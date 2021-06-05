package edu.glsia.devmobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import edu.glsia.devmobile1.database.DatabaseHelper;
import edu.glsia.devmobile1.models.Matiere;
import edu.glsia.devmobile1.models.MesMatieres;
import edu.glsia.devmobile1.repository.MatiereRepository;

public class MatiereActivity extends AppCompatActivity {

    private Button btnAjouter, btnRechercher;
    private EditText id,libelle;
    private Spinner spEnseignant, spImage;
    private RadioGroup rgType;
    Boolean isObligatoire = false;
    Boolean isId = false;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere);
        databaseHelper = new DatabaseHelper(this);

        initViews();
    }

    void initViews(){
        btnAjouter = findViewById(R.id.btnAjouter);
        btnRechercher = findViewById(R.id.btnRechercher);
        id = findViewById(R.id.valId);
        libelle = findViewById(R.id.valLibelle);
        spEnseignant = findViewById(R.id.spEnseignant);
        spImage = findViewById(R.id.spImage);
        rgType = findViewById(R.id.rgType);
    }

    private void ajouterMatiere(int mId, String mLibelle, String mEnseignant, int mImage, Boolean mType) {

        Matiere matiere;//= new Matiere();

        matiere = rechercherMatiere(mId); //verifie si la matiere existe deja ou pas

        if (matiere != null) {
            Toast.makeText(getApplicationContext(), "Cet id est deja pris", Toast.LENGTH_LONG).show();
        }else{
            matiere = new Matiere();
            matiere.setId(mId);
            matiere.setLibelle(mLibelle);
            matiere .setEnseignant(mEnseignant);
            matiere.setImage(mImage);
            matiere.setType(mType);

            //MesMatieres.matiereList.add(matiere);
            MatiereRepository matiereRepository = new MatiereRepository();
            if(matiereRepository.save(databaseHelper.getDatabase(), matiere)){
                Toast.makeText(getApplicationContext(), R.string.success_message, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), R.string.error_message2, Toast.LENGTH_LONG).show();
            }
        }

    }

    private Matiere rechercherMatiere(int id){
         //Matiere matiere = null;
        for (Matiere n : MesMatieres.matiereList) {
            if (id == n.getId()) {
                return n;
//                matiere = new Matiere();
//                matiere.setId(n.getId());
//                matiere.setLibelle(n.getLibelle());
//                matiere.setEnseignant(n.getEnseignant());
//                matiere.setImage(n.getImage());
//                matiere.setType(n.isType());
            }
        }
        return null;
    }

    //verifie si l'id est renseigne
    Boolean verifId(String vId){
        if(vId.length() == 0){
            Toast.makeText(getApplicationContext(), "Veuillez renseigner l'id", Toast.LENGTH_LONG).show();
            isId = true;
        }
        return  isId;
    }

    @Override
    protected void onResume() {
        super.onResume();


        //ecoute du radiogroup
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case -1:
                        //type = null;
                        Log.i("msg","choise cleared");
                        break;
                    case R.id.rbFacultative:
                        isObligatoire = false;
                        Log.i("msg","false");
                        break;
                    case R.id.rbObligatoire:
                        isObligatoire = true;
                        Log.i("msg","true");
                        break;
                }
            }
        });

        //ecoute de la selection de l'image
        spImage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ecoute de la selection d'un enseigant
        spEnseignant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ecoute du bouton rechercher
        btnRechercher.setOnClickListener(v -> {

        });
        btnRechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matiere matiere;
                int rId = Integer.parseInt(String.valueOf(id.getText().toString()));
                matiere = rechercherMatiere(rId);

                if(matiere != null){
                    Intent rech = new Intent(MatiereActivity.this, DetailMatiere.class);
                    rech.putExtra("edu.glsia.devmobile1.models.Matiere", matiere);
                    startActivity(rech);
                }else{
                    Toast.makeText(getApplicationContext(), R.string.error_message, Toast.LENGTH_LONG).show();                }
                }
        });

        //ecoute du bouton ajouter
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mId = Integer.parseInt(String.valueOf(id.getText().toString()));
                String mLibelle = libelle.getText().toString();
                String mEnseignant = spEnseignant.getSelectedItem().toString();
                int mImage = 1;//Integer.parseInt(spImage.getSelectedItem().toString());

                Boolean res = verifId(id.getText().toString());

               // if(res == false)
                    ajouterMatiere(mId, mLibelle, mEnseignant, mImage, isObligatoire);
            }
        });
    }


}
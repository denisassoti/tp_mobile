package edu.glsia.devmobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import edu.glsia.devmobile1.models.Matiere;

public class DetailMatiere extends AppCompatActivity {

    private TextView id, libelle, enseignant, type;
    private ImageView image;
    Bundle extras;
    Matiere matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_matiere);

        initViews();

        matiere = extras.getParcelable("edu.glsia.devmobile1.models.Matiere");
        id.setText(String.valueOf(matiere.getId()));
        libelle.setText(matiere.getLibelle());
        enseignant.setText(matiere.getEnseignant());
        if(matiere.isType() == false){
            type.setText("Facultative");
        }else if(matiere.isType() == true){
            type.setText("Obligatoire");
        }
        String variableName = matiere.getImage();
        //image.setImageResource(R.drawable.variableName);
        //Log.i("image",matiere.getEnseignant());
        image.setImageResource(getResources().getIdentifier(variableName, "drawable", getPackageName()));
    }

    void initViews(){
        extras  = getIntent().getExtras();
        id = findViewById(R.id.rId);
        libelle = findViewById(R.id.rLibelle);
        enseignant = findViewById(R.id.rEnseignant);
        type = findViewById(R.id.rType);
        image = findViewById(R.id.rImage);
    }
}
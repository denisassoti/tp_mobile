package edu.glsia.devmobile1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.glsia.devmobile1.models.Matiere;

public class MainActivity extends AppCompatActivity {

    private Button btnpuissance;
    private Button btnMatiere, btnMenu;
    private EditText valMag;
    private Button btnSauv, btnListMatiere;
//    private static  String SHARED_FIC = 'fic_shared';


    //objet matiere
    Matiere matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//specifier l'interface user
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        registerForContextMenu(btnMenu);//ecouter le boutton menu

    }

    void initView(){
        //initialisations
        btnpuissance = findViewById(R.id.btnMenuPuissance);
        btnMatiere = findViewById(R.id.btnMatiere);
        btnMenu = findViewById(R.id.btnMenu);
        valMag = findViewById(R.id.valMag);
        btnSauv = findViewById(R.id.btnSauvegarder);
        btnListMatiere = findViewById(R.id.btnListMatiere);

    }

    // menu contextuel
    private  final static int MENU_AJOUTER = Menu.FIRST;
    private  final static int MENU_SUPPRIMER = Menu.FIRST + 1;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, MENU_AJOUTER, Menu.NONE, "Ajouter un élément");
        menu.add(Menu.NONE, MENU_SUPPRIMER, Menu.NONE, "Supprimer un élément");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case MENU_AJOUTER:
                Toast.makeText(getApplicationContext(), "Menu ajouter", Toast.LENGTH_LONG).show();
            case MENU_SUPPRIMER:
                Toast.makeText(getApplicationContext(), "Menu supprimer", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnpuissance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                matiere = new Matiere();
                matiere.setId(1);
                matiere.setLibelle("matiere 1");
                Intent puis = new Intent(MainActivity.this,PuissanceActivity.class);
                puis.putExtra("valA",15);
                puis.putExtra("edu.glsia.devmobile1.models.Matiere",matiere);
                startActivity(puis);

            }
        });

        btnMatiere.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mat = new Intent(MainActivity.this, MatiereActivity.class);
                startActivity(mat);
            }
        });
        btnListMatiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent list = new Intent(MainActivity.this, ListMatiere.class);
                startActivity(list);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        //enregistrement de valMag dans Shared preferenced
        btnSauv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("fic_shared", MODE_PRIVATE);
                if(!valMag.getText().toString().isEmpty()) {
                    int mag = Integer.parseInt(valMag.getText().toString());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("nMagique", mag);
                    editor.commit();
                }
            }
        });

        // recuperation de valMag dans les SharedPreferences
        SharedPreferences mesPrefs = getSharedPreferences("fic_shared",MODE_PRIVATE);
        int nbreMagique = mesPrefs.getInt("nMagique",0);
        valMag.setText(String.valueOf(nbreMagique));

//        btnSauvegarder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
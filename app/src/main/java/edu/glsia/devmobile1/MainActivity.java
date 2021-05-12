package edu.glsia.devmobile1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import edu.glsia.devmobile1.models.Matiere;

public class MainActivity extends AppCompatActivity {

    private Button btnpuissance;

    //objet matiere
    Matiere matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//specifier l'interface user
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialisations
        btnpuissance = findViewById(R.id.btnMenuPuissance);

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
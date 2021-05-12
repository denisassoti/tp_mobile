package edu.glsia.devmobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.glsia.devmobile1.models.Matiere;

public class PuissanceActivity extends AppCompatActivity {

    private EditText textA, textN, textResult;
    private Button bCalculer, bEffacer;

    Bundle extras;
    int valA ;
    Matiere matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puissance);

        //initialisation
        extras  = getIntent().getExtras();
        textA = findViewById(R.id.valA);
        textN = findViewById(R.id.valN);
        textResult = findViewById(R.id.valResult);
        bCalculer = findViewById(R.id.btnCalculer);
        bEffacer = findViewById(R.id.btnEffacer);

        valA = new Integer(extras.getInt("valA",0));
        matiere = extras.getParcelable("edu.glsia.devmobile1.models.Matiere");
        Log.i("id",matiere.getId()+"");
        Log.i("libelle",matiere.getLibelle());
        textA.setText(valA+"");
    }

    //fonction de calcul de puissance
    private Long puissance(Long a, Long n){
        Long res = 1L;
        if(n ==0){
            res = 1L;
           return res;
        }else if(n !=0){
            for (int i=0;i<n;i++) {
                res *= a;
            }
           return res;
        }
        return res;
    }


    @Override
    protected void onResume() {
        super.onResume();

        //evenet onClick du btn calculer
        bCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long a = Long.valueOf(textA.getText().toString());
                Long n = Long.valueOf(textN.getText().toString());
                Long res = puissance(a,n);
                textResult.setText(String.valueOf(res));
            }
        });

        //event onClic de effacer
        bEffacer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textA.setText("");
                textN.setText("");
                textResult.setText("");
            }
        });
    }
}
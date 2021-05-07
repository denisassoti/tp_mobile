package edu.glsia.devmobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CalculPuissance extends AppCompatActivity implements View.OnClickListener {
    private Button btnCalculer;
    private TextInputEditText a;
    private TextInputEditText n;
    private TextInputEditText result;
    private Button btnAnnuler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_puissance);
        initViews();
        btnCalculer.setOnClickListener(this);
        btnAnnuler.setOnClickListener(this);
//        result.setText("jhhg");
    }

    private void initViews(){
        btnCalculer = findViewById(R.id.btnCalculer);
        btnAnnuler = findViewById(R.id.btnAnnuler);
        a = findViewById(R.id.a);
        n = findViewById(R.id.n);
        result = findViewById(R.id.result);
    }

    @Override
    public void onClick(View v) {
        initViews();
        int res = 1;
        result.setText("");
        if(v == btnCalculer){
            if(Integer.parseInt(n.getText().toString()) ==0){
                result.setText(1+"");
            }else if(Integer.parseInt(n.getText().toString()) !=0){
                for (int i=0;i<Integer.parseInt(n.getText().toString());i++) {
                    res *= Integer.parseInt(a.getText().toString());
                }

                result.setText(res+"");
            }

        }
        if(v == btnAnnuler){
            a.setText("");
            n.setText("");
            result.setText("");
        }
    }


//    @Override
//    protected void onResume() {
//        initViews();
//    }
}
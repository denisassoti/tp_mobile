package edu.glsia.devmobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.glsia.devmobile1.adapter.MatiereAdapter;
import edu.glsia.devmobile1.database.DatabaseHelper;
import edu.glsia.devmobile1.models.Matiere;
import edu.glsia.devmobile1.repository.MatiereRepository;

public class ListMatiere extends AppCompatActivity {

    private MatiereAdapter matiereAdapter;
    private ListView listView;
    private List<Matiere> listmatieres;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_matiere);
        Log.e("nb mat", "Bonjour");
        databaseHelper = new DatabaseHelper(this);

        initData();
        initViews();
    }

    void initViews(){

        matiereAdapter = new MatiereAdapter(this,listmatieres);
        listView = this.findViewById(R.id.matiereListView);
        listView.setAdapter(matiereAdapter);
        matiereAdapter.notifyDataSetChanged();//actualisation automatique
        Log.e("VAL1",listView.getAdapter().getItem(0).toString());

    }

    //remplier une liste de matiere dans une liste view
    private   void initData(){
        List<Matiere>  matiereList;
//        matiereList.add(new Matiere(1,"Bd Libre","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(2,"Bd Distribue","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(3,"NoSql","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(4,"Adroid mobile","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(5,"Bd Libre","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(1,"Bd Libre","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(2,"Bd Distribue","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(3,"NoSql","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(4,"Adroid mobile","M. AMEVOR",R.drawable.android,true));
//        matiereList.add(new Matiere(5,"Bd Libre","M. AMEVOR",R.drawable.android,true));

        listmatieres=new ArrayList<>();
        MatiereRepository matiereRepository = new MatiereRepository();
        matiereList = matiereRepository.findAll(databaseHelper.getDatabase());
        listmatieres.addAll(matiereList);


    }
}
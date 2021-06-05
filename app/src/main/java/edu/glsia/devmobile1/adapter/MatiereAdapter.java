package edu.glsia.devmobile1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.glsia.devmobile1.R;
import edu.glsia.devmobile1.models.Matiere;

public class MatiereAdapter extends BaseAdapter {

    private Context context;
    // activite dans laquelle on appelle l'adapter puisque COntext est la classe mere des Activity
    // donc des activity generique
    private List<Matiere> matiereList;

    public MatiereAdapter() {
    }

    public MatiereAdapter(Context context, List<Matiere> matiereList) {
        this.context = context;
        this.matiereList = matiereList;
    }

    @Override
    public int getCount() {
        return matiereList.size(); //nombre d'elements dans la liste
    }

    @Override // recupere un objet a une position precise
    public Matiere getItem(int position) {
        return matiereList.get(position);
    }

    @Override //recupere l'id de l'objet qui se trouve a telle position
    public long getItemId(int position) {
        //return matiereList.get(position).getId();
        return ((Matiere) getItem(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView =  LayoutInflater.from(context).inflate(R.layout.activity_matiere_list_item,null); // recup du fichier xml de l'item

        //affectation des champs de la vue aux att de la class car getView attend un objet comme tag
       MatierHolder matierHolder = new MatierHolder();
       matierHolder.enseignant  = convertView.findViewById(R.id.edEnseignant);
       matierHolder.libelle = convertView.findViewById(R.id.edLibelle);
       matierHolder.type = convertView.findViewById(R.id.edType);
       matierHolder.image = convertView.findViewById(R.id.edImage);

       matierHolder.enseignant.setText((getItem(position)).getEnseignant());
       matierHolder.libelle.setText((getItem(position)).getLibelle());
       matierHolder.type.setText((getItem(position)).isType() ? "Obligatoire" : "Facultative");
       //matierHolder.image.setImageResource((getItem(position)).getImage());

       convertView.setTag(matierHolder);
        return convertView;
    }


    class  MatierHolder{
        private TextView libelle, enseignant, type;
        private ImageView image;
    }
}



package com.example.cornuluc_patisserie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rec_adapter extends RecyclerView.Adapter<rec_adapter.ViewHolder> {
    private ArrayList<Patisserie> patisserieList;

    //Le viewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Y declarer les objets de la vue qui seront chargés (par le tableau de données)
        public TextView mTextView;
        public TextView description;
        public ImageView image;
        //Constructeur du holder : le viewHolder a une reference vers tous les objets de la liste
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textview_List_Title);
            description = (TextView) v.findViewById(R.id.textview_List_Description);
            image = (ImageView) v.findViewById(R.id.img_List);
        }
    }

    //Constructeur de l'adaptateur : initialisations de l’adapter et des données
    public rec_adapter(ArrayList<Patisserie> patisserieList) {
        this.patisserieList = patisserieList;
    }

    //Chargement du layout et initialisation du viewHolder
    @Override
    public rec_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.canvas_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Lien entre viewHolder et données
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Patisserie planetes = patisserieList.get(position);
        holder.mTextView.setText(planetes.getPatisserieName());
        holder.description.setText(planetes.getPatisserieDescription());
        holder.image.setImageResource(planetes.getPatisserieId());
    }

    //Nombre d’éléments de la liste
    @Override
    public int getItemCount() {
        return patisserieList.size();
    }
}//Fin de la classe de l’adaptateur
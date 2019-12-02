package com.openclassrooms.entrevoisins.ui.neighbour_detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;


public class DetailNeighbourFragment extends Fragment {


    protected ImageView Avatar;
    protected ImageButton Favorite;
    protected TextView Name;
    protected TextView Adresse;
    protected TextView Mail;
    protected TextView Phone;
    protected TextView Description;
    protected TextView DescriptionTitle;
    protected TextView WhiteName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_neighbour, container, false);

        this.Avatar = view.findViewById(R.id.Avatar);
        this.Favorite = view.findViewById(R.id.Favorite);
        this.Name = view.findViewById(R.id.Name);
        this.Mail = view.findViewById(R.id.Mail);
        this.Phone = view.findViewById(R.id.Phone);
        this.Description = view.findViewById(R.id.Description);
        this.Adresse = view.findViewById(R.id.Adresse);
        this.DescriptionTitle = view.findViewById(R.id.DescriptionTitle);
        this.WhiteName = view.findViewById(R.id.WhiteName);


        Name.setTypeface(null, Typeface.BOLD);
        DescriptionTitle.setTypeface(null,Typeface.BOLD);
        Name.setTextSize(20);
        DescriptionTitle.setTextSize(20);
        WhiteName.setTextSize(30);
        Description.setGravity(Gravity.CENTER_VERTICAL);
        WhiteName.setTextColor(Color.WHITE);


        return view; // vue créée

    }

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       Intent intent = getActivity().getIntent();
       if( intent != null){
        Neighbour neighbour = (Neighbour) intent.getSerializableExtra("Neigh");
        Name.setText(neighbour.getName());
        WhiteName.setText(neighbour.getName());
        Description.setText("Bonjour ! Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! j'aime les jeux de cartes tels que la belote et le tarot.");
        Phone.setText("0606060606");
        Mail.setText("blabla@gmail.com");
        Adresse.setText("8 rue des champs");
        DescriptionTitle.setText("A Propos de moi");




           Favorite.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                   DI.getNeighbourApiService().changeFavoriteNeighbour(neighbour.getId());

                   neighbour.setFavorite(! neighbour.getIsFavorite());

                   if (neighbour.getIsFavorite()) {
                       Favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_yellow_24dp));
                   } else {
                       Favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white));
                   }


               }
           });


           RequestOptions options = new RequestOptions()
                   .centerCrop()
                   .placeholder(R.mipmap.ic_launcher_round)
                   .error(R.mipmap.ic_launcher_round);
           Glide.with(this).load(neighbour.getAvatarUrl()).apply(options).into(Avatar);
// comm

       }
    }
    }









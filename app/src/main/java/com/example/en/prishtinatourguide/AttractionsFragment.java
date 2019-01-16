package com.example.en.prishtinatourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        //Create a list to save places inside.
        ArrayList<Place> attractions = new ArrayList<Place>();

        //Create the places. In this case, attractions
        attractions.add(new Place(getResources().getString(R.string.attraction_one), R.drawable.sheshi_nene_teresa, 42.66246
                , 21.163154));
        attractions.add(new Place(getResources().getString(R.string.attraction_two), R.drawable.zahir_pajaziti, 42.659972
                , 21.160905));
        attractions.add(new Place(getResources().getString(R.string.attraction_three), R.drawable.kosovo_pristina_clock_tower, 42.66672
                , 21.167105));
        attractions.add(new Place(getResources().getString(R.string.attraction_four), R.drawable.government, 42.665112,
                21.164309));
        attractions.add(new Place(getResources().getString(R.string.attraction_five), R.drawable.katedralja, 42.660711, 21.158326));
        attractions.add(new Place(getResources().getString(R.string.attraction_six), R.drawable.sulltan_murat_tomb, 42.656307,21.159394));
        attractions.add(new Place(getResources().getString(R.string.attraction_seven), R.drawable.new_born, 42.701949, 21.104486));

        //Create an adapter that populates the list
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), attractions, R.color.colorAttractions);

        //Create an object to refer to the list view.
        //Find the {@link ListView} object in the view hierarchy of the {@link AttractionsActivity}.
        ListView listOfAttractions = (ListView) rootView.findViewById(R.id.list_view);

        //Link the list to the adapter. This adapter is a PlaceAdapter, which is an ArrayAdapter, which in turn is a ListAdapter
        listOfAttractions.setAdapter(placeAdapter);


        return rootView;
    }

}

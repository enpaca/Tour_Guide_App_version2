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
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.list_of_places, container, false);

        ArrayList<Place> parks = new ArrayList<Place>();

        parks.add(new Place(getResources().getString(R.string.parks_one), R.drawable.germia_park, 42.669316,21.229035));
        parks.add(new Place(getResources().getString(R.string.parks_two), R.drawable.park_taukbahqe , 42.664861,21.181320));
        parks.add(new Place(getResources().getString(R.string.parks_three), R.drawable.city_park, 42.661251,21.169704));


        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), parks, R.color.colorParks);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(placeAdapter);
        return rootView;
    }

}

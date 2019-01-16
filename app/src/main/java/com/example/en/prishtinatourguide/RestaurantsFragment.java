package com.example.en.prishtinatourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        //Create an array list of restaurants:
        ArrayList<Place> restaurants = new ArrayList<Place>();
        //Fill the list with restaurants.
        restaurants.add(new Place(getResources().getString(R.string.restaurants_one), "+377 44 245 333",
                "8:00AM - 12:00AM", 42.661336
                , 21.163897));
        restaurants.add(new Place(getResources().getString(R.string.restaurants_two), "+383 44 188 000",
                "7:30 PM – 9:30 PM", 42.660776, 21.162245));
        restaurants.add(new Place(getResources().getString(R.string.restaurants_three), "+377 44 785 411",
                "9:30 PM – 11:00 PM", 42.653182, 21.167170));
        restaurants.add(new Place(getResources().getString(R.string.restaurants_four), "+383 45 999 957",
                "8:00 PM – 12:00 PM", 42.661561, 21.161865));
        restaurants.add(new Place(getResources().getString(R.string.restaurants_five), "045 33 22 66",
                "07:30 AM - 00:00 AM", 42.65611, 21.17158));
        restaurants.add(new Place(getResources().getString(R.string.restaurants_six), "+386 49 338 899",
                "07:00 AM - 11:00 PM", 42.662491, 21.160798));
        restaurants.add(new Place(getResources().getString(R.string.restaurants_seven), "+377 44 360 094",
                "07:30 AM - 00:00 AM", 42.659995, 21.160340));

        //Create an adapter that populates the list
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), restaurants,R.color.colorRestaurants);

        //Create an object to refer to the list view.
        //Find the {@link ListView} object in the view hierarchy of the {@link RestaurantsActivityActivity}.
        ListView listOfAttractions = (ListView) rootView.findViewById(R.id.list_view);

        //Link the list to the adapter. This adapter is a PlaceAdapter, which is an ArrayAdapter, which in turn is a ListAdapter
        listOfAttractions.setAdapter(placeAdapter);

        return rootView;
    }

}

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
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

//        Create a  array list of shopping malls:
        ArrayList<Place> shoppingMalls = new ArrayList<>();

//        Populate the array list with shopping shopping malls
        shoppingMalls.add(new Place(getResources().getString(R.string.shopping_one), "+381 38 24464484", "10:00 AM – 10:00 PM",42.632885,21.152471
        ));
        shoppingMalls.add(new Place(getResources().getString(R.string.shopping_two),"+381 38 602166","08:00 AM - 11:00 PM",42.627439,21.148200));
        shoppingMalls.add(new Place(getResources().getString(R.string.shopping_three),"+386 43 900 009","8:00 AM – 10:30 PM",42.654004,21.177396 ));
        shoppingMalls.add(new Place(getResources().getString(R.string.shopping_four),"+386 49 481 800","9:00 AM – 10:00 PM", 42.640777,21.111155));
        shoppingMalls.add(new Place(getResources().getString(R.string.shopping_five), "","8:00 AM – 11:00 PM",42.648301,21.124712));
        shoppingMalls.add(new Place(getResources().getString(R.string.shopping_six),"+383 46 160113","Open 24 hours",42.641189,21.110321 ));
        shoppingMalls.add(new Place(getResources().getString(R.string.shopping_seven),"+377 45 434 448","9:00 AM – 10:00 PM",42.641448,21.111794 ));

        //Create a reference to the list view ( which is an adapter view) which is inside the list_of_places.xml
        ListView listOfShoppingMalls = (ListView) rootView.findViewById(R.id.list_view);

        //Create an adapter that is needed by the ListView, in this case listOfShoppingMalls
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), shoppingMalls, R.color.colorShopping);

        //link the adapter to the list
        listOfShoppingMalls.setAdapter(placeAdapter);


        return rootView;
    }

}

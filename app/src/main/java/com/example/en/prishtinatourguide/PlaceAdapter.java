package com.example.en.prishtinatourguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private int mBackgroundColor;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int backgroundColor) {
        super(context, 0, places);
        this.mBackgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if the existing view is being used, if not create/inflate a new view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_in_list_of_places, parent, false);
        }
        //Get the {@link Place} object located at this position in the list
        final Place currentPlace = getItem(position);

        //Set image to the image view in the layout.
        //Find the {@link ImageView} object in the view hierarchy of listItemView
        ImageView image = (ImageView) listItemView.findViewById(R.id.items_image);
        if (currentPlace.hasImage()) {
            image.setImageResource(currentPlace.getImageResourceID());
            image.setVisibility(View.VISIBLE);
        } else {
            //if there is no image associated with the {@link Place} object than remove the ImageView
            // from the view hierarchy of listItemView
            image.setVisibility(View.GONE);
        }

        //Set texts in the text views of the layout
        //Find the {@link TextView} object in the view hierarchy of listItemView
        TextView nameText = (TextView) listItemView.findViewById(R.id.items_name_text);
        nameText.setText(currentPlace.getName());

        TextView geoText = (TextView) listItemView.findViewById(R.id.items_lat_and_long_text);
        geoText.setText(currentPlace.getLocation());


        TextView secondText = (TextView) listItemView.findViewById(R.id.items_contact_text);
        if (currentPlace.hasPhoneNumber() && currentPlace.hasWorkingHours()) {
            secondText.setText(currentPlace.getPhoneNumber());
            secondText.append("\n" + currentPlace.getWorkingHours());
            secondText.setVisibility(View.VISIBLE);
        } else if (currentPlace.hasPhoneNumber()) {
            secondText.setText("\n"+currentPlace.getPhoneNumber());
            secondText.setVisibility(View.VISIBLE);
        } else if (currentPlace.hasWorkingHours()) {
            secondText.setText("\n"+currentPlace.getWorkingHours());
            secondText.setVisibility(View.VISIBLE);
        } else {
            secondText.setVisibility(View.GONE);
        }


        //set the background/theme color of the view:
        //Locate the container, of the text views, which background we want to set.
        View textContainer = listItemView.findViewById(R.id.container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);

        //Experiment with white background. Note: text color should be changed in item_in_list_of_places.xml.
        color = ContextCompat.getColor(getContext(), R.color.colorBackground);

        //Set the background for the text container view
        textContainer.setBackgroundColor(color);



        return listItemView;
    }
}

package in.paperwrk.tourguideapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import in.paperwrk.tourguideapp.R;

public class GridAdapter extends ArrayAdapter<Restaurants> {

    public GridAdapter(@NonNull Context context, ArrayList<Restaurants> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.restaurant_row,parent,false);
        }
        Restaurants restaurants = getItem(position);
        assert restaurants != null;

        //ImageView imageView = view.findViewById(R.id.rest_image);
        //Picasso.get().load(restaurants.getThumbnail()).into(imageView);

        TextView restName = view.findViewById(R.id.restaurant_title);
        restName.setText(restaurants.getRestaurantName());

        return view;
    }
}

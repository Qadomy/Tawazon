package com.blue.tawazon.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blue.tawazon.Classes.ProfileItems;
import com.blue.tawazon.R;

import java.util.ArrayList;

public class ProfileItemAdapter extends ArrayAdapter<ProfileItems> {

    public ProfileItemAdapter(Activity context, ArrayList<ProfileItems> profileItems) {
        super(context, 0, profileItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout_pofile_button_items, parent, false);
        }

        ProfileItems currentProfileItems = getItem(position);

        // init

        TextView titleTextView = listItemView.findViewById(R.id.titleTextView);
        titleTextView.setText(currentProfileItems.getmItemTitle());

        TextView descriptionTextView = listItemView.findViewById(R.id.descriptionTextView2);
        descriptionTextView.setText(currentProfileItems.getmItemDescription());

        ImageView imageView = listItemView.findViewById(R.id.itemImageView);
        imageView.setImageResource(currentProfileItems.getmImageResourceId());

        ImageView iconView = listItemView.findViewById(R.id.iconImageView);
        iconView.setImageResource(currentProfileItems.getmIconArrowID());

        // todo: here when click on arrow icon
        iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();
            }
        });

        return listItemView;
    }
}

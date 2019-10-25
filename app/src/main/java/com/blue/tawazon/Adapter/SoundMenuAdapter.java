package com.blue.tawazon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.blue.tawazon.Classes.SoundItem;
import com.blue.tawazon.R;

import java.util.ArrayList;

public class SoundMenuAdapter extends RecyclerView.Adapter<SoundMenuAdapter.ViewHolder> {

    private ArrayList<SoundItem> soundItems = new ArrayList<>();
    private Context mContext;

    public SoundMenuAdapter(ArrayList<SoundItem> soundItems, Context mContext) {
        this.soundItems = soundItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.layout_sound_item, viewGroup, false);

        return new SoundMenuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {


        viewHolder.itemDesc.setText(soundItems.get(position).getItemDesc());
        viewHolder.itemImage.setImageResource(soundItems.get(position).getImageID());


//        // when click on card view of offer we open prompt to delete the offer
//        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return soundItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView itemDesc;
        ImageView itemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.soundItemCardView);
            itemDesc = itemView.findViewById(R.id.soundItemTextView);
            itemImage = itemView.findViewById(R.id.soundItemImageView);

        }
    }
}

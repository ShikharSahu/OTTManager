package com.example.ottmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.text.MessageFormat;
import java.util.ArrayList;


public class CardRecyclerView extends RecyclerView.Adapter<CardRecyclerView.ViewHolder> {

    private ArrayList<Subscription> localDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //private final TextView textView;

        private TextView nameTvCard, costTvCard, expiryTvCard;
        private ShapeableImageView logoSpImgVCard;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            nameTvCard = view.findViewById(R.id.ottNameCard);
            costTvCard = view.findViewById(R.id.ottCostCard);
            expiryTvCard = view.findViewById(R.id.ottNextPaymentCard);
            logoSpImgVCard = view.findViewById(R.id.ottLogoCard);
            //textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getNameTvCard() {
            return nameTvCard;
        }

        public TextView getCostTvCard() {
            return costTvCard;
        }

        public TextView getExpiryTvCard() {
            return expiryTvCard;
        }

        public ShapeableImageView getLogoSpImgVCard() {
            return logoSpImgVCard;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CardRecyclerView(ArrayList<Subscription> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_sample, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Subscription currentSub = localDataSet.get(position);
        viewHolder.getNameTvCard().setText(currentSub.ottName);
        viewHolder.getCostTvCard().setText(MessageFormat.format("Rs {0} /month", currentSub.cost));
//        viewHolder.getT
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

package com.kalelman.listurlconnection.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kalelman.listurlconnection.R;
import com.kalelman.listurlconnection.model.ModelWarDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private List<ModelWarDetail> warDetailList;

    public RecyclerViewAdapter(List<ModelWarDetail> warDetailList) {
        this.warDetailList = warDetailList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.txtName.setText(warDetailList.get(position).getName());
        viewHolder.txtLocation.setText(warDetailList.get(position).getLocation());
        viewHolder.txtAttackerKing.setText(warDetailList.get(position).getAttackerKing());
        viewHolder.txtDefenderKing.setText(warDetailList.get(position).getDefenderKing());

    }

    @Override
    public int getItemCount() {
        return warDetailList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtLocation)
        TextView txtLocation;
        @BindView(R.id.txtAttackerKing)
        TextView txtAttackerKing;
        @BindView(R.id.txtDefenderKing)
        TextView txtDefenderKing;
        @BindView(R.id.layoutCard)
        CardView layoutCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

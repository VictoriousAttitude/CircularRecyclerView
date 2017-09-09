package com.example.dmitriy.customrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dmitriy on 29.04.17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ItemsHolder> {

    private ArrayList<Info> data;
    private Context ctx;
    private ItemsHolder itemsHolder;

    public Adapter(Context ctx, ArrayList<Info> data) {
        this.data = data;
        this.ctx = ctx;
    }

    @Override
    public ItemsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);

        itemsHolder = new ItemsHolder(view);

        return itemsHolder;
    }

    @Override
    public void onBindViewHolder(ItemsHolder holder, int position) {

        Info info = data.get(position);

        holder.name.setText(info.getTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ItemsHolder extends RecyclerView.ViewHolder{

        public TextView name;

        public ItemsHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.time);
        }
    }
}

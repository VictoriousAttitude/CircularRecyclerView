package com.example.dmitriy.customrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dmitriy on 29.04.17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ItemsHolder> {

    private ArrayList<Info> data;
    private Context ctx;

    private float deviceWidth;

    public Adapter(Context ctx, ArrayList<Info> data) {
        this.data = data;
        this.ctx = ctx;
    }

    @Override
    public ItemsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        if (windowManager != null)
              windowManager.getDefaultDisplay().getMetrics(context.getResources().getDisplayMetrics());

        deviceWidth = context.getResources().getDisplayMetrics().widthPixels;
        view.getLayoutParams().width = ((int) deviceWidth) / 5;

        return new ItemsHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemsHolder holder, int position) {
        Info info = data.get(position);
        holder.getName().setText(info.getTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ItemsHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ItemsHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.time);
        }

        public TextView getName() {
            return name;
        }
    }
}

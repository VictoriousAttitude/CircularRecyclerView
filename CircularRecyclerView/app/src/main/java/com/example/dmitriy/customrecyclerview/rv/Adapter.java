package com.example.dmitriy.customrecyclerview.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.dmitriy.customrecyclerview.R;
import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedList;

/**
 * Created by dmitriy on 29.04.17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ItemsHolder> {

    private CircularLinkedList circularLinkedList;

    public Adapter(CircularLinkedList circularLinkedList) {
        this.circularLinkedList = circularLinkedList;
    }

    @Override
    public ItemsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        if (windowManager != null)
              windowManager.getDefaultDisplay().getMetrics(context.getResources().getDisplayMetrics());

        float deviceWidth = context.getResources().getDisplayMetrics().widthPixels;
        view.getLayoutParams().width = ((int) deviceWidth) / 5;

        return new ItemsHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemsHolder holder, int position) {
        String timeData = circularLinkedList.get(position % circularLinkedList.getSize());
        holder.setTime(timeData);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class ItemsHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public ItemsHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.time_text);
        }

        public void setTime(String name) {
           tv.setText(name);
        }
    }


}

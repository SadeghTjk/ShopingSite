package com.shadow.shopingsite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myholder> {
    Context c;
    List<Product> product = new ArrayList<>();

    public CustomAdapter(Context c, List<Product> product) {
        this.c = c;
        this.product = product;
    }

    @NonNull
    @Override
    public CustomAdapter.myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.list,null);
        return new myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.myholder myholder, int i) {
        myholder.pname.setText(product.get(i).getProductName());
        myholder.price.setText(""+product.get(i).getProductPrice());
      //  myholder.checkBox.setChecked(product.get(i).getProductChecked());

    }

    @Override
    public int getItemCount() {
        return product.size();
    }

    public class myholder extends RecyclerView.ViewHolder{
        public TextView pname, price;
        public CheckBox checkBox;

        public myholder(View itemView) {
            super(itemView);

            pname = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
}}



package com.example.ok.retrofitt.Adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ok.retrofitt.MOdel.ArticlesItem;
import com.example.ok.retrofitt.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ok on 11/12/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.hoderimg> {

    Context mcontext;
    ArrayList<ArticlesItem> articlesItems;

    public Adapter(Context mcontext, ArrayList<ArticlesItem> articlesItems) {
        this.mcontext = mcontext;
        this.articlesItems = articlesItems;
    }


    @Override
    public hoderimg onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item,parent,false);

        return new hoderimg(view);
    }

    @Override
    public void onBindViewHolder(hoderimg holder, int position) {
        int width = (int) mcontext.getResources().getDimension(R.dimen.image_width);

        ArticlesItem items =articlesItems.get(position);

        holder.tex.setText(items.getTitle());

        Picasso.with(mcontext).load(items.getUrlToImage())
                .resize(width,width)
                .into(holder.img);






    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    class hoderimg extends RecyclerView.ViewHolder{
        ImageView img ;
        TextView tex;


        public hoderimg(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img);
        tex = (TextView) itemView.findViewById(R.id.Imgtitle);



        }
    }
}

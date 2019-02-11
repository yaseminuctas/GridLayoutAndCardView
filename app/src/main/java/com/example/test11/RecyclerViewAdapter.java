package com.example.test11;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Yemek> adapterData;
    LayoutInflater inflater;
    private RecyclerItemClickListener listener;


    public RecyclerViewAdapter(List<Yemek> adapterData, Context context) {

        inflater = LayoutInflater.from( context );
        this.context = context;
        this.adapterData = adapterData;
        this.listener = listener;
    }


    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d( "YASE", "onCreateViewHolder çağrıldı" );
        View view = inflater.inflate( R.layout.list_item, parent, false );
        MyViewHolder holder = new MyViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d( "YASE", "onBindViewHolder çağrıldı" );
        final Yemek YemekList = adapterData.get( position );
        setData( YemekList, holder );
        holder.imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onImageClicked( YemekList );

            }
        } );

        if (position % 2 == 0) {
            holder.vLine.setBackgroundColor( Color.rgb( 239,119,126 ) );
        } else {
            holder.vLine.setBackgroundColor( Color.rgb( 216,197,171 ));
        }
    }


    public void setData(Yemek YemekList, MyViewHolder holder) {
        holder.textView.setText( (YemekList.getTitle()) );
        holder.textView1.setText( (YemekList.getOwner()) );
        holder.textView2.setText( (YemekList.getReceipe()));
        holder.textView3.setText( (YemekList.getDate()) );
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView1, textView2, textView3;
        ImageButton imageButton;
        ImageView imageView;
        View vLine;


        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            textView = itemView.findViewById( R.id.textView );
            textView1 = itemView.findViewById( R.id.textView1 );
            textView2 = itemView.findViewById( R.id.textView2 );
            textView3 = itemView.findViewById( R.id.textView3 );
            imageButton = itemView.findViewById( R.id.imageButton );
            imageView = itemView.findViewById( R.id.imageView );
            vLine = itemView.findViewById( R.id.v_line );
        }
    }

    public int getItemCount() {
        return adapterData.size();
    }
}



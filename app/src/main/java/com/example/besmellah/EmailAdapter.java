package com.example.besmellah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    private ArrayList<Email>  data;
    private LayoutInflater inflater;


    public EmailAdapter(Context context, ArrayList<Email> data){
        this.data=data;
        this.inflater=LayoutInflater.from(context);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView SenderTextView;
        TextView SubjectTextView;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SenderTextView=itemView.findViewById(R.id.senderInRow);
            SubjectTextView=itemView.findViewById(R.id.subjectInRow);
            img=itemView.findViewById(R.id.img);

        }
    }





    @NonNull
    @Override
    public EmailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.email_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Email email=data.get(position);
        holder.SenderTextView.setText(email.getSender());
        holder.SubjectTextView.setText(email.getSubject());
        Picasso.get().load(email.getImageURL()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

package com.app.instancedownload;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class w_Adapter extends RecyclerView.Adapter<w_Adapter.ViewHolder> {

    Context context;
    ArrayList<w_ModelClass> fileslist;

    public w_Adapter(Context context, ArrayList<w_ModelClass> fileslist) {
        this.context = context;
        this.fileslist = fileslist;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.w_item_layout,null,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final w_ModelClass modelClass=fileslist.get(position);
        if(modelClass.getUri().toString().endsWith(".mp4"))
        {
            holder.play.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.play.setVisibility(View.INVISIBLE);
        }

        Glide.with(context).load(modelClass.getUri()).into(holder.mainstatus);

        holder.mainstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modelClass.getUri().toString().endsWith(".mp4"))
                {
                    final String path=fileslist.get(position).getPath();
                    String destpath= Environment.getExternalStorageDirectory().getAbsolutePath()+ w_Constant.SAVE_FOLDER_NAME;
                    Intent intent=new Intent(context, w_Video.class);
                    intent.putExtra("DEST_PATH_VIDEO",destpath);
                    intent.putExtra("FILE_VIDEO",path);
                    intent.putExtra("FILENAME_VIDEO",modelClass.getFilename());
                    intent.putExtra("URI_VIDEO",modelClass.getUri().toString());
                    context.startActivity(intent);
                }

                else
                {
                    final String path=fileslist.get(position).getPath();
                    String destpath= Environment.getExternalStorageDirectory().getAbsolutePath()+ w_Constant.SAVE_FOLDER_NAME;
                    Intent intent=new Intent(context, w_Picture.class);
                    intent.putExtra("DEST_PATH",destpath);
                    intent.putExtra("FILE",path);
                    intent.putExtra("FILENAME",modelClass.getFilename());
                    intent.putExtra("URI",modelClass.getUri().toString());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fileslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mainstatus,play;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mainstatus=itemView.findViewById(R.id.thumbnailofstatus);
            play=itemView.findViewById(R.id.play);


        }
    }
}

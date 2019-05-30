package com.example.asad.day02zuoye.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asad.day02zuoye.R;
import com.example.asad.day02zuoye.bean.LiShiPersonClass;

import java.util.List;

/**
 * Created by 13768 on 2019/5/30.
 */

public class LittleAdapter extends RecyclerView.Adapter<LittleAdapter.MyViewHolder>{
    private Context context;
    private List<LiShiPersonClass.ResultBean> mlist;

    public LittleAdapter(Context context, List<LiShiPersonClass.ResultBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.littleitem,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LiShiPersonClass.ResultBean resultBean = mlist.get(position);
        holder.tv.setText(resultBean.getTitle());
        if (!resultBean.getPic().isEmpty()) {
            Glide.with(context).load(resultBean.getPic()).into(holder.iv);
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}

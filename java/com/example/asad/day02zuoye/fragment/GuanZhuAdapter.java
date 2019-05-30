package com.example.asad.day02zuoye.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.asad.day02zuoye.R;
import com.example.asad.day02zuoye.bean.LiShiPersonClass;
import com.example.asad.day02zuoye.bean.MeiShiClass;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by 13768 on 2019/5/30.
 */

public class GuanZhuAdapter extends RecyclerView.Adapter {
    private List<MeiShiClass.DataBean> meishilist;
    private List<String> bannerlist;
    private Context context;
    private LittleAdapter littleAdapter;

    public GuanZhuAdapter(List<MeiShiClass.DataBean> meishilist, List<String> bannerlist, Context context, LittleAdapter littleAdapter, List<LiShiPersonClass.ResultBean> littlelist) {
        this.meishilist = meishilist;
        this.bannerlist = bannerlist;
        this.context = context;
        this.littleAdapter = littleAdapter;
        this.littlelist = littlelist;
    }

    private List<LiShiPersonClass.ResultBean> littlelist;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else if (position % 2 == 0 && position > 1) {
            return 3;
        } else if (position % 2 == 1 && position > 1) {
            return 4;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new BannerViewHolder(LayoutInflater.from(context).inflate(R.layout.banneritem,null));
            case 2:
                return new TwoViewHolder(LayoutInflater.from(context).inflate(R.layout.recycleitem,null));
            case 3:
                return new ThreeViewHolder(LayoutInflater.from(context).inflate(R.layout.putongitem,null));
            case 4:
                return new FourViewHolder(LayoutInflater.from(context).inflate(R.layout.putongitemtwo,null));

            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof BannerViewHolder) {
            ((BannerViewHolder) holder).banner.setImages(bannerlist);
            ((BannerViewHolder) holder).banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load((String) path).into(imageView);
                }
            });
            ((BannerViewHolder) holder).banner.start();
        }

        if (holder instanceof TwoViewHolder) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((TwoViewHolder) holder).recyclerView.setLayoutManager(linearLayoutManager);
            if (littleAdapter!=null) {
                ((TwoViewHolder) holder).recyclerView.setAdapter(littleAdapter);
            }
        }

        if (holder instanceof ThreeViewHolder) {
            MeiShiClass.DataBean dataBean = meishilist.get(position);
            ((ThreeViewHolder) holder).textView.setText(dataBean.getTitle());
            if (!dataBean.getPic().isEmpty()) {
                RoundedCorners roundedCorners = new RoundedCorners(15);
                RequestOptions.bitmapTransform(roundedCorners);
                Glide.with(context).load(dataBean.getPic()).into(((ThreeViewHolder) holder).imageView);
            }
        }

        if (holder instanceof FourViewHolder) {
            MeiShiClass.DataBean dataBean = meishilist.get(position);
            ((FourViewHolder) holder).textView.setText(dataBean.getTitle());
            if (!dataBean.getPic().isEmpty()) {
                RoundedCorners roundedCorners = new RoundedCorners(15);
                RequestOptions.bitmapTransform(roundedCorners);
                Glide.with(context).load(dataBean.getPic()).into(((FourViewHolder) holder).imageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return meishilist.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public TwoViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyl);
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ThreeViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    class FourViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public FourViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
}

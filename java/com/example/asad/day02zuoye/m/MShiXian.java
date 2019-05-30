package com.example.asad.day02zuoye.m;

import android.util.Log;

import com.example.asad.day02zuoye.API;
import com.example.asad.day02zuoye.bean.BannerClass;
import com.example.asad.day02zuoye.bean.LiShiPersonClass;
import com.example.asad.day02zuoye.bean.MeiShiClass;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 13768 on 2019/5/30.
 */

public class MShiXian implements MInterFace{
    @Override
    public void getBannerData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API.BANNER_URL)
                .build();
        retrofit.create(API.class).getBannerData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerClass>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerClass bannerClass) {
                        if (bannerClass!=null) {
                            callBack.OnBannerChenGon(bannerClass);
                        }else {
                            callBack.OnBannerShiBai("解析失败");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.OnBannerShiBai(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMeiShiData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API.MEISHI_URL)
                .build();
        retrofit.create(API.class).getMeiShiData("1","20","1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MeiShiClass>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MeiShiClass meiShiClass) {
                        callBack.OnMeiShiChenGon(meiShiClass);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("tag", "onError: "+e.getMessage());
                        callBack.OnMeiShiShiBai(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLiShiData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API.LISHI_URL)
                .build();
        retrofit.create(API.class).getLiShiData("1.0","3","15","8a5f533bc3b94f536c679e93bd38930b")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LiShiPersonClass>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LiShiPersonClass liShiPersonClass) {
                        callBack.OnLiShiChenGon(liShiPersonClass);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.OnLIShiShiBai(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

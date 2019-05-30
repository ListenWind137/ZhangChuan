package com.example.asad.day02zuoye;


import com.example.asad.day02zuoye.bean.BannerClass;
import com.example.asad.day02zuoye.bean.LiShiPersonClass;
import com.example.asad.day02zuoye.bean.MeiShiClass;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 13768 on 2019/5/30.
 */

public interface API {
    String LISHI_URL = "http://api.juheapi.com/japi/";
    String BANNER_URL = "http://www.wanandroid.com/";
    String MEISHI_URL = "http://www.qubaobei.com/ios/";

    @GET("banner/json")
    Observable<BannerClass> getBannerData();

    @GET("cf/dish_list.php?")
    Observable<MeiShiClass> getMeiShiData(@Query("stage_id") String stage_id, @Query("limit") String limit, @Query("page") String page);

    @GET("toh?")
    Observable<LiShiPersonClass> getLiShiData(@Query("v") String v,@Query("month")String month, @Query("day") String day, @Query("key") String key);
}

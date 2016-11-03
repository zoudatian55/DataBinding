package com.example.administrator.databindingdemo.service;

import android.database.Observable;

import com.example.administrator.databindingdemo.bean.FoodBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public interface FoodService {
@GET("api/food/list")
Call<FoodBean> getFoodData(@Query("id") int id);
}

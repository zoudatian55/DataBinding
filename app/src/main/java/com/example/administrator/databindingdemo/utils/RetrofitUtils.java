package com.example.administrator.databindingdemo.utils;

import android.os.Handler;
import android.os.Message;

import com.example.administrator.databindingdemo.bean.FoodBean;
import com.example.administrator.databindingdemo.net.Constants;
import com.example.administrator.databindingdemo.service.FoodService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class RetrofitUtils {
    private static RetrofitUtils instance;
    private final Retrofit foodRetrofit;


    public static RetrofitUtils getInstance(){
        if(instance==null){
            instance=new RetrofitUtils();
        }
         return instance;
    }

    public RetrofitUtils(){
        foodRetrofit=new Retrofit.Builder()
                .baseUrl(Constants.FOOD_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    public Retrofit getRetrofit(){
        return foodRetrofit;
    }
    /**
     * 发送网络请求
     */
    public  static void getFoodData(int id, final Handler handler, final int what){
        FoodService foodService = getInstance().getRetrofit().create(FoodService.class);
        Call<FoodBean> foodBeanCall = foodService.getFoodData(id);
        foodBeanCall.enqueue(new Callback<FoodBean>() {
            @Override
            public void onResponse(Call<FoodBean> call, Response<FoodBean> response) {
                FoodBean foodBean = response.body();
                //通过handler发送消息
                Message message = handler.obtainMessage();
               message.obj= foodBean;
                message.what=what;
                handler.sendMessage(message);
            }

            @Override
            public void onFailure(Call<FoodBean> call, Throwable t) {

            }
        });
    }



}

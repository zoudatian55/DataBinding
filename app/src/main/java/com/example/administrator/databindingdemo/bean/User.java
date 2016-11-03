package com.example.administrator.databindingdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.administrator.databindingdemo.BR;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class User extends BaseObservable{
    private String firstName;
    private String age;
    private String imgUrl;
    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
       notifyPropertyChanged(BR.firstName);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    //从网络上下载图片
  @BindingAdapter("img")
    public  static void getInternetImage(ImageView imageView,String url){
      Picasso.with(imageView.getContext()).load(url).into(imageView);
    }
}

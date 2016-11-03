package com.example.administrator.databindingdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.administrator.databindingdemo.BR;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class Text extends BaseObservable {
    private String content;
    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }
}

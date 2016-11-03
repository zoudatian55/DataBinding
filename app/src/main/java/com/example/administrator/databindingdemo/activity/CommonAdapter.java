package com.example.administrator.databindingdemo.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class CommonAdapter<T> extends BaseAdapter {
    private LayoutInflater inflater;
   private Context context;
    private List<T> list;
    private int layoutId;
    private int variableId;

    public CommonAdapter(Context context,List<T> list,int layoutId,int variableId ){
   this.context=context;
        inflater=LayoutInflater.from(context);
        this.list=list;
        this.layoutId=layoutId;
        this.variableId=variableId;
    }
    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding dataBinding;
       if(convertView==null){
         dataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
       }else{
           dataBinding=DataBindingUtil.getBinding(convertView);
       }

        dataBinding.setVariable(variableId,list.get(position));

        return dataBinding.getRoot();
    }
}

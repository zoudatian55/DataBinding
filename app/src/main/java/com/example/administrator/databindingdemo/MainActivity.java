package com.example.administrator.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.databindingdemo.bean.Text;
import com.example.administrator.databindingdemo.bean.User;
import com.example.administrator.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User user;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
       binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        //通过Biding对象，给xml布局中的ui控件设置具体信息
        user= new User();
        user.setFirstName("zou");
        user.setAge("20");
        binding.setUser(user);
        user.setImgUrl("http://img0.imgtn.bdimg.com/it/" +
                "u=4256573763,278547175&fm=21&gp=0.jpg");
        binding.setMainActivity(this);
        Text text=new Text();
        text.setContent("hahahaha");
        binding.setText(text);

    }
    public void btnClick(View view,String name){
        Log.e("TAG", "btnClick: name is " + name);
        Log.e("TAG", "btnClick: user.name " + user.getFirstName());
        user.setAge("15");
        binding.setUser(user);
    }
    public void startListActivity(View view){
        startActivity(new Intent(MainActivity.this,ListActivity.class));
    }
}

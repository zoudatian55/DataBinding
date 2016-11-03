package com.example.administrator.databindingdemo;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.administrator.databindingdemo.activity.CommonAdapter;
import com.example.administrator.databindingdemo.activity.NetActivity;
import com.example.administrator.databindingdemo.bean.FoodBean;
import com.example.administrator.databindingdemo.utils.RetrofitUtils;

import java.util.List;

import static com.example.administrator.databindingdemo.R.id.listView;

public class ListActivity extends NetActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listview = ((ListView) findViewById(listView));
        //数据源，通过网络请求
         getFoodData();

    }

    private void getFoodData() {
        RetrofitUtils.getFoodData(1,handler,REQUEST_FOOD_DATA);

    }

    @Override
    public void messageReceived(Message msg) {
        FoodBean foodBean = (FoodBean) msg.obj;
        List<FoodBean.TngouBean> tngouBeen = foodBean.getTngou();

        CommonAdapter<FoodBean.TngouBean> adapter = new CommonAdapter<>(ListActivity.this,
                tngouBeen, R.layout.list_item_layout,BR.tngouBean);

      listview.setAdapter(adapter);
    }
}

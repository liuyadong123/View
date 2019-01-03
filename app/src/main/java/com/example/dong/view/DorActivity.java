package com.example.dong.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class DorActivity extends AppCompatActivity {
    private DotView dot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dor);
        dot=findViewById(R.id.dot);
    }
    /**
     * 随机添加点
     * @param view
     */
    public void add(View view) {
        DotBean dotBean =new DotBean();
        dotBean.setX(new Random().nextInt(800));
        dotBean.setY(new Random().nextInt(1500));
        dotBean.setChecked(false);
        dot.add(dotBean);

    }
    /**
     * 清除选重点
     * @param view
     */
    public void clear(View view) {
    }
}

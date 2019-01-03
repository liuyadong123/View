package com.example.dong.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity implements SearchView.SearchViewCallback {
   private  SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search=findViewById(R.id.search);
        search.setSearchViewCallback(this);

    }

    @Override
    public void KeywordEmapy() {
        Toast.makeText(this,"关键词不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onclickListener(View view) {
        this.finish();
    }

    @Override
    public void searchClick(String keywords) {
        String result = keywords;
        //调用p层的请求商品列表的接口
    }
}

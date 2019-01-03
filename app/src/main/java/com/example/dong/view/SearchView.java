package com.example.dong.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchView extends LinearLayout {
    private ImageView backIv;
    private TextView searchTv;
    private EditText editText;
    private int searchColor ;
    private int searchSize;
    public SearchView(Context context) {
        this(context,null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context,attrs);
        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.search_layout,this,true);
//        addView(view);
        backIv = view.findViewById(R.id.back);
        searchTv = view.findViewById(R.id.tv_search);
        editText = view.findViewById(R.id.et_search);
        searchTv.setTextColor(searchColor);
        backIv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchViewCallback!=null){
                    searchViewCallback.onclickListener(v);
                }

            }
        });
        searchTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    if (searchViewCallback != null) {
                        searchViewCallback.KeywordEmapy();
                        return;
                    }
                    if (searchViewCallback!=null){
                        searchViewCallback.searchClick(editText.getText().toString());
                    }

                }
            }
        });
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SearchView);
        searchColor = typedArray.getColor(R.styleable.SearchView_Search_color, Color.RED);
        if (typedArray!=null){
            typedArray.recycle();
        }

    }
    private  SearchViewCallback searchViewCallback;

    public void setSearchViewCallback(SearchViewCallback searchViewCallback) {
        this.searchViewCallback = searchViewCallback;
    }
    interface SearchViewCallback{
        void KeywordEmapy();
        void onclickListener(View view);
        void searchClick(String keywords);
    }
}

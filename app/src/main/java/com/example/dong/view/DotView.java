package com.example.dong.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DotView extends View {
    private List<DotBean> list =new ArrayList<>();
    private Paint paint;
    private Paint checkedPaint;
    private Paint rectPint;
    private Rect rect;
    private  int left,right,top,bottom;
    public DotView(Context context) {
        this(context,null);
    }

    public DotView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        rectPint=new Paint();
        rectPint.setStyle(Paint.Style.STROKE);
        rectPint.setStrokeWidth(10);
        checkedPaint=new Paint();
        checkedPaint.setColor(Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (list!=null){
            for(DotBean dotBean : list){
                if (!dotBean.isChecked()){

                    canvas.drawCircle(dotBean.getX(),dotBean.getY(),20,paint);
                }else {
                    canvas.drawCircle(dotBean.getX(),dotBean.getY(),20,checkedPaint);
                }
            }
        }
        rect =new Rect(left,right,top,bottom);
        canvas.drawRect(rect,rectPint);
    }
    public  void add(DotBean dotBean){
        if (dotBean!=null){
            list.add(dotBean);
            invalidate();

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                left= (int) event.getX();
                top= (int) event.getY();
                invalidate();
                break;
            case  MotionEvent.ACTION_MOVE:
                right= (int) event.getX();
                bottom= (int)event.getY();
                for (DotBean dotBean : list){
                       if (dotBean.getX()>left&&dotBean.getX()<right&&dotBean.getY()>top &&dotBean.getY()<bottom){

                           dotBean.setChecked(true);
                       }else {
                           dotBean.setChecked(false);
                       }
                }
                invalidate();

                break;
            case  MotionEvent.ACTION_UP:
                break;


        }
        return true;
    }
}

package com.example.dong.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private Paint paint;//画笔
    private int circleX;//圆得x轴起始坐标
    private  int circleY;
    private  int mRaduis=100;//圆的半径

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
      private  void init(){
      paint=new Paint();
      paint.setColor(Color.RED);
      paint.setAntiAlias(true);//抗锯齿  使图片变的光滑 不凹凸
      paint.setStyle(Paint.Style.FILL);//实心
      //paint.setStyle(Paint.Style.STROKE);//空心
      paint.setStrokeWidth(20);

    }
    /*
    * 测量
    * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
    /**
     * 布局
     */

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    /*
    *  绘制
    *
    * */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("重绘："+"==============");
        canvas.drawCircle(circleX,circleY,mRaduis,paint);
    }
 /**
  * 触摸事件
  *
  * */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://按下
                circleX= (int) event.getX();
                circleY= (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE://滑动
                circleX= (int) event.getX();
                circleY= (int) event.getY();
                invalidate();
                break;
            case  MotionEvent.ACTION_UP://抬起
                break;

        }
        return true;

    }
}

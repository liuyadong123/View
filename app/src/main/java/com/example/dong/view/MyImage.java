package com.example.dong.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class MyImage extends ImageView {
    public MyImage(Context context) {
        super(context);
    }

    public MyImage(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImage(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        Bitmap  bitmap=bitmapDrawable.getBitmap();
        if (bitmap!=null){
            Bitmap nb = getRoundBitmap(bitmap);
            canvas.drawBitmap(nb,0,0,null);   //对bitmap进行圆角转换

        }else {
            super.onDraw(canvas);
        }
    }

    private Bitmap getRoundBitmap(Bitmap bitmap) {
        //宽高缩放
        float widthScale = (float) getMeasuredWidth()/bitmap.getWidth();
        float heightScale = (float)getMeasuredHeight()/bitmap.getHeight();
        //矩阵变换类
        Matrix matrix =new Matrix();
        matrix.setScale(widthScale,heightScale);

        // 对bitmap进行变换
        Bitmap bit=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        //最终输出的对象
        Bitmap bitmap1 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
       //创建画布
        Canvas canvas =new Canvas(bitmap1);
        //创建画笔
        Paint paint =new Paint();
        //创建一个圆角的图形
        RectF rectF =new RectF(0,0,getMeasuredWidth(),getMeasuredHeight());
        canvas.drawRoundRect(rectF,100,100,paint);
        //设置画笔的Xfermode模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//设置模式
        //画原始bitmap
        canvas.drawBitmap(bit,0,0,paint);
       return  bitmap1;

    }
}

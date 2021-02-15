package com.example.circlegraph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DrawCircleView extends View {
    Paint paint;
    float StrokeWidth = 300.0f;
    int centerX ;
    int centerY;
    int rangeX = 300;
    int rangeY = 300;
    float sweepAngle = 0;
    int startAngle = -90;
    RectF rect;

    public DrawCircleView(Context context) {
        super(context);
    }

    public DrawCircleView(Context context, AttributeSet attrs) {
        super(context,attrs);
        paint = new Paint();
        paint.setColor(Color.argb(128, 0, 0, 255));
        paint.setStrokeWidth(StrokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        rect = new RectF();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        Log.d("test", "onDraw=");
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        rect.set(centerX - rangeX, centerY - rangeY, centerX + rangeX, centerY + rangeY);

        //円弧のみ描写
        canvas.drawArc(rect, startAngle, sweepAngle, false, paint);
    }

    public float getAngle(){
        return sweepAngle;
    }

    public void setAngle(float angle) {
        sweepAngle = angle;
    }
}

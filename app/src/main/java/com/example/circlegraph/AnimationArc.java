package com.example.circlegraph;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class AnimationArc extends Animation {
    private DrawCircleView drawCircleView;
    private float oldAngle;
    private float newAngle;

    AnimationArc(DrawCircleView drawCircleView, int newAngle){
        this.oldAngle = drawCircleView.getAngle();
        this.newAngle = newAngle;
        this.drawCircleView = drawCircleView;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        drawCircleView.setAngle(angle);
        drawCircleView.requestLayout();
    }
}

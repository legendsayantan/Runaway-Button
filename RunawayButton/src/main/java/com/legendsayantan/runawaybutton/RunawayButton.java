package com.legendsayantan.runawaybutton;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

/**
 * @author legendsayantan
 */

public class RunawayButton extends androidx.appcompat.widget.AppCompatButton {
    public static final int MOVE_ALL_DIRECTION = 0, MOVE_HORIZONTAL = 1, MOVE_VERTICAL= 2;
    public static final int MOVE_LEFT = 3, MOVE_RIGHT = 4, MOVE_UP= 5, MOVE_DOWN= 6;
    private int animationDirection = 0;
    private long animationTime = 200;
    private boolean enabled;
    private float initialX = -1,initialY = -1;
    private AnimatorListenerAdapter animationListener;
    private View warning;
    private ViewGroup parent;
    public RunawayButton(@NonNull Context context) {
        super(context);
        enabled=super.isEnabled();
        super.setEnabled(true);
    }

    public RunawayButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        enabled=super.isEnabled();
        super.setEnabled(true);
    }

    public RunawayButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        enabled=super.isEnabled();
        super.setEnabled(true);
    }

    public void init(){
        initialX = super.getX();
        initialY = super.getY();
    }

    public int getAnimationDirection() {
        return animationDirection;
    }

    public void setAnimationDirection(int animationDirection) {
        this.animationDirection = animationDirection;
    }

    public long getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(long animationTime) {
        this.animationTime = animationTime;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(initialX==-1||initialY==-1)init();
        if(enabled)return super.onTouchEvent(event);
        else{
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                runaway();
            }
            return false;
        }
    }
    public void runaway(){
        int height = super.getHeight();
        int width = super.getWidth();
        float x = super.getX() ,y = super.getY();
        System.out.println(x+"-"+y+"|"+initialX+"-"+initialY);
        if(warning!=null){
            try {
                parent.removeView(warning);
            }catch (Exception ignored){}
            parent.addView(warning);
            warning.setX(x+(super.getHeight()-warning.getHeight())/2f);
            warning.setY(y+(super.getWidth()-warning.getWidth())/2f);
        }
        if (animationDirection == MOVE_ALL_DIRECTION) {
            switch (new Random().nextInt(3)) {
                case 0:
                    _animateHorizontally(x, width);
                    break;
                case 1:
                    _animateVertically(y, height);
                    break;
                case 2:
                    _animateHorizontally(x, width);
                    _animateVerticallyNoCallBack(y, height);
                    break;
            }
        }else if(animationDirection == MOVE_HORIZONTAL){
            _animateHorizontally(x,width);
        }else if(animationDirection == MOVE_VERTICAL){
            _animateVertically(y,height);
        }else if(animationDirection == MOVE_UP){
            _animateToTop(y,height);
        }else if(animationDirection == MOVE_DOWN){
            _animateToBottom(y,height);
        }else if(animationDirection == MOVE_LEFT){
            _animateToLeft(x,width);
        }else if(animationDirection == MOVE_RIGHT){
            _animateToRight(x,width);
        }
    }
    public void restorePosition(){
        if(initialX==-1||initialY==-1)return;
        parent.removeView(warning);
        super.animate().x(initialX).setDuration(animationTime);
        super.animate().y(initialY).setDuration(animationTime);
    }
    private void _animateHorizontally(float x, float offset){
        if(new Random().nextInt(2)==0){
            _animateToLeft(x,offset);
        } else{
            _animateToRight(x,offset);
        }
    }
    private void _animateVertically(float y, float offset){
        if(new Random().nextInt(2)==0){
            _animateToTop(y,offset);
        } else{
            _animateToBottom(y,offset);
        }
    }
    private void _animateVerticallyNoCallBack(float y, float offset){
        if(new Random().nextInt(2)==0){
            _animateToTopNoCallback(y,offset);
        } else{
            _animateToBottomNoCallback(y,offset);
        }
    }
    private void _animateToTop(float y, float offset){
        if(y<initialY){
            _animateToBottom(y,offset);
            return;
        }
        super.animate().y(y-offset).setDuration(animationTime).setListener(animationListener);
    }
    private void _animateToBottom(float y, float offset){
        if(y>initialY){
            _animateToTop(y,offset);
            return;
        }
        super.animate().y(y+offset).setDuration(animationTime).setListener(animationListener);
    }
    private void _animateToTopNoCallback(float y, float offset){
        if(y<initialY){
            _animateToBottomNoCallback(y,offset);
            return;
        }
        super.animate().y(y-offset).setDuration(animationTime);
    }
    private void _animateToBottomNoCallback(float y, float offset){
        if(y>initialY){
            _animateToTopNoCallback(y,offset);
            return;
        }
        super.animate().y(y+offset).setDuration(animationTime);
    }
    private void _animateToLeft(float x, float offset){
        if(x<initialX){
            _animateToRight(x,offset);
            return;
        }
        super.animate().x(x-offset).setDuration(animationTime).setListener(animationListener);
    }
    private void _animateToRight(float x, float offset){
        if(x>initialX){
            _animateToLeft(x,offset);
            return;
        }
        super.animate().x(x+offset).setDuration(animationTime).setListener(animationListener);
    }

    public AnimatorListenerAdapter getAnimationListener() {
        return animationListener;
    }

    public void setAnimationListener(AnimatorListenerAdapter animationListener) {
        this.animationListener = animationListener;
    }

    public void setWarningView(TextView warning, ViewGroup parent) {
        if(warning==null)try {
            parent.removeView(this.warning);
        }catch (Exception e){}
        this.warning = warning;
        this.parent = parent;
    }
}

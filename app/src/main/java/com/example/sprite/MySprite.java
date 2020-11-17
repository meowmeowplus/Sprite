package com.example.sprite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MySprite extends View {
    static final int ANGRY = 1, BABY = 2, HAPPY = 3, MAKEFRIEND = 4, TERRORIZED = 5, UPSET = 6;

    private int[] frame_angry = {
            R.drawable.angry1,
            R.drawable.angry2,
            R.drawable.angry3,
            R.drawable.angry4,
            R.drawable.angry5,
            R.drawable.angry6,
            R.drawable.angry7,
            R.drawable.angry8,
            R.drawable.angry9,
            R.drawable.angry10,
            R.drawable.angry11,
            R.drawable.angry12,
            R.drawable.angry13,
            R.drawable.angry14,
            R.drawable.angry15,
            R.drawable.angry16,
            R.drawable.angry17,
            R.drawable.angry18,
            R.drawable.angry19,
            R.drawable.angry20,
            R.drawable.angry21,
            R.drawable.angry22,
            R.drawable.angry23,
    };

    private int[] frame_baby = {
            R.drawable.baby1,
            R.drawable.baby2,
            R.drawable.baby3,
            R.drawable.baby4,
            R.drawable.baby5,
            R.drawable.baby6,
            R.drawable.baby7,
            R.drawable.baby8,
            R.drawable.baby9,
            R.drawable.baby10,
            R.drawable.baby11,
            R.drawable.baby12,
            R.drawable.baby13,
            R.drawable.baby14,
            R.drawable.baby15,
            R.drawable.baby16,
            R.drawable.baby17,
            R.drawable.baby18,
    };

    private int[] frame_happy = {
            R.drawable.happy1,
            R.drawable.happy2,
            R.drawable.happy3,
            R.drawable.happy4,
            R.drawable.happy5,
            R.drawable.happy6,
            R.drawable.happy7,
            R.drawable.happy8,
            R.drawable.happy9,
            R.drawable.happy10,
            R.drawable.happy11,
            R.drawable.happy12,
            R.drawable.happy13,
            R.drawable.happy14,
            R.drawable.happy15,
            R.drawable.happy16,
            R.drawable.happy17,
            R.drawable.happy18,
            R.drawable.happy19,
            R.drawable.happy20,
            R.drawable.happy21,
            R.drawable.happy22,
            R.drawable.happy23,
            R.drawable.happy24,
            R.drawable.happy25,
            R.drawable.happy26,
            R.drawable.happy27,
            R.drawable.happy28,
            R.drawable.happy29,
            R.drawable.happy30,
            R.drawable.happy31,
            R.drawable.happy32,
            R.drawable.happy33,
            R.drawable.happy34,
            R.drawable.happy35,
            R.drawable.happy36,
            R.drawable.happy37,
    };

    private int[] frame_makefriend = {
            R.drawable.makefriend0,
            R.drawable.makefriend1,
            R.drawable.makefriend2,
            R.drawable.makefriend3,
            R.drawable.makefriend4,
            R.drawable.makefriend5,
            R.drawable.makefriend6,
            R.drawable.makefriend7,
    };

    private  int[] frame_terrorized = {
            R.drawable.terrorized0,
            R.drawable.terrorized1,
            R.drawable.terrorized2,
            R.drawable.terrorized3,
            R.drawable.terrorized4,
    };

    private  int[] frame_upset = {
            R.drawable.upset1,
            R.drawable.upset2,
            R.drawable.upset3,
            R.drawable.upset4,
            R.drawable.upset5,
            R.drawable.upset6,
            R.drawable.upset7,
            R.drawable.upset8,
            R.drawable.upset9,
            R.drawable.upset10,
            R.drawable.upset11,
            R.drawable.upset12,
            R.drawable.upset13,
            R.drawable.upset14,
            R.drawable.upset15,
            R.drawable.upset16,
            R.drawable.upset17,
            R.drawable.upset18,
            R.drawable.upset19,
            R.drawable.upset20,
            R.drawable.upset21,
            R.drawable.upset22,
            R.drawable.upset23,
            R.drawable.upset24,
            R.drawable.upset25,
            R.drawable.upset26,
    };
    private int currentIndex = 0;
    //Change mood to choose kind of frame
    private int mood = UPSET;
    //Different frames have different countDownTime
    private int setCountDownTimer(int mood)
    {
        int countDown = 0;
        switch (mood)
        {
            case ANGRY:
                countDown = 100;
                break;
            case BABY:
                countDown = 50;
                break;
            case HAPPY:
                countDown = 80;
                break;
            case MAKEFRIEND:
                countDown = 100;
                break;
            case TERRORIZED:
                countDown = 150;
                break;
            case UPSET:
                countDown = 80;
                break;
        }
        return countDown;
    }

    private CountDownTimer timer = new CountDownTimer(5000,
            setCountDownTimer(mood)) {
        @Override
        public void onTick(long millisUntilFinished) {
            invalidate();
        }

        @Override
        public void onFinish() {
            start();
        }
    };

    public MySprite(Context context) {
        super(context);
        startAnimation();
    }

    public MySprite(Context context,
                    @Nullable AttributeSet attrs) {
        super(context, attrs);
        startAnimation();
    }

    public void startAnimation() {
        timer.start();
    }

    public void stopAnimation() {
        timer.cancel();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (mood)
        {
            case ANGRY:
                currentIndex = setFrame(currentIndex, frame_angry, canvas);
                break;
            case BABY:
                currentIndex = setFrame(currentIndex, frame_baby, canvas);
                break;
            case HAPPY:
                currentIndex = setFrame(currentIndex, frame_happy, canvas);
                break;
            case MAKEFRIEND:
                currentIndex = setFrame(currentIndex, frame_makefriend, canvas);
                break;
            case TERRORIZED:
                currentIndex = setFrame(currentIndex, frame_terrorized, canvas);
                break;
            case UPSET:
                currentIndex = setFrame(currentIndex, frame_upset, canvas);
                break;
        }

    }

    public int setFrame(int currentIndex, int[] frame, Canvas canvas){
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                frame[currentIndex]);
        currentIndex = (currentIndex+1) % frame.length;
        bmp = Bitmap.createScaledBitmap(bmp, canvas.getWidth(),
                canvas.getHeight(), false);
        canvas.drawBitmap(bmp, 0, 0, null);
        return currentIndex;
    }
}


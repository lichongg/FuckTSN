package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface OnChartGestureListener {
    void onChartDoubleTapped(MotionEvent motionEvent);

    void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7);

    void onChartGestureEnd(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void onChartGestureStart(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void onChartLongPressed(MotionEvent motionEvent);

    void onChartScale(MotionEvent motionEvent, float f6, float f7);

    void onChartSingleTapped(MotionEvent motionEvent);

    void onChartTranslate(MotionEvent motionEvent, float f6, float f7);
}

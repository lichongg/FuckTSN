package com.qq.e.ads.nativ.widget;

import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z5);

    void onWindowVisibilityChanged(int i6);
}

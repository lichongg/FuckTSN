package com.umeng.socialize.shareboard.widgets;

import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class MotionEventCompat {
    static final int ACTION_MASK = 255;
    static final int ACTION_POINTER_DOWN = 5;
    static final int ACTION_POINTER_INDEX_MASK = 65280;
    static final int ACTION_POINTER_INDEX_SHIFT = 8;
    static final int ACTION_POINTER_UP = 6;

    MotionEventCompat() {
    }

    static int getActionIndex(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }
}

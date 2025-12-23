package com.bytedance.sdk.component.jy;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface xt {

    public interface j {
        Pair<Boolean, Boolean> j(View view, MotionEvent motionEvent);
    }

    void setTag(int i6, Object obj);

    void setTouchEventListener(j jVar);
}

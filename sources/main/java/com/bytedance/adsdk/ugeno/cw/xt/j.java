package com.bytedance.adsdk.ugeno.cw.xt;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public String f23629j = "GesThrough_";
    private List<MotionEvent> xt = new ArrayList();
    private Set<String> cw = Collections.synchronizedSet(new HashSet());

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        if (cwVar == null || motionEvent == null || this.xt == null) {
            return;
        }
        this.f23629j = "GesThrough_" + cwVar.la();
        int[] iArr = new int[2];
        cwVar.g().getLocationInWindow(iArr);
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.xt.clear();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(i6, i7);
        this.xt.add(obtain);
    }

    public boolean j(MotionEvent motionEvent) {
        if (motionEvent == null || this.cw == null) {
            return false;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        return this.cw.contains(motionEvent.getDownTime() + "_" + pointerId);
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (this.xt.isEmpty() || this.cw == null || cwVar == null || cwVar.g() == null || cwVar.g().getRootView() == null) {
            return;
        }
        final View rootView = cwVar.g().getRootView();
        this.xt.size();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.cw.xt.j.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : j.this.xt) {
                    if (motionEvent != null) {
                        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        j.this.cw.add(motionEvent.getDownTime() + "_" + pointerId);
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                j.this.xt.clear();
            }
        }, 300L);
    }
}

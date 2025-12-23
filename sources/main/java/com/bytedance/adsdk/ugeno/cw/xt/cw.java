package com.bytedance.adsdk.ugeno.cw.xt;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.w;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private av cw;

    /* renamed from: j, reason: collision with root package name */
    private float f23626j;

    /* renamed from: m, reason: collision with root package name */
    private final int f23627m;

    /* renamed from: r, reason: collision with root package name */
    private Context f23628r;
    private boolean up;
    private float xt;

    public cw(Context context, av avVar) {
        this.f23628r = context;
        this.cw = avVar;
        this.f23627m = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean j(w wVar, com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.up = false;
                    }
                } else {
                    float x5 = motionEvent.getX();
                    float y5 = motionEvent.getY();
                    if (Math.abs(x5 - this.f23626j) >= this.f23627m || Math.abs(y5 - this.xt) >= this.f23627m) {
                        this.up = true;
                    }
                }
            } else {
                if (this.up) {
                    this.up = false;
                    return false;
                }
                float x6 = motionEvent.getX();
                float y6 = motionEvent.getY();
                if (Math.abs(x6 - this.f23626j) < this.f23627m && Math.abs(y6 - this.xt) < this.f23627m) {
                    if (wVar != null) {
                        wVar.j(this.cw, cwVar, cwVar);
                        return true;
                    }
                } else {
                    this.up = false;
                }
            }
        } else {
            this.f23626j = motionEvent.getX();
            this.xt = motionEvent.getY();
        }
        return true;
    }
}

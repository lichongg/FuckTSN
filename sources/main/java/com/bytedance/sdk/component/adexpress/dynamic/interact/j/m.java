package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements View.OnTouchListener {
    private static int cw = 10;

    /* renamed from: j, reason: collision with root package name */
    private float f25741j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f25742r;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.tl up;
    private float xt;

    public m(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar) {
        this.up = tlVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.f25742r = false;
                    }
                } else {
                    float x5 = motionEvent.getX();
                    float y5 = motionEvent.getY();
                    if (Math.abs(x5 - this.f25741j) >= cw || Math.abs(y5 - this.xt) >= cw) {
                        this.f25742r = true;
                    }
                }
            } else {
                if (this.f25742r) {
                    this.f25742r = false;
                    return false;
                }
                float x6 = motionEvent.getX();
                float y6 = motionEvent.getY();
                if (Math.abs(x6 - this.f25741j) < cw && Math.abs(y6 - this.xt) < cw) {
                    com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar = this.up;
                    if (tlVar != null) {
                        tlVar.j();
                    }
                } else {
                    this.f25742r = false;
                }
            }
        } else {
            this.f25741j = motionEvent.getX();
            this.xt = motionEvent.getY();
        }
        return true;
    }
}

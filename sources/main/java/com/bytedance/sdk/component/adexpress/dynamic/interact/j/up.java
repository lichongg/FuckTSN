package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements View.OnTouchListener {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private float f25750j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.tl f25751r;
    private int up;
    private float xt;

    public up(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar, int i6) {
        this.f25751r = tlVar;
        this.up = i6;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y5 = motionEvent.getY();
                    this.xt = y5;
                    if (Math.abs(y5 - this.f25750j) > 10.0f) {
                        this.cw = true;
                    }
                }
            } else {
                if (!this.cw) {
                    return false;
                }
                int xt = com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), Math.abs(this.xt - this.f25750j));
                if (this.xt - this.f25750j < 0.0f && xt > this.up && (tlVar = this.f25751r) != null) {
                    tlVar.j();
                    this.f25750j = 0.0f;
                    this.xt = 0.0f;
                    this.cw = false;
                }
            }
        } else {
            this.f25750j = motionEvent.getY();
        }
        return true;
    }
}

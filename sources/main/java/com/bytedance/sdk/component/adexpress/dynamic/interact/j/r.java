package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements View.OnTouchListener {
    private float ae;
    private float cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.tl f25743g;

    /* renamed from: j, reason: collision with root package name */
    private float f25744j;

    /* renamed from: m, reason: collision with root package name */
    private float f25745m;
    private int oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private float f25746r;
    private boolean tl;
    private boolean up = true;
    private float xt;

    public r(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar, int i6, boolean z5) {
        this.f25743g = tlVar;
        this.oq = i6;
        this.qv = z5;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar3;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y5 = motionEvent.getY();
                    this.ae = y5;
                    if (Math.abs(y5 - this.f25745m) > 10.0f) {
                        this.tl = true;
                    }
                    this.f25746r = motionEvent.getX();
                    this.cw = motionEvent.getY();
                    if (Math.abs(this.f25746r - this.f25744j) > 8.0f || Math.abs(this.cw - this.xt) > 8.0f) {
                        this.up = false;
                    }
                }
            } else {
                if (!this.tl && !this.up) {
                    return false;
                }
                if (!this.qv && (tlVar3 = this.f25743g) != null) {
                    tlVar3.j();
                } else {
                    int xt = com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), Math.abs(this.ae - this.f25745m));
                    if (this.ae - this.f25745m < 0.0f && xt > this.oq && (tlVar2 = this.f25743g) != null) {
                        tlVar2.j();
                    } else if (this.up && (tlVar = this.f25743g) != null) {
                        tlVar.j();
                    }
                }
            }
        } else {
            this.f25744j = motionEvent.getX();
            this.xt = motionEvent.getY();
            this.f25745m = motionEvent.getY();
            this.up = true;
        }
        return true;
    }
}

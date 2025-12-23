package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements View.OnTouchListener {
    private int ae;
    private float cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f25732g;

    /* renamed from: j, reason: collision with root package name */
    private float f25733j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.tl f25734m;

    /* renamed from: r, reason: collision with root package name */
    private float f25735r;
    private boolean tl;
    private boolean up;
    private float xt;

    public cw(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar) {
        this(tlVar, 5);
    }

    public cw(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar, int i6) {
        this.ae = 5;
        this.tl = true;
        this.f25734m = tlVar;
        if (i6 > 0) {
            this.ae = i6;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar3;
        if (this.f25732g) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f25733j = motionEvent.getX();
            this.xt = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.f25735r = motionEvent.getX();
                this.cw = motionEvent.getY();
                if (Math.abs(this.f25735r - this.f25733j) > 10.0f) {
                    this.up = true;
                }
                if (Math.abs(this.f25735r - this.f25733j) > 8.0f || Math.abs(this.cw - this.xt) > 8.0f) {
                    this.tl = false;
                }
                int xt = com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), Math.abs(this.f25735r - this.f25733j));
                if (this.f25735r > this.f25733j && xt > this.ae && (tlVar3 = this.f25734m) != null) {
                    tlVar3.j();
                    this.f25732g = true;
                }
            }
        } else {
            if (!this.up && !this.tl) {
                return false;
            }
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            int xt2 = com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), Math.abs(this.f25735r - this.f25733j));
            if (this.f25735r > this.f25733j && xt2 > this.ae && (tlVar2 = this.f25734m) != null) {
                tlVar2.j();
                this.f25732g = true;
            }
            float abs = Math.abs(x5 - this.f25733j);
            float abs2 = Math.abs(y5 - this.xt);
            if ((abs < 8.0f || abs2 < 8.0f) && (tlVar = this.f25734m) != null) {
                tlVar.xt();
                this.f25732g = true;
            }
        }
        return true;
    }
}

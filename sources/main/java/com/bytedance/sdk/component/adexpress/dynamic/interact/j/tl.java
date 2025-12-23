package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl implements View.OnTouchListener {
    private float ae;
    private final int cw = 10;

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.component.adexpress.dynamic.interact.tl f25747j;

    /* renamed from: m, reason: collision with root package name */
    private float f25748m;

    /* renamed from: r, reason: collision with root package name */
    private float f25749r;
    private float up;
    private final boolean xt;

    public tl(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar, boolean z5) {
        this.f25747j = tlVar;
        this.xt = z5;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar2;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f25748m = motionEvent.getX();
                this.ae = motionEvent.getY();
                new StringBuilder(", mEndY: ").append(this.ae);
                if (!this.xt && (tlVar2 = this.f25747j) != null) {
                    tlVar2.j();
                } else {
                    float f6 = this.f25748m - this.f25749r;
                    float f7 = this.ae - this.up;
                    if (com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), Math.abs((float) Math.sqrt((f6 * f6) + (f7 * f7)))) > 10.0f && (tlVar = this.f25747j) != null) {
                        tlVar.j();
                    }
                }
            }
        } else {
            this.f25749r = motionEvent.getX();
            this.up = motionEvent.getY();
            new StringBuilder(", mStartY: ").append(this.up);
        }
        return true;
    }
}

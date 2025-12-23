package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements View.OnTouchListener {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private float f25752j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.tl f25753m;

    /* renamed from: r, reason: collision with root package name */
    private boolean f25754r;
    private InteractViewContainer up;
    private float xt;

    public xt(InteractViewContainer interactViewContainer, com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar) {
        this.up = interactViewContainer;
        this.f25753m = tlVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x5 = motionEvent.getX();
                    float y5 = motionEvent.getY();
                    if (Math.abs(x5 - this.f25752j) >= com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), 10.0f) || Math.abs(y5 - this.xt) >= com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), 10.0f)) {
                        this.f25754r = true;
                        this.up.m();
                    }
                }
            } else {
                if (this.f25754r) {
                    return false;
                }
                if (System.currentTimeMillis() - this.cw >= 1500) {
                    com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar = this.f25753m;
                    if (tlVar != null) {
                        tlVar.j();
                    }
                }
                this.up.m();
            }
        } else {
            this.cw = System.currentTimeMillis();
            this.f25752j = motionEvent.getX();
            this.xt = motionEvent.getY();
            this.up.up();
        }
        return true;
    }
}

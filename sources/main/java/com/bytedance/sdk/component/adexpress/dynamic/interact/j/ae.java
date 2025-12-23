package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements View.OnTouchListener {
    private static int cw = 10;

    /* renamed from: j, reason: collision with root package name */
    private float f25728j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.tl f25730r;
    private int up;
    private float xt;

    /* renamed from: m, reason: collision with root package name */
    private RectF f25729m = new RectF();
    private long ae = 0;
    private final int tl = 200;

    /* renamed from: g, reason: collision with root package name */
    private final int f25727g = 3;
    private SoftReference<View> oq = new SoftReference<>(null);

    private RectF j(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    public ae(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar, int i6, final ViewGroup viewGroup) {
        this.up = cw;
        this.f25730r = tlVar;
        if (i6 > 0) {
            this.up = i6;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.j.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    View findViewById = viewGroup.findViewById(2097610746);
                    ae.this.oq = new SoftReference(findViewById);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar2;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                RectF rectF = this.f25729m;
                if (rectF != null && !rectF.contains(this.f25728j, this.xt)) {
                    return false;
                }
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.f25728j);
                float abs2 = Math.abs(rawY - this.xt);
                int xt = com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), Math.abs(rawX - this.f25728j));
                int i6 = cw;
                if (abs >= i6 && abs2 >= i6) {
                    if (rawX > this.f25728j && xt > this.up && (tlVar2 = this.f25730r) != null) {
                        tlVar2.j();
                    }
                } else if ((System.currentTimeMillis() - this.ae < 200 || (abs < 3.0f && abs2 < 3.0f)) && (tlVar = this.f25730r) != null) {
                    tlVar.j();
                }
            }
        } else {
            this.f25729m = j(this.oq.get());
            this.f25728j = motionEvent.getRawX();
            this.xt = motionEvent.getRawY();
            this.ae = System.currentTimeMillis();
        }
        return true;
    }
}

package com.bytedance.sdk.component.adexpress.dynamic.interact.j;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements View.OnTouchListener {
    private static int cw = 10;

    /* renamed from: j, reason: collision with root package name */
    private float f25737j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.tl f25739r;
    private int up;
    private float xt;

    /* renamed from: m, reason: collision with root package name */
    private RectF f25738m = new RectF();
    private long ae = 0;
    private final int tl = 200;

    /* renamed from: g, reason: collision with root package name */
    private final int f25736g = 3;
    private SoftReference<ViewGroup> oq = new SoftReference<>(null);

    private RectF j(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    public j(com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar, int i6, final ViewGroup viewGroup) {
        this.up = cw;
        this.f25739r = tlVar;
        if (i6 > 0) {
            this.up = i6;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.j.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.oq = new SoftReference(viewGroup);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                RectF rectF = this.f25738m;
                if (rectF != null && !rectF.contains(this.f25737j, this.xt)) {
                    return false;
                }
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.f25737j);
                float abs2 = Math.abs(rawY - this.xt);
                int i6 = this.up;
                if (abs >= i6 && abs2 >= i6) {
                    com.bytedance.sdk.component.adexpress.dynamic.interact.tl tlVar2 = this.f25739r;
                    if (tlVar2 != null) {
                        tlVar2.j();
                    }
                } else if ((System.currentTimeMillis() - this.ae < 200 || (abs < 3.0f && abs2 < 3.0f)) && (tlVar = this.f25739r) != null) {
                    tlVar.j();
                }
            }
        } else {
            this.f25738m = j(this.oq.get());
            this.f25737j = motionEvent.getRawX();
            this.xt = motionEvent.getRawY();
            this.ae = System.currentTimeMillis();
        }
        return true;
    }
}

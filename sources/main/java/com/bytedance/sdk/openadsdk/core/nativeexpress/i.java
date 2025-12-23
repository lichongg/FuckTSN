package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i {
    private float cw;

    /* renamed from: g, reason: collision with root package name */
    private float f29655g;

    /* renamed from: j, reason: collision with root package name */
    private View f29656j;
    private float oq;
    private float qv;
    private float tl;
    private float xt;

    /* renamed from: r, reason: collision with root package name */
    private float f29658r = 0.0f;
    private float up = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f29657m = 0.0f;
    private float ae = 0.0f;
    private boolean vl = false;
    private boolean jy = false;
    private boolean ws = false;
    private boolean az = false;

    public boolean xt(MotionEvent motionEvent) {
        this.xt = ((ViewGroup) this.f29656j.getParent()).getWidth();
        this.cw = ((ViewGroup) this.f29656j.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.jy = false;
                this.ws = false;
                float x5 = motionEvent.getX();
                float y5 = motionEvent.getY();
                float f6 = x5 - this.f29658r;
                float f7 = y5 - this.up;
                this.tl = this.f29656j.getLeft() + f6;
                this.f29655g = this.f29656j.getTop() + f7;
                this.oq = this.f29656j.getRight() + f6;
                this.qv = this.f29656j.getBottom() + f7;
                if (this.tl < 0.0f) {
                    this.ws = true;
                    this.tl = 0.0f;
                    this.oq = this.f29656j.getWidth() + 0.0f;
                }
                float f8 = this.oq;
                float f9 = this.xt;
                if (f8 > f9) {
                    this.jy = true;
                    this.oq = f9;
                    this.tl = f9 - this.f29656j.getWidth();
                }
                if (this.f29655g < 0.0f) {
                    this.f29655g = 0.0f;
                    this.qv = 0.0f + this.f29656j.getHeight();
                }
                float f10 = this.qv;
                float f11 = this.cw;
                if (f10 > f11) {
                    this.qv = f11;
                    this.f29655g = f11 - this.f29656j.getHeight();
                }
                this.f29656j.offsetLeftAndRight((int) f6);
                this.f29656j.offsetTopAndBottom((int) f7);
                if (this.ws) {
                    View view = this.f29656j;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.jy) {
                    this.f29656j.offsetLeftAndRight((int) (this.xt - r7.getRight()));
                }
            }
        } else {
            if (!this.az) {
                return false;
            }
            if (((int) motionEvent.getRawX()) > this.xt / 2.0f) {
                this.vl = false;
                this.f29656j.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.xt - this.f29656j.getWidth()).start();
                this.f29656j.offsetLeftAndRight((int) (this.xt - r7.getRight()));
            } else {
                this.vl = true;
                this.f29656j.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view2 = this.f29656j;
                view2.offsetLeftAndRight(-view2.getLeft());
            }
            this.f29656j.invalidate();
        }
        return true;
    }

    public i(View view) {
        this.f29656j = view;
    }

    public boolean j(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 2) {
                return false;
            }
            this.f29657m = motionEvent.getX();
            this.ae = motionEvent.getY();
            if (Math.abs(this.f29657m - this.f29658r) >= 5.0f && Math.abs(this.ae - this.up) >= 5.0f) {
                this.az = true;
                return true;
            }
            this.az = false;
            return false;
        }
        this.f29658r = motionEvent.getX();
        this.up = motionEvent.getY();
        return false;
    }
}

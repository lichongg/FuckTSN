package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.bytedance.sdk.openadsdk.core.tj.ya;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SiteGestureView extends View {
    private long ae;
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    private f f29635j;

    /* renamed from: m, reason: collision with root package name */
    private float f29636m;

    /* renamed from: r, reason: collision with root package name */
    private float f29637r;
    private float up;
    private ya xt;

    private boolean j(int i6, MotionEvent motionEvent) {
        if (this.xt.j() == 1 && this.f29635j.j()) {
            com.bytedance.sdk.component.utils.vl.j("xdy", i6 + " ad");
            this.f29635j.j(motionEvent);
            return false;
        }
        com.bytedance.sdk.component.utils.vl.j("xdy", i6 + " site");
        xt(i6, motionEvent);
        return true;
    }

    public SiteGestureView(Context context, ya yaVar, f fVar) {
        super(context);
        this.xt = yaVar;
        this.f29635j = fVar;
        setTag(2097610717, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
    }

    private void xt(int i6, MotionEvent motionEvent) {
        int i7;
        int[] j6 = ed.j(this);
        x.j r5 = new x.j().j("express_gesture_view").r(this.up).cw(this.f29636m).xt(motionEvent.getRawX()).j(motionEvent.getRawY()).xt(this.ae).cw(getWidth()).r(getHeight());
        int i8 = 0;
        if (j6 == null) {
            i7 = 0;
        } else {
            i7 = j6[0];
        }
        x.j j7 = r5.j(i7);
        if (j6 != null) {
            i8 = j6[1];
        }
        com.bytedance.sdk.openadsdk.core.tj.x j8 = j7.xt(i8).j(true).j(System.currentTimeMillis()).j();
        this.xt.j(i6);
        this.f29635j.j(this, 1, j8, this.xt);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    com.bytedance.sdk.component.utils.vl.j("xdy", "gesture cancel");
                }
            } else {
                this.f29635j.xt();
                float r5 = ed.r(getContext(), motionEvent.getX());
                float r6 = ed.r(getContext(), motionEvent.getY());
                if (this.xt.cw() == 0.0d) {
                    com.bytedance.sdk.component.utils.vl.j("xdy", "nh g");
                    xt(-1, motionEvent);
                    return true;
                }
                float f6 = r5 - this.cw;
                float f7 = r6 - this.f29637r;
                float abs = Math.abs(f6);
                float abs2 = Math.abs(f7);
                if (abs <= 3.0f && abs2 <= 3.0f) {
                    com.bytedance.sdk.component.utils.vl.j("xdy", "c ad");
                    this.f29635j.j(motionEvent);
                    return true;
                }
                double cw = this.xt.cw();
                int r7 = this.xt.r();
                if (abs > abs2) {
                    if (abs > cw) {
                        long j6 = r7;
                        if (com.bytedance.sdk.openadsdk.core.mi.xt.j(j6, 2L) && f6 < 0.0f) {
                            return j(2, motionEvent);
                        }
                        if (com.bytedance.sdk.openadsdk.core.mi.xt.j(j6, 4L) && f6 > 0.0f) {
                            return j(4, motionEvent);
                        }
                    }
                } else if (abs2 > cw) {
                    long j7 = r7;
                    if (com.bytedance.sdk.openadsdk.core.mi.xt.j(j7, 8L) && f7 < 0.0f) {
                        return j(8, motionEvent);
                    }
                    if (com.bytedance.sdk.openadsdk.core.mi.xt.j(j7, 16L) && f7 > 0.0f) {
                        return j(16, motionEvent);
                    }
                }
                return false;
            }
        } else {
            this.cw = ed.r(getContext(), motionEvent.getX());
            this.f29637r = ed.r(getContext(), motionEvent.getY());
            this.up = motionEvent.getRawX();
            this.f29636m = motionEvent.getRawY();
            this.ae = System.currentTimeMillis();
            this.f29635j.j(motionEvent);
            if (this.xt.xt() == -1) {
                com.bytedance.sdk.component.utils.vl.j("xdy", "nt ad");
                return false;
            }
            if (!this.f29635j.cw()) {
                com.bytedance.sdk.component.utils.vl.j("xdy", "un ad");
                return false;
            }
        }
        return true;
    }
}

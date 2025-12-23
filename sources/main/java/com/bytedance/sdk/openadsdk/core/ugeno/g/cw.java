package com.bytedance.sdk.openadsdk.core.ugeno.g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements View.OnTouchListener {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private float f30729j;

    /* renamed from: m, reason: collision with root package name */
    private Context f30730m;

    /* renamed from: r, reason: collision with root package name */
    private j f30731r;
    private int up;
    private float xt;

    public interface j {
        void j();

        void xt();
    }

    public cw(Context context, j jVar, int i6) {
        this.f30730m = context;
        this.up = i6;
        this.f30731r = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y5 = motionEvent.getY();
                    this.xt = y5;
                    if (Math.abs(y5 - this.f30729j) > 10.0f) {
                        this.cw = true;
                    }
                }
            } else {
                if (!this.cw) {
                    j jVar = this.f30731r;
                    if (jVar != null) {
                        jVar.xt();
                    }
                    return true;
                }
                int r5 = ed.r(this.f30730m, Math.abs(this.xt - this.f30729j));
                if (this.xt - this.f30729j < 0.0f && r5 > this.up) {
                    j jVar2 = this.f30731r;
                    if (jVar2 != null) {
                        jVar2.j();
                    }
                } else {
                    j jVar3 = this.f30731r;
                    if (jVar3 != null) {
                        jVar3.xt();
                    }
                }
            }
        } else {
            this.f30729j = motionEvent.getY();
        }
        return true;
    }
}

package com.bytedance.adsdk.ugeno.up.cw;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.up.qv;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends xt {
    private boolean jy;
    private float qv;
    private float vl;
    private com.bytedance.adsdk.ugeno.cw.xt.j ws;

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        com.bytedance.adsdk.ugeno.xt.cw cwVar = this.xt;
        if (cwVar != null && cwVar.q() && this.ws == null) {
            this.ws = new com.bytedance.adsdk.ugeno.cw.xt.j();
        }
        return j(this.xt, (MotionEvent) objArr[0]);
    }

    public up(Context context) {
        super(context);
    }

    public boolean j(com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.cw.xt.j jVar = this.ws;
        if (jVar != null) {
            if (jVar.j(motionEvent)) {
                return false;
            }
            this.ws.j(cwVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.qv = motionEvent.getRawX();
            this.vl = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.qv) >= 15.0f || Math.abs(rawY - this.vl) >= 15.0f) {
                    this.jy = true;
                }
            } else if (action == 3) {
                this.jy = false;
            }
        } else {
            if (this.jy) {
                this.jy = false;
                this.qv = 0.0f;
                this.vl = 0.0f;
                com.bytedance.adsdk.ugeno.cw.xt.j jVar2 = this.ws;
                if (jVar2 != null) {
                    jVar2.j(cwVar);
                }
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.qv) < 15.0f && Math.abs(rawY2 - this.vl) < 15.0f) {
                qv qvVar = this.f23743j;
                if (qvVar != null) {
                    qvVar.j(cwVar, this.f23744m, this.cw.xt());
                    this.qv = 0.0f;
                    this.vl = 0.0f;
                    return true;
                }
            } else {
                this.jy = false;
                com.bytedance.adsdk.ugeno.cw.xt.j jVar3 = this.ws;
                if (jVar3 != null) {
                    jVar3.j(cwVar);
                }
            }
        }
        return true;
    }
}

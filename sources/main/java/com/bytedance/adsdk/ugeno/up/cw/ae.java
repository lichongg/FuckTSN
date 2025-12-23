package com.bytedance.adsdk.ugeno.up.cw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.amap.api.services.core.AMapException;
import com.bytedance.adsdk.ugeno.m.g;
import com.bytedance.adsdk.ugeno.up.qv;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends xt implements g.j {
    private Handler jy;
    private int qv;
    private boolean vl;

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.qv = com.bytedance.adsdk.ugeno.m.cw.j(this.up.get("delay"), 500);
        return j(this.xt, motionEvent);
    }

    public ae(Context context) {
        super(context);
        this.qv = 500;
        this.jy = new g(Looper.getMainLooper(), this);
    }

    private boolean j(com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        qv qvVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jy.sendEmptyMessageDelayed(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT, this.qv);
        } else {
            if (action == 1) {
                if (this.vl && (qvVar = this.f23743j) != null) {
                    qvVar.j(this.xt, this.f23744m, this.cw.xt());
                    this.vl = false;
                    Handler handler = this.jy;
                    if (handler != null) {
                        handler.removeMessages(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT);
                    }
                    return true;
                }
                Handler handler2 = this.jy;
                if (handler2 != null) {
                    handler2.removeMessages(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT);
                }
                this.vl = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.jy;
                if (handler3 != null) {
                    handler3.removeMessages(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT);
                }
                this.vl = false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.m.g.j
    public void j(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.vl = true;
        Handler handler = this.jy;
        if (handler != null) {
            handler.removeMessages(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT);
        }
    }
}

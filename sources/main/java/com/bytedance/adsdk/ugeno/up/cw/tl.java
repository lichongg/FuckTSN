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
public class tl extends xt implements g.j {
    private int qv;
    private Handler vl;

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.qv = com.bytedance.adsdk.ugeno.m.cw.j(this.up.get("delay"), 500);
        return j(this.xt, motionEvent);
    }

    public tl(Context context) {
        super(context);
        this.qv = 500;
        this.vl = new g(Looper.getMainLooper(), this);
    }

    private boolean j(com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.vl.sendEmptyMessageDelayed(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR, this.qv);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.vl.removeMessages(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR);
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.m.g.j
    public void j(Message message) {
        if (message.what != 1101) {
            return;
        }
        qv qvVar = this.f23743j;
        if (qvVar != null) {
            qvVar.j(this.xt, this.f23744m, this.cw.xt());
        }
        Handler handler = this.vl;
        if (handler != null) {
            handler.removeMessages(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR);
        }
    }
}

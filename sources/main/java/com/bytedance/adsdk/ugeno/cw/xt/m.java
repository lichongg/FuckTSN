package com.bytedance.adsdk.ugeno.cw.xt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.m.g;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m implements g.j {
    private Handler ae = new g(Looper.getMainLooper(), this);
    private w cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f23631j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw f23632m;

    /* renamed from: r, reason: collision with root package name */
    private Context f23633r;
    private av up;
    private int xt;

    public void j(w wVar) {
        this.cw = wVar;
    }

    public void j() {
        av avVar = this.up;
        if (avVar == null) {
            return;
        }
        JSONObject cw = avVar.cw();
        try {
            this.xt = Integer.parseInt(com.bytedance.adsdk.ugeno.r.xt.j(cw.optString(bi.aX, "8000"), this.f23632m.oq()));
            this.f23631j = cw.optBoolean("repeat");
            this.ae.sendEmptyMessageDelayed(1001, this.xt);
        } catch (NumberFormatException e6) {
            vl.j(e6);
        }
    }

    public m(Context context, av avVar, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.f23633r = context;
        this.up = avVar;
        this.f23632m = cwVar;
    }

    @Override // com.bytedance.adsdk.ugeno.m.g.j
    public void j(Message message) {
        if (message.what != 1001) {
            return;
        }
        w wVar = this.cw;
        if (wVar != null) {
            av avVar = this.up;
            com.bytedance.adsdk.ugeno.xt.cw cwVar = this.f23632m;
            wVar.j(avVar, cwVar, cwVar);
        }
        if (this.f23631j) {
            this.ae.sendEmptyMessageDelayed(1001, this.xt);
        } else {
            this.ae.removeMessages(1001);
        }
    }
}

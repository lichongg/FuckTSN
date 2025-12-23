package com.bytedance.adsdk.ugeno.cw.xt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.jy;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.m.g;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements g.j {
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    private int f23639j;

    /* renamed from: m, reason: collision with root package name */
    private Handler f23640m = new g(Looper.getMainLooper(), this);

    /* renamed from: r, reason: collision with root package name */
    private av f23641r;
    private com.bytedance.adsdk.ugeno.xt.cw up;
    private w xt;

    public void j(w wVar) {
        this.xt = wVar;
    }

    public void j() {
        av avVar = this.f23641r;
        if (avVar == null) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(com.bytedance.adsdk.ugeno.r.xt.j(avVar.cw().optString("delay"), this.up.oq()));
            this.f23639j = parseInt;
            this.f23640m.sendEmptyMessageDelayed(1001, parseInt);
        } catch (NumberFormatException e6) {
            vl.j(e6);
        }
    }

    public xt(Context context, av avVar, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.cw = context;
        this.f23641r = avVar;
        this.up = cwVar;
    }

    @Override // com.bytedance.adsdk.ugeno.m.g.j
    public void j(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject cw = this.f23641r.cw();
        if (TextUtils.equals(cw.optString("type"), "onAnimation")) {
            String optString = cw.optString("nodeId");
            com.bytedance.adsdk.ugeno.xt.cw cwVar = this.up;
            com.bytedance.adsdk.ugeno.xt.cw r5 = cwVar.xt(cwVar).r(optString);
            new jy(r5.g(), com.bytedance.adsdk.ugeno.cw.j.j(cw.optJSONObject("animatorSet"), r5)).j();
        } else {
            w wVar = this.xt;
            if (wVar != null) {
                av avVar = this.f23641r;
                com.bytedance.adsdk.ugeno.xt.cw cwVar2 = this.up;
                wVar.j(avVar, cwVar2, cwVar2);
            }
        }
        this.f23640m.removeMessages(1001);
    }
}

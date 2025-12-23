package com.bytedance.adsdk.ugeno.up.cw;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.up.qv;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends xt implements com.bytedance.adsdk.ugeno.j.xt {
    private String qv;

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        com.bytedance.adsdk.ugeno.xt.cw cwVar;
        com.bytedance.adsdk.ugeno.xt.cw xt;
        com.bytedance.adsdk.ugeno.j.j oq;
        Map<String, String> map = this.up;
        if (map != null && map.size() > 0) {
            String str = this.up.get(CommonNetImpl.NAME);
            this.qv = this.up.get("state");
            if (!TextUtils.isEmpty(str) && (xt = (cwVar = this.xt).xt(cwVar)) != null && (oq = xt.m(str).oq(str)) != null) {
                oq.j(this);
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt
    public void xt() {
        qv qvVar;
        if ((TextUtils.equals(this.qv, "complete") || TextUtils.isEmpty(this.qv)) && (qvVar = this.f23743j) != null) {
            qvVar.j(this.xt, this.f23744m, this.cw.xt());
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt
    public void j() {
        qv qvVar;
        if ((TextUtils.equals(this.qv, "start") || TextUtils.isEmpty(this.qv)) && (qvVar = this.f23743j) != null) {
            qvVar.j(this.xt, this.f23744m, this.cw.xt());
        }
    }
}

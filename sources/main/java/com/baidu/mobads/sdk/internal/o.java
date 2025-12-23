package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o extends ae {

    /* renamed from: t, reason: collision with root package name */
    private CpuChannelListManager.CpuChannelListListener f11074t;

    /* renamed from: u, reason: collision with root package name */
    private String f11075u;

    /* renamed from: v, reason: collision with root package name */
    private int f11076v;

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.f11074t = cpuChannelListListener;
    }

    public o(Context context) {
        super(context);
    }

    public void a(String str, int i6) {
        this.f11075u = str;
        this.f11076v = i6;
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f10733m == null) {
            this.f10734n = false;
            return;
        }
        this.f10734n = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f10733m.createProdHandler(jSONObject2);
            p pVar = new p(this);
            this.f10733m.addEventListener(z.ap, pVar);
            this.f10733m.addEventListener(z.aq, pVar);
            jSONObject.put("appsid", this.f11075u);
            jSONObject.put("subChannelId", this.f11076v);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        a(jSONObject);
    }
}

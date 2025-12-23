package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class o1 extends e1 {

    /* renamed from: f, reason: collision with root package name */
    String f33626f;

    /* renamed from: g, reason: collision with root package name */
    String f33627g;

    /* renamed from: h, reason: collision with root package name */
    private String f33628h;

    @Override // com.huawei.hms.hatool.u0
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f33628h);
        jSONObject.put("_emui_ver", this.f33558a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f33626f);
        jSONObject.put("_mnc", this.f33627g);
        jSONObject.put("_package_name", this.f33559b);
        jSONObject.put("_app_ver", this.f33560c);
        jSONObject.put("_lib_ver", "2.2.0.314");
        jSONObject.put("_channel", this.f33561d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f33562e);
        return jSONObject;
    }

    public void f(String str) {
        this.f33626f = str;
    }

    public void g(String str) {
        this.f33627g = str;
    }

    public void h(String str) {
        this.f33628h = str;
    }
}

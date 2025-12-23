package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class x implements u0 {

    /* renamed from: a, reason: collision with root package name */
    private List<f> f33674a;

    /* renamed from: b, reason: collision with root package name */
    private h0 f33675b;

    /* renamed from: c, reason: collision with root package name */
    private e1 f33676c;

    /* renamed from: d, reason: collision with root package name */
    private u0 f33677d;

    /* renamed from: e, reason: collision with root package name */
    private String f33678e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f33679f;

    @Override // com.huawei.hms.hatool.u0
    public JSONObject a() {
        String str;
        List<f> list = this.f33674a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f33675b == null || this.f33676c == null || this.f33677d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f33675b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a6 = this.f33677d.a();
            a6.put("properties", this.f33676c.a());
            try {
                a6.put("events_global_properties", new JSONObject(this.f33678e));
            } catch (JSONException unused) {
                a6.put("events_global_properties", this.f33678e);
            }
            jSONObject2.put("events_common", a6);
            JSONArray jSONArray = new JSONArray();
            Iterator<f> it = this.f33674a.iterator();
            while (it.hasNext()) {
                JSONObject a7 = it.next().a();
                if (a7 != null) {
                    jSONArray.put(a7);
                } else {
                    j1.l("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(com.umeng.analytics.pro.d.ax, jSONArray);
            try {
                String c6 = r0.c(i0.g(jSONObject2.toString().getBytes("UTF-8")), this.f33679f);
                if (TextUtils.isEmpty(c6)) {
                    j1.l("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", c6);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        j1.l("hmsSdk", str);
        return null;
    }

    public void b(h0 h0Var) {
        this.f33675b = h0Var;
    }

    public void c(l0 l0Var) {
        this.f33677d = l0Var;
    }

    public void d(e1 e1Var) {
        this.f33676c = e1Var;
    }

    public void e(String str) {
        if (str != null) {
            this.f33678e = str;
        }
    }

    public void f(List<f> list) {
        this.f33674a = list;
    }

    public x(String str) {
        this.f33679f = str;
    }
}

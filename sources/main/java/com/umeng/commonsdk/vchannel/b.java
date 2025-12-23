package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private String f42149b;

    /* renamed from: a, reason: collision with root package name */
    private String f42148a = "_$unknown";

    /* renamed from: c, reason: collision with root package name */
    private long f42150c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f42151d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f42152e = a.f42147j;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Object> f42153f = null;

    public String a() {
        return this.f42148a;
    }

    public void a(String str) {
        this.f42148a = str;
    }

    public long b() {
        return this.f42150c;
    }

    public Map<String, Object> c() {
        return this.f42153f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f42148a);
            jSONObject.put("pn", this.f42149b);
            jSONObject.put("ds", this.f42151d);
            jSONObject.put("ts", this.f42150c);
            Map<String, Object> map = this.f42153f;
            if (map != null && map.size() > 0) {
                for (String str : this.f42153f.keySet()) {
                    jSONObject.put(str, this.f42153f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f42152e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f42148a + ",");
        sb.append("pn:" + this.f42149b + ",");
        sb.append("ts:" + this.f42150c + ",");
        Map<String, Object> map = this.f42153f;
        if (map != null && map.size() > 0) {
            for (String str : this.f42153f.keySet()) {
                Object obj = this.f42153f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f42151d + "]");
        return sb.toString();
    }

    public b(Context context) {
        this.f42149b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public void a(long j6) {
        this.f42150c = j6;
    }

    public void a(Map<String, Object> map) {
        this.f42153f = map;
    }
}

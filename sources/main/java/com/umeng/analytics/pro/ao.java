package com.umeng.analytics.pro;

import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ao implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f40869a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b, reason: collision with root package name */
    private String f40870b;

    /* renamed from: c, reason: collision with root package name */
    private String f40871c;

    /* renamed from: d, reason: collision with root package name */
    private String f40872d;

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] a6 = am.a(this.f40870b, this.f40871c);
            if (a6 != null) {
                JSONObject jSONObject2 = new JSONObject(new String(a6));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f40872d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }

    public ao(String str, JSONObject jSONObject, String str2) {
        this.f40870b = str;
        this.f40871c = jSONObject.toString();
        this.f40872d = str2;
    }
}

package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ab extends z {

    /* renamed from: a, reason: collision with root package name */
    private String f40824a;

    /* renamed from: b, reason: collision with root package name */
    private String f40825b;

    public String d() {
        return this.f40824a;
    }

    public void c(String str) {
        this.f40824a = str;
    }

    public void d(String str) {
        this.f40825b = str;
    }

    public String e() {
        return this.f40825b;
    }

    public ab(String str, ArrayList<aa> arrayList) {
        super(str, arrayList);
        this.f40824a = "";
        this.f40825b = "";
    }

    @Override // com.umeng.analytics.pro.z, com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a6 = super.a(str, jSONObject);
        if (a6 != null) {
            try {
                a6.put(com.umeng.ccg.a.f41543s, this.f40824a);
                a6.put(com.umeng.ccg.a.f41544t, this.f40825b);
            } catch (Throwable unused) {
            }
        }
        return a6;
    }
}

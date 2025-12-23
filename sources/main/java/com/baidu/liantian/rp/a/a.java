package com.baidu.liantian.rp.a;

import com.baidu.liantian.b.e;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f10469a;

    /* renamed from: b, reason: collision with root package name */
    public String f10470b;

    /* renamed from: c, reason: collision with root package name */
    public String f10471c;

    /* renamed from: d, reason: collision with root package name */
    public String f10472d;

    /* renamed from: e, reason: collision with root package name */
    public String f10473e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f10469a);
            jSONObject.put("1", aVar.f10471c);
            jSONObject.put("2", aVar.f10472d);
            jSONObject.put("3", aVar.f10473e);
            jSONObject.put("4", aVar.f10470b);
        } catch (Throwable unused) {
            e.a();
        }
        return jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f10472d;
        if (str == null) {
            if (aVar.f10472d != null) {
                return false;
            }
        } else if (!str.equals(aVar.f10472d)) {
            return false;
        }
        String str2 = this.f10473e;
        if (str2 == null) {
            if (aVar.f10473e != null) {
                return false;
            }
        } else if (!str2.equals(aVar.f10473e)) {
            return false;
        }
        String str3 = this.f10470b;
        if (str3 == null) {
            if (aVar.f10470b != null) {
                return false;
            }
        } else if (!str3.equals(aVar.f10470b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f10472d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f10473e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10470b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f10469a = jSONObject.optString("0");
            aVar.f10471c = jSONObject.optString("1");
            aVar.f10472d = jSONObject.optString("2");
            aVar.f10473e = jSONObject.optString("3");
            aVar.f10470b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            e.a();
            return null;
        }
    }
}

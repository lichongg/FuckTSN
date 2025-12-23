package cn.jiguang.aw;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1813a = cn.jiguang.ax.a.b(new byte[]{120, 122, 100, 87, 73, 119, 65, 114});

    /* renamed from: b, reason: collision with root package name */
    public static final String f1814b = cn.jiguang.ax.a.b(new byte[]{97, 92, 85, 126, 97, 120, 95, 81, 77, 124});

    /* renamed from: c, reason: collision with root package name */
    public static final String f1815c = cn.jiguang.ax.a.b(new byte[]{111, 109, 100, 98, 89, 79, 119});

    /* renamed from: d, reason: collision with root package name */
    public static final String f1816d = cn.jiguang.ax.a.b(new byte[]{70, 69, 107, 123, Byte.MAX_VALUE, 126, 94, 110, 120, 101, 115});

    /* renamed from: e, reason: collision with root package name */
    public static final String f1817e = cn.jiguang.ax.a.b(new byte[]{123, 117, 5});

    /* renamed from: f, reason: collision with root package name */
    public static final String f1818f = cn.jiguang.ax.a.b(new byte[]{84, 79, 110, 102, 122, 126, 81, 68, 76, 122, 122});

    /* renamed from: g, reason: collision with root package name */
    public static final String f1819g = cn.jiguang.ax.a.b(new byte[]{110, Byte.MAX_VALUE, 125, 85, 110, 120, 101, 115});

    /* renamed from: h, reason: collision with root package name */
    public static final String f1820h = cn.jiguang.ax.a.b(new byte[]{110, Byte.MAX_VALUE, 125, 85, 115, 112, 114, 115});

    /* renamed from: i, reason: collision with root package name */
    public static final String f1821i = cn.jiguang.ax.a.b(new byte[]{117, 85, 83, 122});

    /* renamed from: j, reason: collision with root package name */
    public static final String f1822j = cn.jiguang.ax.a.b(new byte[]{83, 109, 105, 98, 100, 67});

    /* renamed from: k, reason: collision with root package name */
    public static final String f1823k = cn.jiguang.ax.a.b(new byte[]{82, 124, 120, 121, 99, 68, 115, 110, 97, 98, 114, 88});

    /* renamed from: l, reason: collision with root package name */
    public static final String f1824l = cn.jiguang.ax.a.b(new byte[]{93, 85, 117, 124, 111, 66, 71, 73, 109, 107, 126});

    /* renamed from: o, reason: collision with root package name */
    public int f1827o;

    /* renamed from: q, reason: collision with root package name */
    public int f1829q;

    /* renamed from: v, reason: collision with root package name */
    public int f1834v;

    /* renamed from: x, reason: collision with root package name */
    public String f1836x;

    /* renamed from: m, reason: collision with root package name */
    public int f1825m = 0;

    /* renamed from: n, reason: collision with root package name */
    public String f1826n = "";

    /* renamed from: p, reason: collision with root package name */
    public String f1828p = "";

    /* renamed from: r, reason: collision with root package name */
    public String f1830r = "";

    /* renamed from: s, reason: collision with root package name */
    public String f1831s = "";

    /* renamed from: t, reason: collision with root package name */
    public String f1832t = "";

    /* renamed from: u, reason: collision with root package name */
    public String f1833u = "";

    /* renamed from: w, reason: collision with root package name */
    public String f1835w = "";

    /* renamed from: y, reason: collision with root package name */
    public boolean f1837y = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1838z = false;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.ay.b.e("pif", "p i is empty.");
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jiguang.ay.b.g("pif", "p j i is empty.");
            return null;
        }
        c cVar = new c(jSONObject.toString());
        cVar.f1825m = jSONObject.optInt(f1813a);
        cVar.f1826n = jSONObject.optString(f1814b);
        cVar.f1833u = jSONObject.optString(f1819g);
        cVar.f1831s = jSONObject.optString(f1817e);
        cVar.f1827o = jSONObject.optInt(f1815c, 0);
        cVar.f1828p = jSONObject.optString(f1816d, "");
        cVar.f1829q = jSONObject.optInt(f1822j);
        cVar.f1830r = jSONObject.optString(f1818f);
        cVar.f1832t = jSONObject.optString(f1821i);
        cVar.f1834v = jSONObject.optInt(f1820h);
        cVar.f1837y = jSONObject.optBoolean(f1823k);
        cVar.f1838z = jSONObject.optBoolean(f1824l);
        return cVar;
    }

    public String toString() {
        return "P{pid=" + this.f1825m + ", pName='" + this.f1826n + "', vcode=" + this.f1827o + ", vname='" + this.f1828p + "', status=" + this.f1829q + ", dU='" + this.f1830r + "', m='" + this.f1831s + "', desc='" + this.f1832t + "', fileName='" + this.f1833u + "', fileSize=" + this.f1834v + ", pkgname='" + this.f1835w + "', reportSwitch='" + this.f1837y + "', multySwitch='" + this.f1838z + "'}";
    }

    public c(String str) {
        this.f1836x = str;
    }
}

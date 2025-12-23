package com.amap.api.col.p0003l;

import android.content.Context;
import com.huawei.hms.feature.dynamic.b;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ca extends y3<String, a> {

    /* renamed from: w, reason: collision with root package name */
    private boolean f5862w;

    /* renamed from: x, reason: collision with root package name */
    private int[] f5863x;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public String f5865b;

        /* renamed from: c, reason: collision with root package name */
        public String f5866c;

        /* renamed from: a, reason: collision with root package name */
        public int f5864a = -1;

        /* renamed from: d, reason: collision with root package name */
        public boolean f5867d = false;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0003l.y3
    protected final String l() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.y3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public a g(String str) throws fc {
        String str2;
        int i6;
        String str3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(b.f33209h)) {
                i6 = jSONObject.optInt(b.f33209h);
                str2 = jSONObject.optString("errmsg");
                str3 = jSONObject.optString("errdetail");
            } else {
                str2 = "";
                i6 = -1;
                str3 = "";
            }
            a aVar = new a();
            aVar.f5864a = i6;
            aVar.f5865b = str2;
            aVar.f5866c = str3;
            aVar.f5867d = false;
            for (int i7 : this.f5863x) {
                if (i7 == i6) {
                    aVar.f5867d = true;
                    return aVar;
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", f4.j(this.f7756t));
        if (this.f5862w) {
            hashtable.put("pname", "3dmap");
        }
        String a6 = h4.a();
        String c6 = h4.c(this.f7756t, a6, q4.r(hashtable));
        hashtable.put("ts", a6);
        hashtable.put("scode", c6);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return "http://restsdk.amap.com/v4" + this.f7757u;
    }

    public ca(Context context, String str) {
        super(context, str);
        this.f5863x = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        this.f7757u = "/feedback";
        this.isPostFlag = false;
        this.f5862w = true;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return b3.y(getURL());
    }
}

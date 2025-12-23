package com.amap.api.col.p0003l;

import android.content.Context;
import com.huawei.hms.feature.dynamic.b;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w1 extends y3<String, a> {
    private boolean A;
    private String B;

    /* renamed from: w, reason: collision with root package name */
    private String f7490w;

    /* renamed from: x, reason: collision with root package name */
    private String f7491x;

    /* renamed from: y, reason: collision with root package name */
    private String f7492y;

    /* renamed from: z, reason: collision with root package name */
    private final String f7493z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f7494a;

        /* renamed from: b, reason: collision with root package name */
        public int f7495b = -1;

        /* renamed from: c, reason: collision with root package name */
        public String f7496c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f7497d = false;
    }

    public w1(Context context, String str) {
        super(context, str);
        this.f7491x = "1.0";
        this.f7492y = "0";
        this.f7493z = "lastModified";
        this.A = false;
        this.B = null;
        this.f7757u = "/map/styles";
        this.f7758v = true;
    }

    @Override // com.amap.api.col.p0003l.y3
    protected final /* bridge */ /* synthetic */ a g(String str) throws fc {
        return null;
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
    public a f(z6 z6Var) throws fc {
        List<String> list;
        if (z6Var == null) {
            return null;
        }
        a h6 = h(z6Var.f7800a);
        h6.f7497d = h6.f7494a != null;
        Map<String, List<String>> map = z6Var.f7801b;
        if (map != null && map.containsKey("lastModified") && (list = z6Var.f7801b.get("lastModified")) != null && list.size() > 0) {
            h6.f7496c = list.get(0);
        }
        return h6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.y3
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public a h(byte[] bArr) throws fc {
        a aVar = new a();
        aVar.f7494a = bArr;
        if (this.A && bArr != null) {
            if (bArr.length == 0) {
                aVar.f7494a = null;
                return aVar;
            }
            if (bArr.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains(b.f33209h)) {
                        aVar.f7494a = null;
                        return aVar;
                    }
                } catch (Exception e6) {
                    v5.p(e6, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    public final void b(String str) {
        this.B = str;
    }

    public final void c(String str) {
        this.f7490w = str;
    }

    public final void d(String str) {
        this.f7492y = str;
    }

    @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", f4.j(this.f7756t));
        if (this.A) {
            hashtable.put("sdkType", this.B);
        } else {
            hashtable.put("output", "bin");
        }
        hashtable.put("styleid", this.f7490w);
        hashtable.put("protocol", this.f7491x);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.f7492y);
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

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return b3.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.y3, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        String str;
        p4 s5 = b3.s();
        if (s5 != null) {
            str = s5.e();
        } else {
            str = null;
        }
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", ga.f6366c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", str, "3dmap"));
        hashtable.put("x-INFO", h4.b(this.f7756t));
        hashtable.put("key", f4.j(this.f7756t));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    public w1(Context context, String str, boolean z5) {
        super(context, str);
        this.f7491x = "1.0";
        this.f7492y = "0";
        this.f7493z = "lastModified";
        this.B = null;
        this.A = z5;
        if (z5) {
            this.f7757u = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            this.f7757u = "/map/styles";
        }
        this.f7758v = true;
    }
}

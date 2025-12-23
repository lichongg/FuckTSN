package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.col.s.u2;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class dz {

    /* renamed from: d, reason: collision with root package name */
    u2.a f8012d;

    /* renamed from: h, reason: collision with root package name */
    private String f8016h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8017i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8018j;

    /* renamed from: a, reason: collision with root package name */
    int f8009a = 20000;

    /* renamed from: b, reason: collision with root package name */
    int f8010b = 20000;

    /* renamed from: c, reason: collision with root package name */
    Proxy f8011c = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8013e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f8014f = 20000;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8015g = true;

    /* renamed from: k, reason: collision with root package name */
    private a f8019k = a.NORMAL;

    /* renamed from: l, reason: collision with root package name */
    private b f8020l = b.FIRST_NONDEGRADE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);


        /* renamed from: h, reason: collision with root package name */
        private int f8036h;

        public final int a() {
            return this.f8036h;
        }

        public final boolean b() {
            int i6 = this.f8036h;
            return i6 == FIRST_NONDEGRADE.f8036h || i6 == NEVER_GRADE.f8036h || i6 == FIX_NONDEGRADE.f8036h;
        }

        public final boolean c() {
            int i6 = this.f8036h;
            return i6 == DEGRADE_BYERROR.f8036h || i6 == DEGRADE_ONLY.f8036h || i6 == FIX_DEGRADE_BYERROR.f8036h || i6 == FIX_DEGRADE_ONLY.f8036h;
        }

        public final boolean d() {
            int i6 = this.f8036h;
            return i6 == DEGRADE_BYERROR.f8036h || i6 == FIX_DEGRADE_BYERROR.f8036h;
        }

        public final boolean e() {
            return this.f8036h == NEVER_GRADE.f8036h;
        }

        b(int i6) {
            this.f8036h = i6;
        }
    }

    public final void D() {
        this.f8015g = false;
    }

    public abstract String h();

    public abstract Map<String, String> o();

    public abstract Map<String, String> p();

    public byte[] q() {
        return null;
    }

    public final void y() {
        this.f8013e = true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);


        /* renamed from: f, reason: collision with root package name */
        private int f8027f;

        a(int i6) {
            this.f8027f = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum c {
        HTTP(0),
        HTTPS(1);


        /* renamed from: c, reason: collision with root package name */
        private int f8040c;

        c(int i6) {
            this.f8040c = i6;
        }
    }

    private static String c(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return i(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            d2.e(th, "ht", "pnfh");
            return null;
        }
    }

    private static String i(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
                if (split.length > 1) {
                    int length = split.length;
                    int i6 = 0;
                    String str4 = "";
                    while (true) {
                        if (i6 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i6];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i6++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(s1.a(str3))) {
                                String[] split3 = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                                if (split3.length > 1) {
                                    s1.b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
            return str3;
        } catch (Throwable th) {
            d2.e(th, "ht", "pnfp");
            return str3;
        }
    }

    public final u2.a A() {
        return this.f8012d;
    }

    protected final b B() {
        return this.f8020l;
    }

    protected final int C() {
        return this.f8014f;
    }

    protected final String E() {
        return this.f8016h;
    }

    protected final boolean F() {
        return this.f8017i;
    }

    public final void d(int i6) {
        this.f8009a = i6;
    }

    public final void e(a aVar) {
        this.f8019k = aVar;
    }

    public final void f(b bVar) {
        this.f8020l = bVar;
    }

    public final void g(c cVar) {
        this.f8018j = cVar == c.HTTPS;
    }

    public final void j(int i6) {
        this.f8010b = i6;
    }

    protected boolean k() {
        return this.f8015g;
    }

    public final void l(int i6) {
        this.f8014f = i6;
    }

    public String m() {
        return "";
    }

    public final void n(String str) {
        this.f8016h = str;
    }

    protected String r() {
        return "";
    }

    public final int u() {
        return this.f8009a;
    }

    public final Proxy v() {
        return this.f8011c;
    }

    protected final a w() {
        return this.f8019k;
    }

    protected final boolean x() {
        return this.f8013e;
    }

    protected final boolean z() {
        return this.f8018j;
    }

    private String b(String str) {
        byte[] q5 = q();
        if (q5 != null && q5.length != 0) {
            Map<String, String> o5 = o();
            HashMap<String, String> hashMap = u2.f8511e;
            if (hashMap != null) {
                if (o5 != null) {
                    o5.putAll(hashMap);
                } else {
                    o5 = hashMap;
                }
            }
            if (o5 != null) {
                String h6 = x2.h(o5);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append("?");
                stringBuffer.append(h6);
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    protected final String G() {
        String str;
        try {
            str = m();
            try {
                if (TextUtils.isEmpty(str)) {
                    if (this.f8013e) {
                        return i(((v2) this).N());
                    }
                    return c(p());
                }
                return str;
            } catch (Throwable th) {
                th = th;
                d2.e(th, "ht", "pnfr");
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
    }

    public String a() {
        return h();
    }

    final String s() {
        return b(h());
    }

    final String t() {
        return b(a());
    }
}

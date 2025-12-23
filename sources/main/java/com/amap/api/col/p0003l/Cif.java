package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.amap.api.col.p0003l.r6;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* renamed from: com.amap.api.col.3l.if, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class Cif {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* renamed from: d, reason: collision with root package name */
    private String f6579d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6580e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6581f;

    /* renamed from: o, reason: collision with root package name */
    r6.a f6587o;

    /* renamed from: l, reason: collision with root package name */
    int f6584l = 20000;

    /* renamed from: m, reason: collision with root package name */
    int f6585m = 20000;

    /* renamed from: n, reason: collision with root package name */
    Proxy f6586n = null;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6576a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f6577b = 20000;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6578c = true;

    /* renamed from: g, reason: collision with root package name */
    private a f6582g = a.NORMAL;

    /* renamed from: h, reason: collision with root package name */
    private b f6583h = b.FIRST_NONDEGRADE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.col.3l.if$b */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);


        /* renamed from: h, reason: collision with root package name */
        private int f6603h;

        public final int a() {
            return this.f6603h;
        }

        public final boolean b() {
            int i6 = this.f6603h;
            return i6 == FIRST_NONDEGRADE.f6603h || i6 == NEVER_GRADE.f6603h || i6 == FIX_NONDEGRADE.f6603h;
        }

        public final boolean c() {
            int i6 = this.f6603h;
            return i6 == DEGRADE_BYERROR.f6603h || i6 == DEGRADE_ONLY.f6603h || i6 == FIX_DEGRADE_BYERROR.f6603h || i6 == FIX_DEGRADE_ONLY.f6603h;
        }

        public final boolean d() {
            int i6 = this.f6603h;
            return i6 == DEGRADE_BYERROR.f6603h || i6 == FIX_DEGRADE_BYERROR.f6603h;
        }

        public final boolean e() {
            return this.f6603h == NEVER_GRADE.f6603h;
        }

        b(int i6) {
            this.f6603h = i6;
        }
    }

    public byte[] getEntityBytes() {
        return null;
    }

    public abstract Map<String, String> getParams();

    public abstract Map<String, String> getRequestHead();

    public abstract String getURL();

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.col.3l.if$a */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);


        /* renamed from: f, reason: collision with root package name */
        private int f6594f;

        a(int i6) {
            this.f6594f = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.col.3l.if$c */
    public enum c {
        HTTP(0),
        HTTPS(1);


        /* renamed from: c, reason: collision with root package name */
        private int f6607c;

        c(int i6) {
            this.f6607c = i6;
        }
    }

    public int getConntectionTimeout() {
        return this.f6584l;
    }

    protected a getDegradeAbility() {
        return this.f6582g;
    }

    protected b getDegradeType() {
        return this.f6583h;
    }

    protected String getIPDNSName() {
        return "";
    }

    protected String getNon_degrade_final_Host() {
        return this.f6579d;
    }

    public Proxy getProxy() {
        return this.f6586n;
    }

    protected int getReal_max_timeout() {
        return this.f6577b;
    }

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.f6585m;
    }

    public r6.a getUrlConnectionImpl() {
        return this.f6587o;
    }

    protected boolean isBinary() {
        return this.f6576a;
    }

    protected boolean isHostToIP() {
        return this.f6578c;
    }

    protected boolean isHttps() {
        return this.f6581f;
    }

    protected boolean isIPV6Request() {
        return this.f6580e;
    }

    protected String parseSDKNameFromPlatInfo(String str) {
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
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(f5.a(str3))) {
                                String[] split3 = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                                if (split3.length > 1) {
                                    f5.b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
            return str3;
        } catch (Throwable th) {
            r5.e(th, "ht", "pnfp");
            return str3;
        }
    }

    protected String parseSdkNameFromHeader(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            r5.e(th, "ht", "pnfh");
            return null;
        }
    }

    public void setBinary(boolean z5) {
        this.f6576a = z5;
    }

    public final void setConnectionTimeout(int i6) {
        this.f6584l = i6;
    }

    public void setDegradeAbility(a aVar) {
        this.f6582g = aVar;
    }

    public void setDegradeType(b bVar) {
        this.f6583h = bVar;
    }

    public void setHostToIP(boolean z5) {
        this.f6578c = z5;
    }

    public void setHttpProtocol(c cVar) {
        this.f6581f = cVar == c.HTTPS;
    }

    public void setIPV6Request(boolean z5) {
        this.f6580e = z5;
    }

    public void setNon_degrade_final_Host(String str) {
        this.f6579d = str;
    }

    public final void setProxy(Proxy proxy) {
        this.f6586n = proxy;
    }

    public void setReal_max_timeout(int i6) {
        this.f6577b = i6;
    }

    public final void setSoTimeout(int i6) {
        this.f6585m = i6;
    }

    public void setUrlConnectionImpl(r6.a aVar) {
        this.f6587o = aVar;
    }

    private String e(String str) {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes != null && entityBytes.length != 0) {
            Map<String, String> params = getParams();
            HashMap<String, String> hashMap = r6.f7187e;
            if (hashMap != null) {
                if (params != null) {
                    params.putAll(hashMap);
                } else {
                    params = hashMap;
                }
            }
            if (params != null) {
                String i6 = w6.i(params);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append("?");
                stringBuffer.append(i6);
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    final String a() {
        return e(getURL());
    }

    final String b() {
        return e(getIPV6URL());
    }

    public String getIPV6URL() {
        return getURL();
    }

    protected boolean isIPRequest() {
        if (!TextUtils.isEmpty(getIPDNSName())) {
            return true;
        }
        return false;
    }

    protected String parseSdkNameFromRequest() {
        String str;
        try {
            str = getSDKName();
            try {
                if (TextUtils.isEmpty(str)) {
                    if (this.f6576a) {
                        return parseSDKNameFromPlatInfo(((s6) this).g());
                    }
                    return parseSdkNameFromHeader(getRequestHead());
                }
                return str;
            } catch (Throwable th) {
                th = th;
                r5.e(th, "ht", "pnfr");
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
    }
}

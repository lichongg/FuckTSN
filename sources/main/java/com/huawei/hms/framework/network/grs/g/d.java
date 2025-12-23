package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.qq.e.comm.constants.ErrorCode;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class d {

    /* renamed from: o, reason: collision with root package name */
    private static final String f33458o = "d";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, List<String>> f33459a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f33460b;

    /* renamed from: c, reason: collision with root package name */
    private int f33461c;

    /* renamed from: d, reason: collision with root package name */
    private long f33462d;

    /* renamed from: e, reason: collision with root package name */
    private long f33463e;

    /* renamed from: f, reason: collision with root package name */
    private long f33464f;

    /* renamed from: g, reason: collision with root package name */
    private String f33465g;

    /* renamed from: h, reason: collision with root package name */
    private int f33466h;

    /* renamed from: i, reason: collision with root package name */
    private int f33467i;

    /* renamed from: j, reason: collision with root package name */
    private String f33468j;

    /* renamed from: k, reason: collision with root package name */
    private long f33469k;

    /* renamed from: l, reason: collision with root package name */
    private String f33470l;

    /* renamed from: m, reason: collision with root package name */
    private Exception f33471m;

    /* renamed from: n, reason: collision with root package name */
    private String f33472n;

    public d(int i6, Map<String, List<String>> map, byte[] bArr, long j6) {
        this.f33466h = 2;
        this.f33467i = ErrorCode.PrivateError.LOAD_FAIL;
        this.f33468j = "";
        this.f33469k = 0L;
        this.f33470l = "";
        this.f33461c = i6;
        this.f33459a = map;
        this.f33460b = ByteBuffer.wrap(bArr).array();
        this.f33462d = j6;
        H();
    }

    public d(Exception exc, long j6) {
        this.f33461c = 0;
        this.f33466h = 2;
        this.f33467i = ErrorCode.PrivateError.LOAD_FAIL;
        this.f33468j = "";
        this.f33469k = 0L;
        this.f33470l = "";
        this.f33471m = exc;
        this.f33462d = j6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0054, code lost:
    
        if (r9.getInt("resultCode") == 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E() {
        /*
            r10 = this;
            java.lang.String r0 = "errorList"
            java.lang.String r1 = "errorDesc"
            java.lang.String r2 = "errorCode"
            java.lang.String r3 = "resultCode"
            java.lang.String r4 = "isSuccess"
            boolean r5 = r10.B()
            r6 = 1
            if (r5 == 0) goto L1c
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.d.f33458o
            java.lang.String r1 = "GRSSDK get httpcode{304} not any changed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r10.l(r6)
            return
        L1c:
            boolean r5 = r10.D()
            r7 = 2
            if (r5 != 0) goto L2e
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.d.f33458o
            java.lang.String r1 = "GRSSDK parse server body all failed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r10.l(r7)
            return
        L2e:
            r5 = 0
            byte[] r8 = r10.f33460b     // Catch: org.json.JSONException -> L47
            java.lang.String r8 = com.huawei.hms.framework.common.StringUtils.byte2Str(r8)     // Catch: org.json.JSONException -> L47
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> L47
            r9.<init>(r8)     // Catch: org.json.JSONException -> L47
            boolean r8 = r9.has(r4)     // Catch: org.json.JSONException -> L47
            if (r8 == 0) goto L4a
            int r3 = r9.getInt(r4)     // Catch: org.json.JSONException -> L47
            if (r3 != r6) goto L58
            goto L56
        L47:
            r0 = move-exception
            goto Lba
        L4a:
            boolean r4 = r9.has(r3)     // Catch: org.json.JSONException -> L47
            if (r4 == 0) goto L5a
            int r3 = r9.getInt(r3)     // Catch: org.json.JSONException -> L47
            if (r3 != 0) goto L58
        L56:
            r3 = 1
            goto L62
        L58:
            r3 = 2
            goto L62
        L5a:
            java.lang.String r3 = com.huawei.hms.framework.network.grs.g.d.f33458o     // Catch: org.json.JSONException -> L47
            java.lang.String r4 = "sth. wrong because server errorcode's key."
            com.huawei.hms.framework.common.Logger.e(r3, r4)     // Catch: org.json.JSONException -> L47
            r3 = -1
        L62:
            java.lang.String r4 = "services"
            if (r3 == r6) goto L6d
            boolean r8 = r9.has(r4)     // Catch: org.json.JSONException -> L47
            if (r8 == 0) goto L6d
            r3 = 0
        L6d:
            r10.l(r3)     // Catch: org.json.JSONException -> L47
            java.lang.String r8 = ""
            if (r3 == r6) goto L95
            if (r3 != 0) goto L77
            goto L95
        L77:
            boolean r0 = r9.has(r2)     // Catch: org.json.JSONException -> L47
            if (r0 == 0) goto L82
            int r0 = r9.getInt(r2)     // Catch: org.json.JSONException -> L47
            goto L84
        L82:
            r0 = 9001(0x2329, float:1.2613E-41)
        L84:
            r10.g(r0)     // Catch: org.json.JSONException -> L47
            boolean r0 = r9.has(r1)     // Catch: org.json.JSONException -> L47
            if (r0 == 0) goto L91
            java.lang.String r8 = r9.getString(r1)     // Catch: org.json.JSONException -> L47
        L91:
            r10.q(r8)     // Catch: org.json.JSONException -> L47
            return
        L95:
            boolean r1 = r9.has(r4)     // Catch: org.json.JSONException -> L47
            if (r1 == 0) goto La4
            org.json.JSONObject r1 = r9.getJSONObject(r4)     // Catch: org.json.JSONException -> L47
            java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> L47
            goto La5
        La4:
            r1 = r8
        La5:
            r10.u(r1)     // Catch: org.json.JSONException -> L47
            boolean r1 = r9.has(r0)     // Catch: org.json.JSONException -> L47
            if (r1 == 0) goto Lb6
            org.json.JSONObject r0 = r9.getJSONObject(r0)     // Catch: org.json.JSONException -> L47
            java.lang.String r8 = r0.toString()     // Catch: org.json.JSONException -> L47
        Lb6:
            r10.s(r8)     // Catch: org.json.JSONException -> L47
            return
        Lba:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.g.d.f33458o
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            java.lang.Object[] r2 = new java.lang.Object[r6]
            r2[r5] = r0
            java.lang.String r0 = "GrsResponse GrsResponse(String result) JSONException: %s"
            com.huawei.hms.framework.common.Logger.w(r1, r0, r2)
            r10.l(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.E():void");
    }

    private Map<String, String> G() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f33459a;
        if (map == null || map.size() <= 0) {
            Logger.v(f33458o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : this.f33459a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                hashMap.put(key, it.next());
            }
        }
        return hashMap;
    }

    private void e(Map<String, String> map) {
        if (!map.containsKey("ETag")) {
            Logger.i(f33458o, "Response Heads has not Etag");
            return;
        }
        String str = map.get("ETag");
        if (TextUtils.isEmpty(str)) {
            Logger.i(f33458o, "The Response Heads Etag is Empty");
        } else {
            Logger.i(f33458o, "success get Etag from server");
            d(str);
        }
    }

    private void g(int i6) {
        this.f33467i = i6;
    }

    private void j(Map<String, String> map) {
        long time;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                } catch (NumberFormatException e6) {
                    e = e6;
                    time = 0;
                }
                try {
                    Logger.v(f33458o, "Cache-Control value{%s}", Long.valueOf(time));
                } catch (NumberFormatException e7) {
                    e = e7;
                    Logger.w(f33458o, "getExpireTime addHeadersToResult NumberFormatException", e);
                    if (time > 0) {
                    }
                    time = 86400;
                    long j6 = time * 1000;
                    Logger.i(f33458o, "convert expireTime{%s}", Long.valueOf(j6));
                    n(String.valueOf(j6 + System.currentTimeMillis()));
                }
            }
            time = 0;
        } else {
            if (map.containsKey("Expires")) {
                String str2 = map.get("Expires");
                Logger.v(f33458o, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = map.containsKey("Date") ? map.get("Date") : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e8) {
                    Logger.w(f33458o, "getExpireTime ParseException.", e8);
                }
            } else {
                Logger.i(f33458o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time > 0 || time > 2592000) {
            time = 86400;
        }
        long j62 = time * 1000;
        Logger.i(f33458o, "convert expireTime{%s}", Long.valueOf(j62));
        n(String.valueOf(j62 + System.currentTimeMillis()));
    }

    private void l(int i6) {
        this.f33466h = i6;
    }

    private void m(long j6) {
        this.f33469k = j6;
    }

    private void n(String str) {
        this.f33468j = str;
    }

    private void o(Map<String, String> map) {
        long j6;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j6 = Long.parseLong(str);
                } catch (NumberFormatException e6) {
                    Logger.w(f33458o, "getRetryAfter addHeadersToResult NumberFormatException", e6);
                }
                long j7 = j6 * 1000;
                Logger.v(f33458o, "convert retry-afterTime{%s}", Long.valueOf(j7));
                m(j7);
            }
        }
        j6 = 0;
        long j72 = j6 * 1000;
        Logger.v(f33458o, "convert retry-afterTime{%s}", Long.valueOf(j72));
        m(j72);
    }

    private void u(String str) {
        this.f33465g = str;
    }

    public String A() {
        return this.f33472n;
    }

    public boolean B() {
        return this.f33461c == 304;
    }

    public boolean C() {
        return this.f33461c == 503;
    }

    public boolean D() {
        return this.f33461c == 200;
    }

    public String a() {
        return this.f33468j;
    }

    public void c(long j6) {
        this.f33464f = j6;
    }

    public void d(String str) {
        this.f33470l = str;
    }

    public int f() {
        return this.f33461c;
    }

    public void h(long j6) {
        this.f33463e = j6;
    }

    public void i(String str) {
        this.f33472n = str;
    }

    public int k() {
        return this.f33467i;
    }

    public Exception p() {
        return this.f33471m;
    }

    public String r() {
        return this.f33470l;
    }

    public int t() {
        return this.f33466h;
    }

    public long v() {
        return this.f33464f;
    }

    public long w() {
        return this.f33463e;
    }

    public long x() {
        return this.f33462d;
    }

    public String y() {
        return this.f33465g;
    }

    public long z() {
        return this.f33469k;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[Catch: JSONException -> 0x0032, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0032, blocks: (B:14:0x0025, B:16:0x002b, B:19:0x003a, B:21:0x0040, B:25:0x0034), top: B:13:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F() {
        /*
            r4 = this;
            boolean r0 = r4.D()
            if (r0 != 0) goto L13
            boolean r0 = r4.C()
            if (r0 != 0) goto L13
            boolean r0 = r4.B()
            if (r0 != 0) goto L13
            goto L43
        L13:
            java.util.Map r0 = r4.G()
            int r1 = r0.size()
            if (r1 > 0) goto L25
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.d.f33458o
            java.lang.String r1 = "parseHeader {headers.size() <= 0}"
            com.huawei.hms.framework.common.Logger.w(r0, r1)
            return
        L25:
            boolean r1 = r4.D()     // Catch: org.json.JSONException -> L32
            if (r1 != 0) goto L34
            boolean r1 = r4.B()     // Catch: org.json.JSONException -> L32
            if (r1 == 0) goto L3a
            goto L34
        L32:
            r0 = move-exception
            goto L44
        L34:
            r4.j(r0)     // Catch: org.json.JSONException -> L32
            r4.e(r0)     // Catch: org.json.JSONException -> L32
        L3a:
            boolean r1 = r4.C()     // Catch: org.json.JSONException -> L32
            if (r1 == 0) goto L43
            r4.o(r0)     // Catch: org.json.JSONException -> L32
        L43:
            return
        L44:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.g.d.f33458o
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r0
            java.lang.String r0 = "parseHeader catch JSONException: %s"
            com.huawei.hms.framework.common.Logger.w(r1, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.F():void");
    }

    private void H() {
        F();
        E();
    }

    private void q(String str) {
    }

    private void s(String str) {
    }

    public void b(int i6) {
    }
}

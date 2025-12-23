package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.b8;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.r6;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f10144a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f10145b = 2;

    /* renamed from: e, reason: collision with root package name */
    private static a f10146e;

    /* renamed from: j, reason: collision with root package name */
    private Context f10153j;

    /* renamed from: k, reason: collision with root package name */
    private String f10154k;

    /* renamed from: c, reason: collision with root package name */
    private long f10147c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10148d = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<String> f10149f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private com.autonavi.aps.amapapi.d f10150g = new com.autonavi.aps.amapapi.d();

    /* renamed from: h, reason: collision with root package name */
    private com.autonavi.aps.amapapi.d f10151h = new com.autonavi.aps.amapapi.d();

    /* renamed from: i, reason: collision with root package name */
    private long f10152i = 120000;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10155l = false;

    private String e(int i6) {
        String str;
        int i7 = 0;
        b(false, i6);
        String[] a6 = b(i6).a();
        if (a6 == null || a6.length <= 0) {
            g(i6);
            return b(i6).b();
        }
        int length = a6.length;
        while (true) {
            if (i7 >= length) {
                str = null;
                break;
            }
            str = a6[i7];
            if (!this.f10149f.contains(str)) {
                break;
            }
            i7++;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b(i6).a(str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.autonavi.aps.amapapi.d b(int i6) {
        return i6 == f10145b ? this.f10151h : this.f10150g;
    }

    private static String c(int i6) {
        return i6 == f10145b ? "last_ip_6" : "last_ip_4";
    }

    private void g(int i6) {
        String a6 = i.a(this.f10153j, "cbG9jaXA", c(i6), (String) null);
        if (TextUtils.isEmpty(a6) || this.f10149f.contains(a6)) {
            return;
        }
        b(i6).a(a6);
        b(i6).b(a6);
        b(i6).a(true);
    }

    private a(Context context) {
        this.f10153j = context;
    }

    private void d(int i6) {
        if (b(i6).d()) {
            SharedPreferences.Editor a6 = i.a(this.f10153j, "cbG9jaXA");
            i.a(a6, c(i6));
            i.a(a6);
            b(i6).a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i6) {
        if (b(i6).a() != null && b(i6).a().length > 0) {
            String str = b(i6).a()[0];
            if (!str.equals(this.f10154k) && !this.f10149f.contains(str)) {
                this.f10154k = str;
                SharedPreferences.Editor a6 = i.a(this.f10153j, "cbG9jaXA");
                i.a(a6, c(i6), str);
                i.a(a6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (!strArr[i6].equals(strArr2[i6])) {
                return false;
            }
        }
        return true;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f10146e == null) {
                    f10146e = new a(context);
                }
                aVar = f10146e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final String a(d dVar, int i6) {
        try {
            if (com.autonavi.aps.amapapi.utils.a.q() && dVar != null) {
                String url = dVar.getURL();
                String host = new URL(url).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(url) && !"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    if (!g4.U(str)) {
                        return null;
                    }
                    String e6 = e(i6);
                    if (!TextUtils.isEmpty(e6)) {
                        dVar.c(url.replace(host, e6));
                        dVar.getRequestHead().put("host", str);
                        dVar.d(str);
                        dVar.setIPV6Request(i6 == f10145b);
                        return e6;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private synchronized void b(boolean z5, final int i6) {
        if (!z5) {
            if (!com.autonavi.aps.amapapi.utils.a.p() && this.f10155l) {
                return;
            }
        }
        if (this.f10147c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j6 = this.f10147c;
            if (currentTimeMillis - j6 < this.f10152i) {
                return;
            }
            if (currentTimeMillis - j6 < 60000) {
                return;
            }
        }
        this.f10147c = System.currentTimeMillis();
        this.f10155l = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
        }
        a8.h().b(new b8() { // from class: com.autonavi.aps.amapapi.trans.a.1
            @Override // com.amap.api.col.p0003l.b8
            public final void runTask() {
                int i7;
                StringBuilder sb = new StringBuilder(JPushConstants.HTTP_PRE);
                sb.append(com.autonavi.aps.amapapi.utils.a.r());
                sb.append("?host=dualstack-a.apilocate.amap.com&query=");
                sb.append(i6 == a.f10145b ? 6 : 4);
                String sb2 = sb.toString();
                b bVar = new b();
                bVar.a(sb2);
                bVar.b(sb2);
                bVar.setDegradeAbility(Cif.a.SINGLE);
                bVar.setHttpProtocol(Cif.c.HTTP);
                try {
                    r6.b();
                    JSONObject jSONObject = new JSONObject(new String(r6.d(bVar).f7800a));
                    String[] b6 = a.b(jSONObject.optJSONArray("ips"), a.f10144a);
                    if (b6 != null && b6.length > 0 && !a.b(b6, a.this.b(a.f10144a).a())) {
                        a.this.b(a.f10144a).a(b6);
                        a.this.f(a.f10144a);
                    }
                    String[] b7 = a.b(jSONObject.optJSONArray("ipsv6"), a.f10145b);
                    if (b7 != null && b7.length > 0 && !a.b(b7, a.this.b(a.f10145b).a())) {
                        a.this.b(a.f10145b).a(b7);
                        a.this.f(a.f10145b);
                    }
                    if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has(RtspHeaders.Values.TTL) && (i7 = jSONObject.getInt(RtspHeaders.Values.TTL)) > 30) {
                        a.this.f10152i = i7 * 1000;
                    }
                } catch (Throwable th) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("key", "dnsError");
                        jSONObject2.put(MediationConstant.KEY_REASON, th.getMessage());
                    } catch (Throwable unused) {
                    }
                    h.a(a.this.f10153j, "O018", jSONObject2);
                }
            }
        });
    }

    public final void a(int i6) {
        if (!b(i6).e()) {
            this.f10149f.add(b(i6).b());
            d(i6);
            b(true, i6);
            return;
        }
        d(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] b(JSONArray jSONArray, int i6) throws JSONException {
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i7 = 0; i7 < length; i7++) {
                String string = jSONArray.getString(i7);
                if (!TextUtils.isEmpty(string)) {
                    if (i6 == f10145b) {
                        string = "[" + string + "]";
                    }
                    strArr[i7] = string;
                }
            }
            return strArr;
        }
        return new String[0];
    }

    public final void a(boolean z5, int i6) {
        b(i6).b(z5);
        if (z5) {
            String c6 = b(i6).c();
            String b6 = b(i6).b();
            if (TextUtils.isEmpty(b6) || b6.equals(c6)) {
                return;
            }
            SharedPreferences.Editor a6 = i.a(this.f10153j, "cbG9jaXA");
            i.a(a6, c(i6), b6);
            i.a(a6);
        }
    }
}

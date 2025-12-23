package cn.jiguang.al;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.bz.w;
import cn.jiguang.m.c;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.bn;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static String f1606a = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1607c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f1608d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedList<String> f1609e;

    /* renamed from: b, reason: collision with root package name */
    private Context f1610b;

    /* renamed from: cn.jiguang.al.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f1612b;

        public a(Context context) {
            this.f1612b = context;
            this.f2653h = "JLocationHelper#RequestConfigAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            f.a().d(this.f1612b);
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final f f1613a = new f(null);
    }

    private f() {
    }

    public static f a() {
        return b.f1613a;
    }

    private boolean f(Context context) {
        try {
            String[] split = e.f1601k.split(",");
            if (split != null && split.length != 0) {
                Iterator<PackageInfo> it = cn.jiguang.common.app.helper.b.a().iterator();
                while (it.hasNext()) {
                    ServiceInfo[] serviceInfoArr = it.next().services;
                    if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            for (String str : split) {
                                if (str.equals(serviceInfo.name)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void b(Context context) {
        this.f1610b = cn.jiguang.bz.d.a(context);
    }

    public Integer c() {
        return null;
    }

    static {
        String b6 = cn.jiguang.bz.l.b(new byte[]{113, 124, 98, 97, 67, 26, 54, 39, 112, 114, 81, 80, 112, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, Ascii.US, 76, 123, 123, 57, 103, 1, 15, 120, 120, 102, 118, 71, 67, 54, 123, 98, 112, 68, 85, 106});
        f1607c = b6;
        String b7 = cn.jiguang.bz.l.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 110, 117, 112, SignedBytes.MAX_POWER_OF_TWO, 73, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 125, 82, 83, 54, 126, 39, 62, 81, 80, 105, 111, 97, 114, Ascii.US, 83, 109, 105, 98, 100, 67});
        f1608d = b7;
        LinkedList<String> linkedList = new LinkedList<>();
        f1609e = linkedList;
        linkedList.clear();
        f1609e.add(b6);
        f1609e.add(b7);
    }

    /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void a(Context context) {
        String m6 = cn.jiguang.m.b.m(context);
        cn.jiguang.bb.f.c("JLocationHelper", "locationConfig:" + m6);
        a(context, m6);
    }

    public boolean b() {
        try {
            for (String str : e.f1600j.split(",")) {
                if (cn.jiguang.bz.a.h(this.f1610b, str)) {
                    cn.jiguang.bb.f.c("JLocationHelper", "checkSafeStatus pkgName = " + str);
                    return false;
                }
            }
            if (TextUtils.isEmpty(e.f1600j)) {
                return true;
            }
            List<cn.jiguang.common.app.entity.b> a6 = cn.jiguang.common.app.helper.b.a(this.f1610b, true, false);
            if (a6 == null || a6.size() <= 0) {
                return false;
            }
            return !f(this.f1610b);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JLocationHelper", "checkSafeStatus error:" + th);
            return false;
        }
    }

    public void c(Context context) {
        try {
            cn.jiguang.be.b.e(new a(context));
        } catch (Throwable th) {
            cn.jiguang.bb.f.l("JLocationHelper", "updateImmediately failed: " + th.getMessage());
        }
    }

    public String e(Context context) {
        int i6;
        try {
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JLocationHelper", "request l config exception:" + th.getMessage());
        }
        if (!cn.jiguang.d.b.a(context)) {
            cn.jiguang.bb.f.i("JLocationHelper", "request l config failed because is not validRegistered");
            return null;
        }
        String a6 = cn.jiguang.ba.a.a(context);
        if (TextUtils.isEmpty(a6)) {
            cn.jiguang.bb.f.i("JLocationHelper", "request l config failed because can't get appKey");
            return null;
        }
        long f6 = cn.jiguang.d.a.f(context);
        if (f6 == 0) {
            cn.jiguang.bb.f.i("JLocationHelper", "request l config failed because can't get uid");
            return null;
        }
        String j6 = cn.jiguang.d.a.j(context);
        if (TextUtils.isEmpty(j6)) {
            cn.jiguang.bb.f.i("JLocationHelper", "request l config failed because need register first");
            return null;
        }
        cn.jiguang.m.b.e(context, "JLocationHelper");
        w.a(context, f1609e);
        Iterator<String> it = f1609e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", a6);
            jSONObject.put("uid", f6);
            jSONObject.put("platform", "a");
            jSONObject.put("user_enable", cn.jiguang.m.b.l(context, "JLocation"));
            jSONObject.put("rom", cn.jiguang.u.e.a(context));
            jSONObject.put("manufacturer", cn.jiguang.bz.a.a().B(context));
            jSONObject.put(bn.f10753i, cn.jiguang.bz.a.a().y(context));
            try {
                i6 = Integer.valueOf(cn.jiguang.v.d.a().c(context)).intValue();
            } catch (Throwable unused) {
                i6 = -1;
            }
            jSONObject.put("osversion", i6);
            jSONObject.put("itime", System.currentTimeMillis());
            jSONObject.put("apitype", 0);
            jSONObject.put("coreversion", cn.jiguang.a.a.f1444b);
            cn.jiguang.bb.f.c("JLocationHelper", "url:" + next + ", param json:" + jSONObject.toString());
            String e6 = w.e(jSONObject.toString());
            String e7 = w.e(f6 + w.e(j6) + e6);
            if (TextUtils.isEmpty(e7)) {
                return null;
            }
            String encodeToString = Base64.encodeToString((f6 + ":" + e7).getBytes(), 10);
            if (TextUtils.isEmpty(encodeToString)) {
                return null;
            }
            HttpRequest httpRequest = new HttpRequest(next);
            httpRequest.setRequestProperty("Content-Type", "application/json");
            httpRequest.setRequestProperty("Accept", "application/json");
            httpRequest.setRequestProperty("X-Http-Platform", FaceEnvironment.OS);
            httpRequest.setRequestProperty("X-Http-Appkey", a6);
            httpRequest.setRequestProperty("Authorization", "Basic " + encodeToString);
            httpRequest.setRequestProperty("Charset", "UTF-8");
            httpRequest.setBody(cn.jiguang.d.a.b(jSONObject.toString()));
            HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
            int responseCode = httpPost.getResponseCode();
            cn.jiguang.bb.f.c("JLocationHelper", "responseCode:" + responseCode);
            String responseBody = httpPost.getResponseBody();
            cn.jiguang.bb.f.c("JLocationHelper", "responseBody:" + responseBody);
            if (200 == responseCode && !TextUtils.isEmpty(responseBody)) {
                String c6 = cn.jiguang.d.a.c(responseBody);
                cn.jiguang.bb.f.c("JLocationHelper", "request l config success,response body:" + c6);
                return c6;
            }
        }
        return null;
    }

    public static void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.bb.f.c("JLocationHelper", "parseConfig empty");
                return;
            }
            cn.jiguang.bb.f.c("JLocationHelper", "parseConfig:" + str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("code") != 0) {
                cn.jiguang.m.b.b(context, "JLocationv2_g", e.f1595e * 1000);
                cn.jiguang.m.b.b(context, "JLocationv2_w", e.f1594d * 1000);
                cn.jiguang.m.b.b(context, "JLocationv2_c", e.f1596f * 1000);
                cn.jiguang.m.b.c(context, "JLocationHelper", e.f1602l * 1000);
                return;
            }
            e.f1600j = jSONObject.optString("pkgList", "");
            e.f1601k = jSONObject.optString("servList", "");
            String optString = jSONObject.optString("enable", "0,0,0");
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                if (split.length >= 3) {
                    e.f1592b = split[0].equals("1");
                    e.f1591a = split[1].equals("1");
                    e.f1593c = split[2].equals("1");
                }
            }
            e.f1602l = jSONObject.optInt("r_interval", 3600);
            cn.jiguang.m.b.c(context, "JLocationv2", r15 * 1000);
            String optString2 = jSONObject.optString("b_interval", "800,800,800");
            if (!TextUtils.isEmpty(optString2)) {
                try {
                    String[] split2 = optString2.split(",");
                    if (split2.length >= 3) {
                        e.f1595e = Integer.parseInt(split2[0]);
                        e.f1594d = Integer.parseInt(split2[1]);
                        e.f1596f = Integer.parseInt(split2[2]);
                        cn.jiguang.m.b.b(context, "JLocationv2_g", e.f1595e * 1000);
                        cn.jiguang.m.b.b(context, "JLocationv2_w", e.f1594d * 1000);
                        cn.jiguang.m.b.b(context, "JLocationv2_c", e.f1596f * 1000);
                    }
                } catch (Throwable th) {
                    cn.jiguang.bb.f.i("JLocationHelper", "parseConfig parse interval error:" + th);
                }
            }
            e.f1598h = jSONObject.optInt("wi_level", -90);
            e.f1597g = jSONObject.optInt("wi_count", 20);
            e.f1599i = jSONObject.optInt("wi_percent", 30);
            e.f1603m = jSONObject.optInt("g_interval", 240);
            e.f1604n = jSONObject.optInt("g_distance", 800);
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("JLocationHelper", "parseConfig error:" + th2);
            cn.jiguang.m.b.b(context, "JLocationv2_g", (long) (e.f1595e * 1000));
            cn.jiguang.m.b.b(context, "JLocationv2_w", (long) (e.f1594d * 1000));
            cn.jiguang.m.b.b(context, "JLocationv2_c", (long) (e.f1596f * 1000));
            cn.jiguang.m.b.c(context, "JLocationHelper", e.f1602l * 1000);
        }
    }

    public boolean d(Context context) {
        String e6 = e(context);
        if (!TextUtils.isEmpty(e6)) {
            a(context, e6);
            cn.jiguang.m.b.w(context, e6);
            return true;
        }
        return false;
    }

    public static void a(LinkedList<String> linkedList) {
        if (!c.a.f3097a || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        cn.jiguang.bb.f.c("JLocationHelper", "setTestUrls use loc url :" + linkedList);
        f1609e.clear();
        f1609e.addAll(linkedList);
    }
}

package cn.jiguang.bf;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.f;
import cn.jiguang.bz.l;
import cn.jiguang.e.b;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.LinkedHashMap;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2043a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f2044b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f2045c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f2046d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f2047e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f2048f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f2049g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f2050h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f2051i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f2052j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f2053k;

    /* renamed from: l, reason: collision with root package name */
    public static String f2054l;

    /* renamed from: m, reason: collision with root package name */
    public static int f2055m;

    /* renamed from: n, reason: collision with root package name */
    public static String f2056n;

    /* renamed from: o, reason: collision with root package name */
    public static int f2057o;

    /* renamed from: p, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2058p;

    /* renamed from: q, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2059q;

    /* renamed from: r, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2060r;

    /* renamed from: s, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f2061s;

    /* renamed from: t, reason: collision with root package name */
    private static String f2062t;

    /* renamed from: u, reason: collision with root package name */
    private static String f2063u;

    /* renamed from: v, reason: collision with root package name */
    private static String f2064v;

    /* renamed from: w, reason: collision with root package name */
    private static String f2065w;

    public static String a(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(f2062t)) {
            return f2062t;
        }
        String str = (String) b.b(context, cn.jiguang.e.a.aw());
        return !TextUtils.isEmpty(str) ? str : f2051i;
    }

    public static String b(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(f2063u)) {
            return f2063u;
        }
        String str = (String) b.b(context, cn.jiguang.e.a.ax());
        return !TextUtils.isEmpty(str) ? str : f2052j;
    }

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        f2058p = linkedHashMap;
        String b6 = l.b(new byte[]{98, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2043a = b6;
        String b7 = l.b(new byte[]{83, 112, 123, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 120, 95});
        f2044b = b7;
        String b8 = l.b(new byte[]{85, 65, 106, 113, 98, 126, 93, 69, 106, 123, 119, 118, 85, 14, 122, 103, 123});
        f2045c = b8;
        String b9 = l.b(new byte[]{67, 73, 106, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f2046d = b9;
        linkedHashMap.put(b6, 19000);
        linkedHashMap.put(b7, 19000);
        linkedHashMap.put(b8, 19000);
        linkedHashMap.put(b9, 19000);
        String b10 = l.b(new byte[]{39, 32, 5, 14, 40, HttpConstants.COLON, 38, Utf8.REPLACEMENT_BYTE, 1, 25, 42, 38, 39, 38, 9});
        f2047e = b10;
        String b11 = l.b(new byte[]{40, 57, 37, Utf8.REPLACEMENT_BYTE, 4, 21, 55, 60, 38, Utf8.REPLACEMENT_BYTE, 2, 18, 47});
        f2048f = b11;
        String b12 = l.b(new byte[]{40, HttpConstants.COLON, 38, Utf8.REPLACEMENT_BYTE, 4, 22, 55, 57, 32, Utf8.REPLACEMENT_BYTE, 2, 20, 43});
        f2049g = b12;
        String b13 = l.b(new byte[]{40, HttpConstants.COLON, 38, Utf8.REPLACEMENT_BYTE, 4, 22, 55, 48, 34, Utf8.REPLACEMENT_BYTE, 1, 16, BinaryMemcacheOpcodes.SASL_AUTH});
        f2050h = b13;
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        f2059q = linkedHashMap2;
        try {
            linkedHashMap2.put(b10, 19000);
            linkedHashMap2.put(b11, 19000);
            linkedHashMap2.put(b12, 19000);
            linkedHashMap2.put(b13, 19000);
        } catch (Throwable unused) {
        }
        f2051i = l.b(new byte[]{112, 101, 32, 37, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2052j = l.b(new byte[]{70, 97, 123, 39, 4, 14, 70, 124, 117, 97, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2053k = l.b(new byte[]{70, 120, 101, 120, 67, 14, 70, 125, 114, 97, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2060r = new LinkedHashMap<>();
        f2061s = new LinkedHashMap<>();
        f2062t = "";
        f2063u = "";
        f2064v = "";
        f2065w = "";
    }

    public static LinkedHashMap<String, Integer> a() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = f2060r;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f2058p;
    }

    public static LinkedHashMap<String, Integer> b() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = f2061s;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f2059q;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            f.i("HostConfig", "conn info was empty");
            return;
        }
        f.c("HostConfig", "get conn info=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("srv");
            f.c("HostConfig", "save srvHost:" + optString);
            if (!TextUtils.isEmpty(optString)) {
                b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ax().a((cn.jiguang.e.a<String>) optString)});
            }
            String optString2 = jSONObject.optString("conn");
            f.c("HostConfig", "save connHost:" + optString2);
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aw().a((cn.jiguang.e.a<String>) optString2)});
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(f2064v)) {
            return f2064v;
        }
        return f2053k;
    }

    public static String d() {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(f2065w)) {
            return f2065w;
        }
        return "";
    }
}

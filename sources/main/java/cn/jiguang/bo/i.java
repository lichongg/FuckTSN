package cn.jiguang.bo;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.bz.o;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.bn;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2436a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f2437b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f2438c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f2439d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f2440e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f2441f;

    /* renamed from: g, reason: collision with root package name */
    private static AtomicBoolean f2442g;

    /* renamed from: h, reason: collision with root package name */
    private static AtomicBoolean f2443h;

    /* renamed from: i, reason: collision with root package name */
    private static LinkedList<String> f2444i;

    public static String a(String str) {
        try {
            return v.b(str, f2437b, f2438c);
        } catch (Throwable th) {
            cn.jiguang.bb.f.l("SentryEntryHelper", "basic authorization encode failed:" + th);
            return null;
        }
    }

    public static Integer b() {
        return null;
    }

    private static boolean e(Context context) {
        if (context == null) {
            cn.jiguang.bb.f.i("SentryEntryHelper", "isTimeToUpdate failed: context is null");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aE())).longValue();
        cn.jiguang.bb.f.c("SentryEntryHelper", "currentTime is : " + currentTimeMillis + ", lastTime is : " + longValue);
        return currentTimeMillis - longValue > 86400000;
    }

    static {
        String b6 = cn.jiguang.bz.l.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 69, 42, 109, BinaryMemcacheOpcodes.SASL_AUTH, BinaryMemcacheOpcodes.GATKQ, 84, 21, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 83, 90, 54, 106, 46, BinaryMemcacheOpcodes.GATKQ, 86, 68, 45, 109, BinaryMemcacheOpcodes.GATK, 39, 8, 24, 42, HttpConstants.SEMICOLON, 115, 40, 2});
        f2440e = b6;
        String b7 = cn.jiguang.bz.l.b(new byte[]{96, 98, 101, SignedBytes.MAX_POWER_OF_TWO, 83, BinaryMemcacheOpcodes.GATK, 39, 57, 114, 85, 19, 124, Utf8.REPLACEMENT_BYTE, BinaryMemcacheOpcodes.GATK, 117, 5, 13, 112, 120, 96, 39, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 117, 107, Ascii.US, 66, BinaryMemcacheOpcodes.SASL_AUTH, 61, 112, 117, 4, 69, HttpConstants.COMMA, 62, 46, 41, 3, 19, 124, 49, BinaryMemcacheOpcodes.GATKQ});
        f2441f = b7;
        f2442g = new AtomicBoolean(false);
        f2443h = new AtomicBoolean(false);
        f2444i = new LinkedList<>();
        f2436a = cn.jiguang.bz.l.b(new byte[]{BinaryMemcacheOpcodes.SASL_AUTH, 0, 16, 41, 56, 38, BinaryMemcacheOpcodes.SASL_AUTH, 0, 16, 41, 56, 38, BinaryMemcacheOpcodes.SASL_AUTH, 0, 16, 41});
        f2444i.clear();
        f2444i.add(b6);
        f2444i.add(b7);
        f2437b = cn.jiguang.bz.l.b(new byte[]{109, 80, 79, 112, 92, 113, 16, 94, 75, 69, 96, 119, 115, 80, 106, 37, 85, 97, 101, 91, 73, 71, 68, 113, 97, 45, 79, 88, 80, 116, 99, 91, 97, 71, 90, 114, 71, 72, 75, 81, 89, 94, 111, 83, 98, 112, 32, 73, 100, 46, 91, 89, 70, 68, 16, 110, 60, 103, BinaryMemcacheOpcodes.GATKQ, 106, 81, 92, 90, 61, 71, 125, 111, 77, 66, 47, 126, 96, 72, 50, 49, 66, 95, 87, 119, BinaryMemcacheOpcodes.SASL_AUTH, 95, 102, 73, 71, 99, 114, 100, 69, 93, 72, 102, 93, 69, 34, 39, 85, 104, 78, 114, 66, BinaryMemcacheOpcodes.GATK, 100, 118, 45, 62, 113, 75, 0, 97, 47, 112, 66, 95, 102, 104, 82, 80, 34, 107, 113, 119, 47, HttpConstants.COLON, 39, 123, 86, 66, 47, 121, 108, 125, 90, 116, 111, Byte.MAX_VALUE, 108, 92, 5, 99, 97, 105, BinaryMemcacheOpcodes.GATK, Byte.MAX_VALUE, 2, 20, 45, 56, 125, 68, 8, 104, 95, 39, 83, 85, 69, 16, 45, 113, 103, 68, SignedBytes.MAX_POWER_OF_TWO, 119, 90, 123, 88, 73, 67, 11, 115, 89, 82, 37, 98, 18, 126, 98, 81, 84, 2, 16, 42, 68, 65, 41, 7, 70, 91, 97, 96, 124, 86, 81, 41, 101, 110, 65, 70, 105, 75, 49, 34, 68, 84, 107, Byte.MAX_VALUE, 57, 38, 72, 97, 105, 93, 73, 71, 80, 114});
        f2438c = cn.jiguang.bz.l.b(new byte[]{90, 69, 80, Ascii.US, 101, 90, 74, 57, 65, 123, 99, 74, 57, 70, 112, 84, 68, 112, 102, 113});
        f2439d = cn.jiguang.bz.l.b(new byte[]{89, 93, 65, 122, 91, 94, 80, 2, 21, 47});
    }

    public static String a(String str, String str2) {
        try {
            String str3 = f2439d;
            Mac mac = Mac.getInstance(str3);
            Charset charset = StandardCharsets.UTF_8;
            mac.init(new SecretKeySpec(str.getBytes(charset), str3));
            return w.a(mac.doFinal(str2.getBytes(charset))).toLowerCase();
        } catch (Throwable th) {
            cn.jiguang.bb.f.l("SentryEntryHelper", "HMAC failed:" + th);
            return "";
        }
    }

    public static JSONObject b(Context context) {
        f2443h.set(false);
        try {
        } finally {
            try {
                return null;
            } finally {
            }
        }
        if (o.c()) {
            String a6 = cn.jiguang.ba.a.a(context);
            if (!TextUtils.isEmpty(a6)) {
                w.a(context, f2444i);
                Iterator<String> it = f2444i.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("platform", "a");
                    jSONObject.put("app_key", a6);
                    jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f1444b);
                    jSONObject.put("os_ver", Integer.toString(Build.VERSION.SDK_INT));
                    String z5 = cn.jiguang.bz.a.a().z(context);
                    if (TextUtils.isEmpty(z5)) {
                        z5 = "";
                    }
                    jSONObject.put(bn.f10754j, z5);
                    String jSONObject2 = jSONObject.toString();
                    cn.jiguang.bb.f.c("SentryEntryHelper", "url:" + next + ", param json:" + jSONObject2);
                    try {
                        byte[] bytes = jSONObject2.getBytes("UTF-8");
                        HttpRequest httpRequest = new HttpRequest(next);
                        httpRequest.setRequestProperty("Content-Type", "application/json");
                        httpRequest.setRequestProperty("Accept", "application/json");
                        httpRequest.setRequestProperty("X-Http-Platform", FaceEnvironment.OS);
                        httpRequest.setRequestProperty("X-Http-Appkey", a6);
                        httpRequest.setRequestProperty("Charset", "UTF-8");
                        String substring = v.a(v.a()).substring(0, 16);
                        if (a(httpRequest, context, bytes, substring)) {
                            HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                            int responseCode = httpPost.getResponseCode();
                            cn.jiguang.bb.f.c("SentryEntryHelper", "responseCode:" + responseCode);
                            String responseBody = httpPost.getResponseBody();
                            cn.jiguang.bb.f.c("SentryEntryHelper", "responseBody:" + responseBody);
                            if (200 == responseCode && !TextUtils.isEmpty(responseBody)) {
                                JSONObject jSONObject3 = new JSONObject(responseBody);
                                String optString = jSONObject3.optString("data", null);
                                if (jSONObject3.has("code") && jSONObject3.getInt("code") == 0 && !TextUtils.isEmpty(optString)) {
                                    String str = new String(v.a(optString, substring, f2436a), "UTF-8");
                                    cn.jiguang.bb.f.c("SentryEntryHelper", "request sentry sample success, decrypt data:" + str);
                                    return new JSONObject(str);
                                }
                            }
                        } else {
                            cn.jiguang.bb.f.c("SentryEntryHelper", "configRequestReport is false");
                        }
                    } catch (Throwable th) {
                        cn.jiguang.bb.f.l("SentryEntryHelper", "Throwable UnsupportedEncodingException - " + th.getMessage());
                    }
                }
                return null;
            }
            cn.jiguang.bb.f.i("SentryEntryHelper", "request sentry sample failed because can't get appKey");
        }
        return null;
    }

    public static void c(Context context) {
        if (context == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateImmediately failed: ");
            sb.append(context == null ? "context is null" : "Sentry feature is disabled");
            cn.jiguang.bb.f.i("SentryEntryHelper", sb.toString());
            return;
        }
        if (!e(context)) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aE().a((cn.jiguang.e.a<Long>) 0L)});
            cn.jiguang.bb.f.c("SentryEntryHelper", "Reset sentry config last request time");
        }
        a(context);
    }

    public static void a(final Context context) {
        if (e(context)) {
            cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bo.i.1
                @Override // cn.jiguang.by.b
                public void a() {
                    JSONObject b6 = i.b(context);
                    if (i.f2443h.get()) {
                        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aE().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                        if (b6 != null) {
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aF().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(b6.optBoolean("crash_switch", false)))});
                            i.f2442g.set(b6.optBoolean("crash_switch", false));
                            cn.jiguang.bq.c.a().a(context, b6.optBoolean("net_switch", true));
                            cn.jiguang.bg.c.a(context, b6.optBoolean("use_tcp_ssl", false));
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.k().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(b6.optBoolean("count_switch", true)))});
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.l().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(b6.optBoolean("android_tcpreport_switch", true)))});
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.m().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(b6.optBoolean("tcp_exception_switch", false)))});
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.n().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(b6.optBoolean("net_length_switch", false)))});
                            boolean optBoolean = b6.optBoolean("exception_switch", false);
                            cn.jiguang.bw.a.a().a(optBoolean);
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.N().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(optBoolean))});
                            long optLong = b6.optLong("net_count_threshold");
                            if (optLong < 0) {
                                optLong = cn.jiguang.bq.b.f2512b;
                            }
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.o().a((cn.jiguang.e.a<Long>) Long.valueOf(optLong))});
                            long optLong2 = b6.optLong("net_conn_count_threshold");
                            if (optLong2 < 0) {
                                optLong2 = cn.jiguang.bq.b.f2514d;
                            }
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.q().a((cn.jiguang.e.a<Long>) Long.valueOf(optLong2))});
                            long optLong3 = b6.optLong("net_length_threshold");
                            long j6 = optLong3 > 0 ? optLong3 * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : cn.jiguang.bq.b.f2511a;
                            long optLong4 = b6.optLong("net_conn_length_threshold");
                            long j7 = optLong4 > 0 ? optLong4 * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : cn.jiguang.bq.b.f2513c;
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.p().a((cn.jiguang.e.a<Long>) Long.valueOf(j6))});
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.r().a((cn.jiguang.e.a<Long>) Long.valueOf(j7))});
                        }
                        i.f(context);
                    }
                }
            });
        } else {
            f2442g.set(((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aF())).booleanValue());
            f(context);
            cn.jiguang.bq.c.a().a(context);
        }
        cn.jiguang.bq.a.a().a(context);
        cn.jiguang.bq.b.a().a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        if (a()) {
            h.a().a(context);
            b.a(context);
        }
        h.a().b();
    }

    public static boolean a() {
        return f2442g.get();
    }

    private static boolean a(HttpRequest httpRequest, Context context, byte[] bArr, String str) {
        httpRequest.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpRequest.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        httpRequest.setHaveRspData(true);
        httpRequest.setRspDatazip(true);
        httpRequest.setNeedErrorInput(true);
        String encodeToString = Base64.encodeToString(v.a(bArr, str, f2436a, true), 2);
        httpRequest.setBody(encodeToString);
        httpRequest.setRequestProperty("Content-Length", String.valueOf(encodeToString.length()));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("Charset", "UTF-8");
        httpRequest.setRequestProperty("x-jg-version", "1.0");
        String str2 = System.currentTimeMillis() + "";
        httpRequest.setRequestProperty("x-jg-timestamp", str2);
        String e6 = cn.jiguang.d.a.e(context);
        String a6 = a(str);
        if (a6 == null) {
            cn.jiguang.bb.f.c("SentryEntryHelper", "authForSentryEntry is null");
            return false;
        }
        String str3 = "Basic " + Base64.encodeToString((e6 + ":" + a6).getBytes(), 2);
        httpRequest.setRequestProperty("Authorization", str3);
        httpRequest.setRequestProperty("x-jg-sign", a(w.d(e6 + str2), str3 + str2 + "1.0" + encodeToString));
        return true;
    }
}

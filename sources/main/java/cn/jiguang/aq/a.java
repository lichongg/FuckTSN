package cn.jiguang.aq;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;
import cn.jiguang.bz.l;
import cn.jiguang.bz.q;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.g.c;
import cn.jiguang.m.c;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.amap.api.services.core.AMapException;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.scene.URLPackage;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f1657a = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1658b = l.b(new byte[]{88, 99, 23, BinaryMemcacheOpcodes.SASL_AUTH, 91, 70, 122, 67, 18, 113, Byte.MAX_VALUE, 85, 75, 114, 108, 120});

    /* renamed from: c, reason: collision with root package name */
    private static final String f1659c = l.b(new byte[]{65, 8, 65, 72, 109, 123, 93, SignedBytes.MAX_POWER_OF_TWO, 118, 122, 88, 68, 82, 67, 76, 43});

    /* renamed from: d, reason: collision with root package name */
    private static final String f1660d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f1661e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f1662f;

    /* renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f1663l;

    /* renamed from: g, reason: collision with root package name */
    private String f1664g;

    /* renamed from: h, reason: collision with root package name */
    private String f1665h;

    /* renamed from: i, reason: collision with root package name */
    private Context f1666i;

    /* renamed from: j, reason: collision with root package name */
    private long f1667j;

    /* renamed from: k, reason: collision with root package name */
    private long f1668k;

    /* renamed from: cn.jiguang.aq.a$a, reason: collision with other inner class name */
    private class C0026a extends cn.jiguang.by.b {
        private C0026a() {
        }

        @Override // cn.jiguang.by.b
        public void a() {
            String str;
            try {
                boolean a6 = c.a().a(AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL);
                boolean b6 = c.a().b(AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL);
                if (a6) {
                    cn.jiguang.bw.a.a().a((Object) 1025);
                }
                if (b6) {
                    cn.jiguang.bw.a.a().a((Object) 1026);
                }
                if (a6 || !b6) {
                    f.c("JUaidManager", "user  enable or default can to get uaid, containEnableDatas=" + a6 + " containDisableDatas=" + b6);
                    if (a.this.g()) {
                        cn.jiguang.bw.a.a().a((Object) 1047);
                        a.this.b();
                        return;
                    } else {
                        cn.jiguang.bw.a.a().a((Object) 1012);
                        str = "the next request time is not reached";
                    }
                } else {
                    str = "user disable to get uaid, containEnableDatas=" + a6 + " containDisableDatas=" + b6;
                }
                f.c("JUaidManager", str);
            } catch (Throwable th) {
                cn.jiguang.bw.a.a().a((Object) 1039);
                f.i("JUaidManager", "Throwable e=" + th.getMessage());
            }
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f1677a = new a();
    }

    private a() {
        this.f1664g = i() + l.b(new byte[]{82, 120, 56, 117, 117, 85});
        this.f1665h = i() + l.b(new byte[]{66, 125, 56, 100, 32, 65});
        this.f1667j = 0L;
        this.f1668k = 86400000L;
    }

    public static a a() {
        return b.f1677a;
    }

    private String b(String str) {
        try {
            return Base64.encodeToString(v.a(str.getBytes("UTF-8"), f1659c, f1658b, true), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private JSONObject f() {
        try {
            JSONObject h6 = h();
            if (h6 == null) {
                cn.jiguang.bw.a.a().a((Object) 1035);
                return null;
            }
            h6.put("core_sdk_ver", cn.jiguang.a.a.f1444b);
            f.c("JUaidManager", "start to reqUrlInternal paramJson=" + h6);
            return a(this.f1665h, h6, true);
        } catch (Throwable unused) {
            cn.jiguang.bw.a.a().a(Integer.valueOf(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW));
            return null;
        }
    }

    public ConnectivityManager c() {
        cn.jiguang.bw.a a6;
        int i6;
        Context a7 = d.a();
        if (a7 == null) {
            a6 = cn.jiguang.bw.a.a();
            i6 = 1001;
        } else {
            if (q.a(a7, g.f36042b)) {
                return (ConnectivityManager) a7.getSystemService("connectivity");
            }
            a6 = cn.jiguang.bw.a.a();
            i6 = 1002;
        }
        a6.a(Integer.valueOf(i6));
        return null;
    }

    public Integer d() {
        return null;
    }

    static {
        String b6 = l.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57});
        f1660d = b6;
        String b7 = l.b(new byte[]{121, 68, 84, 105, 123, HttpConstants.COMMA, 62, Ascii.US, 67, 124, HttpConstants.SEMICOLON, 115, 38, 5, 68, HttpConstants.COMMA, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54});
        f1661e = b7;
        f1662f = b6;
        LinkedList<String> linkedList = new LinkedList<>();
        f1663l = linkedList;
        linkedList.clear();
        f1663l.add(b6);
        f1663l.add(b7);
    }

    private HttpResponse a(HttpURLConnection httpURLConnection, String str, String str2, JSONObject jSONObject, String str3) {
        str.getClass();
        switch (str) {
            case "GET":
                return HttpUtils.httpResponse(this.f1666i, httpURLConnection, new HttpRequest(str2), false, false);
            case "PUT":
            case "POST":
                HttpRequest httpRequest = new HttpRequest(str2);
                a(httpRequest, jSONObject);
                httpRequest.setBody(str3);
                return HttpUtils.httpResponse(this.f1666i, httpURLConnection, httpRequest, "POST".equalsIgnoreCase(str), "PUT".equalsIgnoreCase(str));
            default:
                cn.jiguang.bw.a.a().a((Object) 1038);
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Object obj;
        SharedPreferences sharedPreferences;
        if (0 == this.f1667j && (sharedPreferences = this.f1666i.getSharedPreferences("cn.jiguang.common", 0)) != null) {
            this.f1667j = sharedPreferences.getLong("uaid_last_time", 0L);
            this.f1668k = sharedPreferences.getLong("uaid_internal_time", 86400000L);
        }
        long j6 = this.f1668k;
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        if (j6 == 86400000) {
            obj = 1056;
        } else {
            obj = "stime" + this.f1668k;
        }
        a6.a(obj);
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - this.f1667j);
        f.c("JUaidManager", "mLastRequestTime=" + this.f1667j + " next_time=" + this.f1668k + " currentTimeMillis=" + currentTimeMillis + " diffTime=" + abs);
        return abs >= this.f1668k;
    }

    private JSONObject h() {
        String a6;
        JSONObject jSONObject = new JSONObject();
        try {
            a6 = cn.jiguang.ba.a.a(this.f1666i);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(a6)) {
            f.i("JUaidManager", "appKey is null, no need req");
            cn.jiguang.bw.a.a().a((Object) 1013);
            return null;
        }
        long f6 = cn.jiguang.d.a.f(this.f1666i);
        if (0 == f6) {
            f.i("JUaidManager", "uid is 0,no need req");
            cn.jiguang.bw.a.a().a(Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
            return null;
        }
        jSONObject.put("appkey", a6);
        jSONObject.put("uid", f6);
        jSONObject.put("os_ver", cn.jiguang.bz.a.a().D(this.f1666i));
        jSONObject.put("platform", "a");
        return jSONObject;
    }

    private static String i() {
        String str = f1662f;
        if (!c.a.f3097a || TextUtils.isEmpty(f1657a)) {
            return str;
        }
        f.c("JUaidManager", "use folder data config url :" + f1657a);
        return f1657a;
    }

    public void b() {
        Network activeNetwork;
        cn.jiguang.bw.a a6;
        int i6;
        cn.jiguang.bw.a a7;
        int i7;
        try {
            boolean b6 = q.b(this.f1666i, "android.permission.CHANGE_NETWORK_STATE");
            cn.jiguang.bw.a.a().a(Integer.valueOf(b6 ? 1045 : 1046));
            ConnectivityManager c6 = c();
            if (c6 == null) {
                cn.jiguang.bw.a.a().a((Object) 1003);
                f.c("JUaidManager", "no connectivityManager hadChangePermission= " + b6);
                a(b6);
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                activeNetwork = c6.getActiveNetwork();
                if (activeNetwork == null) {
                    a7 = cn.jiguang.bw.a.a();
                    i7 = 1004;
                } else {
                    NetworkCapabilities networkCapabilities = c6.getNetworkCapabilities(activeNetwork);
                    if (networkCapabilities == null) {
                        a7 = cn.jiguang.bw.a.a();
                        i7 = 1005;
                    } else {
                        boolean z5 = false;
                        boolean hasTransport = networkCapabilities.hasTransport(0);
                        try {
                            boolean hasTransport2 = networkCapabilities.hasTransport(1);
                            StringBuilder sb = new StringBuilder("n");
                            if (hasTransport2) {
                                sb.append(1);
                                cn.jiguang.bw.a.a().a((Object) 1043);
                            }
                            if (hasTransport) {
                                sb.append(0);
                                cn.jiguang.bw.a.a().a((Object) 1042);
                            }
                            if (networkCapabilities.hasTransport(3)) {
                                sb.append(3);
                            }
                            if (networkCapabilities.hasTransport(2)) {
                                sb.append(2);
                            }
                            if (networkCapabilities.hasTransport(4)) {
                                sb.append(4);
                            }
                            if (networkCapabilities.hasTransport(5)) {
                                sb.append(5);
                            }
                            if (networkCapabilities.hasTransport(6)) {
                                sb.append(6);
                            }
                            cn.jiguang.bw.a.a().a(sb.toString());
                        } catch (Throwable unused) {
                            cn.jiguang.bw.a.a().a((Object) 1044);
                        }
                        boolean hasCapability = networkCapabilities.hasCapability(12);
                        boolean hasCapability2 = networkCapabilities.hasCapability(16);
                        if (!hasCapability) {
                            a6 = cn.jiguang.bw.a.a();
                            i6 = 1006;
                        } else {
                            if (hasCapability2) {
                                cn.jiguang.bw.a.a().a((Object) 1048);
                                f.c("JUaidManager", "new network, hadChangePermission= " + b6 + " hasTransportCell=" + hasTransport);
                                if (b6 && !hasTransport) {
                                    z5 = true;
                                }
                                a(z5);
                                return;
                            }
                            a6 = cn.jiguang.bw.a.a();
                            i6 = 1007;
                        }
                        a6.a(i6);
                    }
                }
                a7.a(i7);
                a(c6, b6);
                return;
            }
            a(c6, b6);
        } catch (Throwable unused2) {
            cn.jiguang.bw.a.a().a((Object) 1044);
        }
    }

    public void c(Context context) {
        if (context == null) {
            f.i("JUaidManager", "updateImmediately failed: context is null");
            return;
        }
        boolean g6 = g();
        f.c("JUaidManager", "updateImmediately: businessCondition=" + g6);
        if (!g6) {
            f.c("JUaidManager", "Reset request time and continue update");
            a(0L, this.f1668k);
        }
        b(context);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(v.a(Base64.decode(str, 2), f1659c, f1658b, false));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        cn.jiguang.bw.a.a().a((Object) 1029);
    }

    public void b(Context context) {
        if (this.f1666i == null) {
            this.f1666i = context;
        }
        cn.jiguang.bw.a.a().a((Object) 999);
        f.c("JUaidManager", "getUaidAsyn");
        cn.jiguang.be.b.e(new C0026a());
    }

    private JSONObject a(String str, JSONObject jSONObject, boolean z5) {
        String optString;
        String upperCase;
        cn.jiguang.bw.a a6;
        Integer valueOf;
        try {
            optString = jSONObject.optString("uid");
            upperCase = w.e(optString + w.e(cn.jiguang.d.a.j(this.f1666i)).toUpperCase()).toUpperCase();
        } catch (Throwable unused) {
            cn.jiguang.bw.a.a().a(Integer.valueOf(z5 ? 1036 : 1037));
        }
        if (TextUtils.isEmpty(upperCase)) {
            return null;
        }
        String encodeToString = Base64.encodeToString((optString + ":" + upperCase).getBytes(), 10);
        if (TextUtils.isEmpty(encodeToString)) {
            return null;
        }
        w.a(this.f1666i, f1663l);
        int i6 = 0;
        String str2 = str;
        boolean z6 = false;
        while (i6 < f1663l.size()) {
            if (!cn.jiguang.bz.b.e(this.f1666i) || z6) {
                str2 = (z6 || i6 != f1663l.size() - 1) ? str : str.replace(f1660d, f1661e);
            } else {
                str2 = str2.replace(f1660d, f1661e);
                z6 = true;
            }
            f.c("JUaidManager", "url:" + str2 + ", param json:" + jSONObject.toString());
            HttpRequest httpRequest = new HttpRequest(str2);
            httpRequest.setRequestProperty("Content-Type", "application/json");
            httpRequest.setRequestProperty("Accept", "application/json");
            httpRequest.setRequestProperty("X-Http-Platform", FaceEnvironment.OS);
            httpRequest.setRequestProperty("X-Http-Appkey", jSONObject.optString("appkey"));
            httpRequest.setRequestProperty("Authorization", "Basic " + encodeToString);
            httpRequest.setRequestProperty("Charset", "UTF-8");
            httpRequest.setBody(b(jSONObject.toString()));
            HttpResponse httpPost = HttpUtils.httpPost(this.f1666i, httpRequest);
            int responseCode = httpPost.getResponseCode();
            f.c("JUaidManager", "responseCode:" + responseCode);
            String responseBody = httpPost.getResponseBody();
            f.c("JUaidManager", "response:" + responseBody);
            if (200 != responseCode) {
                a6 = cn.jiguang.bw.a.a();
                valueOf = Integer.valueOf(z5 ? PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW : PointerIconCompat.TYPE_ZOOM_IN);
            } else if (TextUtils.isEmpty(responseBody)) {
                a6 = cn.jiguang.bw.a.a();
                valueOf = Integer.valueOf(z5 ? PointerIconCompat.TYPE_ZOOM_OUT : 1032);
            } else {
                String a7 = a(responseBody);
                f.c("JUaidManager", "request success,response body:" + a7);
                JSONObject jSONObject2 = new JSONObject(a7);
                if (2000 == jSONObject2.optInt("code")) {
                    return jSONObject2;
                }
                a6 = cn.jiguang.bw.a.a();
                valueOf = Integer.valueOf(z5 ? PointerIconCompat.TYPE_GRAB : 1033);
            }
            a6.a(valueOf);
            i6++;
        }
        return null;
    }

    private JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    key = value instanceof String ? (String) value : "空key";
                }
                jSONObject.put(key, value);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, JSONObject jSONObject, String str3, String str4) {
        a(HttpUtils.getHttpURLConnectionWithProxy(str2), str, str2, jSONObject, str3, str4);
    }

    private void a(long j6) {
        a(System.currentTimeMillis(), j6);
    }

    private void a(long j6, long j7) {
        this.f1667j = j6;
        if (j7 <= 0) {
            j7 = 86400000;
        }
        SharedPreferences sharedPreferences = this.f1666i.getSharedPreferences("cn.jiguang.common", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("uaid_last_time", this.f1667j).putLong("uaid_internal_time", j7).apply();
        }
        this.f1668k = j7;
        f.c("JUaidManager", "save reqTime requestTime=" + this.f1667j + " next_time=" + this.f1668k);
    }

    public void a(Context context) {
        this.f1666i = context;
    }

    private void a(ConnectivityManager connectivityManager, boolean z5) {
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                cn.jiguang.bw.a.a().a((Object) 1009);
                f.c("JUaidManager", "old network no activeNetworkInfo, hadChangePermission= " + z5);
                a(z5);
                return;
            }
            int type = activeNetworkInfo.getType();
            boolean a6 = a(type);
            boolean z6 = false;
            boolean z7 = 1 == type;
            if (a6) {
                try {
                    cn.jiguang.bw.a.a().a(Integer.valueOf(AVMDLDataLoader.KeyIsPreloadWaitListType));
                } catch (Throwable unused) {
                    cn.jiguang.bw.a.a().a((Object) 1044);
                }
            }
            if (z7) {
                cn.jiguang.bw.a.a().a((Object) 1041);
            }
            cn.jiguang.bw.a.a().a("o" + type);
            if (!activeNetworkInfo.isConnected()) {
                cn.jiguang.bw.a.a().a((Object) 1010);
                return;
            }
            cn.jiguang.bw.a.a().a((Object) 1048);
            f.c("JUaidManager", "old network no activeNetworkInfo, hadChangePermission= " + z5 + " mobileNetworkType=" + a6);
            if (z5 && !a6) {
                z6 = true;
            }
            a(z6);
        } catch (Throwable unused2) {
            cn.jiguang.bw.a.a().a((Object) 1044);
        }
    }

    private void a(HttpRequest httpRequest, JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                httpRequest.setRequestProperty(next, jSONObject.getString(next));
            }
        } catch (Throwable unused) {
        }
    }

    private void a(HttpResponse httpResponse, String str) {
        cn.jiguang.bw.a a6;
        int i6;
        try {
            if (httpResponse != null) {
                int responseCode = httpResponse.getResponseCode();
                String responseBody = httpResponse.getResponseBody();
                f.c("JUaidManager", "token code:" + responseCode);
                f.c("JUaidManager", "tokenResponse:" + responseBody);
                if (200 != responseCode) {
                    a6 = cn.jiguang.bw.a.a();
                    i6 = 1030;
                } else if (TextUtils.isEmpty(responseBody)) {
                    a6 = cn.jiguang.bw.a.a();
                    i6 = 1031;
                } else {
                    JSONObject h6 = h();
                    if (h6 == null) {
                        a6 = cn.jiguang.bw.a.a();
                        i6 = Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);
                    } else {
                        h6.put(URLPackage.KEY_CHANNEL_ID, str);
                        h6.put("core_sdk_ver", cn.jiguang.a.a.f1444b);
                        h6.put("respBody", responseBody);
                        h6.put("respHeader", a(httpResponse.getResponseHeaders()));
                        f.c("JUaidManager", "start to reportToken paramJson=" + h6);
                        JSONObject a7 = a(this.f1664g, h6, false);
                        f.c("JUaidManager", "reportToken response=" + a7);
                        if (a7 == null) {
                            a6 = cn.jiguang.bw.a.a();
                            i6 = 1032;
                        } else if (a7.optInt("code") == 2000) {
                            f.c("JUaidManager", "reportToken success");
                            a6 = cn.jiguang.bw.a.a();
                            i6 = 1000;
                        } else {
                            f.c("JUaidManager", "reportToken fail");
                            a6 = cn.jiguang.bw.a.a();
                            i6 = 1033;
                        }
                    }
                }
            } else {
                a6 = cn.jiguang.bw.a.a();
                i6 = 1028;
            }
            a6.a(i6);
        } catch (Throwable unused) {
            cn.jiguang.bw.a.a().a((Object) 1034);
        }
    }

    private void a(final String str, final String str2, final JSONObject jSONObject, final String str3, final String str4) {
        try {
            int i6 = Build.VERSION.SDK_INT;
            final ConnectivityManager c6 = c();
            if (c6 == null) {
                f.c("JUaidManager", "No connectivity manager available");
                b(str, str2, jSONObject, str3, str4);
                return;
            }
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: cn.jiguang.aq.a.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    try {
                        try {
                            f.c("JUaidManager", "Network available: " + network);
                            cn.jiguang.bw.a.a().a((Object) 1049);
                            a.this.a((HttpURLConnection) network.openConnection(new URL(str2)), str, str2, jSONObject, str3, str4);
                        } finally {
                            c6.unregisterNetworkCallback(this);
                        }
                    } catch (Throwable unused) {
                        a.this.e();
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    try {
                        try {
                            f.c("JUaidManager", "Network unavailable");
                            a.this.b(str, str2, jSONObject, str3, str4);
                        } catch (Throwable unused) {
                            a.this.e();
                        }
                    } finally {
                        c6.unregisterNetworkCallback(this);
                    }
                }
            };
            if (i6 >= 26) {
                c6.requestNetwork(builder.build(), networkCallback, 15000);
            } else {
                c6.requestNetwork(builder.build(), networkCallback);
            }
        } catch (Throwable unused) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpURLConnection httpURLConnection, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        HttpResponse a6 = a(httpURLConnection, str, str2, jSONObject, str3);
        f.c("JUaidManager", "performRequest httpResponse=" + a6);
        a(a6, str4);
    }

    private void a(JSONObject jSONObject, boolean z5) {
        cn.jiguang.bw.a a6;
        int i6;
        cn.jiguang.bw.a a7;
        int i7;
        try {
            boolean e6 = cn.jiguang.g.a.a().e(1037);
            boolean z6 = e6 && z5;
            f.c("JUaidManager", "first enable=" + z5 + " server enable=" + e6 + " final enable=" + z6);
            StringBuilder sb = new StringBuilder();
            sb.append("startReqTokenFromOperator startReqTokenFromOperator= ");
            sb.append(jSONObject);
            f.c("JUaidManager", sb.toString());
            if (jSONObject == null) {
                a7 = cn.jiguang.bw.a.a();
                i7 = 1023;
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null) {
                    for (int i8 = 0; i8 < optJSONArray.length(); i8++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i8);
                        String optString = jSONObject2.optString(URLPackage.KEY_CHANNEL_ID);
                        JSONObject optJSONObject = jSONObject2.optJSONObject("headers");
                        String optString2 = jSONObject2.optString("method");
                        String optString3 = jSONObject2.optString("requestBody");
                        String optString4 = jSONObject2.optString("url");
                        String upperCase = optString2.toUpperCase();
                        cn.jiguang.bw.a.a().a((Object) 1055);
                        if (z6) {
                            a(upperCase, optString4, optJSONObject, optString3, optString);
                            a6 = cn.jiguang.bw.a.a();
                            i6 = 1051;
                        } else {
                            b(upperCase, optString4, optJSONObject, optString3, optString);
                            a6 = cn.jiguang.bw.a.a();
                            i6 = 1052;
                        }
                        a6.a(i6);
                    }
                    return;
                }
                a7 = cn.jiguang.bw.a.a();
                i7 = 1027;
            }
            a7.a(i7);
        } catch (Throwable unused) {
            cn.jiguang.bw.a.a().a((Object) 1029);
        }
    }

    private void a(boolean z5) {
        cn.jiguang.bw.a a6;
        int i6;
        try {
            JSONObject f6 = f();
            if (f6 == null) {
                a6 = cn.jiguang.bw.a.a();
                i6 = 1022;
            } else {
                JSONObject optJSONObject = f6.optJSONObject("data");
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("token_switch");
                    long optLong = optJSONObject.optLong("next_time") * 1000;
                    f.c("JUaidManager", "mSwitch=" + optBoolean + " internalTime=" + optLong);
                    a(optLong);
                    if (optBoolean) {
                        cn.jiguang.bw.a.a().a((Object) 1053);
                        a(optJSONObject, z5);
                        return;
                    } else {
                        a6 = cn.jiguang.bw.a.a();
                        i6 = 1021;
                    }
                } else {
                    a6 = cn.jiguang.bw.a.a();
                    i6 = 1023;
                }
            }
            a6.a(i6);
        } catch (Throwable th) {
            cn.jiguang.bw.a.a().a((Object) 1024);
            f.i("JUaidManager", "startReq throwable:" + th);
        }
    }

    private boolean a(int i6) {
        return i6 == 0 || i6 == 4 || i6 == 5 || i6 == 2 || i6 == 6 || i6 == 3;
    }
}

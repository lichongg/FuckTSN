package cn.jiguang.u;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import cn.jiguang.bz.h;
import cn.jiguang.bz.l;
import cn.jiguang.bz.t;
import cn.jiguang.bz.w;
import cn.jiguang.q.d;
import cn.jiguang.q.e;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.common.base.Ascii;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    private static List<String> A = null;
    private static SimpleDateFormat B = null;
    private static long C = 0;
    private static String D = null;
    private static final FileFilter E;
    private static JSONObject F = null;

    /* renamed from: a, reason: collision with root package name */
    public static JSONArray f3249a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f3250b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f3251c = "";

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f3252d = {123, 98, 112, 68, 0, 52, 110, 54};

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f3253e = {67, 84, 120, 124, 54};

    /* renamed from: f, reason: collision with root package name */
    private static final String f3254f;

    /* renamed from: g, reason: collision with root package name */
    private static final String f3255g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f3256h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f3257i;

    /* renamed from: j, reason: collision with root package name */
    private static final String f3258j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f3259k;

    /* renamed from: l, reason: collision with root package name */
    private static final String f3260l;

    /* renamed from: m, reason: collision with root package name */
    private static final String f3261m;

    /* renamed from: n, reason: collision with root package name */
    private static final String f3262n;

    /* renamed from: o, reason: collision with root package name */
    private static final String f3263o;

    /* renamed from: p, reason: collision with root package name */
    private static final String f3264p;

    /* renamed from: q, reason: collision with root package name */
    private static final String f3265q;

    /* renamed from: r, reason: collision with root package name */
    private static final String f3266r;

    /* renamed from: s, reason: collision with root package name */
    private static final String f3267s;

    /* renamed from: t, reason: collision with root package name */
    private static final String f3268t;

    /* renamed from: u, reason: collision with root package name */
    private static final String f3269u;

    /* renamed from: v, reason: collision with root package name */
    private static final String f3270v;

    /* renamed from: w, reason: collision with root package name */
    private static final String f3271w;

    /* renamed from: x, reason: collision with root package name */
    private static final String f3272x;

    /* renamed from: y, reason: collision with root package name */
    private static Map<String, String> f3273y;

    /* renamed from: z, reason: collision with root package name */
    private static List<String> f3274z;

    private static String b(String str) {
        List<String> a6 = cn.jiguang.v.c.a(new String[]{l.b(f3252d) + str}, 1);
        StringBuilder sb = new StringBuilder();
        for (String str2 : a6) {
            if (str2.startsWith("Blocks")) {
                int indexOf = str2.indexOf("Blocks:");
                int indexOf2 = str2.indexOf("Free:");
                if (indexOf >= 0 && indexOf2 >= 0) {
                    sb.append(str2.substring(indexOf + 15, indexOf2));
                }
            }
            if (str2.contains("ID")) {
                int indexOf3 = str2.indexOf("ID:");
                int indexOf4 = str2.indexOf("Namelen:");
                if (indexOf3 >= 0 && indexOf4 >= 0) {
                    sb.append(str2.substring(indexOf3 + 3, indexOf4));
                }
            }
        }
        return sb.toString();
    }

    public static String c(Context context) {
        try {
            cn.jiguang.bn.a a6 = cn.jiguang.bn.a.a(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sim_slots", b(context));
            jSONObject.put("packagename", context.getPackageName());
            jSONObject.put("appkey", cn.jiguang.ba.a.a(context));
            jSONObject.put("platform", 0);
            jSONObject.put("apkversion", a6.f2369a);
            jSONObject.put("systemversion", a6.f2370b);
            jSONObject.put("modelnumber", a6.f2371c);
            jSONObject.put("basebandversion", a6.f2372d);
            jSONObject.put("buildnumber", a6.f2373e);
            jSONObject.put("channel", a6.f2374f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", cn.jiguang.bi.b.a().b(0));
            jSONObject2.put("StatisticSDKVer", cn.jiguang.bi.b.a().b(1));
            jSONObject2.put("ShareSDKVer", cn.jiguang.bi.b.a().b(2));
            jSONObject2.put("CoreSDKVer", cn.jiguang.bi.b.a().b(3));
            jSONObject2.put("SspSDKVer", cn.jiguang.bi.b.a().b(4));
            jSONObject2.put("VerificationSDKVer", cn.jiguang.bi.b.a().b(5));
            jSONObject.put("sdkver", jSONObject2);
            jSONObject.put("installation", a6.f2375g);
            jSONObject.put("business", (int) cn.jiguang.bi.b.a().b());
            jSONObject.put("device_id_status", h.f2740a);
            jSONObject.put("device_id", h.b(context));
            jSONObject.put("resolution", a6.f2376h);
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, a6.f2377i);
            jSONObject.put("mac_address", cn.jiguang.bz.a.a().b(context, "", false));
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    static {
        String b6 = l.b(new byte[]{54});
        f3254f = b6;
        String b7 = l.b(new byte[]{62, 84, 65, 109, 105, 57, 117, 81, 84, 120});
        f3255g = b7;
        String b8 = l.b(new byte[]{Ascii.US, 83, 96, 123, 98, 116, 93, 15, 124, 124, 117});
        f3256h = b8;
        String b9 = l.b(new byte[]{Ascii.US, 83, 109, 103, 100, 112, 87, 69, 54, 109, 123, 100, 92, 65, 109, 109, 114});
        f3257i = b9;
        String b10 = l.b(new byte[]{54, 123, 98, 126, 66, 65, 126, 109, 57, 116, 93, 85, 117, 105, 98, 116, 84, 15, 41});
        f3258j = b10;
        String b11 = l.b(new byte[]{62, 84, 65, 109, 105, 57, 100, 67, 69, 107});
        f3259k = b11;
        String b12 = l.b(new byte[]{62, 93, 78, 109});
        f3260l = b12;
        String b13 = l.b(new byte[]{Ascii.US, 83, 96, 123, 98, 116, 93, 15, 120, 120, 102});
        f3261m = b13;
        String b14 = l.b(new byte[]{62, 67, 89, 106, 124, 115, 124, Ascii.US, 80, 107, 97, 96, 60, 81, 80, 105});
        f3262n = b14;
        String b15 = l.b(new byte[]{Ascii.US, 83, 96, 123, 98, 116, 93, 15, 123, 97, 120});
        f3263o = b15;
        String b16 = l.b(new byte[]{Ascii.US, 83, 96, 123, 98, 116, 93, 15, 108, 123, 100});
        f3264p = b16;
        String b17 = l.b(new byte[]{Ascii.US, 65, 122, 107, 98});
        f3265q = b17;
        String b18 = l.b(new byte[]{62, 84, 69, 111});
        f3266r = b18;
        String b19 = l.b(new byte[]{54, 107, 121, Byte.MAX_VALUE, 86, 73, 126});
        f3267s = b19;
        String b20 = l.b(new byte[]{Ascii.US, 68, 120, 124, 119});
        f3268t = b20;
        String b21 = l.b(new byte[]{39, 102, 99, 95, 68, 108, 107, 98});
        f3269u = b21;
        String b22 = l.b(new byte[]{62, 67, 89, 106});
        f3270v = b22;
        String b23 = l.b(new byte[]{54, 123, 111, 98, 68, 69, 116, 39, 112, 126, 94, 84, 106});
        f3271w = b23;
        String b24 = l.b(new byte[]{Ascii.US, 83, 96, 123, 98, 116, 93, 15, Byte.MAX_VALUE, 122, 119, 124, 85, 87, 118, 122, 125});
        f3272x = b24;
        f3273y = new HashMap();
        f3274z = new ArrayList();
        A = new ArrayList();
        B = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS Z");
        C = 31536000000L;
        f3273y.put(b6, "p_root");
        f3273y.put(b7, "p_data");
        f3273y.put(b8, "p_etc");
        f3273y.put(b9, "p_emu");
        f3273y.put(b10, "p_emu0");
        f3273y.put(b11, "p_user");
        f3273y.put(b12, "p_mnt");
        f3273y.put(b13, "p_app");
        f3273y.put(b14, "p_papp");
        f3273y.put(b15, "p_bin");
        f3273y.put(b16, "p_usr");
        f3273y.put(b17, "p_acct");
        f3273y.put(b18, "p_dev");
        f3273y.put(b19, "p_con");
        f3273y.put(b20, "p_datas");
        f3273y.put(b21, "p_pro");
        f3273y.put(b22, "p_sys");
        f3273y.put(b23, "p_sfont");
        f3273y.put(b24, "p_fram");
        f3274z.add(b7);
        f3274z.add(b11);
        A.add(":00:00.");
        E = new FileFilter() { // from class: cn.jiguang.u.a.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                String name = file.getName();
                if (!name.startsWith("cpu")) {
                    return false;
                }
                for (int i6 = 3; i6 < name.length(); i6++) {
                    if (name.charAt(i6) < '0' || name.charAt(i6) > '9') {
                        return false;
                    }
                }
                return true;
            }
        };
        f3249a = new JSONArray();
    }

    public static String a(final Context context) {
        Object b6 = cn.jiguang.q.d.b(context, PointerIconCompat.TYPE_GRAB, true, false, (d.b) new d.a() { // from class: cn.jiguang.u.a.1
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return a.i(context);
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    String unused = a.D = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return a.D;
            }
        });
        if (b6 instanceof String) {
            D = (String) b6;
        }
        return D;
    }

    public static JSONArray b(final Context context) {
        Object a6 = cn.jiguang.q.e.a(context, 1022, new e.a() { // from class: cn.jiguang.u.a.3
            @Override // cn.jiguang.q.e.b
            public Object a() {
                return a.f3249a.length() > 0 ? a.f3249a.toString() : "";
            }

            @Override // cn.jiguang.q.e.b
            public void a(Object obj) {
                try {
                    a.f3249a = new JSONArray((String) obj);
                } catch (Throwable unused) {
                }
            }

            @Override // cn.jiguang.q.e.b
            public Object b() {
                JSONArray j6 = a.j(context);
                return j6.length() > 0 ? j6.toString() : "";
            }
        });
        JSONArray jSONArray = new JSONArray();
        try {
            if (!cn.jiguang.q.e.a(a6)) {
                return new JSONArray((String) a6);
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    private static String c(String str) {
        for (String str2 : cn.jiguang.v.c.a(new String[]{l.b(f3253e) + str}, 1)) {
            if (str2.startsWith("Access:")) {
                try {
                    String trim = str2.replace("Access:", "").trim();
                    Iterator<String> it = A.iterator();
                    while (it.hasNext()) {
                        if (trim.contains(it.next())) {
                            return null;
                        }
                    }
                    if (Math.abs(B.parse(trim).getTime() - System.currentTimeMillis()) > C) {
                        return trim;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    public static String d(Context context) {
        String str;
        String str2 = (String) cn.jiguang.e.b.b(context, new cn.jiguang.e.a("cn.jpush.preferences.v2", "n_udp_report_device_info", ""));
        if (TextUtils.isEmpty(str2)) {
            str = (String) cn.jiguang.e.b.b(context, new cn.jiguang.e.a("cn.jpush.preferences.v2", "udp_report_device_info", ""));
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        } else {
            str = new String(Base64.decode(str2, 2));
        }
        f.c("JDeviceHelper", "read deviceinfo:" + str);
        return str;
    }

    public static JSONObject e(Context context) {
        try {
            String c6 = new cn.jiguang.bn.c().c(context);
            if (TextUtils.isEmpty(c6)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(c6);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cid", jSONObject.optString("deviceId", ""));
            jSONObject2.put("imei", jSONObject.optString("imei", ""));
            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, jSONObject.optString("androidId", ""));
            jSONObject2.put("uuid", jSONObject.optString("uuid", ""));
            jSONObject2.put("time_stamp", jSONObject.optLong("genIdTimeStamp", 0L));
            jSONObject2.put("f_type", jSONObject.optInt("deviceIdFromType", -1));
            jSONObject2.put("imei_udid", jSONObject.optString("newImei", ""));
            return jSONObject2;
        } catch (Throwable th) {
            f.i("JDeviceHelper", "cid failed, " + th.getMessage());
            return null;
        }
    }

    public static JSONObject f(Context context) {
        try {
            if (!cn.jiguang.g.a.a().e(1029)) {
                return null;
            }
            JSONObject jSONObject = F;
            if (jSONObject != null && jSONObject.length() > 0) {
                return F;
            }
            JSONObject jSONObject2 = new JSONObject();
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<String, String>> it = f3273y.entrySet().iterator();
            while (true) {
                String str = "";
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String b6 = b(key);
                if (!f3274z.contains(key)) {
                    str = ContainerUtils.FIELD_DELIMITER + c(key);
                }
                String str2 = b6 + str;
                sb.append(str2);
                jSONObject2.put(next.getValue(), str2);
            }
            String d6 = cn.jiguang.bz.a.a().d(context, "");
            sb.append(cn.jiguang.bz.a.a().y(context));
            jSONObject2.put("p_imei", d6);
            sb.append(d6);
            String o5 = cn.jiguang.bz.a.a().o(context);
            jSONObject2.put("p_android_id", o5);
            sb.append(o5);
            try {
                JSONObject a6 = cn.jiguang.x.a.a(context);
                if (a6 != null) {
                    String string = a6.getString("joad");
                    jSONObject2.put("p_oaid", string);
                    sb.append(string);
                }
            } catch (Throwable th) {
                f.c("JDeviceHelper", "ncid box data throwable " + th);
            }
            jSONObject2.put("new_cid_all", w.d(sb.toString()));
            f.c("JDeviceHelper", "ncid box data is aaa " + jSONObject2.toString());
            F = jSONObject2;
            return jSONObject2;
        } catch (Throwable th2) {
            f.i("JDeviceHelper", "ncid failed, " + th2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Context context) {
        double pow;
        int i6;
        Point point = new Point();
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 31) {
                try {
                    Rect rect = (Rect) t.a(t.a(((Activity) context).getWindowManager(), "getMaximumWindowMetrics", (Object[]) null, (Class[]) null), "getBounds", (Object[]) null, (Class[]) null);
                    point.x = rect.right - rect.left;
                    point.y = rect.bottom - rect.top;
                } catch (Exception unused) {
                }
            } else {
                defaultDisplay.getRealSize(point);
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (context instanceof Activity) {
            pow = Math.pow(point.x / displayMetrics.xdpi, 2.0d);
            i6 = point.y;
        } else {
            pow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
            i6 = displayMetrics.heightPixels;
        }
        return String.format(Locale.ENGLISH, "%.1f", Double.valueOf(Math.sqrt(pow + Math.pow(i6 / displayMetrics.ydpi, 2.0d))));
    }

    public static String a(Context context, int i6) {
        if (i6 != 53) {
            return null;
        }
        try {
            String d6 = d(context);
            if (TextUtils.isEmpty(d6)) {
                d6 = c(context);
            }
            JSONObject jSONObject = new JSONObject(d6);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(JThirdPlatFormInterface.KEY_ROM_TYPE, (int) cn.jiguang.bi.b.a().b(context));
            jSONObject2.put("regid", cn.jiguang.bi.b.a().c(context));
            jSONObject.put("rom_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", 53);
            jSONObject3.put("content", jSONObject);
            return jSONObject3.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray j(Context context) {
        JSONObject a6;
        List<cn.jiguang.t.a> b6 = c.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        JSONArray jSONArray = new JSONArray();
        if (b6 != null) {
            for (cn.jiguang.t.a aVar : b6) {
                if (aVar != null && (a6 = aVar.a()) != null) {
                    jSONArray.put(a6);
                }
            }
        }
        f.c("JDeviceHelper", "getSimInfos is " + jSONArray.toString());
        return jSONArray;
    }

    public static void a(Context context, String str) {
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{new cn.jiguang.e.a("cn.jpush.preferences.v2", "n_udp_report_device_info", "").a((cn.jiguang.e.a) Base64.encodeToString(str.getBytes(), 2))});
        f.c("JDeviceHelper", "save device info:" + str);
    }
}

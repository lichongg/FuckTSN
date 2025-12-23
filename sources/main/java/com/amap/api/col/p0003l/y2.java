package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class y2 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7741a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f7742b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f7743c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f7744d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f7745e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f7746f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f7747g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f7748h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f7749i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f7750j;

    /* renamed from: k, reason: collision with root package name */
    private static HashMap<String, Boolean> f7751k = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f7752l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f7753m = new ConcurrentHashMap<>();

    private static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb.append("\"" + entry.getKey() + "\":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("}");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String b(boolean z5) {
        try {
            return "{\"Quest\":" + z5 + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void c(Context context) {
        if (f7743c) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            i(context, "O009", a(hashMap));
            f7743c = true;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context, int i6) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_draw_fail", Integer.valueOf(i6));
            i(context, "O023", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void e(Context context, int i6, int i7, String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (f7752l) {
                try {
                    if (!f7752l.containsKey(Integer.valueOf(i6)) || f7752l.get(Integer.valueOf(i6)).intValue() < 2) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("amap_3dmap_map_request_type", String.valueOf(i7));
                        hashMap.put("amap_3dmap_map_request_info", str);
                        i(context, "O019", a(hashMap));
                        if (f7752l.containsKey(Integer.valueOf(i6))) {
                            f7752l.put(Integer.valueOf(i6), Integer.valueOf(f7752l.get(Integer.valueOf(i6)).intValue() + 1));
                        } else {
                            f7752l.put(Integer.valueOf(i6), 0);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context, int i6, long j6, long j7) {
        try {
            synchronized (f7753m) {
                try {
                    if (!f7753m.containsKey(Integer.valueOf(i6)) || f7753m.get(Integer.valueOf(i6)).intValue() < 2) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("amap_3dmap_map_request_rendertime", Long.valueOf(j6));
                        hashMap.put("amap_3dmap_map_request_size", Long.valueOf(j7));
                        i(context, "O020", a(hashMap));
                        if (f7753m.containsKey(Integer.valueOf(i6))) {
                            f7753m.put(Integer.valueOf(i6), Integer.valueOf(f7753m.get(Integer.valueOf(i6)).intValue() + 1));
                        } else {
                            f7753m.put(Integer.valueOf(i6), 0);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context, long j6) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j6));
            hashMap.put("amap_3dmap_render_background", 0L);
            i(context, "O005", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static synchronized void h(Context context, String str) {
        synchronized (y2.class) {
            try {
                if (f7751k != null && !TextUtils.isEmpty(str)) {
                    if (f7751k.containsKey(str) && f7751k.get(str).booleanValue()) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_coordinate", str);
                    i(context, "O008", a(hashMap));
                    if (!f7751k.containsKey(str)) {
                        f7751k.put(str, Boolean.TRUE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void i(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            h7 h7Var = new h7(context, "3dmap", "10.0.600", str);
            h7Var.a(str2);
            i7.d(h7Var, context);
        } catch (Throwable unused) {
        }
    }

    public static void k(Context context) {
        if (f7744d) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            i(context, "O010", a(hashMap));
            f7744d = true;
        } catch (Throwable unused) {
        }
    }

    public static void l(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            i(context, "O021", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void m(Context context, boolean z5) {
        if (f7741a) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z5 ? 1 : 0));
            i(context, "O006", a(hashMap));
            f7741a = true;
        } catch (Throwable unused) {
        }
    }

    public static void n(Context context) {
        if (f7745e) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            i(context, "O011", a(hashMap));
            f7745e = true;
        } catch (Throwable unused) {
        }
    }

    public static void o(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            i(context, "O022", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void p(Context context, boolean z5) {
        if (f7742b) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z5 ? 1 : 0));
            i(context, "O007", a(hashMap));
            f7742b = true;
        } catch (Throwable unused) {
        }
    }

    public static void q(Context context) {
        if (f7747g) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            i(context, "O012", a(hashMap));
            f7747g = true;
        } catch (Throwable unused) {
        }
    }

    public static void r(Context context) {
        if (f7748h) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            i(context, "O013", a(hashMap));
            f7748h = true;
        } catch (Throwable unused) {
        }
    }

    public static void s(Context context) {
        if (f7749i) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_dxmapreview", 1);
            i(context, "0016", a(hashMap));
            f7749i = true;
        } catch (Throwable unused) {
        }
    }

    public static void t(Context context) {
        if (f7746f) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            i(context, "O014", a(hashMap));
            f7746f = true;
        } catch (Throwable unused) {
        }
    }

    public static void u(Context context) {
        if (f7750j) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            i(context, "O015", a(hashMap));
            f7750j = true;
        } catch (Throwable unused) {
        }
    }

    public static void j(Context context, boolean z5) {
        try {
            String b6 = b(z5);
            h7 h7Var = new h7(context, "3dmap", "10.0.600", "O001");
            h7Var.a(b6);
            i7.d(h7Var, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

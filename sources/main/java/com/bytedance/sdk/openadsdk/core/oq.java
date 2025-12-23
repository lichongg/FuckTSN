package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.content.pm.e1;
import androidx.core.content.pm.o0;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.i.cw.cw.cw;
import com.bytedance.sdk.openadsdk.i.cw.cw.r;
import com.qq.e.comm.managers.status.SDKStatus;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {

    /* renamed from: j, reason: collision with root package name */
    public static final com.bytedance.sdk.openadsdk.i.cw.cw.r f29757j = new j();

    /* renamed from: a, reason: collision with root package name */
    private volatile Function<SparseArray<Object>, Object> f29758a;
    private volatile String ae;
    private String av;
    private volatile com.bytedance.sdk.openadsdk.i.cw.cw.r az;

    /* renamed from: c, reason: collision with root package name */
    private String f29759c;
    private boolean ch;
    private volatile String cw;
    private String ed;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f29760f;

    /* renamed from: g, reason: collision with root package name */
    private volatile int f29761g;
    private up gq;
    private r gx;

    /* renamed from: h, reason: collision with root package name */
    private int f29762h;

    /* renamed from: i, reason: collision with root package name */
    private String f29763i;
    private Bitmap jy;
    private Function<SparseArray<Object>, Object> kt;

    /* renamed from: l, reason: collision with root package name */
    private int f29764l;
    private long la;

    /* renamed from: m, reason: collision with root package name */
    private volatile String f29765m;
    private volatile boolean mi;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f29766n;
    private com.bytedance.sdk.openadsdk.core.playable.r nd;
    private volatile boolean oq;

    /* renamed from: p, reason: collision with root package name */
    private int f29767p;
    private final Set<Integer> qv;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f29768r;
    private String rh;
    private boolean rn;

    /* renamed from: s, reason: collision with root package name */
    private boolean f29769s;
    private volatile boolean tj;
    private volatile com.bytedance.sdk.openadsdk.core.s.j tl;
    private String uf;
    private volatile String up;

    /* renamed from: v, reason: collision with root package name */
    private volatile JSONObject f29770v;
    private volatile boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f29771w;
    private volatile String wq;
    private volatile com.bytedance.sdk.openadsdk.core.rn.j ws;

    /* renamed from: x, reason: collision with root package name */
    private HashMap<String, Object> f29772x;
    private volatile String xt;

    public static class cw {

        /* renamed from: j, reason: collision with root package name */
        public static final com.bytedance.sdk.component.r.j.xt f29774j = com.bytedance.sdk.openadsdk.core.rn.h.j("sp_global_info");
    }

    public static final class j extends com.bytedance.sdk.openadsdk.i.cw.cw.r {
        public j() {
            super(null);
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean ae() {
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean j() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xt.j(7, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean jy() {
            return true;
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean cw() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xt.j(9, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public com.bytedance.sdk.openadsdk.i.cw.cw.cw g() {
            String[] split;
            String j6 = com.bytedance.sdk.openadsdk.tools.xt.j(8, "");
            if (TextUtils.isEmpty(j6) || (split = j6.split(",")) == null) {
                return null;
            }
            String str = split.length > 0 ? split[0] : "";
            String str2 = split.length > 1 ? split[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new cw.j().j(Double.valueOf(str).doubleValue()).xt(Double.valueOf(str2).doubleValue()).j();
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean m() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xt.j(22, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public String oq() {
            return com.bytedance.sdk.openadsdk.tools.xt.j(10, "");
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public String qv() {
            return com.bytedance.sdk.openadsdk.tools.xt.j(18, "");
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean r() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xt.j(11, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean tl() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xt.j(24, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean up() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xt.j(12, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public String vl() {
            return com.bytedance.sdk.openadsdk.tools.xt.j(13, "");
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.cw.r
        public boolean xt() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xt.j(17, "1"));
        }
    }

    public static class r {

        /* renamed from: j, reason: collision with root package name */
        private Map<String, Object> f29777j;
        private String xt;

        public void j(JSONObject jSONObject) throws JSONException {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.f29777j) == null || map.size() == 0 || TextUtils.isEmpty(this.xt)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.f29777j.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.xt));
        }

        public r(Map<String, Object> map, String str) {
            this.f29777j = map;
            this.xt = str;
        }
    }

    private static class xt {

        /* renamed from: j, reason: collision with root package name */
        private static oq f29778j = new oq();
    }

    public static oq i() {
        return xt.f29778j;
    }

    public static Object pz() {
        Map map;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(invoke);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("isTopResumedActivity");
                declaredField2.setAccessible(true);
                if (declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return declaredField3.get(obj);
                }
            }
            return null;
        }
        return null;
    }

    public boolean ae() {
        return this.f29766n;
    }

    public void av() {
        this.f29766n = com.bytedance.sdk.openadsdk.core.r.j.xt();
    }

    public void az() {
        av();
        Context context = v.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.api.m.j.j(context);
        }
        this.qv.add(4);
        cw(context);
    }

    public boolean cw() {
        Object systemService;
        boolean isRequestPinShortcutSupported;
        if (!this.f29769s && Build.VERSION.SDK_INT >= 26) {
            this.f29769s = true;
            try {
                systemService = v.getContext().getSystemService((Class<Object>) o0.a());
                ShortcutManager a6 = e1.a(systemService);
                if (a6 != null) {
                    isRequestPinShortcutSupported = a6.isRequestPinShortcutSupported();
                    this.ch = isRequestPinShortcutSupported;
                }
            } catch (Throwable unused) {
            }
        }
        return this.ch;
    }

    public boolean g() {
        return oq() && ae();
    }

    public boolean jy() {
        return com.bytedance.sdk.openadsdk.av.cw.j().g();
    }

    public String m() {
        return com.bytedance.sdk.openadsdk.av.cw.j().xt();
    }

    public boolean oq() {
        return !qv() && tl();
    }

    public boolean qv() {
        return com.bytedance.sdk.openadsdk.av.cw.j().ae();
    }

    public com.bytedance.sdk.openadsdk.core.rn.j r() {
        if (this.ws == null) {
            cw(v.getContext());
        }
        return this.ws;
    }

    public boolean tl() {
        return com.bytedance.sdk.openadsdk.av.cw.j().m();
    }

    public boolean up() {
        return com.bytedance.sdk.openadsdk.av.cw.j().up();
    }

    public boolean vl() {
        return com.bytedance.sdk.openadsdk.av.cw.j().tl();
    }

    public com.bytedance.sdk.openadsdk.i.cw.cw.r w() {
        return new l(kt());
    }

    public void ws() {
        com.bytedance.sdk.openadsdk.av.cw.j().r();
    }

    public String xt() {
        if (TextUtils.isEmpty(this.wq)) {
            this.wq = com.bytedance.sdk.openadsdk.core.qv.g.j();
        }
        return this.wq;
    }

    private oq() {
        this.tl = new com.bytedance.sdk.openadsdk.core.s.j(2);
        this.f29761g = 0;
        this.oq = true;
        this.qv = Collections.synchronizedSet(new HashSet());
        this.vl = false;
        this.jy = null;
        this.f29771w = false;
        this.mi = true;
        this.tj = true;
        this.f29760f = 0;
        this.f29770v = new JSONObject();
        this.f29772x = new HashMap<>();
        this.ch = false;
        this.f29769s = false;
        this.f29758a = null;
        this.f29764l = -1;
        this.f29767p = -1;
        this.f29762h = -1;
        this.la = -1L;
        this.rh = null;
    }

    private static void av(String str) {
        com.bytedance.sdk.component.utils.av.j(str, "name不能为空");
    }

    private static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.av.j(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap hashMap = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z5 = false;
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                if (!optJSONObject.isNull("__name__")) {
                    String optString = optJSONObject.optString("__name__");
                    String optString2 = optJSONObject.optString("value");
                    if (!TextUtils.isEmpty(optString)) {
                        hashMap.put(optString, optString2);
                    }
                } else if ("csj_rit_list".equals(optJSONObject.optString(CommonNetImpl.NAME))) {
                    g(optJSONObject.optString("value"));
                    jSONArray.remove(i6);
                    z5 = true;
                } else {
                    jSONArray2.put(optJSONObject);
                }
            }
        }
        if (z5) {
            this.f29765m = jSONArray.toString();
        } else {
            this.f29765m = str;
        }
        if ((jSONArray2.length() == 0 && hashMap.isEmpty()) || jSONArray2.length() != 0) {
            this.f29765m = jSONArray2.toString();
        }
        if (hashMap.isEmpty()) {
            return;
        }
        this.f29772x.putAll(hashMap);
    }

    private static com.bytedance.sdk.openadsdk.i.cw.cw.r qa() {
        return new r.j().xt(true).j(true).j((com.bytedance.sdk.openadsdk.i.cw.cw.cw) null).cw(true).j((String) null).r(true).xt((String) null).up(true).cw((String) null).m(true).r((String) null).ae(false).j();
    }

    private static void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.av.j(str.length() <= 20000, "data超长, 最长为20000");
    }

    private static final HashMap<String, Object> ws(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    hashMap.put(next, jSONObject.opt(next));
                }
            }
            return hashMap;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public String a() {
        return !TextUtils.isEmpty(this.f29765m) ? this.f29765m : com.bytedance.sdk.openadsdk.core.cw.r.j().tl("");
    }

    public void ae(String str) {
        m(str);
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            com.bytedance.sdk.openadsdk.core.cw.r.j().ae(str);
            com.bytedance.sdk.openadsdk.core.cw.r.j().g(j(this.f29772x));
        }
    }

    public String aq() {
        return cw.f29774j.xt("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/ad_preview.html");
    }

    public String b() {
        if (!TextUtils.isEmpty(this.f29763i)) {
            return this.f29763i;
        }
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        String xt2 = j6.xt("any_door_id", (String) null);
        this.f29763i = xt2;
        if (!TextUtils.isEmpty(xt2)) {
            return this.f29763i;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        j6.j("any_door_id", valueOf);
        this.f29763i = valueOf;
        return valueOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r7 = this;
            java.lang.String r0 = "gdt_version"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = r7.uf()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L27
            java.lang.String r3 = r7.wq()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L25
            java.lang.String r3 = r7.ed()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L27
        L25:
            java.lang.String r2 = "1.0.0"
        L27:
            r1.put(r0, r2)     // Catch: org.json.JSONException -> L2b
            goto L2c
        L2b:
        L2c:
            java.lang.String r2 = "com.byted.mixed"
            int r3 = com.bytedance.sdk.openadsdk.l.qv.cw(r2)
            if (r3 == 0) goto L72
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 0
        L46:
            int r6 = r3.length()
            if (r5 >= r6) goto L63
            char r6 = r3.charAt(r5)
            r4.append(r6)
            int r6 = r3.length()
            int r6 = r6 + (-1)
            if (r5 == r6) goto L60
            java.lang.String r6 = "."
            r4.append(r6)
        L60:
            int r5 = r5 + 1
            goto L46
        L63:
            java.lang.String r3 = r4.toString()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L72
            java.lang.String r3 = r4.toString()
            goto L74
        L72:
            java.lang.String r3 = "1.0.0.0"
        L74:
            boolean r0 = r1.has(r0)
            if (r0 == 0) goto L97
            java.lang.String r0 = "app_id"
            java.lang.String r4 = r7.xt     // Catch: org.json.JSONException -> L97
            r1.put(r0, r4)     // Catch: org.json.JSONException -> L97
            java.lang.String r0 = "plugin_version"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L97
            java.lang.String r0 = "sdk_version"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L97
            java.lang.String r0 = "plugin_update_network"
            java.lang.String r3 = "2"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L97
            org.json.JSONObject r0 = r7.f29770v     // Catch: org.json.JSONException -> L97
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L97
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.oq.c():void");
    }

    public String ch() {
        return !TextUtils.isEmpty(this.up) ? this.up : com.bytedance.sdk.openadsdk.core.cw.r.j().m("");
    }

    public boolean e() {
        return this.mi;
    }

    public String ed() {
        if (!TextUtils.isEmpty(this.f29759c)) {
            return this.f29759c;
        }
        try {
            Object obj = Class.forName("com.miui.zeus.mimo.sdk.BuildConfig").getField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                this.f29759c = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String f() {
        return !TextUtils.isEmpty(this.xt) ? this.xt : com.bytedance.sdk.openadsdk.core.cw.r.j().r();
    }

    public void g(boolean z5) {
        this.rn = z5;
    }

    public Function<SparseArray<Object>, Object> gx() {
        Function<SparseArray<Object>, Object> function = this.kt;
        if (function != null) {
            return function;
        }
        if (com.bytedance.sdk.openadsdk.i.cw.r.xt(h.xt)) {
            this.kt = com.bytedance.sdk.openadsdk.core.qv.r.av.j(v.getContext());
        } else {
            this.kt = m(3);
        }
        return this.kt;
    }

    public boolean hl() {
        return "5001121".equals(this.xt);
    }

    public boolean j() {
        return this.ws != null && this.ws.xt();
    }

    public long k() {
        return this.la;
    }

    public String kc() {
        return cw.f29774j.xt("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public com.bytedance.sdk.openadsdk.i.cw.cw.r kt() {
        if (this.az == null || this.az.jy()) {
            this.az = z() ? f29757j : qa();
        }
        return this.az;
    }

    public Map<String, Object> l() {
        if (!this.f29772x.isEmpty()) {
            return this.f29772x;
        }
        String oq = com.bytedance.sdk.openadsdk.core.cw.r.j().oq("");
        this.f29772x.putAll(TextUtils.isEmpty(oq) ? ws(oq) : new HashMap<>());
        return this.f29772x;
    }

    public boolean la() {
        return this.f29771w;
    }

    public void m(final String str) {
        w(str);
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("setUserData") { // from class: com.bytedance.sdk.openadsdk.core.oq.1
            @Override // java.lang.Runnable
            public void run() {
                oq.this.jy(str);
            }
        });
    }

    public String mi() {
        return this.rh;
    }

    public com.bytedance.sdk.openadsdk.core.playable.r n() {
        if (this.nd == null) {
            this.nd = new com.bytedance.sdk.openadsdk.core.playable.r(10, 8);
        }
        return this.nd;
    }

    public Function<SparseArray<Object>, Object> qb() {
        return this.f29758a;
    }

    public void qv(String str) {
        cw.f29774j.j("toolsAdPreviewUrl", str);
    }

    public String rr() {
        return cw.f29774j.xt("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/basic_info.html");
    }

    public Object ry() {
        WeakReference<Activity> j6 = this.ws.j();
        if (j6 != null) {
            return j6.get();
        }
        Object apply = this.f29758a != null ? this.f29758a.apply(com.bytedance.sdk.openadsdk.i.r.j().j(14).j(Activity.class).xt()) : null;
        return apply == null ? pz() : apply;
    }

    public com.bytedance.sdk.openadsdk.core.s.j s() {
        return this.tl;
    }

    public String sm() {
        return this.ae;
    }

    public r st() {
        return this.gx;
    }

    public boolean tj() {
        return cw.f29774j.xt("sdk_activate_init", true);
    }

    public void tl(String str) {
        up(str);
        com.bytedance.sdk.openadsdk.core.cw.r.j().up(str);
    }

    public String uf() {
        if (!TextUtils.isEmpty(this.uf)) {
            return this.uf;
        }
        try {
            Object invoke = SDKStatus.class.getMethod("getIntegrationSDKVersion", null).invoke(null, null);
            if (invoke instanceof String) {
                String str = (String) invoke;
                this.uf = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public void up(String str) {
        i(str);
        this.up = str;
    }

    public String v() {
        return !TextUtils.isEmpty(this.cw) ? this.cw : com.bytedance.sdk.openadsdk.core.cw.r.j().up();
    }

    public void vl(String str) {
        cw.f29774j.j("toolsBasicInfUrl", str);
    }

    public String wq() {
        if (!TextUtils.isEmpty(this.ed)) {
            return this.ed;
        }
        try {
            Object invoke = Class.forName(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME).getMethod("getSDKVersion", null).invoke(null, null);
            if (invoke instanceof String) {
                String str = (String) invoke;
                this.ed = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public int xq() {
        return this.f29762h;
    }

    public boolean ya() {
        return this.rn;
    }

    public boolean z() {
        return "5001121".equals(this.xt) && "com.union_test.toutiao".equals(com.bytedance.sdk.openadsdk.core.rn.uf.g());
    }

    public boolean zz() {
        com.bytedance.sdk.component.r.j.xt xtVar = cw.f29774j;
        if (xtVar.xt("update_advance_preview_mode", false)) {
            long xt2 = xtVar.xt("update_advance_preview_mode_time", -1L);
            if (xt2 != -1) {
                if (System.currentTimeMillis() - xt2 <= 3600000) {
                    return true;
                }
                oq(false);
            }
        }
        return false;
    }

    public String ff() {
        try {
            if ((v.xt().ll() & 1) == 1) {
                return com.bytedance.sdk.openadsdk.core.cw.up.j().up();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void g(String str) {
        this.ae = str;
        com.bytedance.sdk.openadsdk.core.p.tl.j((com.bytedance.sdk.openadsdk.core.p.up) null).j(true);
    }

    public void gq() {
        com.bytedance.sdk.openadsdk.core.cw.r.j().xt(this.f29760f);
        com.bytedance.sdk.openadsdk.core.cw.r.j().j(this.xt);
        com.bytedance.sdk.openadsdk.core.cw.r.j().xt(this.cw);
        com.bytedance.sdk.openadsdk.core.cw.r.j().xt(this.f29768r);
        com.bytedance.sdk.openadsdk.core.cw.r.j().up(this.up);
        com.bytedance.sdk.openadsdk.core.cw.r.j().ae(this.f29765m);
        com.bytedance.sdk.openadsdk.core.cw.r.j().g(j(this.f29772x));
        com.bytedance.sdk.component.r.j.xt xtVar = cw.f29774j;
        xtVar.j("title_bar_theme", this.f29761g);
        xtVar.j("allow_show_notify", this.oq);
        com.bytedance.sdk.openadsdk.core.cw.r.j().r(this.vl);
        Set<Integer> set = this.qv;
        if (set != null && !set.isEmpty()) {
            Iterator<Integer> it = this.qv.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            cw.f29774j.j("network_state", sb.toString());
            return;
        }
        xtVar.j("network_state");
    }

    public boolean h() {
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            return cw.f29774j.xt("allow_show_notify", true);
        }
        return this.oq;
    }

    public String hh() {
        if (com.bytedance.sdk.openadsdk.core.cw.cw.j().xt()) {
            String xt2 = cw.f29774j.xt("tob_ab_sdk_version", "");
            if (TextUtils.isEmpty(xt2)) {
                return "";
            }
            return xt2;
        }
        if (TextUtils.isEmpty(this.av)) {
            return "";
        }
        return this.av;
    }

    public boolean j(boolean z5) {
        return this.ws != null && this.ws.j(z5);
    }

    public boolean nd() {
        if (com.bytedance.sdk.openadsdk.core.cw.cw.j().xt()) {
            return com.bytedance.sdk.openadsdk.core.cw.r.j().cw(false);
        }
        return this.vl;
    }

    public int ol() {
        if (com.bytedance.sdk.openadsdk.core.cw.cw.j().xt()) {
            int m6 = com.bytedance.sdk.openadsdk.core.cw.r.j().m();
            if (m6 == Integer.MIN_VALUE) {
                return this.f29760f;
            }
            return m6;
        }
        return this.f29760f;
    }

    public void oq(boolean z5) {
        com.bytedance.sdk.component.r.j.xt xtVar = cw.f29774j;
        xtVar.j("update_advance_preview_mode", z5);
        xtVar.j("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public int p() {
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            return cw.f29774j.xt("title_bar_theme", 0);
        }
        return this.f29761g;
    }

    public int q() {
        return com.bytedance.sdk.openadsdk.core.cw.r.j().r(0);
    }

    public Bitmap rh() {
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            return com.bytedance.sdk.component.utils.r.j(cw.f29774j.xt("pause_icon", ""));
        }
        return this.jy;
    }

    public JSONObject rn() {
        if (h.xt()) {
            i().c();
        }
        return this.f29770v;
    }

    public boolean x() {
        if (com.bytedance.sdk.openadsdk.core.cw.cw.j().xt()) {
            return com.bytedance.sdk.openadsdk.core.cw.r.j().j(this.f29768r);
        }
        return this.f29768r;
    }

    public void j(String str) {
        this.wq = str;
    }

    public void m(boolean z5) {
        com.bytedance.sdk.component.utils.vl.r("bstsdk", "bst(true) stat-quit, run new pl");
        this.f29771w = z5;
        com.bytedance.sdk.openadsdk.core.r.j.j(true);
        com.bytedance.sdk.openadsdk.core.r.cw.j();
    }

    public void r(String str) {
        av(str);
        this.cw = str;
    }

    public void tl(boolean z5) {
        this.mi = z5;
    }

    public void up(boolean z5) {
        cw(z5);
        com.bytedance.sdk.openadsdk.core.cw.r.j().xt(z5);
    }

    public void xt(String str) {
        this.rh = str;
    }

    public boolean j(Activity activity) {
        return this.ws != null && this.ws.j(activity);
    }

    public void oq(String str) {
        cw.f29774j.j("toolsQueryHost", str);
    }

    public void xt(boolean z5) {
        cw.f29774j.j("sdk_activate_init", z5);
    }

    private static void az(String str) {
        com.bytedance.sdk.component.utils.av.j(str, "appid不能为空");
    }

    private void cw(Context context) {
        this.ws = new com.bytedance.sdk.openadsdk.core.rn.j();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.ws);
        } else {
            if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
                return;
            }
            ((Application) StubApp.getOrigApplicationContext(context.getApplicationContext())).registerActivityLifecycleCallbacks(this.ws);
        }
    }

    public void ae(boolean z5) {
        h.ae = z5;
        this.vl = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar) {
        this.az = rVar;
    }

    public void r(boolean z5) {
        this.oq = z5;
    }

    public void up(int i6) {
        com.bytedance.sdk.openadsdk.core.cw.r.j().cw(i6);
    }

    public void xt(int i6) {
        this.f29761g = i6;
    }

    public void j(int i6) {
        this.tl = new com.bytedance.sdk.openadsdk.core.s.j(i6, true);
    }

    public void r(int i6) {
        if (i6 < 0 || i6 > 2) {
            i6 = 0;
        }
        try {
            this.f29760f = i6;
        } catch (Throwable unused) {
        }
    }

    public boolean xt(Context context) {
        if (com.bytedance.sdk.openadsdk.core.a.j.j().up()) {
            this.f29767p = 2;
        } else {
            this.f29767p = 1;
        }
        return this.f29767p == 1;
    }

    public void ae(int i6) {
        this.f29762h = i6;
    }

    public void j(String str, String str2) {
        try {
            JSONObject optJSONObject = this.f29770v.optJSONObject(str);
            if (optJSONObject != null) {
                optJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.vl.r("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public Function<SparseArray<Object>, Object> m(int i6) {
        Object apply;
        if (this.f29758a == null) {
            return null;
        }
        apply = this.f29758a.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10).j(Object.class).j(0, Integer.valueOf(i6)).xt());
        return a1.b.a(apply);
    }

    public void j(String str, String str2, String str3, String str4) {
        try {
            JSONObject optJSONObject = this.f29770v.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.xt;
            }
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put("app_id", str4);
            optJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            optJSONObject.put("sdk_version", str2);
            this.f29770v.put(str, optJSONObject);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.xt("GlobalInfo", "addPluginConfig for " + str + " failed: " + e6.getMessage());
        }
    }

    public void cw(String str) {
        az(str);
        this.xt = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            jSONObject.put("sdk_version", h.cw);
            this.f29770v.put("com.byted.pangle", jSONObject);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public void cw(boolean z5) {
        this.f29768r = z5;
    }

    public void j(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() <= 0) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString("app_id", this.xt);
                    j(str, bundle2.getString("sdk_version"), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        }
    }

    public boolean cw(int i6) {
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            String xt2 = cw.f29774j.xt("network_state", "");
            if (!TextUtils.isEmpty(xt2)) {
                String[] split = xt2.split(",");
                if (split.length > 0) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str) && String.valueOf(i6).equals(str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        Set<Integer> set = this.qv;
        return set != null && set.contains(Integer.valueOf(i6));
    }

    public void j(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.qv.clear();
            for (int i6 : iArr) {
                this.qv.add(Integer.valueOf(i6));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    private static final String j(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    try {
                        jSONObject.putOpt(entry.getKey(), entry.getValue());
                    } catch (Exception e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
            }
            return jSONObject.toString();
        }
        return "";
    }

    public void j(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            String j6 = com.bytedance.sdk.component.utils.r.j(bitmap);
            if (!TextUtils.isEmpty(j6)) {
                cw.f29774j.j("pause_icon", j6);
            }
        }
        this.jy = bitmap;
    }

    public void j(Function<SparseArray<Object>, Object> function) {
        if (this.f29758a != null) {
            return;
        }
        this.f29758a = function;
    }

    public boolean j(Context context) {
        if (com.bytedance.sdk.openadsdk.core.a.j.j().up()) {
            this.f29764l = 2;
        } else {
            this.f29764l = 1;
        }
        return this.f29764l == 1;
    }

    public void j(long j6) {
        this.la = j6;
    }

    public void j(j.xt xtVar) {
        if (this.f29758a != null) {
            if (this.gq == null) {
                up upVar = new up();
                this.gq = upVar;
                upVar.j(this.f29758a);
            }
            this.gq.j(xtVar);
        }
    }

    public void j(r rVar) {
        this.gx = rVar;
    }
}

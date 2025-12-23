package com.bytedance.sdk.openadsdk.av;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.j.j.b;
import com.bytedance.j.xt.a;
import com.bytedance.j.xt.c;
import com.bytedance.j.xt.f;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.oq.qv;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.p;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static void xt(final Context context) {
        a.e(new c() { // from class: com.bytedance.sdk.openadsdk.av.j.1
            @Override // com.bytedance.j.xt.c
            public boolean j(final Throwable th, final Thread thread) {
                try {
                    qv.xt.ae(com.bytedance.sdk.openadsdk.core.h.j.f29119j);
                    if (!j.xt(th, null)) {
                        return false;
                    }
                    ae.xt(new g("tt_crash_handle") { // from class: com.bytedance.sdk.openadsdk.av.j.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            p.j().j(thread, th);
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // com.bytedance.j.xt.c
            public boolean j() {
                try {
                    return j.xt(null, Looper.getMainLooper().getThread());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        boolean z5 = false;
        boolean z6 = new SecureRandom().nextInt(10) == 0;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f fVar = new f() { // from class: com.bytedance.sdk.openadsdk.av.j.2
            @Override // com.bytedance.j.xt.f
            public List<String> m() {
                return null;
            }

            @Override // com.bytedance.j.xt.f
            public String r() {
                return null;
            }

            @Override // com.bytedance.j.xt.f
            public Map<String, Integer> up() {
                return null;
            }

            @Override // com.bytedance.j.xt.f
            public Map<String, Object> ae() {
                HashMap hashMap = new HashMap();
                String f6 = oq.i().f();
                if (TextUtils.isEmpty(f6)) {
                    f6 = String.valueOf(m.j().m());
                }
                hashMap.put("host_appid", f6);
                hashMap.put("sdk_version", "7.0.1.2");
                hashMap.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
                hashMap.put("channel", h.up());
                hashMap.put("sdk_api_version", h.cw);
                return hashMap;
            }

            @Override // com.bytedance.j.xt.f
            public Map<String, Object> j() {
                HashMap hashMap = new HashMap();
                String cw = m.j().cw();
                if (TextUtils.isEmpty(cw)) {
                    cw = kt.cw();
                }
                if (!TextUtils.isEmpty(cw)) {
                    hashMap.put("device_id", cw);
                }
                hashMap.put("ac", com.bytedance.sdk.component.g.r.m.cw(context));
                hashMap.put(CommonNetImpl.AID, m.j().m());
                hashMap.put("app_name", m.j().ae());
                String qv = uf.qv();
                if (!TextUtils.isEmpty(qv)) {
                    hashMap.put("app_version", qv);
                }
                String oq = uf.oq();
                if (!TextUtils.isEmpty(oq)) {
                    hashMap.put("version_code", oq);
                    try {
                        hashMap.put("update_version_code", Integer.valueOf(oq));
                    } catch (Exception e6) {
                        hashMap.put("update_version_code", 0);
                        e6.getMessage();
                    }
                }
                hashMap.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "7.0.1.2");
                hashMap.put("sdk_api_version", h.cw);
                hashMap.put("device_platform", FaceEnvironment.OS);
                hashMap.put("os", "Android");
                String v5 = kt.v();
                hashMap.put(bi.ai, v5);
                hashMap.put("device_mode", v5);
                hashMap.put("rom", ch.j());
                hashMap.put("cpu_abi", Build.CPU_ABI);
                hashMap.put(bi.F, Build.BRAND);
                hashMap.put("channel", h.up());
                hashMap.put("language", Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String str = Build.VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put("os_version", str);
                } catch (Exception unused) {
                }
                hashMap.put("openudid", kt.m());
                hashMap.put("dpi", String.valueOf(ed.tl(context)));
                hashMap.put("resolution", ed.r(context) + "*" + ed.up(context));
                return hashMap;
            }

            @Override // com.bytedance.j.xt.f
            public String cw() {
                return m.j().r();
            }

            @Override // com.bytedance.j.xt.f
            public String xt() {
                String cw = kt.cw();
                if (TextUtils.isEmpty(cw)) {
                    return "0";
                }
                return cw;
            }
        };
        boolean z7 = (v.xt().to() & 2) == 0;
        if (z6 && (v.xt().to() & 1) == 0) {
            z5 = true;
        }
        a.a(origApplicationContext, fVar, z7, z5);
        tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.av.j.3
            @Override // java.lang.Runnable
            public void run() {
                if (!com.bytedance.sdk.openadsdk.core.r.j.cw()) {
                    boolean w5 = v.xt().w();
                    boolean j6 = j.j();
                    if (w5 && j6) {
                        a.d(new b() { // from class: com.bytedance.sdk.openadsdk.av.j.3.1
                        });
                    }
                }
            }
        }, 5000L);
    }

    public static void j(Context context) {
        xt(context);
    }

    public static boolean j() {
        int i6;
        try {
            String zz = v.xt().zz();
            if (!TextUtils.isEmpty(zz) && zz.contains(";")) {
                String[] split = zz.split(";");
                if (split.length != 2) {
                    return true;
                }
                String str = split[0];
                String str2 = split[1];
                Long l6 = -1L;
                try {
                    l6 = Long.valueOf(Long.valueOf(str).longValue() * 60000);
                    i6 = Integer.valueOf(str2).intValue();
                } catch (Exception e6) {
                    vl.xt("apm", "error", e6.getMessage());
                    i6 = -1;
                }
                if (l6.longValue() >= 0 && i6 >= 0 && i6 <= 60) {
                    if (l6.longValue() == 0 || i6 == 0 || l6.longValue() / i6 < 5000) {
                        return false;
                    }
                    String xt = xt();
                    StringBuilder sb = new StringBuilder();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(xt)) {
                        sb.append(currentTimeMillis);
                        j(sb.toString());
                        return true;
                    }
                    String[] split2 = xt.split(";");
                    int length = split2.length;
                    if (length >= i6 && length != 0) {
                        boolean z5 = currentTimeMillis - Long.valueOf(split2[0]).longValue() > l6.longValue();
                        int i7 = length - i6;
                        for (int i8 = i7; i8 < length; i8++) {
                            String str3 = split2[i8];
                            if (i8 != i7 && !TextUtils.isEmpty(str3)) {
                                sb.append(str3);
                                sb.append(";");
                            }
                        }
                        sb.append(currentTimeMillis);
                        j(sb.toString());
                        return z5;
                    }
                    for (String str4 : split2) {
                        sb.append(str4);
                        sb.append(";");
                    }
                    sb.append(currentTimeMillis);
                    j(sb.toString());
                    return true;
                }
            }
            return true;
        } catch (Exception e7) {
            vl.j(e7);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xt(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        if (oq.i().la()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread != null ? thread.getStackTrace() : null;
        }
        String arrays = Arrays.toString(stackTrace);
        if (!arrays.contains(BuildConfig.LIBRARY_PACKAGE_NAME) && !arrays.contains("com.bytedance.sdk.component") && !arrays.contains("com.bykv.vk") && !arrays.contains("com.byted.csj.ext_impl") && !arrays.contains("com.bytedance.adsdk") && !arrays.contains("com.bytedance.msdk") && !arrays.contains("com.bytedance.sdk.gromore") && !arrays.contains("com.bytedance.sdk.openadsdk.mediation") && !arrays.contains("bykvm")) {
            return false;
        }
        Map<String, String> xt = com.bytedance.sdk.openadsdk.core.r.j().xt();
        if (xt == null) {
            return true;
        }
        if (arrays.contains("com.bytedance.sdk.openadsdk.core.nativeexpress")) {
            xt.put("express", "true");
        }
        if (arrays.contains(com.bytedance.sdk.openadsdk.core.live.j.class.getPackage().getName()) || arrays.contains("com.bytedance.sdk.openadsdk.live") || arrays.contains("com.bykv.vk.openvk.live")) {
            xt.put("live_sdk", "true");
        }
        if (!arrays.contains("com.bytedance.msdk") && !arrays.contains("com.bytedance.sdk.gromore") && !arrays.contains("com.bytedance.sdk.openadsdk.mediation") && !arrays.contains("bykvm")) {
            xt.put("mediation", "false");
        } else {
            xt.put("mediation", "true");
        }
        a.g(com.bytedance.sdk.openadsdk.core.r.j().xt());
        return true;
    }

    public static void j(String str) {
        com.bytedance.sdk.openadsdk.core.cw.r.j().xt("sp_apm_record", str);
    }

    public static String xt() {
        return com.bytedance.sdk.openadsdk.core.cw.r.j().cw("sp_apm_record", "");
    }
}

package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginDecodeCallback;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {

    /* renamed from: r, reason: collision with root package name */
    private static volatile BaseDexClassLoader f27562r;
    private static volatile TTPluginListener vl;

    /* renamed from: g, reason: collision with root package name */
    private final Context f27563g;

    /* renamed from: j, reason: collision with root package name */
    private static final String f27561j = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> xt = new HashMap<>();
    private static final HashMap<String, Handler> cw = new HashMap<>();
    private static volatile g up = null;

    /* renamed from: m, reason: collision with root package name */
    private final CountDownLatch f27564m = new CountDownLatch(1);
    private volatile boolean ae = false;
    private volatile String tl = "none";
    private JSONObject oq = new JSONObject();
    private EventListener qv = null;

    private static final class j {
        public String ae;
        public String cw;

        /* renamed from: m, reason: collision with root package name */
        public int f27574m;

        /* renamed from: r, reason: collision with root package name */
        public int f27575r;
        public String up;

        /* renamed from: j, reason: collision with root package name */
        public String f27573j = "";
        public File xt = null;

        /* renamed from: g, reason: collision with root package name */
        public int f27572g = 0;
        public int oq = Integer.MAX_VALUE;
        public List<String> tl = null;

        public boolean j() {
            return this.f27574m == 3;
        }

        j() {
        }
    }

    private static final class xt implements IZeusLogger {
        private xt() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.m.r(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.r(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.up(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.m.cw(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.m.j(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(a.b(3).e(0, 1).h(1, str).g(2, plugin.mClassLoader).k().sparseArray());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j up(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return j(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.m.up("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    static final class cw implements Serializable, Function<SparseArray<Object>, Object> {
        @Override // java.util.function.Function
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet k6 = a.j(sparseArray).k();
            int intValue = k6.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) k6.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 == null) {
                return null;
            }
            ValueSet k7 = a.j(sparseArray2).k();
            return j(intValue, com.bykv.j.j.j.j.g.a().b(k7.intValue(-999900)).d(k7.stringValue(-999901)).e(k7.booleanValue(-999903)).c(a.j((SparseArray) k7.objectValue(-999902, SparseArray.class)).k()).f());
        }

        cw() {
        }

        public SparseArray<Object> j(int i6, Result result) {
            a a6 = a.a();
            if (i6 == 1) {
                up.j("plugin_download", "plugin update start");
                ValueSet values = result.values();
                if (values == null) {
                    up.j("plugin_download", "valueSet empty");
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (result.isSuccess()) {
                    j up = g.up(values.stringValue(2));
                    if (up != null && !TextUtils.isEmpty(up.cw)) {
                        up.j("plugin_download", "plugin update received: " + up.cw);
                        com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "plugin update received: " + up.cw);
                        if (up.j()) {
                            up.j("plugin_download", "plugin revert " + up.cw);
                            Zeus.unInstallPlugin(up.cw);
                        } else {
                            j(up);
                            up.j("plugin_download", "plugin install");
                            if (g.xt(up)) {
                                a6.i(4, true);
                            }
                        }
                    } else {
                        up.j("plugin_download", "plugin update received with invalid config");
                        com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                } else {
                    up.j("plugin_download", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "plugin update received failed");
                    g.cw(stringValue, code);
                    return null;
                }
            }
            return a6.k().sparseArray();
        }

        private void j(j jVar) {
            try {
                if (TextUtils.isEmpty(jVar.cw) || !jVar.cw.equals("com.byted.pangle")) {
                    return;
                }
                g.j(TTAppContextHolder.getContext()).cw();
            } catch (Exception unused) {
            }
        }
    }

    private static File cw(Context context) {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(context, "tt_pangle_bykv_file", 0), f27561j);
    }

    public void xt() {
        try {
            Zeus.installFromDownloadDir();
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.j(th);
        }
    }

    private g(Context context) {
        this.f27563g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        xt(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(String str, int i6) {
        com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i6);
        TTPluginListener tTPluginListener = xt.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    private void xt(Context context) {
        try {
            com.bytedance.pangle.up.up.j(new com.bytedance.pangle.m() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.1
                @Override // com.bytedance.pangle.m
                public void cw(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void j(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.mi.j.j().cw().execute(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void xt(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.mi.j.j().cw().execute(runnable);
                }
            });
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.2
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put(CrashHianalyticsData.MESSAGE, jSONObject.opt(CrashHianalyticsData.MESSAGE));
                            g.this.oq.put("zeus", jSONObject2);
                        } catch (Exception e6) {
                            com.bytedance.sdk.openadsdk.api.m.j(e6);
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        m.j(str, jSONObject);
                    } else {
                        m.xt(str, jSONObject);
                    }
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void saveRecord(String str, String str2) {
                    up.j(str, str2);
                }
            };
            com.bytedance.pangle.up.up.j(new com.bytedance.pangle.m() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.3
                @Override // com.bytedance.pangle.m
                public void cw(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void j(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.mi.j.j().cw().execute(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void xt(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.mi.j.j().cw().execute(runnable);
                }
            });
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(cw(context));
            globalParam.setLogger(new xt());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.4
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i6, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", str + " state changed, " + i6);
                    if (i6 != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                        return;
                    }
                    g.this.r(str);
                }
            });
            Zeus.setDecodeCallback(new ZeusPluginDecodeCallback() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.5
                @Override // com.bytedance.pangle.ZeusPluginDecodeCallback
                public String decode(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String optString = jSONObject.optString("cypher");
                        String optString2 = jSONObject.optString(CrashHianalyticsData.MESSAGE);
                        if (!TextUtils.equals(optString, "3") || TextUtils.isEmpty(optString2)) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.api.plugin.cw.xt.xt(optString2);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "dex plugin decode throw error ".concat(String.valueOf(th)));
                        return null;
                    }
                }
            });
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isDexPlugin", 1);
                jSONObject.put("apiVersionCode", 1000);
                jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, "com.byted.mixed");
                jSONObject.put("hostPackageName", "com.byted.pangle");
                jSONObject.put("minPluginVersion", 1000);
                jSONObject.put("maxPluginVersion", 999999999);
                jSONObject.put("internalPath", "");
                jSONObject.put("internalVersionCode", -1);
                jSONObject.put("appKey", "");
                jSONObject.put("appSecretKey", "");
                Zeus.addPackageDexManager("com.byted.mixed", jSONObject);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "init dex plugin config throw error " + th);
            }
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.6
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i6, String str2) {
                    if (i6 == 7) {
                        g.this.xt(str, i6);
                        return;
                    }
                    if (i6 == 6) {
                        g.this.xt(str, i6);
                        if (g.this.qv == null || !"com.byted.pangle".equals(str)) {
                            com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "no main pl");
                        } else {
                            g.this.qv.onEvent(0, com.bykv.j.j.j.j.g.a().e(true).f());
                        }
                    }
                }
            });
            this.ae = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.tl = th2.getMessage();
        }
    }

    public static g j(Context context) {
        if (up == null) {
            synchronized (g.class) {
                try {
                    if (up == null) {
                        up = new g(context);
                    }
                } finally {
                }
            }
        }
        return up;
    }

    private static boolean r(Context context) {
        File cw2 = cw(context);
        return cw2.exists() && cw2.listFiles().length != 0;
    }

    public void cw() {
        EventListener eventListener = this.qv;
        if (eventListener != null) {
            eventListener.onEvent(1, com.bykv.j.j.j.j.g.a().e(true).f());
        }
    }

    public JSONObject j() {
        return this.oq;
    }

    public BaseDexClassLoader j(ae aeVar, int i6) throws Exception {
        boolean z5;
        String str;
        if (this.ae) {
            boolean xt2 = com.bytedance.sdk.openadsdk.api.plugin.cw.cw.xt();
            int i7 = 8;
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                if (xt2) {
                    new tl(this.f27563g).j();
                }
                if (r(this.f27563g)) {
                    Zeus.installFromDownloadDir();
                }
                try {
                    if (!xt2) {
                        com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "dont wait pl");
                    } else {
                        com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "wait start");
                        this.f27564m.await(i6, TimeUnit.MILLISECONDS);
                    }
                    com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "wait done");
                    aeVar.xt("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "Install wait time out");
                    throw new r(8, "install wait timeout");
                }
            }
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                f27562r = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z5 = true;
            } else {
                z5 = false;
            }
            aeVar.xt("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (f27562r == null) {
                if (this.f27564m.getCount() != 0) {
                    if (xt2) {
                        i7 = 10;
                        str = "this device does not support arm64-v8a, and install wait time out";
                    } else {
                        str = "install wait time out";
                    }
                    com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Install wait time out");
                    throw new r(i7, str);
                }
                if (z5) {
                    com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Get null after load");
                    throw new r(9, "Get null after load");
                }
            }
            aeVar.xt("get_classloader_done");
            return f27562r;
        }
        com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Zeus init failed.");
        throw new r(4, this.tl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(String str, int i6) {
        if ("com.byted.pangle".equals(str) && i6 == 6) {
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "notify to end wait");
            this.f27564m.countDown();
        }
        j(i6 == 6, str);
    }

    public static String xt(String str) {
        int installedMaxVer;
        try {
            Plugin plugin = Zeus.getPlugin(str, false);
            if (plugin == null || (installedMaxVer = plugin.getInstalledMaxVer()) <= 0) {
                return null;
            }
            return j(installedMaxVer);
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public Bundle j(String str, Bundle bundle) {
        String j6 = j(str);
        if (!TextUtils.isEmpty(j6)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, j6);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public void xt(TTPluginListener tTPluginListener) {
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", sb.toString());
        if (plugin != null) {
            j(plugin);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            vl = tTPluginListener;
        }
    }

    public static String j(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str, false) || (plugin = Zeus.getPlugin(str, false)) == null) {
                return null;
            }
            return j(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xt(j jVar) {
        File file;
        if (jVar != null && (file = jVar.xt) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(jVar.cw, file.getAbsolutePath());
            j(syncInstallPlugin, jVar.cw);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "plugin config is null");
        return false;
    }

    public void j(final TTPluginListener tTPluginListener) {
        if (!this.ae) {
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler xt2 = com.bytedance.sdk.openadsdk.mi.j.j().xt();
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        };
        xt2.postDelayed(runnable, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", sb.toString());
        if (plugin != null) {
            j(plugin);
            xt2.removeCallbacks(runnable);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            xt.put(packageName, tTPluginListener);
            cw.put(packageName, xt2);
        }
    }

    private static j j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        jVar.cw = jSONObject.optString(bi.f40972o);
        jVar.f27575r = jSONObject.optInt("version_code");
        jVar.up = jSONObject.optString("download_url");
        jVar.ae = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        jVar.f27572g = jSONObject.optInt("min_version");
        jVar.oq = jSONObject.optInt("max_version");
        jVar.f27573j = jSONObject.optString("sign");
        jVar.f27574m = jSONObject.optBoolean("is_revert") ? 3 : 2;
        jVar.xt = new File(jSONObject.optString("plugin_file"));
        return jVar;
    }

    private static void j(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(com.umeng.ccg.a.f41544t, 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, j(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String j(int i6) {
        char[] charArray = String.valueOf(i6).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < charArray.length; i7++) {
            sb.append(charArray[i7]);
            if (i7 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static boolean j(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void j(boolean z5, String str) {
        HashMap<String, TTPluginListener> hashMap = xt;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb = new StringBuilder("Install dl plugin ");
        sb.append(str);
        sb.append(z5 ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", sb.toString());
        HashMap<String, Handler> hashMap2 = cw;
        Handler handler = hashMap2.get(str);
        if (z5) {
            TTPluginListener tTPluginListener2 = vl;
            if (!j(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                j(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (j(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    vl = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "handle installed, load failed");
                cw(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.m.xt("TTPluginManager", "handle installed failed");
            cw(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void j(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.m.r("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}

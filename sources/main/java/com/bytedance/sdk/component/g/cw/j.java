package com.bytedance.sdk.component.g.cw;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.sdk.component.g.j;
import com.bytedance.sdk.component.oq.oq;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements l.j {

    /* renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f26423g;
    private static boolean tl;
    private com.bytedance.sdk.component.g.j jy;
    private final Context qv;
    private int ws;
    private final boolean xt;
    private volatile boolean cw = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26426r = true;
    private boolean up = false;

    /* renamed from: m, reason: collision with root package name */
    private long f26425m = 0;
    private long ae = 0;
    private AtomicBoolean oq = new AtomicBoolean(false);
    private volatile boolean vl = false;

    /* renamed from: j, reason: collision with root package name */
    final l f26424j = com.bytedance.sdk.component.oq.xt.j.j().j(this, "tt-net");

    private void r(boolean z5) {
        if (this.up) {
            return;
        }
        if (this.f26426r) {
            this.f26426r = false;
            this.f26425m = 0L;
            this.ae = 0L;
        }
        long j6 = z5 ? 360000L : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f26425m > j6) {
            if (currentTimeMillis - this.ae > 120000 || !this.vl) {
                cw();
            }
        }
    }

    public boolean cw() {
        com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "doRefresh: updating state " + this.oq.get());
        ae().execute(new Runnable() { // from class: com.bytedance.sdk.component.g.cw.j.2
            @Override // java.lang.Runnable
            public void run() {
                boolean j6 = com.bytedance.sdk.component.g.r.m.j(j.this.qv);
                if (j6) {
                    j.this.ae = System.currentTimeMillis();
                    if (j.this.oq.compareAndSet(false, true)) {
                        j.this.cw(j6);
                    } else {
                        com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "doRefresh, already running");
                    }
                }
            }
        });
        return true;
    }

    public static ThreadPoolExecutor ae() {
        if (f26423g == null) {
            synchronized (j.class) {
                try {
                    if (f26423g == null) {
                        com.bytedance.sdk.component.oq.r.r rVar = new com.bytedance.sdk.component.oq.r.r(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new oq("tnc/AppConfig"));
                        f26423g = rVar;
                        rVar.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f26423g;
    }

    private com.bytedance.sdk.component.g.j g() {
        if (this.jy == null) {
            j.C0409j c0409j = new j.C0409j();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.jy = c0409j.j(10L, timeUnit).xt(10L, timeUnit).cw(10L, timeUnit).j();
        }
        return this.jy;
    }

    public Context getContext() {
        return this.qv;
    }

    public j(Context context, int i6) {
        this.qv = context;
        this.xt = i.j(context);
        this.ws = i6;
    }

    private boolean tl() {
        String[] m6 = m();
        if (m6 != null && m6.length != 0) {
            j(0);
        }
        return false;
    }

    public static void xt(boolean z5) {
        tl = z5;
    }

    void cw(boolean z5) {
        com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "doRefresh, actual request");
        r();
        this.up = true;
        if (!z5) {
            this.f26424j.sendEmptyMessage(102);
            return;
        }
        try {
            tl();
        } catch (Exception unused) {
            this.oq.set(false);
        }
    }

    public String[] m() {
        String[] strArr;
        if (ae.j().j(this.ws).r() != null) {
            strArr = ae.j().j(this.ws).r().m();
        } else {
            strArr = null;
        }
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        return new String[0];
    }

    public void up() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                if (this.xt) {
                    r();
                } else {
                    xt();
                }
            } catch (Throwable unused) {
            }
        }
    }

    synchronized void xt() {
        if (System.currentTimeMillis() - this.f26425m > 3600000) {
            this.f26425m = System.currentTimeMillis();
            try {
                if (ae.j().j(this.ws).tl() != null) {
                    ae.j().j(this.ws).tl().xt();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void j() {
        j(false);
    }

    public synchronized void j(boolean z5) {
        if (this.xt) {
            r(z5);
            return;
        }
        if (this.f26425m <= 0) {
            try {
                ae().execute(new Runnable() { // from class: com.bytedance.sdk.component.g.cw.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.xt();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void r() {
        if (this.vl) {
            return;
        }
        this.vl = true;
        long j6 = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(this.qv, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j6 > currentTimeMillis) {
            j6 = currentTimeMillis;
        }
        this.f26425m = j6;
        try {
            if (ae.j().j(this.ws).tl() != null) {
                ae.j().j(this.ws).tl().j();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i6) {
        l lVar = this.f26424j;
        if (lVar != null) {
            lVar.sendEmptyMessage(i6);
        }
    }

    public static void j(Context context, int i6) {
        j j6;
        if (tl && (j6 = ae.j().j(i6, context)) != null) {
            if (i.j(context)) {
                j6.j(true);
            } else {
                j6.j();
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = message.what;
        if (i6 == 101) {
            this.up = false;
            this.f26425m = System.currentTimeMillis();
            com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "doRefresh, succ");
            if (this.f26426r) {
                j();
            }
            this.oq.set(false);
            return;
        }
        if (i6 != 102) {
            return;
        }
        this.up = false;
        if (this.f26426r) {
            j();
        }
        com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "doRefresh, error");
        this.oq.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString(CrashHianalyticsData.MESSAGE))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor edit = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(this.qv, "ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (ae.j().j(this.ws).tl() == null) {
            return true;
        }
        ae.j().j(this.ws).tl().j(jSONObject2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final int i6) {
        String[] m6 = m();
        if (m6 != null && m6.length > i6) {
            String str = m6[i6];
            if (TextUtils.isEmpty(str)) {
                xt(102);
                return;
            }
            try {
                String j6 = j(str);
                if (TextUtils.isEmpty(j6)) {
                    xt(102);
                    return;
                }
                com.bytedance.sdk.component.g.xt.cw cw = g().cw();
                cw.j(j6);
                j(cw);
                cw.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.component.g.cw.j.3
                    @Override // com.bytedance.sdk.component.g.j.j
                    public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                        JSONObject jSONObject;
                        if (xtVar == null || !xtVar.tl()) {
                            j.this.j(i6 + 1);
                            return;
                        }
                        String str2 = null;
                        try {
                            jSONObject = new JSONObject(xtVar.r());
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            j.this.j(i6 + 1);
                            return;
                        }
                        try {
                            str2 = jSONObject.getString(CrashHianalyticsData.MESSAGE);
                        } catch (Exception unused2) {
                        }
                        if (!"success".equals(str2)) {
                            j.this.j(i6 + 1);
                            return;
                        }
                        try {
                            if (j.this.j(jSONObject)) {
                                j.this.xt(101);
                            } else {
                                j.this.j(i6 + 1);
                            }
                        } catch (Exception unused3) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.g.j.j
                    public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                        j.this.j(i6 + 1);
                    }
                });
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.g.r.cw.xt("AppConfig", "try app config exception: ".concat(String.valueOf(th)));
                return;
            }
        }
        xt(102);
    }

    private String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return JPushConstants.HTTPS_PRE + str + "/get_domains/v4/";
    }

    private void j(com.bytedance.sdk.component.g.xt.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        Address j6 = ae.j().j(this.ws).r() != null ? ae.j().j(this.ws).r().j(this.qv) : null;
        if (j6 != null && j6.hasLatitude() && j6.hasLongitude()) {
            StringBuilder sb = new StringBuilder();
            sb.append(j6.getLatitude());
            cwVar.j("latitude", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j6.getLongitude());
            cwVar.j("longitude", sb2.toString());
            String locality = j6.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                cwVar.j(DistrictSearchQuery.KEYWORDS_CITY, Uri.encode(locality));
            }
        }
        if (this.cw) {
            cwVar.j("force", "1");
        }
        try {
            cwVar.j("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable th) {
            vl.j(th);
        }
        if (ae.j().j(this.ws).r() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(ae.j().j(this.ws).r().j());
            cwVar.j(CommonNetImpl.AID, sb3.toString());
            cwVar.j("device_platform", ae.j().j(this.ws).r().cw());
            cwVar.j("channel", ae.j().j(this.ws).r().xt());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(ae.j().j(this.ws).r().r());
            cwVar.j("version_code", sb4.toString());
            cwVar.j("custom_info_1", ae.j().j(this.ws).r().up());
        }
    }

    public static void j(ThreadPoolExecutor threadPoolExecutor) {
        f26423g = threadPoolExecutor;
    }
}

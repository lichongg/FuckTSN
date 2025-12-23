package com.huawei.hms.scankit.p;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a4 {

    /* renamed from: h, reason: collision with root package name */
    private static volatile a4 f33976h = new a4();

    /* renamed from: i, reason: collision with root package name */
    private static String[] f33977i = {"AD", "AL", "AN", "AT", "AU", "AX", "BA", "BE", "BG", "BQ", "CA", "CH", "CW", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FO", "FR", "GB", "GG", "GI", "GL", "GR", "HR", "HU", "IE", "IL", "IM", "IS", "IT", "JE", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MF", "MK", "MT", "NL", "NO", "NZ", "PL", "PM", "PT", "RO", "RS", "SE", "SI", "SJ", "SK", "SM", "SX", "TR", "UA", "UM", "US", "VA", "VC", "XK", "YK"};

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f33980c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f33981d;

    /* renamed from: a, reason: collision with root package name */
    private Timer f33978a = new Timer();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f33979b = true;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f33982e = false;

    /* renamed from: f, reason: collision with root package name */
    private final Lock f33983f = new ReentrantLock();

    /* renamed from: g, reason: collision with root package name */
    private List<b> f33984g = new ArrayList(5);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a4.this.d();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        private String f33986a;

        /* renamed from: b, reason: collision with root package name */
        private LinkedHashMap<String, String> f33987b;

        /* synthetic */ b(a4 a4Var, String str, LinkedHashMap linkedHashMap, a aVar) {
            this(str, linkedHashMap);
        }

        private b(String str, LinkedHashMap<String, String> linkedHashMap) {
            this.f33986a = str;
            this.f33987b = linkedHashMap;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends TimerTask {
        private c() {
        }

        /* synthetic */ c(a4 a4Var, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                a4.this.f33979b = true;
                com.huawei.hms.hatool.a.f();
            } catch (Exception e6) {
                o4.b("ScanHiAnalytics", e6.getMessage());
            }
        }
    }

    public static a4 b() {
        return f33976h;
    }

    private void c(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!this.f33982e) {
            com.huawei.hms.hatool.a.d(0, str, linkedHashMap);
            com.huawei.hms.hatool.a.d(1, str, linkedHashMap);
        }
        if (this.f33979b) {
            this.f33979b = false;
            this.f33978a.schedule(new c(this, null), 3000L);
        }
        o4.d("ScanHiAnalytics", str + " " + linkedHashMap.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.f33983f.tryLock() || this.f33980c) {
            return;
        }
        try {
            Context context = DynamicModuleInitializer.getContext();
            if (context == null) {
                return;
            }
            String a6 = a(context);
            if (a6 != null && !a6.isEmpty()) {
                com.huawei.hms.hatool.a.c(context, false, false, false, a6, context.getPackageName());
                com.huawei.hms.hatool.a.a();
                a();
            }
        } finally {
            this.f33983f.unlock();
        }
    }

    public void b(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.f33980c) {
            c(str, linkedHashMap);
        } else {
            a(str, linkedHashMap);
            c();
        }
    }

    private a4() {
    }

    private synchronized void a(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.f33980c) {
            c(str, linkedHashMap);
        } else {
            if (this.f33984g.size() >= 100) {
                return;
            }
            this.f33984g.add(new b(this, str, linkedHashMap, null));
        }
    }

    private synchronized void a() {
        try {
            this.f33980c = true;
            for (b bVar : this.f33984g) {
                c(bVar.f33986a, bVar.f33987b);
            }
            this.f33984g = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f33981d > 6000) {
            this.f33981d = currentTimeMillis;
            new a("ScanHiAnalytics").start();
        }
    }

    private String a(Context context) {
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            String a6 = new a1(context, false).a();
            if (a6 != null && !a6.isEmpty() && !"UNKNOWN".equals(a6)) {
                grsBaseInfo.setSerCountry(a6.toUpperCase(Locale.ENGLISH));
            }
            if (Arrays.asList(f33977i).contains(a6)) {
                this.f33982e = true;
            }
            GrsClient grsClient = new GrsClient(context, grsBaseInfo);
            String synGetGrsUrl = grsClient.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOTNEW");
            if (TextUtils.isEmpty(synGetGrsUrl)) {
                synGetGrsUrl = grsClient.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", org.slf4j.c.E0);
            }
            grsBaseInfo.getSerCountry();
            return synGetGrsUrl;
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }
}

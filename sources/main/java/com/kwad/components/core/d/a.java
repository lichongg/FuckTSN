package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.l;
import com.kwad.sdk.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.m;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static boolean Ob;
    private static boolean Oc;
    private static List<Throwable> Oe;
    private static Map<String, String> Of;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean Od = new AtomicBoolean(false);
    private static final List<b> Og = new CopyOnWriteArrayList();
    private static final List<c> Oh = new CopyOnWriteArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.d.a$a, reason: collision with other inner class name */
    static class C0611a {
        public static String an(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i6 >= 24 ? context.getDataDir() : null;
            if (dataDir != null) {
                return dataDir;
            }
            File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (file.exists()) {
                return file;
            }
            return new File("/data/data/" + context.getPackageName());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        String getKey();

        JSONObject getValue();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void onCrashOccur(int i6, String str);
    }

    public static void a(b bVar) {
        Og.add(bVar);
    }

    private static String[] oA() {
        String[] strArr = new String[1];
        try {
            String name = d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
            return strArr;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return strArr;
        }
    }

    public static void a(c cVar) {
        Oh.add(cVar);
    }

    private static String ah(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static synchronized void am(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!Od.get() && !Oc) {
                    Oc = true;
                    h.execute(new bg() { // from class: com.kwad.components.core.d.a.2
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (e.b(com.kwad.sdk.core.config.c.ayF)) {
                                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init Native");
                                com.kwad.sdk.crash.b.b(a.oy());
                                a.Od.set(true);
                            }
                        }
                    });
                }
            }
        }
    }

    private static void b(Throwable th) {
        if (Oe == null) {
            Oe = new CopyOnWriteArrayList();
        }
        Oe.add(th);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit.get() && !Ob) {
                    Ob = true;
                    h.execute(new bg() { // from class: com.kwad.components.core.d.a.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (e.b(com.kwad.sdk.core.config.c.ayF)) {
                                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init");
                                com.kwad.sdk.crash.b.a(a.oy());
                                a.mHasInit.set(true);
                                a.ow();
                                a.ox();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void j(String str, String str2) {
        if (mHasInit.get()) {
            com.kwad.sdk.crash.report.h.ah(str, str2);
        } else {
            k(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (Of == null) {
            Of = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Of.put(str, str2);
    }

    private static boolean ov() {
        return e.b(com.kwad.sdk.core.config.c.ayG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ow() {
        if (Oe == null || !ov()) {
            return;
        }
        Iterator<Throwable> it = Oe.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.n(it.next());
        }
        Oe.clear();
        Oe = null;
        ServiceProvider.f(new com.kwad.sdk.g.a<Throwable>() { // from class: com.kwad.components.core.d.a.3
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(Throwable th) {
                c(th);
            }

            private static void c(Throwable th) {
                com.kwad.sdk.crash.b.n(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox() {
        Map<String, String> map = Of;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                com.kwad.sdk.crash.report.h.ah(entry.getKey(), entry.getValue());
            }
        }
        Of.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.kwad.sdk.crash.c oy() {
        String a6 = e.a(com.kwad.sdk.core.config.c.aAd);
        com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "configStr:" + a6);
        com.kwad.sdk.crash.model.b ag = ag(a6);
        String str = ag.aPr;
        String str2 = ag.aPs;
        boolean a7 = g.a(ag);
        boolean b6 = g.b(ag);
        final Context context = ServiceProvider.getContext();
        String an = C0611a.an(context);
        c.a fi = new c.a().cb(context).bE(a7).bF(b6).bG(l.Cf().Bk()).fj(str).fi(str2);
        l.Cf();
        c.a fq = fi.fq(ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
        l.Cf();
        return fq.dT(BuildConfig.VERSION_CODE).fr(ExceptionMessage.getSdkCrashVersionName(l.Cf().getApiVersion(), 1)).dU(l.Cf().getApiVersionCode()).dV(1).fp("com.kwad.sdk").fs(context.getPackageName()).ft(ServiceProvider.getSDKConfig().appId).fu(ServiceProvider.getSDKConfig().appName).fv(m.cE(context)).fw(ag.aPn).fx(ag.aPo).fm(bd.getDeviceId()).fn(ServiceProvider.getSDKConfig().appId).fl(ag.version).fy(ag.aPq).fz(ag.aPp).fk("Android").fo(an).a(new com.kwad.sdk.crash.h() { // from class: com.kwad.components.core.d.a.5
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a oH() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.fE(t.IC());
                aVar.putString("mKsadAppId", ServiceProvider.getSDKConfig().appId);
                aVar.putString("mKsadAppName", ServiceProvider.getSDKConfig().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", m.cE(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                l.Cf();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
                l.Cf();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(l.Cf().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", l.Cf().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 214);
                for (b bVar : a.Og) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.f
            public final void a(int i6, ExceptionMessage exceptionMessage) {
                n.aQ(context);
                if (i6 == 1 || i6 == 3 || i6 == 4) {
                    com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i6);
                }
                Iterator it = a.Oh.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onCrashOccur(i6, exceptionMessage.mCrashDetail);
                }
            }
        }).d(oz()).e(oA()).H(e.EY()).m(e.a(com.kwad.sdk.core.config.c.aBl)).Lq();
    }

    private static String[] oz() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ah(KsAdSDKImpl.class.getName()));
            arrayList.add(ah(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(ah(CpuMemoryProfiler.class.getName()));
            arrayList.add(ah(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static com.kwad.sdk.crash.model.b ag(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("KsAdExceptionCollectorHelper", e6);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    public static void reportSdkCaughtException(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTrace(th);
        if (!mHasInit.get()) {
            b(th);
        } else if (ov()) {
            com.kwad.sdk.crash.b.n(th);
        }
    }
}

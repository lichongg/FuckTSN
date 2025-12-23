package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g {
    private static Messenger aYt;
    private static volatile ExecutorService aYu;
    private static volatile AppStatusRules aYv;
    private static com.kwad.sdk.collector.h aYw;
    private static Handler aeD;
    private static WeakReference<Context> aeJ;
    private static ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!g.Ps()) {
                    com.kwad.sdk.core.d.c.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = g.aYt;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                com.kwad.sdk.service.d.gatherException(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.utils.g$2, reason: invalid class name */
    final class AnonymousClass2 extends bg {
        final /* synthetic */ Context dq;

        AnonymousClass2(Context context) {
            this.dq = context;
        }

        @Override // com.kwad.sdk.utils.bg
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.dq, new c.a() { // from class: com.kwad.sdk.utils.g.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.dq);
                    AppStatusRules unused = g.aYv = appStatusRules;
                    g.b(AnonymousClass2.this.dq, g.aYv);
                    g.ct(AnonymousClass2.this.dq);
                    boolean ed = br.ed(AnonymousClass2.this.dq);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(g.aYv);
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + ed);
                    if (ed && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = g.aYv.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            g.c(AnonymousClass2.this.dq, obtainDefaultScanInterval);
                        } else {
                            g.cv(AnonymousClass2.this.dq);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(g.aYv);
                    boolean z5 = g.aYv.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z5);
                    if (isUploadTargetNotEmpty && z5 && ed) {
                        g.Pt();
                        g.aYu.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.dq, g.aYv);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.d.gatherException(th);
                                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void s(int i6, String str) {
                    com.kwad.sdk.core.d.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i6);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements com.kwad.sdk.core.b {
        private List<Long> aYC = new ArrayList();
        private String appName;
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        public static JSONArray P(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = Q(list);
            } catch (Exception e6) {
                com.kwad.sdk.service.d.gatherException(e6);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = list2.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        @Nullable
        private static List<a> Q(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String b6 = com.kwad.sdk.collector.model.c.b(bVar);
                        if (hashMap.containsKey(b6)) {
                            aVar = (a) hashMap.get(b6);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            hashMap.put(b6, aVar2);
                            aVar = aVar2;
                        }
                        long c6 = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.aY(c6);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e6) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                }
            }
            return null;
        }

        private void aY(long j6) {
            this.aYC.add(Long.valueOf(j6));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.aYC.clear();
                int length = optJSONArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    try {
                        this.aYC.add(Long.valueOf(optJSONArray.getLong(i6)));
                    } catch (JSONException e6) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "appName", this.appName);
            aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.aYC.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            aa.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void x(List<com.kwad.sdk.collector.model.b> list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends Handler {
        private void c(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = aa.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.g.c.1
                            private static a PD() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a Ef() {
                                return PD();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    c((ArrayList<com.kwad.sdk.collector.model.b>) arrayList);
                }
                if (list != null) {
                    R(list);
                }
            }
            if (g.aeJ != null && g.aeJ.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = aa.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.g.c.2
                            private static AppStatusRules.Strategy PE() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy Ef() {
                                return PE();
                            }
                        });
                    }
                } else {
                    list2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (list2 != null) {
                    for (AppStatusRules.Strategy strategy : list2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) g.aeJ.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (g.aeJ == null || g.serviceConnection == null) {
                return;
            }
            com.kwad.sdk.core.d.c.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) g.aeJ.get(), g.serviceConnection);
        }

        private static void R(List<a> list) {
            if (list == null) {
                return;
            }
            g.aYw.c(aa.S(list));
        }

        public c(@NonNull Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                c(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }

        private static void c(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray P;
            if (arrayList == null || (P = a.P(arrayList)) == null) {
                return;
            }
            g.aYw.c(P);
        }
    }

    private static boolean Pu() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            Context context = ServiceProvider.getContext();
            return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
        } catch (ClassNotFoundException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return false;
        }
    }

    public static void a(Context context, long j6, com.kwad.sdk.collector.h hVar) {
        if (bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(8192L) || context == null || com.kwad.sdk.utils.d.cr(context)) {
            return;
        }
        aYw = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            aeJ = new WeakReference<>(context);
            if (aeD == null) {
                aeD = new Handler(Looper.getMainLooper());
            }
            aeD.postDelayed(new AnonymousClass2(context), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements b {
        private b aYE = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.g.b
        public final void x(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray P = a.P(list);
            if (P != null) {
                g.aYw.c(P);
            }
            b bVar = this.aYE;
            if (bVar != null) {
                bVar.x(list);
            }
        }
    }

    public static AppStatusRules Pr() {
        return aYv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Ps() {
        if (aYt == null) {
            try {
                aYt = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return aYt != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Pt() {
        if (aYu == null) {
            synchronized (g.class) {
                try {
                    if (aYu == null) {
                        ExecutorService Jx = GlobalThreadPools.Jx();
                        aYu = Jx;
                        com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) Jx, "appStatusHelper");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.encodeKsSdk(jSONObject), false);
    }

    public static void c(final Context context, final long j6) {
        if (aeD == null) {
            aeD = new Handler(Looper.getMainLooper());
        }
        aeD.post(new bg() { // from class: com.kwad.sdk.utils.g.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                g.cv(context);
                g.aeD.postDelayed(this, j6);
            }
        });
    }

    @WorkerThread
    public static void ct(Context context) {
        if (aYv == null) {
            aYv = cu(context);
        }
    }

    @Nullable
    @WorkerThread
    private static AppStatusRules cu(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String J = com.kwad.sdk.crash.utils.h.J(file);
            if (TextUtils.isEmpty(J)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.isEncodeKsSdk(J)) {
                J = com.kwad.sdk.core.a.c.decodeKsSdk(J);
            }
            JSONObject jSONObject = new JSONObject(J);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cv(Context context) {
        if (context == null) {
            return;
        }
        boolean Pu = Pu();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isServiceAvailable: " + Pu);
        if (Pu) {
            com.kwad.sdk.collector.b.a.a(context, serviceConnection);
        } else {
            a(context, new d(null));
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f36050j)
    private static List<com.kwad.sdk.collector.model.b> cx(Context context) {
        ArrayList arrayList = new ArrayList();
        if (bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(8192L) || com.kwad.sdk.utils.d.cr(context)) {
            return arrayList;
        }
        AppStatusRules Pr = Pr();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(Pr)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy d6 = com.kwad.sdk.collector.i.d(Pr);
        arrayList.addAll(a(d6));
        d6.setNeedSaveLaunchTime(System.currentTimeMillis());
        return O(arrayList);
    }

    private static List<com.kwad.sdk.collector.model.b> O(List<com.kwad.sdk.collector.model.b> list) {
        if (list.isEmpty()) {
            return list;
        }
        return new ArrayList(new LinkedHashSet(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> cw(Context context) {
        if (!br.ed(context)) {
            return new ArrayList();
        }
        if (aYv == null) {
            aYv = cu(context);
        }
        return cx(context);
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(8192L) || com.kwad.sdk.utils.d.cr(context)) {
            return;
        }
        Pt();
        aYu.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.4
            @Override // java.lang.Runnable
            public final void run() {
                List cw;
                try {
                    HashSet hashSet = new HashSet();
                    if (!br.ed(context) || (cw = g.cw(context)) == null) {
                        return;
                    }
                    Iterator it = cw.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(cw);
                    if (bVar != null) {
                        bVar.x(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.d.gatherException(th);
                }
            }
        });
    }

    @NonNull
    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (!isNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.DF().a(strategy);
    }
}

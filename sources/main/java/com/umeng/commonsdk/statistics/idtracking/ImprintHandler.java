package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41915a = "ImprintHandler";

    /* renamed from: k, reason: collision with root package name */
    private static Context f41922k = null;

    /* renamed from: l, reason: collision with root package name */
    private static FileLockUtil f41923l = null;

    /* renamed from: m, reason: collision with root package name */
    private static final int f41924m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static final int f41925n = 1;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f41928e;

    /* renamed from: h, reason: collision with root package name */
    private a f41929h = new a();

    /* renamed from: i, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.d f41930i = null;

    /* renamed from: b, reason: collision with root package name */
    private static Object f41916b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final String f41917c = au.b().b(au.f40898c);

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f41918d = "pbl0".getBytes();

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f41919f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private static Object f41920g = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static ImprintHandler f41921j = null;

    /* renamed from: o, reason: collision with root package name */
    private static Map<String, UMImprintPreProcessCallback> f41926o = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    private static Object f41927p = new Object();

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f41920g) {
            try {
                int i6 = 0;
                if (f41919f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f41919f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i6 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i6)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i6++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i6 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i6)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i6++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f41919f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f41922k, th);
            }
        }
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (f41920g) {
            try {
                if (f41919f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f41919f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size) {
                                break;
                            }
                            if (uMImprintChangeCallback == arrayList.get(i6)) {
                                ULog.i("--->>> removeCallback: remove index " + i6);
                                arrayList.remove(i6);
                                break;
                            }
                            i6++;
                        }
                        ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f41919f.remove(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            String h6 = eVar.h();
            if (!TextUtils.isEmpty(h6)) {
                byte[] reverseHexString = DataHelper.reverseHexString(h6);
                byte[] a6 = a(eVar);
                for (int i6 = 0; i6 < 4; i6++) {
                    if (reverseHexString[i6] != a6[i6]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> c6 = dVar.c();
        if (c6.containsKey(bi.f40963f)) {
            c6.remove(bi.f40963f);
            this.f41929h.a(bi.f40963f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z5;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> c6 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c6.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = c6.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().f42077a;
                synchronized (f41927p) {
                    try {
                        z5 = !TextUtils.isEmpty(key) && f41926o.containsKey(key) && (uMImprintPreProcessCallback = f41926o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                    } finally {
                    }
                }
                if (z5) {
                    arrayList3.add(key);
                }
                synchronized (f41920g) {
                    try {
                        if (!TextUtils.isEmpty(key) && f41919f.containsKey(key) && (arrayList2 = f41919f.get(key)) != null) {
                            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                arrayList2.get(i6).onImprintValueChanged(key, str);
                            }
                        }
                    } finally {
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f41920g) {
                try {
                    if (!TextUtils.isEmpty(str2) && f41919f.containsKey(str2) && (arrayList = f41919f.get(str2)) != null) {
                        for (int i7 = 0; i7 < arrayList.size(); i7++) {
                            arrayList.get(i7).onImprintValueChanged(str2, null);
                        }
                    }
                } finally {
                }
            }
            c6.remove(str2);
        }
        return dVar;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, String> f41931a = new HashMap();

        a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> c6 = dVar.c();
                    for (String str : c6.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = c6.get(str)) != null) {
                            String b6 = eVar.b();
                            if (!TextUtils.isEmpty(b6)) {
                                this.f41931a.put(str, b6);
                                boolean z5 = AnalyticsConstants.UM_DEBUG;
                            }
                        }
                    }
                }
            }
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.f41931a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.f41931a.containsKey(str)) {
                this.f41931a.remove(str);
            }
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f41931a.size() > 0) {
                String str3 = this.f41931a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            try {
                if (f41921j == null) {
                    f41921j = new ImprintHandler(context);
                    f41923l = new FileLockUtil();
                    f41923l.doFileOperateion(new File(f41922k.getFilesDir(), f41917c), f41921j, 0);
                }
                imprintHandler = f41921j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return imprintHandler;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    private ImprintHandler(Context context) {
        f41922k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i6) {
        if (i6 == 0) {
            f41921j.e();
        } else if (i6 == 1) {
            f41921j.a(file);
        }
        return true;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            a(str, uMImprintChangeCallback);
        }
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintPreProcessCallback != null) {
            synchronized (f41927p) {
                try {
                    if (!f41926o.containsKey(str)) {
                        f41926o.put(str, uMImprintPreProcessCallback);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                    }
                } finally {
                }
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            b(str, uMImprintChangeCallback);
        }
    }

    public void d() {
        if (this.f41930i == null || f41923l == null) {
            return;
        }
        File file = new File(f41922k.getFilesDir(), f41917c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e6) {
                UMCrashManager.reportCrash(f41922k, e6);
            }
        }
        f41923l.doFileOperateion(file, f41921j, 1);
    }

    public a c() {
        return this.f41929h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d a6;
        boolean a7;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        boolean z5 = AnalyticsConstants.UM_DEBUG;
        HashMap hashMap = new HashMap();
        synchronized (this) {
            try {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.f41930i;
                com.umeng.commonsdk.statistics.proto.d d6 = d(dVar);
                String str = null;
                String i6 = dVar2 == null ? null : dVar2.i();
                if (dVar2 == null) {
                    a6 = e(d6);
                } else {
                    a6 = a(dVar2, d6, hashMap);
                }
                this.f41930i = a6;
                if (a6 != null) {
                    str = a6.i();
                }
                a7 = a(i6, str);
            } finally {
            }
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.f41930i;
        if (dVar3 != null && !a7) {
            this.f41929h.a(dVar3);
            com.umeng.commonsdk.statistics.internal.d dVar4 = this.f41928e;
            if (dVar4 != null) {
                dVar4.onImprintChanged(this.f41929h);
            }
        }
        if (hashMap.size() > 0) {
            synchronized (f41920g) {
                try {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f41919f.containsKey(key)) {
                            ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f41919f.get(key);
                            if (arrayList != null) {
                                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                    arrayList.get(i7).onImprintValueChanged(key, value);
                                }
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f41927p) {
            try {
                if (f41926o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f41919f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f41922k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f41917c
            r0.<init>(r1, r2)
            java.lang.Object r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f41916b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            return
        L18:
            r0 = move-exception
            goto L61
        L1a:
            r0 = 0
            android.content.Context r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f41922k     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L32
            java.io.FileInputStream r2 = r3.openFileInput(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L32
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
        L25:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L18
            goto L38
        L29:
            r0 = move-exception
            goto L5d
        L2b:
            r3 = move-exception
            goto L34
        L2d:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L5d
        L32:
            r3 = move-exception
            r2 = r0
        L34:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L29
            goto L25
        L38:
            if (r0 == 0) goto L5b
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r2.<init>()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.analytics.pro.bu r3 = new com.umeng.analytics.pro.bu     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r3.<init>()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r3.a(r2, r0)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r5.f41930i = r2     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r5.f41929h     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r0.a(r2)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.commonsdk.statistics.proto.d r0 = r5.f41930i     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.commonsdk.statistics.proto.d r0 = r5.d(r0)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r5.f41930i = r0     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            goto L5b
        L57:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L18
        L5b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            return
        L5d:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L18
            throw r0     // Catch: java.lang.Throwable -> L18
        L61:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f41928e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.f42059b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = f41918d;
        byte[] bArr2 = new byte[4];
        for (int i6 = 0; i6 < 4; i6++) {
            bArr2[i6] = (byte) (array[i6] ^ bArr[i6]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                try {
                    com.umeng.commonsdk.statistics.proto.d dVar = this.f41930i;
                    if (dVar == null) {
                        return null;
                    }
                    if (dVar.b() <= 0) {
                        return null;
                    }
                    return new ca().a(this.f41930i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f41922k, th2);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f41930i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> c6 = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i6 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f42077a;
                synchronized (f41927p) {
                    try {
                        if (!TextUtils.isEmpty(key) && f41926o.containsKey(key) && (uMImprintPreProcessCallback = f41926o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                            i6 = 1;
                        }
                    } finally {
                    }
                }
                if (i6 == 0) {
                    c6.put(entry.getKey(), entry.getValue());
                    synchronized (f41920g) {
                        try {
                            if (!TextUtils.isEmpty(key) && f41919f.containsKey(key) && f41919f.get(key) != null) {
                                map.put(key, str);
                            }
                        } finally {
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f41920g) {
                    try {
                        if (!TextUtils.isEmpty(key2) && f41919f.containsKey(key2) && (arrayList = f41919f.get(key2)) != null) {
                            while (i6 < arrayList.size()) {
                                arrayList.get(i6).onImprintValueChanged(key2, null);
                                i6++;
                            }
                        }
                    } finally {
                    }
                }
                c6.remove(key2);
                this.f41929h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f41930i == null) {
            return;
        }
        try {
            synchronized (f41916b) {
                try {
                    byte[] a6 = new ca().a(this.f41930i);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(a6);
                        fileOutputStream.flush();
                    } finally {
                        HelperUtils.safeClose(fileOutputStream);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}

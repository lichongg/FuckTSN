package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class NativeCrashHandler implements q {

    /* renamed from: a, reason: collision with root package name */
    static String f39670a = null;

    /* renamed from: b, reason: collision with root package name */
    private static NativeCrashHandler f39671b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f39672c = 1;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f39673n = true;

    /* renamed from: d, reason: collision with root package name */
    private final Context f39674d;

    /* renamed from: e, reason: collision with root package name */
    private final aa f39675e;

    /* renamed from: f, reason: collision with root package name */
    private final ak f39676f;

    /* renamed from: g, reason: collision with root package name */
    private NativeExceptionHandler f39677g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f39678h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39679i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39680j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39681k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39682l = false;

    /* renamed from: m, reason: collision with root package name */
    private as f39683m;

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z5, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (f39671b == null) {
                    f39671b = new NativeCrashHandler(context, aaVar, asVar, akVar, z5, str);
                }
                nativeCrashHandler = f39671b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void disableCatchAnrTrace() {
        f39672c = 1;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public synchronized boolean isUserOpened() {
        return this.f39682l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                boolean z5 = strategyBean.f39612f;
                if (z5 != this.f39681k) {
                    al.d("server native changed to %b", Boolean.valueOf(z5));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z6 = ac.a().c().f39612f && this.f39682l;
        if (z6 != this.f39681k) {
            al.a("native changed to %b", Boolean.valueOf(z6));
            b(z6);
        }
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z5, int i6);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i6, String str);

    public synchronized void setUserOpened(boolean z5) {
        try {
            c(z5);
            boolean isUserOpened = isUserOpened();
            ac a6 = ac.a();
            if (a6 != null) {
                isUserOpened = isUserOpened && a6.c().f39612f;
            }
            if (isUserOpened != this.f39681k) {
                al.a("native changed to %b", Boolean.valueOf(isUserOpened));
                b(isUserOpened);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void startNativeMonitor() {
        try {
            if (!this.f39680j && !this.f39679i) {
                boolean b6 = ap.b(this.f39675e.f39705t);
                boolean z5 = !b6;
                if (at.f39849b) {
                    boolean a6 = a(b6 ? "Bugly_Native" : this.f39675e.f39705t, z5);
                    this.f39680j = a6;
                    if (!a6 && b6) {
                        this.f39679i = a("NativeRQD", false);
                    }
                } else {
                    String str = "Bugly_Native";
                    aa aaVar = this.f39675e;
                    String str2 = aaVar.f39705t;
                    if (b6) {
                        aaVar.getClass();
                    } else {
                        str = str2;
                    }
                    this.f39680j = a(str, z5);
                }
                if (this.f39680j || this.f39679i) {
                    a(this.f39678h);
                    setNativeAppVersion(this.f39675e.f39700o);
                    setNativeAppChannel(this.f39675e.f39704s);
                    setNativeAppPackage(this.f39675e.f39688c);
                    setNativeUserId(this.f39675e.f());
                    setNativeIsAppForeground(this.f39675e.a());
                    setNativeLaunchTime(this.f39675e.f39686a);
                    return;
                }
                return;
            }
            a(this.f39678h);
        } catch (Throwable th) {
            throw th;
        }
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.f39680j) {
            testCrash();
        } else {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    protected native String unregist();

    private synchronized void c() {
        if (!this.f39681k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f39681k = false;
                return;
            }
        } catch (Throwable unused) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f39681k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
            this.f39680j = false;
            this.f39679i = false;
        }
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f39670a;
        }
        return str;
    }

    public static boolean isShouldHandleInJava() {
        return f39673n;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            f39670a = str;
        }
    }

    public static void setShouldHandleInJava(boolean z5) {
        f39673n = z5;
        NativeCrashHandler nativeCrashHandler = f39671b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z5));
        }
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f39679i || this.f39680j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f39680j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public void checkUploadRecordCrash() {
        this.f39676f.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                int i6;
                if (!ap.a(NativeCrashHandler.this.f39674d, "native_record_lock")) {
                    al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f39673n) {
                    NativeCrashHandler.a(NativeCrashHandler.this, "false");
                }
                CrashDetailBean a6 = be.a(NativeCrashHandler.this.f39674d, NativeCrashHandler.f39670a, NativeCrashHandler.this.f39677g);
                if (a6 != null) {
                    al.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f39683m.a(a6, true)) {
                        NativeCrashHandler.this.f39683m.b(a6, false);
                    }
                    be.a(false, NativeCrashHandler.f39670a);
                }
                final NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                long b6 = ap.b() - at.f39856j;
                long b7 = ap.b() + 86400000;
                File file = new File(NativeCrashHandler.f39670a);
                if (file.exists() && file.isDirectory()) {
                    try {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.2
                                @Override // java.util.Comparator
                                public final /* synthetic */ int compare(File file2, File file3) {
                                    return Long.compare(file3.lastModified(), file2.lastModified());
                                }
                            });
                            int length = listFiles.length;
                            long j6 = 0;
                            int i7 = 0;
                            int i8 = 0;
                            int i9 = 0;
                            while (i7 < length) {
                                File file2 = listFiles[i7];
                                long lastModified = file2.lastModified();
                                j6 += file2.length();
                                if (lastModified < b6 || lastModified >= b7 || j6 >= at.f39855i) {
                                    i6 = length;
                                    al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                    i8++;
                                    if (file2.delete()) {
                                        i9++;
                                    }
                                } else {
                                    i6 = length;
                                }
                                i7++;
                                length = i6;
                            }
                            al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i8), Integer.valueOf(i9));
                        }
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
                ap.b(NativeCrashHandler.this.f39674d, "native_record_lock");
            }
        });
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        f39672c |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    @Override // com.tencent.bugly.proguard.q
    public String getLogFromNative() {
        if (!this.f39679i && !this.f39680j) {
            return null;
        }
        try {
            return this.f39680j ? getNativeLog() : (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f39677g;
    }

    public String getSystemProperty(String str) {
        return (this.f39680j || this.f39679i) ? getProperties(str) : CommonNetImpl.FAIL;
    }

    public boolean isEnableCatchAnrTrace() {
        return (f39672c & 2) == 2;
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f39679i || this.f39680j) && str != null && str2 != null) {
            try {
                if (this.f39680j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public void removeEmptyNativeRecordFiles() {
        be.c(f39670a);
    }

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean setNativeIsAppForeground(boolean z5) {
        return a(14, z5 ? "true" : "false");
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public void unBlockSigquit(boolean z5) {
        if (z5) {
            a(21, "true");
        } else {
            a(21, "false");
        }
    }

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z5, String str) {
        this.f39674d = ap.a(context);
        if (ap.b(f39670a)) {
            try {
                if (ap.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).f39688c + "/app_bugly";
            }
            f39670a = str;
        }
        this.f39683m = asVar;
        this.f39675e = aaVar;
        this.f39676f = akVar;
        this.f39678h = z5;
        this.f39677g = new bd(context, aaVar, asVar, ac.a());
    }

    static /* synthetic */ boolean a(NativeCrashHandler nativeCrashHandler, String str) {
        return nativeCrashHandler.a(999, str);
    }

    private synchronized void b(boolean z5) {
        if (z5) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public boolean setNativeLaunchTime(long j6) {
        try {
            return a(15, String.valueOf(j6));
        } catch (NumberFormatException e6) {
            if (!al.a(e6)) {
                e6.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private synchronized void a(boolean z5) {
        if (this.f39681k) {
            al.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f39680j) {
            try {
                String regist = regist(f39670a, z5, f39672c);
                if (regist != null) {
                    al.a("[Native] Native Crash Report enable.", new Object[0]);
                    this.f39675e.f39706u = regist;
                    String concat = "-".concat(regist);
                    if (!at.f39849b && !this.f39675e.f39693h.contains(concat)) {
                        aa aaVar = this.f39675e;
                        aaVar.f39693h = aaVar.f39693h.concat("-").concat(this.f39675e.f39706u);
                    }
                    al.a("comInfo.sdkVersion %s", this.f39675e.f39693h);
                    this.f39681k = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.f39675e.e(runningCpuAbi);
                    }
                    return;
                }
            } catch (Throwable unused) {
                al.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f39679i) {
            try {
                Class cls = Integer.TYPE;
                String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", new Class[]{String.class, String.class, cls, cls}, new Object[]{f39670a, ab.d(), Integer.valueOf(z5 ? 1 : 5), 1});
                if (str == null) {
                    String d6 = ab.d();
                    aa.b();
                    str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f39670a, d6, Integer.valueOf(aa.B())});
                }
                if (str != null) {
                    this.f39681k = true;
                    this.f39675e.f39706u = str;
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z5 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f39675e.e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f39680j = false;
        this.f39679i = false;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f39671b;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z5, boolean z6, boolean z7) {
        a(16, String.valueOf(z5));
        a(17, String.valueOf(z6));
        a(18, String.valueOf(z7));
        testNativeCrash();
    }

    private synchronized void c(boolean z5) {
        if (this.f39682l != z5) {
            al.a("user change native %b", Boolean.valueOf(z5));
            this.f39682l = z5;
        }
    }

    private static boolean a(String str, boolean z5) {
        boolean z6;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z5) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th) {
            th = th;
            z6 = false;
        }
        try {
            al.a("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th2) {
            th = th2;
            z6 = true;
            al.d(th.getMessage(), new Object[0]);
            al.d("[Native] Failed to load so: %s", str);
            return z6;
        }
    }

    private boolean a(int i6, String str) {
        if (!this.f39680j) {
            return false;
        }
        try {
            setNativeInfo(i6, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}

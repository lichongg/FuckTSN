package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.au;
import com.tencent.bugly.proguard.bc;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CrashReport {

    /* renamed from: a, reason: collision with root package name */
    private static Context f39582a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c, reason: collision with root package name */
        CrashHandleCallback f39584c;

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f39555a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f39556b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i6) {
            this.f39555a = i6;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z5) {
            this.f39556b = z5;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f39584c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f39584c;
        }

        public UserStrategy(Context context) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        String a();

        void a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        void a(String str);

        void b();

        CharSequence c();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39582a).K;
        }
        String str2 = al.f39784b;
        return null;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f39582a = context;
        p.a(CrashModule.getInstance());
        p.a(context);
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i6, String str, String str2, String str3, Map<String, String> map) {
        if (!p.f40120a) {
            String str4 = al.f39784b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            au.a(thread, i6, str, str2, str3, map);
        } else {
            String str5 = al.f39784b;
        }
    }

    public static void setHttpProxy(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            an.f39788a = null;
        } else {
            an.f39788a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i6));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z5) {
        al.a("App fore and back status are no longer supported", new Object[0]);
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z5) {
        return setJavascriptMonitor(webView, z5, false);
    }

    public static void setUserId(String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f39582a, str);
        } else {
            String str3 = al.f39784b;
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void closeBugly() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39784b;
            return;
        }
        if (f39582a == null) {
            return;
        }
        aq a6 = aq.a();
        if (a6 != null) {
            a6.b(f39582a);
        }
        closeCrashReport();
        s.a(f39582a);
        ak a7 = ak.a();
        if (a7 != null) {
            a7.b();
        }
    }

    public static void closeCrashReport() {
        if (!p.f40120a) {
            String str = al.f39784b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().c();
        } else {
            String str2 = al.f39784b;
        }
    }

    public static void closeNativeReport() {
        if (!p.f40120a) {
            String str = al.f39784b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().d();
        } else {
            String str2 = al.f39784b;
        }
    }

    public static void enableBugly(boolean z5) {
        p.f40120a = z5;
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return new HashSet();
        }
        if (context != null) {
            return aa.a(context).w();
        }
        String str2 = al.f39784b;
        return new HashSet();
    }

    public static String getAppChannel() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39582a).f39704s;
        }
        String str2 = al.f39784b;
        return "unknown";
    }

    public static String getAppID() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39582a).e();
        }
        String str2 = al.f39784b;
        return "unknown";
    }

    public static String getAppVer() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39582a).f39700o;
        }
        String str2 = al.f39784b;
        return "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return aa.a(context).f39693h;
        }
        al.d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static Context getContext() {
        return f39582a;
    }

    public static Proxy getHttpProxy() {
        return an.f39788a;
    }

    public static String getUserData(Context context, String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return "unknown";
        }
        if (context == null) {
            String str3 = al.f39784b;
            return "unknown";
        }
        if (ap.b(str)) {
            return null;
        }
        return aa.a(context).g(str);
    }

    public static int getUserDatasSize(Context context) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return -1;
        }
        if (context != null) {
            return aa.a(context).v();
        }
        String str2 = al.f39784b;
        return -1;
    }

    public static String getUserId() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f39582a).f();
        }
        String str2 = al.f39784b;
        return "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return -1;
        }
        if (context != null) {
            return aa.a(context).z();
        }
        String str2 = al.f39784b;
        return -1;
    }

    public static boolean isLastSessionCrash() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39784b;
            return false;
        }
        at a6 = at.a();
        Boolean bool = a6.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str3 = aa.b().f39689d;
        List<y> a7 = w.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a7 == null || a7.size() <= 0) {
            a6.A = Boolean.FALSE;
            return false;
        }
        for (y yVar : a7) {
            if (str3.equals(yVar.f40200c)) {
                a6.A = Boolean.TRUE;
                arrayList.add(yVar);
            }
        }
        if (arrayList.size() > 0) {
            w.a().a(arrayList);
        }
        return true;
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || ap.b(str) || ap.b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            String str3 = al.f39784b;
            String.format("putSdkData key length over limit %d, will be cutted.", 50);
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            String str4 = al.f39784b;
            String.format("putSdkData value length over limit %d, will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        aa.a(context).b(replace, str2);
        al.b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!p.f40120a) {
            String str3 = al.f39784b;
            return;
        }
        if (context == null) {
            String str4 = al.f39784b;
            return;
        }
        if (str == null) {
            al.d("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            al.d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            al.d("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        aa a6 = aa.a(context);
        if (a6.w().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            aa.a(context).a(str, str2);
            al.c("replace KV %s %s", str, str2);
            return;
        }
        if (a6.v() >= 50) {
            al.d("user data size is over limit %d, it will be cutted!", 50);
            return;
        }
        if (str.length() > 50) {
            al.d("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        aa.a(context).a(str, str2);
        al.b("[param] set user data: %s - %s", str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return "unknown";
        }
        if (context == null) {
            String str3 = al.f39784b;
            return "unknown";
        }
        if (ap.b(str)) {
            return null;
        }
        al.b("[param] remove user data: %s", str);
        return aa.a(context).f(str);
    }

    public static void setAppChannel(Context context, String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        if (context == null) {
            String str3 = al.f39784b;
            return;
        }
        if (str == null) {
            String str4 = al.f39784b;
            return;
        }
        aa.a(context).f39704s = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        if (context == null) {
            String str3 = al.f39784b;
            return;
        }
        if (str == null) {
            String str4 = al.f39784b;
            return;
        }
        aa.a(context).f39688c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        if (context == null) {
            String str3 = al.f39784b;
            return;
        }
        if (str == null) {
            String str4 = al.f39784b;
            return;
        }
        aa.a(context).f39700o = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        String str3 = al.f39784b;
        "Set Bugly DB name: ".concat(String.valueOf(str));
        x.f40194a = str;
    }

    public static void setCollectPrivacyInfo(Context context, boolean z5) {
        if (!p.f40120a) {
            String str = al.f39784b;
        } else {
            if (context == null) {
                String str2 = al.f39784b;
                return;
            }
            String str3 = al.f39784b;
            "setCollectPrivacyInfo: ".concat(String.valueOf(z5));
            aa.a(context).f39699n = z5;
        }
    }

    public static void setContext(Context context) {
        f39582a = context;
    }

    public static void setCrashFilter(String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        String str3 = al.f39784b;
        "Set crash stack filter: ".concat(String.valueOf(str));
        at.f39863q = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        String str3 = al.f39784b;
        "Set crash stack filter: ".concat(String.valueOf(str));
        at.f39864r = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).a(str);
    }

    public static void setDeviceModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).b(str);
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        if (context == null) {
            String str3 = al.f39784b;
        } else {
            if (str == null) {
                String str4 = al.f39784b;
                return;
            }
            String str5 = al.f39784b;
            "user set tombstone path: ".concat(str);
            NativeCrashHandler.setDumpFilePath(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z5) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return;
        }
        String str2 = al.f39784b;
        "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z5));
        NativeCrashHandler.setShouldHandleInJava(z5);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z5) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return;
        }
        if (context == null) {
            al.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z5) {
            al.c("This is a development device.", new Object[0]);
        } else {
            al.c("This is not a development device.", new Object[0]);
        }
        aa.a(context).I = z5;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z5, boolean z6) {
        if (webView == null) {
            String str = al.f39784b;
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new a() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final String a() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void a(String str2) {
                webView.loadUrl(str2);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void b() {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final CharSequence c() {
                return webView.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void a(H5JavaScriptInterface h5JavaScriptInterface, String str2) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str2);
            }
        }, z5, z6);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!p.f40120a) {
            String str3 = al.f39784b;
            return;
        }
        if (context == null || ap.b(str) || ap.b(str2)) {
            return;
        }
        aa a6 = aa.a(context);
        if (str == null || str2 == null) {
            return;
        }
        synchronized (a6.T) {
            a6.K.put(str, str2);
        }
    }

    public static void setSessionIntervalMills(long j6) {
        if (p.f40120a) {
            s.a(j6);
        } else {
            String str = al.f39784b;
        }
    }

    public static void setUserSceneTag(Context context, int i6) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return;
        }
        if (context == null) {
            String str2 = al.f39784b;
            return;
        }
        if (i6 <= 0) {
            al.d("setTag args tagId should > 0", new Object[0]);
        }
        aa a6 = aa.a(context);
        synchronized (a6.U) {
            try {
                int i7 = a6.f39708w;
                if (i7 != i6) {
                    a6.f39708w = i6;
                    al.a("user scene tag %d changed to tag %d", Integer.valueOf(i7), Integer.valueOf(a6.f39708w));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        al.b("[param] set user scene tag: %d", Integer.valueOf(i6));
    }

    public static void startCrashReport() {
        if (!p.f40120a) {
            String str = al.f39784b;
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().b();
        } else {
            String str2 = al.f39784b;
        }
    }

    public static void testANRCrash() {
        if (!p.f40120a) {
            String str = al.f39784b;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39784b;
        } else {
            al.a("start to create a anr crash for test!", new Object[0]);
            at.a().h();
        }
    }

    public static void testJavaCrash() {
        int i6;
        if (!p.f40120a) {
            String str = al.f39784b;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39784b;
            return;
        }
        aa b6 = aa.b();
        if (b6 != null && (i6 = b6.f39709x) != 24096) {
            b6.f39709x = 24096;
            al.a("server scene tag %d changed to tag %d", Integer.valueOf(i6), Integer.valueOf(b6.f39709x));
        }
        throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
    }

    public static void testNativeCrash(boolean z5, boolean z6, boolean z7) {
        if (!p.f40120a) {
            String str = al.f39784b;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39784b;
        } else {
            al.a("start to create a native crash for test!", new Object[0]);
            at.a().a(z5, z6, z7);
        }
    }

    public static void uploadUserInfo() {
        if (!p.f40120a) {
            String str = al.f39784b;
            return;
        }
        r rVar = s.f40141b;
        if (rVar == null) {
            String str2 = al.f39784b;
        } else {
            rVar.b();
        }
    }

    public static void enableObtainId(Context context, boolean z5) {
        setCollectPrivacyInfo(context, z5);
    }

    public static String getDeviceID(Context context) {
        return aa.a(context).g();
    }

    public static void postCatchedException(final Throwable th, final Thread thread, final boolean z5) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            String str2 = al.f39784b;
            return;
        }
        if (th == null) {
            al.d("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        final at a6 = at.a();
        a6.f39870w.a(new Runnable() { // from class: com.tencent.bugly.proguard.at.3

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f39876a = false;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f39879d = null;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ byte[] f39880e = null;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f39881f = true;

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    al.c("post a throwable %b", Boolean.valueOf(this.f39876a));
                    at.this.f39867t.a(thread, th, false, this.f39879d, this.f39880e, this.f39881f);
                    if (z5) {
                        al.a("clear user datas", new Object[0]);
                        aa.a(at.this.f39865c).u();
                    }
                } catch (Throwable th2) {
                    if (!al.b(th2)) {
                        th2.printStackTrace();
                    }
                    al.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public static void setAllThreadStackEnable(Context context, boolean z5, boolean z6) {
        aa a6 = aa.a(context);
        a6.Q = z5;
        a6.R = z6;
    }

    public static void setServerUrl(String str) {
        if (!ap.b(str) && ap.d(str)) {
            ac.a(str);
            StrategyBean.f39607a = str;
            StrategyBean.f39608b = str;
            return;
        }
        String str2 = al.f39784b;
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f39582a = context;
        p.a(CrashModule.getInstance());
        p.a(context, userStrategy);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i6) {
        if (inetAddress == null) {
            an.f39788a = null;
        } else {
            an.f39788a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i6));
        }
    }

    public static void postException(int i6, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i6, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return;
        }
        if (context == null) {
            String str3 = al.f39784b;
            return;
        }
        if (TextUtils.isEmpty(str)) {
            al.d("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            al.d("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        if (str.equals(aa.a(context).f())) {
            return;
        }
        aa a6 = aa.a(context);
        synchronized (a6.V) {
            a6.f39697l = str;
        }
        al.b("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            s.a();
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!p.f40120a) {
            String str = al.f39784b;
            return new HashMap();
        }
        if (context == null) {
            al.d("Context should not be null.", new Object[0]);
            return null;
        }
        return aa.a(context).K;
    }

    public static void initCrashReport(Context context, String str, boolean z5) {
        initCrashReport(context, str, z5, null);
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z5) {
        return setJavascriptMonitor(aVar, z5, false);
    }

    public static void initCrashReport(Context context, String str, boolean z5, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f39582a = context;
        p.a(CrashModule.getInstance());
        p.a(context, str, z5, userStrategy);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(a aVar, boolean z5, boolean z6) {
        if (aVar == null) {
            String str = al.f39784b;
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            al.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        al.a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!p.f40120a) {
            String str2 = al.f39784b;
            return false;
        }
        al.c("URL of webview is %s", aVar.a());
        al.a("Enable the javascript needed by webview monitor.", new Object[0]);
        aVar.b();
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(aVar);
        if (h5JavaScriptInterface != null) {
            al.a("Add a secure javascript interface to the webview.", new Object[0]);
            aVar.a(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z5) {
            al.a("Inject bugly.js(v%s) to the webview.", bc.b());
            String a6 = bc.a();
            if (a6 == null) {
                al.e("Failed to inject Bugly.js.", bc.b());
                return false;
            }
            aVar.a("javascript:".concat(a6));
        }
        return true;
    }
}

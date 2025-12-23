package com.tencent.bugly;

import com.tencent.bugly.proguard.aa;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BuglyStrategy {

    /* renamed from: c, reason: collision with root package name */
    private String f39557c;

    /* renamed from: d, reason: collision with root package name */
    private String f39558d;

    /* renamed from: e, reason: collision with root package name */
    private String f39559e;

    /* renamed from: f, reason: collision with root package name */
    private long f39560f;

    /* renamed from: g, reason: collision with root package name */
    private String f39561g;

    /* renamed from: h, reason: collision with root package name */
    private String f39562h;

    /* renamed from: i, reason: collision with root package name */
    private String f39563i;

    /* renamed from: u, reason: collision with root package name */
    private a f39575u;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39564j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39565k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39566l = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f39567m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f39568n = true;

    /* renamed from: o, reason: collision with root package name */
    private Class<?> f39569o = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39570p = true;

    /* renamed from: q, reason: collision with root package name */
    private boolean f39571q = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f39572r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f39573s = true;

    /* renamed from: t, reason: collision with root package name */
    private boolean f39574t = false;

    /* renamed from: a, reason: collision with root package name */
    protected int f39555a = 31;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f39556b = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f39576v = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i6, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i6, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f39558d;
        if (str != null) {
            return str;
        }
        return aa.b().f39704s;
    }

    public synchronized String getAppPackageName() {
        String str = this.f39559e;
        if (str != null) {
            return str;
        }
        return aa.b().f39688c;
    }

    public synchronized long getAppReportDelay() {
        return this.f39560f;
    }

    public synchronized String getAppVersion() {
        String str = this.f39557c;
        if (str != null) {
            return str;
        }
        return aa.b().f39700o;
    }

    public synchronized int getCallBackType() {
        return this.f39555a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f39556b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f39575u;
    }

    public synchronized String getDeviceID() {
        return this.f39562h;
    }

    public synchronized String getDeviceModel() {
        return this.f39563i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f39561g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f39569o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f39570p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f39565k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f39566l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f39564j;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f39568n;
    }

    public synchronized boolean isUploadProcess() {
        return this.f39572r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f39573s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f39574t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f39558d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f39559e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j6) {
        this.f39560f = j6;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f39557c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z5) {
        this.f39570p = z5;
        return this;
    }

    public synchronized void setCallBackType(int i6) {
        this.f39555a = i6;
    }

    public synchronized void setCloseErrorCallback(boolean z5) {
        this.f39556b = z5;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f39575u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f39562h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f39563i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z5) {
        this.f39565k = z5;
        return this;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z5) {
        this.f39564j = z5;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z5) {
        this.f39568n = z5;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f39561g = str;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z5) {
        this.f39574t = z5;
        return this;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z5) {
        this.f39572r = z5;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z5) {
        this.f39573s = z5;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f39569o = cls;
        return this;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f39567m;
    }

    public boolean isMerged() {
        return this.f39576v;
    }

    public boolean isReplaceOldChannel() {
        return this.f39571q;
    }

    public void setEnableCatchAnrTrace(boolean z5) {
        this.f39566l = z5;
    }

    public void setEnableRecordAnrMainStack(boolean z5) {
        this.f39567m = z5;
    }

    @Deprecated
    public void setMerged(boolean z5) {
        this.f39576v = z5;
    }

    public void setReplaceOldChannel(boolean z5) {
        this.f39571q = z5;
    }
}

package com.umeng.analytics.vshelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class PageNameMonitor implements com.umeng.analytics.vshelper.a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.vshelper.PageNameMonitor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final PageNameMonitor f41522a = new PageNameMonitor(null);

        private a() {
        }
    }

    /* synthetic */ PageNameMonitor(AnonymousClass1 anonymousClass1) {
        this();
    }

    private PageNameMonitor() {
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            try {
                String str = currentCustomPage;
                if (str != null) {
                    return str;
                }
                String str2 = currentActivity;
                if (str2 != null) {
                    return str2;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getCurrentActivityName() {
        String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }

    public static PageNameMonitor getInstance() {
        return a.f41522a;
    }
}

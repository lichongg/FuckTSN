package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class InitReport {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33386a = "HaReport";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f33387b = false;

    /* renamed from: c, reason: collision with root package name */
    private static final int f33388c = 10;

    /* renamed from: d, reason: collision with root package name */
    private static List<Runnable> f33389d = new CopyOnWriteArrayList();

    public static void disableConnectNet() {
        f33387b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a() {
        try {
            Iterator<Runnable> it = f33389d.iterator();
            while (it.hasNext()) {
                HianalyticsHelper.getInstance().getReportExecutor().submit(it.next());
            }
            f33389d.clear();
        } catch (NullPointerException unused) {
            Logger.e(f33386a, "event is null occured");
        } catch (RejectedExecutionException unused2) {
            Logger.e(f33386a, "submit failed of rejected execution exception");
        } catch (Exception unused3) {
            Logger.e(f33386a, "submit failed because of some exception");
        }
    }

    public static void enableConnectNet() {
        f33387b = true;
        try {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.InitReport.1
                @Override // java.lang.Runnable
                public void run() {
                    InitReport.a();
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(f33386a, "the thread submit has rejectedExecutionException!");
        } catch (Throwable unused2) {
            Logger.e(f33386a, "the thread submit has fatal error!");
        }
    }

    public static void reportWhenInit(Runnable runnable) {
        if (!f33387b) {
            if (f33389d.size() > 10) {
                Logger.e("TAG", "the event to be report when init exceed the limit!");
                return;
            } else {
                f33389d.add(runnable);
                return;
            }
        }
        try {
            HianalyticsHelper.getInstance().getReportExecutor().execute(runnable);
        } catch (RejectedExecutionException unused) {
            Logger.e(f33386a, "the thread submit has rejectedExecutionException!");
        } catch (Throwable unused2) {
            Logger.e(f33386a, "the thread submit has fatal error!");
        }
    }
}

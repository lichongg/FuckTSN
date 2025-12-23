package cn.jiguang.by;

import cn.jiguang.ba.h;
import cn.jiguang.ba.i;
import cn.jiguang.bb.f;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, ExecutorService> f2659a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, String> f2660b;

    public static void a(String str) {
        try {
            a(c(str));
        } catch (Throwable th) {
            f.l("SDKWorker_XExecutor", "shutdown executor " + str + "error: " + th);
        }
    }

    public static boolean b(String str) {
        try {
            ExecutorService c6 = c(str);
            if (c6 != null && !c6.isShutdown()) {
                if (!c6.isTerminated()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            f.l("SDKWorker_XExecutor", "check executor " + str + " isAlive error: " + th);
            return false;
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f2660b = hashMap;
        hashMap.put("SDK_INIT", "ic");
        hashMap.put("SDK_SERVICE_INIT", "mn");
        hashMap.put("TCP_CONN_TASK", "tc");
        hashMap.put("UPLOAD_REPORT", "rp");
        hashMap.put("ONCE_TASK", "oc");
        hashMap.put("SCHEDULE_TASK", "sc");
        hashMap.put("MAJOR_TASK", "mj");
        hashMap.put("NORMAL_TASK", "nr");
        hashMap.put("FUTURE_TASK", SocializeProtocolConstants.PROTOCOL_KEY_FR);
        hashMap.put("DELAY_TASK", "dl");
        hashMap.put("AIDL_TASK", "al");
        hashMap.put("DYNAMIC_LOAD_TASK", "dl");
        hashMap.put("IPC_ACTION_TASK", ConstantHelper.LOG_CATE);
        hashMap.put("MAIN_IPC_ACTION_TASK", "m_ca");
    }

    public static void a(String str, Runnable runnable) {
        a(str, runnable, 0, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b1, code lost:
    
        if (r13.equals("TCP_CONN_TASK") != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011e, code lost:
    
        if (r13.equals("UPLOAD_REPORT") != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0140, code lost:
    
        if (r13.equals("MAIN_IPC_ACTION_TASK") != false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.concurrent.ExecutorService c(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.by.d.c(java.lang.String):java.util.concurrent.ExecutorService");
    }

    public static void a(String str, Runnable runnable, int i6) {
        a(str, runnable, i6, true);
    }

    public static void a(String str, final Runnable runnable, int i6, final boolean z5) {
        try {
            Runnable runnable2 = new Runnable() { // from class: cn.jiguang.by.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!z5 || (!h.b() && !i.a())) {
                            runnable.run();
                        }
                    } catch (Throwable th) {
                        f.l("SDKWorker_XExecutor", "execute run failed, e:" + th);
                    }
                }
            };
            ExecutorService c6 = c(str);
            if (c6 != null) {
                if (i6 <= 0 || !(c6 instanceof ScheduledExecutorService)) {
                    c6.execute(runnable2);
                } else {
                    ((ScheduledExecutorService) c6).schedule(runnable2, i6, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Throwable th) {
            f.l("SDKWorker_XExecutor", "execute failed, try again e:" + th);
        }
    }

    public static void a(String str, Runnable runnable, boolean z5) {
        a(str, runnable, 0, z5);
    }

    private static void a(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        try {
            executorService.shutdown();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            f.a("SDKWorker_XExecutor", "executor did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            f.a("SDKWorker_XExecutor", "current thread is interrupted by self");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            f.i("SDKWorker_XExecutor", "shutDown e:" + th);
        }
    }
}

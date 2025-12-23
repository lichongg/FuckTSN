package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {
    public static final String TAG = "c";
    private static int aJJ;
    private static int aJK;
    private static int aJL;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aJM = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aJN = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aJM.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aJN.put(threadPoolExecutor, str);
    }

    static /* synthetic */ int JG() {
        int i6 = aJJ;
        aJJ = i6 + 1;
        return i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.aJz = str;
        bVar.aJA = threadPoolExecutor.getCorePoolSize();
        bVar.aJB = threadPoolExecutor.getMaximumPoolSize();
        bVar.aJC = threadPoolExecutor.getPoolSize();
        bVar.aJD = threadPoolExecutor.getActiveCount();
        bVar.aJG = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aJM;
        long longValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.aJF = completedTaskCount - longValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.aJE = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).JK();
        } else {
            bVar.aJE = 0L;
        }
        bVar.aJH = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.aJI = aJK;
        return bVar;
    }

    public static void cS(final String str) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d eD;
                int i6;
                if (TextUtils.isEmpty(str) || (eD = c.eD(str)) == null || (i6 = eD.aJK) == 0) {
                    return;
                }
                int unused = c.aJK = i6;
                if (Math.random() * c.aJK >= 1.0d) {
                    return;
                }
                c.a(eD);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.aJR = true;
        com.kwad.sdk.core.threads.a.a.aJR = true;
        interval = dVar.interval;
        aJL = dVar.aJQ;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new bg() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ExecutorService eC;
                for (String str : GlobalThreadPools.JA()) {
                    if (str != null && !c.aJN.containsValue(str) && (eC = GlobalThreadPools.eC(str)) != null && (eC instanceof ThreadPoolExecutor) && !c.aJM.containsKey(eC)) {
                        c.a((ThreadPoolExecutor) eC, str);
                    }
                }
                int i6 = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.aJN.keySet()) {
                    String str2 = (String) c.aJN.get(threadPoolExecutor);
                    i6 += threadPoolExecutor.getPoolSize();
                    b b6 = c.b(threadPoolExecutor, str2);
                    if (b6 != null) {
                        com.kwad.sdk.commercial.b.s(b6);
                    }
                }
                b bVar = new b();
                bVar.aJz = "total";
                bVar.aJC = i6;
                com.kwad.sdk.commercial.b.s(bVar);
                c.JG();
                if (c.aJJ < c.aJL) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }

    public static d eD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }
}

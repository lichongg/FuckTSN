package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.p;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private List<com.kwad.sdk.n.a.a> aWU;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final b aWY = new b();
    }

    private boolean N(List<String> list) {
        int i6;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        boolean z5 = true;
        while (it.hasNext()) {
            String[] gF = gF(it.next());
            int length = gF.length;
            boolean z6 = false;
            while (i6 < length) {
                z6 = gE(gF[i6]);
                i6 = z6 ? 0 : i6 + 1;
            }
            z5 &= z6;
        }
        return z5;
    }

    public final void OS() {
        boolean z5 = false;
        for (int i6 = 0; i6 < this.aWU.size(); i6++) {
            com.kwad.sdk.n.a.a aVar = this.aWU.get(i6);
            if (ez(aVar.aXl)) {
                com.kwad.sdk.commercial.b.v(eA(aVar.aXl));
                z5 = true;
            }
        }
        if (z5) {
            return;
        }
        com.kwad.sdk.commercial.b.v(eA(-1));
    }

    public final void clearAll() {
        for (int i6 = 0; i6 < this.aWU.size(); i6++) {
            eB(i6);
            eD(i6);
            eF(i6);
            OT();
            eG(i6);
        }
    }

    private static void OT() {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", 0L);
    }

    private void a(com.kwad.sdk.n.a.a aVar) {
        String a6 = c.OV().a(aVar.aXn);
        if (TextUtils.isEmpty(a6)) {
            return;
        }
        z(aVar.aXl, a6);
    }

    private static void aV(long j6) {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", j6);
    }

    private static com.kwad.sdk.n.b.a.a eA(int i6) {
        com.kwad.sdk.n.b.a.a aVar = new com.kwad.sdk.n.b.a.a();
        String str = "_" + i6;
        aVar.eI(i6);
        aVar.gI(ag.h("ksadsdk_perf_ranger_v2", "aggregation_version" + str, ""));
        aVar.eJ(ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, 0));
        aVar.eK(ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, 0));
        aVar.aW(ag.b("ksadsdk_perf_ranger_v2", "ks_launch_delay", -1L));
        aVar.aX(ag.b("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + str, -1L));
        return aVar;
    }

    private static void eB(int i6) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i6), "");
    }

    public static void eC(int i6) {
        String str = "_" + i6;
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + str, ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, -1) + 1);
    }

    private static void eD(int i6) {
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + ("_" + i6), 0);
    }

    public static void eE(int i6) {
        String str = "_" + i6;
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, -1) + 1);
    }

    private static void eF(int i6) {
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + ("_" + i6), 0);
    }

    private static void eG(int i6) {
        ag.a("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + ("_" + i6), 0L);
    }

    private static void ey(int i6) {
        ag.b("ksadsdk_perf_ranger_v2", "aggregation_sdk" + ("_" + i6), 1);
    }

    private static boolean ez(int i6) {
        StringBuilder sb = new StringBuilder("aggregation_sdk");
        sb.append("_" + i6);
        return ag.c("ksadsdk_perf_ranger_v2", sb.toString(), -1) == 1;
    }

    private static String[] gF(String str) {
        return str.contains("_") ? str.split("_") : new String[]{str};
    }

    private static void z(int i6, String str) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i6), str);
    }

    public final void b(d dVar) {
        List<com.kwad.sdk.n.a.a> list = dVar.aWU;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.aWU = list;
    }

    public final void c(final StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        GlobalThreadPools.Jn().execute(new Runnable() { // from class: com.kwad.sdk.n.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.aWU != null && !b.this.aWU.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.aWU) {
                            if (b.a(stackTraceElementArr, aVar.aXp)) {
                                b.eE(aVar.aXl);
                            }
                        }
                    }
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e6));
                }
            }
        });
    }

    public static b OQ() {
        return a.aWY;
    }

    private void OR() {
        long PP = p.PP();
        if (PP <= 0) {
            return;
        }
        aV(PP);
    }

    private static boolean gE(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void gG(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GlobalThreadPools.Jn().execute(new Runnable() { // from class: com.kwad.sdk.n.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.aWU != null && !b.this.aWU.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.aWU) {
                            if (b.b(str, aVar.aXo)) {
                                b.eC(aVar.aXl);
                            }
                        }
                    }
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e6));
                }
            }
        });
    }

    public final void start() {
        OR();
        List<com.kwad.sdk.n.a.a> list = this.aWU;
        if (list == null) {
            com.kwad.sdk.core.d.c.w(TAG, "aggregationCheckConfigList is null");
            return;
        }
        for (com.kwad.sdk.n.a.a aVar : list) {
            try {
                if (N(aVar.aXm)) {
                    ey(aVar.aXl);
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e6));
            }
            try {
                if (aVar.aXn != null) {
                    a(aVar);
                }
            } catch (Exception e7) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e7));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static boolean a(StackTraceElement[] stackTraceElementArr, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (p.a(stackTraceElement).contains(str)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}

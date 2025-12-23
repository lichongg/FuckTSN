package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class af {
    private static AtomicInteger aZC = new AtomicInteger(0);
    private static volatile boolean aZD = false;
    private static volatile boolean aZE;

    private static int Qe() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int BJ = hVar.BJ();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "config mode:" + BJ);
        return BJ;
    }

    private static void Qf() {
        if (aZD) {
            return;
        }
        aZC.set(Qi());
        aZE = bo.m("kssdk_kv_mode", "downgrade", false);
        aZD = true;
    }

    @WorkerThread
    public static com.kwad.sdk.utils.b.a Qh() {
        Map<String, ?> all;
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences ho = bo.ho("ksadsdk_kv_perf");
        if (ho == null) {
            return null;
        }
        try {
            all = ho.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += ((Integer) it.next().getValue()).intValue();
        }
        aVar.bcQ = i6;
        SharedPreferences.Editor edit = ho.edit();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            edit.putInt(it2.next().getKey(), 0);
        }
        edit.apply();
        d(aVar);
        e(aVar);
        return aVar;
    }

    private static int Qi() {
        int c6 = bo.c("kssdk_kv_mode", RtspHeaders.Values.MODE, 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "local mode:" + c6);
        return c6;
    }

    private static boolean Qk() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static void Qn() {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                Context context;
                try {
                    context = ag.getContext();
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e6));
                }
                if (context == null) {
                    return;
                }
                Iterator<String> it = i.a.ase.iterator();
                while (it.hasNext()) {
                    af.S(context, it.next());
                }
                af.eP(0);
                af.aZC.set(0);
            }
        });
    }

    private static void Qo() {
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "transferToKv");
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    Context context = ag.getContext();
                    if (context != null) {
                        Iterator<String> it = i.a.ase.iterator();
                        while (it.hasNext()) {
                            af.R(context, it.next());
                        }
                        af.eP(1);
                        af.aZC.set(1);
                    }
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e6));
                }
            }
        });
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (i.a.asf.contains(str)) {
            return;
        }
        cVar.release();
    }

    @WorkerThread
    public static void at(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    int c6 = bo.c("ksadsdk_kv_perf", str, 0);
                    if (TextUtils.isEmpty(str2)) {
                        bo.ay("ksadsdk_kv_perf", str);
                    } else {
                        bo.b("ksadsdk_kv_perf", str, c6 + 1);
                    }
                } catch (Exception e6) {
                    bo.ay("ksadsdk_kv_perf", str);
                    ServiceProvider.reportSdkCaughtException(e6);
                }
            }
        });
    }

    public static void au(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                SharedPreferences ho = bo.ho("ksadsdk_kv_perf");
                if (ho != null && ho.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bo.b("ksadsdk_kv_perf_failed", str, bo.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bo.b("ksadsdk_kv_perf_success", str, bo.c("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(@NonNull com.kwad.sdk.utils.b.a aVar) {
        if (aVar.bcR / (r0 + aVar.bcS) > 0.10000000149011612d) {
            aZE = true;
            com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "need downgrade");
            bo.l("kssdk_kv_mode", "downgrade", true);
        }
        if (aZE) {
            Qm();
        }
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences ho = bo.ho("ksadsdk_kv_perf_failed");
        int i6 = 0;
        if (ho == null) {
            aVar.bcR = 0;
            return;
        }
        Map<String, ?> all = ho.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                i6 += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bcR = i6;
        SharedPreferences.Editor edit = ho.edit();
        edit.clear();
        edit.apply();
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences ho = bo.ho("ksadsdk_kv_perf_success");
        int i6 = 0;
        if (ho == null) {
            aVar.bcS = 0;
            return;
        }
        Map<String, ?> all = ho.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                i6 += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bcS = i6;
        SharedPreferences.Editor edit = ho.edit();
        edit.clear();
        edit.apply();
    }

    static void eP(int i6) {
        bo.b("kssdk_kv_mode", RtspHeaders.Values.MODE, i6);
    }

    private static boolean gW(String str) {
        return i.a.ase.contains(str);
    }

    private static void transfer(int i6) {
        if (i6 == 0) {
            Qn();
        } else if (i6 == 1) {
            Qo();
        }
    }

    public static void Qg() {
        if (Qj() || Qe() == 0) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.utils.b.a Qh = af.Qh();
                if (Qh != null) {
                    af.c(Qh);
                    com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                    if (bVar != null) {
                        bVar.a(Qh);
                    }
                }
            }
        });
    }

    private static boolean Qj() {
        Qf();
        if (aZC.get() == 0) {
            return true;
        }
        return false;
    }

    private static int Ql() {
        int i6;
        Qf();
        if (!aZE && Qk()) {
            i6 = Qe();
        } else {
            i6 = 0;
        }
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "targetMode:" + i6);
        return i6;
    }

    public static void Qm() {
        boolean z5;
        Qf();
        int i6 = aZC.get();
        int Ql = Ql();
        if (i6 != Ql) {
            z5 = true;
        } else {
            z5 = false;
        }
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "needTransfer:" + z5);
        if (z5) {
            transfer(Ql);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(Context context, String str) {
        SharedPreferences ho;
        com.kwad.sdk.utils.a.c ay = com.kwad.sdk.utils.a.e.ay(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (ho = bo.ho(str)) == null) {
            SharedPreferences.Editor edit = ho.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (!ay.contains("sp_to_kv_transfer_flag")) {
            SharedPreferences ho2 = bo.ho(str);
            if (ho2 == null) {
                ay.putBoolean("sp_to_kv_transfer_flag", true);
                return;
            }
            ay.putAll(ho2.getAll());
            ay.putBoolean("sp_to_kv_transfer_flag", true);
            bo.ay(str, "kv_to_sp_transfer_flag");
            a(str, ay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(Context context, String str) {
        SharedPreferences ho = bo.ho(str);
        if (ho != null) {
            if ("ksadsdk_splash_preload_id_list".equals(str)) {
                SharedPreferences.Editor edit = ho.edit();
                if (edit != null) {
                    edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                    return;
                }
                return;
            }
            if (!ho.contains("kv_to_sp_transfer_flag")) {
                com.kwad.sdk.utils.a.c ay = com.kwad.sdk.utils.a.e.ay(context, str);
                Map<String, Object> all = ay.getAll();
                if (all.isEmpty()) {
                    bo.l(str, "kv_to_sp_transfer_flag", true);
                    return;
                }
                bo.a(str, all);
                bo.l(str, "kv_to_sp_transfer_flag", true);
                ay.remove("sp_to_kv_transfer_flag");
                ay.release();
            }
        }
    }

    public static boolean gX(String str) {
        boolean z5;
        if (!Qj() && gW(str)) {
            z5 = false;
        } else {
            z5 = true;
        }
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "shouldUseModeSp:" + z5);
        return z5;
    }
}

package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private static BlockEvent c(String str, long j6, long j7, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j7;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.aPI = str;
        if (j6 == 0) {
            j6 = System.currentTimeMillis();
        }
        aVar.aPG = j6;
        aVar.repeatCount = (int) (j7 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    private static String fK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean startsWith = str.startsWith(" \n");
            com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "oldVersion:" + startsWith);
            if (startsWith) {
                if (str.contains("at ")) {
                    str = str.substring(str.indexOf("at "));
                }
                str = str.replaceAll(":", "\\.") + com.snail.antifake.deviceid.e.f37542d;
            }
            String replaceAll = str.replaceAll("at ", "").replaceAll(" ", "");
            if (replaceAll.contains(com.snail.antifake.deviceid.e.f37542d)) {
                replaceAll = replaceAll.replaceAll(com.snail.antifake.deviceid.e.f37542d, "\n\tat ");
            }
            return "\n\tat " + (replaceAll + "_").replaceAll("\n\tat _", com.snail.antifake.deviceid.e.f37542d);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", Log.getStackTraceString(e6));
            return str;
        }
    }

    public static void fM(String str) {
        try {
            d dVar = new d();
            dVar.errorMsg = str;
            dVar.aPQ = a.LL();
            com.kwad.sdk.commercial.b.q(dVar);
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", str);
    }

    private static void h(final String str, final boolean z5) {
        h.execute(new bg() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z5 || f.LO() == 1) {
                    com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "report now :" + str);
                    com.kwad.sdk.crash.report.h.ah("perf-block", str);
                    return;
                }
                BlockReportAction blockReportAction = new BlockReportAction(str);
                com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                final Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
                if (context == null) {
                    return;
                }
                com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).l(blockReportAction);
                if (f.Ij()) {
                    final List<com.kwad.sdk.core.report.e> Ir = com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).Ir();
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.kwad.sdk.core.report.e> it = Ir.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((BlockReportAction) it.next()).msg);
                    }
                    com.kwad.sdk.crash.report.h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onError(int i6, String str2) {
                            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", "errorCode:" + i6 + " errorMsg:" + str2);
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onSuccess() {
                            com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).B(Ir);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Ij() {
        int LO = LO();
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.cc(context).size();
        com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "size:" + size + " limit:" + LO);
        if (size < LO) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int LO() {
        com.kwad.sdk.crash.online.monitor.a.a LM = e.LM();
        if (LM != null) {
            return LM.aQd;
        }
        return 20;
    }

    public static void a(String str, long j6, long j7, String str2, String str3, boolean z5) {
        try {
            h(b(str, j6, j7, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static String b(String str, long j6, long j7, String str2, String str3) {
        try {
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", Log.getStackTraceString(e6));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = fK(b.fI(str));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (j7 == 0) {
            j7 = 2000;
        }
        return c(str, j6, j7, str2, str3).toJson().toString();
    }

    public static void fL(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "reportPrinterName:" + str);
            if (e.LN()) {
                d dVar = new d();
                dVar.aPO = str;
                dVar.aPQ = a.LL();
                com.kwad.sdk.commercial.b.q(dVar);
            }
        }
    }
}

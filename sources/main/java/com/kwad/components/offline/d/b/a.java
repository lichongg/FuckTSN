package com.kwad.components.offline.d.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.activity.k;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static long akT;
    private static final AtomicBoolean ajy = new AtomicBoolean(false);
    private static final String akN = ah.format("lib%s.so", "tk_runtime_v0_0_161");
    private static final String akO = ah.format("lib%s.so", "tk_runtime_lite_v0_0_161");
    private static final String akP = ah.format("lib%s.so", "kwai-v8");
    private static final String akQ = ah.format("lib%s.so", "kwai-v8-lite");
    private static final String akR = ah.format("lib%s.so", "kwad-fb");
    private static final String akS = ah.format("lib%s.so", "kwad-yoga");
    private static final String ajz = ah.format("lib%s.so", "c++_shared");
    private static Boolean akU = null;

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String Fc;
        String str;
        String str2;
        AtomicBoolean atomicBoolean = ajy;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            Fc = e.Fd();
            if (TextUtils.isEmpty(Fc)) {
                Fc = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_lite_3358" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_3358";
            }
            str = useTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = useTkLite ? "0e2d6748c990aa021d01521b6926a5d1" : "581986671ff8549adfa5bcc94410a6d5";
            if (useTkLite) {
                hashMap.put(akO, "0666493e16b18f08ec178a949c41ce30");
                hashMap.put(akQ, "77545ba1892c1a1d4a039db37b3249eb");
            } else {
                hashMap.put(akN, "a72b02a82df72cd82a3acace986099ad");
                hashMap.put(akP, "7316cd8d074b04e6cb21486288d314ce");
            }
            hashMap.put(akR, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(akS, "76308532f64b68fd5a930c42cceec22b");
            hashMap.put(ajz, "2e989e1c8d777ce169376feb637530e9");
        } else {
            Fc = e.Fc();
            if (TextUtils.isEmpty(Fc)) {
                Fc = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_lite_3358" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_3358";
            }
            str = useTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = useTkLite ? "e9821df3990aca6fc2cd6b5b71c5a1df" : "16335fa1eb7d19586a6be6aa74778b5b";
            if (useTkLite) {
                hashMap.put(akO, "cb8a97957aa4cb944a27f4353be3384c");
                hashMap.put(akQ, "2dbd72527a0739740746adaae48ed2e0");
            } else {
                hashMap.put(akN, "75ae8eff358638dcddad68117cbbc494");
                hashMap.put(akP, "519ba633e88efafb8fbd536d800da734");
            }
            hashMap.put(akR, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(akS, "2c6f402c6a565d2e6912b0013fa59380");
            hashMap.put(ajz, "2ce4deb75b884953f20ab2e6e149be98");
        }
        b bVar = new b();
        bVar.ary = com.kwad.sdk.core.network.idc.a.HF().ef(Fc);
        bVar.enable = true;
        bVar.arx = str;
        bVar.version = useTkLite ? "3.3.60-lite" : "3.3.60";
        bVar.arB = false;
        bVar.arA = str2;
        bVar.arD = hashMap;
        com.kwad.library.b.a k6 = com.kwad.library.solder.a.a.k(context, ITkOfflineCompo.PACKAGE_NAME);
        c.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + k6);
        if (k.a(k6)) {
            bVar.arG = k6.zI();
        }
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.d.b.a.1
            @Override // com.kwad.library.solder.lib.ext.b.C0666b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
                ws();
            }

            private void ws() {
                SoLoadListener.this.onLoaded();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0666b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.Af()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0666b, com.kwad.library.solder.lib.ext.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.c cVar) {
                super.e(cVar);
                SoLoadListener.this.onPreUpdate();
                long unused = a.akT = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.Af()).setThreadPoolCoreSize(cVar.zZ().zM().An()).toJson());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0666b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                if (cVar.getState() == 4) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.Af()).setDownloadTime(SystemClock.elapsedRealtime() - a.akT).setDownloadState(1).setThreadPoolCoreSize(cVar.zZ().zM().An()).toJson());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0666b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
            }
        });
    }

    public static boolean useTkLite() {
        if (akU == null) {
            akU = Boolean.valueOf(!e.a(com.kwad.sdk.core.config.c.azk));
        }
        return akU.booleanValue();
    }
}

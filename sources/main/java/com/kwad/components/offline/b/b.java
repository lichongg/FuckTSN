package com.kwad.components.offline.b;

import android.content.Context;
import android.os.Build;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.core.o.b.a<IAdWaynePlayerOfflineCompo> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final b ajI = new b(0);
    }

    /* synthetic */ b(byte b6) {
        this();
    }

    @Override // com.kwad.components.core.o.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z5, IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        a(context, iAdWaynePlayerOfflineCompo);
    }

    private b() {
    }

    @Override // com.kwad.components.core.o.b.a
    public final String getTag() {
        return "AdWaynePlayerInitModule";
    }

    @Override // com.kwad.components.core.o.b.a
    public final boolean isEnabled() {
        return Build.VERSION.SDK_INT >= e.a(com.kwad.sdk.core.config.c.aBV) && ((Boolean) e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue();
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qA() {
        return "4.4.20.1";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qB() {
        return "https://p5-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adWaynePlayer/ks_so-adWaynePlayerNoSoRelease-4.4.20.1-f5fa94106c-87.zip";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qC() {
        return "de8902ac8ffc6225035515217d960ba1";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qD() {
        return "ks_wayne_player_44201";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qE() {
        return IAdWaynePlayerOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qy() {
        return "WAYNEPLAYER";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qz() {
        return IAdWaynePlayerOfflineCompo.PACKAGE_NAME;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.o.b.b.class, methodId = "initOC")
    public static void aF(Context context) {
        wt().init(context);
    }

    private static b wt() {
        return a.ajI;
    }

    private void a(Context context, final IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        iAdWaynePlayerOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i6) {
                b.this.aJ(i6);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z5) {
                try {
                    d.a(com.kwad.components.core.o.a.a.a.class, new com.kwad.components.offline.b.a(iAdWaynePlayerOfflineCompo));
                    b.this.qx();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}

package com.kwad.components.offline.a;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.core.o.b.a<IAdLiveOfflineCompo> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final b ajw = new b(0);
    }

    /* synthetic */ b(byte b6) {
        this();
    }

    @Override // com.kwad.components.core.o.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z5, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        a(context, iAdLiveOfflineCompo);
    }

    private b() {
    }

    @Override // com.kwad.components.core.o.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.o.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.azT)).booleanValue();
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qA() {
        return "3.3.76";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qB() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.76-089e702802-65.zip";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qC() {
        return "611820df0455699043f4a75e86ea0e69";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qD() {
        return "ks_live_3376";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qE() {
        return IAdLiveOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qy() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qz() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.o.b.b.class, methodId = "initOC")
    public static void aF(Context context) {
        wq().init(context);
    }

    private static b wq() {
        return a.ajw;
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i6) {
                b.this.aJ(i6);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z5) {
                try {
                    d.a(com.kwad.components.core.o.a.b.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                    b.this.qx();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}

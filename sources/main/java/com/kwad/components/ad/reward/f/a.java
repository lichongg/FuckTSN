package com.kwad.components.ad.reward.f;

import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.kwad.components.core.video.h;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.k.a<h> {
    private IAdLivePlayModule hR;
    private List<h> uC;
    private long uD;
    private AdLivePlayStateListener uE;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(h hVar) {
        if (hVar != null) {
            this.uC.remove(hVar);
        }
    }

    private void ie() {
        try {
            this.uC.clear();
            this.hR.unRegisterAdLivePlayStateListener(this.uE);
            this.hR.onDestroy();
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.hR.getCurrentShowShopItemInfo();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.hR.getPlayDuration();
    }

    public final void onPause() {
        this.hR.onPause();
    }

    public final void onResume() {
        this.hR.onResume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.hR.pause();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.hR.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.hR.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.hR.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z5, boolean z6) {
        this.hR.setAudioEnabled(z5, z6);
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.hR.skipToEnd();
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.hR.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public a(@NonNull AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule) {
        super(adTemplate);
        this.uC = new CopyOnWriteArrayList();
        this.uD = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.uE = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z5) {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    @Override // com.kwad.sdk.g.a
                    public final /* bridge */ /* synthetic */ void accept(h hVar) {
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayCompleted();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onLivePlayEnd();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayPaused();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j6) {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: c, reason: merged with bridge method [inline-methods] */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(a.this.uD, j6);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onLivePlayResume();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayStart();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPrepared();
                    }
                });
            }
        };
        this.hR = iAdLivePlayModule;
        if (e.ef(adTemplate) == 2) {
            this.uD = com.kwad.sdk.core.response.b.a.ag(e.el(adTemplate));
        }
        this.hR.registerAdLivePlayStateListener(this.uE);
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        ie();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.g.a<h> aVar) {
        if (aVar != null) {
            Iterator<h> it = this.uC.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(h hVar) {
        if (hVar != null) {
            this.uC.add(hVar);
        }
    }
}

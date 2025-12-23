package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.t;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a extends d {
    private o zy;

    @Override // com.kwad.components.ad.reward.presenter.f.d
    protected final boolean jW() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.zy = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            public final boolean isMuted() {
                boolean z5;
                if (!com.kwad.sdk.core.config.e.hC() && com.kwad.components.core.t.a.aC(a.this.getContext()).sW()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (a.this.tm.mVideoPlayConfig.isVideoSoundEnable() && !z5) {
                    return false;
                }
                return true;
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new x() { // from class: com.kwad.components.ad.reward.presenter.f.a.2
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void a(y yVar) {
                super.a(yVar);
                long vE = yVar.vE();
                a.this.tm.rD.onVideoPlayError(yVar.errorCode, (int) vE);
                com.kwad.components.ad.reward.monitor.c.a(a.this.tm.rS, a.this.tm.mAdTemplate, a.this.tm.sr, yVar.errorCode, vE);
                com.kwad.components.ad.reward.monitor.b.c(a.this.tm.rS, a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                a.this.tm.rD.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(a.this.tm.rS, a.this.tm.mAdTemplate, a.this.tm.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                a.this.tm.rD.onVideoPlayEnd();
                a.this.tm.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(a.this.tm);
                if (yVar.vA()) {
                    com.kwad.components.ad.reward.g unused = a.this.tm;
                    com.kwad.components.ad.reward.g.a(a.this.tm.rL, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.g.a
                        /* renamed from: c, reason: merged with bridge method [inline-methods] */
                        public void accept(com.kwad.components.ad.reward.k.a aVar) {
                            com.kwad.components.ad.reward.g unused2 = a.this.tm;
                            aVar.jU();
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                a.this.tm.mAdTemplate.setmCurPlayTime(yVar.qz);
            }
        });
    }

    public void a(ae.a aVar) {
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / bj) + 0.5f);
        aVar.height = (int) ((screenHeight / bj) + 0.5f);
    }
}

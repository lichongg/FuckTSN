package com.beizi.ad.internal;

import com.beizi.ad.internal.f.a;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.BannerAdViewImpl;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class g extends m {

    /* renamed from: a, reason: collision with root package name */
    private final SoftReference<AdViewImpl> f11952a;

    /* renamed from: b, reason: collision with root package name */
    private com.beizi.ad.internal.d.b f11953b;

    /* renamed from: c, reason: collision with root package name */
    private com.beizi.ad.internal.f.a f11954c;

    @Override // com.beizi.ad.internal.f
    public e c() {
        AdViewImpl adViewImpl = this.f11952a.get();
        if (adViewImpl != null) {
            return adViewImpl.getAdParameters();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.m
    public void e() {
        com.beizi.ad.internal.f.a aVar = this.f11954c;
        if (aVar != null) {
            aVar.cancel(true);
            this.f11954c = null;
        }
        a((LinkedList<com.beizi.ad.internal.d.a>) null);
        com.beizi.ad.internal.d.b bVar = this.f11953b;
        if (bVar != null) {
            bVar.a(true);
            this.f11953b = null;
        }
    }

    protected a.C0107a f() {
        if (this.f11952a.get() != null) {
            return this.f11952a.get().getAdRequest();
        }
        return null;
    }

    g(AdViewImpl adViewImpl) {
        this.f11952a = new SoftReference<>(adViewImpl);
    }

    @Override // com.beizi.ad.internal.f
    public void a() {
        if (f() == null) {
            return;
        }
        this.f11954c = new com.beizi.ad.internal.f.a(f());
        g();
        try {
            this.f11954c.a(this);
            this.f11954c.executeOnExecutor(com.beizi.ad.lance.a.c.b().c(), new Void[0]);
            AdViewImpl adViewImpl = this.f11952a.get();
            if (adViewImpl != null) {
                adViewImpl.getAdDispatcher().e();
            }
        } catch (IllegalStateException e6) {
            e6.getMessage();
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // com.beizi.ad.internal.f
    public com.beizi.ad.b.a d() {
        a.C0107a f6 = f();
        if (f6 != null) {
            return f6.a();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.f
    public void a(int i6) {
        h();
        AdViewImpl adViewImpl = this.f11952a.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().a(i6);
        }
    }

    @Override // com.beizi.ad.internal.f
    public void a(final com.beizi.ad.internal.f.c cVar) {
        final AdViewImpl adViewImpl = this.f11952a.get();
        if (adViewImpl != null) {
            adViewImpl.getMyHandler().post(new Runnable() { // from class: com.beizi.ad.internal.g.1
                @Override // java.lang.Runnable
                public void run() {
                    com.beizi.ad.internal.f.c cVar2;
                    com.beizi.ad.internal.f.c cVar3 = cVar;
                    boolean z5 = false;
                    boolean z6 = cVar3 != null && cVar3.h();
                    if (g.this.b() != null && !g.this.b().isEmpty()) {
                        z5 = true;
                    }
                    if (!z6 && !z5) {
                        adViewImpl.getAdDispatcher().a(3);
                        return;
                    }
                    Objects.toString(adViewImpl.getMediaType());
                    k mediaType = adViewImpl.getMediaType();
                    k kVar = k.BANNER;
                    if (mediaType.equals(kVar)) {
                        ((BannerAdViewImpl) adViewImpl).resetContainerIfNeeded();
                    }
                    if (z6) {
                        g.this.a(cVar.g());
                    }
                    if (g.this.b() == null || g.this.b().isEmpty()) {
                        com.beizi.ad.internal.f.c cVar4 = cVar;
                        if (cVar4 != null) {
                            g.this.a(adViewImpl, cVar4);
                            return;
                        }
                        return;
                    }
                    com.beizi.ad.internal.d.a i6 = g.this.i();
                    if (i6 != null && (cVar2 = cVar) != null) {
                        i6.a(cVar2.j());
                    }
                    if (adViewImpl.getMediaType().equals(k.SPLASH)) {
                        g.this.f11953b = com.beizi.ad.internal.d.h.a(adViewImpl.getContext(), g.this, i6, adViewImpl.getAdDispatcher(), adViewImpl.getSplashParent(), cVar);
                        return;
                    }
                    if (adViewImpl.getMediaType().equals(kVar)) {
                        g.this.f11953b = com.beizi.ad.internal.d.c.a(adViewImpl.getContext(), g.this, i6, adViewImpl.getAdDispatcher(), cVar);
                    } else if (adViewImpl.getMediaType().equals(k.INTERSTITIAL)) {
                        g.this.f11953b = com.beizi.ad.internal.d.f.a(adViewImpl.getContext(), g.this, i6, adViewImpl.getAdDispatcher(), cVar);
                    } else {
                        adViewImpl.getAdDispatcher().a(1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0001, B:5:0x0019, B:8:0x002b, B:10:0x0042, B:12:0x004e, B:13:0x0059, B:17:0x0028), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(final com.beizi.ad.internal.view.AdViewImpl r6, final com.beizi.ad.internal.f.c r7) {
        /*
            r5 = this;
            r0 = 0
            com.beizi.ad.internal.e r1 = r6.getAdParameters()     // Catch: java.lang.Exception -> L26
            r1.a(r0)     // Catch: java.lang.Exception -> L26
            com.beizi.ad.internal.view.AdWebView r1 = new com.beizi.ad.internal.view.AdWebView     // Catch: java.lang.Exception -> L26
            r1.<init>(r6)     // Catch: java.lang.Exception -> L26
            com.beizi.ad.internal.k r2 = r6.getMediaType()     // Catch: java.lang.Exception -> L26
            com.beizi.ad.internal.k r3 = com.beizi.ad.internal.k.SPLASH     // Catch: java.lang.Exception -> L26
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L26
            if (r2 != 0) goto L28
            com.beizi.ad.internal.k r2 = r6.getMediaType()     // Catch: java.lang.Exception -> L26
            com.beizi.ad.internal.k r3 = com.beizi.ad.internal.k.BANNER     // Catch: java.lang.Exception -> L26
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L26
            if (r2 == 0) goto L2b
            goto L28
        L26:
            r6 = move-exception
            goto L62
        L28:
            r1.loadAd(r7)     // Catch: java.lang.Exception -> L26
        L2b:
            com.beizi.ad.internal.f.c$a r2 = r7.z()     // Catch: java.lang.Exception -> L26
            com.beizi.ad.internal.f.c$a r3 = r7.A()     // Catch: java.lang.Exception -> L26
            r6.createAdLogo(r2, r3)     // Catch: java.lang.Exception -> L26
            com.beizi.ad.internal.k r2 = r6.getMediaType()     // Catch: java.lang.Exception -> L26
            com.beizi.ad.internal.k r3 = com.beizi.ad.internal.k.BANNER     // Catch: java.lang.Exception -> L26
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L26
            if (r2 == 0) goto L59
            r6.addBannerCloseBtn()     // Catch: java.lang.Exception -> L26
            r2 = r6
            com.beizi.ad.internal.view.BannerAdViewImpl r2 = (com.beizi.ad.internal.view.BannerAdViewImpl) r2     // Catch: java.lang.Exception -> L26
            boolean r3 = r2.getExpandsToFitScreenWidth()     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L59
            int r3 = r7.d()     // Catch: java.lang.Exception -> L26
            int r4 = r7.c()     // Catch: java.lang.Exception -> L26
            r2.expandToFitScreenWidth(r3, r4, r1)     // Catch: java.lang.Exception -> L26
        L59:
            com.beizi.ad.internal.g$2 r2 = new com.beizi.ad.internal.g$2     // Catch: java.lang.Exception -> L26
            r2.<init>()     // Catch: java.lang.Exception -> L26
            r5.a(r2)     // Catch: java.lang.Exception -> L26
            return
        L62:
            r6.toString()
            r5.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.g.a(com.beizi.ad.internal.view.AdViewImpl, com.beizi.ad.internal.f.c):void");
    }

    public void a(com.beizi.ad.internal.f.b bVar) {
        h();
        if (this.f11953b != null) {
            this.f11953b = null;
        }
        AdViewImpl adViewImpl = this.f11952a.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().a(bVar);
        } else {
            bVar.h();
        }
    }
}

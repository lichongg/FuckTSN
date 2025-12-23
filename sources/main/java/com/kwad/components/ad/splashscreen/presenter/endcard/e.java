package com.kwad.components.ad.splashscreen.presenter.endcard;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends com.kwad.components.ad.splashscreen.presenter.e {
    private com.kwad.components.core.webview.tachikoma.f.g mq = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.e.1
        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void v(String str) {
            if ("tk_splash_end_card".equals(str)) {
                e.this.a(new d(), true);
                e.this.a(new a(), true);
                e.this.a(new b(), true);
                e.this.a(new c(), true);
            }
        }
    };

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.mq);
    }
}

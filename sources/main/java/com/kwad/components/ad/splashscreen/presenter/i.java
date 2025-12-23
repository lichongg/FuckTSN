package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class i extends e implements com.kwad.sdk.core.j.c {
    private static long nA = 400;
    private com.kwad.components.ad.splashscreen.e.a Gy;
    private Vibrator gZ;

    protected abstract void fM();

    protected abstract void i(int i6, String str);

    protected abstract void initView();

    protected abstract void mn();

    protected abstract void mo();

    protected abstract void mp();

    protected abstract void mq();

    protected abstract void mr();

    private void ms() {
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Gy;
            if (aVar == null) {
                this.Gy = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Gf.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    {
                        super(r3);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void j(int i6, String str) {
                        i.this.i(i6, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.Gf.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Gy);
            }
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        if (this.Gf.Fv) {
            return;
        }
        mq();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar == null) {
            return;
        }
        AdInfo el = com.kwad.sdk.core.response.b.e.el(hVar.mAdTemplate);
        mp();
        mn();
        if (com.kwad.sdk.core.response.b.a.aF(el)) {
            ms();
        }
        mo();
        fM();
        this.Gf.Fs.a(this);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        mr();
    }

    protected final void mt() {
        Context context = getContext();
        if (context != null) {
            this.gZ = (Vibrator) context.getSystemService("vibrator");
        }
        bw.a(getContext(), this.gZ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        com.kwad.sdk.core.j.a aVar;
        super.onUnbind();
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null && (aVar = hVar.Fs) != null) {
            aVar.b(this);
        }
        mr();
        bw.b(getContext(), this.gZ);
    }
}

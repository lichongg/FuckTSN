package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.k.a<i> implements g.a {
    private com.kwad.components.core.h.c Bg;

    public final FrameLayout T(Context context) {
        FrameLayout imagePlayerView = this.Bg.getImagePlayerView(context);
        this.Bg.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.ad.k.a
    public final void a(i iVar) {
        this.Bg.d(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void b(i iVar) {
        this.Bg.c(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.Bg.getPlayDuration();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hg() {
        this.Bg.destroy();
    }

    public final void kS() {
        this.Bg.setURLs(com.kwad.sdk.core.response.b.a.ba(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)));
        this.Bg.play();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.Bg.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.Bg.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.Bg.skipToEnd();
    }

    public b(@NonNull AdTemplate adTemplate) {
        super(adTemplate);
        long M = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.el(adTemplate));
        com.kwad.components.core.h.c cVar = new com.kwad.components.core.h.c();
        this.Bg = cVar;
        cVar.E(M);
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void he() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hf() {
        pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        this.Bg.destroy();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hd() {
    }
}

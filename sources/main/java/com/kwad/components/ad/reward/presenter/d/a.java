package com.kwad.components.ad.reward.presenter.d;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    private void dm() {
        this.tm.b(this);
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    protected void dt() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.d.b.a());
        a(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    public a() {
        dt();
    }

    private void fa() {
        List<Presenter> NM = NM();
        if (NM != null) {
            for (Object obj : NM) {
                if (obj instanceof c) {
                    ((c) obj).jO();
                }
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        dm();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        fa();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
        fa();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this);
        com.kwad.components.ad.reward.a.gg().b(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
    }
}

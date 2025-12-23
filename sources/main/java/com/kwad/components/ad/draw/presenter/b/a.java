package com.kwad.components.ad.draw.presenter.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private InterfaceC0554a eH;

    @Nullable
    private b eI;
    private boolean eJ = false;
    private AdTemplate mAdTemplate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.draw.presenter.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0554a {
        void aV();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        boolean aW();
    }

    @MainThread
    public final void a(InterfaceC0554a interfaceC0554a) {
        this.eH = interfaceC0554a;
    }

    @MainThread
    public final void a(b bVar) {
        this.eI = bVar;
    }

    public final void aU() {
        InterfaceC0554a interfaceC0554a;
        if (this.eJ) {
            return;
        }
        this.eJ = true;
        if (e.el(this.mAdTemplate).status == 1 || e.el(this.mAdTemplate).status == 2 || e.el(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.eI;
        if ((bVar == null || !bVar.aW()) && (interfaceC0554a = this.eH) != null) {
            interfaceC0554a.aV();
        }
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}

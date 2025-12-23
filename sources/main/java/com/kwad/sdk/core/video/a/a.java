package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a implements c {
    private c.f aKh;
    private c.g aKi;
    private c.h aKj;
    private c.e aaa;
    private c.i aab;
    private c.b aac;
    private c.InterfaceC0691c aad;
    private c.d aae;
    private c.a aaf;

    protected static void h(float f6) {
        if (f6 == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.eE("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.eE("autoVoice");
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.aKh = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.aaa = eVar;
    }

    public final void resetListeners() {
        this.aKh = null;
        this.aaa = null;
        this.aaf = null;
        this.aac = null;
        this.aKi = null;
        this.aab = null;
        this.aad = null;
        this.aae = null;
        this.aKj = null;
    }

    protected final void JV() {
        c.f fVar = this.aKh;
        if (fVar != null) {
            fVar.tG();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.aac = bVar;
    }

    protected final void b(TimedText timedText) {
        c.h hVar = this.aKj;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.aae = dVar;
    }

    public final void notifyOnBufferingUpdate(int i6) {
        c.a aVar = this.aaf;
        if (aVar != null) {
            aVar.aK(i6);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.aac;
        if (bVar != null) {
            bVar.qK();
        }
    }

    public final boolean notifyOnError(int i6, int i7) {
        com.kwad.sdk.core.video.a.a.a.eE("videoPlayError");
        c.InterfaceC0691c interfaceC0691c = this.aad;
        return interfaceC0691c != null && interfaceC0691c.m(i6, i7);
    }

    public final boolean notifyOnInfo(int i6, int i7) {
        c.d dVar = this.aae;
        return dVar != null && dVar.n(i6, i7);
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.aaa;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.aKi;
        if (gVar != null) {
            gVar.qL();
        }
    }

    public final void x(int i6, int i7) {
        c.i iVar = this.aab;
        if (iVar != null) {
            iVar.l(i6, i7);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.aaf = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.aKi = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.aab = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0691c interfaceC0691c) {
        this.aad = interfaceC0691c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.aKj = hVar;
    }
}

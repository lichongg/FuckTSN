package com.bykv.vk.openvk.component.video.j.r;

import com.bykv.vk.openvk.component.video.j.r.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j implements cw {
    private cw.InterfaceC0308cw ae;
    private cw.xt cw;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f22998j = false;

    /* renamed from: m, reason: collision with root package name */
    private cw.ae f22999m;

    /* renamed from: r, reason: collision with root package name */
    private cw.j f23000r;
    private cw.r tl;
    private cw.m up;
    private cw.up xt;

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public final void j(cw.up upVar) {
        this.xt = upVar;
    }

    protected final void xt() {
        try {
            cw.up upVar = this.xt;
            if (upVar != null) {
                upVar.xt(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    protected final void cw() {
        try {
            cw.xt xtVar = this.cw;
            if (xtVar != null) {
                xtVar.j(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public final void j(cw.xt xtVar) {
        this.cw = xtVar;
    }

    protected final void r() {
        try {
            cw.m mVar = this.up;
            if (mVar != null) {
                mVar.cw(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public final void j(cw.j jVar) {
        this.f23000r = jVar;
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public final void j(cw.m mVar) {
        this.up = mVar;
    }

    protected final boolean xt(int i6, int i7) {
        try {
            cw.r rVar = this.tl;
            if (rVar != null) {
                if (rVar.xt(this, i6, i7)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public final void j(cw.InterfaceC0308cw interfaceC0308cw) {
        this.ae = interfaceC0308cw;
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public final void j(cw.r rVar) {
        this.tl = rVar;
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public final void j(cw.ae aeVar) {
        this.f22999m = aeVar;
    }

    public void j() {
        this.xt = null;
        this.f23000r = null;
        this.cw = null;
        this.up = null;
        this.f22999m = null;
        this.ae = null;
        this.tl = null;
    }

    protected final void j(int i6) {
        try {
            cw.j jVar = this.f23000r;
            if (jVar != null) {
                jVar.j(this, i6);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    protected final void j(int i6, int i7, int i8, int i9) {
        try {
            cw.ae aeVar = this.f22999m;
            if (aeVar != null) {
                aeVar.j(this, i6, i7, i8, i9);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    protected final boolean j(int i6, int i7) {
        try {
            cw.InterfaceC0308cw interfaceC0308cw = this.ae;
            if (interfaceC0308cw != null) {
                if (interfaceC0308cw.j(this, i6, i7)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw
    public void j(boolean z5) {
        this.f22998j = z5;
    }
}

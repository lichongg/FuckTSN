package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n implements u {
    private final u amj;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final n amk = new n(0);
    }

    /* synthetic */ n(byte b6) {
        this();
    }

    private n() {
        this.amj = com.kwad.framework.filedownloader.f.e.zB().apH ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z5, int i6, int i7, int i8, boolean z6, com.kwad.framework.filedownloader.d.b bVar, boolean z7) {
        return this.amj.a(str, str2, z5, i6, i7, i8, z6, bVar, z7);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aG(Context context) {
        this.amj.aG(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bw(int i6) {
        return this.amj.bw(i6);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bx(int i6) {
        return this.amj.bx(i6);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean by(int i6) {
        return this.amj.by(i6);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.amj.isConnected();
    }

    public static n xA() {
        return a.amk;
    }

    public static e.a xB() {
        if (xA().amj instanceof o) {
            return (e.a) xA().amj;
        }
        return null;
    }
}

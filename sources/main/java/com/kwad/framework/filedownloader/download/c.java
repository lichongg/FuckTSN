package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.download.ConnectTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements Runnable {
    private final String aca;
    private final int amZ;
    private final ConnectTask anV;
    private final f anW;
    private e anX;
    final int anY;
    private final boolean anw;
    private volatile boolean nf;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private String aca;
        private Boolean anT;
        private f anW;
        private final ConnectTask.a anZ = new ConnectTask.a();
        private Integer aoa;

        public final a a(f fVar) {
            this.anW = fVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.anZ.a(aVar);
            return this;
        }

        public final a bM(int i6) {
            this.anZ.bL(i6);
            return this;
        }

        public final a bs(String str) {
            this.anZ.bp(str);
            return this;
        }

        public final a bt(String str) {
            this.anZ.bq(str);
            return this;
        }

        public final a bu(String str) {
            this.aca = str;
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.anZ.a(bVar);
            return this;
        }

        public final a i(Integer num) {
            this.aoa = num;
            return this;
        }

        public final c yt() {
            if (this.anW == null || this.aca == null || this.anT == null || this.aoa == null) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("%s %s %B", this.anW, this.aca, this.anT));
            }
            ConnectTask yb = this.anZ.yb();
            return new c(yb.amZ, this.aoa.intValue(), yb, this.anW, this.anT.booleanValue(), this.aca, (byte) 0);
        }

        public final a bg(boolean z5) {
            this.anT = Boolean.valueOf(z5);
            return this;
        }
    }

    /* synthetic */ c(int i6, int i7, ConnectTask connectTask, f fVar, boolean z5, String str, byte b6) {
        this(i6, i7, connectTask, fVar, z5, str);
    }

    public final void pause() {
        this.nf = true;
        e eVar = this.anX;
        if (eVar != null) {
            eVar.pause();
        }
    }

    private c(int i6, int i7, ConnectTask connectTask, f fVar, boolean z5, String str) {
        this.amZ = i6;
        this.anY = i7;
        this.nf = false;
        this.anW = fVar;
        this.aca = str;
        this.anV = connectTask;
        this.anw = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0167 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.c.run():void");
    }

    public final void xy() {
        pause();
    }
}

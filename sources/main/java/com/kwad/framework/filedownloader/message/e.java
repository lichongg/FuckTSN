package com.kwad.framework.filedownloader.message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private volatile g aoK;
    private volatile b aoL;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        private static final e aoM = new e();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public final void a(b bVar) {
        this.aoL = bVar;
        if (bVar == null) {
            this.aoK = null;
        } else {
            this.aoK = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.aoL != null) {
                this.aoL.r(messageSnapshot);
            }
        } else if (this.aoK != null) {
            this.aoK.u(messageSnapshot);
        }
    }

    public static e yT() {
        return a.aoM;
    }
}

package com.kwad.sdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private volatile boolean arX = false;
    private com.kwad.sdk.g.a arY;

    public final synchronized void report() {
        if (this.arY != null && !this.arX) {
            this.arY.accept(null);
            this.arX = true;
        }
    }

    public static f ad(final long j6) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.1
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.aj(j6);
            }
        });
    }

    public static f ae(final long j6) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.2
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.ak(j6);
            }
        });
    }

    public static f af(final long j6) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.3
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.an(j6);
            }
        });
    }

    public static f ag(final long j6) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.4
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.ao(j6);
            }
        });
    }

    private static f d(com.kwad.sdk.g.a aVar) {
        return new f(aVar);
    }

    private f(com.kwad.sdk.g.a aVar) {
        this.arY = aVar;
    }
}

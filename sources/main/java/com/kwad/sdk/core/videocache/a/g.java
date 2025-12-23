package com.kwad.sdk.core.videocache.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends e {
    private final long maxSize;

    @Override // com.kwad.sdk.core.videocache.a.e
    protected final boolean aL(long j6) {
        return j6 <= this.maxSize;
    }

    public g(long j6) {
        if (j6 > 0) {
            this.maxSize = j6;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }
}

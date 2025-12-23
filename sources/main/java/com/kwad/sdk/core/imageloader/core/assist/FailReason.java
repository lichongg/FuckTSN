package com.kwad.sdk.core.imageloader.core.assist;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FailReason {
    private final Throwable cause;
    private final FailType type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public Throwable getCause() {
        return this.cause;
    }

    public FailType getType() {
        return this.type;
    }

    public String toString() {
        return "FailReason{type=" + this.type + ", cause=" + this.cause + '}';
    }

    public FailReason(FailType failType, Throwable th) {
        this.type = failType;
        this.cause = th;
    }
}

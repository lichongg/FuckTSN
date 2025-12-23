package com.tencent.open.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class n implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private long f40683a;

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof n) && this.f40683a == ((n) obj).b();
    }

    public byte[] a() {
        long j6 = this.f40683a;
        return new byte[]{(byte) (255 & j6), (byte) ((65280 & j6) >> 8), (byte) ((16711680 & j6) >> 16), (byte) ((j6 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f40683a;
    }

    public int hashCode() {
        return (int) this.f40683a;
    }

    public n(long j6) {
        this.f40683a = j6;
    }
}

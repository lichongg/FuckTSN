package com.danikula.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f32154a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f32155b;

    public b() {
        this(new byte[0]);
    }

    @Override // com.danikula.videocache.d
    public void complete() {
        this.f32155b = true;
    }

    public b(byte[] bArr) {
        this.f32154a = (byte[]) n.d(bArr);
    }

    @Override // com.danikula.videocache.d
    public void a(byte[] bArr, int i6) throws ProxyCacheException {
        n.d(this.f32154a);
        n.b(i6 >= 0 && i6 <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.f32154a, this.f32154a.length + i6);
        System.arraycopy(bArr, 0, copyOf, this.f32154a.length, i6);
        this.f32154a = copyOf;
    }

    @Override // com.danikula.videocache.d
    public long available() throws ProxyCacheException {
        return this.f32154a.length;
    }

    @Override // com.danikula.videocache.d
    public int b(byte[] bArr, long j6, int i6) throws ProxyCacheException {
        if (j6 >= this.f32154a.length) {
            return -1;
        }
        if (j6 <= 2147483647L) {
            return new ByteArrayInputStream(this.f32154a).read(bArr, (int) j6, i6);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j6);
    }

    @Override // com.danikula.videocache.d
    public boolean isCompleted() {
        return this.f32155b;
    }

    @Override // com.danikula.videocache.d
    public void close() throws ProxyCacheException {
    }
}

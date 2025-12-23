package com.danikula.videocache;

import java.io.ByteArrayInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class c implements q {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f32156a;

    /* renamed from: b, reason: collision with root package name */
    private ByteArrayInputStream f32157b;

    @Override // com.danikula.videocache.q
    public void a(long j6) throws ProxyCacheException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f32156a);
        this.f32157b = byteArrayInputStream;
        byteArrayInputStream.skip(j6);
    }

    @Override // com.danikula.videocache.q
    public long length() throws ProxyCacheException {
        return this.f32156a.length;
    }

    @Override // com.danikula.videocache.q
    public int read(byte[] bArr) throws ProxyCacheException {
        return this.f32157b.read(bArr, 0, bArr.length);
    }

    public c(byte[] bArr) {
        this.f32156a = bArr;
    }

    @Override // com.danikula.videocache.q
    public void close() throws ProxyCacheException {
    }
}

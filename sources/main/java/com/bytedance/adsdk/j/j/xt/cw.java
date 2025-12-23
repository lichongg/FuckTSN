package com.bytedance.adsdk.j.j.xt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements m {

    /* renamed from: j, reason: collision with root package name */
    private final ByteBuffer f23169j;

    @Override // com.bytedance.adsdk.j.j.xt.m
    public long j(long j6) throws IOException {
        this.f23169j.position((int) (r0.position() + j6));
        return j6;
    }

    @Override // com.bytedance.adsdk.j.j.xt.m
    public byte c_() throws IOException {
        return this.f23169j.get();
    }

    @Override // com.bytedance.adsdk.j.j.xt.m
    public int cw() {
        return this.f23169j.position();
    }

    @Override // com.bytedance.adsdk.j.j.xt.m
    public void d_() throws IOException {
        this.f23169j.position(0);
    }

    @Override // com.bytedance.adsdk.j.j.xt.m
    public int j(byte[] bArr, int i6, int i7) throws IOException {
        this.f23169j.get(bArr, i6, i7);
        return i7;
    }

    @Override // com.bytedance.adsdk.j.j.xt.m
    public int r() throws IOException {
        return this.f23169j.limit() - this.f23169j.position();
    }

    @Override // com.bytedance.adsdk.j.j.xt.m
    public InputStream up() throws IOException {
        return new ByteArrayInputStream(this.f23169j.array());
    }

    public cw(ByteBuffer byteBuffer) {
        this.f23169j = byteBuffer;
        byteBuffer.position(0);
    }
}

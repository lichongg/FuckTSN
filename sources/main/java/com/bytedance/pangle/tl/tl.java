package com.bytedance.pangle.tl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* loaded from: D:\Downloads\app\classes4.dex */
class tl implements qv {

    /* renamed from: j, reason: collision with root package name */
    private final ByteBuffer f25530j;

    @Override // com.bytedance.pangle.tl.qv
    public long j() {
        return this.f25530j.capacity();
    }

    @Override // com.bytedance.pangle.tl.qv
    public void j(oq oqVar, long j6, int i6) throws IOException, DigestException {
        ByteBuffer slice;
        synchronized (this.f25530j) {
            this.f25530j.position(0);
            int i7 = (int) j6;
            this.f25530j.limit(i6 + i7);
            this.f25530j.position(i7);
            slice = this.f25530j.slice();
        }
        oqVar.j(slice);
    }

    tl(ByteBuffer byteBuffer) {
        this.f25530j = byteBuffer.slice();
    }
}

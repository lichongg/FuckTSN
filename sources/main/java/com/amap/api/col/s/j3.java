package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j3 extends p3 {

    /* renamed from: c, reason: collision with root package name */
    ByteArrayOutputStream f8185c;

    public j3() {
        this.f8185c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) {
        byte[] byteArray = this.f8185c.toByteArray();
        try {
            this.f8185c.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        this.f8185c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.s.p3
    public final void c(byte[] bArr) {
        try {
            this.f8185c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public j3(p3 p3Var) {
        super(p3Var);
        this.f8185c = new ByteArrayOutputStream();
    }
}

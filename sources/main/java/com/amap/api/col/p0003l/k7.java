package com.amap.api.col.p0003l;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k7 extends q7 {

    /* renamed from: c, reason: collision with root package name */
    ByteArrayOutputStream f6692c;

    public k7() {
        this.f6692c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0003l.q7
    protected final byte[] b(byte[] bArr) {
        byte[] byteArray = this.f6692c.toByteArray();
        try {
            this.f6692c.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        this.f6692c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0003l.q7
    public final void c(byte[] bArr) {
        try {
            this.f6692c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public k7(q7 q7Var) {
        super(q7Var);
        this.f6692c = new ByteArrayOutputStream();
    }
}

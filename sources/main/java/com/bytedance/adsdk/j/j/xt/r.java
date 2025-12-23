package com.bytedance.adsdk.j.j.xt;

import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements ae {

    /* renamed from: j, reason: collision with root package name */
    protected ByteBuffer f23170j;

    public void j(byte b6) {
        this.f23170j.put(b6);
    }

    public void cw(int i6) {
        ByteBuffer byteBuffer = this.f23170j;
        if (byteBuffer == null || i6 > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i6);
            this.f23170j = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f23170j.clear();
    }

    public void j(byte[] bArr) {
        this.f23170j.put(bArr);
    }

    public void r(int i6) {
        this.f23170j.position(i6 + j());
    }

    public byte[] xt() {
        return this.f23170j.array();
    }

    public r() {
        cw(Data.MAX_DATA_BYTES);
    }

    public int j() {
        return this.f23170j.position();
    }
}

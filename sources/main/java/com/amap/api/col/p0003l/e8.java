package com.amap.api.col.p0003l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class e8 {

    /* renamed from: a, reason: collision with root package name */
    g8 f6006a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f6007b;

    public final e8 a() {
        this.f6006a.c(this.f6007b);
        return this;
    }

    e8(int i6) {
        ByteBuffer allocate = ByteBuffer.allocate(i6);
        this.f6007b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f6006a = new g8(this.f6007b);
    }
}

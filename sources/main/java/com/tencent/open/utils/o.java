package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class o implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f40684a;

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof o) && this.f40684a == ((o) obj).b();
    }

    public o(byte[] bArr, int i6) {
        int i7 = (bArr[i6 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f40684a = i7;
        this.f40684a = i7 + (bArr[i6] & 255);
    }

    public byte[] a() {
        int i6 = this.f40684a;
        return new byte[]{(byte) (i6 & 255), (byte) ((i6 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f40684a;
    }

    public int hashCode() {
        return this.f40684a;
    }

    public o(int i6) {
        this.f40684a = i6;
    }
}

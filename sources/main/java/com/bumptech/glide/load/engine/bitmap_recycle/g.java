package com.bumptech.glide.load.engine.bitmap_recycle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g implements a<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15014a = "ByteArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i6) {
        return new byte[i6];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String getTag() {
        return f15014a;
    }
}

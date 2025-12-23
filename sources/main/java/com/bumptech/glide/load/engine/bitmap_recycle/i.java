package com.bumptech.glide.load.engine.bitmap_recycle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class i implements a<int[]> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15021a = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int b() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i6) {
        return new int[i6];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String getTag() {
        return f15021a;
    }
}

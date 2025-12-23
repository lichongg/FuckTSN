package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b implements GifDecoder.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15722a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15723b;

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this(eVar, null);
    }

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f15722a = eVar;
        this.f15723b = bVar;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public byte[] a(int i6) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f15723b;
        return bVar == null ? new byte[i6] : (byte[]) bVar.c(i6, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public Bitmap b(int i6, int i7, @NonNull Bitmap.Config config) {
        return this.f15722a.f(i6, i7, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void c(@NonNull Bitmap bitmap) {
        this.f15722a.d(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public int[] d(int i6) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f15723b;
        return bVar == null ? new int[i6] : (int[]) bVar.c(i6, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void e(@NonNull byte[] bArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f15723b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void f(@NonNull int[] iArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f15723b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}

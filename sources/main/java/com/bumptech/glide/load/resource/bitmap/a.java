package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a<DataType> implements com.bumptech.glide.load.g<DataType, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.g<DataType, Bitmap> f15563a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f15564b;

    public a(Context context, com.bumptech.glide.load.g<DataType, Bitmap> gVar) {
        this(context.getResources(), gVar);
    }

    @Deprecated
    public a(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.g<DataType, Bitmap> gVar) {
        this(resources, gVar);
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull DataType datatype, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.f15563a.a(datatype, fVar);
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.u<BitmapDrawable> b(@NonNull DataType datatype, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return d0.c(this.f15564b, this.f15563a.b(datatype, i6, i7, fVar));
    }

    public a(@NonNull Resources resources, @NonNull com.bumptech.glide.load.g<DataType, Bitmap> gVar) {
        this.f15564b = (Resources) com.bumptech.glide.util.k.d(resources);
        this.f15563a = (com.bumptech.glide.load.g) com.bumptech.glide.util.k.d(gVar);
    }
}

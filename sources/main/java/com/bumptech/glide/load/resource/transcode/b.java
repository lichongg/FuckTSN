package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.bitmap.d0;
import com.bumptech.glide.util.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f15773a;

    public b(@NonNull Context context) {
        this(context.getResources());
    }

    @Deprecated
    public b(@NonNull Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this(resources);
    }

    @Override // com.bumptech.glide.load.resource.transcode.e
    @Nullable
    public u<BitmapDrawable> a(@NonNull u<Bitmap> uVar, @NonNull com.bumptech.glide.load.f fVar) {
        return d0.c(this.f15773a, uVar);
    }

    public b(@NonNull Resources resources) {
        this.f15773a = (Resources) k.d(resources);
    }
}

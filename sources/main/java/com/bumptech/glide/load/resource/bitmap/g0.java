package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g0 implements com.bumptech.glide.load.g<Uri, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.drawable.e f15611a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15612b;

    @Override // com.bumptech.glide.load.g
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        com.bumptech.glide.load.engine.u<Drawable> b6 = this.f15611a.b(uri, i6, i7, fVar);
        if (b6 == null) {
            return null;
        }
        return v.a(this.f15612b, b6.get(), i6, i7);
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.f fVar) {
        return "android.resource".equals(uri.getScheme());
    }

    public g0(com.bumptech.glide.load.resource.drawable.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar2) {
        this.f15611a = eVar;
        this.f15612b = eVar2;
    }
}

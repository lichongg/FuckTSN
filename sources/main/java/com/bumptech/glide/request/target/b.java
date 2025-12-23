package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class b<Z> implements p<Z> {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.request.e f16220a;

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public com.bumptech.glide.request.e d() {
        return this.f16220a;
    }

    @Override // com.bumptech.glide.request.target.p
    public void n(@Nullable com.bumptech.glide.request.e eVar) {
        this.f16220a = eVar;
    }

    @Override // com.bumptech.glide.request.target.p
    public void g(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    public void j(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    public void o(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
    }
}

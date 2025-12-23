package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class e<T> implements p<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f16221a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16222b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.request.e f16223c;

    public e() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public e(int i6, int i7) {
        if (com.bumptech.glide.util.l.w(i6, i7)) {
            this.f16221a = i6;
            this.f16222b = i7;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i6 + " and height: " + i7);
    }

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public final com.bumptech.glide.request.e d() {
        return this.f16223c;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void n(@Nullable com.bumptech.glide.request.e eVar) {
        this.f16223c = eVar;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void q(@NonNull o oVar) {
        oVar.d(this.f16221a, this.f16222b);
    }

    @Override // com.bumptech.glide.request.target.p
    public final void b(@NonNull o oVar) {
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

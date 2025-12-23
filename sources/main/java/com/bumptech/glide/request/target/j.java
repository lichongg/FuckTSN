package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j<Z> extends r<ImageView, Z> implements f.a {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private Animatable f16248j;

    public j(ImageView imageView) {
        super(imageView);
    }

    protected abstract void u(@Nullable Z z5);

    @Deprecated
    public j(ImageView imageView, boolean z5) {
        super(imageView, z5);
    }

    private void t(@Nullable Z z5) {
        if (!(z5 instanceof Animatable)) {
            this.f16248j = null;
            return;
        }
        Animatable animatable = (Animatable) z5;
        this.f16248j = animatable;
        animatable.start();
    }

    @Override // com.bumptech.glide.request.transition.f.a
    @Nullable
    public Drawable a() {
        return ((ImageView) this.f16264b).getDrawable();
    }

    @Override // com.bumptech.glide.request.transition.f.a
    public void c(Drawable drawable) {
        ((ImageView) this.f16264b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.p
    public void h(@NonNull Z z5, @Nullable com.bumptech.glide.request.transition.f<? super Z> fVar) {
        if (fVar == null || !fVar.a(z5, this)) {
            v(z5);
        } else {
            t(z5);
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.manager.m
    public void onStart() {
        Animatable animatable = this.f16248j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.manager.m
    public void onStop() {
        Animatable animatable = this.f16248j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    private void v(@Nullable Z z5) {
        u(z5);
        t(z5);
    }

    @Override // com.bumptech.glide.request.target.r, com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void g(@Nullable Drawable drawable) {
        super.g(drawable);
        Animatable animatable = this.f16248j;
        if (animatable != null) {
            animatable.stop();
        }
        v(null);
        c(drawable);
    }

    @Override // com.bumptech.glide.request.target.r, com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void j(@Nullable Drawable drawable) {
        super.j(drawable);
        v(null);
        c(drawable);
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void o(@Nullable Drawable drawable) {
        super.o(drawable);
        v(null);
        c(drawable);
    }
}

package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class a<R> implements g<R> {

    /* renamed from: a, reason: collision with root package name */
    private final g<Drawable> f16277a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.request.transition.a$a, reason: collision with other inner class name */
    private final class C0175a implements f<R> {

        /* renamed from: a, reason: collision with root package name */
        private final f<Drawable> f16278a;

        C0175a(f<Drawable> fVar) {
            this.f16278a = fVar;
        }

        @Override // com.bumptech.glide.request.transition.f
        public boolean a(R r5, f.a aVar) {
            return this.f16278a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.b(r5)), aVar);
        }
    }

    protected abstract Bitmap b(R r5);

    @Override // com.bumptech.glide.request.transition.g
    public f<R> a(DataSource dataSource, boolean z5) {
        return new C0175a(this.f16277a.a(dataSource, z5));
    }

    public a(g<Drawable> gVar) {
        this.f16277a = gVar;
    }
}

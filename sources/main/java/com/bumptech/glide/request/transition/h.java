package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h<R> implements g<R> {

    /* renamed from: a, reason: collision with root package name */
    private final k.a f16290a;

    /* renamed from: b, reason: collision with root package name */
    private f<R> f16291b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private final Animation f16292a;

        @Override // com.bumptech.glide.request.transition.k.a
        public Animation a(Context context) {
            return this.f16292a;
        }

        a(Animation animation) {
            this.f16292a = animation;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private final int f16293a;

        @Override // com.bumptech.glide.request.transition.k.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f16293a);
        }

        b(int i6) {
            this.f16293a = i6;
        }
    }

    public h(Animation animation) {
        this(new a(animation));
    }

    public h(int i6) {
        this(new b(i6));
    }

    @Override // com.bumptech.glide.request.transition.g
    public f<R> a(DataSource dataSource, boolean z5) {
        if (dataSource == DataSource.MEMORY_CACHE || !z5) {
            return e.b();
        }
        if (this.f16291b == null) {
            this.f16291b = new k(this.f16290a);
        }
        return this.f16291b;
    }

    h(k.a aVar) {
        this.f16290a = aVar;
    }
}

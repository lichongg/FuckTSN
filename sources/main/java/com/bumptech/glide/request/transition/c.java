package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements g<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f16280a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16281b;

    /* renamed from: c, reason: collision with root package name */
    private d f16282c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private static final int f16283c = 300;

        /* renamed from: a, reason: collision with root package name */
        private final int f16284a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f16285b;

        public a() {
            this(300);
        }

        public a(int i6) {
            this.f16284a = i6;
        }

        public c a() {
            return new c(this.f16284a, this.f16285b);
        }

        public a b(boolean z5) {
            this.f16285b = z5;
            return this;
        }
    }

    private f<Drawable> b() {
        if (this.f16282c == null) {
            this.f16282c = new d(this.f16280a, this.f16281b);
        }
        return this.f16282c;
    }

    @Override // com.bumptech.glide.request.transition.g
    public f<Drawable> a(DataSource dataSource, boolean z5) {
        return dataSource == DataSource.MEMORY_CACHE ? e.b() : b();
    }

    protected c(int i6, boolean z5) {
        this.f16280a = i6;
        this.f16281b = z5;
    }
}

package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f16358a = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends c {

        /* renamed from: b, reason: collision with root package name */
        private volatile RuntimeException f16359b;

        b() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.c
        void b(boolean z5) {
            if (z5) {
                this.f16359b = new RuntimeException("Released");
            } else {
                this.f16359b = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.c
        public void c() {
            if (this.f16359b != null) {
                throw new IllegalStateException("Already released", this.f16359b);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.util.pool.c$c, reason: collision with other inner class name */
    private static class C0178c extends c {

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f16360b;

        C0178c() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.c
        public void b(boolean z5) {
            this.f16360b = z5;
        }

        @Override // com.bumptech.glide.util.pool.c
        public void c() {
            if (this.f16360b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    abstract void b(boolean z5);

    public abstract void c();

    private c() {
    }

    @NonNull
    public static c a() {
        return new C0178c();
    }
}

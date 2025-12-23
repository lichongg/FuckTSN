package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class c implements m {

    /* renamed from: a, reason: collision with root package name */
    private final b f15006a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f15007b = new h<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class a implements n {

        /* renamed from: a, reason: collision with root package name */
        private final b f15008a;

        /* renamed from: b, reason: collision with root package name */
        private int f15009b;

        /* renamed from: c, reason: collision with root package name */
        private int f15010c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap.Config f15011d;

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.n
        public void a() {
            this.f15008a.c(this);
        }

        public void b(int i6, int i7, Bitmap.Config config) {
            this.f15009b = i6;
            this.f15010c = i7;
            this.f15011d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f15009b == aVar.f15009b && this.f15010c == aVar.f15010c && this.f15011d == aVar.f15011d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i6 = ((this.f15009b * 31) + this.f15010c) * 31;
            Bitmap.Config config = this.f15011d;
            return i6 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.f(this.f15009b, this.f15010c, this.f15011d);
        }

        public a(b bVar) {
            this.f15008a = bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class b extends d<a> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        b() {
        }

        a e(int i6, int i7, Bitmap.Config config) {
            a b6 = b();
            b6.b(i6, i7, config);
            return b6;
        }
    }

    static String f(int i6, int i7, Bitmap.Config config) {
        return "[" + i6 + "x" + i7 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public void d(Bitmap bitmap) {
        this.f15007b.d(this.f15006a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public Bitmap e(int i6, int i7, Bitmap.Config config) {
        return this.f15007b.a(this.f15006a.e(i6, i7, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public Bitmap removeLast() {
        return this.f15007b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f15007b;
    }

    c() {
    }

    private static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public String a(int i6, int i7, Bitmap.Config config) {
        return f(i6, i7, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.util.l.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public String c(Bitmap bitmap) {
        return g(bitmap);
    }
}

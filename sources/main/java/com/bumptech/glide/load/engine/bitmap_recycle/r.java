package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.NavigableMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(19)
/* loaded from: D:\Downloads\app\classes3.dex */
final class r implements m {

    /* renamed from: d, reason: collision with root package name */
    private static final int f15060d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final b f15061a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f15062b = new h<>();

    /* renamed from: c, reason: collision with root package name */
    private final NavigableMap<Integer, Integer> f15063c = new o();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static final class a implements n {

        /* renamed from: a, reason: collision with root package name */
        private final b f15064a;

        /* renamed from: b, reason: collision with root package name */
        int f15065b;

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.n
        public void a() {
            this.f15064a.c(this);
        }

        public void b(int i6) {
            this.f15065b = i6;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f15065b == ((a) obj).f15065b;
        }

        public int hashCode() {
            return this.f15065b;
        }

        public String toString() {
            return r.g(this.f15065b);
        }

        a(b bVar) {
            this.f15064a = bVar;
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

        public a e(int i6) {
            a aVar = (a) super.b();
            aVar.b(i6);
            return aVar;
        }
    }

    private void f(Integer num) {
        Integer num2 = this.f15063c.get(num);
        if (num2.intValue() == 1) {
            this.f15063c.remove(num);
        } else {
            this.f15063c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    static String g(int i6) {
        return "[" + i6 + "]";
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    @Nullable
    public Bitmap removeLast() {
        Bitmap f6 = this.f15062b.f();
        if (f6 != null) {
            f(Integer.valueOf(com.bumptech.glide.util.l.h(f6)));
        }
        return f6;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f15062b + "\n  SortedSizes" + this.f15063c;
    }

    r() {
    }

    private static String h(Bitmap bitmap) {
        return g(com.bumptech.glide.util.l.h(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public String a(int i6, int i7, Bitmap.Config config) {
        return g(com.bumptech.glide.util.l.g(i6, i7, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.util.l.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public String c(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    public void d(Bitmap bitmap) {
        a e6 = this.f15061a.e(com.bumptech.glide.util.l.h(bitmap));
        this.f15062b.d(e6, bitmap);
        Integer num = this.f15063c.get(Integer.valueOf(e6.f15065b));
        NavigableMap<Integer, Integer> navigableMap = this.f15063c;
        Integer valueOf = Integer.valueOf(e6.f15065b);
        int i6 = 1;
        if (num != null) {
            i6 = 1 + num.intValue();
        }
        navigableMap.put(valueOf, Integer.valueOf(i6));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
    @Nullable
    public Bitmap e(int i6, int i7, Bitmap.Config config) {
        int g6 = com.bumptech.glide.util.l.g(i6, i7, config);
        a e6 = this.f15061a.e(g6);
        Integer ceilingKey = this.f15063c.ceilingKey(Integer.valueOf(g6));
        if (ceilingKey != null && ceilingKey.intValue() != g6 && ceilingKey.intValue() <= g6 * 8) {
            this.f15061a.c(e6);
            e6 = this.f15061a.e(ceilingKey.intValue());
        }
        Bitmap a6 = this.f15062b.a(e6);
        if (a6 != null) {
            a6.reconfigure(i6, i7, config);
            f(ceilingKey);
        }
        return a6;
    }
}

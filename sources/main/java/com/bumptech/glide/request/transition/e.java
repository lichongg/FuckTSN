package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e<R> implements f<R> {

    /* renamed from: a, reason: collision with root package name */
    static final e<?> f16288a = new e<>();

    /* renamed from: b, reason: collision with root package name */
    private static final g<?> f16289b = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a<R> implements g<R> {
        @Override // com.bumptech.glide.request.transition.g
        public f<R> a(DataSource dataSource, boolean z5) {
            return e.f16288a;
        }
    }

    @Override // com.bumptech.glide.request.transition.f
    public boolean a(Object obj, f.a aVar) {
        return false;
    }

    public static <R> f<R> b() {
        return f16288a;
    }

    public static <R> g<R> c() {
        return (g<R>) f16289b;
    }
}

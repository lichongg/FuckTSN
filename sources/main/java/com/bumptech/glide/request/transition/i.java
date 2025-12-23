package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i<R> implements g<R> {

    /* renamed from: a, reason: collision with root package name */
    private final j.a f16294a;

    /* renamed from: b, reason: collision with root package name */
    private j<R> f16295b;

    @Override // com.bumptech.glide.request.transition.g
    public f<R> a(DataSource dataSource, boolean z5) {
        if (dataSource == DataSource.MEMORY_CACHE || !z5) {
            return e.b();
        }
        if (this.f16295b == null) {
            this.f16295b = new j<>(this.f16294a);
        }
        return this.f16295b;
    }

    public i(j.a aVar) {
        this.f16294a = aVar;
    }
}

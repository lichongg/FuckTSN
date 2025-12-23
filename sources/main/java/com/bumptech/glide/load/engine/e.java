package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.cache.a;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class e<DataType> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.a<DataType> f15133a;

    /* renamed from: b, reason: collision with root package name */
    private final DataType f15134b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.f f15135c;

    @Override // com.bumptech.glide.load.engine.cache.a.b
    public boolean a(@NonNull File file) {
        return this.f15133a.a(this.f15134b, file, this.f15135c);
    }

    e(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, com.bumptech.glide.load.f fVar) {
        this.f15133a = aVar;
        this.f15134b = datatype;
        this.f15135c = fVar;
    }
}

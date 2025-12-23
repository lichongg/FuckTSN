package com.bumptech.glide.load.resource;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class l<T> implements u<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final T f15769a;

    @Override // com.bumptech.glide.load.engine.u
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<T> a() {
        return (Class<T>) this.f15769a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public final T get() {
        return this.f15769a;
    }

    public l(@NonNull T t5) {
        this.f15769a = (T) com.bumptech.glide.util.k.d(t5);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
    }
}

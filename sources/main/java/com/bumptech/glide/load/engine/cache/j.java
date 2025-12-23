package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface j {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void d(@NonNull u<?> uVar);
    }

    void a(int i6);

    void b();

    void c(float f6);

    @Nullable
    u<?> d(@NonNull com.bumptech.glide.load.c cVar, @Nullable u<?> uVar);

    @Nullable
    u<?> e(@NonNull com.bumptech.glide.load.c cVar);

    void f(@NonNull a aVar);

    long getCurrentSize();

    long getMaxSize();
}

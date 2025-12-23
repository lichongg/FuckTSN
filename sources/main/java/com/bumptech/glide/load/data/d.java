package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface d<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<T> {
        void d(@Nullable T t5);

        void e(@NonNull Exception exc);
    }

    @NonNull
    Class<T> a();

    void b();

    void c(@NonNull Priority priority, @NonNull a<? super T> aVar);

    void cancel();

    @NonNull
    DataSource getDataSource();
}

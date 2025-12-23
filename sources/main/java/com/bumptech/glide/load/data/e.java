package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface e<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<T> {
        @NonNull
        Class<T> a();

        @NonNull
        e<T> b(@NonNull T t5);
    }

    @NonNull
    T a() throws IOException;

    void b();
}

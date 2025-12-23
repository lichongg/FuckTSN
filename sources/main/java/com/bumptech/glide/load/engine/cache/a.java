package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$a, reason: collision with other inner class name */
    public interface InterfaceC0153a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f15075a = 262144000;

        /* renamed from: b, reason: collision with root package name */
        public static final String f15076b = "image_manager_disk_cache";

        @Nullable
        a build();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        boolean a(@NonNull File file);
    }

    void a(com.bumptech.glide.load.c cVar, b bVar);

    @Nullable
    File b(com.bumptech.glide.load.c cVar);

    void clear();

    void delete(com.bumptech.glide.load.c cVar);
}

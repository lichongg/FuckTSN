package com.bumptech.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class m<T> implements com.bumptech.glide.load.i<T> {

    /* renamed from: c, reason: collision with root package name */
    private static final com.bumptech.glide.load.i<?> f15770c = new m();

    @NonNull
    public static <T> m<T> c() {
        return (m) f15770c;
    }

    private m() {
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<T> a(@NonNull Context context, @NonNull u<T> uVar, int i6, int i7) {
        return uVar;
    }
}

package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final b<Object> f14983e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final T f14984a;

    /* renamed from: b, reason: collision with root package name */
    private final b<T> f14985b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14986c;

    /* renamed from: d, reason: collision with root package name */
    private volatile byte[] f14987d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b<T> {
        void update(@NonNull byte[] bArr, @NonNull T t5, @NonNull MessageDigest messageDigest);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    @NonNull
    public static <T> e<T> a(@NonNull String str, @NonNull b<T> bVar) {
        return new e<>(str, null, bVar);
    }

    @NonNull
    public static <T> e<T> b(@NonNull String str, @Nullable T t5, @NonNull b<T> bVar) {
        return new e<>(str, t5, bVar);
    }

    @NonNull
    private static <T> b<T> c() {
        return (b<T>) f14983e;
    }

    @NonNull
    private byte[] e() {
        if (this.f14987d == null) {
            this.f14987d = this.f14986c.getBytes(c.f14919b);
        }
        return this.f14987d;
    }

    @NonNull
    public static <T> e<T> f(@NonNull String str) {
        return new e<>(str, null, c());
    }

    @NonNull
    public static <T> e<T> g(@NonNull String str, @NonNull T t5) {
        return new e<>(str, t5, c());
    }

    @Nullable
    public T d() {
        return this.f14984a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f14986c.equals(((e) obj).f14986c);
        }
        return false;
    }

    public int hashCode() {
        return this.f14986c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f14986c + "'}";
    }

    public void update(@NonNull T t5, @NonNull MessageDigest messageDigest) {
        this.f14985b.update(e(), t5, messageDigest);
    }

    private e(@NonNull String str, @Nullable T t5, @NonNull b<T> bVar) {
        this.f14986c = k.b(str);
        this.f14984a = t5;
        this.f14985b = (b) k.d(bVar);
    }
}

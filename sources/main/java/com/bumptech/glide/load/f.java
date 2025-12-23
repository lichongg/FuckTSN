package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f implements c {

    /* renamed from: c, reason: collision with root package name */
    private final ArrayMap<e<?>, Object> f15395c = new CachedHashCodeArrayMap();

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        for (int i6 = 0; i6 < this.f15395c.size(); i6++) {
            f(this.f15395c.keyAt(i6), this.f15395c.valueAt(i6), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull e<T> eVar) {
        return this.f15395c.containsKey(eVar) ? (T) this.f15395c.get(eVar) : eVar.d();
    }

    public void d(@NonNull f fVar) {
        this.f15395c.putAll((SimpleArrayMap<? extends e<?>, ? extends Object>) fVar.f15395c);
    }

    @NonNull
    public <T> f e(@NonNull e<T> eVar, @NonNull T t5) {
        this.f15395c.put(eVar, t5);
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f15395c.equals(((f) obj).f15395c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f15395c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f15395c + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(@NonNull e<T> eVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        eVar.update(obj, messageDigest);
    }
}

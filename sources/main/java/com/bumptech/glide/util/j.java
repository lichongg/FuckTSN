package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f16339a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f16340b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f16341c;

    public j() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        b(cls, cls2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f16339a.equals(jVar.f16339a) && this.f16340b.equals(jVar.f16340b) && l.d(this.f16341c, jVar.f16341c);
    }

    public j(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2);
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f16339a = cls;
        this.f16340b = cls2;
        this.f16341c = cls3;
    }

    public int hashCode() {
        int hashCode = ((this.f16339a.hashCode() * 31) + this.f16340b.hashCode()) * 31;
        Class<?> cls = this.f16341c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f16339a + ", second=" + this.f16340b + '}';
    }

    public j(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        b(cls, cls2, cls3);
    }
}

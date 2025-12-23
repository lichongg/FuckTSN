package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class n implements com.bumptech.glide.load.c {

    /* renamed from: c, reason: collision with root package name */
    private final Object f15305c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15306d;

    /* renamed from: e, reason: collision with root package name */
    private final int f15307e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f15308f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f15309g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.c f15310h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.i<?>> f15311i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.f f15312j;

    /* renamed from: k, reason: collision with root package name */
    private int f15313k;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f15305c.equals(nVar.f15305c) && this.f15310h.equals(nVar.f15310h) && this.f15307e == nVar.f15307e && this.f15306d == nVar.f15306d && this.f15311i.equals(nVar.f15311i) && this.f15308f.equals(nVar.f15308f) && this.f15309g.equals(nVar.f15309g) && this.f15312j.equals(nVar.f15312j)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f15313k == 0) {
            int hashCode = this.f15305c.hashCode();
            this.f15313k = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f15310h.hashCode()) * 31) + this.f15306d) * 31) + this.f15307e;
            this.f15313k = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f15311i.hashCode();
            this.f15313k = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f15308f.hashCode();
            this.f15313k = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f15309g.hashCode();
            this.f15313k = hashCode5;
            this.f15313k = (hashCode5 * 31) + this.f15312j.hashCode();
        }
        return this.f15313k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f15305c + ", width=" + this.f15306d + ", height=" + this.f15307e + ", resourceClass=" + this.f15308f + ", transcodeClass=" + this.f15309g + ", signature=" + this.f15310h + ", hashCode=" + this.f15313k + ", transformations=" + this.f15311i + ", options=" + this.f15312j + '}';
    }

    n(Object obj, com.bumptech.glide.load.c cVar, int i6, int i7, Map<Class<?>, com.bumptech.glide.load.i<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.f fVar) {
        this.f15305c = com.bumptech.glide.util.k.d(obj);
        this.f15310h = (com.bumptech.glide.load.c) com.bumptech.glide.util.k.e(cVar, "Signature must not be null");
        this.f15306d = i6;
        this.f15307e = i7;
        this.f15311i = (Map) com.bumptech.glide.util.k.d(map);
        this.f15308f = (Class) com.bumptech.glide.util.k.e(cls, "Resource class must not be null");
        this.f15309g = (Class) com.bumptech.glide.util.k.e(cls2, "Transcode class must not be null");
        this.f15312j = (com.bumptech.glide.load.f) com.bumptech.glide.util.k.d(fVar);
    }
}

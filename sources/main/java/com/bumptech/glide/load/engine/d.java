package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class d implements com.bumptech.glide.load.c {

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.c f15131c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.c f15132d;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f15131c.b(messageDigest);
        this.f15132d.b(messageDigest);
    }

    com.bumptech.glide.load.c c() {
        return this.f15131c;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f15131c.equals(dVar.f15131c) && this.f15132d.equals(dVar.f15132d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (this.f15131c.hashCode() * 31) + this.f15132d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f15131c + ", signature=" + this.f15132d + '}';
    }

    d(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2) {
        this.f15131c = cVar;
        this.f15132d = cVar2;
    }
}

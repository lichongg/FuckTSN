package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class w implements com.bumptech.glide.load.c {

    /* renamed from: k, reason: collision with root package name */
    private static final com.bumptech.glide.util.h<Class<?>, byte[]> f15373k = new com.bumptech.glide.util.h<>(50);

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15374c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.c f15375d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.c f15376e;

    /* renamed from: f, reason: collision with root package name */
    private final int f15377f;

    /* renamed from: g, reason: collision with root package name */
    private final int f15378g;

    /* renamed from: h, reason: collision with root package name */
    private final Class<?> f15379h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.f f15380i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.i<?> f15381j;

    private byte[] c() {
        com.bumptech.glide.util.h<Class<?>, byte[]> hVar = f15373k;
        byte[] i6 = hVar.i(this.f15379h);
        if (i6 != null) {
            return i6;
        }
        byte[] bytes = this.f15379h.getName().getBytes(com.bumptech.glide.load.c.f14919b);
        hVar.m(this.f15379h, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f15374c.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f15377f).putInt(this.f15378g).array();
        this.f15376e.b(messageDigest);
        this.f15375d.b(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.i<?> iVar = this.f15381j;
        if (iVar != null) {
            iVar.b(messageDigest);
        }
        this.f15380i.b(messageDigest);
        messageDigest.update(c());
        this.f15374c.put(bArr);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.f15378g == wVar.f15378g && this.f15377f == wVar.f15377f && com.bumptech.glide.util.l.d(this.f15381j, wVar.f15381j) && this.f15379h.equals(wVar.f15379h) && this.f15375d.equals(wVar.f15375d) && this.f15376e.equals(wVar.f15376e) && this.f15380i.equals(wVar.f15380i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f15375d.hashCode() * 31) + this.f15376e.hashCode()) * 31) + this.f15377f) * 31) + this.f15378g;
        com.bumptech.glide.load.i<?> iVar = this.f15381j;
        if (iVar != null) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return (((hashCode * 31) + this.f15379h.hashCode()) * 31) + this.f15380i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f15375d + ", signature=" + this.f15376e + ", width=" + this.f15377f + ", height=" + this.f15378g + ", decodedResourceClass=" + this.f15379h + ", transformation='" + this.f15381j + "', options=" + this.f15380i + '}';
    }

    w(com.bumptech.glide.load.engine.bitmap_recycle.b bVar, com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2, int i6, int i7, com.bumptech.glide.load.i<?> iVar, Class<?> cls, com.bumptech.glide.load.f fVar) {
        this.f15374c = bVar;
        this.f15375d = cVar;
        this.f15376e = cVar2;
        this.f15377f = i6;
        this.f15378g = i7;
        this.f15381j = iVar;
        this.f15379h = cls;
        this.f15380i = fVar;
    }
}

package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.h<com.bumptech.glide.load.c, String> f15126a = new com.bumptech.glide.util.h<>(1000);

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<b> f15127b = com.bumptech.glide.util.pool.a.e(10, new a());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements a.d<b> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        final MessageDigest f15129a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.pool.c f15130b = com.bumptech.glide.util.pool.c.a();

        @Override // com.bumptech.glide.util.pool.a.f
        @NonNull
        public com.bumptech.glide.util.pool.c h() {
            return this.f15130b;
        }

        b(MessageDigest messageDigest) {
            this.f15129a = messageDigest;
        }
    }

    private String a(com.bumptech.glide.load.c cVar) {
        b bVar = (b) com.bumptech.glide.util.k.d(this.f15127b.acquire());
        try {
            cVar.b(bVar.f15129a);
            return com.bumptech.glide.util.l.z(bVar.f15129a.digest());
        } finally {
            this.f15127b.release(bVar);
        }
    }

    public String b(com.bumptech.glide.load.c cVar) {
        String i6;
        synchronized (this.f15126a) {
            i6 = this.f15126a.i(cVar);
        }
        if (i6 == null) {
            i6 = a(cVar);
        }
        synchronized (this.f15126a) {
            this.f15126a.m(cVar, i6);
        }
        return i6;
    }
}

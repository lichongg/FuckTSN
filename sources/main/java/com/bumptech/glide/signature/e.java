package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e implements com.bumptech.glide.load.c {

    /* renamed from: c, reason: collision with root package name */
    private final Object f16306c;

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f16306c.toString().getBytes(com.bumptech.glide.load.c.f14919b));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f16306c.equals(((e) obj).f16306c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f16306c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f16306c + '}';
    }

    public e(@NonNull Object obj) {
        this.f16306c = k.d(obj);
    }
}

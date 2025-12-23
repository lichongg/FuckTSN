package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements com.bumptech.glide.load.c {

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final String f16303c;

    /* renamed from: d, reason: collision with root package name */
    private final long f16304d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16305e;

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f16304d == dVar.f16304d && this.f16305e == dVar.f16305e && this.f16303c.equals(dVar.f16303c);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f16304d).putInt(this.f16305e).array());
        messageDigest.update(this.f16303c.getBytes(com.bumptech.glide.load.c.f14919b));
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        int hashCode = this.f16303c.hashCode() * 31;
        long j6 = this.f16304d;
        return ((hashCode + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.f16305e;
    }

    public d(@Nullable String str, long j6, int i6) {
        this.f16303c = str == null ? "" : str;
        this.f16304d = j6;
        this.f16305e = i6;
    }
}

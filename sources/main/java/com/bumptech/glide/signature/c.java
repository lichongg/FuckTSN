package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c implements com.bumptech.glide.load.c {

    /* renamed from: c, reason: collision with root package name */
    private static final c f16302c = new c();

    @NonNull
    public static c c() {
        return f16302c;
    }

    public String toString() {
        return "EmptySignature";
    }

    private c() {
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
    }
}

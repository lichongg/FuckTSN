package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f14918a = "UTF-8";

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f14919b = Charset.forName("UTF-8");

    void b(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}

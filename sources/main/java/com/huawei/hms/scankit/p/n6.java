package com.huawei.hms.scankit.p;

import java.security.SecureRandom;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class n6 {

    /* renamed from: a, reason: collision with root package name */
    private static final SecureRandom f34597a = new SecureRandom();

    public static int a(int i6) {
        return f34597a.nextInt(i6);
    }

    public static float a(float f6) {
        return f34597a.nextFloat() * f6;
    }
}

package com.baidu.liantian.core;

import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static String f10451a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        char[] charArray = f10451a.toCharArray();
        char[] cArr = new char[16];
        for (int i6 = 0; i6 < 16; i6++) {
            cArr[i6] = charArray[new Random().nextInt(62)];
        }
        return new String(cArr).getBytes();
    }
}

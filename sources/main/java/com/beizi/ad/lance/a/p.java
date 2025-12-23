package com.beizi.ad.lance.a;

import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p {
    public static boolean a(int i6) {
        float nextInt = new Random().nextInt(100);
        m.c("BeiZisAd", "ratio = " + nextInt + ",ratioCheckNum = " + i6);
        return nextInt < ((float) i6);
    }
}

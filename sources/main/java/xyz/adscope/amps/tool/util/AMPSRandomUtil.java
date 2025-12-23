package xyz.adscope.amps.tool.util;

import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSRandomUtil {
    public static int getRandomNum(int i6) {
        return new Random().nextInt(i6) + 1;
    }

    public static boolean isHitRandomNum(int i6, int i7, int i8) {
        return i8 >= i6 && i8 <= i7;
    }

    public static int getNegativeToPositiveRandomNum(int i6) {
        return new Random().nextInt((i6 * 2) + 1) - i6;
    }

    public static int getRandomNum(int i6, int i7) {
        return new Random().nextInt((i7 - i6) + 1) + i6;
    }

    public static boolean isHitRandomNum(int i6) {
        return i6 >= ((int) (Math.random() * 100.0d)) + 1 || i6 == 100;
    }
}

package cn.bluemobi.dylan.base.utils;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d {
    public static int a(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f6) {
        return (int) ((f6 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f6) {
        return (int) ((f6 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int d(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}

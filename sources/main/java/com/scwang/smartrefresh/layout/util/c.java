package com.scwang.smartrefresh.layout.util;

import android.content.res.Resources;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    float f37477a = Resources.getSystem().getDisplayMetrics().density;

    public int a(float f6) {
        return (int) ((f6 * this.f37477a) + 0.5f);
    }

    public float c(float f6) {
        return f6 / this.f37477a;
    }

    public static int b(float f6) {
        return (int) ((f6 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float d(float f6) {
        return f6 / Resources.getSystem().getDisplayMetrics().density;
    }
}

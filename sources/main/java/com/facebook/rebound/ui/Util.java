package com.facebook.rebound.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class Util {
    public static final FrameLayout.LayoutParams b() {
        return a(-1, -1);
    }

    public static final FrameLayout.LayoutParams c() {
        return a(-1, -2);
    }

    public static final FrameLayout.LayoutParams d() {
        return a(-2, -1);
    }

    public static final FrameLayout.LayoutParams e() {
        return a(-2, -2);
    }

    public static final int f(float f6, Resources resources) {
        return (int) TypedValue.applyDimension(1, f6, resources.getDisplayMetrics());
    }

    public static final FrameLayout.LayoutParams a(int i6, int i7) {
        return new FrameLayout.LayoutParams(i6, i7);
    }
}

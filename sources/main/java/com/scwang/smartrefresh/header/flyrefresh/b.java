package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@TargetApi(21)
/* loaded from: D:\Downloads\app\classes6.dex */
class b {
    public static Interpolator a(float f6, float f7) {
        return new PathInterpolator(f6, f7);
    }

    public static Interpolator b(float f6, float f7, float f8, float f9) {
        return new PathInterpolator(f6, f7, f8, f9);
    }

    public static Interpolator c(Path path) {
        return new PathInterpolator(path);
    }

    private b() {
    }
}

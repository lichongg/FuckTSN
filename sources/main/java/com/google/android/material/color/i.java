package com.google.android.material.color;

import android.os.Build;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final /* synthetic */ class i {
    @Nullable
    public static ColorResourcesOverride a() {
        int i6 = Build.VERSION.SDK_INT;
        if (30 <= i6 && i6 <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i6 >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }
}

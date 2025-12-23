package com.beizi.fusion.tool;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g {
    public static File a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getFilesDir();
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getCacheDir();
        } catch (Exception unused) {
            return context.getCacheDir();
        }
    }
}

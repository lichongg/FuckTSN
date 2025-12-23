package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private a() {
    }

    public static boolean a(Context context) {
        if (r1.widthPixels / context.getResources().getDisplayMetrics().density >= 600.0f) {
            return true;
        }
        return false;
    }
}

package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static void a(View view, int i6, int i7, int i8, int i9) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i7 >= 0) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), i7);
            }
            marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 16.0f);
        }
    }

    public static boolean z(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.skipButtonPosition == 0;
    }

    public static boolean a(Context context, int i6, int i7) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i8 = displayMetrics.widthPixels;
        int i9 = displayMetrics.heightPixels;
        int a6 = com.kwad.sdk.c.a.a.a(context, 10.0f);
        return Math.abs(i6 - i8) <= a6 && Math.abs(i7 - i9) <= a6;
    }
}

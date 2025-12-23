package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bz {
    public static boolean a(View view, int i6, boolean z5) {
        return view != null && b(view, i6, z5) && dl(view.getContext());
    }

    private static boolean b(View view, int i6, boolean z5) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity ej = com.kwad.sdk.o.m.ej(view.getContext());
        if ((ej != null && ej.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z5 && !view.hasWindowFocus())) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            long height = r9.height() * r9.width();
            long height2 = view.getHeight() * view.getWidth();
            if (height2 > 0 && height * 100 >= i6 * height2) {
                return true;
            }
        }
        return false;
    }

    public static boolean o(View view, int i6) {
        return view != null && b(view, i6, true) && view.hasWindowFocus() && dl(view.getContext());
    }

    public static double k(View view, boolean z5) {
        if (view == null) {
            return -1.0d;
        }
        if (!dl(view.getContext())) {
            return -2.0d;
        }
        if (view.getParent() == null) {
            return -3.0d;
        }
        Activity ej = com.kwad.sdk.o.m.ej(view.getContext());
        if (ej != null && ej.isFinishing()) {
            return -4.0d;
        }
        if (!view.isShown() || view.getVisibility() != 0) {
            return -5.0d;
        }
        if (!view.hasWindowFocus()) {
            return -6.0d;
        }
        if (!view.getGlobalVisibleRect(new Rect())) {
            return -8.0d;
        }
        long height = r6.height() * r6.width();
        long height2 = view.getHeight() * view.getWidth();
        if (height2 <= 0) {
            return -7.0d;
        }
        return (height * 100.0d) / height2;
    }

    private static boolean dl(Context context) {
        return aw.Rh().dl(context);
    }
}

package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aq {
    public static boolean QW() {
        return isOrientationPortrait();
    }

    public static void d(Context context, boolean z5) {
        try {
            Activity ej = com.kwad.sdk.o.m.ej(context);
            if (ej == null) {
                return;
            }
            if (z5) {
                ej.getWindow().getDecorView().setSystemUiVisibility(1792);
            } else {
                ej.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static boolean dg(Context context) {
        Activity ej = com.kwad.sdk.o.m.ej(context);
        boolean z5 = false;
        if (ej != null) {
            Window window = ej.getWindow();
            if ((window.getAttributes().flags & 1024) == 1024) {
                z5 = true;
            }
            window.setFlags(1024, 1024);
        }
        return z5;
    }

    public static void dh(Context context) {
        Activity ej = com.kwad.sdk.o.m.ej(context);
        if (ej != null) {
            ej.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void di(Context context) {
        Activity ej = com.kwad.sdk.o.m.ej(context);
        if (ej != null) {
            ej.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void dj(Context context) {
        Activity ej = com.kwad.sdk.o.m.ej(context);
        if (ej != null) {
            ej.setRequestedOrientation(1);
        }
    }

    public static boolean isOrientationPortrait() {
        if (StubApp.getOrigApplicationContext(ServiceProvider.Pp().getApplicationContext()).getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }
}

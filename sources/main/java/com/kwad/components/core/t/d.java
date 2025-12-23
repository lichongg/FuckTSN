package com.kwad.components.core.t;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i6, boolean z5) {
        a(activity, 0, true, true);
    }

    public static void a(@NonNull Activity activity, int i6, boolean z5, boolean z6) {
        if (tc()) {
            b(activity, i6, z5);
            if (z6) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    public static boolean tc() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static void b(@NonNull Activity activity, int i6, boolean z5) {
        int i7;
        Window window = activity.getWindow();
        int i8 = Build.VERSION.SDK_INT;
        if (z5 && i8 >= 23) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (bb.Rl()) {
                a(activity, true);
            } else if (bb.Rm()) {
                l.b(activity, true);
            }
            i7 = 9472;
        } else {
            i7 = PredefinedCaptureConfigurations.f35648o;
        }
        window.getDecorView().setSystemUiVisibility(i7);
        window.setStatusBarColor(i6);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    private static boolean a(@NonNull Activity activity, boolean z5) {
        try {
            Integer num = (Integer) z.ar("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            num.intValue();
            z.callMethod(activity.getWindow(), "setExtraFlags", num, num);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }
}

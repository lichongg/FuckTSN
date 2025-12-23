package com.beizi.ad.lance.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g {
    public static View a(int i6, View view, View view2, String str) {
        if (view != null) {
            return a(i6, view2, view, str, true);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0377  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.View a(int r23, android.view.View r24, android.view.View r25, java.lang.String r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1142
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.lance.a.g.a(int, android.view.View, android.view.View, java.lang.String, boolean):android.view.View");
    }

    private static int b(Context context) {
        return context instanceof Activity ? ((Activity) context).getResources().getDisplayMetrics().heightPixels : PredefinedCaptureConfigurations.f35653t;
    }

    private static int c(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        Resources resources = ((Activity) context).getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS));
        m.c("BeiZisAd", "Status height:" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    private static int a(Context context) {
        return context instanceof Activity ? ((Activity) context).getResources().getDisplayMetrics().widthPixels : PredefinedCaptureConfigurations.f35652s;
    }
}

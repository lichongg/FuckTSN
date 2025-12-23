package xyz.adscope.common.tool.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SystemUtil {
    public static boolean checkAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null && str != null) {
            try {
                if (!str.isEmpty()) {
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                        packageInfo = null;
                    }
                    return packageInfo != null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static WeakReference<Context> findActivityContext(View view) {
        Object parent;
        if (view == null) {
            return null;
        }
        try {
            Context context = view.getContext();
            WeakReference weakReference = new WeakReference(view);
            while (weakReference.get() != null && (parent = ((View) weakReference.get()).getParent()) != null && (parent instanceof View)) {
                weakReference = new WeakReference((View) parent);
            }
            View view2 = (View) weakReference.get();
            if (view2 != null) {
                context = view2.getContext();
                if (context instanceof Activity) {
                    return new WeakReference<>((Activity) context);
                }
            }
            return new WeakReference<>(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean hasSdk(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isDarkUiMode(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                return (configuration.uiMode & 48) == 32;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}

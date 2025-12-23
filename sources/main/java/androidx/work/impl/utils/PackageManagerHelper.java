package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> klazz) {
        return isComponentExplicitlyEnabled(context, klazz.getName());
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String className) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, className)) == 1;
    }

    public static void setComponentEnabled(@NonNull Context context, @NonNull Class<?> klazz, boolean enabled) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, klazz.getName()), enabled ? 1 : 2, 1);
            Logger.get().debug(TAG, String.format("%s %s", klazz.getName(), enabled ? "enabled" : "disabled"), new Throwable[0]);
        } catch (Exception e6) {
            Logger.get().debug(TAG, String.format("%s could not be %s", klazz.getName(), enabled ? "enabled" : "disabled"), e6);
        }
    }

    private PackageManagerHelper() {
    }
}

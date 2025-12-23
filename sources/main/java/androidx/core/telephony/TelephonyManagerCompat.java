package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission(g.f36043c)
        @DoNotInline
        static String getDeviceId(TelephonyManager telephonyManager, int i6) {
            return telephonyManager.getDeviceId(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission(g.f36043c)
        @DoNotInline
        static String getImei(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static int getSubscriptionId(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    @Nullable
    @RequiresPermission(g.f36043c)
    @SuppressLint({"MissingPermission"})
    public static String getImei(@NonNull TelephonyManager telephonyManager) {
        int subscriptionId;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 26) {
            return Api26Impl.getImei(telephonyManager);
        }
        if (i6 < 22 || (subscriptionId = getSubscriptionId(telephonyManager)) == Integer.MAX_VALUE || subscriptionId == -1) {
            return telephonyManager.getDeviceId();
        }
        int slotIndex = SubscriptionManagerCompat.getSlotIndex(subscriptionId);
        if (i6 >= 23) {
            return Api23Impl.getDeviceId(telephonyManager, slotIndex);
        }
        try {
            if (sGetDeviceIdMethod == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceId", Integer.TYPE);
                sGetDeviceIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (String) sGetDeviceIdMethod.invoke(telephonyManager, Integer.valueOf(slotIndex));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager telephonyManager) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            return Api30Impl.getSubscriptionId(telephonyManager);
        }
        if (i6 < 22) {
            return Integer.MAX_VALUE;
        }
        try {
            if (sGetSubIdMethod == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", null);
                sGetSubIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSubIdMethod.invoke(telephonyManager, null);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }

    private TelephonyManagerCompat() {
    }
}

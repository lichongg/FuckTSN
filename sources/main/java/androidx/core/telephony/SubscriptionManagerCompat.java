package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(22)
/* loaded from: D:\Downloads\app\classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    public static int getSlotIndex(int i6) {
        if (i6 == -1) {
            return -1;
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            return Api29Impl.getSlotIndex(i6);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                Class<?> cls = Integer.TYPE;
                if (i7 >= 26) {
                    sGetSlotIndexMethod = a.a().getDeclaredMethod("getSlotIndex", cls);
                } else {
                    sGetSlotIndexMethod = a.a().getDeclaredMethod("getSlotId", cls);
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke(null, Integer.valueOf(i6));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int getSlotIndex(int i6) {
            return SubscriptionManager.getSlotIndex(i6);
        }
    }

    private SubscriptionManagerCompat() {
    }
}

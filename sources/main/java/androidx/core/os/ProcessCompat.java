package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ProcessCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Api19Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        @SuppressLint({"DiscouragedPrivateApi"})
        static boolean isApplicationUid(int i6) {
            try {
                synchronized (sResolvedLock) {
                    try {
                        if (!sResolved) {
                            sResolved = true;
                            sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                        }
                    } finally {
                    }
                }
                Method method = sMethodUserHandleIsAppMethod;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i6));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            return true;
        }

        private Api19Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isApplicationUid(int i6) {
            return Process.isApplicationUid(i6);
        }
    }

    public static boolean isApplicationUid(int i6) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.isApplicationUid(i6) : Api19Impl.isApplicationUid(i6);
    }

    private ProcessCompat() {
    }
}

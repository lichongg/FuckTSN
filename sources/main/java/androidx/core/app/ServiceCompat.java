package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    static class Api29Impl {
        @DoNotInline
        static void startForeground(Service service, int i6, Notification notification, int i7) {
            if (i7 == 0 || i7 == -1) {
                service.startForeground(i6, notification, i7);
            } else {
                service.startForeground(i6, notification, i7 & 255);
            }
        }

        private Api29Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(34)
    static class Api34Impl {
        @DoNotInline
        static void startForeground(Service service, int i6, Notification notification, int i7) {
            if (i7 == 0 || i7 == -1) {
                service.startForeground(i6, notification, i7);
            } else {
                service.startForeground(i6, notification, i7 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }

        private Api34Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StopForegroundFlags {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void stopForeground(Service service, int i6) {
            service.stopForeground(i6);
        }
    }

    public static void startForeground(@NonNull Service service, int i6, @NonNull Notification notification, int i7) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 34) {
            Api34Impl.startForeground(service, i6, notification, i7);
        } else if (i8 >= 29) {
            Api29Impl.startForeground(service, i6, notification, i7);
        } else {
            service.startForeground(i6, notification);
        }
    }

    public static void stopForeground(@NonNull Service service, int i6) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.stopForeground(service, i6);
        } else {
            service.stopForeground((i6 & 1) != 0);
        }
    }

    private ServiceCompat() {
    }
}

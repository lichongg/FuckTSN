package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class TileServiceCompat {
    private static TileServiceWrapper sTileServiceWrapper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface TileServiceWrapper {
        void startActivityAndCollapse(PendingIntent pendingIntent);

        void startActivityAndCollapse(Intent intent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void clearTileServiceWrapper() {
        sTileServiceWrapper = null;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void startActivityAndCollapse(TileService tileService, Intent intent) {
            tileService.startActivityAndCollapse(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static void startActivityAndCollapse(TileService tileService, PendingIntent pendingIntent) {
            tileService.startActivityAndCollapse(pendingIntent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setTileServiceWrapper(@NonNull TileServiceWrapper tileServiceWrapper) {
        sTileServiceWrapper = tileServiceWrapper;
    }

    public static void startActivityAndCollapse(@NonNull TileService tileService, @NonNull PendingIntentActivityWrapper pendingIntentActivityWrapper) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 34) {
            TileServiceWrapper tileServiceWrapper = sTileServiceWrapper;
            if (tileServiceWrapper != null) {
                tileServiceWrapper.startActivityAndCollapse(pendingIntentActivityWrapper.getPendingIntent());
                return;
            } else {
                Api34Impl.startActivityAndCollapse(tileService, pendingIntentActivityWrapper.getPendingIntent());
                return;
            }
        }
        if (i6 >= 24) {
            TileServiceWrapper tileServiceWrapper2 = sTileServiceWrapper;
            if (tileServiceWrapper2 != null) {
                tileServiceWrapper2.startActivityAndCollapse(pendingIntentActivityWrapper.getIntent());
            } else {
                Api24Impl.startActivityAndCollapse(tileService, pendingIntentActivityWrapper.getIntent());
            }
        }
    }

    private TileServiceCompat() {
    }
}

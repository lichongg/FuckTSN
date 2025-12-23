package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SupportSQLiteCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Deprecated(message = "Kept for ABI compatibility reasons due to b/402796648 even though minSdk is greater than 16.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Api16Impl {

        @NotNull
        public static final Api16Impl INSTANCE = new Api16Impl();

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final void cancel(@NotNull CancellationSignal cancellationSignal) {
            g0.p(cancellationSignal, "cancellationSignal");
            cancellationSignal.cancel();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @NotNull
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        private Api16Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Deprecated(message = "Kept for ABI compatibility reasons due to b/402796648 even though minSdk is greater than 19.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Api19Impl {

        @NotNull
        public static final Api19Impl INSTANCE = new Api19Impl();

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @NotNull
        public static final Uri getNotificationUri(@NotNull Cursor cursor) {
            g0.p(cursor, "cursor");
            Uri notificationUri = cursor.getNotificationUri();
            g0.o(notificationUri, "getNotificationUri(...)");
            return notificationUri;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final boolean isLowRamDevice(@NotNull ActivityManager activityManager) {
            g0.p(activityManager, "activityManager");
            return activityManager.isLowRamDevice();
        }

        private Api19Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api21Impl {

        @NotNull
        public static final Api21Impl INSTANCE = new Api21Impl();

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final File getNoBackupFilesDir(@NotNull Context context) {
            g0.p(context, "context");
            File noBackupFilesDir = context.getNoBackupFilesDir();
            g0.o(noBackupFilesDir, "getNoBackupFilesDir(...)");
            return noBackupFilesDir;
        }

        private Api21Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api23Impl {

        @NotNull
        public static final Api23Impl INSTANCE = new Api23Impl();

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setExtras(@NotNull Cursor cursor, @NotNull Bundle extras) {
            g0.p(cursor, "cursor");
            g0.p(extras, "extras");
            cursor.setExtras(extras);
        }

        private Api23Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api29Impl {

        @NotNull
        public static final Api29Impl INSTANCE = new Api29Impl();

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final List<Uri> getNotificationUris(@NotNull Cursor cursor) {
            g0.p(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            g0.m(notificationUris);
            return notificationUris;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setNotificationUris(@NotNull Cursor cursor, @NotNull ContentResolver cr, @NotNull List<? extends Uri> uris) {
            g0.p(cursor, "cursor");
            g0.p(cr, "cr");
            g0.p(uris, "uris");
            cursor.setNotificationUris(cr, uris);
        }

        private Api29Impl() {
        }
    }

    private SupportSQLiteCompat() {
    }
}

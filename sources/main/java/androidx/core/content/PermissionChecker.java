package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(@NonNull Context context, @NonNull String str) {
        String str2;
        if (Binder.getCallingPid() == Process.myPid()) {
            str2 = context.getPackageName();
        } else {
            str2 = null;
        }
        return checkPermission(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static int checkCallingPermission(@NonNull Context context, @NonNull String str, @Nullable String str2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return checkPermission(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static int checkPermission(@NonNull Context context, @NonNull String str, int i6, int i7, @Nullable String str2) {
        int noteProxyOpNoThrow;
        if (context.checkPermission(str, i6, i7) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i7);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (myUid == i7 && ObjectsCompat.equals(packageName, str2)) {
            noteProxyOpNoThrow = AppOpsManagerCompat.checkOrNoteProxyOp(context, i7, permissionToOp, str2);
        } else {
            noteProxyOpNoThrow = AppOpsManagerCompat.noteProxyOpNoThrow(context, permissionToOp, str2);
        }
        if (noteProxyOpNoThrow == 0) {
            return 0;
        }
        return -2;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}

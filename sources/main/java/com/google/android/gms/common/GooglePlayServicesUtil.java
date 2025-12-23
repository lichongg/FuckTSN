package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {

    @NonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @Nullable
    @Deprecated
    public static Dialog getErrorDialog(int i6, @NonNull Activity activity, int i7) {
        return getErrorDialog(i6, activity, i7, null);
    }

    @ResultIgnorabilityUnspecified
    @HideFirstParty
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static boolean showErrorDialogFragment(int i6, @NonNull Activity activity, int i7) {
        return showErrorDialogFragment(i6, activity, i7, null);
    }

    @Nullable
    @Deprecated
    public static Dialog getErrorDialog(int i6, @NonNull Activity activity, int i7, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i6)) {
            i6 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i6, i7, onCancelListener);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i6) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i6);
    }

    @ResultIgnorabilityUnspecified
    @InlineMe(imports = {"androidx.fragment.app.Fragment", "com.google.android.gms.common.GooglePlayServicesUtil"}, replacement = "GooglePlayServicesUtil.showErrorDialogFragment(errorCode, activity, (Fragment) null, requestCode, cancelListener)")
    @Deprecated
    public static boolean showErrorDialogFragment(int i6, @NonNull Activity activity, int i7, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i6, activity, null, i7, onCancelListener);
    }

    private GooglePlayServicesUtil() {
    }

    @NonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i6, @NonNull Context context, int i7) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i6, i7);
    }

    @NonNull
    @Deprecated
    public static String getErrorString(int i6) {
        return GooglePlayServicesUtilLight.getErrorString(i6);
    }

    @NonNull
    public static Context getRemoteContext(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    @NonNull
    public static Resources getRemoteResource(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i6) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i6);
    }

    @ResultIgnorabilityUnspecified
    public static boolean showErrorDialogFragment(int i6, @NonNull Activity activity, @Nullable Fragment fragment, int i7, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        int i8 = true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i6) ? 18 : i6;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, i8, i7, onCancelListener);
        }
        Dialog zaa = googleApiAvailability.zaa(activity, i8, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i8, "d"), i7), onCancelListener, null);
        if (zaa == null) {
            return false;
        }
        googleApiAvailability.zad(activity, zaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i6, @NonNull Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (!GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i6) && !GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i6)) {
            googleApiAvailability.showErrorNotification(context, i6);
        } else {
            googleApiAvailability.zaf(context);
        }
    }
}

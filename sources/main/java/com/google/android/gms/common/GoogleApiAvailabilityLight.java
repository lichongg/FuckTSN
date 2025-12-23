package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ShowFirstParty
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class GoogleApiAvailabilityLight {

    @NonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @NonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @KeepForSdk
    static final String TRACKING_SOURCE_DIALOG = "d";

    @KeepForSdk
    static final String TRACKING_SOURCE_NOTIFICATION = "n";

    @KeepForSdk
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();

    @Deprecated
    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(int i6) {
        return getErrorResolutionIntent(null, i6, null);
    }

    @Nullable
    @KeepForSdk
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, int i6, int i7) {
        return getErrorResolutionPendingIntent(context, i6, i7, null);
    }

    @ResultIgnorabilityUnspecified
    @HideFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(@NonNull Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static GoogleApiAvailabilityLight getInstance() {
        return zza;
    }

    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(@Nullable Context context, int i6, @Nullable String str) {
        if (i6 != 1 && i6 != 2) {
            if (i6 != 3) {
                return null;
            }
            Uri fromParts = Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        }
        if (context != null && DeviceProperties.isWearableWithoutPlayStore(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String sb2 = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(sb2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
        }
        intent3.setData(appendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, int i6, int i7, @Nullable String str) {
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i6, str);
        if (errorResolutionIntent == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i7, errorResolutionIntent, com.google.android.gms.internal.common.zzd.zza | AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    @KeepForSdk
    public int isGooglePlayServicesAvailable(@NonNull Context context, int i6) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i6);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    @KeepForSdk
    GoogleApiAvailabilityLight() {
    }

    @KeepForSdk
    public void cancelAvailabilityErrorNotifications(@NonNull Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int getApkVersion(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getClientVersion(context);
    }

    @NonNull
    @KeepForSdk
    public String getErrorString(int i6) {
        return GooglePlayServicesUtilLight.getErrorString(i6);
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPlayServicesPossiblyUpdating(@NonNull Context context, int i6) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i6);
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPlayStorePossiblyUpdating(@NonNull Context context, int i6) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i6);
    }

    @KeepForSdk
    public boolean isUninstalledAppPossiblyUpdating(@NonNull Context context, @NonNull String str) {
        return GooglePlayServicesUtilLight.zza(context, str);
    }

    @KeepForSdk
    public boolean isUserResolvableError(int i6) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i6);
    }

    @KeepForSdk
    public void verifyGooglePlayServicesIsAvailable(@NonNull Context context, int i6) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, i6);
    }
}

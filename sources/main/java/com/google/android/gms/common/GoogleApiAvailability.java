package com.google.android.gms.common;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cn.jiguang.bz.c0;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {com.google.android.gms.internal.base.zad.class, zae.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: D:\Downloads\app\classes5.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    @NonNull
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @GuardedBy("lock")
    private String zac;
    private static final Object zaa = new Object();
    private static final GoogleApiAvailability zab = new GoogleApiAvailability();
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    @NonNull
    public Task<Void> checkApiAvailability(@NonNull GoogleApi<?> googleApi, @NonNull GoogleApi<?>... googleApiArr) {
        return zai(googleApi, googleApiArr).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.gms.common.zab
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                int i6 = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
                return Tasks.forResult(null);
            }
        });
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Activity activity, int i6, int i7) {
        return getErrorDialog(activity, i6, i7, (DialogInterface.OnCancelListener) null);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, int i6, int i7) {
        return super.getErrorResolutionPendingIntent(context, i6, i7);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ResultIgnorabilityUnspecified
    @HideFirstParty
    public int isGooglePlayServicesAvailable(@NonNull Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @ResultIgnorabilityUnspecified
    public boolean showErrorDialogFragment(@NonNull Activity activity, int i6, int i7) {
        return showErrorDialogFragment(activity, i6, i7, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(@NonNull Context context, int i6) {
        zae(context, i6, null, getErrorResolutionPendingIntent(context, i6, 0, "n"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    final Dialog zaa(@NonNull Context context, int i6, @Nullable zag zagVar, @Nullable DialogInterface.OnCancelListener onCancelListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (i6 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.zac.zac(context, i6));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zab2 = com.google.android.gms.common.internal.zac.zab(context, i6);
        if (zab2 != null) {
            if (zagVar == null) {
                zagVar = onClickListener;
            }
            builder.setPositiveButton(zab2, zagVar);
        }
        String zaf = com.google.android.gms.common.internal.zac.zaf(context, i6);
        if (zaf != null) {
            builder.setTitle(zaf);
        }
        String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i6));
        new IllegalArgumentException();
        return builder.create();
    }

    @NonNull
    public static GoogleApiAvailability getInstance() {
        return zab;
    }

    @NonNull
    public static final Task zai(@NonNull HasApiKey hasApiKey, @NonNull HasApiKey... hasApiKeyArr) {
        Preconditions.checkNotNull(hasApiKey, "Requested API must not be null.");
        for (HasApiKey hasApiKey2 : hasApiKeyArr) {
            Preconditions.checkNotNull(hasApiKey2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return GoogleApiManager.zaj().zam(arrayList);
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Activity activity, int i6, int i7, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return zaa(activity, i6, zag.zab(activity, getErrorResolutionIntent(activity, i6, "d"), i7), onCancelListener, null);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        return connectionResult.hasResolution() ? connectionResult.getResolution() : getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(@NonNull Context context, int i6) {
        return super.isGooglePlayServicesAvailable(context, i6);
    }

    @NonNull
    @MainThread
    public Task<Void> makeGooglePlayServicesAvailable(@NonNull Activity activity) {
        int i6 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity, i6);
        if (isGooglePlayServicesAvailable == 0) {
            return Tasks.forResult(null);
        }
        zacc zaa2 = zacc.zaa(activity);
        zaa2.zah(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        return zaa2.zad();
    }

    @ResultIgnorabilityUnspecified
    public boolean showErrorDialogFragment(@NonNull Activity activity, int i6, int i7, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i6, i7, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zad(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @NonNull
    public final Dialog zab(@NonNull Activity activity, @NonNull DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.zac.zac(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zad(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @Nullable
    @ResultIgnorabilityUnspecified
    public final zabx zac(Context context, zabw zabwVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme(WiseOpenHianalyticsData.UNION_PACKAGE);
        zabx zabxVar = new zabx(zabwVar);
        zao.zaa(context, zabxVar, intentFilter);
        zabxVar.zaa(context);
        if (isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            return zabxVar;
        }
        zabwVar.zaa();
        zabxVar.zab();
        return null;
    }

    final void zad(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    final void zaf(Context context) {
        new zad(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    @ResultIgnorabilityUnspecified
    public final boolean zag(@NonNull Activity activity, @NonNull LifecycleFragment lifecycleFragment, int i6, int i7, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i6, zag.zad(lifecycleFragment, getErrorResolutionIntent(activity, i6, "d"), 2), onCancelListener, null);
        if (zaa2 == null) {
            return false;
        }
        zad(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @NonNull
    public Task<Void> checkApiAvailability(@NonNull HasApiKey<?> hasApiKey, @NonNull HasApiKey<?>... hasApiKeyArr) {
        return zai(hasApiKey, hasApiKeyArr).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.gms.common.zaa
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                int i6 = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
                return Tasks.forResult(null);
            }
        });
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(@NonNull Context context) {
        return super.getClientVersion(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(@Nullable Context context, int i6, @Nullable String str) {
        return super.getErrorResolutionIntent(context, i6, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @NonNull
    public final String getErrorString(int i6) {
        return super.getErrorString(i6);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean isUserResolvableError(int i6) {
        return super.isUserResolvableError(i6);
    }

    @TargetApi(26)
    public void setDefaultNotificationChannelId(@NonNull Context context, @NonNull String str) {
        NotificationChannel notificationChannel;
        if (PlatformVersion.isAtLeastO()) {
            notificationChannel = ((NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"))).getNotificationChannel(str);
            Preconditions.checkNotNull(notificationChannel);
        }
        synchronized (zaa) {
            this.zac = str;
        }
    }

    public void showErrorNotification(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        zae(context, connectionResult.getErrorCode(), null, getErrorResolutionPendingIntent(context, connectionResult));
    }

    @TargetApi(20)
    final void zae(Context context, int i6, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        int i7;
        String str2;
        NotificationChannel notificationChannel;
        CharSequence name;
        String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i6), null);
        new IllegalArgumentException();
        if (i6 == 18) {
            zaf(context);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String zae = com.google.android.gms.common.internal.zac.zae(context, i6);
        String zad = com.google.android.gms.common.internal.zac.zad(context, i6);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"));
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(zae).setStyle(new NotificationCompat.BigTextStyle().bigText(zad));
        if (DeviceProperties.isWearable(context)) {
            Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                style.addAction(com.bjtsn.pose_detection.R.drawable.common_full_open_on_phone, resources.getString(com.bjtsn.pose_detection.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(com.bjtsn.pose_detection.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(zad);
        }
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkState(PlatformVersion.isAtLeastO());
            synchronized (zaa) {
                str2 = this.zac;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(com.bjtsn.pose_detection.R.string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(c0.a("com.google.android.gms.availability", string, 4));
                } else {
                    name = notificationChannel.getName();
                    if (!string.contentEquals(name)) {
                        notificationChannel.setName(string);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
            }
            style.setChannelId(str2);
        }
        Notification build = style.build();
        if (i6 != 1 && i6 != 2 && i6 != 3) {
            i7 = 39789;
        } else {
            GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
            i7 = 10436;
        }
        notificationManager.notify(i7, build);
    }

    public final boolean zah(@NonNull Context context, @NonNull ConnectionResult connectionResult, int i6) {
        PendingIntent errorResolutionPendingIntent;
        if (InstantApps.isInstantApp(context) || (errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult)) == null) {
            return false;
        }
        zae(context, connectionResult.getErrorCode(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.zaa(context, errorResolutionPendingIntent, i6, true), zap.zaa | AMapEngineUtils.HALF_MAX_P20_WIDTH));
        return true;
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Fragment fragment, int i6, int i7) {
        return getErrorDialog(fragment, i6, i7, (DialogInterface.OnCancelListener) null);
    }

    public boolean showErrorDialogFragment(@NonNull Activity activity, int i6, @NonNull ActivityResultLauncher<IntentSenderRequest> activityResultLauncher, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i6, null, onCancelListener, new zac(this, activity, i6, activityResultLauncher));
        if (zaa2 == null) {
            return false;
        }
        zad(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Fragment fragment, int i6, int i7, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return zaa(fragment.requireContext(), i6, zag.zac(fragment, getErrorResolutionIntent(fragment.requireContext(), i6, "d"), i7), onCancelListener, null);
    }
}

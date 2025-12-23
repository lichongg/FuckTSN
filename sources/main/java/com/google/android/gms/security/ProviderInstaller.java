package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ProviderInstaller {

    @NonNull
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();

    @GuardedBy("ProviderInstaller.lock")
    private static Method zzc = null;

    @GuardedBy("ProviderInstaller.lock")
    private static Method zzd = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i6, @Nullable Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(@NonNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context context2;
        Preconditions.checkNotNull(context, "Context must not be null");
        zza.verifyGooglePlayServicesIsAvailable(context, 11925000);
        synchronized (zzb) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
            } catch (DynamiteModule.LoadingException e6) {
                "Failed to load providerinstaller module: ".concat(String.valueOf(e6.getMessage()));
                context2 = null;
            }
            if (context2 != null) {
                zzc(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    if (zzd == null) {
                        Class cls = Long.TYPE;
                        zzd = zzb(remoteContext, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, cls, cls});
                    }
                    zzd.invoke(null, context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2));
                } catch (Exception e7) {
                    "Failed to report request stats: ".concat(String.valueOf(e7.getMessage()));
                }
            }
            if (remoteContext == null) {
                throw new GooglePlayServicesNotAvailableException(8);
            }
            zzc(remoteContext, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
        }
    }

    public static void installIfNeededAsync(@NonNull Context context, @NonNull ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    @GuardedBy("ProviderInstaller.lock")
    private static void zzc(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                zzc = zzb(context, str, "insertProvider", new Class[]{Context.class});
            }
            zzc.invoke(null, context);
        } catch (Exception e6) {
            Throwable cause = e6.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                "Failed to install provider: ".concat(String.valueOf(cause == null ? e6.getMessage() : cause.getMessage()));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }

    private static Method zzb(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }
}

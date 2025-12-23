package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.stub.StubApp;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class GmsClientSupervisor {

    @Nullable
    @VisibleForTesting
    static HandlerThread zza;
    private static final Object zzb = new Object();

    @Nullable
    private static zzs zzc;

    @Nullable
    private static Executor zzd;
    private static boolean zze;

    @NonNull
    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, null);
    }

    @KeepForSdk
    public void unbindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        zza(new zzo(componentName, 4225), serviceConnection, str);
    }

    protected abstract void zza(zzo zzoVar, ServiceConnection serviceConnection, String str);

    protected abstract boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor);

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return 4225;
    }

    @NonNull
    @KeepForSdk
    public static GmsClientSupervisor getInstance(@NonNull Context context) {
        synchronized (zzb) {
            try {
                if (zzc == null) {
                    zzc = new zzs(StubApp.getOrigApplicationContext(context.getApplicationContext()), zze ? getOrStartHandlerThread().getLooper() : context.getMainLooper(), zzd);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzc;
    }

    @KeepForSdk
    public static void setDefaultBindExecutor(@Nullable Executor executor) {
        synchronized (zzb) {
            try {
                zzs zzsVar = zzc;
                if (zzsVar != null) {
                    zzsVar.zzi(executor);
                }
                zzd = executor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void setUseHandlerThreadForCallbacks() {
        synchronized (zzb) {
            try {
                zzs zzsVar = zzc;
                if (zzsVar != null && !zze) {
                    zzsVar.zzj(getOrStartHandlerThread().getLooper());
                }
                zze = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(@NonNull String str, @NonNull String str2, int i6, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z5) {
        zza(new zzo(str, str2, 4225, z5), serviceConnection, str3);
    }

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str, @Nullable Executor executor) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, executor);
    }

    @KeepForSdk
    public void unbindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        zza(new zzo(str, 4225, false), serviceConnection, str2);
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread(int i6) {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", i6);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public boolean bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        return zzc(new zzo(str, 4225, false), serviceConnection, str2, null);
    }
}

package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ConnectionTracker {
    private static final Object zzb = new Object();

    @Nullable
    private static volatile ConnectionTracker zzc;

    @NonNull
    @VisibleForTesting
    public final ConcurrentHashMap zza = new ConcurrentHashMap();

    @NonNull
    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (zzc == null) {
            synchronized (zzb) {
                try {
                    if (zzc == null) {
                        zzc = new ConnectionTracker();
                    }
                } finally {
                }
            }
        }
        ConnectionTracker connectionTracker = zzc;
        Preconditions.checkNotNull(connectionTracker);
        return connectionTracker;
    }

    private static boolean zzd(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof zzt);
    }

    private static final boolean zze(Context context, Intent intent, ServiceConnection serviceConnection, int i6, @Nullable Executor executor) {
        boolean bindService;
        if (executor == null) {
            executor = null;
        }
        if (!PlatformVersion.isAtLeastQ() || executor == null) {
            return context.bindService(intent, serviceConnection, i6);
        }
        bindService = context.bindService(intent, i6, executor, serviceConnection);
        return bindService;
    }

    @ResultIgnorabilityUnspecified
    public final boolean zza(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i6, @Nullable Executor executor) {
        return zzc(context, str, intent, serviceConnection, 4225, true, executor);
    }

    private ConnectionTracker() {
    }

    private static void zzb(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean zzc(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i6, boolean z5, @Nullable Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.packageManager(context).getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (zzd(serviceConnection)) {
            ServiceConnection serviceConnection2 = (ServiceConnection) this.zza.putIfAbsent(serviceConnection, serviceConnection);
            if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction());
            }
            try {
                boolean zze = zze(context, intent, serviceConnection, i6, executor);
                if (!zze) {
                    return false;
                }
                return zze;
            } finally {
                this.zza.remove(serviceConnection, serviceConnection);
            }
        }
        return zze(context, intent, serviceConnection, i6, executor);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public boolean bindService(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i6) {
        return zzc(context, context.getClass().getName(), intent, serviceConnection, i6, true, null);
    }

    @KeepForSdk
    public void unbindService(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        if (zzd(serviceConnection) && this.zza.containsKey(serviceConnection)) {
            try {
                zzb(context, (ServiceConnection) this.zza.get(serviceConnection));
                return;
            } finally {
                this.zza.remove(serviceConnection);
            }
        }
        zzb(context, serviceConnection);
    }

    @KeepForSdk
    public void unbindServiceSafe(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }
}

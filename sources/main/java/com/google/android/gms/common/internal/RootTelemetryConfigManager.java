package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class RootTelemetryConfigManager {

    @Nullable
    private static RootTelemetryConfigManager zza;
    private static final RootTelemetryConfiguration zzb = new RootTelemetryConfiguration(0, false, false, 0, 0);

    @Nullable
    private RootTelemetryConfiguration zzc;

    @VisibleForTesting
    public final synchronized void zza(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.zzc = zzb;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.zzc;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
            this.zzc = rootTelemetryConfiguration;
        }
    }

    @NonNull
    @KeepForSdk
    public static synchronized RootTelemetryConfigManager getInstance() {
        RootTelemetryConfigManager rootTelemetryConfigManager;
        synchronized (RootTelemetryConfigManager.class) {
            try {
                if (zza == null) {
                    zza = new RootTelemetryConfigManager();
                }
                rootTelemetryConfigManager = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rootTelemetryConfigManager;
    }

    @Nullable
    @KeepForSdk
    public RootTelemetryConfiguration getConfig() {
        return this.zzc;
    }

    private RootTelemetryConfigManager() {
    }
}

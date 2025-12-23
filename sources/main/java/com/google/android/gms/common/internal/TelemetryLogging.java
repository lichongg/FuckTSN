package com.google.android.gms.common.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class TelemetryLogging {
    @NonNull
    @KeepForSdk
    public static TelemetryLoggingClient getClient(@NonNull Context context) {
        return getClient(context, TelemetryLoggingOptions.zaa);
    }

    @NonNull
    @KeepForSdk
    public static TelemetryLoggingClient getClient(@NonNull Context context, @NonNull TelemetryLoggingOptions telemetryLoggingOptions) {
        return new com.google.android.gms.common.internal.service.zao(context, telemetryLoggingOptions);
    }

    private TelemetryLogging() {
    }
}

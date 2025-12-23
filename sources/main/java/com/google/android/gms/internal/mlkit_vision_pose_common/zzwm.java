package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzwm {
    private final TelemetryLoggingClient zza;
    private final AtomicLong zzb = new AtomicLong(-1);

    public static zzwm zza(Context context) {
        return new zzwm(context, "mlkit:vision");
    }

    final /* synthetic */ void zzb(long j6, Exception exc) {
        this.zzb.set(j6);
    }

    public final synchronized void zzc(int i6, int i7, long j6, long j7) {
        AtomicLong atomicLong = this.zzb;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (atomicLong.get() != -1 && elapsedRealtime - this.zzb.get() <= TimeUnit.MINUTES.toMillis(30L)) {
            return;
        }
        this.zza.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(i6, i7, 0, j6, j7, null, null, 0, -1)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzwl
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzwm.this.zzb(elapsedRealtime, exc);
            }
        });
    }

    @VisibleForTesting
    zzwm(Context context, String str) {
        this.zza = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("mlkit:vision").build());
    }
}

package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zacd implements OnCompleteListener {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey zac;
    private final long zad;
    private final long zae;

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @WorkerThread
    public final void onComplete(@NonNull Task task) {
        zabq zai;
        int i6;
        int i7;
        int i8;
        int i9;
        int errorCode;
        long j6;
        long j7;
        int i10;
        if (this.zaa.zaD()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zai = this.zaa.zai(this.zac)) != null && (zai.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zai.zaf();
                boolean z5 = this.zad > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    z5 &= config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i6 = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration zab = zab(zai, baseGmsClient, this.zab);
                        if (zab == null) {
                            return;
                        }
                        boolean z6 = zab.getMethodTimingTelemetryEnabled() && this.zad > 0;
                        maxMethodInvocationsInBatch = zab.getMaxMethodInvocationsLogged();
                        z5 = z6;
                    }
                    i7 = batchPeriodMillis;
                    i8 = maxMethodInvocationsInBatch;
                } else {
                    i6 = 0;
                    i7 = 5000;
                    i8 = 100;
                }
                GoogleApiManager googleApiManager = this.zaa;
                if (task.isSuccessful()) {
                    i9 = 0;
                    errorCode = 0;
                } else {
                    if (task.isCanceled()) {
                        i9 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            int statusCode = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            if (connectionResult == null) {
                                i9 = statusCode;
                            } else {
                                errorCode = connectionResult.getErrorCode();
                                i9 = statusCode;
                            }
                        } else {
                            i9 = 101;
                        }
                    }
                    errorCode = -1;
                }
                if (z5) {
                    long j8 = this.zad;
                    long j9 = this.zae;
                    j6 = j8;
                    j7 = System.currentTimeMillis();
                    i10 = (int) (SystemClock.elapsedRealtime() - j9);
                } else {
                    j6 = 0;
                    j7 = 0;
                    i10 = -1;
                }
                googleApiManager.zaw(new MethodInvocation(this.zab, i9, errorCode, j6, j7, null, null, gCoreServiceId, i10), i6, i7, i8);
            }
        }
    }

    @VisibleForTesting
    zacd(GoogleApiManager googleApiManager, int i6, ApiKey apiKey, long j6, long j7, @Nullable String str, @Nullable String str2) {
        this.zaa = googleApiManager;
        this.zab = i6;
        this.zac = apiKey;
        this.zad = j6;
        this.zae = j7;
    }

    @Nullable
    static zacd zaa(GoogleApiManager googleApiManager, int i6, ApiKey apiKey) {
        boolean z5;
        long j6;
        if (googleApiManager.zaD()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if (config != null) {
                if (config.getMethodInvocationTelemetryEnabled()) {
                    z5 = config.getMethodTimingTelemetryEnabled();
                    zabq zai = googleApiManager.zai(apiKey);
                    if (zai != null) {
                        if (zai.zaf() instanceof BaseGmsClient) {
                            BaseGmsClient baseGmsClient = (BaseGmsClient) zai.zaf();
                            if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                                ConnectionTelemetryConfiguration zab = zab(zai, baseGmsClient, i6);
                                if (zab != null) {
                                    zai.zaq();
                                    z5 = zab.getMethodTimingTelemetryEnabled();
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            return null;
                        }
                    }
                } else {
                    return null;
                }
            } else {
                z5 = true;
            }
            long j7 = 0;
            if (z5) {
                j6 = System.currentTimeMillis();
            } else {
                j6 = 0;
            }
            if (z5) {
                j7 = SystemClock.elapsedRealtime();
            }
            return new zacd(googleApiManager, i6, apiKey, j6, j7, null, null);
        }
        return null;
    }

    @Nullable
    private static ConnectionTelemetryConfiguration zab(zabq zabqVar, BaseGmsClient baseGmsClient, int i6) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i6) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i6))) || zabqVar.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }
}

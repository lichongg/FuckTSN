package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BackendResponse {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();

    public static BackendResponse fatalError() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse ok(long j6) {
        return new AutoValue_BackendResponse(Status.OK, j6);
    }

    public static BackendResponse transientError() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1L);
    }
}

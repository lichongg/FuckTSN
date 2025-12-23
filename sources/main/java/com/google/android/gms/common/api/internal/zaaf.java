package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zaaf {
    private final ApiKey zaa;
    private final TaskCompletionSource zab = new TaskCompletionSource();

    public final ApiKey zaa() {
        return this.zaa;
    }

    public final TaskCompletionSource zab() {
        return this.zab;
    }

    public zaaf(ApiKey apiKey) {
        this.zaa = apiKey;
    }
}

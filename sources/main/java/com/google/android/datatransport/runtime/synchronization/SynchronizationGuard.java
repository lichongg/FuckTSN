package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@WorkerThread
/* loaded from: D:\Downloads\app\classes4.dex */
public interface SynchronizationGuard {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CriticalSection<T> {
        T execute();
    }

    <T> T runCriticalSection(CriticalSection<T> criticalSection);
}

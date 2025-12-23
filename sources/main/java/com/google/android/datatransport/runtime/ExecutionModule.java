package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Module
/* loaded from: D:\Downloads\app\classes4.dex */
abstract class ExecutionModule {
    @Provides
    @Singleton
    static Executor executor() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }

    ExecutionModule() {
    }
}

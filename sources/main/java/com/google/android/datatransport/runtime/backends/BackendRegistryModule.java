package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Module
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BackendRegistryModule {
    @Binds
    abstract BackendRegistry backendRegistry(MetadataBackendRegistry metadataBackendRegistry);
}

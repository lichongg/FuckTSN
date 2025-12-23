package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {
    private final Provider<Context> contextProvider;
    private final Provider<String> dbNameProvider;
    private final Provider<Integer> schemaVersionProvider;

    public static SchemaManager_Factory create(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager newInstance(Context context, String str, int i6) {
        return new SchemaManager(context, str, i6);
    }

    @Override // javax.inject.Provider
    public SchemaManager get() {
        return newInstance(this.contextProvider.get(), this.dbNameProvider.get(), this.schemaVersionProvider.get().intValue());
    }

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.contextProvider = provider;
        this.dbNameProvider = provider2;
        this.schemaVersionProvider = provider3;
    }
}

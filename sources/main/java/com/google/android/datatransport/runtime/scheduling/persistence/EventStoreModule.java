package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import javax.inject.Named;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Module
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class EventStoreModule {
    @Binds
    abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);

    @Provides
    @Named("SQLITE_DB_NAME")
    static String dbName() {
        return "com.google.android.datatransport.events";
    }

    @Provides
    @Named("SCHEMA_VERSION")
    static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    @Provides
    static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }
}

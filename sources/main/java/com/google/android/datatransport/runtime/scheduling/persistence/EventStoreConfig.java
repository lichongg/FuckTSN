package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
/* loaded from: D:\Downloads\app\classes4.dex */
abstract class EventStoreConfig {
    private static final long DURATION_ONE_WEEK_MS = 604800000;
    private static final int LOAD_BATCH_SIZE = 200;
    private static final int LOCK_TIME_OUT_MS = 10000;
    private static final long MAX_DB_STORAGE_SIZE_IN_BYTES = 10485760;
    private static final int MAX_BLOB_BYTE_SIZE_PER_ROW = 81920;
    static final EventStoreConfig DEFAULT = builder().setMaxStorageSizeInBytes(MAX_DB_STORAGE_SIZE_IN_BYTES).setLoadBatchSize(200).setCriticalSectionEnterTimeoutMs(10000).setEventCleanUpAge(604800000).setMaxBlobByteSizePerRow(MAX_BLOB_BYTE_SIZE_PER_ROW).build();

    abstract int getCriticalSectionEnterTimeoutMs();

    abstract long getEventCleanUpAge();

    abstract int getLoadBatchSize();

    abstract int getMaxBlobByteSizePerRow();

    abstract long getMaxStorageSizeInBytes();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    static abstract class Builder {
        abstract EventStoreConfig build();

        abstract Builder setCriticalSectionEnterTimeoutMs(int i6);

        abstract Builder setEventCleanUpAge(long j6);

        abstract Builder setLoadBatchSize(int i6);

        abstract Builder setMaxBlobByteSizePerRow(int i6);

        abstract Builder setMaxStorageSizeInBytes(long j6);

        Builder() {
        }
    }

    static Builder builder() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    EventStoreConfig() {
    }

    Builder toBuilder() {
        return builder().setMaxStorageSizeInBytes(getMaxStorageSizeInBytes()).setLoadBatchSize(getLoadBatchSize()).setCriticalSectionEnterTimeoutMs(getCriticalSectionEnterTimeoutMs()).setEventCleanUpAge(getEventCleanUpAge()).setMaxBlobByteSizePerRow(getMaxBlobByteSizePerRow());
    }
}

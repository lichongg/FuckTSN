package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.mail.Part;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Singleton
@WorkerThread
/* loaded from: D:\Downloads\app\classes4.dex */
public class SQLiteEventStore implements EventStore, SynchronizationGuard {
    private static final int LOCK_RETRY_BACK_OFF_MILLIS = 50;
    private static final String LOG_TAG = "SQLiteEventStore";
    static final int MAX_RETRIES = 16;
    private static final Encoding PROTOBUF_ENCODING = Encoding.of("proto");
    private final EventStoreConfig config;
    private final Clock monotonicClock;
    private final SchemaManager schemaManager;
    private final Clock wallClock;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Function<T, U> {
        U apply(T t5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Metadata {
        final String key;
        final String value;

        /* synthetic */ Metadata(String str, String str2, AnonymousClass1 anonymousClass1) {
            this(str, str2);
        }

        private Metadata(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Producer<T> {
        T produce();
    }

    static /* synthetic */ Object lambda$clearDb$11(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete(d.ax, null, new String[0]);
        sQLiteDatabase.delete("transport_contexts", null, new String[0]);
        return null;
    }

    static /* synthetic */ List lambda$loadActiveContexts$9(SQLiteDatabase sQLiteDatabase) {
        Function function;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
        function = SQLiteEventStore$$Lambda$20.instance;
        return (List) tryWithCursor(rawQuery, function);
    }

    @Nullable
    private Long getTransportContextId(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Function function;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))));
        if (transportContext.getExtras() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.getExtras(), 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{bm.f41039d}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        function = SQLiteEventStore$$Lambda$6.instance;
        return (Long) tryWithCursor(query, function);
    }

    static /* synthetic */ Object lambda$ensureBeginTransaction$16(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    static /* synthetic */ SQLiteDatabase lambda$getDb$0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    static /* synthetic */ List lambda$loadActiveContexts$8(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.builder().setBackendName(cursor.getString(1)).setPriority(PriorityMapping.valueOf(cursor.getInt(2))).setExtras(maybeBase64Decode(cursor.getString(3))).build());
        }
        return arrayList;
    }

    static /* synthetic */ byte[] lambda$readPayload$13(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i6 += blob.length;
        }
        byte[] bArr = new byte[i6];
        int i7 = 0;
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            byte[] bArr2 = (byte[]) arrayList.get(i8);
            System.arraycopy(bArr2, 0, bArr, i7, bArr2.length);
            i7 += bArr2.length;
        }
        return bArr;
    }

    static /* synthetic */ Object lambda$recordNextCallTime$6(long j6, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j6));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}) < 1) {
            contentValues.put("backend_name", transportContext.getBackendName());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    private List<PersistedEvent> loadEvents(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return arrayList;
        }
        tryWithCursor(sQLiteDatabase.query(d.ax, new String[]{bm.f41039d, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", Part.INLINE}, "context_id = ?", new String[]{transportContextId.toString()}, null, null, null, String.valueOf(this.config.getLoadBatchSize())), SQLiteEventStore$$Lambda$15.lambdaFactory$(this, arrayList, transportContext));
        return arrayList;
    }

    private Map<Long, Set<Metadata>> loadMetadata(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i6 = 0; i6 < list.size(); i6++) {
            sb.append(list.get(i6).getId());
            if (i6 < list.size() - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        sb.append(')');
        tryWithCursor(sQLiteDatabase.query("event_metadata", new String[]{"event_id", CommonNetImpl.NAME, "value"}, sb.toString(), null, null, null, null), SQLiteEventStore$$Lambda$17.lambdaFactory$(hashMap));
        return hashMap;
    }

    private static byte[] maybeBase64Decode(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private <T> T retryIfDbLocked(Producer<T> producer, Function<Throwable, T> function) {
        long time = this.monotonicClock.getTime();
        while (true) {
            try {
                return producer.produce();
            } catch (SQLiteDatabaseLockedException e6) {
                if (this.monotonicClock.getTime() >= this.config.getCriticalSectionEnterTimeoutMs() + time) {
                    return function.apply(e6);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static Encoding toEncoding(@Nullable String str) {
        return str == null ? PROTOBUF_ENCODING : Encoding.of(str);
    }

    private static String toIdList(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getId());
            if (it.hasNext()) {
                sb.append(StringUtil.COMMA);
            }
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public int cleanUp() {
        return ((Integer) inTransaction(SQLiteEventStore$$Lambda$13.lambdaFactory$(this.wallClock.getTime() - this.config.getEventCleanUpAge()))).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.schemaManager.close();
    }

    @VisibleForTesting
    SQLiteDatabase getDb() {
        Function function;
        SchemaManager schemaManager = this.schemaManager;
        schemaManager.getClass();
        Producer lambdaFactory$ = SQLiteEventStore$$Lambda$1.lambdaFactory$(schemaManager);
        function = SQLiteEventStore$$Lambda$4.instance;
        return (SQLiteDatabase) retryIfDbLocked(lambdaFactory$, function);
    }

    @Inject
    SQLiteEventStore(@WallTime Clock clock, @Monotonic Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager) {
        this.schemaManager = schemaManager;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = eventStoreConfig;
    }

    private void ensureBeginTransaction(SQLiteDatabase sQLiteDatabase) {
        Function function;
        Producer lambdaFactory$ = SQLiteEventStore$$Lambda$18.lambdaFactory$(sQLiteDatabase);
        function = SQLiteEventStore$$Lambda$19.instance;
        retryIfDbLocked(lambdaFactory$, function);
    }

    private long ensureTransportContext(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId != null) {
            return transportContextId.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.getBackendName());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (transportContext.getExtras() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private long getPageCount() {
        return getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long getPageSize() {
        return getDb().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private boolean isStorageAtLimit() {
        if (getPageCount() * getPageSize() >= this.config.getMaxStorageSizeInBytes()) {
            return true;
        }
        return false;
    }

    private List<PersistedEvent> join(List<PersistedEvent> list, Map<Long, Set<Metadata>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.getId()))) {
                EventInternal.Builder builder = next.getEvent().toBuilder();
                for (Metadata metadata : map.get(Long.valueOf(next.getId()))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(PersistedEvent.create(next.getId(), next.getTransportContext(), builder.build()));
            }
        }
        return list;
    }

    static /* synthetic */ Object lambda$ensureBeginTransaction$15(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    static /* synthetic */ Long lambda$getNextCallTime$4(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    static /* synthetic */ Long lambda$getTransportContextId$2(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    static /* synthetic */ Boolean lambda$hasPendingEventsFor$5(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Function function;
        Long transportContextId = sQLiteEventStore.getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return Boolean.FALSE;
        }
        Cursor rawQuery = sQLiteEventStore.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
        function = SQLiteEventStore$$Lambda$21.instance;
        return (Boolean) tryWithCursor(rawQuery, function);
    }

    static /* synthetic */ List lambda$loadBatch$7(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> loadEvents = sQLiteEventStore.loadEvents(sQLiteDatabase, transportContext);
        return sQLiteEventStore.join(loadEvents, sQLiteEventStore.loadMetadata(sQLiteDatabase, loadEvents));
    }

    static /* synthetic */ Object lambda$loadEvents$12(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z5 = false;
            long j6 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z5 = true;
            }
            EventInternal.Builder uptimeMillis = EventInternal.builder().setTransportName(cursor.getString(1)).setEventMillis(cursor.getLong(2)).setUptimeMillis(cursor.getLong(3));
            if (z5) {
                uptimeMillis.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                uptimeMillis.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), sQLiteEventStore.readPayload(j6)));
            }
            if (!cursor.isNull(6)) {
                uptimeMillis.setCode(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.create(j6, transportContext, uptimeMillis.build()));
        }
        return null;
    }

    static /* synthetic */ Object lambda$loadMetadata$14(Map map, Cursor cursor) {
        while (true) {
            AnonymousClass1 anonymousClass1 = null;
            if (!cursor.moveToNext()) {
                return null;
            }
            long j6 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j6));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j6), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2), anonymousClass1));
        }
    }

    static /* synthetic */ Long lambda$persist$1(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal, SQLiteDatabase sQLiteDatabase) {
        boolean z5;
        byte[] bArr;
        if (sQLiteEventStore.isStorageAtLimit()) {
            return -1L;
        }
        long ensureTransportContext = sQLiteEventStore.ensureTransportContext(sQLiteDatabase, transportContext);
        int maxBlobByteSizePerRow = sQLiteEventStore.config.getMaxBlobByteSizePerRow();
        byte[] bytes = eventInternal.getEncodedPayload().getBytes();
        if (bytes.length <= maxBlobByteSizePerRow) {
            z5 = true;
        } else {
            z5 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(ensureTransportContext));
        contentValues.put("transport_name", eventInternal.getTransportName());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.getEventMillis()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.getUptimeMillis()));
        contentValues.put("payload_encoding", eventInternal.getEncodedPayload().getEncoding().getName());
        contentValues.put("code", eventInternal.getCode());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put(Part.INLINE, Boolean.valueOf(z5));
        if (z5) {
            bArr = bytes;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        long insert = sQLiteDatabase.insert(d.ax, null, contentValues);
        if (!z5) {
            int ceil = (int) Math.ceil(bytes.length / maxBlobByteSizePerRow);
            for (int i6 = 1; i6 <= ceil; i6++) {
                byte[] copyOfRange = Arrays.copyOfRange(bytes, (i6 - 1) * maxBlobByteSizePerRow, Math.min(i6 * maxBlobByteSizePerRow, bytes.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i6));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : eventInternal.getMetadata().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put(CommonNetImpl.NAME, entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    static /* synthetic */ Object lambda$recordFailure$3(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    private byte[] readPayload(long j6) {
        Function function;
        Cursor query = getDb().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j6)}, null, null, "sequence_num");
        function = SQLiteEventStore$$Lambda$16.instance;
        return (byte[]) tryWithCursor(query, function);
    }

    @VisibleForTesting
    static <T> T tryWithCursor(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void clearDb() {
        Function function;
        function = SQLiteEventStore$$Lambda$14.instance;
        inTransaction(function);
    }

    @VisibleForTesting
    long getByteSize() {
        return getPageCount() * getPageSize();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public long getNextCallTime(TransportContext transportContext) {
        Function function;
        Cursor rawQuery = getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))});
        function = SQLiteEventStore$$Lambda$8.instance;
        return ((Long) tryWithCursor(rawQuery, function)).longValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public boolean hasPendingEventsFor(TransportContext transportContext) {
        return ((Boolean) inTransaction(SQLiteEventStore$$Lambda$9.lambdaFactory$(this, transportContext))).booleanValue();
    }

    @VisibleForTesting
    <T> T inTransaction(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            T apply = function.apply(db);
            db.setTransactionSuccessful();
            return apply;
        } finally {
            db.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<TransportContext> loadActiveContexts() {
        return (Iterable) inTransaction(SQLiteEventStore$$Lambda$12.instance);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<PersistedEvent> loadBatch(TransportContext transportContext) {
        return (Iterable) inTransaction(SQLiteEventStore$$Lambda$11.lambdaFactory$(this, transportContext));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    @Nullable
    public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
        Logging.d(LOG_TAG, "Storing event with priority=%s, name=%s for destination %s", transportContext.getPriority(), eventInternal.getTransportName(), transportContext.getBackendName());
        long longValue = ((Long) inTransaction(SQLiteEventStore$$Lambda$5.lambdaFactory$(this, transportContext, eventInternal))).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.create(longValue, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void recordFailure(Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        inTransaction(SQLiteEventStore$$Lambda$7.lambdaFactory$("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + toIdList(iterable)));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void recordNextCallTime(TransportContext transportContext, long j6) {
        inTransaction(SQLiteEventStore$$Lambda$10.lambdaFactory$(j6, transportContext));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void recordSuccess(Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        getDb().compileStatement("DELETE FROM events WHERE _id in " + toIdList(iterable)).execute();
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    public <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase db = getDb();
        ensureBeginTransaction(db);
        try {
            T execute = criticalSection.execute();
            db.setTransactionSuccessful();
            return execute;
        } finally {
            db.endTransaction();
        }
    }
}

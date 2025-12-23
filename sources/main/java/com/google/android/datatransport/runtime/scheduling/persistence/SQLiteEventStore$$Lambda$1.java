package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$1 implements SQLiteEventStore.Producer {
    private final SchemaManager arg$1;

    public static SQLiteEventStore.Producer lambdaFactory$(SchemaManager schemaManager) {
        return new SQLiteEventStore$$Lambda$1(schemaManager);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    public Object produce() {
        return this.arg$1.getWritableDatabase();
    }

    private SQLiteEventStore$$Lambda$1(SchemaManager schemaManager) {
        this.arg$1 = schemaManager;
    }
}

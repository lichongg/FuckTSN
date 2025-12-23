package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$12 implements SQLiteEventStore.Function {
    private static final SQLiteEventStore$$Lambda$12 instance = new SQLiteEventStore$$Lambda$12();

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadActiveContexts$9((SQLiteDatabase) obj);
    }

    private SQLiteEventStore$$Lambda$12() {
    }
}

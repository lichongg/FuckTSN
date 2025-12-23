package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$10 implements SQLiteEventStore.Function {
    private final long arg$1;
    private final TransportContext arg$2;

    public static SQLiteEventStore.Function lambdaFactory$(long j6, TransportContext transportContext) {
        return new SQLiteEventStore$$Lambda$10(j6, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordNextCallTime$6(this.arg$1, this.arg$2, (SQLiteDatabase) obj);
    }

    private SQLiteEventStore$$Lambda$10(long j6, TransportContext transportContext) {
        this.arg$1 = j6;
        this.arg$2 = transportContext;
    }
}

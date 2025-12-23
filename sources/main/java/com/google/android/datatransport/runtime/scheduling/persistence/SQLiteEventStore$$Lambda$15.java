package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$15 implements SQLiteEventStore.Function {
    private final SQLiteEventStore arg$1;
    private final List arg$2;
    private final TransportContext arg$3;

    public static SQLiteEventStore.Function lambdaFactory$(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        return new SQLiteEventStore$$Lambda$15(sQLiteEventStore, list, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadEvents$12(this.arg$1, this.arg$2, this.arg$3, (Cursor) obj);
    }

    private SQLiteEventStore$$Lambda$15(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.arg$1 = sQLiteEventStore;
        this.arg$2 = list;
        this.arg$3 = transportContext;
    }
}

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$5 implements SQLiteEventStore.Function {
    private final SQLiteEventStore arg$1;
    private final TransportContext arg$2;
    private final EventInternal arg$3;

    public static SQLiteEventStore.Function lambdaFactory$(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        return new SQLiteEventStore$$Lambda$5(sQLiteEventStore, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$persist$1(this.arg$1, this.arg$2, this.arg$3, (SQLiteDatabase) obj);
    }

    private SQLiteEventStore$$Lambda$5(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        this.arg$1 = sQLiteEventStore;
        this.arg$2 = transportContext;
        this.arg$3 = eventInternal;
    }
}

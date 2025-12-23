package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$18 implements SQLiteEventStore.Producer {
    private final SQLiteDatabase arg$1;

    public static SQLiteEventStore.Producer lambdaFactory$(SQLiteDatabase sQLiteDatabase) {
        return new SQLiteEventStore$$Lambda$18(sQLiteDatabase);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    public Object produce() {
        return SQLiteEventStore.lambda$ensureBeginTransaction$15(this.arg$1);
    }

    private SQLiteEventStore$$Lambda$18(SQLiteDatabase sQLiteDatabase) {
        this.arg$1 = sQLiteDatabase;
    }
}

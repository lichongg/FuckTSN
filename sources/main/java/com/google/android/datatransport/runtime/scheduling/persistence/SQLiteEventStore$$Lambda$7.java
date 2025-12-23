package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$7 implements SQLiteEventStore.Function {
    private final String arg$1;

    public static SQLiteEventStore.Function lambdaFactory$(String str) {
        return new SQLiteEventStore$$Lambda$7(str);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordFailure$3(this.arg$1, (SQLiteDatabase) obj);
    }

    private SQLiteEventStore$$Lambda$7(String str) {
        this.arg$1 = str;
    }
}

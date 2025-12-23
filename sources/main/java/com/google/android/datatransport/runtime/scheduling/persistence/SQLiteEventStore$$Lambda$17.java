package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$17 implements SQLiteEventStore.Function {
    private final Map arg$1;

    public static SQLiteEventStore.Function lambdaFactory$(Map map) {
        return new SQLiteEventStore$$Lambda$17(map);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadMetadata$14(this.arg$1, (Cursor) obj);
    }

    private SQLiteEventStore$$Lambda$17(Map map) {
        this.arg$1 = map;
    }
}

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.umeng.analytics.pro.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class SQLiteEventStore$$Lambda$13 implements SQLiteEventStore.Function {
    private final long arg$1;

    public static SQLiteEventStore.Function lambdaFactory$(long j6) {
        return new SQLiteEventStore$$Lambda$13(j6);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((SQLiteDatabase) obj).delete(d.ax, "timestamp_ms < ?", new String[]{String.valueOf(this.arg$1)}));
        return valueOf;
    }

    private SQLiteEventStore$$Lambda$13(long j6) {
        this.arg$1 = j6;
    }
}

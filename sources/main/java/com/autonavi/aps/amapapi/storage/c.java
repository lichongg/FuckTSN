package com.autonavi.aps.amapapi.storage;

import android.database.sqlite.SQLiteDatabase;
import com.amap.api.col.p0003l.d6;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements d6 {
    @Override // com.amap.api.col.p0003l.d6
    public final void a(SQLiteDatabase sQLiteDatabase, int i6) {
    }

    @Override // com.amap.api.col.p0003l.d6
    public final int c() {
        return 1;
    }

    @Override // com.amap.api.col.p0003l.d6
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "SdCardDbCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.p0003l.d6
    public final String b() {
        return "alsn20170807.db";
    }
}

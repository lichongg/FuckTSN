package com.amap.api.col.p0003l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r0 implements d6 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile r0 f7160a;

    public static r0 a() {
        if (f7160a == null) {
            synchronized (r0.class) {
                try {
                    if (f7160a == null) {
                        f7160a = new r0();
                    }
                } finally {
                }
            }
        }
        return f7160a;
    }

    @Override // com.amap.api.col.p0003l.d6
    public final int c() {
        return 2;
    }

    @Override // com.amap.api.col.p0003l.d6
    public final String b() {
        return "offlineDbV4.db";
    }

    private r0() {
    }

    @Override // com.amap.api.col.p0003l.d6
    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
        } catch (Throwable th) {
            v5.p(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.d6
    public final void a(SQLiteDatabase sQLiteDatabase, int i6) {
        SQLiteDatabase sQLiteDatabase2;
        if (sQLiteDatabase != null && i6 == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase2 = null;
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("url"));
                    String substring = string.substring(string.lastIndexOf("/") + 1);
                    sQLiteDatabase2.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }
}

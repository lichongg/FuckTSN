package com.beizi.ad.internal.i.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.beizi.ad.internal.i.k;
import com.beizi.ad.internal.i.p;
import com.umeng.analytics.pro.bm;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class a extends SQLiteOpenHelper implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f12206a = {bm.f41039d, "url", "length", IMediaFormat.KEY_MIME};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        k.a(context);
    }

    @Override // com.beizi.ad.internal.i.b.c
    public p a(String str) {
        k.a(str);
        Cursor cursor = null;
        r1 = null;
        p a6 = null;
        try {
            Cursor query = getReadableDatabase().query("SourceInfo", f12206a, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        a6 = a(query);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return a6;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        k.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // com.beizi.ad.internal.i.b.c
    public void a(String str, p pVar) {
        k.a(str, pVar);
        boolean z5 = a(str) != null;
        ContentValues a6 = a(pVar);
        if (z5) {
            getWritableDatabase().update("SourceInfo", a6, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a6);
        }
    }

    private p a(Cursor cursor) {
        return new p(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getInt(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(IMediaFormat.KEY_MIME)));
    }

    private ContentValues a(p pVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", pVar.f12260a);
        contentValues.put("length", Integer.valueOf(pVar.f12261b));
        contentValues.put(IMediaFormat.KEY_MIME, pVar.f12262c);
        return contentValues;
    }
}

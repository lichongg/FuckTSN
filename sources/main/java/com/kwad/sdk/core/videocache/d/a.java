package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.n;
import com.kwad.sdk.utils.ax;
import com.umeng.analytics.pro.bm;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a extends SQLiteOpenHelper implements c {
    private static final String[] aLH = {bm.f41039d, "url", "length", IMediaFormat.KEY_MIME};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        ax.checkNotNull(context);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        ax.d(str, nVar);
        boolean z5 = eS(str) != null;
        ContentValues a6 = a(nVar);
        if (z5) {
            getWritableDatabase().update("SourceInfo", a6, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a6);
        }
    }

    private static n h(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(IMediaFormat.KEY_MIME)));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eS(String str) {
        ax.hh(str);
        Cursor cursor = null;
        r1 = null;
        n h6 = null;
        try {
            Cursor query = getReadableDatabase().query("SourceInfo", aLH, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        h6 = h(query);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(query);
            return h6;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ax.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    private static ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.url);
        contentValues.put("length", Long.valueOf(nVar.aLB));
        contentValues.put(IMediaFormat.KEY_MIME, nVar.aLC);
        return contentValues;
    }
}

package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.n;
import com.danikula.videocache.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class a extends SQLiteOpenHelper implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32244a = "SourceInfo";

    /* renamed from: b, reason: collision with root package name */
    private static final String f32245b = "_id";

    /* renamed from: c, reason: collision with root package name */
    private static final String f32246c = "url";

    /* renamed from: e, reason: collision with root package name */
    private static final String f32248e = "mime";

    /* renamed from: g, reason: collision with root package name */
    private static final String f32250g = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";

    /* renamed from: d, reason: collision with root package name */
    private static final String f32247d = "length";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f32249f = {"_id", "url", f32247d, "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        n.d(context);
    }

    @Override // com.danikula.videocache.sourcestorage.c
    public void a(String str, s sVar) {
        n.a(str, sVar);
        boolean z5 = get(str) != null;
        ContentValues b6 = b(sVar);
        if (z5) {
            getWritableDatabase().update(f32244a, b6, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(f32244a, null, b6);
        }
    }

    private ContentValues b(s sVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sVar.f32241a);
        contentValues.put(f32247d, Long.valueOf(sVar.f32242b));
        contentValues.put("mime", sVar.f32243c);
        return contentValues;
    }

    private s c(Cursor cursor) {
        return new s(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(f32247d)), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.danikula.videocache.sourcestorage.c
    public s get(String str) {
        n.d(str);
        Cursor cursor = null;
        r1 = null;
        s c6 = null;
        try {
            Cursor query = getReadableDatabase().query(f32244a, f32249f, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c6 = c(query);
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
            return c6;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        n.d(sQLiteDatabase);
        sQLiteDatabase.execSQL(f32250g);
    }

    @Override // com.danikula.videocache.sourcestorage.c
    public void release() {
        close();
    }
}

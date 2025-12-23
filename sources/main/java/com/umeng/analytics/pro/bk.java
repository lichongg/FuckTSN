package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bk extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f41024b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static bk f41025c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f41026d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* renamed from: e, reason: collision with root package name */
    private static final String f41027e = "DROP TABLE IF EXISTS stf";

    /* renamed from: f, reason: collision with root package name */
    private static final String f41028f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* renamed from: a, reason: collision with root package name */
    private final Context f41029a;

    public static final int a() {
        return 1;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f41026d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    public static bk a(Context context) {
        bk bkVar;
        synchronized (f41024b) {
            try {
                if (f41025c == null) {
                    f41025c = new bk(context, bm.f41037b, null, 1);
                }
                bkVar = f41025c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bkVar;
    }

    public boolean c() {
        return !b(bm.f41038c);
    }

    private bk(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i6) {
        super(context, str, cursorFactory, i6);
        this.f41029a = context;
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                try {
                    writableDatabase.execSQL(f41028f);
                } catch (Throwable unused) {
                }
                writableDatabase.close();
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f41027e);
            sQLiteDatabase.execSQL(f41026d);
        } catch (SQLException unused) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.isOpen()) {
                        cursor = sQLiteDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return false;
                    }
                    sQLiteDatabase.close();
                    return false;
                }
            }
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    cursor.close();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        sQLiteDatabase.close();
        return false;
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public bl a(String str) {
        Cursor cursor;
        bl blVar = null;
        try {
            cursor = a(str, new String[]{bm.f41044i, bm.f41040e, bm.f41041f, bm.f41042g, bm.f41045j, bm.f41046k}, null, null, null, null, null, "1");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        bl blVar2 = new bl();
                        try {
                            blVar2.f41030a = cursor.getString(0);
                            blVar2.f41031b = cursor.getString(1);
                            String string = cursor.getString(2);
                            String string2 = cursor.getString(3);
                            blVar2.f41032c = i.a(this.f41029a).d(string);
                            blVar2.f41033d = i.a(this.f41029a).d(string2);
                            blVar2.f41034e = cursor.getString(4);
                            blVar2.f41035f = cursor.getString(5);
                            blVar = blVar2;
                        } catch (Throwable unused) {
                            blVar = blVar2;
                            try {
                                d();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return blVar;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            return blVar;
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }
}

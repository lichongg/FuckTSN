package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class f extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    private static Context f41287b;

    /* renamed from: a, reason: collision with root package name */
    private String f41288a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f41289a = new f(f.f41287b, h.b(f.f41287b), e.f41221b, null, 2, null);

        private a() {
        }
    }

    /* synthetic */ f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i6, AnonymousClass1 anonymousClass1) {
        this(context, str, str2, cursorFactory, i6);
    }

    public static f a(Context context) {
        if (f41287b == null) {
            f41287b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f41289a;
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i6) {
        this(new c(context, str), str2, cursorFactory, i6);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f41288a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f41288a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f41288a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.f41262a, "__av")) {
            h.a(sQLiteDatabase, e.d.f41262a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.f41262a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.f41262a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.f41262a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.f41236a, "__av")) {
            h.a(sQLiteDatabase, e.b.f41236a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.f41236a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.f41225a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.f41225a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.f41225a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.f41262a);
        a(sQLiteDatabase, e.b.f41236a);
        a(sQLiteDatabase, e.a.f41225a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        if (i7 <= i6 || i6 != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            f(sQLiteDatabase);
        }
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i6) {
        super(context, TextUtils.isEmpty(str) ? e.f41221b : str, cursorFactory, i6);
        this.f41288a = null;
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    c(sQLiteDatabase);
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                    a(sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (SQLiteDatabaseCorruptException unused) {
                    h.a(f41287b);
                    if (sQLiteDatabase == null) {
                        return;
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                    if (sQLiteDatabase == null) {
                        return;
                    }
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable unused4) {
        }
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.f41262a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.f41249a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.f41236a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.f41225a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f41288a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}

package com.umeng.socialize.net.dplus.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class StandardDBHelper extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static Context f42476a;

    /* renamed from: b, reason: collision with root package name */
    private String f42477b;

    public StandardDBHelper(Context context) {
        super(context, DBConfig.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.f42477b = null;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f42477b = "create table if not exists stats (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists stats (Id integer primary key,_json TEXT)");
        } catch (SQLException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f42477b = "create table if not exists s_e (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists s_e (Id integer primary key,_json TEXT)");
        } catch (SQLException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f42477b = "create table if not exists auth (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists auth (Id integer primary key,_json TEXT)");
        } catch (SQLException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f42477b = "create table if not exists userinfo (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists userinfo (Id integer primary key,_json TEXT)");
        } catch (SQLException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f42477b = "create table if not exists dau (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists dau (Id integer primary key,_json TEXT)");
        } catch (SQLException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
        b(sQLiteDatabase);
        c(sQLiteDatabase);
        d(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }
}

package com.bytedance.msdk.up.j;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends SQLiteOpenHelper {
    private void j(SQLiteDatabase sQLiteDatabase) {
        com.bytedance.msdk.j.up.cw.j("DBHelper", "initDB........");
        try {
            sQLiteDatabase.execSQL(j());
        } catch (Throwable th) {
            vl.j(th);
        }
        try {
            sQLiteDatabase.execSQL(xt());
        } catch (Throwable th2) {
            vl.j(th2);
        }
    }

    public tl(Context context, String str, int i6) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.j(context), str, (SQLiteDatabase.CursorFactory) null, i6);
        com.bytedance.msdk.j.up.cw.j("DBHelper", "DatabaseHelper ........");
    }

    private static String cw() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    private static String r() {
        return "ALTER TABLE adevent_applog ADD COLUMN encrypt INTEGER default 0";
    }

    private static String xt() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        try {
            com.bytedance.msdk.j.up.cw.j("DBHelper", "onUpgrade....数据库版本升级.....");
            if (i6 == 1 || i6 == 2) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_freqctl';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_pacing';");
            } else if (i6 != 3) {
                return;
            }
            sQLiteDatabase.execSQL(xt());
            j(sQLiteDatabase, i6, i7);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            j(sQLiteDatabase);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private void j(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        try {
            sQLiteDatabase.execSQL(cw());
        } catch (Throwable th) {
            vl.j(th);
        }
        try {
            sQLiteDatabase.execSQL(r());
        } catch (Throwable th2) {
            vl.j(th2);
        }
    }

    private static String j() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }
}

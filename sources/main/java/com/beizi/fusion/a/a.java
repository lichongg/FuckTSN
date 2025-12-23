package com.beizi.fusion.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.beizi.fusion.tool.aa;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f13289a;

    private a(Context context) {
        super(context, "beizi_ad.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    static a a(Context context) {
        if (f13289a == null) {
            synchronized (a.class) {
                try {
                    if (f13289a == null) {
                        f13289a = new a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } finally {
                }
            }
        }
        return f13289a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        if (i7 <= i6) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query("Sqlite_master", new String[]{CommonNetImpl.NAME}, "type=?", new String[]{"table"}, null, null, null);
                while (cursor.moveToNext()) {
                    String string = cursor.getString(0);
                    if (string != null && string.startsWith("T_")) {
                        aa.c("BeiZis", "before alter table ");
                        sQLiteDatabase.execSQL("alter table " + string + " add column space_id");
                    }
                }
                cursor.close();
            } catch (Exception e6) {
                e6.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            }
        } finally {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }
}

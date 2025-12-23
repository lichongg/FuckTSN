package com.bytedance.sdk.component.tl.xt.j.j.j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.tl.j.m;
import com.bytedance.sdk.component.tl.xt.j.j.xt.ae;
import com.bytedance.sdk.component.tl.xt.j.j.xt.r;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends SQLiteOpenHelper {

    /* renamed from: j, reason: collision with root package name */
    final Context f26766j;
    private m xt;

    public j(Context context, m mVar) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.j(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f26766j = context;
        this.xt = mVar;
    }

    private ArrayList<String> cw(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                rawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private void j(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.m.r(this.xt.xt()));
        sQLiteDatabase.execSQL(r.xt(this.xt.j()));
        sQLiteDatabase.execSQL(ae.r(this.xt.r()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.j.xt(this.xt.up()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.m.m.xt());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        try {
            if (i6 <= i7) {
                j(sQLiteDatabase);
            } else {
                xt(sQLiteDatabase);
                j(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void xt(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> cw = cw(sQLiteDatabase);
        if (cw != null && cw.size() > 0) {
            Iterator<String> it = cw.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            j(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }
}

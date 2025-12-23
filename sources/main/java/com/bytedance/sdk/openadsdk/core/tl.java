package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    private static final Object cw = new Object();

    /* renamed from: j, reason: collision with root package name */
    private cw f30508j;
    private Context xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.tl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public class cw {
        private SQLiteDatabase xt = null;

        public void j() {
            boolean m6;
            try {
                SQLiteDatabase sQLiteDatabase = this.xt;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    return;
                }
                synchronized (tl.cw) {
                    try {
                        SQLiteDatabase sQLiteDatabase2 = this.xt;
                        if (sQLiteDatabase2 != null) {
                            if (!sQLiteDatabase2.isOpen()) {
                            }
                        }
                        tl tlVar = tl.this;
                        this.xt = tlVar.new j(tlVar.getContext()).getWritableDatabase();
                    } finally {
                    }
                }
            } finally {
                if (!m6) {
                }
            }
        }

        public cw() {
        }

        private boolean m() {
            SQLiteDatabase sQLiteDatabase = this.xt;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public SQLiteDatabase xt() {
            return this.xt;
        }

        public void cw() {
            j();
            SQLiteDatabase sQLiteDatabase = this.xt;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public int delete(String str, String str2, String[] strArr) {
            try {
                j();
                return this.xt.delete(str, str2, strArr);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                if (!m()) {
                    return 0;
                }
                throw e6;
            }
        }

        public long insert(String str, String str2, ContentValues contentValues) {
            try {
                j();
                return this.xt.insert(str, str2, contentValues);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                if (!m()) {
                    return -1L;
                }
                throw e6;
            }
        }

        public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                j();
                return this.xt.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                xt xtVar = new xt(tl.this, null);
                if (!m()) {
                    return xtVar;
                }
                throw th;
            }
        }

        public void r() {
            j();
            SQLiteDatabase sQLiteDatabase = this.xt;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public void up() {
            j();
            SQLiteDatabase sQLiteDatabase = this.xt;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                j();
                return this.xt.update(str, contentValues, str2, strArr);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                if (!m()) {
                    return 0;
                }
                throw e6;
            }
        }

        public void j(String str) throws SQLException {
            try {
                j();
                this.xt.execSQL(str);
            } catch (Throwable th) {
                if (m()) {
                    throw th;
                }
            }
        }
    }

    private class j extends SQLiteOpenHelper {

        /* renamed from: j, reason: collision with root package name */
        final Context f30510j;

        private void j(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.openadsdk.core.kt.xt.cw.get();
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.m.r("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.r.xt("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.ae.r("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.j.xt("logstatsbatch"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.m.m.xt());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.j.xt.xt.cw());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.xt.cw());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.nativeexpress.j.cw.cw());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS meta_cache (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,uuid TEXT,create_time TEXT,meta_data TEXT,save_version TEXT,expire_time TEXT,slot_type TEXT,is_using INTEGER,priority TEXT)");
        }

        private void xt(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.m.m.cw());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.m.m.r());
        }

        public j(Context context) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.j(context), "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 12);
            this.f30510j = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                j(sQLiteDatabase, this.f30510j);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.r("DBHelper", th.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            if (i6 > i7) {
                j(sQLiteDatabase);
                j(sQLiteDatabase, tl.this.xt);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            if (i6 > i7) {
                try {
                    j(sQLiteDatabase);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.r("DBHelper", th.getMessage());
                    return;
                }
            }
            j(sQLiteDatabase, tl.this.xt);
            switch (i6) {
                case 1:
                    j(sQLiteDatabase, i6, i7);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    j(sQLiteDatabase, i6, i7);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.ae.r("logstats"));
                    j(sQLiteDatabase, i6, i7);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.j.xt.xt.cw());
                    j(sQLiteDatabase, i6, i7);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.j.xt("logstatsbatch"));
                    j(sQLiteDatabase, i6, i7);
                    break;
                case 6:
                case 8:
                case 9:
                    j(sQLiteDatabase, i6, i7);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.xt.cw());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    j(sQLiteDatabase, i6, i7);
                    break;
                case 10:
                case 11:
                    xt(sQLiteDatabase, i6, i7);
                    break;
            }
        }

        private ArrayList<String> xt(SQLiteDatabase sQLiteDatabase) {
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

        private void j(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.m.up("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.r.cw("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.ae.up("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.tl.xt.j.j.xt.j.cw("logstatsbatch"));
            xt(sQLiteDatabase, i6, i7);
        }

        private void j(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> xt = xt(sQLiteDatabase);
            if (xt == null || xt.size() <= 0) {
                return;
            }
            Iterator<String> it = xt.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }

    private class xt extends AbstractCursor {
        private xt() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i6) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i6) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i6) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i6) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i6) {
            return true;
        }

        /* synthetic */ xt(tl tlVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i6) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i6) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.xt;
        return context == null ? v.getContext() : context;
    }

    public cw j() {
        return this.f30508j;
    }

    tl(Context context) {
        Context origApplicationContext;
        try {
            if (context == null) {
                origApplicationContext = v.getContext();
            } else {
                origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            this.xt = origApplicationContext;
            if (this.f30508j == null) {
                this.f30508j = new cw();
            }
        } catch (Throwable unused) {
        }
    }
}

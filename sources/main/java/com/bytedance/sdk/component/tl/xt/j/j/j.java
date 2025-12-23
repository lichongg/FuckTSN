package com.bytedance.sdk.component.tl.xt.j.j;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class j {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile j cw;

    /* renamed from: j, reason: collision with root package name */
    private xt f26765j;
    private Context xt;

    /* renamed from: com.bytedance.sdk.component.tl.xt.j.j.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bytedance.sdk.component.tl.xt.j.j.j$j, reason: collision with other inner class name */
    private class C0418j extends AbstractCursor {
        private C0418j() {
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

        /* synthetic */ C0418j(j jVar, AnonymousClass1 anonymousClass1) {
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

    public class xt {
        private SQLiteDatabase j(up upVar) {
            boolean xt;
            try {
                SQLiteDatabase j6 = upVar.xt().j(upVar.getContext());
                if (j6 == null || !j6.isOpen()) {
                    return null;
                }
                j6.setLockingEnabled(false);
                return j6;
            } finally {
                if (!xt) {
                }
            }
        }

        public int delete(up upVar, String str, String str2, String[] strArr) {
            try {
                SQLiteDatabase j6 = j(upVar);
                if (j6 != null) {
                    return j6.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e6) {
                vl.j(e6);
                if (xt(upVar)) {
                    throw e6;
                }
                return 0;
            }
        }

        public long insert(up upVar, String str, String str2, ContentValues contentValues) {
            try {
                SQLiteDatabase j6 = j(upVar);
                if (j6 != null) {
                    return j6.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e6) {
                vl.j(e6);
                if (xt(upVar)) {
                    throw e6;
                }
                return -1L;
            }
        }

        public Cursor query(up upVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            AnonymousClass1 anonymousClass1 = null;
            try {
                SQLiteDatabase j6 = j(upVar);
                if (j6 != null) {
                    return j6.query(str, strArr, str2, strArr2, str3, str4, str5);
                }
                return null;
            } catch (Throwable th) {
                vl.j(th);
                C0418j c0418j = new C0418j(j.this, anonymousClass1);
                if (xt(upVar)) {
                    throw th;
                }
                return c0418j;
            }
        }

        public int update(up upVar, String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                SQLiteDatabase j6 = j(upVar);
                if (j6 != null) {
                    return j6.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e6) {
                vl.j(e6);
                if (xt(upVar)) {
                    throw e6;
                }
                return 0;
            }
        }

        public xt() {
        }

        private boolean xt(up upVar) {
            SQLiteDatabase j6 = j(upVar);
            if (j6 != null && j6.inTransaction()) {
                return true;
            }
            return false;
        }

        public synchronized void insert(up upVar, String str, String str2, List<com.bytedance.sdk.component.tl.j.xt> list) {
            JSONObject ae;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = j(upVar);
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i6 = 0; i6 < list.size(); i6++) {
                            com.bytedance.sdk.component.tl.j.xt xtVar = list.get(i6);
                            if (xtVar != null && (ae = xtVar.ae()) != null) {
                                contentValues.put("id", xtVar.cw());
                                String xt = upVar.r().xt(ae.toString());
                                if (!TextUtils.isEmpty(xt)) {
                                    contentValues.put("value", xt);
                                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("retry", (Integer) 0);
                                    contentValues.put("encrypt", (Integer) 1);
                                    sQLiteDatabase.insert(str, str2, contentValues);
                                }
                                contentValues.clear();
                            }
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        com.bytedance.sdk.component.tl.xt.cw.cw.j("DBHelper", str + " insert list size=" + list.size(), upVar);
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e6) {
                    com.bytedance.sdk.component.tl.xt.cw.cw.j("DBHelper", str + " insert list error=" + list.size(), upVar);
                    vl.j(e6);
                    if (xt(upVar)) {
                        throw e6;
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                throw th;
            }
        }

        public void j(up upVar, String str) throws SQLException {
            boolean xt;
            try {
                SQLiteDatabase j6 = j(upVar);
                if (j6 != null) {
                    j6.execSQL(str);
                }
            } finally {
                if (!xt) {
                }
            }
        }
    }

    public static j j(Context context) {
        if (cw == null) {
            synchronized (j.class) {
                try {
                    if (cw == null) {
                        cw = new j(context);
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    private Context getContext() {
        return this.xt;
    }

    private j(Context context) {
        try {
            this.xt = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.f26765j == null) {
                this.f26765j = new xt();
            }
        } catch (Throwable unused) {
        }
    }

    public xt j() {
        return this.f26765j;
    }
}

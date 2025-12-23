package com.umeng.socialize.net.dplus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.socialize.utils.ContextUtil;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DBManager {

    /* renamed from: a, reason: collision with root package name */
    private static DBManager f42474a;

    /* renamed from: b, reason: collision with root package name */
    private static StandardDBHelper f42475b;

    public synchronized void closeDatabase() {
        f42475b.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void delete(java.util.ArrayList<java.lang.Integer> r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.db.DBManager.f42475b     // Catch: java.lang.Throwable -> L3a
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L3a
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L3a
            r1 = 0
        Lc:
            int r2 = r5.size()     // Catch: java.lang.Throwable -> L3a
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r2.<init>()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "delete from "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3a
            r2.append(r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = " where Id='"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r3 = r5.get(r1)     // Catch: java.lang.Throwable -> L3a
            r2.append(r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "' "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3a
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L3a
            int r1 = r1 + 1
            goto Lc
        L3a:
            goto L43
        L3c:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3a
        L3f:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L46
            goto L46
        L43:
            if (r0 == 0) goto L46
            goto L3f
        L46:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.delete(java.util.ArrayList, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void deleteTable(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.db.DBManager.f42475b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r1.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "DELETE FROM "
            r1.append(r2)     // Catch: java.lang.Throwable -> L2b
            r1.append(r4)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = ";"
            r1.append(r4)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L2b
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L2b
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2b
        L27:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            if (r0 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.deleteTable(java.lang.String):void");
    }

    public synchronized void insertAuth(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f42475b.getWritableDatabase();
            } catch (Throwable unused) {
            }
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("auth", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public synchronized void insertDau(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f42475b.getWritableDatabase();
            } catch (Throwable unused) {
            }
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("dau", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public synchronized void insertS_E(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f42475b.getWritableDatabase();
            } catch (Throwable unused) {
            }
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("s_e", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public synchronized void insertStats(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f42475b.getWritableDatabase();
            } catch (Throwable unused) {
            }
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("stats", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public synchronized void insertUserInfo(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f42475b.getWritableDatabase();
            } catch (Throwable unused) {
            }
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("userinfo", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0077, code lost:
    
        if (r3 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONArray select(java.lang.String r12, java.util.ArrayList<java.lang.Integer> r13, double r14, boolean r16) throws org.json.JSONException {
        /*
            r11 = this;
            monitor-enter(r11)
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L8a
            r0.<init>()     // Catch: java.lang.Throwable -> L8a
            r1 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r2 = com.umeng.socialize.net.dplus.db.DBManager.f42475b     // Catch: java.lang.Throwable -> L6b org.json.JSONException -> L6e
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L6b org.json.JSONException -> L6e
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            r9 = 0
            r10 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r12
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
        L1b:
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            if (r12 == 0) goto L61
            r12 = 0
            int r12 = r1.getInt(r12)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            if (r16 == 0) goto L47
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            byte[] r4 = r4.getBytes()     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            int r4 = r4.length     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            byte[] r5 = r2.getBytes()     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            int r5 = r5.length     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            int r4 = r4 + r5
            double r4 = (double) r4     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            int r6 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r6 <= 0) goto L47
            goto L61
        L42:
            goto L72
        L44:
            r0 = move-exception
            r12 = r0
            goto L7c
        L47:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            r0.put(r4)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            boolean r2 = r13.contains(r2)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            if (r2 != 0) goto L1b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            r13.add(r12)     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            goto L1b
        L61:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L42 org.json.JSONException -> L44
            r1.close()     // Catch: java.lang.Throwable -> L7a
        L67:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L7a
            goto L7a
        L6b:
            r3 = r1
            goto L72
        L6e:
            r0 = move-exception
            r12 = r0
            r3 = r1
            goto L7c
        L72:
            if (r1 == 0) goto L77
            r1.close()     // Catch: java.lang.Throwable -> L7a
        L77:
            if (r3 == 0) goto L7a
            goto L67
        L7a:
            monitor-exit(r11)
            return r0
        L7c:
            throw r12     // Catch: java.lang.Throwable -> L7d
        L7d:
            r0 = move-exception
            r12 = r0
            if (r1 == 0) goto L84
            r1.close()     // Catch: java.lang.Throwable -> L89
        L84:
            if (r3 == 0) goto L89
            r3.endTransaction()     // Catch: java.lang.Throwable -> L89
        L89:
            throw r12     // Catch: java.lang.Throwable -> L8a
        L8a:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L8a
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.select(java.lang.String, java.util.ArrayList, double, boolean):org.json.JSONArray");
    }

    public static synchronized DBManager get(Context context) {
        DBManager dBManager;
        synchronized (DBManager.class) {
            try {
                if (f42474a == null) {
                    f42474a = new DBManager();
                }
                dBManager = f42474a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dBManager;
    }

    private DBManager() {
        f42475b = new StandardDBHelper(ContextUtil.getContext());
    }
}

package cn.jpush.android.v;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.helper.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.bm;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f3921b;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f3920a = {bm.f41039d, "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};

    /* renamed from: c, reason: collision with root package name */
    private static final Object f3922c = new Object();

    private b(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public int a(long j6) {
        if (!a(true)) {
            return 0;
        }
        try {
            return getWritableDatabase().delete("t_localnotification", "ln_id=" + j6, null);
        } catch (Exception unused) {
            return 0;
        } finally {
            b(true);
        }
    }

    public long b(long j6, int i6, int i7, int i8, String str, long j7, long j8) {
        if (!a(true)) {
            return 0L;
        }
        try {
            String str2 = "ln_id=" + j6;
            ContentValues contentValues = new ContentValues();
            contentValues.put("ln_id", Long.valueOf(j6));
            contentValues.put("ln_count", Integer.valueOf(i6));
            contentValues.put("ln_remove", Integer.valueOf(i7));
            contentValues.put("ln_type", Integer.valueOf(i8));
            contentValues.put("ln_extra", cn.jpush.android.ad.c.c(str));
            contentValues.put("ln_trigger_time", Long.valueOf(j7));
            contentValues.put("ln_add_time", Long.valueOf(j8));
            return getWritableDatabase().update("t_localnotification", contentValues, str2, null);
        } catch (Exception unused) {
            return 0L;
        } finally {
            b(true);
        }
    }

    public long a(long j6, int i6, int i7, int i8, String str, long j7, long j8) {
        if (!a(true)) {
            return 0L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ln_id", Long.valueOf(j6));
            contentValues.put("ln_count", Integer.valueOf(i6));
            contentValues.put("ln_remove", Integer.valueOf(i7));
            contentValues.put("ln_type", Integer.valueOf(i8));
            contentValues.put("ln_extra", cn.jpush.android.ad.c.c(str));
            contentValues.put("ln_trigger_time", Long.valueOf(j7));
            contentValues.put("ln_add_time", Long.valueOf(j8));
            return getWritableDatabase().insert("t_localnotification", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        } finally {
            b(true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception unused) {
            Logger.v("LocalNotificationDb", "表已经存在");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }

    public Cursor a(int i6, long j6) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f3920a, "ln_count=" + i6 + " and ln_trigger_time<" + j6, null, null, null, null, null);
        } catch (Exception e6) {
            Logger.w("LocalNotificationDb", "getOutDatas exception:" + e6.getMessage());
            return null;
        }
    }

    public Cursor a(long j6, long j7) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f3920a, "ln_count>0 and ln_trigger_time<" + (j7 + j6) + " and ln_trigger_time>" + j6, null, null, null, null, null);
        } catch (Exception e6) {
            Logger.w("LocalNotificationDb", "getRtcDatas exception:" + e6.getMessage());
            return null;
        }
    }

    public static b a(Context context) {
        if (f3921b == null) {
            synchronized (f3922c) {
                try {
                    if (f3921b == null) {
                        f3921b = new b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } finally {
                }
            }
        }
        return f3921b;
    }

    public c a(long j6, int i6) {
        if (!a(false)) {
            throw new Exception("open database failed");
        }
        Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query(true, "t_localnotification", f3920a, "ln_id=" + j6 + " and ln_type" + ContainerUtils.KEY_VALUE_DELIMITER + i6, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            c a6 = a(cursor);
            if (cursor != null) {
                cursor.close();
            }
            b(false);
            return a6;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            b(false);
            throw th;
        }
    }

    public static c a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            Logger.d("LocalNotificationDb", "cursor is null");
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(cursor.getLong(1));
            cVar.a(cursor.getInt(2));
            cVar.b(cursor.getInt(3));
            cVar.c(cursor.getInt(4));
            cVar.a(cn.jpush.android.ad.c.c(cursor.getString(5)));
            cVar.c(cursor.getLong(6));
            cVar.b(cursor.getLong(7));
            Logger.i("LocalNotificationDb", cVar.toString());
            return cVar;
        } catch (Exception e6) {
            e6.getStackTrace();
            Logger.w("LocalNotificationDb", "initLocalNotificationDBData exception:" + e6.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] a() {
        /*
            r13 = this;
            java.lang.String r4 = "1"
            r10 = 0
            boolean r0 = r13.a(r10)
            r11 = 0
            if (r0 == 0) goto L95
            r12 = 1
            java.lang.String r0 = "ln_id"
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            android.database.sqlite.SQLiteDatabase r0 = r13.getReadableDatabase()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r2 = "t_localnotification"
            r8 = 0
            r9 = 0
            r1 = 1
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r1 == 0) goto L4b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            if (r0 <= 0) goto L4b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            int[] r11 = new int[r0]     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            r0 = 0
        L33:
            int r2 = r1.getInt(r10)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            r11[r0] = r2     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            int r0 = r0 + 1
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            if (r2 != 0) goto L33
            goto L4b
        L42:
            r0 = move-exception
            r11 = r1
        L44:
            r1 = 0
            goto L79
        L46:
            r0 = r11
            r11 = r1
        L49:
            r1 = 0
            goto L87
        L4b:
            boolean r0 = r13.a(r12)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            if (r0 == 0) goto L65
            java.lang.String r0 = "delete from t_localnotification"
            android.database.sqlite.SQLiteDatabase r2 = r13.getWritableDatabase()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L60
            r2.execSQL(r0)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L60
            r0 = 1
            goto L66
        L5c:
            r0 = move-exception
            r11 = r1
            r1 = 1
            goto L79
        L60:
            r0 = r11
            r11 = r1
            r1 = 1
            goto L87
        L65:
            r0 = 0
        L66:
            if (r1 == 0) goto L6b
            r1.close()
        L6b:
            r13.b(r10)
            if (r0 == 0) goto L73
            r13.b(r12)
        L73:
            return r11
        L74:
            r0 = move-exception
            goto L44
        L76:
            r0 = r11
            goto L49
        L79:
            if (r11 == 0) goto L7e
            r11.close()
        L7e:
            r13.b(r10)
            if (r1 == 0) goto L86
            r13.b(r12)
        L86:
            throw r0
        L87:
            if (r11 == 0) goto L8c
            r11.close()
        L8c:
            r13.b(r10)
            if (r1 == 0) goto L94
            r13.b(r12)
        L94:
            return r0
        L95:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.v.b.a():int[]");
    }
}

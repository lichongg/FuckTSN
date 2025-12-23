package com.baidu.liantian.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static a f10331d;

    /* renamed from: a, reason: collision with root package name */
    int f10332a = 5;

    /* renamed from: b, reason: collision with root package name */
    String f10333b = "create table tbchliantian(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f10334c;

    /* renamed from: e, reason: collision with root package name */
    private C0097a f10335e;

    /* renamed from: f, reason: collision with root package name */
    private Context f10336f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.liantian.a.a$a, reason: collision with other inner class name */
    private class C0097a extends SQLiteOpenHelper {
        public C0097a(Context context) {
            super(context, "bliantianh.db", (SQLiteDatabase.CursorFactory) null, a.this.f10332a);
            b.a();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.f10333b);
            } catch (Throwable unused) {
                e.a();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            try {
                b.a();
                if (i6 < 3 && i7 >= 3) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE tbchliantian ADD COLUMN pr INTEGER  DEFAULT -1");
                            sQLiteDatabase.setTransactionSuccessful();
                        } finally {
                        }
                    } catch (Throwable unused) {
                        e.a();
                    }
                }
                if (i6 < 5 && i7 >= 5) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE tbchliantian ADD COLUMN pdld INTEGER  DEFAULT -1");
                            sQLiteDatabase.setTransactionSuccessful();
                        } finally {
                        }
                    } catch (Throwable unused2) {
                        e.a();
                    }
                }
                if (i6 < 4 && i7 >= 4) {
                    try {
                        sQLiteDatabase.execSQL("drop table if exists pgnliantian");
                    } catch (Throwable unused3) {
                        e.a();
                    }
                }
            } catch (Throwable unused4) {
                e.a();
            }
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                Objects.toString(f10331d);
                b.a();
                if (f10331d == null) {
                    f10331d = new a(context);
                }
                aVar = f10331d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final Map<Integer, String> b() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            try {
                cursor = this.f10334c.query("tbchliantian", null, "n=1", null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            int i6 = cursor.getInt(cursor.getColumnIndex("k"));
                            String string = cursor.getString(cursor.getColumnIndex("v"));
                            hashMap.put(Integer.valueOf(i6), "'" + string + "'");
                        } catch (Throwable unused) {
                            try {
                                e.a();
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                return hashMap;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        e.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                    return hashMap;
                }
            } catch (Throwable unused3) {
                cursor = null;
            }
        } catch (Throwable unused4) {
            e.a();
        }
        return hashMap;
    }

    public final Map<Integer, String> c() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            try {
                cursor = this.f10334c.query("tbchliantian", null, "n=1", null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            int i6 = cursor.getInt(cursor.getColumnIndex("k"));
                            hashMap.put(Integer.valueOf(i6), cursor.getString(cursor.getColumnIndex("p")));
                        } catch (Throwable unused) {
                            try {
                                e.a();
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                return hashMap;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        e.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                    return hashMap;
                }
            } catch (Throwable unused3) {
                cursor = null;
            }
        } catch (Throwable unused4) {
            e.a();
        }
        return hashMap;
    }

    public final void d() {
        List<Integer> list;
        try {
            ArrayList<ApkInfo> arrayList = new ArrayList();
            for (ApkInfo apkInfo : a()) {
                if (!e.c(apkInfo.pkgPath) && (list = g.f10438b) != null && !list.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            g a6 = g.a();
            for (ApkInfo apkInfo2 : arrayList) {
                if (a6 != null) {
                    a6.b(apkInfo2.packageName);
                }
                this.f10334c.delete("tbchliantian", "k=" + apkInfo2.key, null);
                b.a();
                e.d(this.f10336f.getFilesDir().getCanonicalPath() + "/.liantian_" + apkInfo2.key);
                Context context = this.f10336f;
                if (context != null) {
                    e.d(context.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
            e.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if (r11.isClosed() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        if (r11.isClosed() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f10334c     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "tbchliantian"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L45
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L45
            r5.append(r11)     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L45
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L45
            if (r11 == 0) goto L35
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L35
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L46
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L46
            r2 = 1
            if (r0 != r2) goto L35
            r1 = 1
        L35:
            if (r11 == 0) goto L52
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
        L3d:
            r11.close()     // Catch: java.lang.Throwable -> L41
            goto L52
        L41:
            com.baidu.liantian.b.e.a()
            goto L52
        L45:
            r11 = 0
        L46:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L53
            if (r11 == 0) goto L52
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
            goto L3d
        L52:
            return r1
        L53:
            r0 = move-exception
            if (r11 == 0) goto L63
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L63
            r11.close()     // Catch: java.lang.Throwable -> L60
            goto L63
        L60:
            com.baidu.liantian.b.e.a()
        L63:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.e(int):boolean");
    }

    public final void f(int i6) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) (-1));
            this.f10334c.update("tbchliantian", contentValues, "k=" + i6, null);
        } catch (Throwable unused) {
            e.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r11.isClosed() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (r11.isClosed() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int g(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "pdld"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f10334c     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "tbchliantian"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L41
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L41
            r5.append(r11)     // Catch: java.lang.Throwable -> L41
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L41
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L41
            if (r11 == 0) goto L31
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L31
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L42
            int r1 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L42
        L31:
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3d
            if (r0 != 0) goto L4e
        L39:
            r11.close()     // Catch: java.lang.Throwable -> L3d
            goto L4e
        L3d:
            com.baidu.liantian.b.e.a()
            goto L4e
        L41:
            r11 = 0
        L42:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L4f
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3d
            if (r0 != 0) goto L4e
            goto L39
        L4e:
            return r1
        L4f:
            r0 = move-exception
            if (r11 == 0) goto L5f
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L5c
            if (r1 != 0) goto L5f
            r11.close()     // Catch: java.lang.Throwable -> L5c
            goto L5f
        L5c:
            com.baidu.liantian.b.e.a()
        L5f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.g(int):int");
    }

    private a(Context context) {
        b.a();
        this.f10336f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        C0097a c0097a = new C0097a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f10335e = c0097a;
        try {
            this.f10334c = c0097a.getWritableDatabase();
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final void h(int i6) {
        b.a();
        if (i6 <= 0) {
            return;
        }
        try {
            this.f10334c.delete("tbchliantian", "k=" + i6, null);
            b.a();
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final long a(ApkInfo apkInfo) {
        if (apkInfo == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(apkInfo.initStatus));
        contentValues.put("p", apkInfo.packageName);
        contentValues.put("a", apkInfo.pkgPath);
        contentValues.put(t.f36143d, apkInfo.libPath);
        contentValues.put("v", apkInfo.versionName);
        contentValues.put("apk", apkInfo.dexPath);
        contentValues.put(IAdInterListener.AdReqParam.AP, Integer.valueOf(apkInfo.apkParseSuc));
        contentValues.put("cl", apkInfo.className);
        contentValues.put("st", Long.valueOf(apkInfo.startTime));
        contentValues.put(d.ac, Integer.valueOf(apkInfo.duration));
        contentValues.put("m5", apkInfo.apkMD5);
        contentValues.put("th", Integer.valueOf(apkInfo.applicationTheme));
        contentValues.put("pr", Integer.valueOf(apkInfo.priority));
        ActivityInfo[] activityInfoArr = apkInfo.activities;
        if (activityInfoArr != null) {
            contentValues.put("ac", new com.baidu.liantian.core.a(activityInfoArr).a());
        }
        try {
            if (b(apkInfo.key)) {
                SQLiteDatabase sQLiteDatabase = this.f10334c;
                return sQLiteDatabase.update("tbchliantian", contentValues, "k=" + apkInfo.key, null);
            }
            contentValues.put("k", Integer.valueOf(apkInfo.key));
            return this.f10334c.insert("tbchliantian", null, contentValues);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r10.isClosed() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r10.isClosed() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(int r10) {
        /*
            r9 = this;
            java.lang.String r1 = "tbchliantian"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r9.f10334c     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = "p"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            r3.append(r10)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3a
            if (r10 == 0) goto L2a
            int r0 = r10.getCount()     // Catch: java.lang.Throwable -> L3b
            if (r0 <= 0) goto L2a
            r8 = 1
        L2a:
            if (r10 == 0) goto L47
            boolean r0 = r10.isClosed()     // Catch: java.lang.Throwable -> L36
            if (r0 != 0) goto L47
        L32:
            r10.close()     // Catch: java.lang.Throwable -> L36
            goto L47
        L36:
            com.baidu.liantian.b.e.a()
            goto L47
        L3a:
            r10 = 0
        L3b:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto L47
            boolean r0 = r10.isClosed()     // Catch: java.lang.Throwable -> L36
            if (r0 != 0) goto L47
            goto L32
        L47:
            return r8
        L48:
            r0 = move-exception
            if (r10 == 0) goto L58
            boolean r1 = r10.isClosed()     // Catch: java.lang.Throwable -> L55
            if (r1 != 0) goto L58
            r10.close()     // Catch: java.lang.Throwable -> L55
            goto L58
        L55:
            com.baidu.liantian.b.e.a()
        L58:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.b(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r11.isClosed() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (r11.isClosed() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f10334c     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "tbchliantian"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L41
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L41
            r5.append(r11)     // Catch: java.lang.Throwable -> L41
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L41
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L41
            if (r11 == 0) goto L31
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L31
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L42
            int r1 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L42
        L31:
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3d
            if (r0 != 0) goto L4e
        L39:
            r11.close()     // Catch: java.lang.Throwable -> L3d
            goto L4e
        L3d:
            com.baidu.liantian.b.e.a()
            goto L4e
        L41:
            r11 = 0
        L42:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L4f
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3d
            if (r0 != 0) goto L4e
            goto L39
        L4e:
            return r1
        L4f:
            r0 = move-exception
            if (r11 == 0) goto L5f
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L5c
            if (r1 != 0) goto L5f
            r11.close()     // Catch: java.lang.Throwable -> L5c
            goto L5f
        L5c:
            com.baidu.liantian.b.e.a()
        L5f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.c(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if (r11.isClosed() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        if (r11.isClosed() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "u"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f10334c     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "tbchliantian"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L45
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L45
            r5.append(r11)     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L45
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L45
            if (r11 == 0) goto L35
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L35
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L46
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L46
            r2 = 1
            if (r0 != r2) goto L35
            r1 = 1
        L35:
            if (r11 == 0) goto L52
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
        L3d:
            r11.close()     // Catch: java.lang.Throwable -> L41
            goto L52
        L41:
            com.baidu.liantian.b.e.a()
            goto L52
        L45:
            r11 = 0
        L46:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L53
            if (r11 == 0) goto L52
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
            goto L3d
        L52:
            return r1
        L53:
            r0 = move-exception
            if (r11 == 0) goto L63
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L63
            r11.close()     // Catch: java.lang.Throwable -> L60
            goto L63
        L60:
            com.baidu.liantian.b.e.a()
        L63:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.d(int):boolean");
    }

    public final List<ApkInfo> a() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = this.f10334c.query("tbchliantian", null, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            ApkInfo apkInfo = new ApkInfo();
                            apkInfo.key = cursor.getInt(cursor.getColumnIndex("k"));
                            apkInfo.packageName = cursor.getString(cursor.getColumnIndex("p"));
                            apkInfo.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                            apkInfo.libPath = cursor.getString(cursor.getColumnIndex(t.f36143d));
                            apkInfo.versionName = cursor.getString(cursor.getColumnIndex("v"));
                            apkInfo.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                            apkInfo.duration = cursor.getInt(cursor.getColumnIndex(d.ac));
                            apkInfo.priority = cursor.getInt(cursor.getColumnIndex("pr"));
                            arrayList.add(apkInfo);
                        } catch (Throwable unused) {
                            try {
                                e.a();
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                return arrayList;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        e.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                    return arrayList;
                }
            } catch (Throwable unused3) {
                cursor = null;
            }
        } catch (Throwable unused4) {
            e.a();
        }
        return arrayList;
    }

    public final String[] b(String str) {
        String[] strArr;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        String[] strArr2 = null;
        try {
            Cursor query = this.f10334c.query("tbchliantian", new String[]{t.f36150k, "b", bi.aL}, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        boolean z5 = query.getInt(query.getColumnIndex(t.f36150k)) == 1;
                        String string = query.getString(query.getColumnIndex("b"));
                        String string2 = query.getString(query.getColumnIndex(bi.aL));
                        if (z5 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            strArr2 = new String[]{string, string2};
                        }
                    }
                } catch (Throwable unused) {
                    String[] strArr3 = strArr2;
                    cursor = query;
                    strArr = strArr3;
                    try {
                        e.a();
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable unused2) {
                                e.a();
                            }
                        }
                        return strArr;
                    } finally {
                    }
                }
            }
            if (query == null) {
                return strArr2;
            }
            try {
                if (query.isClosed()) {
                    return strArr2;
                }
                query.close();
                return strArr2;
            } catch (Throwable unused3) {
                e.a();
                return strArr2;
            }
        } catch (Throwable unused4) {
            strArr = null;
        }
    }

    public final void c(int i6, int i7) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pr", Integer.valueOf(i7));
            this.f10334c.update("tbchliantian", contentValues, "k=" + i6, null);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final ApkInfo c(String str) {
        ApkInfo apkInfo;
        ArrayList<com.baidu.liantian.core.b> a6;
        int size;
        Cursor cursor = null;
        r1 = null;
        ApkInfo apkInfo2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.f10334c.query("tbchliantian", null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = query.getInt(query.getColumnIndex("k"));
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex(t.f36143d));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex("apk"));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex(IAdInterListener.AdReqParam.AP));
                            apkInfo.className = query.getString(query.getColumnIndex("cl"));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex("th"));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex(d.ac));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex("m5"));
                            apkInfo.priority = query.getInt(query.getColumnIndex("pr"));
                            byte[] blob = query.getBlob(query.getColumnIndex("ac"));
                            if (blob != null && (a6 = com.baidu.liantian.core.a.a(blob)) != null && (size = a6.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i6 = 0; i6 < size; i6++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a6.get(i6).f10384a;
                                    activityInfo.name = a6.get(i6).f10393j;
                                    activityInfo.configChanges = a6.get(i6).f10391h;
                                    activityInfo.flags = a6.get(i6).f10389f;
                                    activityInfo.labelRes = a6.get(i6).f10395l;
                                    activityInfo.launchMode = a6.get(i6).f10385b;
                                    activityInfo.nonLocalizedLabel = a6.get(i6).f10396m;
                                    activityInfo.packageName = a6.get(i6).f10394k;
                                    activityInfo.permission = a6.get(i6).f10386c;
                                    activityInfo.screenOrientation = a6.get(i6).f10390g;
                                    activityInfo.softInputMode = a6.get(i6).f10392i;
                                    activityInfo.targetActivity = a6.get(i6).f10388e;
                                    activityInfo.taskAffinity = a6.get(i6).f10387d;
                                    apkInfo.activities[i6] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable unused) {
                            cursor = query;
                            try {
                                e.a();
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        e.a();
                                    }
                                }
                                return apkInfo;
                            } finally {
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    apkInfo = null;
                }
            }
            if (query == null) {
                return apkInfo2;
            }
            try {
                if (query.isClosed()) {
                    return apkInfo2;
                }
                query.close();
                return apkInfo2;
            } catch (Throwable unused4) {
                e.a();
                return apkInfo2;
            }
        } catch (Throwable unused5) {
            apkInfo = null;
        }
    }

    public final void b(int i6, int i7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i7));
        try {
            this.f10334c.update("tbchliantian", contentValues, "k=" + i6, null);
        } catch (Throwable unused) {
            e.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0193, code lost:
    
        if (r1.isClosed() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x017f, code lost:
    
        if (r1.isClosed() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0181, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.baidu.liantian.core.ApkInfo a(int r10) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.a(int):com.baidu.liantian.core.ApkInfo");
    }

    public final void a(String str) {
        b.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f10334c.delete("tbchliantian", "p=?", new String[]{str});
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final int a(int i6, int i7) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i7));
            return this.f10334c.update("tbchliantian", contentValues, "k=" + i6, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}

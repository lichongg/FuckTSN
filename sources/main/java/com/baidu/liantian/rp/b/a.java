package com.baidu.liantian.rp.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.liantian.ac.F;
import com.baidu.liantian.e;
import com.kuaishou.weapon.p0.t;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f10474a;

    /* renamed from: b, reason: collision with root package name */
    private C0098a f10475b;

    /* renamed from: c, reason: collision with root package name */
    private e f10476c;

    /* renamed from: d, reason: collision with root package name */
    private SQLiteDatabase f10477d;

    /* renamed from: e, reason: collision with root package name */
    private Context f10478e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.liantian.rp.b.a$a, reason: collision with other inner class name */
    class C0098a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            if (i6 <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
            if (i6 <= 2) {
                sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
            }
        }

        public C0098a(Context context) {
            super(context, "liantian_d.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f10474a == null) {
                    f10474a = new a(context);
                }
                aVar = f10474a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        if (r10 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.String r4 = "b=?"
            java.lang.String[] r5 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L26
            android.database.sqlite.SQLiteDatabase r1 = r9.f10477d     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = "c"
            r7 = 0
            r8 = 0
            r3 = 0
            r6 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L26
            if (r10 == 0) goto L1c
            int r1 = r10.getCount()     // Catch: java.lang.Throwable -> L27
            if (r1 <= 0) goto L1c
            r0 = 0
        L1c:
            if (r10 == 0) goto L2d
        L1e:
            r10.close()     // Catch: java.lang.Exception -> L22
            goto L2d
        L22:
            com.baidu.liantian.b.e.a()
            goto L2d
        L26:
            r10 = 0
        L27:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L2e
            if (r10 == 0) goto L2d
            goto L1e
        L2d:
            return r0
        L2e:
            r0 = move-exception
            if (r10 == 0) goto L38
            r10.close()     // Catch: java.lang.Exception -> L35
            goto L38
        L35:
            com.baidu.liantian.b.e.a()
        L38:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.b(java.lang.String):boolean");
    }

    public final int c() {
        e eVar = new e(this.f10478e);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return this.f10477d.delete(t.f36150k, "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - (eVar.f10461e.getInt("re_net_over", 7) * 86400000))});
        } catch (Exception unused) {
            com.baidu.liantian.b.e.a();
            return -1;
        }
    }

    private a(Context context) {
        this.f10478e = context;
        this.f10475b = new C0098a(context);
        this.f10476c = new e(context);
        try {
            this.f10477d = this.f10475b.getWritableDatabase();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final long a(com.baidu.liantian.rp.c.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", aVar.f10481b);
        contentValues.put("c", Integer.valueOf(aVar.f10482c));
        contentValues.put("d", Long.valueOf(aVar.f10484e));
        contentValues.put("e", Integer.valueOf(aVar.f10486g));
        contentValues.put("g", Integer.valueOf(aVar.f10485f));
        contentValues.put("f", Integer.valueOf(aVar.f10487h));
        contentValues.put("i", Integer.valueOf(aVar.f10488i));
        contentValues.put("j", aVar.f10489j);
        String str = aVar.f10483d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception unused) {
            com.baidu.liantian.b.e.a();
        }
        contentValues.put("h", str);
        try {
            return this.f10477d.insert(t.f36150k, null, contentValues);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
            return -1L;
        }
    }

    private int b(int i6) {
        try {
            return this.f10477d.delete(t.f36150k, "a=?", new String[]{String.valueOf(i6)});
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        com.baidu.liantian.b.e.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0027, code lost:
    
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (r1 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            r11 = this;
            r1 = 0
            r0 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f10477d     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L24
            java.lang.String r3 = "r"
            r9 = 0
            r10 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L24
            if (r1 == 0) goto L1a
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L24
            goto L1a
        L18:
            r0 = move-exception
            goto L2b
        L1a:
            if (r1 == 0) goto L2a
        L1c:
            r1.close()     // Catch: java.lang.Exception -> L20
            goto L2a
        L20:
            com.baidu.liantian.b.e.a()
            goto L2a
        L24:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L2a
            goto L1c
        L2a:
            return r0
        L2b:
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.lang.Exception -> L31
            goto L34
        L31:
            com.baidu.liantian.b.e.a()
        L34:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.b():int");
    }

    public final long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.f10477d.insert("c", null, contentValues);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return -1L;
        }
    }

    public final int a(List<Integer> list) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                try {
                    this.f10477d.beginTransaction();
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        b(it.next().intValue());
                    }
                    this.f10477d.setTransactionSuccessful();
                    sQLiteDatabase = this.f10477d;
                } catch (Throwable unused) {
                    com.baidu.liantian.b.e.a();
                    sQLiteDatabase = this.f10477d;
                }
                sQLiteDatabase.endTransaction();
                return -1;
            } catch (Exception unused2) {
                com.baidu.liantian.b.e.a();
                return -1;
            }
        } catch (Throwable th) {
            try {
                this.f10477d.endTransaction();
            } catch (Exception unused3) {
                com.baidu.liantian.b.e.a();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0130, code lost:
    
        if (r3 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0132, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0136, code lost:
    
        com.baidu.liantian.b.e.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013d, code lost:
    
        if (r3 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.liantian.rp.c.a> a(int r19) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.a(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c3, code lost:
    
        if (r10 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c5, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c9, code lost:
    
        com.baidu.liantian.b.e.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d0, code lost:
    
        if (r10 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.liantian.rp.c.a> a() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r4 = "i=5"
            java.lang.String r8 = "d desc"
            r10 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.f10477d     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "r"
            java.lang.String r9 = "100"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            if (r10 == 0) goto Lc3
        L1a:
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            if (r1 == 0) goto Lc3
            com.baidu.liantian.rp.c.a r1 = new com.baidu.liantian.rp.c.a     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.<init>()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "a"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10480a = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "b"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10481b = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "c"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10482c = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "d"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            long r2 = r10.getLong(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10484e = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "g"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10485f = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "e"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10486g = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "f"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10487h = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "i"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10488i = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "j"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r1.f10489j = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = "h"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            com.baidu.liantian.ac.F r3 = com.baidu.liantian.ac.F.getInstance()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            r4 = 0
            byte[] r4 = android.util.Base64.decode(r2, r4)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            java.lang.String r5 = "xVOTuxgN3lkRN2v4"
            java.lang.String r6 = "utf-8"
            byte[] r5 = r5.getBytes(r6)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            byte[] r3 = r3.ad(r4, r5)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            r4.<init>(r3)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            r2 = r4
            goto Lbc
        Lb7:
            r0 = move-exception
            goto Ld4
        Lb9:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
        Lbc:
            r1.f10483d = r2     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            r0.add(r1)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lcd
            goto L1a
        Lc3:
            if (r10 == 0) goto Ld3
        Lc5:
            r10.close()     // Catch: java.lang.Exception -> Lc9
            goto Ld3
        Lc9:
            com.baidu.liantian.b.e.a()
            goto Ld3
        Lcd:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> Lb7
            if (r10 == 0) goto Ld3
            goto Lc5
        Ld3:
            return r0
        Ld4:
            if (r10 == 0) goto Ldd
            r10.close()     // Catch: java.lang.Exception -> Lda
            goto Ldd
        Lda:
            com.baidu.liantian.b.e.a()
        Ldd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.a():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0117, code lost:
    
        if (r10 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0119, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x011d, code lost:
    
        com.baidu.liantian.b.e.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0124, code lost:
    
        if (r10 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.liantian.rp.c.a> a(boolean r12, int r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.a(boolean, int):java.util.List");
    }
}

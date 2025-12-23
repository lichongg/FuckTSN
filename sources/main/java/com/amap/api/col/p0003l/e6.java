package com.amap.api.col.p0003l;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e6 {

    /* renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends d6>, d6> f5999d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private f6 f6000a;

    /* renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f6001b;

    /* renamed from: c, reason: collision with root package name */
    private d6 f6002c;

    private static ContentValues a(Object obj, hk hkVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : m(obj.getClass(), hkVar.b())) {
            field.setAccessible(true);
            i(obj, field, contentValues);
        }
        return contentValues;
    }

    private SQLiteDatabase b() {
        try {
            if (this.f6001b == null) {
                this.f6001b = this.f6000a.getReadableDatabase();
            }
        } catch (Throwable th) {
            r5.e(th, "dbs", "grd");
        }
        return this.f6001b;
    }

    public static synchronized d6 c(Class<? extends d6> cls) throws IllegalAccessException, InstantiationException {
        d6 d6Var;
        synchronized (e6.class) {
            try {
                if (f5999d.get(cls) == null) {
                    f5999d.put(cls, cls.newInstance());
                }
                d6Var = f5999d.get(cls);
            } catch (Throwable th) {
                throw th;
            }
        }
        return d6Var;
    }

    private static <T> String e(hk hkVar) {
        if (hkVar == null) {
            return null;
        }
        return hkVar.a();
    }

    private static void i(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(hl.class);
        if (annotation == null) {
            return;
        }
        hl hlVar = (hl) annotation;
        try {
            switch (hlVar.b()) {
                case 1:
                    contentValues.put(hlVar.a(), Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(hlVar.a(), Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(hlVar.a(), Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(hlVar.a(), Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(hlVar.a(), Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(hlVar.a(), (String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(hlVar.a(), (byte[]) field.get(obj));
                    break;
            }
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
    
        if (r5 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> void k(java.lang.String r5, java.lang.Object r6) {
        /*
            r4 = this;
            com.amap.api.col.3l.d6 r0 = r4.f6002c
            monitor-enter(r0)
            if (r6 != 0) goto L9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7
            return
        L7:
            r5 = move-exception
            goto L54
        L9:
            java.lang.Class r1 = r6.getClass()     // Catch: java.lang.Throwable -> L7
            com.amap.api.col.3l.hk r1 = o(r1)     // Catch: java.lang.Throwable -> L7
            java.lang.String r2 = e(r1)     // Catch: java.lang.Throwable -> L7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L7
            if (r3 == 0) goto L1d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7
            return
        L1d:
            android.content.ContentValues r6 = a(r6, r1)     // Catch: java.lang.Throwable -> L7
            android.database.sqlite.SQLiteDatabase r1 = r4.n()     // Catch: java.lang.Throwable -> L7
            r4.f6001b = r1     // Catch: java.lang.Throwable -> L7
            if (r1 != 0) goto L2b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7
            return
        L2b:
            r3 = 0
            r1.update(r2, r6, r5, r3)     // Catch: java.lang.Throwable -> L37
            android.database.sqlite.SQLiteDatabase r5 = r4.f6001b     // Catch: java.lang.Throwable -> L7
            if (r5 == 0) goto L47
            goto L43
        L34:
            r4.f6001b = r3     // Catch: java.lang.Throwable -> L7
            goto L47
        L37:
            r5 = move-exception
            java.lang.String r6 = "dbs"
            java.lang.String r1 = "udd"
            com.amap.api.col.p0003l.r5.e(r5, r6, r1)     // Catch: java.lang.Throwable -> L49
            android.database.sqlite.SQLiteDatabase r5 = r4.f6001b     // Catch: java.lang.Throwable -> L7
            if (r5 == 0) goto L47
        L43:
            r5.close()     // Catch: java.lang.Throwable -> L7
            goto L34
        L47:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7
            return
        L49:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r6 = r4.f6001b     // Catch: java.lang.Throwable -> L7
            if (r6 == 0) goto L53
            r6.close()     // Catch: java.lang.Throwable -> L7
            r4.f6001b = r3     // Catch: java.lang.Throwable -> L7
        L53:
            throw r5     // Catch: java.lang.Throwable -> L7
        L54:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.e6.k(java.lang.String, java.lang.Object):void");
    }

    private static Field[] m(Class<?> cls, boolean z5) {
        if (cls == null) {
            return null;
        }
        return z5 ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private SQLiteDatabase n() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f6001b;
        } catch (Throwable th) {
            r5.e(th, "dbs", "gwd");
        }
        if (sQLiteDatabase != null) {
            if (sQLiteDatabase.isReadOnly()) {
            }
            return this.f6001b;
        }
        SQLiteDatabase sQLiteDatabase2 = this.f6001b;
        if (sQLiteDatabase2 != null) {
            sQLiteDatabase2.close();
        }
        this.f6001b = this.f6000a.getWritableDatabase();
        return this.f6001b;
    }

    private static <T> hk o(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(hk.class);
        if (annotation != null) {
            return (hk) annotation;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0025, code lost:
    
        if (r5 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> void q(T r5) {
        /*
            r4 = this;
            com.amap.api.col.3l.d6 r0 = r4.f6002c
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r4.n()     // Catch: java.lang.Throwable -> Ld
            r4.f6001b = r1     // Catch: java.lang.Throwable -> Ld
            if (r1 != 0) goto Lf
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            return
        Ld:
            r5 = move-exception
            goto L38
        Lf:
            r2 = 0
            f(r1, r5)     // Catch: java.lang.Throwable -> L1b
            android.database.sqlite.SQLiteDatabase r5 = r4.f6001b     // Catch: java.lang.Throwable -> Ld
            if (r5 == 0) goto L2b
            goto L27
        L18:
            r4.f6001b = r2     // Catch: java.lang.Throwable -> Ld
            goto L2b
        L1b:
            r5 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "itd"
            com.amap.api.col.p0003l.r5.e(r5, r1, r3)     // Catch: java.lang.Throwable -> L2d
            android.database.sqlite.SQLiteDatabase r5 = r4.f6001b     // Catch: java.lang.Throwable -> Ld
            if (r5 == 0) goto L2b
        L27:
            r5.close()     // Catch: java.lang.Throwable -> Ld
            goto L18
        L2b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            return
        L2d:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r4.f6001b     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto L37
            r1.close()     // Catch: java.lang.Throwable -> Ld
            r4.f6001b = r2     // Catch: java.lang.Throwable -> Ld
        L37:
            throw r5     // Catch: java.lang.Throwable -> Ld
        L38:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.e6.q(java.lang.Object):void");
    }

    private <T> List<T> s(String str, Class<T> cls) {
        ArrayList arrayList;
        hk o5;
        String e6;
        Throwable th;
        Cursor cursor;
        Throwable th2;
        String str2;
        synchronized (this.f6002c) {
            try {
                arrayList = new ArrayList();
                o5 = o(cls);
                e6 = e(o5);
                if (this.f6001b == null) {
                    this.f6001b = b();
                }
            } catch (Throwable th3) {
                throw th3;
            }
            if (this.f6001b == null || TextUtils.isEmpty(e6) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.f6001b.query(e6, null, str, null, null, null, null);
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
            try {
            } catch (Throwable th5) {
                th = th5;
                try {
                    r5.e(th, "dbs", "sld");
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th6) {
                            r5.e(th6, "dbs", "sld");
                        }
                    }
                    try {
                        SQLiteDatabase sQLiteDatabase = this.f6001b;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            this.f6001b = null;
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        str2 = "dbs";
                        r5.e(th2, str2, "sld");
                        return arrayList;
                    }
                    return arrayList;
                } finally {
                }
            }
            if (cursor == null) {
                this.f6001b.close();
                this.f6001b = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th8) {
                        r5.e(th8, "dbs", "sld");
                    }
                }
                try {
                    SQLiteDatabase sQLiteDatabase2 = this.f6001b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                        this.f6001b = null;
                    }
                } catch (Throwable th9) {
                    r5.e(th9, "dbs", "sld");
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(d(cursor, cls, o5));
            }
            try {
                cursor.close();
            } catch (Throwable th10) {
                r5.e(th10, "dbs", "sld");
            }
            try {
                SQLiteDatabase sQLiteDatabase3 = this.f6001b;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                    this.f6001b = null;
                }
            } catch (Throwable th11) {
                th2 = th11;
                str2 = "dbs";
                r5.e(th2, str2, "sld");
                return arrayList;
            }
            return arrayList;
            throw th3;
        }
    }

    public final void h(Object obj, String str) {
        synchronized (this.f6002c) {
            try {
                List p5 = p(str, obj.getClass());
                if (p5 != null && p5.size() != 0) {
                    r(str, obj);
                }
                g(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if (r4 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> void j(java.lang.String r4, java.lang.Class<T> r5) {
        /*
            r3 = this;
            com.amap.api.col.3l.d6 r0 = r3.f6002c
            monitor-enter(r0)
            com.amap.api.col.3l.hk r5 = o(r5)     // Catch: java.lang.Throwable -> L13
            java.lang.String r5 = e(r5)     // Catch: java.lang.Throwable -> L13
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L15
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return
        L13:
            r4 = move-exception
            goto L47
        L15:
            android.database.sqlite.SQLiteDatabase r1 = r3.n()     // Catch: java.lang.Throwable -> L13
            r3.f6001b = r1     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L1f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return
        L1f:
            r2 = 0
            r1.delete(r5, r4, r2)     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r4 = r3.f6001b     // Catch: java.lang.Throwable -> L13
            if (r4 == 0) goto L3a
        L27:
            r4.close()     // Catch: java.lang.Throwable -> L13
            goto L38
        L2b:
            r4 = move-exception
            java.lang.String r5 = "dbs"
            java.lang.String r1 = "dld"
            com.amap.api.col.p0003l.r5.e(r4, r5, r1)     // Catch: java.lang.Throwable -> L3c
            android.database.sqlite.SQLiteDatabase r4 = r3.f6001b     // Catch: java.lang.Throwable -> L13
            if (r4 == 0) goto L3a
            goto L27
        L38:
            r3.f6001b = r2     // Catch: java.lang.Throwable -> L13
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return
        L3c:
            r4 = move-exception
            android.database.sqlite.SQLiteDatabase r5 = r3.f6001b     // Catch: java.lang.Throwable -> L13
            if (r5 == 0) goto L46
            r5.close()     // Catch: java.lang.Throwable -> L13
            r3.f6001b = r2     // Catch: java.lang.Throwable -> L13
        L46:
            throw r4     // Catch: java.lang.Throwable -> L13
        L47:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.e6.j(java.lang.String, java.lang.Class):void");
    }

    public final <T> void l(List<T> list) {
        String str;
        synchronized (this.f6002c) {
            try {
                if (list.size() == 0) {
                    return;
                }
                SQLiteDatabase n6 = n();
                this.f6001b = n6;
                if (n6 == null) {
                    return;
                }
                try {
                    n6.beginTransaction();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        f(this.f6001b, it.next());
                    }
                    this.f6001b.setTransactionSuccessful();
                    try {
                        this.f6001b.close();
                        this.f6001b = null;
                    } catch (Throwable th) {
                        th = th;
                        str = "dbs";
                        r5.e(th, str, "ild");
                    }
                } catch (Throwable th2) {
                    try {
                        r5.e(th2, "dbs", "ild");
                        try {
                            if (this.f6001b.inTransaction()) {
                                this.f6001b.endTransaction();
                            }
                        } catch (Throwable th3) {
                            r5.e(th3, "dbs", "ild");
                        }
                        try {
                            this.f6001b.close();
                            this.f6001b = null;
                        } catch (Throwable th4) {
                            th = th4;
                            str = "dbs";
                            r5.e(th, str, "ild");
                        }
                    } finally {
                        try {
                            if (this.f6001b.inTransaction()) {
                                this.f6001b.endTransaction();
                            }
                        } catch (Throwable th5) {
                            r5.e(th5, "dbs", "ild");
                        }
                        try {
                            this.f6001b.close();
                            this.f6001b = null;
                            throw th;
                        } catch (Throwable th6) {
                            r5.e(th6, "dbs", "ild");
                        }
                    }
                }
            } catch (Throwable th7) {
                throw th7;
            }
        }
    }

    public e6(Context context, d6 d6Var) {
        try {
            this.f6000a = new f6(StubApp.getOrigApplicationContext(context.getApplicationContext()), d6Var.b(), d6Var.c(), d6Var);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f6002c = d6Var;
    }

    private static <T> T d(Cursor cursor, Class<T> cls, hk hkVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] m6 = m(cls, hkVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(null);
        for (Field field : m6) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(hl.class);
            if (annotation != null) {
                hl hlVar = (hl) annotation;
                int b6 = hlVar.b();
                int columnIndex = cursor.getColumnIndex(hlVar.a());
                switch (b6) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static <T> void f(SQLiteDatabase sQLiteDatabase, T t5) {
        hk o5 = o(t5.getClass());
        String e6 = e(o5);
        if (TextUtils.isEmpty(e6) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(e6, null, a(t5, o5));
    }

    private <T> void g(T t5) {
        q(t5);
    }

    private <T> void r(String str, Object obj) {
        k(str, obj);
    }

    public final <T> List<T> p(String str, Class<T> cls) {
        return s(str, cls);
    }
}

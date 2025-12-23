package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class t {
    private static t E = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f36140a = "k";

    /* renamed from: b, reason: collision with root package name */
    public static final String f36141b = "p";

    /* renamed from: c, reason: collision with root package name */
    public static final String f36142c = "v";

    /* renamed from: d, reason: collision with root package name */
    public static final String f36143d = "l";

    /* renamed from: e, reason: collision with root package name */
    public static final String f36144e = "i";

    /* renamed from: f, reason: collision with root package name */
    public static final String f36145f = "a";

    /* renamed from: g, reason: collision with root package name */
    public static final String f36146g = "s";

    /* renamed from: h, reason: collision with root package name */
    public static final String f36147h = "n";

    /* renamed from: i, reason: collision with root package name */
    public static final String f36148i = "u";

    /* renamed from: j, reason: collision with root package name */
    public static final String f36149j = "c";

    /* renamed from: k, reason: collision with root package name */
    public static final String f36150k = "r";

    /* renamed from: l, reason: collision with root package name */
    public static final String f36151l = "b";

    /* renamed from: m, reason: collision with root package name */
    public static final String f36152m = "m";

    /* renamed from: n, reason: collision with root package name */
    public static final String f36153n = "el";

    /* renamed from: o, reason: collision with root package name */
    public static final String f36154o = "ail";

    /* renamed from: p, reason: collision with root package name */
    public static final String f36155p = "aps";

    /* renamed from: q, reason: collision with root package name */
    public static final String f36156q = "dp";

    /* renamed from: r, reason: collision with root package name */
    public static final String f36157r = "pcn";

    /* renamed from: s, reason: collision with root package name */
    public static final String f36158s = "pst";

    /* renamed from: t, reason: collision with root package name */
    public static final String f36159t = "d";

    /* renamed from: u, reason: collision with root package name */
    public static final String f36160u = "at";

    /* renamed from: v, reason: collision with root package name */
    public static final String f36161v = "dm";

    /* renamed from: w, reason: collision with root package name */
    public static final String f36162w = "rm";

    /* renamed from: x, reason: collision with root package name */
    public static final String f36163x = "pc";

    /* renamed from: y, reason: collision with root package name */
    public static final String f36164y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;

    /* renamed from: z, reason: collision with root package name */
    private int f36165z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    class a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            if (i6 >= 3 || i7 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable unused2) {
            }
        }

        public a(Context context) {
            super(context, bi.f35783p, (SQLiteDatabase.CursorFactory) null, t.this.f36165z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }
    }

    public int c(int i6) {
        Cursor cursor;
        int i7 = 0;
        try {
            cursor = this.C.query(bi.f35784q, new String[]{"n"}, "k=" + i6, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        i7 = cursor.getInt(cursor.getColumnIndex("n"));
                    }
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return 0;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return i7;
        } catch (Throwable unused2) {
            cursor = null;
        }
    }

    public boolean d(int i6) {
        Cursor cursor;
        boolean z5 = false;
        try {
            cursor = this.C.query(bi.f35784q, new String[]{"s"}, "k=" + i6, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                            z5 = true;
                        }
                    }
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return false;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return z5;
        } catch (Throwable unused2) {
            cursor = null;
        }
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            try {
                if (E == null) {
                    E = new t(context);
                }
                tVar = E;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public boolean b(int i6) {
        Cursor cursor;
        boolean z5 = false;
        try {
            cursor = this.C.query(bi.f35784q, new String[]{"p"}, "k=" + i6, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        z5 = true;
                    }
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return false;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return z5;
        } catch (Throwable unused2) {
            cursor = null;
        }
    }

    private t(Context context) {
        this.D = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.B = new a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    public long a(s sVar) {
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.f36116b));
        contentValues.put(f36155p, Integer.valueOf(sVar.f36130p));
        contentValues.put("p", sVar.f36117c);
        contentValues.put("a", sVar.f36119e);
        contentValues.put(f36143d, sVar.f36122h);
        contentValues.put("v", sVar.f36118d);
        contentValues.put(f36156q, sVar.f36128n);
        contentValues.put("a", sVar.f36119e);
        contentValues.put(f36157r, sVar.f36129o);
        contentValues.put(f36158s, Long.valueOf(sVar.f36133s));
        contentValues.put(f36162w, Integer.valueOf(sVar.f36137w));
        contentValues.put("at", Integer.valueOf(sVar.f36131q));
        contentValues.put(f36163x, Integer.valueOf(sVar.f36138x));
        contentValues.put(f36164y, Integer.valueOf(sVar.f36139y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.f36124j)) {
            contentValues.put(f36161v, sVar.f36124j);
        }
        try {
            if (b(sVar.f36115a)) {
                SQLiteDatabase sQLiteDatabase = this.C;
                return sQLiteDatabase.update(bi.f35784q, contentValues, "k=" + sVar.f36115a, null);
            }
            contentValues.put("k", Integer.valueOf(sVar.f36115a));
            return this.C.insert(bi.f35784q, null, contentValues);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dn.a(sVar.f36119e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r a6 = r.a();
            for (s sVar2 : arrayList) {
                if (a6 != null) {
                    a6.a(sVar2.f36119e);
                }
                this.C.delete(bi.f35784q, "k=" + sVar2.f36115a, null);
                List<Integer> list = r.f36107b;
                if (list != null && !list.contains(Integer.valueOf(sVar2.f36115a))) {
                    dn.c(this.D.getFilesDir().getCanonicalPath() + bi.f35777j + sVar2.f36115a);
                }
                if (a6.b() != null && a6.b().get(sVar2.f36117c) != null) {
                    dn.c(this.D.getFileStreamPath(sVar2.f36117c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bi.f35784q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.C.update(bi.f35784q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i6, int i7) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f36163x, Integer.valueOf(i7));
            this.C.update(bi.f35784q, contentValues, "k=" + i6, null);
        } catch (Throwable unused) {
        }
    }

    public List<s> a() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.C.query(bi.f35784q, null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        s sVar = new s();
                        sVar.f36115a = cursor.getInt(cursor.getColumnIndex("k"));
                        sVar.f36117c = cursor.getString(cursor.getColumnIndex("p"));
                        sVar.f36119e = cursor.getString(cursor.getColumnIndex("a"));
                        sVar.f36122h = cursor.getString(cursor.getColumnIndex(f36143d));
                        sVar.f36118d = cursor.getString(cursor.getColumnIndex("v"));
                        sVar.f36133s = cursor.getLong(cursor.getColumnIndex(f36158s));
                        sVar.f36134t = cursor.getInt(cursor.getColumnIndex("d"));
                        sVar.f36137w = cursor.getInt(cursor.getColumnIndex(f36162w));
                        sVar.f36138x = cursor.getInt(cursor.getColumnIndex(f36163x));
                        boolean z5 = true;
                        if (cursor.getInt(cursor.getColumnIndex(f36164y)) != 1) {
                            z5 = false;
                        }
                        sVar.f36139y = z5;
                        arrayList.add(sVar);
                    } catch (Throwable unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                return arrayList;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        return arrayList;
    }

    public void b(int i6, int i7) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i7));
            this.C.update(bi.f35784q, contentValues, "k=" + i6, null);
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        s sVar;
        Cursor cursor = null;
        r1 = null;
        s sVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.C.query(bi.f35784q, null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f36115a = query.getInt(query.getColumnIndex("k"));
                            sVar.f36116b = query.getInt(query.getColumnIndex("n"));
                            sVar.f36117c = query.getString(query.getColumnIndex("p"));
                            sVar.f36119e = query.getString(query.getColumnIndex("a"));
                            sVar.f36122h = query.getString(query.getColumnIndex(f36143d));
                            sVar.f36118d = query.getString(query.getColumnIndex("v"));
                            sVar.f36128n = query.getString(query.getColumnIndex(f36156q));
                            sVar.f36130p = query.getInt(query.getColumnIndex(f36155p));
                            sVar.f36129o = query.getString(query.getColumnIndex(f36157r));
                            sVar.f36131q = query.getInt(query.getColumnIndex("at"));
                            sVar.f36133s = query.getLong(query.getColumnIndex(f36158s));
                            sVar.f36134t = query.getInt(query.getColumnIndex("d"));
                            sVar.f36137w = query.getInt(query.getColumnIndex(f36162w));
                            sVar.f36124j = query.getString(query.getColumnIndex(f36161v));
                            sVar.f36138x = query.getInt(query.getColumnIndex(f36163x));
                            boolean z5 = true;
                            if (query.getInt(query.getColumnIndex(f36164y)) != 1) {
                                z5 = false;
                            }
                            sVar.f36139y = z5;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public s a(int i6) {
        s sVar;
        Cursor cursor = null;
        r0 = null;
        s sVar2 = null;
        try {
            Cursor query = this.C.query(bi.f35784q, null, "k=" + i6, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f36115a = i6;
                            sVar.f36116b = query.getInt(query.getColumnIndex("n"));
                            sVar.f36117c = query.getString(query.getColumnIndex("p"));
                            sVar.f36119e = query.getString(query.getColumnIndex("a"));
                            sVar.f36122h = query.getString(query.getColumnIndex(f36143d));
                            sVar.f36118d = query.getString(query.getColumnIndex("v"));
                            sVar.f36128n = query.getString(query.getColumnIndex(f36156q));
                            sVar.f36130p = query.getInt(query.getColumnIndex(f36155p));
                            sVar.f36129o = query.getString(query.getColumnIndex(f36157r));
                            sVar.f36131q = query.getInt(query.getColumnIndex("at"));
                            sVar.f36133s = query.getLong(query.getColumnIndex(f36158s));
                            sVar.f36134t = query.getInt(query.getColumnIndex("d"));
                            sVar.f36137w = query.getInt(query.getColumnIndex(f36162w));
                            sVar.f36124j = query.getString(query.getColumnIndex(f36161v));
                            sVar.f36138x = query.getInt(query.getColumnIndex(f36163x));
                            boolean z5 = true;
                            if (query.getInt(query.getColumnIndex(f36164y)) != 1) {
                                z5 = false;
                            }
                            sVar.f36139y = z5;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bi.f35784q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public int a(int i6, int i7) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i7));
            return this.C.update(bi.f35784q, contentValues, "k=" + i6, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}

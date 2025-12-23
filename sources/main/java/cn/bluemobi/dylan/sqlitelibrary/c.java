package cn.bluemobi.dylan.sqlitelibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.acse.ottn.l3;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: g, reason: collision with root package name */
    private static volatile c f1390g;

    /* renamed from: a, reason: collision with root package name */
    String[] f1391a = {"java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long", "java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Character", "java.lang.String", "java.util.Date", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "double", "long", "short", "byte", "boolean", "char", "float"};

    /* renamed from: b, reason: collision with root package name */
    private final String f1392b = "SQLiteDbUtil";

    /* renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f1393c;

    /* renamed from: d, reason: collision with root package name */
    private Context f1394d;

    /* renamed from: e, reason: collision with root package name */
    private String f1395e;

    /* renamed from: f, reason: collision with root package name */
    private String f1396f;

    private <T> T k(Class<T> cls, Cursor cursor) {
        Object valueOf;
        try {
            Constructor<T> constructor = cls.getConstructor(null);
            constructor.setAccessible(true);
            T newInstance = constructor.newInstance(null);
            Class<?>[] c6 = b.c(cls);
            String[] b6 = b.b(cls);
            for (int i6 = 0; i6 < c6.length; i6++) {
                String str = b6[i6];
                Class<?> cls2 = c6[i6];
                Method method = cls.getMethod(l3.f4738h + str.substring(0, 1).toUpperCase() + str.substring(1), cls2);
                if (cls2.equals(String.class)) {
                    valueOf = cursor.getString(cursor.getColumnIndex(str));
                } else {
                    if (!cls2.equals(Integer.class) && !cls2.getName().equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        if (!cls2.equals(Character.class) && !cls2.getName().equals("char")) {
                            if (!cls2.equals(Boolean.class) && !cls2.getName().equals("boolean")) {
                                if (!cls2.equals(Float.class) && !cls2.getName().equals("float")) {
                                    if (!cls2.equals(Double.class) && !cls2.getName().equals("double")) {
                                        if (!cls2.equals(Byte.class) && !cls2.getName().equals("byte")) {
                                            if (!cls2.equals(Short.class) && !cls2.getName().equals("short")) {
                                                if (!cls2.equals(Long.class) && !cls2.getName().equals("long")) {
                                                    if (cls2.isArray()) {
                                                        valueOf = cursor.getBlob(cursor.getColumnIndex(str));
                                                    } else if (cls2.equals(Date.class)) {
                                                        if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(str)))) {
                                                            valueOf = new Date(cursor.getString(cursor.getColumnIndex(str)));
                                                        }
                                                    } else if (cls2.equals(java.sql.Date.class)) {
                                                        valueOf = TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(str))) ? null : java.sql.Date.valueOf(cursor.getString(cursor.getColumnIndex(str)));
                                                    }
                                                }
                                                valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex(str)));
                                            }
                                            valueOf = Short.valueOf(cursor.getShort(cursor.getColumnIndex(str)));
                                        }
                                        valueOf = Byte.valueOf(cursor.getString(cursor.getColumnIndex(str)));
                                    }
                                    valueOf = Double.valueOf(cursor.getDouble(cursor.getColumnIndex(str)));
                                }
                                valueOf = Float.valueOf(cursor.getFloat(cursor.getColumnIndex(str)));
                            }
                            valueOf = Boolean.valueOf("true".equalsIgnoreCase(cursor.getString(cursor.getColumnIndex(str))));
                        }
                        valueOf = Character.valueOf(cursor.getString(cursor.getColumnIndex(str)).charAt(0));
                    }
                    valueOf = Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str)));
                }
                method.invoke(newInstance, valueOf);
            }
            return newInstance;
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return null;
        } catch (InstantiationException e7) {
            e7.printStackTrace();
            return null;
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            return null;
        } catch (InvocationTargetException e9) {
            e9.printStackTrace();
            return null;
        }
    }

    public <T> int c(Class<T> cls) {
        if (cls == null) {
            return 0;
        }
        String d6 = b.d(cls);
        try {
            l();
            return this.f1393c.delete(d6, null, null);
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        } finally {
            a();
        }
    }

    public <T> int delete(Class<T> cls, int i6) {
        if (cls == null) {
            return 0;
        }
        String d6 = b.d(cls);
        try {
            l();
            return this.f1393c.delete(d6, "id=?", new String[]{String.valueOf(i6)});
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        } finally {
            a();
        }
    }

    public <T> long insert(T t5) {
        if (t5 == null) {
            return -1L;
        }
        String d6 = b.d(t5.getClass());
        ContentValues g6 = g(t5);
        try {
            try {
                l();
                return this.f1393c.insert(d6, null, g6);
            } catch (Exception e6) {
                e6.printStackTrace();
                a();
                return 0L;
            }
        } finally {
            a();
        }
    }

    public void m(Context context) {
        o(context, null, null);
    }

    public void n(Context context, String str) {
        o(context, null, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077  */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v8 */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> p(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 0
            r10.l()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L65
            android.database.sqlite.SQLiteDatabase r1 = r10.f1393c     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L65
            android.database.Cursor r11 = r1.rawQuery(r11, r0, r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L65
            if (r11 != 0) goto L15
            if (r11 == 0) goto L11
            r11.close()
        L11:
            r10.a()
            return r0
        L15:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L5b
            r1.<init>()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L5b
        L1a:
            boolean r0 = r11.moveToNext()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            if (r0 == 0) goto L54
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r0.<init>()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.lang.String[] r2 = r11.getColumnNames()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            int r3 = r2.length     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r4 = 0
        L2b:
            if (r4 >= r3) goto L50
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            int r6 = r11.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            int r7 = r11.getType(r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r8 = 4
            if (r7 != r8) goto L46
            byte[] r6 = r11.getBlob(r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r0.put(r5, r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            goto L4d
        L42:
            r0 = move-exception
            goto L75
        L44:
            r0 = move-exception
            goto L69
        L46:
            java.lang.String r6 = r11.getString(r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r0.put(r5, r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
        L4d:
            int r4 = r4 + 1
            goto L2b
        L50:
            r1.add(r0)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            goto L1a
        L54:
            r11.close()
            r10.a()
            return r1
        L5b:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L69
        L60:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L75
        L65:
            r11 = move-exception
            r1 = r0
            r0 = r11
            r11 = r1
        L69:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L42
            if (r11 == 0) goto L71
            r11.close()
        L71:
            r10.a()
            return r1
        L75:
            if (r11 == 0) goto L7a
            r11.close()
        L7a:
            r10.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.sqlitelibrary.c.p(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        if (r12 == null) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T query(java.lang.Class<T> r11, int r12) {
        /*
            r10 = this;
            r1 = 0
            if (r11 != 0) goto L4
            return r1
        L4:
            java.lang.String r3 = cn.bluemobi.dylan.sqlitelibrary.b.d(r11)
            r10.l()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            android.database.sqlite.SQLiteDatabase r2 = r10.f1393c     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r5 = "id=?"
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            if (r12 != 0) goto L2a
            if (r12 == 0) goto L26
            r12.close()
        L26:
            r10.a()
            return r1
        L2a:
            boolean r0 = r12.moveToNext()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            if (r0 == 0) goto L42
            java.lang.Object r11 = r10.k(r11, r12)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r12.close()
            r10.a()
            return r11
        L3b:
            r0 = move-exception
            r11 = r0
            r1 = r12
            goto L59
        L3f:
            r0 = move-exception
            r11 = r0
            goto L52
        L42:
            r12.close()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
        L45:
            r12.close()
        L48:
            r10.a()
            goto L58
        L4c:
            r0 = move-exception
            r11 = r0
            goto L59
        L4f:
            r0 = move-exception
            r11 = r0
            r12 = r1
        L52:
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L3b
            if (r12 == 0) goto L48
            goto L45
        L58:
            return r1
        L59:
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            r10.a()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.sqlitelibrary.c.query(java.lang.Class, int):java.lang.Object");
    }

    public <T> int update(T t5, int i6) {
        if (t5 == null) {
            return 0;
        }
        try {
            String d6 = b.d(t5.getClass());
            ContentValues g6 = g(t5);
            l();
            return this.f1393c.update(d6, g6, "id=?", new String[]{String.valueOf(i6)});
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        } finally {
            a();
        }
    }

    private c() {
    }

    private String getType(Class cls) {
        if (cls.equals(String.class)) {
            return "TEXT";
        }
        if (cls.equals(Integer.class) || cls.getName().equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return "Integer";
        }
        if (cls.equals(Character.class) || cls.getName().equals("char")) {
            return "Character";
        }
        if (cls.equals(Boolean.class) || cls.getName().equals("boolean")) {
            return "boolean";
        }
        if (cls.equals(Float.class) || cls.getName().equals("float")) {
            return "Float";
        }
        if (cls.equals(Double.class) || cls.getName().equals("double")) {
            return "Double";
        }
        if (cls.equals(Byte.class) || cls.getName().equals("byte")) {
            return "Byte";
        }
        if (cls.equals(Short.class) || cls.getName().equals("short")) {
            return "Short";
        }
        if (cls.equals(Long.class) || cls.getName().equals("long")) {
            return "Long";
        }
        if (cls.equals(Date.class) || cls.equals(java.sql.Date.class)) {
            return "Date";
        }
        if (!cls.isArray()) {
            return "TEXT";
        }
        String name = cls.getComponentType().getName();
        return ("byte".equals(name) || "Byte".equals(name)) ? "Blob" : "TEXT";
    }

    public static c h() {
        if (f1390g == null) {
            synchronized (c.class) {
                try {
                    if (f1390g == null) {
                        f1390g = new c();
                    }
                } finally {
                }
            }
        }
        return f1390g;
    }

    private boolean j(String str) {
        List<Map<String, Object>> p5 = p("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + str + "'");
        return p5 != null && p5.size() > 0 && Integer.parseInt(p5.get(0).get("count(*)").toString()) > 0;
    }

    private void l() throws Exception {
        if (this.f1393c == null) {
            throw new Exception("未初始化数据库");
        }
        o(this.f1394d, this.f1395e, this.f1396f);
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = this.f1393c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        this.f1393c.close();
    }

    public <T> void b(Class<T> cls) {
        int i6;
        String d6 = b.d(cls);
        ArrayList arrayList = new ArrayList(Arrays.asList(b.b(cls)));
        ArrayList arrayList2 = new ArrayList(Arrays.asList(b.c(cls)));
        int indexOf = arrayList.indexOf("id");
        if (indexOf != -1) {
            arrayList.remove(indexOf);
            arrayList2.remove(indexOf);
        }
        String str = ")";
        if (!j(d6)) {
            String str2 = ("CREATE TABLE IF NOT EXISTS " + d6 + "(") + "id  Integer PRIMARY KEY AUTOINCREMENT,";
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                str2 = i7 != arrayList.size() - 1 ? str2 + ((String) arrayList.get(i7)) + " " + getType((Class) arrayList2.get(i7)) + "," : str2 + ((String) arrayList.get(i7)) + " " + getType((Class) arrayList2.get(i7));
            }
            f(str2 + ")");
            return;
        }
        List<Map<String, Object>> p5 = p("PRAGMA table_info([" + d6 + "])");
        Objects.toString(p5);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i8 = 0;
        while (i8 < p5.size()) {
            String obj = p5.get(i8).get(CommonNetImpl.NAME).toString();
            List<Map<String, Object>> list = p5;
            String obj2 = p5.get(i8).get("type").toString();
            arrayList3.add(obj);
            arrayList4.add(obj2);
            i8++;
            str = str;
            p5 = list;
        }
        String str3 = str;
        int indexOf2 = arrayList3.indexOf("id");
        if (indexOf2 != -1) {
            arrayList3.remove(indexOf2);
            arrayList4.remove(indexOf2);
        }
        int i9 = 0;
        boolean z5 = false;
        while (i9 < arrayList.size()) {
            String str4 = (String) arrayList.get(i9);
            String type = getType((Class) arrayList2.get(i9));
            if (arrayList3.contains(str4)) {
                i6 = i9;
                int indexOf3 = arrayList3.indexOf(str4);
                if (indexOf3 != -1 && !type.equals((String) arrayList4.get(indexOf3))) {
                    z5 = true;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                i6 = i9;
                sb.append("ALTER TABLE ");
                sb.append(d6);
                sb.append(" ADD COLUMN ");
                sb.append(str4);
                sb.append(" ");
                sb.append(type);
                f(sb.toString());
            }
            i9 = i6 + 1;
        }
        if (z5) {
            List<T> query = h().query(cls);
            h().e(d6);
            String str5 = ("CREATE TABLE IF NOT EXISTS " + d6 + "(") + "id  Integer PRIMARY KEY AUTOINCREMENT,";
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                str5 = i10 != arrayList.size() - 1 ? str5 + ((String) arrayList.get(i10)) + " " + getType((Class) arrayList2.get(i10)) + "," : str5 + ((String) arrayList.get(i10)) + " " + getType((Class) arrayList2.get(i10));
            }
            f(str5 + str3);
            h().insert((List) query);
        }
    }

    public <T> void d(Class<T> cls) {
        if (cls == null) {
            return;
        }
        f("DROP TABLE IF EXISTS " + b.d(cls));
    }

    public void e(String str) {
        f("DROP TABLE IF EXISTS " + str);
    }

    public SQLiteDatabase i() {
        return this.f1393c;
    }

    public void o(Context context, String str, String str2) {
        this.f1394d = context;
        this.f1395e = str;
        this.f1396f = str2;
        if (TextUtils.isEmpty(str2)) {
            str2 = "mydb.db";
        }
        if (TextUtils.isEmpty(str)) {
            this.f1393c = context.openOrCreateDatabase(str2, 0, null);
            return;
        }
        File file = new File(str, str2);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        this.f1393c = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
    }

    private <T> ContentValues g(T t5) {
        List<Map<String, Object>> a6 = b.a(t5);
        ContentValues contentValues = new ContentValues();
        for (int i6 = 0; i6 < a6.size(); i6++) {
            Map<String, Object> map = a6.get(i6);
            String str = (String) map.get(CommonNetImpl.NAME);
            Object obj = map.get("value");
            if (obj == null) {
                contentValues.putNull(str);
            } else if (obj instanceof byte[]) {
                contentValues.put(str, (byte[]) obj);
            } else {
                contentValues.put(str, String.valueOf(obj));
            }
        }
        contentValues.remove("id");
        return contentValues;
    }

    public void f(String str) {
        try {
            try {
                l();
                this.f1393c.execSQL(str);
            } catch (SQLException e6) {
                e6.printStackTrace();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        } finally {
            a();
        }
    }

    public <T> int delete(Class<T> cls, String str, String[] strArr) {
        if (cls == null) {
            return 0;
        }
        String d6 = b.d(cls);
        try {
            l();
            return this.f1393c.delete(d6, str, strArr);
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        } finally {
            a();
        }
    }

    public <T> void insert(List<T> list) {
        if (list == null) {
            return;
        }
        try {
            try {
                l();
                this.f1393c.beginTransaction();
                for (T t5 : list) {
                    this.f1393c.insert(b.d(t5.getClass()), null, g(t5));
                }
                this.f1393c.setTransactionSuccessful();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            this.f1393c.endTransaction();
            a();
        } catch (Throwable th) {
            this.f1393c.endTransaction();
            a();
            throw th;
        }
    }

    public <T> int update(T t5, String str, String[] strArr) {
        if (t5 == null) {
            return -1;
        }
        String d6 = b.d(t5.getClass());
        ContentValues g6 = g(t5);
        try {
            try {
                l();
                return this.f1393c.update(d6, g6, str, strArr);
            } catch (Exception e6) {
                e6.printStackTrace();
                a();
                return 0;
            }
        } finally {
            a();
        }
    }

    public <T> List<T> query(Class<T> cls, String str, String[] strArr) {
        Throwable th;
        Exception exc;
        ArrayList arrayList;
        Cursor cursor = null;
        if (cls == null) {
            return null;
        }
        String d6 = b.d(cls);
        try {
            try {
                l();
                Cursor query = this.f1393c.query(d6, null, str, strArr, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    a();
                    return null;
                }
                try {
                    try {
                        arrayList = new ArrayList();
                        while (query.moveToNext()) {
                            try {
                                arrayList.add(k(cls, query));
                            } catch (Exception e6) {
                                exc = e6;
                                cursor = query;
                                exc.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                a();
                                return arrayList;
                            }
                        }
                        query.close();
                        query.close();
                        a();
                        return arrayList;
                    } catch (Exception e7) {
                        exc = e7;
                        arrayList = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e8) {
            exc = e8;
            arrayList = null;
        }
    }

    public <T> List<T> query(Class<T> cls) {
        Throwable th;
        Exception exc;
        ArrayList arrayList;
        Cursor cursor = null;
        if (cls == null) {
            a();
            return null;
        }
        try {
            try {
                l();
                Cursor query = this.f1393c.query(b.d(cls), null, null, null, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    a();
                    return null;
                }
                try {
                    try {
                        arrayList = new ArrayList();
                        while (query.moveToNext()) {
                            try {
                                arrayList.add(k(cls, query));
                            } catch (Exception e6) {
                                exc = e6;
                                cursor = query;
                                exc.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                a();
                                return arrayList;
                            }
                        }
                        query.close();
                        a();
                        return arrayList;
                    } catch (Exception e7) {
                        exc = e7;
                        arrayList = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e8) {
            exc = e8;
            arrayList = null;
        }
    }

    public <T> List<T> query(Class<T> cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Throwable th;
        Exception exc;
        ArrayList arrayList;
        Cursor cursor = null;
        try {
            if (cls == null) {
                a();
                return null;
            }
            try {
                l();
                Cursor query = this.f1393c.query(b.d(cls), strArr, str, strArr2, str2, str3, str4, str5);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    a();
                    return null;
                }
                try {
                    try {
                        arrayList = new ArrayList();
                        while (query.moveToNext()) {
                            try {
                                arrayList.add(k(cls, query));
                            } catch (Exception e6) {
                                exc = e6;
                                cursor = query;
                                exc.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                a();
                                return arrayList;
                            }
                        }
                        query.close();
                        a();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a();
                        throw th;
                    }
                } catch (Exception e7) {
                    exc = e7;
                    arrayList = null;
                }
            } catch (Exception e8) {
                exc = e8;
                arrayList = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}

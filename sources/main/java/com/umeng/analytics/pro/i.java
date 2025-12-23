package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.pro.e;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f41295a = 2049;

    /* renamed from: b, reason: collision with root package name */
    public static final int f41296b = 2050;

    /* renamed from: c, reason: collision with root package name */
    private static final int f41297c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private static Context f41298d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f41299e = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f41300f = "umeng+";

    /* renamed from: g, reason: collision with root package name */
    private static final String f41301g = "ek__id";

    /* renamed from: h, reason: collision with root package name */
    private static final String f41302h = "ek_key";

    /* renamed from: i, reason: collision with root package name */
    private List<String> f41303i;

    /* renamed from: j, reason: collision with root package name */
    private List<Integer> f41304j;

    /* renamed from: k, reason: collision with root package name */
    private String f41305k;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f41306l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.i$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final i f41314a = new i(null);

        private b() {
        }
    }

    /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static i a(Context context) {
        i iVar = b.f41314a;
        if (f41298d == null && context != null) {
            f41298d = StubApp.getOrigApplicationContext(context.getApplicationContext());
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f41303i.clear();
            this.f41306l.clear();
            this.f41304j.clear();
        }
    }

    public void b() {
        this.f41306l.clear();
    }

    public boolean c() {
        return this.f41306l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
    
        if (r0 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r6 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            com.umeng.analytics.pro.u r1 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r2 == 0) goto L29
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1f
        L1f:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return
        L29:
            java.lang.String r2 = ""
            java.lang.String r3 = "-1"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r3 = 0
        L32:
            r4 = 2
            if (r3 >= r4) goto L67
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4.<init>()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "update __et set __i=\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4.append(r1)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "\" where "
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "__i"
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "=\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r5 = r2[r3]     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            int r3 = r3 + 1
            goto L32
        L65:
            goto L77
        L67:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
        L6a:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L82
        L77:
            if (r0 == 0) goto L6d
            goto L6a
        L7a:
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L83
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L6d
            goto L6a
        L82:
            return
        L83:
            r1 = move-exception
            if (r0 == 0) goto L89
            r0.endTransaction()     // Catch: java.lang.Throwable -> L89
        L89:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.d():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.util.List<java.lang.Integer> r1 = r4.f41304j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r1 <= 0) goto L3e
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.f41304j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r1 >= r2) goto L3e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.<init>()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.util.List<java.lang.Integer> r3 = r4.f41304j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.append(r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r1 = r1 + 1
            goto L17
        L3c:
            goto L53
        L3e:
            java.util.List<java.lang.Integer> r1 = r4.f41304j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r1.clear()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
        L46:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L49
        L49:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L5e
        L53:
            if (r0 == 0) goto L49
            goto L46
        L56:
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L5f
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L49
            goto L46
        L5e:
            return
        L5f:
            r1 = move-exception
            if (r0 == 0) goto L65
            r0.endTransaction()     // Catch: java.lang.Throwable -> L65
        L65:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r0 == null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
        L16:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L19
        L19:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L2f
        L23:
            if (r0 == 0) goto L19
            goto L16
        L27:
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L30
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L19
            goto L16
        L2f:
            return
        L30:
            r1 = move-exception
            if (r0 == 0) goto L36
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.i():void");
    }

    private i() {
        this.f41303i = new ArrayList();
        this.f41304j = new ArrayList();
        this.f41305k = null;
        this.f41306l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c6 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c6);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(f41298d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f41298d));
            sQLiteDatabase.insert(e.c.f41249a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        Cursor cursor2 = null;
        r13 = null;
        r13 = null;
        String str2 = null;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(e.d.a.f41267e);
            if (optJSONObject != null) {
                sQLiteDatabase2 = sQLiteDatabase;
                cursor = a(e.d.f41262a, sQLiteDatabase2, new String[]{e.d.a.f41267e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            str2 = d(cursor.getString(cursor.getColumnIndex(e.d.a.f41267e)));
                        } catch (Throwable unused) {
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                    }
                }
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                cursor = null;
            }
            if (optJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(str2)) {
                    jSONArray = new JSONArray(str2);
                }
                jSONArray.put(optJSONObject);
                String c6 = c(jSONArray.toString());
                if (!TextUtils.isEmpty(c6)) {
                    sQLiteDatabase2.execSQL("update  __sd set __d=\"" + c6 + "\" where __ii=\"" + str + "\"");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(e.d.a.f41266d);
            if (optJSONObject2 != null) {
                String c7 = c(optJSONObject2.toString());
                if (!TextUtils.isEmpty(c7)) {
                    sQLiteDatabase2.execSQL("update  __sd set __c=\"" + c7 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase2.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(e.d.a.f41269g)) + "\" where __ii=\"" + str + "\"");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable unused2) {
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f41299e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f41298d, f41301g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f41298d).getString(f41301g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f41298d, f41301g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < substring.length(); i6++) {
                        char charAt = substring.charAt(i6);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    f41299e = sb.toString();
                }
                if (TextUtils.isEmpty(f41299e)) {
                    return;
                }
                f41299e += new StringBuilder(f41299e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f41298d, f41302h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f41298d, f41302h, c(f41300f));
                } else {
                    if (f41300f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean e() {
        return this.f41303i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a5, code lost:
    
        if (r6 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008d, code lost:
    
        r6.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008b, code lost:
    
        if (r6 != null) goto L51;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f41306l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            android.database.sqlite.SQLiteDatabase r6 = r2.a()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.util.List<java.lang.String> r2 = r14.f41306l     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r5 = "__is"
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r12 = 0
            r13 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r4 = r14
            android.database.Cursor r2 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            if (r2 == 0) goto L65
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            if (r4 == 0) goto L65
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r4.<init>()     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            int r3 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            int r5 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r4.put(r1, r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r4.put(r0, r5)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r3 = r4
            goto L65
        L5b:
        L5c:
            r3 = r2
            goto L86
        L5e:
            r3 = r2
            goto L9b
        L60:
            r4 = r3
            goto L5c
        L63:
            r4 = r3
            goto L5e
        L65:
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            if (r2 == 0) goto L6d
            r2.close()
        L6d:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L70
        L70:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La8
        L7a:
            r4 = r3
            goto L86
        L7d:
            r4 = r3
            goto L9b
        L7f:
            r4 = r3
            r6 = r4
            goto L86
        L83:
            r4 = r3
            r6 = r4
            goto L9b
        L86:
            if (r3 == 0) goto L8b
            r3.close()
        L8b:
            if (r6 == 0) goto L90
        L8d:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L90
        L90:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r4
            goto La8
        L9b:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> La9
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La9
            if (r3 == 0) goto La5
            r3.close()
        La5:
            if (r6 == 0) goto L90
            goto L8d
        La8:
            return r3
        La9:
            r0 = move-exception
            if (r3 == 0) goto Laf
            r3.close()
        Laf:
            if (r6 == 0) goto Lb4
            r6.endTransaction()     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.f():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a5, code lost:
    
        if (r6 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008d, code lost:
    
        r6.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008b, code lost:
    
        if (r6 != null) goto L51;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f41303i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            android.database.sqlite.SQLiteDatabase r6 = r2.a()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.util.List<java.lang.String> r2 = r14.f41303i     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r5 = "__sd"
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r12 = 0
            r13 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r4 = r14
            android.database.Cursor r2 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            if (r2 == 0) goto L65
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            if (r4 == 0) goto L65
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r4.<init>()     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            int r3 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            int r5 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r4.put(r1, r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r4.put(r0, r5)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r3 = r4
            goto L65
        L5b:
        L5c:
            r3 = r2
            goto L86
        L5e:
            r3 = r2
            goto L9b
        L60:
            r4 = r3
            goto L5c
        L63:
            r4 = r3
            goto L5e
        L65:
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            if (r2 == 0) goto L6d
            r2.close()
        L6d:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L70
        L70:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La8
        L7a:
            r4 = r3
            goto L86
        L7d:
            r4 = r3
            goto L9b
        L7f:
            r4 = r3
            r6 = r4
            goto L86
        L83:
            r4 = r3
            r6 = r4
            goto L9b
        L86:
            if (r3 == 0) goto L8b
            r3.close()
        L8b:
            if (r6 == 0) goto L90
        L8d:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L90
        L90:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r4
            goto La8
        L9b:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> La9
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La9
            if (r3 == 0) goto La5
            r3.close()
        La5:
            if (r6 == 0) goto L90
            goto L8d
        La8:
            return r3
        La9:
            r0 = move-exception
            if (r3 == 0) goto Laf
            r3.close()
        Laf:
            if (r6 == 0) goto Lb4
            r6.endTransaction()     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        if (r1 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.f41305k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L7c
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.<init>()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = r5.f41305k     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r0)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.<init>()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = r5.f41305k     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r0)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
        L4d:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L50
        L50:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L7c
        L5a:
            goto L61
        L5c:
            r1 = r2
            goto L61
        L5f:
            r1 = r2
            goto L64
        L61:
            if (r1 == 0) goto L50
            goto L4d
        L64:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L6c
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L50
            goto L4d
        L6c:
            r0 = move-exception
            if (r1 == 0) goto L72
            r1.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L7c:
            r5.f41305k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.j():void");
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.f41303i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
    
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a6, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
    
        if (r2 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> La3 android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> La3 android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> La3 android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            if (r4 >= r5) goto L91
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.<init>()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L38
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            if (r8 == 0) goto L47
            goto L38
        L35:
            r2 = r3
            goto La4
        L38:
            com.umeng.analytics.pro.u r7 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = r7.b()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            if (r8 == 0) goto L47
            r7 = r9
        L47:
            r6.put(r1, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            int r7 = r5.optInt(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r0, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r5.remove(r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r5.remove(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
        L8e:
            int r4 = r4 + 1
            goto L13
        L91:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r3.endTransaction()     // Catch: java.lang.Throwable -> L97
        L97:
            android.content.Context r11 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r11 = com.umeng.analytics.pro.g.a(r11)
            r11.b()
            goto Lb2
        La1:
            r2 = r3
            goto Laa
        La3:
        La4:
            if (r2 == 0) goto L97
        La6:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L97
            goto L97
        Laa:
            android.content.Context r11 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> Lb3
            com.umeng.analytics.pro.h.a(r11)     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto L97
            goto La6
        Lb2:
            return
        Lb3:
            r11 = move-exception
            if (r2 == 0) goto Lb9
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb9
        Lb9:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONArray):void");
    }

    public JSONObject b(boolean z5) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z5);
        return jSONObject;
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f41299e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f41299e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
    
        if (r4 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
    
        if (r4 != null) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00b5: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:60:0x00ba, block:B:59:0x00b5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> L8e
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> L8e
            android.database.sqlite.SQLiteDatabase r4 = r1.a()     // Catch: java.lang.Throwable -> L8a android.database.sqlite.SQLiteDatabaseCorruptException -> L8e
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L29 android.database.sqlite.SQLiteDatabaseCorruptException -> L2d
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L29 android.database.sqlite.SQLiteDatabaseCorruptException -> L2d
            if (r1 != 0) goto L31
            java.lang.String r3 = "__er"
            java.lang.String r6 = "__i=? "
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L29 android.database.sqlite.SQLiteDatabaseCorruptException -> L2d
            r10 = 0
            r11 = 0
            r5 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L29 android.database.sqlite.SQLiteDatabaseCorruptException -> L2d
            r2 = r12
        L27:
            r0 = r14
            goto L40
        L29:
            r2 = r12
        L2a:
            r13 = r0
            goto L92
        L2d:
            r2 = r12
        L2e:
            r13 = r0
            goto La2
        L31:
            java.lang.String r3 = "__er"
            r10 = 0
            r11 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            goto L27
        L40:
            if (r0 == 0) goto L75
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            r14.<init>()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
        L47:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            if (r1 == 0) goto L6a
            java.lang.String r1 = "__a"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            if (r3 != 0) goto L47
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            java.lang.String r1 = r12.d(r1)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            r14.put(r3)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            goto L47
        L6a:
            int r1 = r14.length()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            if (r1 <= 0) goto L75
            java.lang.String r1 = "error"
            r13.put(r1, r14)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
        L75:
            r4.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteDatabaseCorruptException -> L2e
            if (r0 == 0) goto L7d
            r0.close()
        L7d:
            r4.endTransaction()     // Catch: java.lang.Throwable -> L80
        L80:
            android.content.Context r13 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r13 = com.umeng.analytics.pro.g.a(r13)
            r13.b()
            goto Laf
        L8a:
            r2 = r12
            r13 = r0
            r4 = r13
            goto L92
        L8e:
            r2 = r12
            r13 = r0
            r4 = r13
            goto La2
        L92:
            android.content.Context r14 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L9f
            com.umeng.analytics.pro.h.a(r14)     // Catch: java.lang.Throwable -> L9f
            if (r13 == 0) goto L9c
            r13.close()
        L9c:
            if (r4 == 0) goto L80
            goto L7d
        L9f:
            r0 = move-exception
            r14 = r0
            goto Lb0
        La2:
            android.content.Context r14 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L9f
            com.umeng.analytics.pro.h.a(r14)     // Catch: java.lang.Throwable -> L9f
            if (r13 == 0) goto Lac
            r13.close()
        Lac:
            if (r4 == 0) goto L80
            goto L7d
        Laf:
            return
        Lb0:
            if (r13 == 0) goto Lb5
            r13.close()
        Lb5:
            if (r4 == 0) goto Lba
            r4.endTransaction()     // Catch: java.lang.Throwable -> Lba
        Lba:
            android.content.Context r13 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r13 = com.umeng.analytics.pro.g.a(r13)
            r13.b()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f41299e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f41299e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.<init>()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            if (r6 != 0) goto L51
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            goto L51
        L4c:
            r0 = r1
            goto L62
        L4f:
            r0 = r1
            goto L68
        L51:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r1.endTransaction()     // Catch: java.lang.Throwable -> L57
        L57:
            android.content.Context r5 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            goto L70
        L61:
        L62:
            if (r0 == 0) goto L57
        L64:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L57
            goto L57
        L68:
            android.content.Context r5 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L72
            com.umeng.analytics.pro.h.a(r5)     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L57
            goto L64
        L70:
            r5 = 0
            return r5
        L72:
            r5 = move-exception
            if (r0 == 0) goto L78
            r0.endTransaction()     // Catch: java.lang.Throwable -> L78
        L78:
            android.content.Context r6 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r6 = com.umeng.analytics.pro.g.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i6 = 0; i6 < length; i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e8, code lost:
    
        if (r4 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d8, code lost:
    
        if (r4 == null) goto L30;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00ec: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:69:0x00f1, block:B:67:0x00ec */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00f1: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:70:0x00f6, block:B:69:0x00f1 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:
    
        if (r2 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
    
        if (r2 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.i.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            com.umeng.analytics.pro.i$a r4 = com.umeng.analytics.pro.i.a.BEGIN     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r4) goto L54
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.<init>()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L4f:
            r2 = r3
            goto L90
        L52:
            r2 = r3
            goto L96
        L54:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L5c
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L5c:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.END     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L64
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L64:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.PAGE     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L6e
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L6e:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.AUTOPAGE     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L78
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L78:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.NEWSESSION     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L7f
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
        L7f:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r3.endTransaction()     // Catch: java.lang.Throwable -> L85
        L85:
            android.content.Context r7 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r7 = com.umeng.analytics.pro.g.a(r7)
            r7.b()
            goto L9e
        L8f:
        L90:
            if (r2 == 0) goto L85
        L92:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L85
            goto L85
        L96:
            android.content.Context r7 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L9f
            com.umeng.analytics.pro.h.a(r7)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L85
            goto L92
        L9e:
            return r1
        L9f:
            r7 = move-exception
            if (r2 == 0) goto La5
            r2.endTransaction()     // Catch: java.lang.Throwable -> La5
        La5:
            android.content.Context r8 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r8 = com.umeng.analytics.pro.g.a(r8)
            r8.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.i$a):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r0 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r4 == 0) goto L1a
            if (r3 == 0) goto L4f
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            goto L4f
        L18:
            goto L5f
        L1a:
            java.util.List<java.lang.String> r3 = r2.f41303i     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r3 <= 0) goto L4f
            r3 = 0
        L23:
            java.util.List<java.lang.String> r4 = r2.f41303i     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r3 >= r4) goto L4f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.util.List<java.lang.String> r1 = r2.f41303i     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r4.append(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r3 = r3 + 1
            goto L23
        L4f:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
        L52:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L55
        L55:
            android.content.Context r3 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)
            r3.b()
            goto L6a
        L5f:
            if (r0 == 0) goto L55
            goto L52
        L62:
            android.content.Context r3 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.h.a(r3)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L55
            goto L52
        L6a:
            return
        L6b:
            r3 = move-exception
            if (r0 == 0) goto L71
            r0.endTransaction()     // Catch: java.lang.Throwable -> L71
        L71:
            android.content.Context r4 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(boolean, boolean):void");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        String str2;
        try {
            long longValue = ((Long) jSONObject.opt(e.d.a.f41269g)).longValue();
            Object opt = jSONObject.opt(e.d.a.f41270h);
            long longValue2 = (opt == null || !(opt instanceof Long)) ? 0L : ((Long) opt).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str3 = "";
            if (optJSONObject == null || optJSONObject.length() <= 0) {
                str2 = "";
            } else {
                str2 = c(optJSONObject.toString());
            }
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str3 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + e.d.a.f41270h + "=\"" + longValue2 + "\", __sp=\"" + str2 + "\", __pp=\"" + str3 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r7 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            android.database.sqlite.SQLiteDatabase r7 = r4.a()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            r7.beginTransaction()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            java.lang.String[] r8 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            java.lang.String r6 = "__sd"
            java.lang.String r9 = "__ii=? "
            java.lang.String[] r10 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r13 = 0
            r14 = 0
            r11 = 0
            r12 = 0
            r5 = r15
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r1 == 0) goto L39
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            goto L39
        L35:
            r0 = move-exception
            goto L51
        L37:
            goto L65
        L39:
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.lang.Exception -> L41
        L3e:
            r7.endTransaction()     // Catch: java.lang.Exception -> L41
        L41:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L6d
        L4b:
            r0 = move-exception
            r7 = r1
            goto L51
        L4e:
            r7 = r1
            goto L65
        L51:
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.lang.Exception -> L5b
        L56:
            if (r7 == 0) goto L5b
            r7.endTransaction()     // Catch: java.lang.Exception -> L5b
        L5b:
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L65:
            if (r1 == 0) goto L6a
            r1.close()     // Catch: java.lang.Exception -> L41
        L6a:
            if (r7 == 0) goto L41
            goto L3e
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            if (r1 != 0) goto L30
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r1.<init>()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r1.append(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            goto L30
        L2e:
            goto L40
        L30:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
        L33:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r4 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L4b
        L40:
            if (r0 == 0) goto L36
            goto L33
        L43:
            android.content.Context r4 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L4c
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L36
            goto L33
        L4b:
            return
        L4c:
            r4 = move-exception
            if (r0 == 0) goto L52
            r0.endTransaction()     // Catch: java.lang.Throwable -> L52
        L52:
            android.content.Context r0 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0074 A[Catch: all -> 0x0065, TryCatch #1 {all -> 0x0065, blocks: (B:52:0x0052, B:54:0x0058, B:15:0x0069, B:17:0x0074, B:18:0x0079, B:26:0x0088, B:29:0x008e, B:31:0x0094, B:38:0x009a, B:40:0x00a8, B:33:0x0097), top: B:51:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0052 A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x0052->B:54:0x0058, LOOP_START, PHI: r12
  0x0052: PHI (r12v2 java.lang.String) = (r12v7 java.lang.String), (r12v3 java.lang.String) binds: [B:14:0x0050, B:54:0x0058] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r15, org.json.JSONObject r16, android.database.sqlite.SQLiteDatabase r17, java.lang.String r18) throws org.json.JSONException {
        /*
            r14 = this;
            r0 = r16
            r10 = r18
            java.lang.String r11 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r12 = 0
            boolean r3 = r2.equals(r10)     // Catch: java.lang.Throwable -> L21
            if (r3 == 0) goto L24
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto Le4
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L21
            if (r1 > 0) goto L1f
            goto Le4
        L1f:
            r13 = r0
            goto L39
        L21:
            goto Ldf
        L24:
            boolean r2 = r1.equals(r10)     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L38
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto Le4
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L21
            if (r1 > 0) goto L1f
            goto Le4
        L38:
            r13 = r12
        L39:
            java.lang.String[] r3 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[]{r15}     // Catch: java.lang.Throwable -> L21
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            r0 = r14
            r2 = r17
            android.database.Cursor r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L69
        L52:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L69
            int r2 = r1.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L65
            java.lang.String r12 = r14.d(r2)     // Catch: java.lang.Throwable -> L65
            goto L52
        L65:
            r12 = r1
            goto Ldf
        L69:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L65
            r2.<init>()     // Catch: java.lang.Throwable -> L65
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L65
            if (r3 != 0) goto L79
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L65
            r2.<init>(r12)     // Catch: java.lang.Throwable -> L65
        L79:
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L65
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 <= r4) goto L87
            if (r1 == 0) goto Le4
            r1.close()
            return
        L87:
            r3 = 0
        L88:
            int r4 = r13.length()     // Catch: java.lang.Throwable -> L65
            if (r3 >= r4) goto L9a
            org.json.JSONObject r4 = r13.getJSONObject(r3)     // Catch: java.lang.Throwable -> L65 org.json.JSONException -> L97
            if (r4 == 0) goto L97
            r2.put(r4)     // Catch: java.lang.Throwable -> L65
        L97:
            int r3 = r3 + 1
            goto L88
        L9a:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = r14.c(r2)     // Catch: java.lang.Throwable -> L65
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L65
            if (r3 != 0) goto Ld9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r3.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r4 = "update __sd set "
            r3.append(r4)     // Catch: java.lang.Throwable -> L65
            r3.append(r10)     // Catch: java.lang.Throwable -> L65
            r3.append(r11)     // Catch: java.lang.Throwable -> L65
            r3.append(r2)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = "\" where "
            r3.append(r2)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = "__ii"
            r3.append(r2)     // Catch: java.lang.Throwable -> L65
            r3.append(r11)     // Catch: java.lang.Throwable -> L65
            r3.append(r15)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L65
            r3 = r17
            r3.execSQL(r2)     // Catch: java.lang.Throwable -> L65
        Ld9:
            if (r1 == 0) goto Le4
            r1.close()
            goto Le4
        Ldf:
            if (r12 == 0) goto Le4
            r12.close()
        Le4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    public JSONObject a(boolean z5) {
        a();
        this.f41304j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z5) {
            a(jSONObject, z5);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
            return jSONObject;
        }
        String a6 = a(jSONObject, z5);
        if (!TextUtils.isEmpty(a6)) {
            b(jSONObject, a6);
            a(jSONObject, a6);
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01aa, code lost:
    
        if (r4 != null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x019a, code lost:
    
        if (r4 != null) goto L100;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x01b3: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:123:0x01b8, block:B:122:0x01b3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0253, code lost:
    
        if (r16 != null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0244, code lost:
    
        if (r16 != null) goto L129;
     */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x025c: IF  (r16 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:138:0x0261, block:B:137:0x025c */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0257: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:137:0x025c, block:B:135:0x0257 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            if (r7 == 0) goto L18
            if (r6 == 0) goto L53
            java.lang.String r6 = "delete from __is"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            goto L53
        L18:
            java.util.List<java.lang.String> r6 = r5.f41306l     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r7 = 0
            if (r6 <= 0) goto L4c
            r1 = 0
        L22:
            if (r7 >= r6) goto L4b
            java.util.List<java.lang.String> r2 = r5.f41306l     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.Object r2 = r2.get(r7)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            if (r2 != 0) goto L2f
            r1 = 1
        L2f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r3.<init>()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r4 = "delete from __is where __ii=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r3.append(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            int r7 = r7 + 1
            goto L22
        L4b:
            r7 = r1
        L4c:
            if (r7 == 0) goto L53
            java.lang.String r6 = "delete from __is where __ii is null"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
        L53:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
        L56:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L59
        L59:
            android.content.Context r6 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r6 = com.umeng.analytics.pro.g.a(r6)
            r6.b()
            goto L75
        L63:
            android.content.Context r6 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.h.a(r6)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L59
            goto L56
        L6b:
            r6 = move-exception
            goto L76
        L6d:
            android.content.Context r6 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.h.a(r6)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L59
            goto L56
        L75:
            return
        L76:
            if (r0 == 0) goto L7b
            r0.endTransaction()     // Catch: java.lang.Throwable -> L7b
        L7b:
            android.content.Context r7 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r7 = com.umeng.analytics.pro.g.a(r7)
            r7.b()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            if (r1 != 0) goto L63
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.util.List<java.lang.Integer> r1 = r3.f41304j     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.clear()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            goto L63
        L61:
            goto L73
        L63:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
        L66:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r4 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L7e
        L73:
            if (r0 == 0) goto L69
            goto L66
        L76:
            android.content.Context r4 = com.umeng.analytics.pro.i.f41298d     // Catch: java.lang.Throwable -> L7f
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L69
            goto L66
        L7e:
            return
        L7f:
            r4 = move-exception
            if (r0 == 0) goto L85
            r0.endTransaction()     // Catch: java.lang.Throwable -> L85
        L85:
            android.content.Context r5 = com.umeng.analytics.pro.i.f41298d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, java.lang.String):void");
    }
}

package com.bxkj.base.v2.data.spp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class PreferencesProvider extends ContentProvider {

    /* renamed from: i, reason: collision with root package name */
    public static String f17020i = "SPCOLUMNNAME";

    /* renamed from: j, reason: collision with root package name */
    public static String f17021j = "authorities_key";

    /* renamed from: k, reason: collision with root package name */
    public static String f17022k = "authorities_spname";

    /* renamed from: l, reason: collision with root package name */
    public static final int f17023l = 100;

    /* renamed from: m, reason: collision with root package name */
    public static final int f17024m = 101;

    /* renamed from: n, reason: collision with root package name */
    public static final int f17025n = 102;

    /* renamed from: o, reason: collision with root package name */
    public static final int f17026o = 104;

    /* renamed from: p, reason: collision with root package name */
    public static final int f17027p = 105;

    /* renamed from: q, reason: collision with root package name */
    public static final int f17028q = 106;

    /* renamed from: r, reason: collision with root package name */
    public static final int f17029r = 107;

    /* renamed from: a, reason: collision with root package name */
    private UriMatcher f17030a;

    /* renamed from: b, reason: collision with root package name */
    private String f17031b = "string/*/*/";

    /* renamed from: c, reason: collision with root package name */
    private String f17032c = "integer/*/*/";

    /* renamed from: d, reason: collision with root package name */
    private String f17033d = "long/*/*/";

    /* renamed from: e, reason: collision with root package name */
    private String f17034e = "float/*/*/";

    /* renamed from: f, reason: collision with root package name */
    private String f17035f = "boolean/*/*/";

    /* renamed from: g, reason: collision with root package name */
    private String f17036g = "delete/*/*/";

    /* renamed from: h, reason: collision with root package name */
    private String f17037h = "puts";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        private String f17038a;

        /* renamed from: b, reason: collision with root package name */
        private String f17039b;

        /* renamed from: c, reason: collision with root package name */
        private Object f17040c;

        /* synthetic */ a(PreferencesProvider preferencesProvider, com.bxkj.base.v2.data.spp.a aVar) {
            this();
        }

        private a() {
        }

        public Object a() {
            return this.f17040c;
        }

        public String b() {
            return this.f17039b;
        }

        public String c() {
            return this.f17038a;
        }

        public void d(Object obj) {
            this.f17040c = obj;
        }

        public void e(String str) {
            this.f17039b = str;
        }

        public void f(String str) {
            this.f17038a = str;
        }
    }

    private Cursor a(Context context, a aVar, int i6) {
        Object k6;
        Object obj;
        Object a6 = aVar.a();
        switch (i6) {
            case 100:
                if (a6 != null) {
                    k6 = c.k(context, aVar.c(), aVar.b(), String.valueOf(a6));
                    break;
                } else {
                    k6 = c.j(context, aVar.c(), aVar.b());
                    break;
                }
            case 101:
                if (a6 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a6);
                    sb.append("");
                    obj = TextUtils.isDigitsOnly(sb.toString()) ? a6 : -1;
                    k6 = Integer.valueOf(c.g(context, aVar.c(), aVar.b(), Integer.parseInt(obj + "")));
                    break;
                } else {
                    k6 = Integer.valueOf(c.f(context, aVar.c(), aVar.b()));
                    break;
                }
            case 102:
                if (a6 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(a6);
                    sb2.append("");
                    obj = TextUtils.isDigitsOnly(sb2.toString()) ? a6 : -1;
                    k6 = Long.valueOf(c.i(context, aVar.c(), aVar.b(), Long.parseLong(obj + "")));
                    break;
                } else {
                    k6 = Long.valueOf(c.h(context, aVar.c(), aVar.b()));
                    break;
                }
            case 103:
            default:
                k6 = null;
                break;
            case 104:
                if (a6 != null) {
                    k6 = Float.valueOf(c.e(context, aVar.c(), aVar.b(), Float.parseFloat(a6 + "")));
                    break;
                } else {
                    k6 = Float.valueOf(c.d(context, aVar.c(), aVar.b()));
                    break;
                }
            case 105:
                if (a6 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(c.b(context, aVar.c(), aVar.b(), Boolean.valueOf(a6 + "").booleanValue()));
                    sb3.append("");
                    k6 = sb3.toString();
                    break;
                } else {
                    k6 = c.a(context, aVar.c(), aVar.b()) + "";
                    break;
                }
        }
        if (k6 == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{f17020i});
        matrixCursor.addRow(new Object[]{k6});
        return matrixCursor;
    }

    private a c(Uri uri) {
        try {
            a aVar = new a(this, null);
            aVar.f(uri.getPathSegments().get(1));
            if (uri.getPathSegments().size() > 2) {
                aVar.e(uri.getPathSegments().get(2));
            }
            if (uri.getPathSegments().size() > 3) {
                aVar.d(uri.getPathSegments().get(3));
            }
            return aVar;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public abstract String b();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        a c6 = c(uri);
        if (c6 == null) {
            return -1;
        }
        int match = this.f17030a.match(uri);
        if (match != 100 && match != 101 && match != 102 && match != 104 && match != 105) {
            return 0;
        }
        delete(getContext(), c6);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        a c6 = c(uri);
        if (c6 == null) {
            return null;
        }
        int match = this.f17030a.match(uri);
        if (match != 100 && match != 101 && match != 102 && match != 104 && match != 105 && match != 107) {
            return uri;
        }
        insert(getContext(), contentValues, c6);
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String b6 = b();
        c.p(getContext(), f17022k, f17021j, b6);
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f17030a = uriMatcher;
        uriMatcher.addURI(b6, this.f17031b, 100);
        this.f17030a.addURI(b6, this.f17031b + "*/", 100);
        this.f17030a.addURI(b6, this.f17032c, 101);
        this.f17030a.addURI(b6, this.f17032c + "*/", 101);
        this.f17030a.addURI(b6, this.f17033d, 102);
        this.f17030a.addURI(b6, this.f17033d + "*/", 102);
        this.f17030a.addURI(b6, this.f17034e, 104);
        this.f17030a.addURI(b6, this.f17034e + "*/", 104);
        this.f17030a.addURI(b6, this.f17035f, 105);
        this.f17030a.addURI(b6, this.f17035f + "*/", 105);
        this.f17030a.addURI(b6, this.f17036g, 106);
        this.f17030a.addURI(b6, this.f17037h, 107);
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        a c6 = c(uri);
        if (c6 == null) {
            return null;
        }
        return a(getContext(), c6, this.f17030a.match(uri));
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a c6 = c(uri);
        if (c6 == null) {
            return -1;
        }
        int match = this.f17030a.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105) {
            insert(getContext(), contentValues, c6);
            return 0;
        }
        return 0;
    }

    private void delete(Context context, a aVar) {
        SharedPreferences.Editor c6 = c.c(context, aVar.c());
        c6.remove(aVar.b());
        c6.apply();
    }

    private void insert(Context context, ContentValues contentValues, a aVar) {
        SharedPreferences.Editor c6 = c.c(context, aVar.c());
        for (String str : contentValues.keySet()) {
            Object obj = contentValues.get(str);
            if (obj instanceof Integer) {
                c6.putInt(str, Integer.parseInt(obj + ""));
            } else if (obj instanceof Long) {
                c6.putLong(str, Long.parseLong(obj + ""));
            } else if (obj instanceof Float) {
                c6.putFloat(str, Float.parseFloat(obj + ""));
            } else if (obj instanceof Boolean) {
                c6.putBoolean(str, Boolean.valueOf(obj + "").booleanValue());
            } else {
                StringBuilder sb = new StringBuilder();
                if (obj == null) {
                    obj = "";
                }
                sb.append(obj);
                sb.append("");
                c6.putString(str, sb.toString());
            }
        }
        c6.apply();
    }
}

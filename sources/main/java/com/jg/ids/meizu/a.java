package com.jg.ids.meizu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: D:\Downloads\app\classes10.dex */
final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final a f35567b = new a();

    /* renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f35568a = null;

    /* renamed from: c, reason: collision with root package name */
    private b f35569c = null;

    static a a() {
        return f35567b;
    }

    private a() {
    }

    public final boolean a(Context context) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
        } catch (Throwable th) {
            cursor = null;
        }
        if (context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) {
            return false;
        }
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
        if (query != null) {
            try {
                query.moveToFirst();
                d a6 = a(query);
                if (a6 != null) {
                    boolean equals = "0".equals(a6.f35570a);
                    if (query == null) {
                        return equals;
                    }
                    query.close();
                    return equals;
                }
            } catch (Throwable th2) {
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    private static d a(Cursor cursor) {
        d dVar = null;
        d dVar2 = new d(null, 0);
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        dVar2.f35570a = cursor.getString(columnIndex);
                    }
                    int columnIndex2 = cursor.getColumnIndex("code");
                    if (columnIndex2 >= 0) {
                        dVar2.f35571b = cursor.getInt(columnIndex2);
                    }
                    int columnIndex3 = cursor.getColumnIndex("expired");
                    if (columnIndex3 >= 0) {
                        dVar2.f35572c = cursor.getLong(columnIndex3);
                        return dVar2;
                    }
                }
            } catch (Throwable th) {
            }
        }
        dVar = dVar2;
        return dVar;
    }

    public final String b(Context context) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"aaid"}, null);
            if (query != null) {
                try {
                    d a6 = a(query);
                    if (a6 != null) {
                        if (a6.f35571b != 1000) {
                            e(context);
                        }
                        String str = a6.f35570a;
                        if (query == null) {
                            return str;
                        }
                        query.close();
                        return str;
                    }
                } catch (Throwable th) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return "";
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th2) {
            cursor = null;
        }
        return "";
    }

    public final String c(Context context) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (query != null) {
                try {
                    d a6 = a(query);
                    if (a6 != null) {
                        if (a6.f35571b != 1000) {
                            e(context);
                        }
                        String str = a6.f35570a;
                        if (query == null) {
                            return str;
                        }
                        query.close();
                        return str;
                    }
                } catch (Throwable th) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return "";
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th2) {
            cursor = null;
        }
        return "";
    }

    public final String d(Context context) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"vaid"}, null);
            if (query != null) {
                try {
                    d a6 = a(query);
                    if (a6 != null) {
                        if (a6.f35571b != 1000) {
                            e(context);
                        }
                        String str = a6.f35570a;
                        if (query == null) {
                            return str;
                        }
                        query.close();
                        return str;
                    }
                } catch (Throwable th) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return "";
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th2) {
            cursor = null;
        }
        return "";
    }

    public final void a(b bVar) {
        this.f35569c = bVar;
    }

    public final void a(int i6) {
        if (this.f35569c != null) {
            this.f35569c.a(i6);
        }
    }

    private synchronized void e(Context context) {
        try {
            if (this.f35568a == null) {
                this.f35568a = new MeiZuReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                context.registerReceiver(this.f35568a, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}

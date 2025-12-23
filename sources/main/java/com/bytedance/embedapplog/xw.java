package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.tk;

/* loaded from: D:\Downloads\app\classes3.dex */
final class xw implements tk {

    /* renamed from: j, reason: collision with root package name */
    private wf<Boolean> f24101j = new wf<Boolean>() { // from class: com.bytedance.embedapplog.xw.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.wf
        /* renamed from: cw, reason: merged with bridge method [inline-methods] */
        public Boolean j(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    @Override // com.bytedance.embedapplog.tk
    public boolean j(Context context) {
        if (context == null) {
            return false;
        }
        return this.f24101j.xt(context).booleanValue();
    }

    private String j(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }

    @Override // com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursor == null) {
                return null;
            }
            try {
                tk.j jVar = new tk.j();
                jVar.xt = j(cursor);
                return jVar;
            } catch (Throwable th) {
                th = th;
                try {
                    uc.j(th);
                    return null;
                } finally {
                    ri.j(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    xw() {
    }
}

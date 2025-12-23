package com.beizi.fusion.d.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.beizi.fusion.d.a.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Context f13383a;

    public void a(b.a aVar) {
        try {
            this.f13383a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            Cursor query = this.f13383a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            String a6 = a(query);
            if (aVar != null) {
                aVar.a(a6);
            }
            query.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public e(Context context) {
        this.f13383a = context;
    }

    private String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }
}

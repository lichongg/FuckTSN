package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private Context mContext;

    private static String getOaid(Cursor cursor) {
        String str;
        str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                str = getOaid(cursor);
                com.kwad.sdk.core.d.c.i("MeizuDeviceIDHelper", "getOAID oaid:" + str);
                return str;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    h.closeQuietly(cursor);
                    return str;
                } finally {
                    h.closeQuietly(cursor);
                }
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.i("MeizuDeviceIDHelper", "getOAID service not found;");
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    public f(Context context) {
        this.mContext = context;
    }
}

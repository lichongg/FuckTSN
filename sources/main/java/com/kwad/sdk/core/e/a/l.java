package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l {
    private Context mContext;

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                com.kwad.sdk.core.d.c.i("VivoDeviceIDHelper", "getOAID oaid:" + str);
            }
            return str;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.i("VivoDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return str;
        } finally {
            h.closeQuietly(cursor);
        }
    }

    public l(Context context) {
        this.mContext = context;
    }
}

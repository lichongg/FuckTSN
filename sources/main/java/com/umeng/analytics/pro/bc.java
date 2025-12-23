package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class bc implements av {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40952a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(f40952a), null, null, null, null);
        if (query != null) {
            r0 = query.moveToNext() ? query.getString(query.getColumnIndex("device_ids_grndid")) : null;
            query.close();
        }
        return r0;
    }

    bc() {
    }
}

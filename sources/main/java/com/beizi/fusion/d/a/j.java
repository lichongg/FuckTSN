package com.beizi.fusion.d.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private Context f13402b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13403c = false;

    /* renamed from: a, reason: collision with root package name */
    String f13401a = null;

    public String a() {
        Cursor query = this.f13402b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        }
        return r1;
    }

    public j(Context context) {
        this.f13402b = context;
    }
}

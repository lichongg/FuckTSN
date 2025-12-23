package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class i implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13519a;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f13519a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public i(Context context) {
        this.f13519a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13519a == null || bVar == null) {
            return;
        }
        try {
            Cursor query = this.f13519a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    com.beizi.fusion.sm.b.e.a("OAID query success: " + string);
                    bVar.a(string);
                    query.close();
                    return;
                }
                throw new com.beizi.fusion.sm.b.d("OAID query failed");
            } finally {
            }
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            bVar.a(e6);
        }
    }
}

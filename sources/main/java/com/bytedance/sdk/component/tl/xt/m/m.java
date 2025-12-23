package com.bytedance.sdk.component.tl.xt.m;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements up {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.j.up f26790j;
    private Context xt;

    public static String cw() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    public static String r() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }

    public static String xt() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)").toString();
    }

    @Override // com.bytedance.sdk.component.tl.xt.m.up
    public void delete(r rVar) {
        com.bytedance.sdk.component.tl.xt.j.j.xt.delete(this.xt, "trackurl", "id=?", new String[]{rVar.xt()}, this.f26790j);
    }

    @Override // com.bytedance.sdk.component.tl.xt.m.up
    public void insert(r rVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", rVar.xt());
        contentValues.put("url", rVar.cw());
        contentValues.put("replaceholder", Integer.valueOf(rVar.r() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(rVar.up()));
        contentValues.put(JThirdPlatFormInterface.KEY_EXTRA, com.bytedance.sdk.component.utils.j.xt(rVar.j().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.tl.xt.j.j.xt.insert(this.xt, "trackurl", contentValues, this.f26790j);
    }

    @Override // com.bytedance.sdk.component.tl.xt.m.up
    public List<r> j() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor query = com.bytedance.sdk.component.tl.xt.j.j.xt.query(this.xt, "trackurl", null, null, null, null, null, null, this.f26790j);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    try {
                        String string = query.getString(query.getColumnIndex("id"));
                        String string2 = query.getString(query.getColumnIndex("url"));
                        boolean z5 = query.getInt(query.getColumnIndex("replaceholder")) > 0;
                        int i6 = query.getInt(query.getColumnIndex("retry"));
                        String string3 = query.getString(query.getColumnIndex(JThirdPlatFormInterface.KEY_EXTRA));
                        int i7 = query.getInt(query.getColumnIndex("encrypt"));
                        if (i7 > 0) {
                            string3 = com.bytedance.sdk.component.utils.j.cw(string3);
                        }
                        try {
                            jSONObject = new JSONObject(string3);
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        linkedList.add(new r(string, string2, z5, i6, jSONObject, i7));
                    } catch (Throwable unused2) {
                    }
                } finally {
                    query.close();
                }
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.tl.xt.m.up
    public void update(r rVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", rVar.xt());
        contentValues.put("url", rVar.cw());
        contentValues.put("replaceholder", Integer.valueOf(rVar.r() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(rVar.up()));
        contentValues.put(JThirdPlatFormInterface.KEY_EXTRA, com.bytedance.sdk.component.utils.j.xt(rVar.j().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.tl.xt.j.j.xt.update(this.xt, "trackurl", contentValues, "id=?", new String[]{rVar.xt()}, this.f26790j);
    }

    public m(com.bytedance.sdk.component.tl.j.up upVar) {
        this.xt = upVar.getContext();
        this.f26790j = upVar;
    }
}

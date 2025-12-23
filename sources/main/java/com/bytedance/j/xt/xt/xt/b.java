package com.bytedance.j.xt.xt.xt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.j.xt.tl.i;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class b extends a<z0.a> {
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r1 = 0
            if (r11 == 0) goto L30
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto La
            goto L30
        La:
            java.lang.String r3 = r10.f24312b     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = "path=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Exception -> L26
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L26
            int r12 = r11.getCount()     // Catch: java.lang.Exception -> L26
            r11.close()     // Catch: java.lang.Exception -> L23
            goto L2c
        L23:
            r0 = move-exception
            r11 = r0
            goto L29
        L26:
            r0 = move-exception
            r11 = r0
            r12 = 0
        L29:
            com.bytedance.j.xt.tl.i.c(r11)
        L2c:
            if (r12 <= 0) goto L30
            r11 = 1
            return r11
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.j.xt.xt.xt.b.e(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    public b() {
        super("duplicatelog");
    }

    @Override // com.bytedance.j.xt.xt.xt.a
    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.j.xt.xt.xt.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ContentValues a(z0.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.f56786a);
        contentValues.put("insert_time", Long.valueOf(aVar.f56787b));
        return contentValues;
    }

    @Override // com.bytedance.j.xt.xt.xt.a
    public void insert(SQLiteDatabase sQLiteDatabase, z0.a aVar) {
        if (aVar == null || e(sQLiteDatabase, aVar.f56786a)) {
            return;
        }
        super.insert(sQLiteDatabase, (SQLiteDatabase) aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f24312b + " where _id in (select _id from " + this.f24312b + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e6) {
            i.c(e6);
        }
    }
}

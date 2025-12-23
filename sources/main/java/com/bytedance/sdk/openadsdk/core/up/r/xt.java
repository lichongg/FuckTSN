package com.bytedance.sdk.openadsdk.core.up.r;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.up.r.up;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements j {
    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, up.xt xtVar, boolean z5, long j6, up.j jVar) {
        if (jVar.cw() <= 0) {
            return;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (query != null) {
            if (jVar.cw() > 0 && query.getCount() >= jVar.cw()) {
                query.moveToFirst();
                com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "meta_cache", "rit=? AND uuid=?", new String[]{str, query.getString(query.getColumnIndex("uuid"))});
            }
            query.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("uuid", xtVar.up);
        contentValues.put("create_time", Long.valueOf(xtVar.f30891j));
        contentValues.put("meta_data", xtVar.cw);
        contentValues.put("save_version", Integer.valueOf(xtVar.f30892r));
        contentValues.put("expire_time", Long.valueOf(xtVar.xt));
        contentValues.put("slot_type", jVar.j());
        contentValues.put("is_using", Integer.valueOf(z5 ? 1 : 0));
        contentValues.put("priority", Long.valueOf(j6));
        com.bytedance.sdk.openadsdk.core.multipro.j.j.insert(v.getContext(), "meta_cache", contentValues);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.up.r.xt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f30893j;

        static {
            int[] iArr = new int[up.j.xt.values().length];
            f30893j = iArr;
            try {
                iArr[up.j.xt.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30893j[up.j.xt.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void xt(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.bytedance.sdk.openadsdk.core.multipro.j.j.update(v.getContext(), "meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public up.xt j(String str, up.j jVar, long j6) {
        String string;
        long j7;
        long j8;
        Cursor j9 = j(jVar, str);
        if (j9 == null) {
            return null;
        }
        do {
            try {
                if (!j9.moveToNext()) {
                    return null;
                }
                string = j9.getString(j9.getColumnIndex("meta_data"));
                j7 = j9.getLong(j9.getColumnIndex("create_time"));
                j8 = j9.getLong(j9.getColumnIndex("expire_time"));
                if (j6 <= 0) {
                    break;
                }
            } finally {
                j9.close();
            }
        } while (j7 < j6);
        up.xt xtVar = new up.xt(string, j7, j8, j9.getString(j9.getColumnIndex("uuid")));
        j9.close();
        return xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public up.xt j(String str, up.j jVar, long j6, List<String> list) {
        Cursor j7 = j(jVar, str);
        if (j7 == null) {
            return null;
        }
        while (j7.moveToNext()) {
            try {
                String string = j7.getString(j7.getColumnIndex("uuid"));
                if (string != null && list != null && list.contains(string)) {
                }
                up.xt xtVar = new up.xt(j7.getString(j7.getColumnIndex("meta_data")), j7.getLong(j7.getColumnIndex("create_time")), j7.getLong(j7.getColumnIndex("expire_time")), string);
                j7.close();
                return xtVar;
            } catch (Throwable th) {
                j7.close();
                throw th;
            }
        }
        j7.close();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str) {
        com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(up.j jVar) {
        com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "meta_cache", "slot_type =?", new String[]{jVar.j()});
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, up.j jVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (jVar.xt()) {
            com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "7012", String.valueOf(currentTimeMillis)});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(currentTimeMillis)});
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, String str2) {
        com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, String str2, boolean z5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z5));
        com.bytedance.sdk.openadsdk.core.multipro.j.j.update(v.getContext(), "meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    private Cursor j(up.j jVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = AnonymousClass1.f30893j[jVar.r().ordinal()];
        if (i6 == 1) {
            if (jVar.xt()) {
                return com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str, "7012"}, null, null, "create_time DESC");
            }
            return com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str}, null, null, "create_time DESC");
        }
        if (i6 != 2) {
            if (jVar.xt()) {
                return com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str, "7012"}, null, null, null);
            }
            return com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str}, null, null, null);
        }
        if (jVar.xt()) {
            return com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str, "7012"}, null, null, "priority DESC");
        }
        return com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str}, null, null, "priority DESC");
    }
}

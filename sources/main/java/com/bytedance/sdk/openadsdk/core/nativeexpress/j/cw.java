package com.bytedance.sdk.openadsdk.core.nativeexpress.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public static int f29661j = 20;
    private static volatile cw xt;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.j.cw.cw> up;
    private final Object cw = new Object();

    /* renamed from: r, reason: collision with root package name */
    private final LruCache<String, j> f29663r = new LruCache<String, j>(f29661j) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.cw.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, j jVar) {
            return 1;
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f29662m = new AtomicBoolean(false);

    private void cw(String str) {
        if (!TextUtils.isEmpty(str) && this.f29663r.size() > 0) {
            synchronized (this.cw) {
                this.f29663r.remove(str);
            }
        }
    }

    public static cw j() {
        if (xt == null) {
            synchronized (cw.class) {
                try {
                    if (xt == null) {
                        xt = new cw();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    List<j> xt() {
        boolean z5 = this.f29662m.get();
        this.f29662m.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "ugen_template", null, null, null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("id");
                        int columnIndex2 = query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                        int columnIndex3 = query.getColumnIndex("url");
                        int columnIndex4 = query.getColumnIndex("data");
                        int columnIndex5 = query.getColumnIndex("update_time");
                        if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                            int columnIndex6 = query.getColumnIndex("rit");
                            String string = columnIndex6 != -1 ? query.getString(columnIndex6) : null;
                            String string2 = query.getString(columnIndex);
                            String string3 = query.getString(columnIndex2);
                            String string4 = query.getString(columnIndex3);
                            j j6 = new j().j(string2).xt(string3).cw(string4).r(query.getString(columnIndex4)).up(string).j(Long.valueOf(query.getLong(columnIndex5)));
                            arrayList.add(j6);
                            synchronized (this.cw) {
                                this.f29663r.put(string2, j6);
                            }
                            if (!z5) {
                                if (this.up == null) {
                                    this.up = new ConcurrentHashMap<>();
                                }
                                if (string2 != null && !this.up.contains(string2)) {
                                    this.up.put(string2, new com.bytedance.sdk.component.adexpress.j.cw.cw(string, string2, string3));
                                }
                            }
                        }
                    } while (query.moveToNext());
                }
            } catch (Throwable th) {
                try {
                    vl.cw("UGTmplDbHelper", "getUgenTemplate error", th);
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }
        if (query != null) {
        }
        return arrayList;
    }

    private cw() {
    }

    public static String cw() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)").toString();
    }

    j j(String str, String str2) {
        j jVar;
        j j6;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.cw) {
            jVar = this.f29663r.get(str);
        }
        if (jVar != null) {
            if (TextUtils.equals(str2, jVar.xt())) {
                return jVar;
            }
            cw(str2);
            return null;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                do {
                    int columnIndex = query.getColumnIndex("id");
                    int columnIndex2 = query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                    int columnIndex3 = query.getColumnIndex("url");
                    int columnIndex4 = query.getColumnIndex("data");
                    int columnIndex5 = query.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = query.getColumnIndex("rit");
                        String string = query.getString(columnIndex);
                        String string2 = query.getString(columnIndex2);
                        String string3 = query.getString(columnIndex3);
                        String string4 = query.getString(columnIndex4);
                        j6 = new j().j(string).xt(string2).r(string4).cw(string3).up(columnIndex6 != -1 ? query.getString(columnIndex6) : null).j(Long.valueOf(query.getLong(columnIndex5)));
                        synchronized (this.cw) {
                            this.f29663r.put(string, j6);
                        }
                    }
                    return null;
                } while (query.moveToNext());
                return j6;
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    void xt(String str) {
        com.bytedance.sdk.component.adexpress.j.cw.cw cwVar;
        try {
            if (this.up != null && !this.up.isEmpty() && (cwVar = this.up.get(str)) != null) {
                String j6 = cwVar.j();
                if (!TextUtils.isEmpty(j6)) {
                    com.bytedance.sdk.openadsdk.core.cw.xt.j().delete(j6, str, true);
                }
                this.up.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    void j(j jVar, boolean z5) {
        if (jVar == null || TextUtils.isEmpty(jVar.j())) {
            return;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "ugen_template", null, "id=?", new String[]{jVar.j()}, null, null, null);
        boolean z6 = query != null && query.getCount() > 0;
        if (z6) {
            try {
                r3 = query.moveToFirst() ? query.getString(query.getColumnIndex("rit")) : null;
                query.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", jVar.j());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, jVar.xt());
        contentValues.put("url", jVar.cw());
        contentValues.put("data", jVar.up());
        contentValues.put("rit", jVar.m());
        contentValues.put("update_time", jVar.r());
        if (z6) {
            com.bytedance.sdk.openadsdk.core.multipro.j.j.update(v.getContext(), "ugen_template", contentValues, "id=?", new String[]{jVar.j()});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.j.j.insert(v.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.cw) {
            this.f29663r.put(jVar.j(), jVar);
        }
        if (z5) {
            return;
        }
        try {
            if (this.up == null) {
                this.up = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.j.cw.cw cwVar = new com.bytedance.sdk.component.adexpress.j.cw.cw(jVar.m(), jVar.j(), jVar.xt());
            this.up.put(jVar.j(), cwVar);
            if (r3 != null) {
                com.bytedance.sdk.openadsdk.core.cw.xt.j().delete(r3, cwVar.xt(), true);
            }
            com.bytedance.sdk.openadsdk.core.cw.xt.j().update(jVar.m(), cwVar, true);
        } catch (Throwable unused2) {
        }
    }

    Set<j> j(String str) {
        j jVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("id");
                        if (columnIndex != -1) {
                            String string = query.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.cw) {
                                    jVar = this.f29663r.get(string);
                                }
                                if (jVar != null) {
                                    hashSet.add(jVar);
                                } else {
                                    j jVar2 = new j();
                                    int columnIndex2 = query.getColumnIndex("data");
                                    if (columnIndex2 != -1) {
                                        String string2 = query.getString(columnIndex2);
                                        if (!TextUtils.isEmpty(string2)) {
                                            jVar2.r(string2);
                                            jVar2.j(string);
                                            jVar2.up(str);
                                            int columnIndex3 = query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                                            int columnIndex4 = query.getColumnIndex("url");
                                            int columnIndex5 = query.getColumnIndex("update_time");
                                            if (columnIndex3 != -1) {
                                                jVar2.xt(query.getString(columnIndex3));
                                            }
                                            if (columnIndex4 != -1) {
                                                jVar2.cw(query.getString(columnIndex4));
                                            }
                                            if (columnIndex5 != -1) {
                                                jVar2.j(Long.valueOf(query.getLong(columnIndex5)));
                                            }
                                            hashSet.add(jVar2);
                                            synchronized (this.cw) {
                                                this.f29663r.put(string, jVar2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } while (query.moveToNext());
                }
            } catch (Throwable th) {
                try {
                    vl.cw("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
                    return hashSet;
                } finally {
                    query.close();
                }
            }
        }
        if (query != null) {
        }
        return hashSet;
    }

    void j(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i6 = 0; i6 < strArr.length; i6++) {
                cw(strArr[i6]);
                com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "ugen_template", "id=?", new String[]{strArr[i6]});
                xt(strArr[i6]);
            }
        }
    }
}

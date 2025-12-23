package com.bytedance.sdk.component.adexpress.j.xt;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.vl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    public static int f25826j = 2000;
    private static volatile m xt;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.j.cw.cw> up;

    /* renamed from: r, reason: collision with root package name */
    private final Object f25828r = new Object();

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f25827m = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.j.cw.xt> ae = new LruCache<String, com.bytedance.sdk.component.adexpress.j.cw.xt>(f25826j) { // from class: com.bytedance.sdk.component.adexpress.j.xt.m.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.j.cw.xt xtVar) {
            return 1;
        }
    };
    private Set<String> cw = Collections.synchronizedSet(new HashSet());

    public static m j() {
        if (xt == null) {
            synchronized (m.class) {
                try {
                    if (xt == null) {
                        xt = new m();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    void cw(String str) {
        com.bytedance.sdk.component.adexpress.j.cw.cw cwVar;
        try {
            if (this.up != null && !this.up.isEmpty() && (cwVar = this.up.get(str)) != null) {
                String j6 = cwVar.j();
                if (!TextUtils.isEmpty(j6) && com.bytedance.sdk.component.adexpress.j.j.j.j().m() != null) {
                    com.bytedance.sdk.component.adexpress.j.j.j.j().m().delete(j6, str);
                }
                this.up.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    Set<com.bytedance.sdk.component.adexpress.j.cw.xt> xt(String str) {
        com.bytedance.sdk.component.adexpress.j.cw.xt xtVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.j.j.j.j().xt() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor query = com.bytedance.sdk.component.adexpress.j.j.j.j().xt().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("id"));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.f25828r) {
                                xtVar = this.ae.get(string);
                            }
                            if (xtVar != null) {
                                hashSet.add(xtVar);
                            } else {
                                String string2 = query.getString(query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                                String string3 = query.getString(query.getColumnIndex("url"));
                                String string4 = query.getString(query.getColumnIndex("data"));
                                String string5 = query.getString(query.getColumnIndex("version"));
                                com.bytedance.sdk.component.adexpress.j.cw.xt j6 = new com.bytedance.sdk.component.adexpress.j.cw.xt().j(str).xt(string).cw(string2).r(string3).up(string4).m(string5).j(Long.valueOf(query.getLong(query.getColumnIndex("update_time"))));
                                hashSet.add(j6);
                                synchronized (this.f25828r) {
                                    this.ae.put(string, j6);
                                }
                                this.cw.add(string);
                            }
                        }
                    } while (query.moveToNext());
                }
                query.close();
                return hashSet;
            } catch (Exception unused) {
                query.close();
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        return hashSet;
    }

    private m() {
    }

    private void r(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.j.cw.xt> lruCache;
        if (!TextUtils.isEmpty(str) && (lruCache = this.ae) != null && lruCache.size() > 0) {
            synchronized (this.f25828r) {
                this.ae.remove(str);
            }
        }
    }

    public static String cw() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)").toString();
    }

    com.bytedance.sdk.component.adexpress.j.cw.xt j(String str) {
        com.bytedance.sdk.component.adexpress.j.cw.xt xtVar;
        com.bytedance.sdk.component.adexpress.j.cw.xt j6;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.j.j.j.j().xt() == null) {
            return null;
        }
        synchronized (this.f25828r) {
            xtVar = this.ae.get(String.valueOf(str));
        }
        if (xtVar != null) {
            return xtVar;
        }
        Cursor query = com.bytedance.sdk.component.adexpress.j.j.j.j().xt().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("rit"));
                        String string2 = query.getString(query.getColumnIndex("id"));
                        String string3 = query.getString(query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                        String string4 = query.getString(query.getColumnIndex("url"));
                        String string5 = query.getString(query.getColumnIndex("data"));
                        String string6 = query.getString(query.getColumnIndex("version"));
                        j6 = new com.bytedance.sdk.component.adexpress.j.cw.xt().j(string).xt(string2).cw(string3).r(string4).up(string5).m(string6).j(Long.valueOf(query.getLong(query.getColumnIndex("update_time"))));
                        synchronized (this.f25828r) {
                            this.ae.put(string2, j6);
                        }
                        this.cw.add(string2);
                    } while (query.moveToNext());
                    return j6;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    List<com.bytedance.sdk.component.adexpress.j.cw.xt> xt() {
        if (com.bytedance.sdk.component.adexpress.j.j.j.j().xt() == null) {
            return null;
        }
        boolean z5 = this.f25827m.get();
        this.f25827m.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor query = com.bytedance.sdk.component.adexpress.j.j.j.j().xt().query("template_diff_new", null, null, null, null, null, null);
        if (query == null) {
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                String string = query.getString(query.getColumnIndex("rit"));
                String string2 = query.getString(query.getColumnIndex("id"));
                String string3 = query.getString(query.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                String string4 = query.getString(query.getColumnIndex("url"));
                String string5 = query.getString(query.getColumnIndex("data"));
                String string6 = query.getString(query.getColumnIndex("version"));
                arrayList.add(new com.bytedance.sdk.component.adexpress.j.cw.xt().j(string).xt(string2).cw(string3).r(string4).up(string5).m(string6).j(Long.valueOf(query.getLong(query.getColumnIndex("update_time")))));
                synchronized (this.f25828r) {
                    this.ae.put(string2, arrayList.get(arrayList.size() - 1));
                }
                this.cw.add(string2);
                if (!z5 && com.bytedance.sdk.component.adexpress.j.j.j.j().m() != null) {
                    if (this.up == null) {
                        this.up = new ConcurrentHashMap<>();
                    }
                    if (string2 != null && !this.up.contains(string2)) {
                        this.up.put(string2, new com.bytedance.sdk.component.adexpress.j.cw.cw(string, string2, string3));
                    }
                }
            } catch (Throwable th) {
                try {
                    vl.cw("TmplDbHelper", "getTemplate error", th);
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }
        return arrayList;
    }

    void j(com.bytedance.sdk.component.adexpress.j.cw.xt xtVar, boolean z5) {
        if (xtVar == null || com.bytedance.sdk.component.adexpress.j.j.j.j().xt() == null || TextUtils.isEmpty(xtVar.xt())) {
            return;
        }
        Cursor query = com.bytedance.sdk.component.adexpress.j.j.j.j().xt().query("template_diff_new", null, "id=?", new String[]{xtVar.xt()}, null, null, null);
        boolean z6 = query != null && query.getCount() > 0;
        if (query != null) {
            try {
                r2 = query.moveToFirst() ? query.getString(query.getColumnIndex("rit")) : null;
                query.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", xtVar.j());
        contentValues.put("id", xtVar.xt());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, xtVar.cw());
        contentValues.put("url", xtVar.r());
        contentValues.put("data", xtVar.up());
        contentValues.put("version", xtVar.m());
        contentValues.put("update_time", xtVar.ae());
        if (z6) {
            com.bytedance.sdk.component.adexpress.j.j.j.j().xt().update("template_diff_new", contentValues, "id=?", new String[]{xtVar.xt()});
        } else {
            com.bytedance.sdk.component.adexpress.j.j.j.j().xt().insert("template_diff_new", contentValues);
        }
        synchronized (this.f25828r) {
            this.ae.put(xtVar.xt(), xtVar);
        }
        this.cw.add(xtVar.xt());
        if (z5) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.j.j.j.j().m() == null) {
                return;
            }
            if (this.up == null) {
                this.up = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.j.cw.cw cwVar = new com.bytedance.sdk.component.adexpress.j.cw.cw(xtVar.j(), xtVar.xt(), xtVar.cw());
            this.up.put(xtVar.xt(), cwVar);
            if (r2 != null) {
                com.bytedance.sdk.component.adexpress.j.j.j.j().m().delete(r2, cwVar.xt());
            }
            com.bytedance.sdk.component.adexpress.j.j.j.j().m().update(xtVar.j(), cwVar);
        } catch (Throwable unused2) {
        }
    }

    void j(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.j.j.j.j().xt() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i6 = 0; i6 < strArr.length; i6++) {
                r(strArr[i6]);
                com.bytedance.sdk.component.adexpress.j.j.j.j().xt().delete("template_diff_new", "id=?", new String[]{strArr[i6]});
                cw(strArr[i6]);
            }
        }
    }
}

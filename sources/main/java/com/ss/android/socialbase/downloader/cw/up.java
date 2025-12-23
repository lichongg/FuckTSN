package com.ss.android.socialbase.downloader.cw;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.cw.cw;
import com.ss.android.socialbase.downloader.downloader.tj;
import com.ss.android.socialbase.downloader.qv.g;
import com.umeng.analytics.pro.bm;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes6.dex */
public class up extends cw.j implements tj {
    private static volatile SQLiteDatabase xt;
    private ae cw;

    /* renamed from: j, reason: collision with root package name */
    xt f38706j;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f38707m;

    /* renamed from: r, reason: collision with root package name */
    private ae f38708r;
    private ae up;

    public up() {
        this(false);
    }

    private void g() {
        xt.beginTransaction();
    }

    private void oq() {
        try {
            if (xt == null || !xt.inTransaction()) {
                return;
            }
            xt.endTransaction();
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void qv() {
        try {
            g();
            xt.delete("downloader", null, null);
            xt.delete("downloadChunk", null, null);
            xt.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                vl.j(th);
            } finally {
                oq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        if (xt == null) {
            synchronized (up.class) {
                try {
                    if (xt == null) {
                        xt = j.j().getWritableDatabase();
                        this.cw = new ae(xt, "downloader", com.ss.android.socialbase.downloader.xt.cw.f39023j, com.ss.android.socialbase.downloader.xt.cw.xt);
                        this.f38708r = new ae(xt, "downloadChunk", com.ss.android.socialbase.downloader.xt.cw.cw, com.ss.android.socialbase.downloader.xt.cw.f39025r);
                        this.up = new ae(xt, "segments", com.ss.android.socialbase.downloader.xt.cw.up, com.ss.android.socialbase.downloader.xt.cw.f39024m);
                    }
                } catch (Throwable th) {
                    vl.j(th);
                } finally {
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw ae(int i6) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public boolean up() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public List<com.ss.android.socialbase.downloader.ae.cw> xt() {
        return null;
    }

    public up(boolean z5) {
        this.f38706j = null;
        if (z5) {
            this.f38707m = false;
            j();
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw g(int i6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 1);
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public boolean m(final int i6) {
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.11
            @Override // java.lang.Runnable
            public void run() {
                up.this.up(i6);
                up.this.r(i6);
                up.this.jy(i6);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public boolean up(int i6) {
        ae aeVar;
        tl();
        if (xt != null && (aeVar = this.cw) != null) {
            try {
                j(i6, aeVar.xt());
                return true;
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        return null;
    }

    private void update(final int i6, final ContentValues contentValues) {
        tl();
        if (xt == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.3
            @Override // java.lang.Runnable
            public void run() {
                up.this.j(i6, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public List<com.ss.android.socialbase.downloader.ae.xt> cw(int i6) {
        ArrayList arrayList = new ArrayList();
        tl();
        if (xt == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            cursor = xt.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", bm.f41039d), new String[]{Integer.toString(i6)});
            while (cursor.moveToNext()) {
                arrayList.add(new com.ss.android.socialbase.downloader.ae.xt(cursor));
            }
            com.ss.android.socialbase.downloader.az.m.j(cursor);
            return arrayList;
        } catch (Throwable th) {
            try {
                vl.j(th);
                com.ss.android.socialbase.downloader.az.m.j(cursor);
                return arrayList;
            } catch (Throwable th2) {
                com.ss.android.socialbase.downloader.az.m.j(cursor);
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void jy(int i6) {
        tl();
        if (xt == null) {
            return;
        }
        try {
            j(i6, this.up.xt());
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void r(final int i6) {
        tl();
        if (xt == null || this.f38708r == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up.this.j(i6, up.this.f38708r.xt());
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public Map<Long, g> vl(int i6) {
        Cursor cursor;
        String str;
        tl();
        if (xt != null) {
            try {
                try {
                    cursor = xt.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", bm.f41039d), new String[]{Integer.toString(i6)});
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    try {
                        vl.j(th);
                        com.ss.android.socialbase.downloader.az.m.j(cursor);
                        return null;
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.az.m.j(cursor);
                        throw th2;
                    }
                }
                try {
                    if (cursor.moveToNext()) {
                        int columnIndex = cursor.getColumnIndex("info");
                        if (columnIndex >= 0) {
                            str = cursor.getString(columnIndex);
                        } else {
                            str = null;
                        }
                        HashMap hashMap = new HashMap();
                        JSONArray jSONArray = new JSONArray(str);
                        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                            g gVar = new g(jSONArray.getJSONObject(i7));
                            hashMap.put(Long.valueOf(gVar.cw()), gVar);
                        }
                        com.ss.android.socialbase.downloader.az.m.j(cursor);
                        return hashMap;
                    }
                    com.ss.android.socialbase.downloader.az.m.j(cursor);
                } catch (Throwable th3) {
                    th = th3;
                    vl.j(th);
                    com.ss.android.socialbase.downloader.az.m.j(cursor);
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw oq(int i6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-7));
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw xt(int i6) {
        Cursor cursor;
        tl();
        if (xt != null) {
            try {
                try {
                    cursor = xt.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", bm.f41039d), new String[]{Integer.toString(i6)});
                    try {
                        if (cursor.moveToNext()) {
                            com.ss.android.socialbase.downloader.ae.cw cwVar = new com.ss.android.socialbase.downloader.ae.cw(cursor);
                            com.ss.android.socialbase.downloader.az.m.j(cursor);
                            return cwVar;
                        }
                        com.ss.android.socialbase.downloader.az.m.j(cursor);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            vl.j(th);
                            com.ss.android.socialbase.downloader.az.m.j(cursor);
                            return null;
                        } catch (Throwable th2) {
                            com.ss.android.socialbase.downloader.az.m.j(cursor);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                    vl.j(th);
                    com.ss.android.socialbase.downloader.az.m.j(cursor);
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        try {
            if (!j(cwVar.ae())) {
                cw(cwVar);
                return;
            }
            ae aeVar = this.cw;
            if (aeVar == null) {
                return;
            }
            try {
                xt(cwVar, aeVar.cw());
            } catch (Throwable th) {
                vl.j(th);
            }
        } catch (Throwable th2) {
            vl.j(th2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw up(int i6, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j6));
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw tl(int i6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    /* renamed from: qv, reason: merged with bridge method [inline-methods] */
    public ArrayList<g> ws(int i6) {
        Map<Long, g> vl = vl(i6);
        if (vl == null || vl.isEmpty()) {
            return null;
        }
        return new ArrayList<>(vl.values());
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void j() {
        j(new SparseArray<>(), new SparseArray<>(), (r) null);
    }

    private void cw(final com.ss.android.socialbase.downloader.ae.cw cwVar) {
        tl();
        if (xt == null || this.cw == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up upVar = up.this;
                    upVar.j(cwVar, upVar.cw.j());
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tj
    public void j(final SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> sparseArray2, final r rVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.1
                /* JADX WARN: Code restructure failed: missing block: B:140:0x027e, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:146:0x0287, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:185:0x0342, code lost:
                
                    if (r0 == null) goto L170;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:186:0x0344, code lost:
                
                    r0.j();
                    r18.f38710r.f38707m = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:187:0x034c, code lost:
                
                    r18.f38710r.j(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:188:0x035e, code lost:
                
                    throw r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:194:0x035b, code lost:
                
                    if (r0 == null) goto L170;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:89:0x01aa, code lost:
                
                    if (r0 != null) goto L85;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x01ac, code lost:
                
                    r0.j();
                    r18.f38710r.f38707m = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:91:0x01b4, code lost:
                
                    r18.f38710r.j(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:92:0x01bd, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01c3, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Removed duplicated region for block: B:34:0x00dd A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 888
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.cw.up.AnonymousClass1.run():void");
                }
            };
            ExecutorService i6 = com.ss.android.socialbase.downloader.downloader.cw.i();
            if (i6 != null) {
                i6.execute(runnable);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void xt(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        j(xtVar);
    }

    private void xt(com.ss.android.socialbase.downloader.ae.cw cwVar, SQLiteStatement sQLiteStatement) {
        if (cwVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                cwVar.j(sQLiteStatement);
                sQLiteStatement.bindLong(cwVar.m() + 1, cwVar.ae());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw r(int i6, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j6));
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void cw() {
        tl();
        if (xt == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.2
            @Override // java.lang.Runnable
            public void run() {
                up.this.qv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<com.ss.android.socialbase.downloader.ae.cw> list) {
        if (list == null) {
            return;
        }
        try {
            for (com.ss.android.socialbase.downloader.ae.cw cwVar : list) {
                if (cwVar != null && cwVar.ag()) {
                    com.ss.android.socialbase.downloader.az.m.xt(cwVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw cw(int i6, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j6));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public boolean r() {
        return this.f38707m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<com.ss.android.socialbase.downloader.ae.cw> list, List<Integer> list2, SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray, SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || xt == null) {
            return;
        }
        synchronized (xt) {
            try {
                g();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.jy.j.cw().j("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i6 = 0; i6 < list.size(); i6++) {
                            strArr[i6] = String.valueOf(list.get(i6));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        xt.delete("downloader", str, strArr);
                        xt.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(", ", list2);
                        xt.delete("downloader", "_id IN (?)", new String[]{join});
                        xt.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i7 = 0; i7 < size; i7++) {
                    int keyAt = sparseArray.keyAt(i7);
                    com.ss.android.socialbase.downloader.ae.cw cwVar = sparseArray.get(keyAt);
                    xt.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    xt.insert("downloader", null, cwVar.up());
                    if (cwVar.kj() > 1) {
                        List<com.ss.android.socialbase.downloader.ae.xt> cw = cw(keyAt);
                        if (cw.size() > 0) {
                            xt.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.ae.xt xtVar : cw) {
                                xtVar.xt(cwVar.ae());
                                xt.insert("downloadChunk", null, xtVar.j());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        int ae = sparseArray2.valueAt(i8).ae();
                        List<com.ss.android.socialbase.downloader.ae.xt> j6 = com.ss.android.socialbase.downloader.az.m.j(cw(ae));
                        if (j6 != null && j6.size() > 0) {
                            sparseArray3.put(ae, j6);
                        }
                    }
                }
                xt.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw xt(int i6, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j6));
        if (j6 > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        try {
            r(i6);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.ae.xt xtVar : list) {
                    if (xtVar != null) {
                        j(xtVar);
                        if (xtVar.m()) {
                            Iterator<com.ss.android.socialbase.downloader.ae.xt> it = xtVar.ae().iterator();
                            while (it.hasNext()) {
                                j(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public boolean j(int i6) {
        try {
            return xt(i6) != null;
        } catch (Throwable th) {
            vl.j(th);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        tl();
        ArrayList arrayList = new ArrayList();
        if (xt == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            cursor = xt.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
            if (cursor.moveToNext()) {
                arrayList.add(new com.ss.android.socialbase.downloader.ae.cw(cursor));
            }
            com.ss.android.socialbase.downloader.az.m.j(cursor);
            return arrayList;
        } catch (Throwable th) {
            try {
                vl.j(th);
                com.ss.android.socialbase.downloader.az.m.j(cursor);
                return arrayList;
            } catch (Throwable th2) {
                com.ss.android.socialbase.downloader.az.m.j(cursor);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i6);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void j(final com.ss.android.socialbase.downloader.ae.xt xtVar) {
        tl();
        if (xt == null || this.f38708r == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up.this.j(xtVar, up.this.f38708r.j());
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, SQLiteStatement sQLiteStatement) {
        if (cwVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                cwVar.j(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.ss.android.socialbase.downloader.ae.xt xtVar, SQLiteStatement sQLiteStatement) {
        if (xtVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                xtVar.j(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void j(final int i6, final int i7, final long j6) {
        tl();
        if (i6 == 0 || i7 < 0 || j6 < 0 || xt == null || this.f38708r == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up.this.j(i6, i7, j6, up.this.f38708r.cw());
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void j(final int i6, final int i7, final int i8, final long j6) {
        tl();
        if (i6 == 0 || i7 < 0 || i8 < 0 || j6 < 0 || xt == null || this.f38708r == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up.this.j(i6, i7, i8, j6, up.this.f38708r.cw());
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void j(final int i6, final int i7, final int i8, final int i9) {
        tl();
        if (i6 == 0 || i8 < 0 || i9 == i7 || i9 < 0 || xt == null || this.f38708r == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up.this.j(i6, i7, i8, i9, up.this.f38708r.cw());
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, int i7, int i8, int i9, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i9));
                xt.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i6), Integer.toString(i7), Integer.toString(i8)});
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, int i7, long j6, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j6));
                xt.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i6), Integer.toString(i7)});
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, int i7, int i8, long j6, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j6));
                xt.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i6), Integer.toString(i7), Integer.toString(i8)});
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, int i7) {
        tl();
        if (xt == null) {
            return null;
        }
        int i8 = 10;
        while (xt.isDbLockedByCurrentThread() && i8 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    vl.j(th);
                }
            } catch (Throwable th2) {
                vl.j(th2);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i7));
        xt.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i6)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public boolean j(final com.ss.android.socialbase.downloader.ae.cw cwVar) {
        tl();
        if (cwVar == null || xt == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.cw.cw(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.up.10
            @Override // java.lang.Runnable
            public void run() {
                up.this.r(cwVar);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j6));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put(CommonNetImpl.NAME, str2);
        }
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j6));
        update(i6, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean j(int i6, Map<Long, g> map) {
        long currentTimeMillis = System.currentTimeMillis();
        tl();
        if (xt == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l6 : map.keySet()) {
                l6.longValue();
                jSONArray.put(map.get(l6).qv());
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        SQLiteStatement r5 = this.up.r();
        synchronized (r5) {
            r5.clearBindings();
            r5.bindLong(1, i6);
            r5.bindString(2, jSONArray.toString());
            r5.execute();
        }
        com.ss.android.socialbase.downloader.m.j.xt("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.az.m.cw(currentTimeMillis));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, ContentValues contentValues) {
        int i7 = 10;
        while (xt.isDbLockedByCurrentThread() && i7 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    vl.j(th);
                }
            } catch (Throwable th2) {
                vl.j(th2);
                return;
            }
        }
        try {
            xt.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i6)});
        } catch (Throwable th3) {
            vl.j(th3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.cw.cw
    public void j(xt xtVar) {
        this.f38706j = xtVar;
    }

    public void j(SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> sparseArray2) {
        try {
            HashMap j6 = com.ss.android.socialbase.downloader.az.m.j(sparseArray);
            HashMap j7 = com.ss.android.socialbase.downloader.az.m.j(sparseArray2);
            xt xtVar = this.f38706j;
            if (xtVar != null) {
                xtVar.j(j6, j7);
            }
        } catch (Throwable unused) {
        }
    }
}

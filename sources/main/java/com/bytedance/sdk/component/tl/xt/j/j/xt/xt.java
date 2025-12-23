package com.bytedance.sdk.component.tl.xt.j.j.xt;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt extends com.bytedance.sdk.component.tl.xt.j.j implements cw {
    private com.bytedance.sdk.component.tl.j.up cw;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.r.xt.j f26775r;
    private final Context xt;

    /* renamed from: j, reason: collision with root package name */
    protected final List<com.bytedance.sdk.component.tl.j.xt> f26773j = new ArrayList();
    private boolean up = false;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f26774m = new Runnable() { // from class: com.bytedance.sdk.component.tl.xt.j.j.xt.xt.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (xt.this) {
                try {
                    if (xt.this.f26773j.isEmpty()) {
                        xt.this.up = false;
                        return;
                    }
                    ArrayList arrayList = new ArrayList(xt.this.f26773j);
                    xt.this.f26773j.clear();
                    xt.this.up = false;
                    xt.this.xt(arrayList);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    private void xt() {
        if (this.up) {
            return;
        }
        com.bytedance.sdk.component.tl.xt.ae.j.j(r()).j().postDelayed(this.f26774m, r0.xt());
        this.up = true;
    }

    public abstract String j();

    abstract com.bytedance.sdk.component.tl.j.up r();

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
    
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int up() {
        /*
            r11 = this;
            r1 = 0
            r0 = 0
            android.content.Context r2 = r11.getContext()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.lang.String r3 = r11.j()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            com.bytedance.sdk.component.tl.j.up r10 = r11.cw     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.tl.xt.j.j.xt.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            if (r1 == 0) goto L29
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            goto L29
        L25:
            r0 = move-exception
            goto L2f
        L27:
            goto L35
        L29:
            if (r1 == 0) goto L38
        L2b:
            r1.close()     // Catch: java.lang.Exception -> L38
            goto L38
        L2f:
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.lang.Exception -> L34
        L34:
            throw r0
        L35:
            if (r1 == 0) goto L38
            goto L2b
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.j.j.xt.xt.up():int");
    }

    public Context getContext() {
        return this.xt;
    }

    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, int i7, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5) {
        int xt;
        if (this.f26775r == null || xtVar == null || !com.bytedance.sdk.component.tl.xt.cw.j.j(i6) || !j(xtVar) || (xt = this.f26775r.xt()) <= i7) {
            return null;
        }
        return j(xt - i7, bm.f41039d, i6, z5);
    }

    public xt(Context context, com.bytedance.sdk.component.tl.j.up upVar, com.bytedance.sdk.component.tl.xt.r.xt.j jVar) {
        this.xt = context;
        this.cw = upVar;
        this.f26775r = jVar;
    }

    public synchronized void xt(com.bytedance.sdk.component.tl.j.xt xtVar) {
        if (j(xtVar) && xtVar.ae() != null && !TextUtils.isEmpty(xtVar.cw())) {
            this.f26773j.add(xtVar);
            xt();
        }
    }

    public com.bytedance.sdk.component.tl.xt.j.xt j(int i6, List<com.bytedance.sdk.component.tl.j.xt> list) {
        com.bytedance.sdk.component.tl.xt.j.xt xtVar = new com.bytedance.sdk.component.tl.xt.j.xt();
        if (list != null && list.size() != 0 && list.get(0) != null && j(list.get(0))) {
            if (i6 != 200 && i6 != -1 && i6 != -3) {
                xtVar.j("code:".concat(String.valueOf(i6)));
            } else {
                xtVar.j(delete(list));
            }
            xtVar.j(true);
            return xtVar;
        }
        xtVar.j(false);
        return xtVar;
    }

    public void xt(List<com.bytedance.sdk.component.tl.j.xt> list) {
        com.bytedance.sdk.component.tl.xt.j.j.xt.insert(getContext(), j(), list, this.cw);
        Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.tl.xt.cw.j.j(it.next(), this.cw, "_db");
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public List<com.bytedance.sdk.component.tl.j.xt> xt(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, List<String> list, String str) {
        List<com.bytedance.sdk.component.tl.j.xt> j6 = j(bm.f41039d, i6, z5);
        if (!j(j6, list)) {
            return null;
        }
        j();
        j6.size();
        return j6;
    }

    protected void j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.tl.j.xt> it = this.f26773j.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.tl.j.xt next = it.next();
                if (next != null) {
                    String cw = next.cw();
                    if (!TextUtils.isEmpty(cw) && list.contains(cw)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.j("DBInsertMemRepo", j() + "deleteMemList: " + th.getMessage(), this.cw.up());
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public boolean xt(int i6, String str, com.bytedance.sdk.component.tl.j.xt xtVar) {
        if (this.f26775r == null) {
            return false;
        }
        int up = up();
        int j6 = this.f26775r.j();
        com.bytedance.sdk.component.tl.xt.cw.cw.j("check db " + j() + " count:" + up + " MaxCacheCount:" + j6 + " message:" + com.bytedance.sdk.component.tl.xt.cw.j.xt(i6), this.cw);
        return up >= j6;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public boolean j(String str) {
        if (this.f26775r == null) {
            return false;
        }
        int up = up();
        com.bytedance.sdk.component.tl.xt.cw.cw.j("check flush db " + j() + " count:" + up, this.cw);
        return up > 0;
    }

    private boolean j(List<com.bytedance.sdk.component.tl.j.xt> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.tl.j.xt next = it.next();
                    if (next != null) {
                        String cw = next.cw();
                        if (!TextUtils.isEmpty(cw) && list2.contains(cw)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.tl.xt.cw.cw.j("DBInsertMemRepo", "deleteMemList: " + th.getMessage(), this.cw);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}

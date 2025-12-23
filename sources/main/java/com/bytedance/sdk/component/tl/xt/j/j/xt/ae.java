package com.bytedance.sdk.component.tl.xt.j.j.xt;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import xyz.adscope.common.v2.persistent.db.IBaseDbHelper;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends xt {
    protected List<String> cw;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.r.xt.j f26771r;
    protected com.bytedance.sdk.component.tl.j.up xt;

    public byte cw() {
        return (byte) 2;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j
    public boolean j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return com.bytedance.sdk.component.tl.xt.cw.j.r(xtVar);
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.xt
    com.bytedance.sdk.component.tl.j.up r() {
        return this.xt;
    }

    public byte xt() {
        return (byte) 1;
    }

    public ae(Context context, com.bytedance.sdk.component.tl.xt.r.xt.j jVar, com.bytedance.sdk.component.tl.j.up upVar) {
        super(context, upVar, jVar == null ? com.bytedance.sdk.component.tl.xt.r.xt.j.cw() : jVar);
        this.cw = new ArrayList();
        this.f26771r = jVar;
        this.xt = upVar;
        if (jVar == null) {
            this.f26771r = com.bytedance.sdk.component.tl.xt.r.xt.j.cw();
        }
    }

    private void r(List<com.bytedance.sdk.component.tl.j.xt> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().cw());
        }
        com.bytedance.sdk.component.tl.xt.j.j.xt.j(getContext(), "UPDATE " + j() + " SET retry = retry+1 WHERE " + j("id", (List<?>) linkedList, 1000, true), this.xt);
    }

    public static String up(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    protected void cw(List<String> list) {
        j();
        list.size();
        com.bytedance.sdk.component.tl.xt.j.j.xt.j(getContext(), "DELETE FROM " + j() + " WHERE " + j("id", (List<?>) list, 1000, true), this.xt);
        com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.az(), list.size(), this.xt);
        j(list);
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.cw
    public String delete(List<com.bytedance.sdk.component.tl.j.xt> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().cw());
        }
        com.bytedance.sdk.component.tl.xt.cw.j.j(list, this.xt, j());
        String j6 = com.bytedance.sdk.component.tl.xt.j.j.xt.j(getContext(), "DELETE FROM " + j() + " WHERE " + j("id", (List<?>) linkedList, 1000, true), this.xt);
        j(linkedList);
        return j6;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.xt
    public String j() {
        return this.xt.xt().r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b6, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00bf, code lost:
    
        if (r11.cw.isEmpty() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c1, code lost:
    
        cw(r11.cw);
        r11.cw.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00cf, code lost:
    
        if (com.bytedance.sdk.component.tl.xt.cw.j.j(r14) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d1, code lost:
    
        if (r15 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00d3, code lost:
    
        j(r12, 5, com.baidu.mobads.sdk.internal.bn.f10748d);
     */
    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.cw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.bytedance.sdk.component.tl.j.xt> j(int r12, java.lang.String r13, int r14, boolean r15) {
        /*
            r11 = this;
            android.content.Context r0 = r11.getContext()
            com.bytedance.sdk.component.tl.j.up r1 = r11.xt
            long r0 = com.bytedance.sdk.component.tl.xt.xt.j.j(r12, r0, r1)
            r2 = 0
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 <= 0) goto L18
            r2 = 100
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 <= 0) goto L1a
            r0 = r2
            goto L1a
        L18:
            r0 = 1
        L1a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r13)
            java.lang.String r13 = " DESC limit "
            r12.append(r13)
            r12.append(r0)
            java.lang.String r9 = r12.toString()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List<java.lang.String> r13 = r11.cw
            r13.clear()
            android.content.Context r2 = r11.getContext()
            java.lang.String r3 = r11.j()
            java.lang.String r13 = "id"
            java.lang.String r0 = "value"
            java.lang.String r1 = "encrypt"
            java.lang.String[] r4 = new java.lang.String[]{r13, r0, r1}
            r8 = 0
            com.bytedance.sdk.component.tl.j.up r10 = r11.xt
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r2 = com.bytedance.sdk.component.tl.xt.j.j.xt.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r2 == 0) goto Lfa
        L56:
            r3 = 604800000(0x240c8400, double:2.988109026E-315)
            r5 = 5
            boolean r6 = r2.moveToNext()     // Catch: java.lang.Throwable -> Ld7
            if (r6 == 0) goto Lb6
            int r6 = r2.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L56
            java.lang.String r6 = r2.getString(r6)     // Catch: java.lang.Throwable -> L56
            int r7 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = r2.getString(r7)     // Catch: java.lang.Throwable -> L56
            int r8 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L56
            int r8 = r2.getInt(r8)     // Catch: java.lang.Throwable -> L56
            r9 = 1
            if (r8 != r9) goto L85
            com.bytedance.sdk.component.tl.j.up r8 = r11.xt     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.component.tl.j.r r8 = r8.r()     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = r8.j(r7)     // Catch: java.lang.Throwable -> L56
        L85:
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L56
            if (r8 == 0) goto L91
            java.util.List<java.lang.String> r3 = r11.cw     // Catch: java.lang.Throwable -> L56
            r3.add(r6)     // Catch: java.lang.Throwable -> L56
            goto L56
        L91:
            int r8 = r12.size()     // Catch: java.lang.Throwable -> L56
            r9 = 100
            if (r8 <= r9) goto L9a
            goto Lb6
        L9a:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L56
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.component.tl.xt.r.j.j r4 = new com.bytedance.sdk.component.tl.xt.r.j.j     // Catch: java.lang.Throwable -> L56
            r4.<init>(r6, r3)     // Catch: java.lang.Throwable -> L56
            byte r3 = r11.cw()     // Catch: java.lang.Throwable -> L56
            r4.xt(r3)     // Catch: java.lang.Throwable -> L56
            byte r3 = r11.xt()     // Catch: java.lang.Throwable -> L56
            r4.j(r3)     // Catch: java.lang.Throwable -> L56
            r12.add(r4)     // Catch: java.lang.Throwable -> L56
            goto L56
        Lb6:
            r2.close()     // Catch: java.lang.Exception -> Lfa
            java.util.List<java.lang.String> r13 = r11.cw     // Catch: java.lang.Exception -> Lfa
            boolean r13 = r13.isEmpty()     // Catch: java.lang.Exception -> Lfa
            if (r13 != 0) goto Lcb
            java.util.List<java.lang.String> r13 = r11.cw     // Catch: java.lang.Exception -> Lfa
            r11.cw(r13)     // Catch: java.lang.Exception -> Lfa
            java.util.List<java.lang.String> r13 = r11.cw     // Catch: java.lang.Exception -> Lfa
            r13.clear()     // Catch: java.lang.Exception -> Lfa
        Lcb:
            boolean r13 = com.bytedance.sdk.component.tl.xt.cw.j.j(r14)     // Catch: java.lang.Exception -> Lfa
            if (r13 == 0) goto Lfa
            if (r15 != 0) goto Lfa
            r11.j(r12, r5, r3)     // Catch: java.lang.Exception -> Lfa
            goto Lfa
        Ld7:
            r0 = move-exception
            r13 = r0
            r2.close()     // Catch: java.lang.Exception -> Lf9
            java.util.List<java.lang.String> r0 = r11.cw     // Catch: java.lang.Exception -> Lf9
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> Lf9
            if (r0 != 0) goto Lee
            java.util.List<java.lang.String> r0 = r11.cw     // Catch: java.lang.Exception -> Lf9
            r11.cw(r0)     // Catch: java.lang.Exception -> Lf9
            java.util.List<java.lang.String> r0 = r11.cw     // Catch: java.lang.Exception -> Lf9
            r0.clear()     // Catch: java.lang.Exception -> Lf9
        Lee:
            boolean r14 = com.bytedance.sdk.component.tl.xt.cw.j.j(r14)     // Catch: java.lang.Exception -> Lf9
            if (r14 == 0) goto Lf9
            if (r15 != 0) goto Lf9
            r11.j(r12, r5, r3)     // Catch: java.lang.Exception -> Lf9
        Lf9:
            throw r13
        Lfa:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.j.j.xt.ae.j(int, java.lang.String, int, boolean):java.util.List");
    }

    public static String r(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.cw
    public List<com.bytedance.sdk.component.tl.j.xt> j(String str, int i6, boolean z5) {
        com.bytedance.sdk.component.tl.xt.r.xt.j jVar = this.f26771r;
        if (jVar == null) {
            return new ArrayList();
        }
        return j(jVar.xt(), str, i6, z5);
    }

    private void j(int i6, long j6) {
        long currentTimeMillis = System.currentTimeMillis() - j6;
        Context context = getContext();
        String j7 = j();
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i6);
        com.bytedance.sdk.component.tl.xt.j.j.xt.delete(context, j7, "gen_time <? OR retry >?", new String[]{sb2, sb3.toString()}, this.xt);
    }

    public void j(List<com.bytedance.sdk.component.tl.j.xt> list, int i6, long j6) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            r(list);
            j(i6, j6);
        } catch (Exception unused) {
        }
    }

    private static String j(String str, List<?> list, int i6, boolean z5) {
        int i7;
        String str2 = z5 ? IBaseDbHelper.CONDITION_IN : " NOT IN ";
        String str3 = z5 ? " OR " : " AND ";
        int min = Math.min(i6, 1000);
        int size = list.size();
        if (size % min == 0) {
            i7 = size / min;
        } else {
            i7 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = i8 * min;
            String j6 = j(TextUtils.join("','", list.subList(i9, Math.min(i9 + min, size))), "");
            if (i8 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(j6);
            sb.append("')");
        }
        return j(sb.toString(), str + str2 + "('')");
    }

    private static String j(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}

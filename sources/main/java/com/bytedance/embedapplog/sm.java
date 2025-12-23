package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class sm {
    static final xt[] cw;

    /* renamed from: m, reason: collision with root package name */
    private static final ya[] f24050m;
    private String ae;

    /* renamed from: r, reason: collision with root package name */
    private final f f24051r;
    private final j up;

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f24049j = {1};
    static final HashMap<String, ya> xt = new HashMap<>();

    static class j extends SQLiteOpenHelper {
        j(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i6) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.j(context), str, cursorFactory, i6);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            uc.r("onUpgrade, " + i6 + ", " + i7, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ya> it = sm.xt.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().r());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    onCreate(sQLiteDatabase);
                } finally {
                }
            }
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ya> it = sm.xt.values().iterator();
                while (it.hasNext()) {
                    String cw = it.next().cw();
                    if (cw != null) {
                        sQLiteDatabase.execSQL(cw);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    uc.xt(th);
                } finally {
                    ri.j(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            onUpgrade(sQLiteDatabase, i6, i7);
        }
    }

    static class xt {
        int cw;

        /* renamed from: j, reason: collision with root package name */
        String f24052j;
        int xt;

        /* JADX INFO: Access modifiers changed from: private */
        public static void xt() {
            for (xt xtVar : sm.cw) {
                xtVar.f24052j = "";
                xtVar.xt = 0;
                xtVar.cw = 0;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(this.cw);
            sb.append("-");
            sb.append(this.f24052j);
            sb.append("-");
            sb.append(this.xt);
            return sb.toString();
        }

        xt() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(ya yaVar) {
            String g6 = yaVar.g();
            if (g6 == null || g6.length() <= this.xt) {
                return;
            }
            this.f24052j = yaVar.tl();
            this.xt = g6.length();
        }
    }

    static {
        j(new kc());
        j(new ry(true));
        j(new aq());
        j(new zz());
        ya[] yaVarArr = {new xq(), new ff(null, false, null), new k("", new JSONObject())};
        f24050m = yaVarArr;
        for (int i6 = 0; i6 < 3; i6++) {
            j(yaVarArr[i6]);
        }
        cw = new xt[]{new xt(), new xt(), new xt()};
    }

    private String j(String str, boolean z5) {
        StringBuilder sb = new StringBuilder("SELECT * FROM page WHERE session_id");
        sb.append(z5 ? "='" : "!='");
        sb.append(str);
        sb.append("' ORDER BY ");
        sb.append(z5 ? "session_id," : "");
        sb.append("duration DESC LIMIT 500");
        return sb.toString();
    }

    private String j(ya yaVar, String str, boolean z5, int i6, int i7) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(yaVar.r());
        sb.append(" WHERE session_id");
        sb.append(z5 ? "='" : "!='");
        sb.append(str);
        sb.append("' AND event_type='");
        sb.append(i7);
        sb.append("' ORDER BY _id LIMIT ");
        sb.append(i6);
        return sb.toString();
    }

    private String xt(String str, boolean z5) {
        StringBuilder sb = new StringBuilder("DELETE FROM page WHERE session_id");
        sb.append(z5 ? "='" : "!='");
        sb.append(str);
        sb.append("'");
        return sb.toString();
    }

    public sm(f fVar) {
        this.up = new j(fVar.xt(), "bd_embed_tea_agent.db", null, 30);
        this.f24051r = fVar;
    }

    private String j(String str, int i6, String str2, boolean z5, long j6) {
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str);
        sb.append(" WHERE session_id");
        sb.append(z5 ? "='" : "!='");
        sb.append(str2);
        sb.append("' AND event_type='");
        sb.append(i6);
        sb.append("' AND _id<=");
        sb.append(j6);
        return sb.toString();
    }

    private String j(long j6, int i6) {
        return "UPDATE pack SET _fail=" + i6 + " WHERE _id=" + j6;
    }

    private static void j(ya yaVar) {
        xt.put(yaVar.r(), yaVar);
    }

    private boolean j(String str) {
        uc.j("needLaunch, " + this.ae + ", " + str);
        if (TextUtils.equals(str, this.ae)) {
            return false;
        }
        this.ae = str;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0133 A[Catch: all -> 0x011d, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x011d, blocks: (B:31:0x0133, B:79:0x0119), top: B:6:0x0030, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.ArrayList<com.bytedance.embedapplog.zz> j(org.json.JSONObject r27) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.sm.j(org.json.JSONObject):java.util.ArrayList");
    }

    private void j(JSONObject jSONObject, boolean z5, zz zzVar, SQLiteDatabase sQLiteDatabase) {
        zz zzVar2 = zzVar;
        for (int i6 : f24049j) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int j6 = j(0, sQLiteDatabase, zzVar2.f24107r, z5, i6, jSONArrayArr, jArr);
            if (j(jArr)) {
                while (true) {
                    long[] jArr2 = jArr;
                    int i7 = i6;
                    JSONArray[] jSONArrayArr2 = jSONArrayArr;
                    zz zzVar3 = zzVar2;
                    zzVar3.j(jSONObject, null, null, null, jSONArrayArr2, jArr2, i7);
                    jSONArrayArr = jSONArrayArr2;
                    i6 = i7;
                    jArr = jArr2;
                    zzVar2 = zzVar3;
                    boolean z6 = z5;
                    SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                    j(zzVar2, z5, sQLiteDatabase2, true);
                    j6 = j6;
                    while (j6 < f24050m.length) {
                        j6 = j(j6, sQLiteDatabase2, zzVar2.f24107r, z6, i6, jSONArrayArr, jArr);
                        if (j(jArr)) {
                            break;
                        }
                        z6 = z5;
                        sQLiteDatabase2 = sQLiteDatabase;
                    }
                }
            }
        }
    }

    private JSONObject j(ry ryVar, JSONObject jSONObject) {
        if (!TextUtils.equals(ryVar.jy, this.f24051r.up().cw()) || ryVar.vl != this.f24051r.up().xt()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                ri.xt(jSONObject2, jSONObject);
                jSONObject2.put("app_version", ryVar.jy);
                jSONObject2.put("version_code", ryVar.vl);
                return jSONObject2;
            } catch (JSONException e6) {
                uc.xt(e6);
            }
        }
        return jSONObject;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008f -> B:6:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(org.json.JSONObject r12, com.bytedance.embedapplog.ry r13, com.bytedance.embedapplog.zz r14, android.database.sqlite.SQLiteDatabase r15, org.json.JSONArray[] r16, long[] r17, java.util.ArrayList<com.bytedance.embedapplog.zz> r18) {
        /*
            r11 = this;
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "packCurrentData, "
            r1.<init>(r2)
            java.lang.String r2 = r13.f24107r
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.bytedance.embedapplog.uc.j(r1)
            java.lang.String r1 = r13.f24107r
            boolean r8 = r11.j(r1)
            java.lang.String r3 = r13.f24107r
            r4 = 1
            r5 = 0
            r1 = 0
            r0 = r11
            r2 = r15
            r6 = r16
            r7 = r17
            int r9 = r0.j(r1, r2, r3, r4, r5, r6, r7)
            r6 = r7
            r10 = 0
            if (r8 != 0) goto L32
            boolean r0 = r11.j(r6)
            if (r0 == 0) goto L54
        L32:
            if (r8 == 0) goto L36
            r2 = r13
            goto L37
        L36:
            r2 = r10
        L37:
            r4 = 0
            r7 = 0
            r3 = 0
            r1 = r12
            r0 = r14
            r5 = r16
            r0.j(r1, r2, r3, r4, r5, r6, r7)
            com.bytedance.embedapplog.ya[] r0 = com.bytedance.embedapplog.sm.f24050m
            int r0 = r0.length
            if (r9 < r0) goto L58
            com.bytedance.embedapplog.ya r0 = r14.clone()
            com.bytedance.embedapplog.zz r0 = (com.bytedance.embedapplog.zz) r0
            r0.oq()
            r1 = r18
            r1.add(r0)
        L54:
            r8 = r14
        L55:
            r2 = r15
        L56:
            r1 = r9
            goto L60
        L58:
            r0 = r14
        L59:
            r1 = 1
            r2 = r15
            r11.j(r0, r1, r15, r1)
            r8 = r0
            goto L56
        L60:
            com.bytedance.embedapplog.ya[] r0 = com.bytedance.embedapplog.sm.f24050m
            int r0 = r0.length
            if (r1 >= r0) goto L91
            java.lang.String r3 = r13.f24107r
            r4 = 1
            r5 = 0
            r0 = r11
            r6 = r16
            r7 = r17
            int r9 = r0.j(r1, r2, r3, r4, r5, r6, r7)
            r6 = r7
            boolean r0 = r11.j(r6)
            if (r0 == 0) goto L8f
            java.lang.String r0 = r13.f24107r
            boolean r0 = r11.j(r0)
            if (r0 == 0) goto L83
            r2 = r13
            goto L84
        L83:
            r2 = r10
        L84:
            r4 = 0
            r7 = 0
            r3 = 0
            r1 = r12
            r5 = r16
            r0 = r8
            r0.j(r1, r2, r3, r4, r5, r6, r7)
            goto L59
        L8f:
            r0 = r8
            goto L55
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.sm.j(org.json.JSONObject, com.bytedance.embedapplog.ry, com.bytedance.embedapplog.zz, android.database.sqlite.SQLiteDatabase, org.json.JSONArray[], long[], java.util.ArrayList):void");
    }

    private void j(JSONObject jSONObject, ry ryVar, zz zzVar, kc kcVar, aq aqVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        uc.j("packHistoryData, " + ryVar.f24107r);
        JSONArray j6 = j(ryVar, true, aqVar, kcVar, sQLiteDatabase);
        ryVar.ws = j6.length() == 0;
        int j7 = j(0, sQLiteDatabase, ryVar.f24107r, true, 0, jSONArrayArr, jArr);
        if (ryVar.ws) {
            zzVar.j(jSONObject, j(ryVar.f24107r) ? ryVar : null, null, null, jSONArrayArr, jArr, 0);
        } else {
            zzVar.j(jSONObject, null, aqVar, j6, jSONArrayArr, jArr, 0);
        }
        while (true) {
            zz zzVar2 = zzVar;
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            j(zzVar2, true, sQLiteDatabase2, true);
            while (j7 < f24050m.length) {
                j7 = j(j7, sQLiteDatabase2, ryVar.f24107r, true, 0, jSONArrayArr, jArr);
                if (j(jArr)) {
                    break;
                }
                zzVar2 = zzVar;
                sQLiteDatabase2 = sQLiteDatabase;
            }
            return;
            zzVar2.j(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0088 -> B:8:0x004d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0061 -> B:9:0x0072). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(org.json.JSONObject r15, com.bytedance.embedapplog.ry r16, com.bytedance.embedapplog.aq r17, com.bytedance.embedapplog.kc r18, com.bytedance.embedapplog.zz r19, android.database.sqlite.SQLiteDatabase r20, java.lang.String r21, org.json.JSONArray[] r22, long[] r23) {
        /*
            r14 = this;
            r1 = r16
            r6 = r21
            java.lang.String r0 = "packLostData, "
            java.lang.String r2 = java.lang.String.valueOf(r6)
            java.lang.String r0 = r0.concat(r2)
            com.bytedance.embedapplog.uc.j(r0)
            r1.f24107r = r6
            r8 = 0
            r1.kt = r8
            r9 = r19
            r9.f24107r = r6
            r2 = 0
            r0 = r14
            r3 = r17
            r4 = r18
            r5 = r20
            org.json.JSONArray r10 = r0.j(r1, r2, r3, r4, r5)
            r11 = r1
            r4 = 0
            r5 = 0
            r1 = 0
            r2 = r20
            r7 = r23
            r3 = r6
            r6 = r22
            int r1 = r0.j(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r10.length()
            r12 = 1
            if (r0 != 0) goto L3e
            r0 = 1
            goto L3f
        L3e:
            r0 = 0
        L3f:
            r11.ws = r0
            boolean r0 = r14.j(r7)
            r13 = 0
            if (r0 != 0) goto L50
            boolean r0 = r11.ws
            if (r0 != 0) goto L4d
            goto L50
        L4d:
            r2 = r20
            goto L72
        L50:
            boolean r0 = r11.ws
            if (r0 != 0) goto L57
            r2 = r17
            goto L58
        L57:
            r2 = r13
        L58:
            if (r0 != 0) goto L5f
            r4 = r10
        L5b:
            r3 = r2
            r0 = r9
            r9 = r1
            goto L61
        L5f:
            r4 = r13
            goto L5b
        L61:
            r7 = 0
            r2 = 0
            r1 = r15
            r5 = r22
            r6 = r23
            r0.j(r1, r2, r3, r4, r5, r6, r7)
            r2 = r20
            r14.j(r0, r8, r2, r12)
            r1 = r9
            r9 = r0
        L72:
            com.bytedance.embedapplog.ya[] r0 = com.bytedance.embedapplog.sm.f24050m
            int r0 = r0.length
            if (r1 >= r0) goto L8c
            r4 = 0
            r5 = 0
            r0 = r14
            r3 = r21
            r6 = r22
            r7 = r23
            int r1 = r0.j(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r14.j(r7)
            if (r2 == 0) goto L4d
            r2 = r13
            goto L5f
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.sm.j(org.json.JSONObject, com.bytedance.embedapplog.ry, com.bytedance.embedapplog.aq, com.bytedance.embedapplog.kc, com.bytedance.embedapplog.zz, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
    }

    private boolean j(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void j(zz zzVar, boolean z5, SQLiteDatabase sQLiteDatabase, boolean z6) {
        boolean z7;
        boolean z8;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.up.getWritableDatabase();
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    uc.xt(th);
                    if (z7) {
                        ri.j(sQLiteDatabase);
                        return;
                    }
                    return;
                } finally {
                }
            }
        }
        if (z6 && sQLiteDatabase.insert("pack", null, zzVar.xt((ContentValues) null)) < 0) {
            if (zzVar.mi != null) {
                j((String) null);
            }
            if (z7) {
                ri.j(sQLiteDatabase);
                return;
            }
            return;
        }
        long j6 = zzVar.av;
        if (j6 > 0) {
            z8 = z5;
            sQLiteDatabase.execSQL(j("event", zzVar.oq, zzVar.f24107r, z8, j6));
        } else {
            z8 = z5;
        }
        long j7 = zzVar.f24112w;
        if (j7 > 0) {
            sQLiteDatabase.execSQL(j("eventv3", zzVar.oq, zzVar.f24107r, z8, j7));
        }
        long j8 = zzVar.tj;
        if (j8 > 0) {
            sQLiteDatabase.execSQL(j("event_misc", zzVar.oq, zzVar.f24107r, z8, j8));
        }
        if (z7) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (z7) {
            ri.j(sQLiteDatabase);
        }
    }

    private int j(int i6, SQLiteDatabase sQLiteDatabase, String str, boolean z5, int i7, JSONArray[] jSONArrayArr, long[] jArr) {
        xt.xt();
        int i8 = 0;
        while (i8 < i6) {
            jSONArrayArr[i8] = null;
            jArr[i8] = 0;
            i8++;
        }
        int i9 = i8;
        int i10 = 200;
        while (i10 > 0 && i9 < f24050m.length) {
            j(sQLiteDatabase, str, i10, i9, z5, jSONArrayArr, jArr, i7);
            int length = jSONArrayArr[i9].length();
            i10 -= length;
            cw[i9].cw = length;
            if (i10 > 0) {
                i9++;
            }
        }
        for (int i11 = i9 + 1; i11 < jSONArrayArr.length; i11++) {
            jSONArrayArr[i11] = null;
            jArr[i11] = 0;
        }
        return i9;
    }

    private void j(SQLiteDatabase sQLiteDatabase, String str, int i6, int i7, boolean z5, JSONArray[] jSONArrayArr, long[] jArr, int i8) {
        Throwable th;
        ya yaVar = f24050m[i7];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j6 = 0;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(j(yaVar, str, z5, i6, i8), null);
            for (int i9 = 0; rawQuery.moveToNext() && i9 <= 200; i9++) {
                try {
                    yaVar.j(rawQuery);
                    cw[i7].j(yaVar);
                    if (uc.xt) {
                        uc.j("queryEvent, ".concat(String.valueOf(yaVar)), null);
                    }
                    jSONArray.put(yaVar.m());
                    long j7 = yaVar.f24105j;
                    if (j7 > j6) {
                        j6 = j7;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    try {
                        uc.xt(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        jSONArrayArr[i7] = jSONArray;
                        jArr[i7] = j6;
                    } finally {
                    }
                }
            }
            rawQuery.close();
        } catch (Throwable th3) {
            th = th3;
        }
        jSONArrayArr[i7] = jSONArray;
        jArr[i7] = j6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
    
        if (r12 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray j(com.bytedance.embedapplog.ry r22, boolean r23, com.bytedance.embedapplog.aq r24, com.bytedance.embedapplog.kc r25, android.database.sqlite.SQLiteDatabase r26) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.sm.j(com.bytedance.embedapplog.ry, boolean, com.bytedance.embedapplog.aq, com.bytedance.embedapplog.kc, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r3 == null) goto L16;
     */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.bytedance.embedapplog.zz> j() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap<java.lang.String, com.bytedance.embedapplog.ya> r1 = com.bytedance.embedapplog.sm.xt
            java.lang.String r2 = "pack"
            java.lang.Object r1 = r1.get(r2)
            com.bytedance.embedapplog.zz r1 = (com.bytedance.embedapplog.zz) r1
            r2 = 0
            com.bytedance.embedapplog.sm$j r3 = r5.up     // Catch: java.lang.Throwable -> L35
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = "SELECT * FROM pack ORDER BY _id DESC LIMIT 8"
            android.database.Cursor r3 = r3.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> L35
        L1c:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L31
            com.bytedance.embedapplog.ya r1 = r1.clone()     // Catch: java.lang.Throwable -> L2f
            com.bytedance.embedapplog.zz r1 = (com.bytedance.embedapplog.zz) r1     // Catch: java.lang.Throwable -> L2f
            r1.j(r3)     // Catch: java.lang.Throwable -> L2f
            r0.add(r1)     // Catch: java.lang.Throwable -> L2f
            goto L1c
        L2f:
            r1 = move-exception
            goto L37
        L31:
            r3.close()
            goto L3d
        L35:
            r1 = move-exception
            r3 = r2
        L37:
            com.bytedance.embedapplog.uc.xt(r1)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L3d
            goto L31
        L3d:
            java.lang.String r1 = "queryPack, "
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r1 = r1.concat(r3)
            com.bytedance.embedapplog.uc.j(r1, r2)
            return r0
        L4b:
            r0 = move-exception
            if (r3 == 0) goto L51
            r3.close()
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.sm.j():java.util.ArrayList");
    }

    public void j(ArrayList<zz> arrayList, ArrayList<zz> arrayList2, ArrayList<zz> arrayList3) {
        SQLiteDatabase sQLiteDatabase = null;
        uc.j("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<zz> it = arrayList2.iterator();
        while (it.hasNext()) {
            zz next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.xt) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.up.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                try {
                    Iterator<zz> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        zz next2 = it2.next();
                        if (arrayList3.contains(next2)) {
                            j(next2, true, writableDatabase, false);
                        } else {
                            writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(next2.f24105j)});
                        }
                    }
                } catch (Throwable th) {
                    uc.xt(th);
                }
                Iterator<zz> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    zz next3 = it3.next();
                    if (next3.mi != null) {
                        j((String) null);
                    }
                    if (!arrayList3.contains(next3)) {
                        long j6 = next3.f24105j;
                        int i6 = next3.jy + 1;
                        next3.jy = i6;
                        writableDatabase.execSQL(j(j6, i6));
                    }
                }
                writableDatabase.setTransactionSuccessful();
                ri.j(writableDatabase);
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                try {
                    uc.xt(th);
                } finally {
                    ri.j(sQLiteDatabase);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void j(@NonNull ArrayList<ya> arrayList) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.up.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            Iterator<ya> it = arrayList.iterator();
            ContentValues contentValues = null;
            while (it.hasNext()) {
                ya next = it.next();
                String r5 = next.r();
                contentValues = next.xt(contentValues);
                next.f24105j = writableDatabase.insert(r5, null, contentValues);
                if ("event".equals(next.r())) {
                    arrayList3.add(next);
                } else if ("eventv3".equals(next.r())) {
                    arrayList3.add(next);
                } else if (next instanceof ry) {
                    arrayList2.add((ry) next);
                }
            }
            writableDatabase.setTransactionSuccessful();
            ri.j(writableDatabase);
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                uc.xt(th);
            } finally {
                ri.j(sQLiteDatabase);
            }
        }
    }
}

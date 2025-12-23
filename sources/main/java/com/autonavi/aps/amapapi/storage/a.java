package com.autonavi.aps.amapapi.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.restruct.d;
import com.autonavi.aps.amapapi.utils.j;
import com.baidu.mobads.sdk.internal.bn;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    Hashtable<String, ArrayList<C0096a>> f10124a = new Hashtable<>();

    /* renamed from: i, reason: collision with root package name */
    private long f10132i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10133j = false;

    /* renamed from: k, reason: collision with root package name */
    private String f10134k = "2.0.201501131131".replace(".", "");

    /* renamed from: l, reason: collision with root package name */
    private String f10135l = null;

    /* renamed from: b, reason: collision with root package name */
    boolean f10125b = true;

    /* renamed from: c, reason: collision with root package name */
    long f10126c = 0;

    /* renamed from: d, reason: collision with root package name */
    String f10127d = null;

    /* renamed from: e, reason: collision with root package name */
    d f10128e = null;

    /* renamed from: m, reason: collision with root package name */
    private String f10136m = null;

    /* renamed from: n, reason: collision with root package name */
    private long f10137n = 0;

    /* renamed from: f, reason: collision with root package name */
    boolean f10129f = true;

    /* renamed from: g, reason: collision with root package name */
    boolean f10130g = true;

    /* renamed from: h, reason: collision with root package name */
    String f10131h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.autonavi.aps.amapapi.storage.a$a, reason: collision with other inner class name */
    static class C0096a {

        /* renamed from: a, reason: collision with root package name */
        private com.autonavi.aps.amapapi.model.a f10138a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f10139b = null;

        public final com.autonavi.aps.amapapi.model.a a() {
            return this.f10138a;
        }

        public final void a(com.autonavi.aps.amapapi.model.a aVar) {
            this.f10138a = aVar;
        }

        public final String b() {
            return this.f10139b;
        }

        protected C0096a() {
        }

        public final void a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f10139b = null;
            } else {
                this.f10139b = str.replace("##", "#");
            }
        }
    }

    private boolean b() {
        long b6 = j.b();
        long j6 = this.f10132i;
        long j7 = b6 - j6;
        if (j6 == 0) {
            return false;
        }
        return this.f10124a.size() > 360 || j7 > bn.f10749e;
    }

    private void c() {
        this.f10132i = 0L;
        if (!this.f10124a.isEmpty()) {
            this.f10124a.clear();
        }
        this.f10133j = false;
    }

    public final void a(String str, StringBuilder sb, com.autonavi.aps.amapapi.model.a aVar, Context context, boolean z5) {
        try {
            if (j.a(aVar)) {
                String str2 = str + ContainerUtils.FIELD_DELIMITER + aVar.isOffset() + ContainerUtils.FIELD_DELIMITER + aVar.i() + ContainerUtils.FIELD_DELIMITER + aVar.j();
                if (a(str2, aVar) && !aVar.e().equals("mem") && !aVar.e().equals(master.flame.danmaku.danmaku.parser.b.f50156c) && !aVar.e().equals("wifioff") && !"-3".equals(aVar.d())) {
                    if (b()) {
                        c();
                    }
                    JSONObject f6 = aVar.f();
                    if (j.a(f6, "offpct")) {
                        f6.remove("offpct");
                        aVar.a(f6);
                    }
                    if (str2.contains("wifi")) {
                        if (TextUtils.isEmpty(sb)) {
                            return;
                        }
                        if (aVar.getAccuracy() >= 300.0f) {
                            int i6 = 0;
                            for (String str3 : sb.toString().split("#")) {
                                if (str3.contains(",")) {
                                    i6++;
                                }
                            }
                            if (i6 >= 8) {
                                return;
                            }
                        } else if (aVar.getAccuracy() <= 3.0f) {
                            return;
                        }
                        if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aVar.g())) {
                            String replace = str2.replace("cgiwifi", "cgi");
                            com.autonavi.aps.amapapi.model.a h6 = aVar.h();
                            if (j.a(h6)) {
                                a(replace, new StringBuilder(), h6, context, true);
                            }
                        }
                    } else if (str2.contains("cgi")) {
                        if (sb != null) {
                            if (sb.indexOf(",") != -1) {
                                return;
                            }
                        }
                        if ("4".equals(aVar.d())) {
                            return;
                        }
                    }
                    com.autonavi.aps.amapapi.model.a a6 = a(str2, sb, false);
                    if (j.a(a6) && a6.toStr().equals(aVar.toStr(3))) {
                        return;
                    }
                    this.f10132i = j.b();
                    C0096a c0096a = new C0096a();
                    c0096a.a(aVar);
                    c0096a.a(TextUtils.isEmpty(sb) ? null : sb.toString());
                    if (this.f10124a.containsKey(str2)) {
                        this.f10124a.get(str2).add(c0096a);
                    } else {
                        ArrayList<C0096a> arrayList = new ArrayList<>();
                        arrayList.add(c0096a);
                        this.f10124a.put(str2, arrayList);
                    }
                    if (z5) {
                        try {
                            a(str2, aVar, sb, context);
                        } catch (Throwable th) {
                            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "add");
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "Cache", "add");
        }
    }

    public final void b(Context context) {
        try {
            c();
            c(context);
            this.f10133j = false;
            this.f10127d = null;
            this.f10137n = 0L;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "destroy part");
        }
    }

    /* JADX WARN: Finally extract failed */
    private void c(Context context) throws Exception {
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "clearHist p2");
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            } catch (Throwable th2) {
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
        if (!j.a(sQLiteDatabase, "hist")) {
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
            sQLiteDatabase.close();
            return;
        }
        try {
            sQLiteDatabase.delete("hist" + this.f10134k, "time<?", new String[]{String.valueOf(j.a() - bn.f10749e)});
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "DB", "clearHist");
            String message = th3.getMessage();
            if (!TextUtils.isEmpty(message)) {
                message.contains("no such table");
            }
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public final com.autonavi.aps.amapapi.model.a a(Context context, String str, StringBuilder sb, boolean z5, boolean z6) {
        if (TextUtils.isEmpty(str) || !com.autonavi.aps.amapapi.utils.a.e()) {
            return null;
        }
        String str2 = str + ContainerUtils.FIELD_DELIMITER + this.f10129f + ContainerUtils.FIELD_DELIMITER + this.f10130g + ContainerUtils.FIELD_DELIMITER + this.f10131h;
        if (str2.contains(GeocodeSearch.GPS) || !com.autonavi.aps.amapapi.utils.a.e() || sb == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z5 && !this.f10133j) {
            try {
                String a6 = a(str2, sb, context);
                c();
                a(context, a6, z6);
            } catch (Throwable unused) {
            }
        }
        if (this.f10124a.isEmpty()) {
            return null;
        }
        return a(str2, sb, z6);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008d A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0022, B:14:0x0030, B:16:0x004a, B:18:0x0054, B:20:0x0066, B:23:0x0071, B:25:0x0075, B:27:0x007b, B:28:0x0087, B:30:0x008d, B:31:0x0091, B:36:0x0044), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a a(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "cgiwifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L44
            java.lang.String r1 = "wifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L12
            goto L44
        L12:
            java.lang.String r6 = "cgi"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L42
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f10124a     // Catch: java.lang.Throwable -> L40
            boolean r6 = r6.containsKey(r5)     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L42
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f10124a     // Catch: java.lang.Throwable -> L40
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L40
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L40
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L40
            if (r6 <= 0) goto L42
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f10124a     // Catch: java.lang.Throwable -> L40
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L40
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L40
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L40
            com.autonavi.aps.amapapi.storage.a$a r6 = (com.autonavi.aps.amapapi.storage.a.C0096a) r6     // Catch: java.lang.Throwable -> L40
            goto L48
        L40:
            r5 = move-exception
            goto L96
        L42:
            r6 = r0
            goto L48
        L44:
            com.autonavi.aps.amapapi.storage.a$a r6 = r4.a(r6, r5)     // Catch: java.lang.Throwable -> L40
        L48:
            if (r6 == 0) goto L9d
            com.autonavi.aps.amapapi.model.a r1 = r6.a()     // Catch: java.lang.Throwable -> L40
            boolean r1 = com.autonavi.aps.amapapi.utils.j.a(r1)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L9d
            com.autonavi.aps.amapapi.model.a r1 = r6.a()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "mem"
            r1.e(r2)     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = r6.b()     // Catch: java.lang.Throwable -> L40
            r1.h(r2)     // Catch: java.lang.Throwable -> L40
            if (r7 != 0) goto L87
            long r2 = r1.getTime()     // Catch: java.lang.Throwable -> L40
            boolean r7 = com.autonavi.aps.amapapi.utils.a.a(r2)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L71
            goto L87
        L71:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f10124a     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L9d
            boolean r7 = r7.containsKey(r5)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L9d
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f10124a     // Catch: java.lang.Throwable -> L40
            java.lang.Object r5 = r7.get(r5)     // Catch: java.lang.Throwable -> L40
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.lang.Throwable -> L40
            r5.remove(r6)     // Catch: java.lang.Throwable -> L40
            goto L9d
        L87:
            boolean r5 = com.autonavi.aps.amapapi.utils.j.a(r1)     // Catch: java.lang.Throwable -> L40
            if (r5 == 0) goto L91
            r5 = 0
            r4.f10126c = r5     // Catch: java.lang.Throwable -> L40
        L91:
            r5 = 4
            r1.setLocationType(r5)     // Catch: java.lang.Throwable -> L40
            return r1
        L96:
            java.lang.String r6 = "Cache"
            java.lang.String r7 = "get1"
            com.autonavi.aps.amapapi.utils.b.a(r5, r6, r7)
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.a");
    }

    private static boolean a(String str, com.autonavi.aps.amapapi.model.a aVar) {
        if (TextUtils.isEmpty(str) || !j.a(aVar) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    private C0096a a(StringBuilder sb, String str) {
        C0096a c0096a;
        boolean z5;
        C0096a c0096a2;
        C0096a c0096a3 = null;
        if (this.f10124a.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (!this.f10124a.containsKey(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        ArrayList<C0096a> arrayList = this.f10124a.get(str);
        char c6 = 1;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            C0096a c0096a4 = arrayList.get(size);
            if (!TextUtils.isEmpty(c0096a4.b())) {
                if (!a(c0096a4.b(), sb)) {
                    z5 = false;
                } else {
                    if (j.a(c0096a4.b(), sb.toString())) {
                        c0096a2 = c0096a4;
                        c0096a3 = c0096a2;
                        break;
                    }
                    z5 = true;
                }
                a(c0096a4.b(), (Hashtable<String, String>) hashtable);
                a(sb.toString(), (Hashtable<String, String>) hashtable2);
                hashtable3.clear();
                Iterator it = hashtable.keySet().iterator();
                while (it.hasNext()) {
                    hashtable3.put((String) it.next(), "");
                }
                Iterator it2 = hashtable2.keySet().iterator();
                while (it2.hasNext()) {
                    hashtable3.put((String) it2.next(), "");
                }
                Set keySet = hashtable3.keySet();
                double[] dArr = new double[keySet.size()];
                double[] dArr2 = new double[keySet.size()];
                Iterator it3 = keySet.iterator();
                int i6 = 0;
                while (it3 != null && it3.hasNext()) {
                    C0096a c0096a5 = c0096a3;
                    String str2 = (String) it3.next();
                    double d6 = 0.0d;
                    dArr[i6] = hashtable.containsKey(str2) ? 1.0d : 0.0d;
                    if (hashtable2.containsKey(str2)) {
                        d6 = 1.0d;
                    }
                    dArr2[i6] = d6;
                    i6++;
                    c0096a3 = c0096a5;
                }
                c0096a = c0096a3;
                keySet.clear();
                double[] a6 = a(dArr, dArr2);
                if (a6[0] < 0.800000011920929d) {
                    c0096a2 = c0096a4;
                    if (a6[c6] < Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d)) {
                        if (z5 && a6[0] >= Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d)) {
                        }
                    }
                    c0096a3 = c0096a2;
                    break;
                }
                c0096a2 = c0096a4;
                c0096a3 = c0096a2;
                break;
            }
            c0096a = c0096a3;
            size--;
            c0096a3 = c0096a;
            c6 = 1;
        }
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return c0096a3;
    }

    private static boolean a(String str, StringBuilder sb) {
        String str2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        if (split[0].contains("#")) {
            String str3 = split[0];
            str2 = str3.substring(str3.lastIndexOf("#") + 1);
        } else {
            str2 = split[0];
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return sb.toString().contains(str2 + ",access");
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (!TextUtils.isEmpty(str2) && !str2.contains(Logger.f33116c)) {
                hashtable.put(str2, "");
            }
        }
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < dArr.length; i8++) {
            double d9 = dArr[i8];
            d7 += d9 * d9;
            double d10 = dArr2[i8];
            d8 += d10 * d10;
            d6 += d9 * d10;
            if (d10 == 1.0d) {
                i7++;
                if (d9 == 1.0d) {
                    i6++;
                }
            }
        }
        dArr3[0] = d6 / (Math.sqrt(d7) * Math.sqrt(d8));
        double d11 = i6;
        dArr3[1] = (d11 * 1.0d) / i7;
        dArr3[2] = d11;
        for (int i9 = 0; i9 < 2; i9++) {
            if (dArr3[i9] > 1.0d) {
                dArr3[i9] = 1.0d;
            }
        }
        return dArr3;
    }

    public final void a(Context context) {
        if (this.f10133j) {
            return;
        }
        try {
            c();
            a(context, (String) null, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "loadDB");
        }
        this.f10133j = true;
    }

    private String a(String str, StringBuilder sb, Context context) {
        String str2;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.f10135l = j.l(context);
            if (str.contains(ContainerUtils.FIELD_DELIMITER)) {
                str = str.substring(0, str.indexOf(ContainerUtils.FIELD_DELIMITER));
            }
            String substring = str.substring(str.lastIndexOf("#") + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
                String[] split = sb.toString().split(",access");
                if (split[0].contains("#")) {
                    String str3 = split[0];
                    str2 = str3.substring(str3.lastIndexOf("#") + 1);
                } else {
                    str2 = split[0];
                }
                jSONObject.put("mmac", str2);
            }
            return j4.f(com.autonavi.aps.amapapi.security.a.a(jSONObject.toString().getBytes("UTF-8"), this.f10135l));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.f10135l == null) {
            this.f10135l = j.l(context);
        }
        String a6 = a(str, sb, context);
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.f10134k);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.f10134k);
            sb2.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = a6;
            byte[] a7 = com.autonavi.aps.amapapi.security.a.a(sb.toString().getBytes("UTF-8"), this.f10135l);
            objArr[1] = a7;
            objArr[2] = com.autonavi.aps.amapapi.security.a.a(aMapLocation.toStr().getBytes("UTF-8"), this.f10135l);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i6 = 1; i6 < 3; i6++) {
                objArr[i6] = j4.f((byte[]) objArr[i6]);
            }
            sQLiteDatabase.execSQL(sb2.toString(), objArr);
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "updateHist");
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } catch (Throwable th2) {
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x027a A[LOOP:0: B:32:0x00d1->B:53:0x027a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x026a A[EDGE_INSN: B:54:0x026a->B:55:0x026a BREAK  A[LOOP:0: B:32:0x00d1->B:53:0x027a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r20, java.lang.String r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 701
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(android.content.Context, java.lang.String, boolean):void");
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f10130g = aMapLocationClientOption.isNeedAddress();
        this.f10129f = aMapLocationClientOption.isOffset();
        this.f10125b = aMapLocationClientOption.isLocationCacheEnable();
        this.f10131h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(d dVar) {
        this.f10128e = dVar;
    }

    private boolean a(com.autonavi.aps.amapapi.model.a aVar, boolean z5) {
        if (a(z5)) {
            return aVar == null || com.autonavi.aps.amapapi.utils.a.a(aVar.getTime()) || z5;
        }
        return false;
    }

    private boolean a(boolean z5) {
        if (com.autonavi.aps.amapapi.utils.a.e() || z5) {
            return this.f10125b || com.autonavi.aps.amapapi.utils.a.f() || z5;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x0010, B:8:0x0018, B:12:0x002c, B:20:0x004e, B:24:0x0056, B:26:0x0064, B:32:0x0089, B:33:0x0092, B:35:0x0096, B:37:0x009c, B:39:0x00a7, B:42:0x00cb, B:44:0x00d9, B:52:0x00e9, B:57:0x00ab, B:58:0x00b4, B:60:0x00b8, B:61:0x00c1, B:62:0x0090, B:63:0x0076, B:65:0x007c, B:71:0x001c, B:73:0x0020), top: B:5:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x0010, B:8:0x0018, B:12:0x002c, B:20:0x004e, B:24:0x0056, B:26:0x0064, B:32:0x0089, B:33:0x0092, B:35:0x0096, B:37:0x009c, B:39:0x00a7, B:42:0x00cb, B:44:0x00d9, B:52:0x00e9, B:57:0x00ab, B:58:0x00b4, B:60:0x00b8, B:61:0x00c1, B:62:0x0090, B:63:0x0076, B:65:0x007c, B:71:0x001c, B:73:0x0020), top: B:5:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b8 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x0010, B:8:0x0018, B:12:0x002c, B:20:0x004e, B:24:0x0056, B:26:0x0064, B:32:0x0089, B:33:0x0092, B:35:0x0096, B:37:0x009c, B:39:0x00a7, B:42:0x00cb, B:44:0x00d9, B:52:0x00e9, B:57:0x00ab, B:58:0x00b4, B:60:0x00b8, B:61:0x00c1, B:62:0x0090, B:63:0x0076, B:65:0x007c, B:71:0x001c, B:73:0x0020), top: B:5:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c1 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x0010, B:8:0x0018, B:12:0x002c, B:20:0x004e, B:24:0x0056, B:26:0x0064, B:32:0x0089, B:33:0x0092, B:35:0x0096, B:37:0x009c, B:39:0x00a7, B:42:0x00cb, B:44:0x00d9, B:52:0x00e9, B:57:0x00ab, B:58:0x00b4, B:60:0x00b8, B:61:0x00c1, B:62:0x0090, B:63:0x0076, B:65:0x007c, B:71:0x001c, B:73:0x0020), top: B:5:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0090 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:6:0x0010, B:8:0x0018, B:12:0x002c, B:20:0x004e, B:24:0x0056, B:26:0x0064, B:32:0x0089, B:33:0x0092, B:35:0x0096, B:37:0x009c, B:39:0x00a7, B:42:0x00cb, B:44:0x00d9, B:52:0x00e9, B:57:0x00ab, B:58:0x00b4, B:60:0x00b8, B:61:0x00c1, B:62:0x0090, B:63:0x0076, B:65:0x007c, B:71:0x001c, B:73:0x0020), top: B:5:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.restruct.e r17, boolean r18, com.autonavi.aps.amapapi.model.a r19, com.autonavi.aps.amapapi.restruct.k r20, java.lang.StringBuilder r21, java.lang.String r22, android.content.Context r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(com.autonavi.aps.amapapi.restruct.e, boolean, com.autonavi.aps.amapapi.model.a, com.autonavi.aps.amapapi.restruct.k, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.autonavi.aps.amapapi.model.a");
    }

    public final void a(String str) {
        this.f10127d = str;
    }

    public final void a() {
        this.f10126c = 0L;
        this.f10127d = null;
    }
}

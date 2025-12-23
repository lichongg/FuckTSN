package com.autonavi.aps.amapapi.trans;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.l9;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.utils.j;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f {
    protected static String I;
    protected static String K;

    /* renamed from: a, reason: collision with root package name */
    public String f10181a = "1";

    /* renamed from: b, reason: collision with root package name */
    protected short f10182b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected String f10183c = null;

    /* renamed from: d, reason: collision with root package name */
    protected String f10184d = null;

    /* renamed from: e, reason: collision with root package name */
    protected String f10185e = null;

    /* renamed from: f, reason: collision with root package name */
    protected String f10186f = null;

    /* renamed from: g, reason: collision with root package name */
    protected String f10187g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f10188h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f10189i = null;

    /* renamed from: j, reason: collision with root package name */
    protected String f10190j = null;

    /* renamed from: k, reason: collision with root package name */
    protected String f10191k = null;

    /* renamed from: l, reason: collision with root package name */
    protected String f10192l = null;

    /* renamed from: m, reason: collision with root package name */
    protected String f10193m = null;

    /* renamed from: n, reason: collision with root package name */
    protected String f10194n = null;

    /* renamed from: o, reason: collision with root package name */
    protected String f10195o = null;

    /* renamed from: p, reason: collision with root package name */
    protected String f10196p = null;

    /* renamed from: q, reason: collision with root package name */
    protected String f10197q = null;

    /* renamed from: r, reason: collision with root package name */
    protected String f10198r = null;

    /* renamed from: s, reason: collision with root package name */
    protected String f10199s = null;

    /* renamed from: t, reason: collision with root package name */
    protected String f10200t = null;

    /* renamed from: u, reason: collision with root package name */
    protected String f10201u = null;

    /* renamed from: v, reason: collision with root package name */
    protected String f10202v = null;

    /* renamed from: w, reason: collision with root package name */
    protected String f10203w = null;

    /* renamed from: x, reason: collision with root package name */
    protected String f10204x = null;

    /* renamed from: y, reason: collision with root package name */
    protected String f10205y = null;

    /* renamed from: z, reason: collision with root package name */
    protected int f10206z = 0;
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> A = new ArrayList<>();
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> B = new ArrayList<>();
    protected String C = null;
    protected String D = null;
    protected ArrayList<l9> E = new ArrayList<>();
    protected String F = null;
    protected String G = null;
    protected byte[] H = null;
    private byte[] Q = null;
    private int R = 0;
    protected String J = null;
    protected String L = null;
    protected String M = null;
    protected String N = null;
    protected int O = 0;
    private List<com.autonavi.aps.amapapi.restruct.f> S = null;
    private List<com.autonavi.aps.amapapi.restruct.d> T = Collections.synchronizedList(new ArrayList());
    final int P = 3;

    /* JADX WARN: Can't wrap try/catch for region: R(48:12|13|14|(17:287|(1:289)(1:390)|290|(7:292|(1:294)(1:367)|295|(1:297)(1:366)|298|(1:300)(1:365)|301)(12:(11:369|(1:371)(1:389)|372|(1:374)(1:388)|375|(1:377)(1:387)|378|(1:380)(1:386)|381|(1:383)(1:385)|384)|303|(1:305)(1:364)|(1:307)|308|(1:310)(1:362)|311|(1:313)|314|(1:316)(1:361)|317|(2:319|(2:321|322)(3:323|(10:325|(1:327)(1:356)|328|(1:330)(1:355)|331|(1:333)(1:354)|(1:335)|336|(1:352)(8:338|(1:340)(1:351)|341|(1:343)|344|(1:346)(1:350)|347|348)|349)|357))(1:(2:359|322)(1:360)))|302|303|(0)(0)|(0)|307|308|(0)(0)|311|(0)|314|(0)(0)|317|(0)(0))(1:17)|18|(42:22|23|24|25|(1:283)(4:28|(13:30|(2:32|(1:85)(5:(3:37|(1:39)|40)(2:78|(3:80|(1:82)|83)(1:84))|41|(1:43)|44|(3:64|(1:75)(5:66|(1:68)|(1:70)|71|(3:73|59|60)(1:74))|61)(3:49|(6:53|(1:55)|(1:57)|58|59|60)|61)))(1:90)|86|(1:88)|89|41|(1:76)|43|44|(1:46)|64|(0)(0)|61)|91|92)|93|(1:282)(16:97|98|99|100|101|102|(1:104)|105|106|107|108|(5:274|(1:276)|111|(2:113|114)|116)|110|111|(0)|116)|117|(1:119)(7:242|(1:244)(1:273)|(1:246)|247|(10:249|250|251|252|253|(1:255)(2:266|(1:268))|256|(1:265)|(2:261|262)(1:264)|263)|271|272)|120|121|122|(1:124)(3:234|(1:236)|(1:238)(30:239|240|126|127|128|129|(1:131)|132|133|134|(3:226|227|228)|136|137|138|139|140|141|142|(1:144)(1:221)|145|146|(1:148)|149|(5:151|(1:153)(1:193)|154|(5:157|158|(9:161|(1:188)(2:163|(1:183)(2:167|(6:169|(1:171)|172|173|174|175)(4:176|(3:178|(1:180)|181)(1:182)|174|175)))|184|(1:186)|187|173|174|175|159)|189|190)|156)|194|(4:196|(1:198)(1:214)|199|(3:201|(6:204|(1:206)|207|(2:209|210)(1:212)|211|202)|213))|215|(1:217)|218|219))|125|126|127|128|129|(0)|132|133|134|(0)|136|137|138|139|140|141|142|(0)(0)|145|146|(0)|149|(0)|194|(0)|215|(0)|218|219)|286|25|(0)|283|93|(1:95)|282|117|(0)(0)|120|121|122|(0)(0)|125|126|127|128|129|(0)|132|133|134|(0)|136|137|138|139|140|141|142|(0)(0)|145|146|(0)|149|(0)|194|(0)|215|(0)|218|219) */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0717, code lost:
    
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x072d, code lost:
    
        r5 = r5 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x06f6, code lost:
    
        r7[r0] = 0;
        r28 = 1;
        r5 = r0 + 1;
        r2 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05d8 A[Catch: all -> 0x05e5, TRY_LEAVE, TryCatch #5 {all -> 0x05e5, blocks: (B:99:0x0575, B:108:0x05ad, B:111:0x05be, B:113:0x05d8, B:279:0x05a3, B:102:0x0589, B:105:0x0596), top: B:98:0x0575, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x06d1 A[Catch: all -> 0x06f6, TryCatch #6 {all -> 0x06f6, blocks: (B:122:0x06cd, B:124:0x06d1, B:125:0x06d3, B:234:0x06d9, B:238:0x06e5, B:239:0x06e8), top: B:121:0x06cd }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x070b A[Catch: all -> 0x0717, TryCatch #7 {all -> 0x0717, blocks: (B:129:0x0703, B:131:0x070b, B:133:0x0719), top: B:128:0x0703 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0754  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x071f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x06d9 A[Catch: all -> 0x06f6, TryCatch #6 {all -> 0x06f6, blocks: (B:122:0x06cd, B:124:0x06d1, B:125:0x06d3, B:234:0x06d9, B:238:0x06e5, B:239:0x06e8), top: B:121:0x06cd }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0371 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0221 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0540 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0567  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a() {
        /*
            Method dump skipped, instructions count: 2349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a():byte[]");
    }

    private void b() {
        String[] strArr = new String[27];
        strArr[0] = this.f10181a;
        strArr[1] = this.f10183c;
        strArr[2] = this.f10184d;
        strArr[3] = this.f10185e;
        strArr[4] = this.f10186f;
        strArr[5] = this.f10187g;
        strArr[6] = this.f10188h;
        strArr[7] = this.f10189i;
        strArr[8] = this.f10192l;
        strArr[9] = this.f10193m;
        strArr[10] = this.f10194n;
        strArr[11] = this.f10195o;
        strArr[12] = this.f10196p;
        strArr[13] = this.f10197q;
        strArr[14] = this.f10198r;
        strArr[15] = this.f10199s;
        strArr[16] = this.f10200t;
        strArr[17] = this.f10201u;
        strArr[18] = this.f10202v;
        strArr[19] = this.f10203w;
        strArr[20] = this.f10204x;
        strArr[21] = this.D;
        strArr[22] = this.F;
        strArr[23] = this.G;
        strArr[24] = I;
        strArr[25] = this.M;
        strArr[26] = this.N;
        for (int i6 = 0; i6 < 27; i6++) {
            if (TextUtils.isEmpty(strArr[i6])) {
                strArr[i6] = "";
            }
        }
        if (TextUtils.isEmpty(this.f10190j)) {
            this.f10190j = "0";
        } else if (!"0".equals(this.f10190j) && !"2".equals(this.f10190j)) {
            this.f10190j = "0";
        }
        if (TextUtils.isEmpty(this.f10191k)) {
            this.f10191k = "0";
        } else if (!"0".equals(this.f10191k) && !"1".equals(this.f10191k)) {
            this.f10191k = "0";
        }
        if (TextUtils.isEmpty(this.f10205y)) {
            this.f10205y = "0";
        } else if (!"1".equals(this.f10205y) && !"2".equals(this.f10205y)) {
            this.f10205y = "0";
        }
        if (!com.autonavi.aps.amapapi.restruct.e.a(this.f10206z)) {
            this.f10206z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:24:0x000c, B:8:0x001f, B:10:0x0022, B:12:0x002b, B:13:0x0033, B:3:0x0012, B:5:0x0017), top: B:23:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto L12
            int r4 = r0.length     // Catch: java.lang.Throwable -> L10
            if (r4 == r1) goto L1e
            goto L12
        L10:
            r0 = move-exception
            goto L42
        L12:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L10
            r4 = 0
        L15:
            if (r4 >= r1) goto L1e
            java.lang.String r5 = "0"
            r0[r4] = r5     // Catch: java.lang.Throwable -> L10
            int r4 = r4 + 1
            goto L15
        L1e:
            r1 = 0
        L1f:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L10
            if (r1 >= r4) goto L41
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L10
            r5 = 2
            if (r4 <= r5) goto L33
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = r4.substring(r3, r5)     // Catch: java.lang.Throwable -> L10
            r0[r1] = r4     // Catch: java.lang.Throwable -> L10
        L33:
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch: java.lang.Throwable -> L10
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L10
            r2[r1] = r4     // Catch: java.lang.Throwable -> L10
            int r1 = r1 + 1
            goto L1f
        L41:
            return r2
        L42:
            java.lang.String r1 = "getMacBa "
            java.lang.String r7 = r1.concat(r7)
            java.lang.String r1 = "Req"
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r7 = r6.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a(java.lang.String):byte[]");
    }

    public final void a(Context context, boolean z5, boolean z6, com.autonavi.aps.amapapi.restruct.e eVar, k kVar, ConnectivityManager connectivityManager, String str, g gVar) {
        String str2;
        String str3;
        int i6;
        NetworkInfo networkInfo;
        String str4;
        ArrayList<l9> arrayList;
        int i7;
        String j6 = f4.j(context);
        int d6 = j.d();
        this.J = str;
        this.S = null;
        if (!z6) {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        } else {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        }
        String str5 = str3;
        String str6 = str2;
        StringBuilder sb = new StringBuilder();
        int g6 = eVar.g();
        int h6 = eVar.h();
        TelephonyManager i8 = eVar.i();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> c6 = eVar.c();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> d7 = eVar.d();
        ArrayList<l9> e6 = kVar.e();
        String str7 = "1";
        String str8 = h6 == 2 ? "1" : "0";
        if (i8 != null) {
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f10240g)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.f10240g = i4.P();
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "getApsReq part4");
                }
            }
            i6 = d6;
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f10240g) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.f10240g = "888888888888888";
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f10241h)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.f10241h = i4.U();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f10241h) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.f10241h = "888888888888888";
            }
        } else {
            i6 = d6;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a6 = kVar.a(connectivityManager);
        if (j.a(networkInfo) == -1) {
            str4 = "";
            str7 = str4;
        } else {
            str4 = j.a(connectivityManager);
            if (a6) {
                str7 = "2";
            }
        }
        if ((g6 & 4) == 4 && !d7.isEmpty()) {
            this.B.clear();
            this.B.addAll(d7);
        } else {
            this.B.clear();
        }
        this.A.clear();
        this.A.addAll(c6);
        StringBuilder sb2 = new StringBuilder();
        if (kVar.k()) {
            if (a6) {
                com.autonavi.aps.amapapi.restruct.j m6 = kVar.m();
                if (kVar.a(m6)) {
                    sb2.append(m6.a());
                    sb2.append(",");
                    int c7 = m6.c();
                    if (c7 < -128 || c7 > 127) {
                        c7 = 0;
                    }
                    sb2.append(c7);
                    sb2.append(",");
                    String b6 = m6.b();
                    try {
                        i7 = b6.getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i7 = 32;
                    }
                    if (i7 >= 32) {
                        b6 = "unkwn";
                    }
                    sb2.append(b6.replace("*", "."));
                }
            }
            if (e6 != null && (arrayList = this.E) != null) {
                arrayList.clear();
                this.E.addAll(e6);
            }
        } else {
            kVar.g();
            ArrayList<l9> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.f10182b = (short) 0;
        if (!z5) {
            this.f10182b = (short) 2;
        }
        this.f10183c = str6;
        this.f10184d = str5;
        this.f10186f = Build.MODEL;
        this.f10187g = FaceEnvironment.OS + Build.VERSION.RELEASE;
        this.f10188h = j.b(context);
        this.f10189i = str8;
        this.f10190j = "0";
        this.f10191k = "0";
        this.f10192l = "0";
        this.f10193m = "0";
        this.f10194n = "0";
        this.f10195o = j6;
        this.f10196p = com.autonavi.aps.amapapi.utils.b.f10240g;
        this.f10197q = com.autonavi.aps.amapapi.utils.b.f10241h;
        this.f10199s = String.valueOf(i6);
        this.f10200t = j.i(context);
        this.f10202v = "6.4.3";
        this.f10203w = null;
        this.f10201u = "";
        this.f10204x = str4;
        this.f10205y = str7;
        this.f10206z = g6;
        this.C = eVar.l();
        this.F = k.p();
        this.D = sb2.toString();
        this.O = (int) ((j.b() - kVar.q()) / 1000);
        try {
            if (TextUtils.isEmpty(I)) {
                I = i4.F(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(K)) {
                K = i4.o(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.M)) {
                this.M = i4.E();
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = i4.D(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.S = gVar.a(this.B, this.E);
            a(this.A, this.B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb2.delete(0, sb2.length());
    }

    private void a(ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList, ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.autonavi.aps.amapapi.restruct.d> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.autonavi.aps.amapapi.restruct.d next = it.next();
                if (next.f10046r && next.f10042n) {
                    a(next, this.T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a(arrayList.get(0), this.T);
    }

    private static void a(com.autonavi.aps.amapapi.restruct.d dVar, List<com.autonavi.aps.amapapi.restruct.d> list) {
        if (dVar == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(dVar);
            return;
        }
        int i6 = -1;
        long j6 = Long.MAX_VALUE;
        int i7 = 0;
        int i8 = -1;
        while (true) {
            if (i7 >= size) {
                i6 = i8;
                break;
            }
            com.autonavi.aps.amapapi.restruct.d dVar2 = list.get(i7);
            if (dVar.c() != null && dVar.c().equals(dVar2.c())) {
                int i9 = dVar.f10047s;
                if (i9 != dVar2.f10047s) {
                    dVar2.f10048t = dVar.f10048t;
                    dVar2.f10047s = i9;
                }
            } else {
                j6 = Math.min(j6, dVar2.f10048t);
                if (j6 == dVar2.f10048t) {
                    i8 = i7;
                }
                i7++;
            }
        }
        if (i6 >= 0) {
            if (size < 3) {
                list.add(dVar);
            } else {
                if (dVar.f10048t <= j6 || i6 >= size) {
                    return;
                }
                list.remove(i6);
                list.add(dVar);
            }
        }
    }

    private static int a(String str, byte[] bArr, int i6) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i6] = 0;
                return i6 + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i6] = (byte) length;
            int i7 = i6 + 1;
            System.arraycopy(bytes, 0, bArr, i7, length);
            return i7 + length;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Req", "copyContentWithByteLen");
            bArr[i6] = 0;
            return i6 + 1;
        }
    }
}

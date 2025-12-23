package cn.jiguang.bh;

import com.umeng.analytics.pro.bi;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static f f2214a;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f2215b;

    /* renamed from: c, reason: collision with root package name */
    private static String[] f2216c;

    static {
        f fVar = new f("Message Section", 3);
        f2214a = fVar;
        f2215b = new String[4];
        f2216c = new String[4];
        fVar.a(3);
        f2214a.a(true);
        f2214a.a(0, "qd");
        f2214a.a(1, "an");
        f2214a.a(2, "au");
        f2214a.a(3, bi.az);
        String[] strArr = f2215b;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = f2216c;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i6) {
        return f2214a.d(i6);
    }
}

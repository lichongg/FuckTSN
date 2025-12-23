package com.tencent.open.b;

import com.tencent.open.utils.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected static e f40533a;

    public void a(int i6, String str, String str2, String str3, String str4, Long l6, int i7, int i8, String str5) {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f40533a == null) {
                    f40533a = new e();
                }
                eVar = f40533a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    protected e() {
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        h.a().a(m.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        h.a().a(m.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        h.a().a(m.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }
}

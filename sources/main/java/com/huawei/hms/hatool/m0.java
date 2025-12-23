package com.huawei.hms.hatool;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f33611a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f33612b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.314" + x0.a();
    }

    public void d(int i6, String str, String str2) {
        c(i6, "FormalHASDK", str + "=> " + str2);
    }

    public boolean e(int i6) {
        return this.f33611a && i6 >= this.f33612b;
    }

    public void b(int i6) {
        System.lineSeparator();
        System.lineSeparator();
        a();
        System.lineSeparator();
        this.f33612b = i6;
        this.f33611a = true;
    }

    public void c(int i6, String str, String str2) {
    }
}

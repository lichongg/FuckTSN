package com.amap.api.col.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f8233a;

    public static synchronized void a() {
        synchronized (m.class) {
            if (!f8233a) {
                n.b().g("regeo", new p("/geocode/regeo"));
                n.b().g("placeAround", new p("/place/around"));
                n.b().g("placeText", new o("/place/text"));
                n.b().g("geo", new o("/geocode/geo"));
                f8233a = true;
            }
        }
    }
}

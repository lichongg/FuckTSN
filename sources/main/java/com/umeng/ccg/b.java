package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f41545a = true;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f41546b = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f41547c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f41548d = true;

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Boolean> f41550f = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static Object f41549e = new Object();

    public static boolean a() {
        boolean z5;
        synchronized (f41549e) {
            z5 = f41545a;
        }
        return z5;
    }

    public static boolean b() {
        boolean z5;
        synchronized (f41549e) {
            z5 = f41546b;
        }
        return z5;
    }

    public static boolean c() {
        boolean z5;
        synchronized (f41549e) {
            z5 = f41547c;
        }
        return z5;
    }

    public static boolean d() {
        boolean z5;
        synchronized (f41549e) {
            z5 = f41548d;
        }
        return z5;
    }

    public static void a(boolean z5) {
        synchronized (f41549e) {
            f41548d = z5;
            f41550f.put(a.f41529e, Boolean.valueOf(z5));
        }
    }

    public static boolean a(String str) {
        boolean booleanValue;
        synchronized (f41549e) {
            try {
                booleanValue = f41550f.containsKey(str) ? f41550f.get(str).booleanValue() : true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }
}

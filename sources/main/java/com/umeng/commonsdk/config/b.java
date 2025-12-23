package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f41621a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Object f41622b = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.config.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f41623a = new b(null);

        private a() {
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void a() {
        synchronized (f41622b) {
            f41621a.clear();
        }
    }

    private b() {
    }

    public static b b() {
        return a.f41623a;
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f41622b) {
            try {
                if (!f41621a.containsKey(str)) {
                    return true;
                }
                return f41621a.get(str).booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f41622b) {
                try {
                    Map<String, Boolean> map = f41621a;
                    if (map != null) {
                        map.put(str, bool);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}

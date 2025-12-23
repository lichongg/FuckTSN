package cn.jpush.android.f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<b, cn.jpush.android.e.a> f3642a = new ConcurrentHashMap();

    public static cn.jpush.android.e.a a(b bVar) {
        return f3642a.get(bVar);
    }

    public static void a(b bVar, cn.jpush.android.e.a aVar) {
        if (aVar != null) {
            f3642a.put(bVar, aVar);
        }
    }

    public static void b(b bVar) {
        f3642a.remove(bVar);
    }
}

package com.hp.hpl.sparta;

import java.util.Hashtable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static f f32856a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static d f32857b = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements f {

        /* renamed from: a, reason: collision with root package name */
        private final Hashtable f32858a = new Hashtable();

        @Override // com.hp.hpl.sparta.q.f
        public String a(String str) {
            String str2 = (String) this.f32858a.get(str);
            if (str2 != null) {
                return str2;
            }
            this.f32858a.put(str, str);
            return str;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements d {
        @Override // com.hp.hpl.sparta.q.d
        public c a() {
            return new e(null);
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        Object get(Object obj);

        Object put(Object obj, Object obj2);

        int size();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        c a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e extends Hashtable implements c {
        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface f {
        String a(String str);
    }

    public static String a(String str) {
        return f32856a.a(str);
    }

    static c b() {
        return f32857b.a();
    }

    public static void c(d dVar) {
        f32857b = dVar;
    }

    public static void d(f fVar) {
        f32856a = fVar;
    }
}

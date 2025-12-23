package rx.plugins;

import androidx.camera.view.p;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class f {

    /* renamed from: f, reason: collision with root package name */
    private static final f f54459f = new f();

    /* renamed from: g, reason: collision with root package name */
    static final rx.plugins.b f54460g = new a();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<rx.plugins.b> f54461a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<d> f54462b = new AtomicReference<>();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicReference<h> f54463c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference<rx.plugins.a> f54464d = new AtomicReference<>();

    /* renamed from: e, reason: collision with root package name */
    private final AtomicReference<g> f54465e = new AtomicReference<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.plugins.a {
        b() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        r2 = "rxjava.plugin." + r7.substring(0, r7.length() - 6).substring(14) + ".impl";
        r1 = r10.getProperty(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0087, code lost:
    
        if (r1 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a8, code lost:
    
        throw new java.lang.IllegalStateException("Implementing class declaration for " + r0 + " missing: " + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Object e(java.lang.Class<?> r9, java.util.Properties r10) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.plugins.f.e(java.lang.Class, java.util.Properties):java.lang.Object");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends rx.plugins.b {
        a() {
        }
    }

    @Deprecated
    public static f c() {
        return f54459f;
    }

    public rx.plugins.a a() {
        if (this.f54464d.get() == null) {
            Object e6 = e(rx.plugins.a.class, h());
            if (e6 == null) {
                p.a(this.f54464d, null, new b());
            } else {
                p.a(this.f54464d, null, (rx.plugins.a) e6);
            }
        }
        return this.f54464d.get();
    }

    public rx.plugins.b b() {
        if (this.f54461a.get() == null) {
            Object e6 = e(rx.plugins.b.class, h());
            if (e6 == null) {
                p.a(this.f54461a, null, f54460g);
            } else {
                p.a(this.f54461a, null, (rx.plugins.b) e6);
            }
        }
        return this.f54461a.get();
    }

    public d d() {
        if (this.f54462b.get() == null) {
            Object e6 = e(d.class, h());
            if (e6 == null) {
                p.a(this.f54462b, null, e.f());
            } else {
                p.a(this.f54462b, null, (d) e6);
            }
        }
        return this.f54462b.get();
    }

    public g f() {
        if (this.f54465e.get() == null) {
            Object e6 = e(g.class, h());
            if (e6 == null) {
                p.a(this.f54465e, null, g.h());
            } else {
                p.a(this.f54465e, null, (g) e6);
            }
        }
        return this.f54465e.get();
    }

    public h g() {
        if (this.f54463c.get() == null) {
            Object e6 = e(h.class, h());
            if (e6 == null) {
                p.a(this.f54463c, null, i.f());
            } else {
                p.a(this.f54463c, null, (h) e6);
            }
        }
        return this.f54463c.get();
    }

    public void i(rx.plugins.a aVar) {
        if (p.a(this.f54464d, null, aVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f54463c.get());
    }

    public void j(rx.plugins.b bVar) {
        if (p.a(this.f54461a, null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f54461a.get());
    }

    public void k(d dVar) {
        if (p.a(this.f54462b, null, dVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f54462b.get());
    }

    public void l(g gVar) {
        if (p.a(this.f54465e, null, gVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f54465e.get());
    }

    public void m(h hVar) {
        if (p.a(this.f54463c, null, hVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f54463c.get());
    }

    public void n() {
        f fVar = f54459f;
        fVar.f54461a.set(null);
        fVar.f54462b.set(null);
        fVar.f54463c.set(null);
        fVar.f54464d.set(null);
        fVar.f54465e.set(null);
    }

    f() {
    }

    static Properties h() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }
}

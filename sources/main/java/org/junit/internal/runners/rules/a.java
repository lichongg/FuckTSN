package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f51420d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f51421e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f51422f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f51423g;

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends Annotation> f51424a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f51425b;

    /* renamed from: c, reason: collision with root package name */
    private final List<k> f51426c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.internal.runners.rules.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0990a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Class<? extends Annotation> f51427a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f51428b;

        /* renamed from: c, reason: collision with root package name */
        private final List<k> f51429c;

        /* synthetic */ b(Class cls, C0990a c0990a) {
            this(cls);
        }

        b e() {
            this.f51428b = true;
            return this;
        }

        private b(Class<? extends Annotation> cls) {
            this.f51427a = cls;
            this.f51428b = false;
            this.f51429c = new ArrayList();
        }

        a d() {
            return new a(this);
        }

        b f(k kVar) {
            this.f51429c.add(kVar);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements k {
        private c() {
        }

        /* synthetic */ c(C0990a c0990a) {
            this();
        }

        private boolean b(org.junit.runners.model.c<?> cVar) {
            return Modifier.isPublic(cVar.a().getModifiers());
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!b(cVar)) {
                list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must be declared in a public class."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class d implements k {
        private d() {
        }

        /* synthetic */ d(C0990a c0990a) {
            this();
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.f(cVar)) {
                list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must implement MethodRule or TestRule."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class e implements k {
        private e() {
        }

        /* synthetic */ e(C0990a c0990a) {
            this();
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.g(cVar)) {
                list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must implement TestRule."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class f implements k {
        private f() {
        }

        /* synthetic */ f(C0990a c0990a) {
            this();
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            boolean z5;
            String str;
            boolean e6 = a.e(cVar);
            if (cVar.getAnnotation(ClassRule.class) != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (cVar.g()) {
                if (e6 || !z5) {
                    if (a.e(cVar)) {
                        str = "must not be static.";
                    } else {
                        str = "must not be static or it must be annotated with @ClassRule.";
                    }
                    list.add(new org.junit.internal.runners.rules.b(cVar, cls, str));
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class g implements k {
        private g() {
        }

        /* synthetic */ g(C0990a c0990a) {
            this();
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!cVar.d()) {
                list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must be public."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class h implements k {
        private h() {
        }

        /* synthetic */ h(C0990a c0990a) {
            this();
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!cVar.g()) {
                list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must be static."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class i implements k {
        private i() {
        }

        /* synthetic */ i(C0990a c0990a) {
            this();
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.f(cVar)) {
                list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must return an implementation of MethodRule or TestRule."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class j implements k {
        private j() {
        }

        /* synthetic */ j(C0990a c0990a) {
            this();
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.g(cVar)) {
                list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must return an implementation of TestRule."));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface k {
        void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list);
    }

    private static b d() {
        return new b(ClassRule.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(org.junit.runners.model.c<?> cVar) {
        return org.junit.rules.f.class.isAssignableFrom(cVar.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(org.junit.runners.model.c<?> cVar) {
        return l.class.isAssignableFrom(cVar.getType());
    }

    private static b h() {
        return new b(Rule.class, null);
    }

    private void j(org.junit.runners.model.c<?> cVar, List<Throwable> list) {
        Iterator<k> it = this.f51426c.iterator();
        while (it.hasNext()) {
            it.next().a(cVar, this.f51424a, list);
        }
    }

    public void i(org.junit.runners.model.i iVar, List<Throwable> list) {
        Iterator it = (this.f51425b ? iVar.i(this.f51424a) : iVar.e(this.f51424a)).iterator();
        while (it.hasNext()) {
            j((org.junit.runners.model.c) it.next(), list);
        }
    }

    static {
        C0990a c0990a = null;
        f51420d = d().f(new c(c0990a)).f(new h(c0990a)).f(new g(c0990a)).f(new e(c0990a)).d();
        f51421e = h().f(new f(c0990a)).f(new g(c0990a)).f(new d(c0990a)).d();
        f51422f = d().e().f(new c(c0990a)).f(new h(c0990a)).f(new g(c0990a)).f(new j(c0990a)).d();
        f51423g = h().e().f(new f(c0990a)).f(new g(c0990a)).f(new i(c0990a)).d();
    }

    a(b bVar) {
        this.f51424a = bVar.f51427a;
        this.f51425b = bVar.f51428b;
        this.f51426c = bVar.f51429c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(org.junit.runners.model.c<?> cVar) {
        if (!e(cVar) && !g(cVar)) {
            return false;
        }
        return true;
    }
}

package org.junit.experimental.max;

import h5.c;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.k;
import org.junit.internal.runners.b;
import org.junit.internal.runners.d;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.e;
import org.junit.runner.f;
import org.junit.runner.g;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f51346b = "malformed JUnit 3 test class: ";

    /* renamed from: a, reason: collision with root package name */
    private final MaxHistory f51347a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.experimental.max.a$a, reason: collision with other inner class name */
    class C0983a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f51348a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: org.junit.experimental.max.a$a$a, reason: collision with other inner class name */
        class C0984a extends Suite {
            C0984a(Class cls, List list) throws InitializationError {
                super((Class<?>) cls, (List<g>) list);
            }
        }

        @Override // org.junit.runner.f
        public g h() {
            try {
                return new C0984a(null, this.f51348a);
            } catch (InitializationError e6) {
                return new b(null, e6);
            }
        }

        C0983a(List list) {
            this.f51348a = list;
        }
    }

    private f b(List<Description> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Description> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return new C0983a(arrayList);
    }

    private List<Description> c(f fVar) {
        ArrayList arrayList = new ArrayList();
        d(null, fVar.h().getDescription(), arrayList);
        return arrayList;
    }

    @Deprecated
    public static a e(String str) {
        return l(new File(str));
    }

    public static a l(File file) {
        return new a(file);
    }

    public Result h(f fVar) {
        return i(fVar, new e());
    }

    public Result i(f fVar, e eVar) {
        eVar.a(this.f51347a.listener());
        return eVar.i(j(fVar).h());
    }

    public f j(f fVar) {
        if (fVar instanceof c) {
            return fVar;
        }
        List<Description> c6 = c(fVar);
        Collections.sort(c6, this.f51347a.testComparator());
        return b(c6);
    }

    private a(File file) {
        this.f51347a = MaxHistory.forFolder(file);
    }

    private g a(Description description) {
        if (description.toString().equals("TestSuite with 0 tests")) {
            return Suite.G();
        }
        if (description.toString().startsWith(f51346b)) {
            return new d(new k(f(description)));
        }
        Class<?> testClass = description.getTestClass();
        if (testClass != null) {
            String methodName = description.getMethodName();
            if (methodName == null) {
                return f.a(testClass).h();
            }
            return f.i(testClass, methodName).h();
        }
        throw new RuntimeException("Can't build a runner from description [" + description + "]");
    }

    private void d(Description description, Description description2, List<Description> list) {
        if (description2.getChildren().isEmpty()) {
            if (description2.toString().equals("warning(junit.framework.TestSuite$1)")) {
                list.add(Description.createSuiteDescription(f51346b + description, new Annotation[0]));
                return;
            }
            list.add(description2);
            return;
        }
        Iterator<Description> it = description2.getChildren().iterator();
        while (it.hasNext()) {
            d(description2, it.next(), list);
        }
    }

    private Class<?> f(Description description) {
        try {
            return Class.forName(description.toString().replace(f51346b, ""));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public Result g(Class<?> cls) {
        return h(f.a(cls));
    }

    public List<Description> k(f fVar) {
        return c(j(fVar));
    }
}

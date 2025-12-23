package junit.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class JUnit4TestAdapterCache extends HashMap<Description, f> {
    private static final JUnit4TestAdapterCache fInstance = new JUnit4TestAdapterCache();
    private static final long serialVersionUID = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends RunListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f43468a;

        a(j jVar) {
            this.f43468a = jVar;
        }

        @Override // org.junit.runner.notification.RunListener
        public void b(Failure failure) throws Exception {
            this.f43468a.a(JUnit4TestAdapterCache.this.asTest(failure.getDescription()), failure.getException());
        }

        @Override // org.junit.runner.notification.RunListener
        public void c(Description description) throws Exception {
            this.f43468a.e(JUnit4TestAdapterCache.this.asTest(description));
        }

        @Override // org.junit.runner.notification.RunListener
        public void g(Description description) throws Exception {
            this.f43468a.o(JUnit4TestAdapterCache.this.asTest(description));
        }
    }

    public static JUnit4TestAdapterCache getDefault() {
        return fInstance;
    }

    public org.junit.runner.notification.a getNotifier(j jVar, c cVar) {
        org.junit.runner.notification.a aVar = new org.junit.runner.notification.a();
        aVar.d(new a(jVar));
        return aVar;
    }

    public f asTest(Description description) {
        if (description.isSuite()) {
            return createTest(description);
        }
        if (!containsKey(description)) {
            put(description, createTest(description));
        }
        return get(description);
    }

    public List<f> asTestList(Description description) {
        if (description.isTest()) {
            return Arrays.asList(asTest(description));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(asTest(it.next()));
        }
        return arrayList;
    }

    f createTest(Description description) {
        if (description.isTest()) {
            return new d(description);
        }
        k kVar = new k(description.getDisplayName());
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            kVar.b(asTest(it.next()));
        }
        return kVar;
    }
}

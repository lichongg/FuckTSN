package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<RunListener> f51513a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f51514b = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.runner.notification.a$a, reason: collision with other inner class name */
    class C0994a extends h {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Description f51515c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0994a(Description description) throws Exception {
            super(a.this);
            this.f51515c = description;
        }

        @Override // org.junit.runner.notification.a.h
        protected void a(RunListener runListener) throws Exception {
            runListener.f(this.f51515c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends h {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Result f51517c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Result result) throws Exception {
            super(a.this);
            this.f51517c = result;
        }

        @Override // org.junit.runner.notification.a.h
        protected void a(RunListener runListener) throws Exception {
            runListener.e(this.f51517c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends h {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Description f51519c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Description description) throws Exception {
            super(a.this);
            this.f51519c = description;
        }

        @Override // org.junit.runner.notification.a.h
        protected void a(RunListener runListener) throws Exception {
            runListener.g(this.f51519c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends h {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f51521c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, List list2) throws Exception {
            super(list);
            this.f51521c = list2;
        }

        @Override // org.junit.runner.notification.a.h
        protected void a(RunListener runListener) throws Exception {
            Iterator it = this.f51521c.iterator();
            while (it.hasNext()) {
                runListener.b((Failure) it.next());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends h {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Failure f51523c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Failure failure) {
            super(a.this);
            this.f51523c = failure;
        }

        @Override // org.junit.runner.notification.a.h
        protected void a(RunListener runListener) throws Exception {
            runListener.a(this.f51523c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends h {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Description f51525c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Description description) throws Exception {
            super(a.this);
            this.f51525c = description;
        }

        @Override // org.junit.runner.notification.a.h
        protected void a(RunListener runListener) throws Exception {
            runListener.d(this.f51525c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends h {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Description f51527c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Description description) throws Exception {
            super(a.this);
            this.f51527c = description;
        }

        @Override // org.junit.runner.notification.a.h
        protected void a(RunListener runListener) throws Exception {
            runListener.c(this.f51527c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class h {

        /* renamed from: a, reason: collision with root package name */
        private final List<RunListener> f51529a;

        h(a aVar) {
            this(aVar.f51513a);
        }

        protected abstract void a(RunListener runListener) throws Exception;

        h(List<RunListener> list) {
            this.f51529a = list;
        }

        void b() {
            int size = this.f51529a.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener runListener : this.f51529a) {
                try {
                    a(runListener);
                    arrayList.add(runListener);
                } catch (Exception e6) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e6));
                }
            }
            a.this.g(arrayList, arrayList2);
        }
    }

    public void m() {
        this.f51514b = true;
    }

    public void c(RunListener runListener) {
        if (runListener == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f51513a.add(0, o(runListener));
    }

    public void d(RunListener runListener) {
        if (runListener == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f51513a.add(o(runListener));
    }

    public void e(Failure failure) {
        new e(failure).b();
    }

    public void f(Failure failure) {
        g(this.f51513a, Arrays.asList(failure));
    }

    public void h(Description description) {
        new g(description).b();
    }

    public void i(Description description) {
        new f(description).b();
    }

    public void j(Result result) {
        new b(result).b();
    }

    public void k(Description description) {
        new C0994a(description).b();
    }

    public void l(Description description) throws StoppedByUserException {
        if (this.f51514b) {
            throw new StoppedByUserException();
        }
        new c(description).b();
    }

    public void n(RunListener runListener) {
        if (runListener == null) {
            throw new NullPointerException("Cannot remove a null listener");
        }
        this.f51513a.remove(o(runListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<RunListener> list, List<Failure> list2) {
        if (!list2.isEmpty()) {
            new d(list, list2).b();
        }
    }

    RunListener o(RunListener runListener) {
        if (runListener.getClass().isAnnotationPresent(RunListener.ThreadSafe.class)) {
            return runListener;
        }
        return new org.junit.runner.notification.b(runListener, this);
    }
}

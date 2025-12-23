package org.junit.validator;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class c implements org.junit.validator.e {

    /* renamed from: a, reason: collision with root package name */
    private static final List<b<?>> f51571a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class b<T extends org.junit.runners.model.a> {

        /* renamed from: a, reason: collision with root package name */
        private static final org.junit.validator.b f51572a = new org.junit.validator.b();

        private b() {
        }

        abstract Iterable<T> a(i iVar);

        abstract List<Exception> c(org.junit.validator.a aVar, T t5);

        /* synthetic */ b(a aVar) {
            this();
        }

        private List<Exception> b(T t5) {
            ArrayList arrayList = new ArrayList();
            for (Annotation annotation : t5.getAnnotations()) {
                ValidateWith validateWith = (ValidateWith) annotation.annotationType().getAnnotation(ValidateWith.class);
                if (validateWith != null) {
                    arrayList.addAll(c(f51572a.a(validateWith), t5));
                }
            }
            return arrayList;
        }

        public List<Exception> d(i iVar) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = a(iVar).iterator();
            while (it.hasNext()) {
                arrayList.addAll(b(it.next()));
            }
            return arrayList;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.validator.c$c, reason: collision with other inner class name */
    private static class C0996c extends b<i> {
        private C0996c() {
            super(null);
        }

        /* synthetic */ C0996c(a aVar) {
            this();
        }

        @Override // org.junit.validator.c.b
        Iterable<i> a(i iVar) {
            return Collections.singletonList(iVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.junit.validator.c.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<Exception> c(org.junit.validator.a aVar, i iVar) {
            return aVar.a(iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d extends b<org.junit.runners.model.b> {
        private d() {
            super(null);
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // org.junit.validator.c.b
        Iterable<org.junit.runners.model.b> a(i iVar) {
            return iVar.d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.junit.validator.c.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<Exception> c(org.junit.validator.a aVar, org.junit.runners.model.b bVar) {
            return aVar.b(bVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e extends b<org.junit.runners.model.d> {
        private e() {
            super(null);
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        @Override // org.junit.validator.c.b
        Iterable<org.junit.runners.model.d> a(i iVar) {
            return iVar.h();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.junit.validator.c.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<Exception> c(org.junit.validator.a aVar, org.junit.runners.model.d dVar) {
            return aVar.c(dVar);
        }
    }

    static {
        a aVar = null;
        f51571a = Arrays.asList(new C0996c(aVar), new e(aVar), new d(aVar));
    }

    @Override // org.junit.validator.e
    public List<Exception> a(i iVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<b<?>> it = f51571a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().d(iVar));
        }
        return arrayList;
    }
}

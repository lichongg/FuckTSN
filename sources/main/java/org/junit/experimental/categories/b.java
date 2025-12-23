package org.junit.experimental.categories;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b extends org.junit.validator.a {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<Class<? extends Annotation>> f51341b = Collections.unmodifiableSet(new HashSet(Arrays.asList(BeforeClass.class, AfterClass.class, Before.class, After.class)));

    @Override // org.junit.validator.a
    public List<Exception> c(org.junit.runners.model.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : dVar.getAnnotations()) {
            for (Class<? extends Annotation> cls : f51341b) {
                if (annotation.annotationType().isAssignableFrom(cls)) {
                    d(arrayList, cls);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void d(List<Exception> list, Class<?> cls) {
        list.add(new Exception(String.format("@%s can not be combined with @Category", cls.getSimpleName())));
    }
}

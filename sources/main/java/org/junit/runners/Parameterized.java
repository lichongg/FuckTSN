package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.g;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Parameterized extends Suite {

    /* renamed from: h, reason: collision with root package name */
    private static final org.junit.runners.parameterized.c f51533h = new org.junit.runners.parameterized.b();

    /* renamed from: i, reason: collision with root package name */
    private static final List<g> f51534i = Collections.EMPTY_LIST;

    /* renamed from: g, reason: collision with root package name */
    private final List<g> f51535g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameter {
        int value() default 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameters {
        String name() default "{index}";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UseParametersRunnerFactory {
        Class<? extends org.junit.runners.parameterized.c> value() default org.junit.runners.parameterized.b.class;
    }

    public Parameterized(Class<?> cls) throws Throwable {
        super(cls, f51534i);
        this.f51535g = Collections.unmodifiableList(K(J(), ((Parameters) O().getAnnotation(Parameters.class)).name(), P(cls)));
    }

    private org.junit.runners.parameterized.d L(String str, int i6, Object obj) {
        return M(s(), str, i6, obj instanceof Object[] ? (Object[]) obj : new Object[]{obj});
    }

    private static org.junit.runners.parameterized.d M(i iVar, String str, int i6, Object[] objArr) {
        return new org.junit.runners.parameterized.d("[" + MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i6)), objArr) + "]", iVar, Arrays.asList(objArr));
    }

    private List<org.junit.runners.parameterized.d> N(Iterable<Object> iterable, String str) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            arrayList.add(L(str, i6, it.next()));
            i6++;
        }
        return arrayList;
    }

    private org.junit.runners.parameterized.c P(Class<?> cls) throws InstantiationException, IllegalAccessException {
        UseParametersRunnerFactory useParametersRunnerFactory = (UseParametersRunnerFactory) cls.getAnnotation(UseParametersRunnerFactory.class);
        return useParametersRunnerFactory == null ? f51533h : useParametersRunnerFactory.value().newInstance();
    }

    @Override // org.junit.runners.Suite, org.junit.runners.d
    protected List<g> o() {
        return this.f51535g;
    }

    private Iterable<Object> J() throws Throwable {
        Object l6 = O().l(null, new Object[0]);
        if (l6 instanceof Iterable) {
            return (Iterable) l6;
        }
        if (l6 instanceof Object[]) {
            return Arrays.asList((Object[]) l6);
        }
        throw Q();
    }

    private List<g> K(Iterable<Object> iterable, String str, org.junit.runners.parameterized.c cVar) throws InitializationError, Exception {
        try {
            List<org.junit.runners.parameterized.d> N = N(iterable, str);
            ArrayList arrayList = new ArrayList();
            Iterator<org.junit.runners.parameterized.d> it = N.iterator();
            while (it.hasNext()) {
                arrayList.add(cVar.a(it.next()));
            }
            return arrayList;
        } catch (ClassCastException unused) {
            throw Q();
        }
    }

    private org.junit.runners.model.d O() throws Exception {
        for (org.junit.runners.model.d dVar : s().i(Parameters.class)) {
            if (dVar.g() && dVar.d()) {
                return dVar;
            }
        }
        throw new Exception("No public static parameters method on class " + s().k());
    }

    private Exception Q() throws Exception {
        return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", s().k(), O().c()));
    }
}

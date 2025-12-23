package org.junit.runners.parameterized;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.Parameterized;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends org.junit.runners.b {

    /* renamed from: g, reason: collision with root package name */
    private final Object[] f51564g;

    /* renamed from: h, reason: collision with root package name */
    private final String f51565h;

    @Override // org.junit.runners.d
    protected Annotation[] r() {
        return new Annotation[0];
    }

    @Override // org.junit.runners.b
    protected String U(org.junit.runners.model.d dVar) {
        return dVar.c() + q();
    }

    @Override // org.junit.runners.d
    protected String q() {
        return this.f51565h;
    }

    public a(d dVar) throws InitializationError {
        super(dVar.c().j());
        this.f51564g = dVar.b().toArray(new Object[dVar.b().size()]);
        this.f51565h = dVar.a();
    }

    private Object j0() throws Exception {
        return s().l().newInstance(this.f51564g);
    }

    private Object k0() throws Exception {
        List<org.junit.runners.model.b> m02 = m0();
        if (m02.size() == this.f51564g.length) {
            Object newInstance = s().j().newInstance();
            Iterator<org.junit.runners.model.b> it = m02.iterator();
            while (it.hasNext()) {
                Field i6 = it.next().i();
                int value = ((Parameterized.Parameter) i6.getAnnotation(Parameterized.Parameter.class)).value();
                try {
                    i6.set(newInstance, this.f51564g[value]);
                } catch (IllegalArgumentException e6) {
                    throw new Exception(s().k() + ": Trying to set " + i6.getName() + " with the value " + this.f51564g[value] + " that is not the right type (" + this.f51564g[value].getClass().getSimpleName() + " instead of " + i6.getType().getSimpleName() + ").", e6);
                }
            }
            return newInstance;
        }
        throw new Exception("Wrong number of parameters and @Parameter fields. @Parameter fields counted: " + m02.size() + ", available parameters: " + this.f51564g.length + ".");
    }

    private boolean l0() {
        return !m0().isEmpty();
    }

    private List<org.junit.runners.model.b> m0() {
        return s().e(Parameterized.Parameter.class);
    }

    @Override // org.junit.runners.b
    public Object G() throws Exception {
        if (l0()) {
            return k0();
        }
        return j0();
    }

    @Override // org.junit.runners.b
    protected void V(List<Throwable> list) {
        a0(list);
        if (l0()) {
            c0(list);
        }
    }

    @Override // org.junit.runners.b
    protected void W(List<Throwable> list) {
        super.W(list);
        if (l0()) {
            List<org.junit.runners.model.b> m02 = m0();
            int size = m02.size();
            int[] iArr = new int[size];
            Iterator<org.junit.runners.model.b> it = m02.iterator();
            while (it.hasNext()) {
                int value = ((Parameterized.Parameter) it.next().i().getAnnotation(Parameterized.Parameter.class)).value();
                if (value >= 0 && value <= m02.size() - 1) {
                    iArr[value] = iArr[value] + 1;
                } else {
                    list.add(new Exception("Invalid @Parameter value: " + value + ". @Parameter fields counted: " + m02.size() + ". Please use an index between 0 and " + (m02.size() - 1) + "."));
                }
            }
            for (int i6 = 0; i6 < size; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0) {
                    list.add(new Exception("@Parameter(" + i6 + ") is never used."));
                } else if (i7 > 1) {
                    list.add(new Exception("@Parameter(" + i6 + ") is used more than once (" + i7 + ")."));
                }
            }
        }
    }

    @Override // org.junit.runners.d
    protected h i(org.junit.runner.notification.a aVar) {
        return h(aVar);
    }
}

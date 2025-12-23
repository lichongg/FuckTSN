package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class c<T extends c<T>> implements a {
    public abstract Class<?> a();

    protected abstract int b();

    public abstract String c();

    abstract boolean f(T t5);

    public abstract Class<?> getType();

    public boolean d() {
        return Modifier.isPublic(b());
    }

    boolean e(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (f(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        return Modifier.isStatic(b());
    }
}

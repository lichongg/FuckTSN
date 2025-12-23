package org.junit.runners;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.internal.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum MethodSorters {
    NAME_ASCENDING(f.f51385b),
    JVM(null),
    DEFAULT(f.f51384a);

    private final Comparator<Method> comparator;

    public Comparator<Method> getComparator() {
        return this.comparator;
    }

    MethodSorters(Comparator comparator) {
        this.comparator = comparator;
    }
}

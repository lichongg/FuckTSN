package org.junit.internal.runners.model;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class b {
    protected abstract Object b() throws Throwable;

    public Object a() throws Throwable {
        try {
            return b();
        } catch (InvocationTargetException e6) {
            throw e6.getTargetException();
        }
    }
}

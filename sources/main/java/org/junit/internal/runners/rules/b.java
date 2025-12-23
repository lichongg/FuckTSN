package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import org.junit.runners.model.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class b extends Exception {
    public b(c<?> cVar, Class<? extends Annotation> cls, String str) {
        super(String.format("The @%s '%s' %s", cls.getSimpleName(), cVar.c(), str));
    }
}

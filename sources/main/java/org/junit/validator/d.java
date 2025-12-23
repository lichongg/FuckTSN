package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Exception> f51573a = Collections.EMPTY_LIST;

    @Override // org.junit.validator.e
    public List<Exception> a(i iVar) {
        if (iVar.p()) {
            return f51573a;
        }
        return Collections.singletonList(new Exception("The class " + iVar.k() + " is not public."));
    }
}

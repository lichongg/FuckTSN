package org.junit.runners.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MultipleFailureException extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public List<Throwable> getFailures() {
        return Collections.unmodifiableList(this.fErrors);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(String.format("There were %d errors:", Integer.valueOf(this.fErrors.size())));
        for (Throwable th : this.fErrors) {
            sb.append(String.format("\n  %s(%s)", th.getClass().getName(), th.getMessage()));
        }
        return sb.toString();
    }

    public MultipleFailureException(List<Throwable> list) {
        this.fErrors = new ArrayList(list);
    }

    public static void assertEmpty(List<Throwable> list) throws Exception {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            throw org.junit.internal.i.b(list.get(0));
        }
        throw new org.junit.internal.runners.model.MultipleFailureException(list);
    }
}

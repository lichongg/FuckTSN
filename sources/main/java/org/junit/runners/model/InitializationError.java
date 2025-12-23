package org.junit.runners.model;

import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class InitializationError extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public InitializationError(List<Throwable> list) {
        this.fErrors = list;
    }

    public List<Throwable> getCauses() {
        return this.fErrors;
    }

    public InitializationError(Throwable th) {
        this((List<Throwable>) Arrays.asList(th));
    }

    public InitializationError(String str) {
        this(new Exception(str));
    }
}

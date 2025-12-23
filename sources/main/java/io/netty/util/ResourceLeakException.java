package io.netty.util;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class ResourceLeakException extends RuntimeException {
    private static final long serialVersionUID = 7186453858343358280L;
    private final StackTraceElement[] cachedStackTrace;

    public ResourceLeakException() {
        this.cachedStackTrace = getStackTrace();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceLeakException)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(this.cachedStackTrace, ((ResourceLeakException) obj).cachedStackTrace);
    }

    public int hashCode() {
        int i6 = 0;
        for (StackTraceElement stackTraceElement : this.cachedStackTrace) {
            i6 = (i6 * 31) + stackTraceElement.hashCode();
        }
        return i6;
    }

    public ResourceLeakException(String str) {
        super(str);
        this.cachedStackTrace = getStackTrace();
    }

    public ResourceLeakException(String str, Throwable th) {
        super(str, th);
        this.cachedStackTrace = getStackTrace();
    }

    public ResourceLeakException(Throwable th) {
        super(th);
        this.cachedStackTrace = getStackTrace();
    }
}

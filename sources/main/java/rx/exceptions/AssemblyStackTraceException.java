package rx.exceptions;

import java.util.HashSet;
import rx.plugins.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class AssemblyStackTraceException extends RuntimeException {
    private static final long serialVersionUID = 2038859767182585852L;

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public static AssemblyStackTraceException find(Throwable th) {
        HashSet hashSet = new HashSet();
        while (!(th instanceof AssemblyStackTraceException)) {
            if (th != null && th.getCause() != null) {
                th = th.getCause();
                if (!hashSet.add(th)) {
                }
            }
            return null;
        }
        return (AssemblyStackTraceException) th;
    }

    public void attachTo(Throwable th) {
        HashSet hashSet = new HashSet();
        while (th.getCause() != null) {
            th = th.getCause();
            if (!hashSet.add(th)) {
                c.I(this);
                return;
            }
        }
        try {
            th.initCause(this);
        } catch (IllegalStateException unused) {
            c.I(new RuntimeException("Received an exception with a cause set to null, instead of being unset. To fix this, look down the chain of causes. The last exception had a cause explicitly set to null. It should be unset instead.", th));
        }
    }

    public AssemblyStackTraceException(String str) {
        super(str);
    }
}

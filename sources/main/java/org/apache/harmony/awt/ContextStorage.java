package org.apache.harmony.awt;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import org.apache.harmony.awt.datatransfer.DTK;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ContextStorage {
    private static final ContextStorage globalContext = new ContextStorage();
    private DTK dtk;
    private GraphicsEnvironment graphicsEnvironment;
    private Toolkit toolkit;
    private volatile boolean shutdownPending = false;
    private final Object contextLock = new ContextLock(this, null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class ContextLock {
        private ContextLock() {
        }

        /* synthetic */ ContextLock(ContextStorage contextStorage, ContextLock contextLock) {
            this();
        }
    }

    private static ContextStorage getCurrentContext() {
        return globalContext;
    }

    public static Object getContextLock() {
        return getCurrentContext().contextLock;
    }

    public static DTK getDTK() {
        return getCurrentContext().dtk;
    }

    public static Toolkit getDefaultToolkit() {
        return getCurrentContext().toolkit;
    }

    public static GraphicsEnvironment getGraphicsEnvironment() {
        return getCurrentContext().graphicsEnvironment;
    }

    public static void setDTK(DTK dtk) {
        getCurrentContext().dtk = dtk;
    }

    public static void setDefaultToolkit(Toolkit toolkit) {
        getCurrentContext().toolkit = toolkit;
    }

    public static void setGraphicsEnvironment(GraphicsEnvironment graphicsEnvironment) {
        getCurrentContext().graphicsEnvironment = graphicsEnvironment;
    }

    public static boolean shutdownPending() {
        return getCurrentContext().shutdownPending;
    }

    void shutdown() {
    }
}

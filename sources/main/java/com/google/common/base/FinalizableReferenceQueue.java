package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public class FinalizableReferenceQueue implements Closeable {
    private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    private static final Method startFinalizer = getStartFinalizer(loadFinalizer(new SystemLoader(), new DecoupledLoader(), new DirectLoader()));
    final PhantomReference<Object> frqRef;
    final ReferenceQueue<Object> queue;
    final boolean threadStarted;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class DecoupledLoader implements FinalizerLoader {
        private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        URL getBaseUrl() throws IOException {
            String str = FinalizableReferenceQueue.FINALIZER_CLASS_NAME.replace('.', '/') + ".class";
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            }
            String url = resource.toString();
            if (url.endsWith(str)) {
                return new URL(resource, url.substring(0, url.length() - str.length()));
            }
            throw new IOException("Unsupported path style: " + url);
        }

        URLClassLoader newLoader(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }

        DecoupledLoader() {
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @NullableDecl
        public Class<?> loadFinalizer() {
            try {
                return newLoader(getBaseUrl()).loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
            } catch (Exception e6) {
                FinalizableReferenceQueue.logger.log(Level.WARNING, LOADING_ERROR, (Throwable) e6);
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class DirectLoader implements FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class<?> loadFinalizer() {
            try {
                return Class.forName(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
            } catch (ClassNotFoundException e6) {
                throw new AssertionError(e6);
            }
        }

        DirectLoader() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface FinalizerLoader {
        @NullableDecl
        Class<?> loadFinalizer();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SystemLoader implements FinalizerLoader {

        @VisibleForTesting
        static boolean disabled;

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @NullableDecl
        public Class<?> loadFinalizer() {
            if (disabled) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
                return null;
            }
        }

        SystemLoader() {
        }
    }

    private static Class<?> loadFinalizer(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader finalizerLoader : finalizerLoaderArr) {
            Class<?> loadFinalizer = finalizerLoader.loadFinalizer();
            if (loadFinalizer != null) {
                return loadFinalizer;
            }
        }
        throw new AssertionError();
    }

    static Method getStartFinalizer(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e6) {
            throw new AssertionError(e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void cleanUp() {
        if (this.threadStarted) {
            return;
        }
        while (true) {
            Reference<? extends Object> poll = this.queue.poll();
            if (poll == 0) {
                return;
            }
            poll.clear();
            try {
                ((FinalizableReference) poll).finalizeReferent();
            } catch (Throwable th) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frqRef.enqueue();
        cleanUp();
    }

    public FinalizableReferenceQueue() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.queue = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.frqRef = phantomReference;
        boolean z5 = false;
        try {
            startFinalizer.invoke(null, FinalizableReference.class, referenceQueue, phantomReference);
            z5 = true;
        } catch (IllegalAccessException e6) {
            throw new AssertionError(e6);
        } catch (Throwable th) {
            logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
        }
        this.threadStarted = z5;
    }
}

package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class CleanerJava6 implements Cleaner {
    private static final Field CLEANER_FIELD;
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CleanerJava6.class);

    static {
        Field field;
        Method method;
        Object doPrivileged;
        Object obj;
        long j6;
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1);
        long j7 = -1;
        Throwable th = null;
        try {
            doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava6.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = allocateDirect.getClass().getDeclaredField("cleaner");
                        if (PlatformDependent.hasUnsafe()) {
                            return declaredField;
                        }
                        declaredField.setAccessible(true);
                        return declaredField;
                    } catch (Throwable th2) {
                        return th2;
                    }
                }
            });
        } catch (Throwable th2) {
            field = null;
            method = null;
            th = th2;
        }
        if (doPrivileged instanceof Throwable) {
            throw ((Throwable) doPrivileged);
        }
        field = (Field) doPrivileged;
        if (PlatformDependent.hasUnsafe()) {
            j6 = PlatformDependent0.objectFieldOffset(field);
            obj = PlatformDependent0.getObject(allocateDirect, j6);
        } else {
            obj = field.get(allocateDirect);
            j6 = -1;
        }
        method = obj.getClass().getDeclaredMethod("clean", null);
        method.invoke(obj, null);
        j7 = j6;
        if (th == null) {
            logger.debug("java.nio.ByteBuffer.cleaner(): available");
        } else {
            logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", th);
        }
        CLEANER_FIELD = field;
        CLEANER_FIELD_OFFSET = j7;
        CLEAN_METHOD = method;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void freeDirectBuffer0(ByteBuffer byteBuffer) throws Exception {
        long j6 = CLEANER_FIELD_OFFSET;
        Object object = j6 == -1 ? CLEANER_FIELD.get(byteBuffer) : PlatformDependent0.getObject(byteBuffer, j6);
        if (object != null) {
            CLEAN_METHOD.invoke(object, null);
        }
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Throwable th = (Throwable) AccessController.doPrivileged(new PrivilegedAction<Throwable>() { // from class: io.netty.util.internal.CleanerJava6.2
            @Override // java.security.PrivilegedAction
            public Throwable run() {
                try {
                    CleanerJava6.freeDirectBuffer0(byteBuffer);
                    return null;
                } catch (Throwable th2) {
                    return th2;
                }
            }
        });
        if (th != null) {
            PlatformDependent0.throwException(th);
        }
    }

    static boolean isSupported() {
        return (CLEANER_FIELD_OFFSET == -1 && CLEANER_FIELD == null) ? false : true;
    }

    CleanerJava6() {
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            return;
        }
        if (System.getSecurityManager() == null) {
            try {
                freeDirectBuffer0(byteBuffer);
                return;
            } catch (Throwable th) {
                PlatformDependent0.throwException(th);
                return;
            }
        }
        freeDirectBufferPrivileged(byteBuffer);
    }
}

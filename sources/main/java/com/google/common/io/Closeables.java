package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Closeables {

    @VisibleForTesting
    static final Logger logger = Logger.getLogger(Closeables.class.getName());

    public static void closeQuietly(@NullableDecl InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }

    public static void close(@NullableDecl Closeable closeable, boolean z5) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e6) {
            if (!z5) {
                throw e6;
            }
            logger.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e6);
        }
    }

    private Closeables() {
    }

    public static void closeQuietly(@NullableDecl Reader reader) {
        try {
            close(reader, true);
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }
}

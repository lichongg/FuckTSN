package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Flushables {
    private static final Logger logger = Logger.getLogger(Flushables.class.getName());

    public static void flushQuietly(Flushable flushable) {
        try {
            flush(flushable, true);
        } catch (IOException e6) {
            logger.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e6);
        }
    }

    private Flushables() {
    }

    public static void flush(Flushable flushable, boolean z5) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e6) {
            if (z5) {
                logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e6);
                return;
            }
            throw e6;
        }
    }
}

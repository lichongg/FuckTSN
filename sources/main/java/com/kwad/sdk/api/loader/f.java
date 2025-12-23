package com.kwad.sdk.api.loader;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f implements Thread.UncaughtExceptionHandler {
    private static f atX;
    private Thread.UncaughtExceptionHandler atY;
    private int atZ;
    private long aub;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean aua = new AtomicBoolean();

    public static f aW(Context context) {
        if (atX == null) {
            synchronized (f.class) {
                try {
                    if (atX == null) {
                        atX = new f(context);
                    }
                } finally {
                }
            }
        }
        return atX;
    }

    public final void cancel() {
        this.aua.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.atY = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                this.aua.get();
            }
            if (!this.aua.get() && this.aub > 0 && System.currentTimeMillis() - this.aub <= this.atZ) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.g("filterStack", th);
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && booleanValue) {
                    b.a(context, i.auf, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.atY;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.atY;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.atY != null) {
                    this.atY.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }

    private f(Context context) {
        this.mContext = context;
    }

    public final void cp(int i6) {
        this.aub = System.currentTimeMillis();
        this.atZ = i6;
    }
}

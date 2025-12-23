package com.kwad.sdk.crash.utils;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class a {
        private a() {
        }

        abstract Object Ma();

        abstract void println(Object obj);

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends a {
        private final PrintWriter aQW;

        b(PrintWriter printWriter) {
            super((byte) 0);
            this.aQW = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final Object Ma() {
            return this.aQW;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final void println(Object obj) {
            this.aQW.println(obj);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }

    private static void a(Throwable th, a aVar) {
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.Ma()) {
            try {
                aVar.println(th);
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    aVar.println("\tat " + stackTraceElement);
                }
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, "Suppressed: ", "\t", newSetFromMap);
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    a(cause, aVar, "Caused by: ", "", newSetFromMap);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.println(str2 + "\tat " + stackTraceElement);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", str2 + "\t", set);
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th + "]");
    }
}

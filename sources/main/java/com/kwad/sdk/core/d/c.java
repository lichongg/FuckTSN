package com.kwad.sdk.core.d;

import android.util.Log;
import com.ksad.annotation.invoker.ForInvoker;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static boolean aEb = true;
    private static boolean aEc = com.kwad.sdk.core.d.a.oz.booleanValue();
    private static final com.kwad.sdk.core.d.a.a aEd = new b();
    private static final List<com.kwad.sdk.core.d.a.a> aEe = new CopyOnWriteArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        void b(com.kwad.sdk.core.d.a.a aVar);
    }

    public static void a(com.kwad.sdk.core.d.a.a aVar) {
        List<com.kwad.sdk.core.d.a.a> list = aEe;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public static void d(String str, String str2) {
        S(dX(str), dY(str2));
    }

    public static void e(final String str, String str2) {
        final String dY = dY(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.9
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.dX(str), dY);
            }
        });
    }

    public static void w(final String str, String str2) {
        final String dY = dY(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.7
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.dX(str), dY);
            }
        });
    }

    private static void R(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.1
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    private static void S(String str, String str2) {
        if (str2 == null || str2.length() <= 4000) {
            R(str, str2);
        } else {
            R(str, str2.substring(0, 4000));
            S(str, str2.substring(4000));
        }
    }

    public static void d(String str, Throwable th) {
        d(str, th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dX(String str) {
        return "KSAd_" + str;
    }

    private static String dY(String str) {
        return str + " " + zJ();
    }

    public static void init(boolean z5) {
        aEb = z5;
        List<com.kwad.sdk.core.d.a.a> list = aEe;
        list.clear();
        list.add(aEd);
        Hw();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.2
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.sdk.core.d.a.oz.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.3
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    private static String zJ() {
        int i6;
        String str;
        if (!aEc) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i6 = stackTrace[3].getLineNumber();
        } else {
            i6 = -1;
            str = "unknown";
        }
        return "(" + str + ':' + i6 + ')';
    }

    @ForInvoker(methodId = "registerLogger")
    private static void Hw() {
        com.kwad.sdk.commercial.h.a.register();
    }

    public static void T(final String str, String str2) {
        final String dY = dY(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.5
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.dX(str), dY, true);
            }
        });
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.a.a aVar2 : aEe) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(final String str, String str2, Throwable th) {
        final String dY = dY(str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.10
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.dX(str), dY);
            }
        });
    }

    public static void i(final String str, String str2) {
        final String dY = dY(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.6
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.i(c.dX(str), dY);
            }
        });
    }

    public static void v(final String str, String str2) {
        final String dY = dY(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.4
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.dX(str), dY);
            }
        });
    }

    public static void w(final String str, Throwable th) {
        final String dY = dY(Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.8
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.dX(str), dY, com.kwad.sdk.core.d.a.oz.booleanValue());
            }
        });
    }
}

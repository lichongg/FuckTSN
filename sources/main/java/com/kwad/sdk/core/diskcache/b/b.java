package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                OutputStream outputStream = null;
                try {
                    a.C0678a dE = com.kwad.sdk.core.diskcache.a.a.this.dE(str2);
                    if (dE != null) {
                        outputStream = dE.ds(0);
                        if (b.a(str, outputStream, new a.C0688a())) {
                            dE.commit();
                        } else {
                            dE.abort();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.flush();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (IOException unused) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (Throwable th) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            }
        });
    }

    static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) {
        a.c cVar;
        a.c cVar2 = null;
        try {
            cVar = aVar.dD(str);
            if (cVar != null) {
                try {
                    File dv = cVar.dv(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    return dv;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar2 = cVar;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
        return null;
    }

    static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a.C0688a c0688a) {
        boolean z5 = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0678a dE = aVar.dE(str2);
                if (dE != null) {
                    outputStream = dE.ds(0);
                    if (a(str, outputStream, c0688a)) {
                        dE.commit();
                        z5 = true;
                    } else {
                        dE.abort();
                    }
                    aVar.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return z5;
            } catch (IOException e6) {
                c0688a.msg = e6.getMessage();
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return z5;
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0688a c0688a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0688a, -1L, true, null);
    }
}

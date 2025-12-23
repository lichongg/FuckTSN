package com.kwad.components.core.o.b.a;

import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class k implements IOfflineCompoLogcat {
    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2) {
        com.kwad.sdk.core.d.c.e(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2) {
        com.kwad.sdk.core.d.c.v(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2) {
        com.kwad.sdk.core.d.c.w(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2, Throwable th) {
        com.kwad.sdk.core.d.c.e(str, str2, th);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoLogcat
    public final boolean isLoggable() {
        return com.kwad.sdk.core.d.c.aEb;
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2, boolean z5) {
        if (z5) {
            com.kwad.sdk.core.d.c.T(str, str2);
        } else {
            com.kwad.sdk.core.d.c.v(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2, boolean z5) {
        if (z5 || com.kwad.components.core.a.oz.booleanValue()) {
            com.kwad.sdk.core.d.c.w(str, str2);
        }
    }

    k() {
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void d(String str, String str2) {
        com.kwad.sdk.core.d.c.d(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void i(String str, String str2) {
        com.kwad.sdk.core.d.c.i(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTrace(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTrace(th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTraceOnly(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
    }
}

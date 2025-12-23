package com.kwad.components.offline.c;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements com.kwad.sdk.core.d.a.a {
    private final IObiwanLogcat akd;

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        this.akd.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        this.akd.w(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        this.akd.d(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        this.akd.e(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        this.akd.i(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
        this.akd.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z5) {
        this.akd.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z5) {
        this.akd.w(str, str2, z5);
    }

    public c(IObiwanLogcat iObiwanLogcat) {
        this.akd = iObiwanLogcat;
    }
}

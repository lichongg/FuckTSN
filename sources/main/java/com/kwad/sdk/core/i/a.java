package com.kwad.sdk.core.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static c aKc;
    private static c aKd;

    public static c j(boolean z5, boolean z6) {
        c cVar;
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter useKwaiUA: " + z5 + ", unionUAMark: " + z6);
        if (z5) {
            if (aKc == null) {
                aKc = new b();
            }
            cVar = aKc;
        } else {
            if (aKd == null) {
                aKd = new d();
            }
            cVar = aKd;
        }
        cVar.bt(z6);
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter result: " + cVar);
        return cVar;
    }
}

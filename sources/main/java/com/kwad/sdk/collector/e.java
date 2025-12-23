package com.kwad.sdk.collector;

import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    public static String cD(String str) {
        try {
            return new String(com.kwad.sdk.core.a.c.Hf().encode(q.j(w.V(new File(str)))));
        } catch (IOException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return null;
        }
    }
}

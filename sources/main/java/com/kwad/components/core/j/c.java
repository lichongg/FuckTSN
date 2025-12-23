package com.kwad.components.core.j;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private Object Rf;
    private AdTemplate Rg;

    public static List<AdTemplate> n(List<c> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAdTemplate());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kwad.sdk.core.response.model.AdTemplate getAdTemplate() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.Rf
            if (r0 == 0) goto Lb
            com.kwad.components.core.j.b r0 = (com.kwad.components.core.j.b) r0     // Catch: java.lang.Exception -> Lb
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.getAdTemplate()     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L10
            com.kwad.sdk.core.response.model.AdTemplate r0 = r1.Rg
        L10:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.j.c.getAdTemplate():com.kwad.sdk.core.response.model.AdTemplate");
    }

    public final Object getHost() {
        return this.Rf;
    }

    public c(@NonNull AdTemplate adTemplate, int i6) {
        this.Rf = null;
        try {
            this.Rf = new b(adTemplate, i6);
        } catch (Throwable unused) {
            this.Rg = adTemplate;
        }
    }
}

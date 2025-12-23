package com.kwad.components.core.t;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k {
    public static boolean d(@NonNull AdTemplate adTemplate, boolean z5) {
        if (!z5 && com.kwad.sdk.core.response.b.b.dD(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            return com.kwad.sdk.core.config.e.Gd();
        }
        return false;
    }

    public static void f(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0616a(context).ao(true).aB(adTemplate));
    }
}

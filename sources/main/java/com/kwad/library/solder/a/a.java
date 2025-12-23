package com.kwad.library.solder.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static void a(Context context, @NonNull b bVar, b.c cVar) {
        i.zS().a(context, new c(bVar), cVar);
    }

    public static void a(Context context, @NonNull com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.zS().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }

    public static com.kwad.library.b.a k(Context context, String str) {
        com.kwad.library.solder.lib.a.a m6 = i.zS().m(context, str);
        if (m6 != null && m6.isLoaded() && (m6 instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) m6;
        }
        return null;
    }

    public static void l(Context context, String str) {
        i.zS().l(context, str);
    }
}

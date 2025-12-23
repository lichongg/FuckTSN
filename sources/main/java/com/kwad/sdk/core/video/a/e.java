package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private static boolean ZG = false;
    private static AtomicBoolean aKu = null;
    private static int aKv = -1;
    private static final AtomicBoolean aKw = new AtomicBoolean(false);
    private static final AtomicBoolean aKx = new AtomicBoolean(false);
    private static int aKy;

    public static boolean DH() {
        return aKx.get() || com.kwad.framework.a.a.MY.booleanValue();
    }

    public static int Ka() {
        return aKy;
    }

    public static boolean Kb() {
        AtomicBoolean atomicBoolean = aKu;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aKu = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z5, boolean z6, boolean z7, int i6) {
        boolean z8;
        b bVar;
        b bVar2;
        try {
            if (DH() && z6 && Kb()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i6);
                aKy = 2;
                dVar.bu(z5);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                aKy = 1;
                bVar2 = bVar3;
            }
            z8 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!ZG) {
                ZG = true;
                com.kwad.sdk.service.d.gatherException(th);
            }
            b bVar4 = new b();
            aKy = 1;
            z8 = true;
            bVar = bVar4;
        }
        int a6 = av.a(DH(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk(), z6, Kb(), z8, z7, bVar.getMediaPlayerType());
        com.kwad.sdk.core.d.c.T("KwaiPlayHelper", "player v=" + Integer.toBinaryString(a6));
        if (aKv != a6) {
            aKv = a6;
            dL(a6);
        }
        return bVar;
    }

    private static void dL(int i6) {
        n nVar = new n(10212L);
        nVar.aHl = i6;
        com.kwad.sdk.core.report.g.a2(nVar);
    }
}

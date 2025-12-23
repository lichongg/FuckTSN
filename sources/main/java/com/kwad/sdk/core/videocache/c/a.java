package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static f aLG;

    public static f bR(Context context) {
        return b(context, 0, 0);
    }

    public static f b(Context context, int i6, int i7) {
        f fVar = aLG;
        if (fVar != null) {
            return fVar;
        }
        f c6 = c(context, i6, i7);
        aLG = c6;
        return c6;
    }

    private static f c(Context context, int i6, int i7) {
        return new f.a(context).aJ(IjkMediaMeta.AV_CH_STEREO_LEFT).dN(i6).dO(i7).Kn();
    }
}

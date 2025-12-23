package com.bytedance.msdk.tl.r;

import android.util.SparseArray;
import java.util.function.Function;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static Function<SparseArray<Object>, Object> f25232j;

    public static void j(Function<SparseArray<Object>, Object> function) {
        f25232j = function;
    }

    public static void j(com.bytedance.msdk.up.j jVar, boolean z5) {
        if (jVar != null && com.bytedance.msdk.core.j.qv().ch()) {
            xt(jVar, z5);
        }
    }

    private static void xt(com.bytedance.msdk.up.j jVar, boolean z5) {
        if (f25232j != null) {
            com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
            if (z5) {
                j6.j(10002).j(Void.class);
                j6.j(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER, jVar.cw());
                f25232j.apply(j6.xt());
            } else {
                j6.j(10002).j(Void.class);
                j6.j(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM, jVar.cw());
                f25232j.apply(j6.xt());
            }
        }
    }
}

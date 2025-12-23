package com.bytedance.sdk.gromore.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f27476j;
    private static Function<SparseArray<Object>, Object> xt;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        return null;
    }

    public static void j(Function<SparseArray<Object>, Object> function) {
        xt = function;
    }

    private j() {
    }

    public static j j() {
        if (f27476j == null) {
            synchronized (j.class) {
                try {
                    if (f27476j == null) {
                        f27476j = new j();
                    }
                } finally {
                }
            }
        }
        return f27476j;
    }

    public void j(String str, String str2) {
        if (xt != null) {
            e a6 = e.a();
            a6.g(20000, str);
            a6.g(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM, str2);
            a6.e(-99999987, 10000);
            a6.f(-99999985, Void.class);
            xt.apply(a6.k().sparseArray());
        }
    }
}

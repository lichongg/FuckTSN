package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Collection;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    static final com.bumptech.glide.repackaged.com.google.common.base.b f15901a = com.bumptech.glide.repackaged.com.google.common.base.b.g(", ").i("null");

    static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    static StringBuilder b(int i6) {
        f.b(i6, "size");
        return new StringBuilder((int) Math.min(i6 * 8, IjkMediaMeta.AV_CH_STEREO_RIGHT));
    }
}

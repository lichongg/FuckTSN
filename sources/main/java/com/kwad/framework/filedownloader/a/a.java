package com.kwad.framework.filedownloader.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.kwad.framework.filedownloader.f.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int V(long j6) {
        if (j6 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return 1;
        }
        if (j6 < 5242880) {
            return 2;
        }
        if (j6 < 52428800) {
            return 3;
        }
        if (j6 < 104857600) {
            return 4;
        }
        return 5;
    }
}

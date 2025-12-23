package com.kwad.components.ad.k;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a<L extends i> {
    public AdTemplate mAdTemplate;

    @MainThread
    public abstract void a(L l6);

    @MainThread
    public abstract void b(L l6);

    public boolean kR() {
        return false;
    }

    public abstract void pause();

    public abstract void resume();

    public long getPlayDuration() {
        return 0L;
    }

    public a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @WorkerThread
    public void release() {
    }

    public void skipToEnd() {
    }

    public void setAudioEnabled(boolean z5, boolean z6) {
    }
}

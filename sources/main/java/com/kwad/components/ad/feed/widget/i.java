package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i extends c {
    @Override // com.kwad.components.ad.feed.widget.c
    protected final void cr() {
        this.hL.setRatio(1.7857143f);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_novel_regular_video;
    }

    public i(@NonNull Context context) {
        super(context);
        setRadiusDp(12);
    }

    @Override // com.kwad.components.ad.feed.widget.c, com.kwad.components.core.widget.b
    public final void bw() {
        super.bw();
        View findViewById = findViewById(R.id.ksad_feed_novel_video);
        if (findViewById != null) {
            findViewById.setClipToOutline(true);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i6) {
        if (!com.kwad.sdk.core.config.e.Gh()) {
            setBackgroundColor(-1);
        }
    }
}

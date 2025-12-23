package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BiserialDownloadProgressView extends DownloadProgressView {
    public BiserialDownloadProgressView(@NonNull Context context) {
        super(context);
    }

    public BiserialDownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BiserialDownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void nN() {
        m.inflate(getContext(), R.layout.ksad_download_progress_biserial_layout, this);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void nO() {
        this.MC = getResources().getDrawable(R.drawable.ksad_feed_download_progress_novel);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void nP() {
        this.MD = getResources().getDrawable(R.drawable.ksad_feed_actionbar_before_bg);
    }
}

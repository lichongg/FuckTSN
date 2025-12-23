package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsConvertButton extends KSCornerButton implements KsAppDownloadListener {

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public KsConvertButton(Context context) {
        super(context);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void bj(@Nullable String str) {
        if (str != null) {
            setText(str);
        }
    }

    @Nullable
    private String getAdActionDesc() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            return com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        return null;
    }

    public final void a(@Nullable com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
        this.mApkDownloadHelper = cVar;
        this.mAdTemplate = adTemplate;
        if (cVar != null) {
            cVar.b(this);
        }
        bj(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        bj(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        bj(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i6) {
        bj("下载中..." + i6 + "%");
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        bj(getAdActionDesc());
    }

    @RequiresApi(api = 21)
    public KsConvertButton(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }
}

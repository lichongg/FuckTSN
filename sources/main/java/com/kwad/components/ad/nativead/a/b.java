package com.kwad.components.ad.nativead.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.nativead.d;
import com.kwad.components.core.e.d.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public KsNativeAd.VideoPlayListener oQ;

    @NonNull
    public d.a oW;

    /* renamed from: pl, reason: collision with root package name */
    @NonNull
    public AdBasePvFrameLayout f36338pl;

    @NonNull
    public com.kwad.components.ad.nativead.c.a pr;
    public boolean pw = false;
    public boolean px = false;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.pr.release();
    }
}

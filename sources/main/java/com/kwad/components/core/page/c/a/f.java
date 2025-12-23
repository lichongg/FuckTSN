package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends com.kwad.components.core.page.c.a.a {
    private boolean Uh;
    private com.kwad.components.core.b.a mTitleBarHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void aQ(int i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(View view) {
        b bVar = this.TJ;
        if (bVar != null) {
            bVar.a(this.Uh, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        com.kwad.components.core.page.a.a aVar = this.TJ.TK;
        if (aVar != null) {
            aVar.qP();
        }
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.TJ.mPageTitle)) {
            return this.TJ.mPageTitle;
        }
        List<AdInfo> list = this.TJ.mAdTemplate.adInfoList;
        return (list == null || list.size() <= 0 || this.TJ.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.b.a.cl(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate));
    }

    private void ro() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.TJ.jI);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.aj(true);
        this.mTitleBarHelper.a(new a.InterfaceC0605a() { // from class: com.kwad.components.core.page.c.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC0605a
            public final void x(View view) {
                f.this.A(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0605a
            public final void y(View view) {
                f.this.B(view);
            }
        });
        ViewGroup hP = this.mTitleBarHelper.hP();
        AdTemplate adTemplate = this.TJ.mAdTemplate;
        int i6 = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.b.a.cm(adTemplate) && !com.kwad.sdk.core.response.b.b.dC(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate))) {
            i6 = 8;
        }
        hP.setVisibility(i6);
        this.TJ.a(new a() { // from class: com.kwad.components.core.page.c.a.f.2
            @Override // com.kwad.components.core.page.c.a.f.a
            public final void aQ(int i7) {
                f.this.mTitleBarHelper.hP().setVisibility(i7 == 1 ? 0 : 8);
            }
        });
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        b bVar = this.TJ;
        this.Uh = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.el(bVar.mAdTemplate)));
        ro();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}

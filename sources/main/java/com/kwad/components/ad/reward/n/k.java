package com.kwad.components.ad.reward.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k extends d implements com.kwad.sdk.widget.d {
    private ViewStub CB;
    private ViewGroup CC;
    private KsStyledTextButton CD;
    private KsStyledTextButton CE;
    private KsPriceView Cd;
    private TextView Cg;
    private TextView Ch;
    private View Ci;
    private TextView fv;
    private TextView ko;
    private KSCornerImageView nR;
    private com.kwad.components.ad.reward.g tm;

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.CB = viewStub;
        this.tm = gVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.R(rVar.getAdTemplate()));
    }

    private void f(View view, boolean z5) {
        if (view.equals(this.CE)) {
            this.tm.a(2, view.getContext(), z5 ? 38 : 153, 1);
        } else if (view.equals(this.CD)) {
            this.tm.a(2, view.getContext(), z5 ? 37 : 153, 1);
        } else if (view.equals(this.CC)) {
            this.tm.a(2, view.getContext(), z5 ? 2 : 153, 2);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.tm.mAdTemplate)) {
            f(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.CC;
    }

    public final void hide() {
        ViewGroup viewGroup = this.CC;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.CC = viewGroup;
        this.tm = gVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.nR, aVar.ho(), adTemplate, 8);
        this.ko.setText(aVar.getTitle());
        this.fv.setText(aVar.hp());
        int dimensionPixelSize = this.CC.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.Cd.getConfig().as(dimensionPixelSize).au(dimensionPixelSize).at(this.CC.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.Cd.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String ig = aVar.ig();
        this.Ci.setVisibility(TextUtils.isEmpty(ig) ? 8 : 0);
        if (ig != null) {
            this.Cg.setText(ig);
        }
        this.Ch.setText(aVar.ih());
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        f(view, true);
    }
}

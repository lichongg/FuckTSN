package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends d implements View.OnClickListener {
    private View CA;
    private DialogFragment Cx;
    private TextView Cy;
    private View Cz;
    private AdTemplate adTemplate;
    private TextView fv;
    private TextView ko;
    private KSCornerImageView nR;
    private TextView nS;
    private h.a sL;
    private ViewGroup vV;
    private View yJ;

    private void initView() {
        this.nR = (KSCornerImageView) this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.ko = (TextView) this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.fv = (TextView) this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.Cy = (TextView) this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.nS = (TextView) this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.yJ = this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.Cz = this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.CA = this.vV.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.yJ.setOnClickListener(this);
        this.Cz.setOnClickListener(this);
        this.CA.setOnClickListener(this);
        this.nR.setOnClickListener(this);
        this.ko.setOnClickListener(this);
        this.fv.setOnClickListener(this);
        this.nS.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadAppIcon(this.nR, cVar.ho(), this.adTemplate, 4);
        this.ko.setText(cVar.getTitle());
        this.fv.setText(cVar.hp());
        this.Cy.setText(cVar.hr());
        if (com.kwad.sdk.core.response.b.a.co(this.adTemplate)) {
            this.nS.setText(String.format("%s >", com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.vV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.yJ)) {
            this.Cx.dismiss();
            h.a aVar2 = this.sL;
            if (aVar2 != null) {
                aVar2.hj();
                return;
            }
            return;
        }
        if (view.equals(this.Cz)) {
            this.Cx.dismiss();
            h.a aVar3 = this.sL;
            if (aVar3 != null) {
                aVar3.G(false);
                return;
            }
            return;
        }
        if (view.equals(this.CA)) {
            this.Cx.dismiss();
            h.a aVar4 = this.sL;
            if (aVar4 != null) {
                aVar4.hj();
                return;
            }
            return;
        }
        if (view.equals(this.nR)) {
            h.a aVar5 = this.sL;
            if (aVar5 != null) {
                aVar5.h(127, 2);
                return;
            }
            return;
        }
        if (view.equals(this.ko)) {
            h.a aVar6 = this.sL;
            if (aVar6 != null) {
                aVar6.h(128, 2);
                return;
            }
            return;
        }
        if (view.equals(this.fv)) {
            h.a aVar7 = this.sL;
            if (aVar7 != null) {
                aVar7.h(129, 2);
                return;
            }
            return;
        }
        if (!view.equals(this.nS) || (aVar = this.sL) == null) {
            return;
        }
        aVar.h(131, 2);
    }

    public j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.Cx = dialogFragment;
        this.adTemplate = adTemplate;
        this.sL = aVar;
        this.vV = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }
}

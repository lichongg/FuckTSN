package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m extends d implements View.OnClickListener {
    private View CA;
    private ViewGroup CN;
    private View CO;
    private TextView CP;
    private TextView CQ;
    private TextView CR;
    private View CS;
    private DialogFragment Cx;
    private ImageView ig;
    private TextView ko;
    private h.a sL;

    private void t(boolean z5) {
        this.CO = this.CN.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.ko = (TextView) this.CN.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.ig = (ImageView) this.CN.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.CQ = (TextView) this.CN.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.CP = (TextView) this.CN.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.CA = this.CN.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.CS = this.CN.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.CR = (TextView) this.CN.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z5) {
            this.CO.setVisibility(8);
        }
        this.CO.setOnClickListener(this);
        this.CA.setOnClickListener(this);
        this.CS.setOnClickListener(this);
        this.CR.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.CN;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.CO)) {
            this.Cx.dismiss();
            h.a aVar2 = this.sL;
            if (aVar2 != null) {
                aVar2.hj();
                return;
            }
            return;
        }
        if (view.equals(this.CA)) {
            this.Cx.dismiss();
            h.a aVar3 = this.sL;
            if (aVar3 != null) {
                aVar3.hj();
                return;
            }
            return;
        }
        if (!view.equals(this.CS)) {
            if (!view.equals(this.CR) || (aVar = this.sL) == null) {
                return;
            }
            aVar.h(131, 2);
            return;
        }
        this.Cx.dismiss();
        h.a aVar4 = this.sL;
        if (aVar4 != null) {
            aVar4.G(false);
        }
    }

    public m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.Cx = dialogFragment;
        this.sL = aVar;
        if (com.kwad.sdk.core.response.b.a.cR(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            this.CN = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            t(true);
        } else {
            this.CN = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
            t(false);
        }
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadCircleIcon(this.ig, cVar.ho(), this.CN.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.ko != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = hP().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.ko.setText(spannableString);
        }
        this.CP.setText(cVar.hp());
        this.CQ.setText(cVar.hq());
        this.CR.setText(String.format("%s", cVar.sU));
    }
}

package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n extends d implements View.OnClickListener {
    private TextView BW;
    private ViewGroup CN;
    private LinearLayout CU;
    private KsPriceView CV;
    private TextView CW;
    private View CX;
    private KSCornerImageView CY;
    private b CZ;
    private a Da;
    private KSCornerImageView el;
    private ViewGroup jI;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void iE();
    }

    static /* synthetic */ View a(n nVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void initView() {
        this.CN = (ViewGroup) this.jI.findViewById(R.id.ksad_reward_order_root);
        this.el = (KSCornerImageView) this.jI.findViewById(R.id.ksad_reward_order_icon);
        this.BW = (TextView) this.jI.findViewById(R.id.ksad_reward_order_title);
        this.CU = (LinearLayout) this.jI.findViewById(R.id.ksad_reward_order_coupon_list);
        this.CV = (KsPriceView) this.jI.findViewById(R.id.ksad_reward_order_price);
        this.CW = (TextView) this.jI.findViewById(R.id.ksad_reward_order_btn_buy);
        this.CX = this.jI.findViewById(R.id.ksad_reward_order_text_area);
        this.CY = (KSCornerImageView) this.jI.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.CW.setText(com.kwad.components.ad.e.b.aD());
        this.CW.setOnClickListener(this);
        this.el.setOnClickListener(this);
        this.CX.setOnClickListener(this);
        Context context = this.jI.getContext();
        if (aq.QW()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.jI.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.jI.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.CN;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.CZ == null) {
            return;
        }
        if (view.equals(this.CW)) {
            this.CZ.hT();
        } else if (view.equals(this.el)) {
            this.CZ.js();
        } else if (view.equals(this.CX)) {
            this.CZ.jt();
        }
    }

    public n(ViewGroup viewGroup, b bVar) {
        this.jI = viewGroup;
        this.CZ = bVar;
        initView();
    }

    public final void a(a aVar) {
        this.Da = aVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.sdk.core.response.b.a.cV(com.kwad.sdk.core.response.b.e.el(rVar.getAdTemplate())), rVar.getAdTemplate());
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.el, adProductInfo.getIcon(), adTemplate);
        this.BW.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.CU.setVisibility(8);
            this.Da.iE();
        } else {
            this.CU.setVisibility(0);
            this.CU.post(new bg() { // from class: com.kwad.components.ad.reward.n.n.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        n nVar = n.this;
                        View a6 = n.a(nVar, nVar.CU.getContext(), couponInfo, n.this.CU);
                        ViewGroup.LayoutParams layoutParams = a6.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        n.this.CU.addView(a6, layoutParams);
                        com.kwad.components.core.t.j.a(new com.kwad.components.core.widget.e(), n.this.CU);
                    }
                    if (n.this.Da != null) {
                        if (n.this.CU.getChildCount() > 0) {
                            n.this.CU.getChildAt(0).post(new bg() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                @Override // com.kwad.sdk.utils.bg
                                public final void doTask() {
                                    n.this.Da.iE();
                                }
                            });
                        } else {
                            n.this.Da.iE();
                        }
                    }
                }
            });
        }
        this.CV.h(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String aE = com.kwad.components.ad.e.b.aE();
        if (bp.isNullString(aE)) {
            return;
        }
        KSImageLoader.loadImage(this.CY, aE, adTemplate);
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.o.m.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }
}

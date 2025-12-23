package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private TransViewPager lc;
    private int li;
    private ImageView lo;
    private ImageView lp;
    private ImageView lq;
    private int lr;
    private final ViewPager.OnPageChangeListener ls;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void dD() {
        int i6 = this.lr;
        if (i6 < this.li - 1) {
            this.lc.setCurrentItem(i6 + 1, true);
        }
    }

    private void initView() {
        m.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.lo = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.lp = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.lq = imageView;
        com.kwad.sdk.c.a.a.a(this, this.lo, this.lp, imageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c J;
        if (view.equals(this.lo)) {
            dD();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 162);
        } else if (view.equals(this.lp)) {
            dD();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 36);
        } else {
            if (!view.equals(this.lq) || (J = this.lc.J(this.lr)) == null) {
                return;
            }
            J.fc();
        }
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.ls = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i7) {
                InterstitialAggregateManualTipsView.this.lr = i7;
                if (InterstitialAggregateManualTipsView.this.lr == InterstitialAggregateManualTipsView.this.li - 1) {
                    InterstitialAggregateManualTipsView.this.lo.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.lp.setAlpha(0.5f);
                } else {
                    InterstitialAggregateManualTipsView.this.lo.setAlpha(1.0f);
                    InterstitialAggregateManualTipsView.this.lp.setAlpha(1.0f);
                }
            }
        };
        this.mContext = context;
        initView();
    }
}

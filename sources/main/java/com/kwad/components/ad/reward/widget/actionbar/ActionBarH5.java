package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ActionBarH5 extends FrameLayout implements d {
    private TextView Ew;
    private a Ex;
    private View Ey;
    private TextView gD;
    private AdTemplate mAdTemplate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void O(boolean z5);
    }

    public ActionBarH5(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.Ew = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.gD = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.Ey = findViewById(R.id.ksad_download_bar_cover);
    }

    private void d(View view, final boolean z5) {
        com.kwad.components.core.e.d.a.a(new a.C0616a(view.getContext()).aB(this.mAdTemplate).aB(view == this.Ey ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.Ex != null) {
                    ActionBarH5.this.Ex.O(z5);
                }
            }
        }));
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.Ex = aVar;
        AdInfo el = e.el(adTemplate);
        this.Ew.setText(com.kwad.sdk.core.response.b.a.au(el));
        this.gD.setText(com.kwad.sdk.core.response.b.a.aE(el));
        setClickable(true);
        this.Ey.setClickable(true);
        new h(this.Ey, this);
        new h(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, false);
        }
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        B(context);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }
}

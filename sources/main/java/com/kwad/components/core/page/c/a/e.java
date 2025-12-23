package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends a {
    private LinearLayout Tc;
    private TextView Td;
    private ImageView Te;

    private void rl() {
        this.Tc = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.TJ.mPageTitle)) {
            this.Tc.setVisibility(8);
            return;
        }
        this.Td = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.Te = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.Tc.setVisibility(8);
            }
        });
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate);
        boolean bz = com.kwad.sdk.core.response.b.a.bz(el);
        String bv = com.kwad.sdk.core.response.b.a.bv(el);
        if (bz) {
            this.Tc.setVisibility(0);
            this.Td.setText(bv);
            this.Td.setSelected(true);
        } else {
            this.Tc.setVisibility(8);
        }
        this.TJ.a(rm());
    }

    @NonNull
    private KsAdWebView.c rm() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.c.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void rn() {
                if (e.this.TJ.qT() && e.this.Tc.getVisibility() == 0) {
                    e.this.Tc.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        rl();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}

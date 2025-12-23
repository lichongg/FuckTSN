package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.ak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class CloseCountDownView extends LinearLayout {
    private a Iq;
    private String JJ;
    private int JK;
    private TextView JL;
    private TextView JM;
    private ImageView JN;
    private com.kwad.components.ad.splashscreen.widget.a JO;
    private Runnable JP;
    private boolean qy;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void eh();

        void mf();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.qy) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.JK <= 0) {
                    if (CloseCountDownView.this.Iq != null) {
                        CloseCountDownView.this.Iq.mf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ap(closeCountDownView.JK);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }

    private void ah(Context context) {
        setOrientation(0);
        m.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.JL = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.JM = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.JN = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.Iq != null) {
                    CloseCountDownView.this.Iq.eh();
                }
            }
        });
    }

    private void fP() {
        this.qy = true;
    }

    private void fQ() {
        this.qy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i6) {
        this.JL.setText(String.format(this.JJ, Integer.valueOf(i6)));
    }

    private void au() {
        post(this.JP);
    }

    static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i6 = closeCountDownView.JK;
        closeCountDownView.JK = i6 - 1;
        return i6;
    }

    private void nn() {
        ak.a(this, this.JO.mR());
        ak.a(this.JM, this.JO.nq());
        ak.a(this.JN, this.JO.nt());
        this.JL.setTextSize(0, this.JO.nr());
        this.JM.setTextSize(0, this.JO.nr());
        Drawable background = getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(this.JO.ns());
        }
    }

    public void setOnViewClickListener(a aVar) {
        this.Iq = aVar;
    }

    public final void a(AdInfo adInfo, float f6) {
        com.kwad.components.ad.splashscreen.widget.a ai;
        boolean dn = com.kwad.sdk.core.response.b.a.dn(adInfo);
        if (dn) {
            ai = com.kwad.components.ad.splashscreen.widget.a.aj(getContext());
        } else {
            ai = com.kwad.components.ad.splashscreen.widget.a.ai(getContext());
        }
        this.JO = ai;
        ai.d(f6);
        boolean cv = com.kwad.sdk.core.response.b.a.cv(adInfo);
        this.JK = com.kwad.sdk.core.response.b.a.cu(adInfo);
        if (dn) {
            nn();
        }
        if (cv) {
            this.JL.setVisibility(0);
            this.JM.setVisibility(0);
            ap(this.JK);
            float np = this.JO.np();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), np), 0, com.kwad.sdk.c.a.a.a(getContext(), np), 0);
        } else {
            float no = this.JO.no();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), no), 0, com.kwad.sdk.c.a.a.a(getContext(), no), 0);
        }
        au();
    }

    public final void bt() {
        fQ();
    }

    public final void bu() {
        fP();
    }

    public final void cq() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.qy) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.JK <= 0) {
                    if (CloseCountDownView.this.Iq != null) {
                        CloseCountDownView.this.Iq.mf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ap(closeCountDownView.JK);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.qy) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.JK <= 0) {
                    if (CloseCountDownView.this.Iq != null) {
                        CloseCountDownView.this.Iq.mf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ap(closeCountDownView.JK);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.qy) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.JK <= 0) {
                    if (CloseCountDownView.this.Iq != null) {
                        CloseCountDownView.this.Iq.mf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ap(closeCountDownView.JK);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ah(context);
    }
}

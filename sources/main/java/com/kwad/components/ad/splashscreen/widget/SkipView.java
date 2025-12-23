package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.b {
    private a JD;
    private Runnable JP;
    private final b Ls;
    private View Lt;
    private TextView Lu;
    private TextView Lv;
    private int Lw;
    private boolean qy;
    private boolean vX;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void am(int i6);

        void me();

        void mf();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {
        private int JK;
        private int LA;
        private boolean LB;
        private boolean LC;
        private String Ly;
        private String Lz;

        private b() {
            this.Ly = "跳过";
            this.Lz = "";
            this.LA = 5;
            this.JK = 5;
            this.LB = true;
            this.LC = true;
        }

        public final void ac(String str) {
            this.JK = -1;
            this.Lz = str;
        }

        static /* synthetic */ int d(b bVar) {
            int i6 = bVar.JK;
            bVar.JK = i6 - 1;
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean nD() {
            return this.LB && this.LC;
        }

        public final void ar(int i6) {
            this.LA = i6;
            this.JK = i6;
        }

        public final String nB() {
            int i6 = this.JK;
            if (i6 < 0) {
                return this.Lz;
            }
            if (i6 == 0) {
                return this.Lz + 1;
            }
            return this.Lz + this.JK;
        }

        public final boolean nC() {
            return this.JK <= 0;
        }

        /* synthetic */ b(byte b6) {
            this();
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    private void fP() {
        this.qy = true;
    }

    private void fQ() {
        this.qy = false;
    }

    private void init() {
        setOrientation(0);
        m.inflate(getContext(), R.layout.ksad_skip_view, this);
        this.Lu = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.Lv = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.Lt = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.JD != null) {
                    SkipView.this.JD.me();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i6) {
        a aVar = this.JD;
        if (aVar != null) {
            aVar.am(i6);
        }
    }

    private void au() {
        a(this.Ls);
        post(this.JP);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        if (this.vX) {
            nA();
        }
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return;
        }
        fQ();
    }

    public final void ac(String str) {
        if (str == null) {
            return;
        }
        this.Ls.ac(str);
        a(this.Ls);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(a aVar) {
        this.JD = aVar;
    }

    public void setSkipBtnVisible(boolean z5) {
        this.Ls.LB = z5;
        a(this.Ls);
    }

    public void setSkipText(String str) {
        this.Ls.Ly = str;
        a(this.Ls);
    }

    public void setTimerBtnVisible(boolean z5) {
        this.Ls.LC = z5;
        a(this.Ls);
    }

    public void setTimerPrefixText(String str) {
        this.Ls.Lz = str;
        a(this.Ls);
    }

    public void setTimerSecond(int i6) {
        this.Ls.ar(i6);
        a(this.Ls);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(m.wrapContextIfNeed(context), attributeSet, i6);
        this.Ls = new b((byte) 0);
        this.Lw = -1;
        this.qy = false;
        this.vX = true;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.qy) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Ls);
                SkipView skipView2 = SkipView.this;
                skipView2.al(skipView2.Ls.LA - SkipView.this.Ls.JK);
                if (!SkipView.this.Ls.nC()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.Ls);
                } else if (SkipView.this.JD != null) {
                    SkipView.this.JD.mf();
                }
            }
        };
        init();
    }

    private void C(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cE(adInfo));
    }

    private void nA() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            fP();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int ao(int i6) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void cq() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.Lw = layoutParams.width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.Lu != null) {
            if (bVar.Ly != null) {
                this.Lu.setText(bVar.Ly);
            }
            this.Lu.setVisibility(this.Ls.LB ? 0 : 8);
        }
        String nB = bVar.nB();
        TextView textView = this.Lv;
        if (textView != null) {
            if (nB != null) {
                textView.setText(nB);
            }
            this.Lv.setVisibility(this.Ls.LC ? 0 : 8);
        }
        if (this.Lt != null) {
            boolean nD = this.Ls.nD();
            this.Lt.setVisibility(nD ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!nD) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i6 = this.Lw;
                if (i6 > 0) {
                    layoutParams.width = i6;
                    invalidate();
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.vX = com.kwad.sdk.core.response.b.a.cD(adInfo);
        setTimerPrefixText(e.a(com.kwad.components.ad.splashscreen.b.a.FN));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            au();
        }
        setSkipText(com.kwad.sdk.core.response.b.a.cs(adInfo));
        setVisibility(8);
        C(adInfo);
    }
}

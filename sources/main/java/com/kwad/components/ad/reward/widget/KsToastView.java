package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsToastView extends LinearLayout {
    TextView Ec;
    private String Ed;
    private Runnable Ee;
    private int countDown;

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i6) {
        this.Ec.setText(String.format(this.Ed, Integer.valueOf(i6)));
    }

    static /* synthetic */ int b(KsToastView ksToastView) {
        int i6 = ksToastView.countDown;
        ksToastView.countDown = i6 - 1;
        return i6;
    }

    private void init(Context context) {
        m.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.Ec = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    public final void ai(int i6) {
        if (this.Ee == null) {
            this.Ee = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.G(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.Ee);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Ee);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }

    public KsToastView(Context context, boolean z5) {
        super(context);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }
}

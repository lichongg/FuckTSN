package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String Ed = "%s秒后自动关闭";
    private TextView aiZ;
    private ImageView aja;
    private a ajb;
    private boolean ajc;
    private boolean ajd;
    private int countDown;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void eg();

        void eh();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_auto_close, this);
        this.aiZ = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.aja = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i6) {
        this.aiZ.setText(String.format(Ed, Integer.valueOf(i6)));
    }

    static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i6 = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i6 - 1;
        return i6;
    }

    public final void ai(int i6) {
        if (i6 <= 0) {
            return;
        }
        this.countDown = i6;
        post(new bg() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (KsAutoCloseView.this.ajc) {
                    if (KsAutoCloseView.this.ajd) {
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                        return;
                    }
                    if (KsAutoCloseView.this.countDown == 0) {
                        if (KsAutoCloseView.this.ajb != null) {
                            KsAutoCloseView.this.ajb.eg();
                        }
                    } else {
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.G(ksAutoCloseView.countDown);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    }
                }
            }
        });
    }

    public final void bb(boolean z5) {
        this.ajc = z5;
        int i6 = z5 ? 0 : 8;
        TextView textView = this.aiZ;
        if (textView != null) {
            textView.setVisibility(i6);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ajb != null && view.equals(this.aja)) {
            this.ajb.eh();
        }
    }

    public void setCountDownPaused(boolean z5) {
        this.ajd = z5;
    }

    public void setViewListener(a aVar) {
        this.ajb = aVar;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }
}

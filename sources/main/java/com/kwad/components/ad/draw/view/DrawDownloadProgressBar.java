package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar fR;
    private View fS;
    private Context mContext;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.fR = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.fS = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void e(String str, int i6) {
        if (i6 == 0 || i6 == getMax()) {
            this.fS.setVisibility(0);
        } else {
            this.fS.setVisibility(8);
        }
        this.fR.e(str, i6);
    }

    public int getMax() {
        return this.fR.getMax();
    }

    public void setTextColor(int i6) {
        this.fR.setTextColor(i6);
    }

    public void setTextSize(int i6) {
        this.fR.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), i6));
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        B(context);
    }
}

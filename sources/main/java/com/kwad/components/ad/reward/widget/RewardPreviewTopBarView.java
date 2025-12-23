package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String Eg;
    private String Eh;
    private ProgressBar Ei;
    private TextView Ej;
    private long Ek;
    private long El;
    private boolean Em;
    private a En;
    private ImageView cw;
    private TextView vW;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void G(boolean z5);

        void H(boolean z5);
    }

    public RewardPreviewTopBarView(@NonNull Context context) {
        super(context);
        this.Eg = " 秒后即可获得奖励";
        this.Eh = "恭喜你获得奖励";
        this.Ek = -1L;
        this.Em = false;
    }

    @MainThread
    private void e(boolean z5, boolean z6) {
        if (this.Em) {
            this.vW.setVisibility(0);
        } else {
            this.vW.setVisibility(8);
            this.Ej.setText(this.Eh);
            a aVar = this.En;
            if (aVar != null) {
                aVar.H(false);
            }
        }
        this.Em = true;
    }

    @MainThread
    public final void s(long j6) {
        int ceil = (int) Math.ceil(j6 / 1000.0f);
        TextView textView = this.Ej;
        if (textView != null) {
            textView.setText(ceil + this.Eg);
        }
        e(j6, this.Ek);
        if (this.Ek - j6 >= this.El && this.cw.getVisibility() != 0) {
            this.cw.setVisibility(0);
        }
        if (ceil <= 0) {
            e(true, false);
        }
    }

    public final boolean ln() {
        return this.Em;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!view.equals(this.cw) || (aVar = this.En) == null) {
            return;
        }
        aVar.G(this.Em);
    }

    @MainThread
    public void setCloseBtnDelayShowDuration(long j6) {
        this.El = j6;
        if (j6 <= 0) {
            this.cw.setVisibility(0);
        }
    }

    @MainThread
    public void setRewardTips(String str) {
        TextView textView = this.vW;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTopBarListener(a aVar) {
        this.En = aVar;
    }

    @MainThread
    public void setTotalCountDuration(long j6) {
        this.Ek = j6;
        this.Ei.setMax((int) j6);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        View.inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.Ei = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.vW = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.Ej = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.cw = imageView;
        imageView.setVisibility(8);
        this.cw.setOnClickListener(this);
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Eg = " 秒后即可获得奖励";
        this.Eh = "恭喜你获得奖励";
        this.Ek = -1L;
        this.Em = false;
    }

    @MainThread
    private void e(long j6, long j7) {
        this.Ei.setProgress((int) (j7 - j6));
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.Eg = " 秒后即可获得奖励";
        this.Eh = "恭喜你获得奖励";
        this.Ek = -1L;
        this.Em = false;
    }
}

package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AppScoreView extends LinearLayout {
    private ImageView Mu;
    private ImageView Mv;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public void setScore(float f6) {
        double d6 = f6;
        if (d6 > 4.5d) {
            ImageView imageView = this.Mu;
            int i6 = R.drawable.ksad_star_checked;
            imageView.setImageResource(i6);
            this.Mv.setImageResource(i6);
            return;
        }
        if (d6 > 4.0d) {
            this.Mu.setImageResource(R.drawable.ksad_star_checked);
            this.Mv.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d6 > 3.5d) {
            this.Mu.setImageResource(R.drawable.ksad_star_checked);
            this.Mv.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d6 > 3.0d) {
            this.Mu.setImageResource(R.drawable.ksad_star_half);
            this.Mv.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d6 == 3.0d) {
            ImageView imageView2 = this.Mu;
            int i7 = R.drawable.ksad_star_unchecked;
            imageView2.setImageResource(i7);
            this.Mv.setImageResource(i7);
        }
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.ksad_app_score, this);
        this.Mu = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.Mv = (ImageView) findViewById(R.id.ksad_score_fifth);
    }
}

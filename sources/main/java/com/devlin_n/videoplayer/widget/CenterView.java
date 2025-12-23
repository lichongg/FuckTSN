package com.devlin_n.videoplayer.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.devlin_n.videoplayer.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class CenterView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f32407a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f32408b;

    /* renamed from: c, reason: collision with root package name */
    private ProgressBar f32409c;

    private void a() {
        setGravity(17);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_center_window, this);
        this.f32407a = (ImageView) inflate.findViewById(R.id.iv_icon);
        this.f32408b = (TextView) inflate.findViewById(R.id.tv_percent);
        this.f32409c = (ProgressBar) inflate.findViewById(R.id.pro_percent);
    }

    public void setIcon(int i6) {
        ImageView imageView = this.f32407a;
        if (imageView != null) {
            imageView.setImageResource(i6);
        }
    }

    public void setProPercent(int i6) {
        ProgressBar progressBar = this.f32409c;
        if (progressBar != null) {
            progressBar.setProgress(i6);
        }
    }

    public void setProVisibility(int i6) {
        ProgressBar progressBar = this.f32409c;
        if (progressBar != null) {
            progressBar.setVisibility(i6);
        }
    }

    public void setTextView(String str) {
        TextView textView = this.f32408b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public CenterView(Context context) {
        super(context);
        a();
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        if (i6 != 0) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_out));
        }
    }
}

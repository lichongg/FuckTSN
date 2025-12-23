package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.controller.BaseVideoController;
import g1.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class AdController extends BaseVideoController implements View.OnClickListener {
    protected ImageView A;

    /* renamed from: v, reason: collision with root package name */
    protected TextView f32284v;

    /* renamed from: w, reason: collision with root package name */
    protected TextView f32285w;

    /* renamed from: x, reason: collision with root package name */
    protected ImageView f32286x;

    /* renamed from: y, reason: collision with root package name */
    protected ImageView f32287y;

    /* renamed from: z, reason: collision with root package name */
    protected ImageView f32288z;

    public AdController(@NonNull Context context) {
        super(context);
    }

    public AdController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void l() {
        this.f32290b.h();
        if (this.f32290b.isMute()) {
            this.f32287y.setImageResource(R.drawable.ic_action_volume_up);
        } else {
            this.f32287y.setImageResource(R.drawable.ic_action_volume_off);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int f() {
        BaseVideoController.d dVar = this.f32290b;
        if (dVar == null) {
            return 0;
        }
        int currentPosition = dVar.getCurrentPosition();
        int duration = this.f32290b.getDuration();
        TextView textView = this.f32284v;
        if (textView != null) {
            textView.setText(String.format("%s | 跳过", Integer.valueOf((duration - currentPosition) / 1000)));
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.layout_ad_controller;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected void e() {
        super.e();
        this.f32284v = (TextView) this.f32289a.findViewById(R.id.ad_time);
        TextView textView = (TextView) this.f32289a.findViewById(R.id.ad_detail);
        this.f32285w = textView;
        textView.setText("了解详情>");
        ImageView imageView = (ImageView) this.f32289a.findViewById(R.id.back);
        this.f32286x = imageView;
        imageView.setVisibility(8);
        this.f32287y = (ImageView) this.f32289a.findViewById(R.id.iv_volume);
        this.f32288z = (ImageView) this.f32289a.findViewById(R.id.fullscreen);
        ImageView imageView2 = (ImageView) this.f32289a.findViewById(R.id.iv_play);
        this.A = imageView2;
        imageView2.setOnClickListener(this);
        this.f32284v.setOnClickListener(this);
        this.f32285w.setOnClickListener(this);
        this.f32286x.setOnClickListener(this);
        this.f32287y.setOnClickListener(this);
        this.f32288z.setOnClickListener(this);
        this.f32291c = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z5;
        int id = view.getId();
        boolean z6 = false;
        if (id == R.id.back) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (id == R.id.fullscreen) {
            z6 = true;
        }
        if (z5 | z6) {
            c();
            return;
        }
        if (id == R.id.iv_volume) {
            l();
            return;
        }
        if (id == R.id.ad_detail) {
            a aVar = this.f32302n;
            if (aVar != null) {
                aVar.onAdClick();
                return;
            }
            return;
        }
        if (id == R.id.ad_time) {
            this.f32290b.e();
        } else if (id == R.id.iv_play) {
            b();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 0 && (aVar = this.f32302n) != null) {
            aVar.onAdClick();
            return false;
        }
        return false;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i6) {
        super.setPlayState(i6);
        if (i6 != 3) {
            if (i6 != 4) {
                return;
            }
            this.A.setSelected(false);
        } else {
            post(this.f32304p);
            this.A.setSelected(true);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i6) {
        super.setPlayerState(i6);
        if (i6 != 10) {
            if (i6 != 11) {
                return;
            }
            this.f32286x.setVisibility(0);
            return;
        }
        this.f32286x.setVisibility(8);
    }
}

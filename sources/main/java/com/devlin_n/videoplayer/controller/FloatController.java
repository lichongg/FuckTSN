package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class FloatController extends BaseVideoController implements View.OnClickListener {

    /* renamed from: v, reason: collision with root package name */
    private ProgressBar f32318v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f32319w;

    public FloatController(@NonNull Context context) {
        super(context);
    }

    public FloatController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void l(int i6) {
        if (this.f32303o == 6) {
            return;
        }
        if (!this.f32291c) {
            this.f32319w.setVisibility(0);
        }
        this.f32291c = true;
        removeCallbacks(this.f32305q);
        if (i6 != 0) {
            postDelayed(this.f32305q, i6);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void d() {
        if (this.f32303o != 6 && this.f32291c) {
            this.f32319w.setVisibility(8);
            this.f32291c = false;
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void g() {
        l(this.f32295g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.layout_float_controller;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected void e() {
        super.e();
        setOnClickListener(this);
        this.f32289a.findViewById(R.id.btn_close).setOnClickListener(this);
        this.f32318v = (ProgressBar) this.f32289a.findViewById(R.id.loading);
        ImageView imageView = (ImageView) this.f32289a.findViewById(R.id.start_play);
        this.f32319w = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            this.f32290b.d();
        } else if (id == R.id.start_play) {
            b();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i6) {
        super.setPlayState(i6);
        switch (i6) {
            case 0:
                this.f32319w.setSelected(false);
                this.f32319w.setVisibility(0);
                this.f32318v.setVisibility(8);
                break;
            case 1:
                this.f32319w.setVisibility(8);
                this.f32318v.setVisibility(0);
                break;
            case 2:
                this.f32319w.setVisibility(8);
                this.f32318v.setVisibility(8);
                break;
            case 3:
                this.f32319w.setSelected(true);
                this.f32319w.setVisibility(8);
                this.f32318v.setVisibility(8);
                d();
                break;
            case 4:
                this.f32319w.setSelected(false);
                this.f32319w.setVisibility(0);
                this.f32318v.setVisibility(8);
                l(0);
                break;
            case 5:
                l(0);
                break;
            case 6:
                this.f32319w.setVisibility(8);
                this.f32318v.setVisibility(0);
                break;
            case 7:
                this.f32319w.setVisibility(8);
                this.f32318v.setVisibility(8);
                break;
        }
    }
}

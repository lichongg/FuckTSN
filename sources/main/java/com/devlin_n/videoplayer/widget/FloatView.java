package com.devlin_n.videoplayer.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.player.IjkVideoView;
import h1.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class FloatView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private WindowManager f32410a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager.LayoutParams f32411b;

    /* renamed from: c, reason: collision with root package name */
    public IjkVideoView f32412c;

    /* renamed from: d, reason: collision with root package name */
    private int f32413d;

    /* renamed from: e, reason: collision with root package name */
    private int f32414e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f32415f;

    private void a() {
        setBackgroundResource(R.drawable.shape_float_window_background);
        int a6 = f.a(getContext(), 1.0f);
        setPadding(a6, a6, a6, a6);
        IjkVideoView ijkVideoView = new IjkVideoView(getContext());
        this.f32412c = ijkVideoView;
        addView(ijkVideoView);
    }

    public FloatView(@NonNull Context context, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        super(context);
        this.f32415f = true;
        this.f32410a = windowManager;
        this.f32411b = layoutParams;
        a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                if (this.f32415f) {
                    this.f32413d = (int) motionEvent.getX();
                    this.f32414e = (int) (motionEvent.getY() + f.f(getContext()));
                    this.f32415f = false;
                }
                WindowManager.LayoutParams layoutParams = this.f32411b;
                layoutParams.x = rawX - this.f32413d;
                layoutParams.y = rawY - this.f32414e;
                this.f32410a.updateViewLayout(this, layoutParams);
            }
        } else {
            this.f32415f = true;
        }
        return super.onTouchEvent(motionEvent);
    }
}

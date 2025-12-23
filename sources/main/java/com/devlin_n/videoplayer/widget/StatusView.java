package com.devlin_n.videoplayer.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.player.BackgroundPlayService;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class StatusView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f32422a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f32423b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f32424c;

    /* renamed from: d, reason: collision with root package name */
    private float f32425d;

    /* renamed from: e, reason: collision with root package name */
    private float f32426e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StubApp.getOrigApplicationContext(StatusView.this.getContext().getApplicationContext()).stopService(new Intent(StatusView.this.getContext(), (Class<?>) BackgroundPlayService.class));
        }
    }

    public StatusView(Context context) {
        this(context, null);
    }

    public StatusView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void b(String str, View.OnClickListener onClickListener) {
        TextView textView = this.f32423b;
        if (textView != null) {
            textView.setText(str);
            this.f32423b.setOnClickListener(onClickListener);
        }
    }

    public void setMessage(String str) {
        TextView textView = this.f32422a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_status_view, this);
        this.f32422a = (TextView) inflate.findViewById(R.id.message);
        this.f32423b = (TextView) inflate.findViewById(R.id.status_btn);
        this.f32424c = (ImageView) inflate.findViewById(R.id.btn_close);
        setBackgroundResource(android.R.color.black);
        setClickable(true);
        if (h1.a.f43027c) {
            this.f32424c.setVisibility(0);
            this.f32424c.setOnClickListener(new a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float abs = Math.abs(motionEvent.getX() - this.f32425d);
                float abs2 = Math.abs(motionEvent.getY() - this.f32426e);
                if (abs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || abs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            this.f32425d = motionEvent.getX();
            this.f32426e = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}

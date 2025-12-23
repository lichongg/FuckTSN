package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws {
    private int ae;

    /* renamed from: j, reason: collision with root package name */
    private final j f31269j;

    /* renamed from: m, reason: collision with root package name */
    private int f31270m;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private float f31271r;
    private float up;
    private boolean xt = false;
    private boolean cw = false;
    private boolean tl = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f31268g = false;
    private final View.OnTouchListener oq = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ws.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (ws.this.f31269j.az()) {
                return ws.this.xt || !ws.this.cw;
            }
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                ws wsVar = ws.this;
                wsVar.qv = wsVar.j(motionEvent);
                ws.this.f31271r = x5;
                ws.this.up = y5;
                ws.this.f31270m = (int) x5;
                ws.this.ae = (int) y5;
                ws.this.tl = true;
                if (ws.this.f31269j != null && ws.this.cw && !ws.this.xt) {
                    ws.this.f31269j.j(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x5 - ws.this.f31270m) > 20.0f || Math.abs(y5 - ws.this.ae) > 20.0f) {
                    ws.this.tl = false;
                }
                if (!ws.this.xt) {
                    ws.this.tl = true;
                }
                ws.this.f31268g = false;
                ws.this.f31271r = 0.0f;
                ws.this.up = 0.0f;
                ws.this.f31270m = 0;
                if (ws.this.f31269j != null) {
                    ws.this.f31269j.j(view, ws.this.tl);
                }
                ws.this.qv = false;
            } else if (action != 2) {
                if (action == 3) {
                    ws.this.qv = false;
                }
            } else if (ws.this.xt && !ws.this.qv) {
                float f6 = x5 - ws.this.f31271r;
                float f7 = y5 - ws.this.up;
                float abs = Math.abs(f6);
                float abs2 = Math.abs(f7);
                if (!ws.this.f31268g) {
                    if (abs <= 20.0f && abs2 <= 20.0f) {
                        return true;
                    }
                    ws.this.f31268g = true;
                }
                if (ws.this.f31269j != null) {
                    ws.this.f31269j.ws();
                }
                ws.this.f31271r = x5;
                ws.this.up = y5;
            }
            return ws.this.xt || !ws.this.cw;
        }
    };

    public interface j {
        boolean az();

        void j(View view, boolean z5);

        void ws();
    }

    public ws(j jVar) {
        this.f31269j = jVar;
    }

    public void j(View view) {
        if (view != null) {
            view.setOnTouchListener(this.oq);
        }
    }

    public void j(boolean z5) {
        this.cw = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int r5 = ed.r(StubApp.getOrigApplicationContext(v.getContext().getApplicationContext()));
        int up = ed.up(StubApp.getOrigApplicationContext(v.getContext().getApplicationContext()));
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f6 = r5;
        if (rawX <= f6 * 0.01f || rawX >= f6 * 0.99f) {
            return true;
        }
        float f7 = up;
        return rawY <= 0.01f * f7 || rawY >= f7 * 0.99f;
    }
}

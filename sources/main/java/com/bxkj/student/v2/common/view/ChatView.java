package com.bxkj.student.v2.common.view;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ChatView extends RelativeLayout {

    /* renamed from: k, reason: collision with root package name */
    private static final int f20963k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f20964l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f20965m = 3;

    /* renamed from: n, reason: collision with root package name */
    private static final int f20966n = 4;

    /* renamed from: a, reason: collision with root package name */
    private int f20967a;

    /* renamed from: b, reason: collision with root package name */
    private int f20968b;

    /* renamed from: c, reason: collision with root package name */
    private int f20969c;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager.LayoutParams f20970d;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager f20971e;

    /* renamed from: f, reason: collision with root package name */
    private float f20972f;

    /* renamed from: g, reason: collision with root package name */
    private float f20973g;

    /* renamed from: h, reason: collision with root package name */
    private float f20974h;

    /* renamed from: i, reason: collision with root package name */
    private float f20975i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f20976j;

    private void a() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (iArr[0] < (this.f20969c / 2) - (getWidth() / 2)) {
            g(0);
        } else {
            g(1);
        }
    }

    private void g(int l6) {
        if (l6 == 0) {
            this.f20970d.x = 0;
        } else if (l6 == 1) {
            this.f20970d.x = this.f20969c - this.f20967a;
        } else if (l6 == 3) {
            this.f20970d.y = 0;
        } else if (l6 == 4) {
            this.f20970d.y = this.f20968b - this.f20967a;
        }
        this.f20971e.updateViewLayout(this, this.f20970d);
    }

    private int c(int densityDpi) {
        if (densityDpi <= 120) {
            return 36;
        }
        if (densityDpi <= 160) {
            return 48;
        }
        if (densityDpi <= 240) {
            return 72;
        }
        return densityDpi <= 320 ? 96 : 108;
    }

    private void f() {
        WindowManager.LayoutParams layoutParams = this.f20970d;
        layoutParams.x = (int) (this.f20972f - this.f20974h);
        layoutParams.y = (int) ((this.f20973g - this.f20975i) - (this.f20968b / 25));
        this.f20971e.updateViewLayout(this, layoutParams);
    }

    public void d() {
        setVisibility(8);
    }

    public ChatView(Activity activity) {
        super(activity);
        LayoutInflater.from(activity).inflate(R.layout.floating_help, this);
        this.f20971e = (WindowManager) activity.getSystemService("window");
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.f20967a = u.a(50.0f, activity);
        this.f20969c = this.f20971e.getDefaultDisplay().getWidth();
        this.f20968b = this.f20971e.getDefaultDisplay().getHeight();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f20970d = layoutParams;
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.gravity = 53;
        layoutParams.flags = 8;
        int i6 = this.f20967a;
        layoutParams.width = i6;
        layoutParams.height = i6;
        layoutParams.y = (this.f20968b - i6) >> 1;
        this.f20971e.addView(this, layoutParams);
        d();
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.v2.common.view.ChatView.1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy() {
                    ChatView.this.b();
                }
            });
        }
    }

    public void b() {
        d();
        this.f20971e.removeViewImmediate(this);
    }

    public void e() {
        if (isShown()) {
            return;
        }
        setVisibility(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.f20972f = event.getRawX();
        this.f20973g = event.getRawY();
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f20976j) {
                        f();
                    } else if (Math.abs(this.f20974h - event.getX()) > this.f20967a / 3 || Math.abs(this.f20975i - event.getY()) > this.f20967a / 3) {
                        f();
                    }
                    this.f20976j = true;
                }
            } else {
                if (this.f20976j) {
                    a();
                }
                this.f20976j = false;
                this.f20975i = 0.0f;
                this.f20974h = 0.0f;
            }
        } else {
            this.f20974h = event.getX();
            this.f20975i = event.getY();
        }
        return super.onTouchEvent(event);
    }
}

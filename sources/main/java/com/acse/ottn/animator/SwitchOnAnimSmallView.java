package com.acse.ottn.animator;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.acse.ottn.R;
import com.acse.ottn.a0;
import com.acse.ottn.i;
import com.acse.ottn.p4;
import com.acse.ottn.u4;
import com.acse.ottn.v2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SwitchOnAnimSmallView extends FrameLayout {

    /* renamed from: g, reason: collision with root package name */
    public static final int f4195g = 300;

    /* renamed from: h, reason: collision with root package name */
    public static final int f4196h = 500;

    /* renamed from: a, reason: collision with root package name */
    public Handler f4197a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f4198b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f4199c;

    /* renamed from: d, reason: collision with root package name */
    public float f4200d;

    /* renamed from: e, reason: collision with root package name */
    public float f4201e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4202f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends a0 {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.animator.SwitchOnAnimSmallView$a$a, reason: collision with other inner class name */
        public class RunnableC0064a implements Runnable {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.animator.SwitchOnAnimSmallView$a$a$a, reason: collision with other inner class name */
            public class RunnableC0065a implements Runnable {
                public RunnableC0065a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (SwitchOnAnimSmallView.this.f4199c != null) {
                        SwitchOnAnimSmallView.this.f4199c.setBackgroundResource(R.mipmap.finger_normal);
                    }
                    SwitchOnAnimSmallView.this.d();
                }
            }

            public RunnableC0064a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimSmallView.this.f4198b == null || SwitchOnAnimSmallView.this.f4197a == null) {
                    return;
                }
                SwitchOnAnimSmallView.this.f4198b.setBackgroundResource(R.mipmap.switch_on_circle_point);
                SwitchOnAnimSmallView.this.c();
                SwitchOnAnimSmallView.this.f4197a.postDelayed(new RunnableC0065a(), 100L);
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(i iVar) {
            if (SwitchOnAnimSmallView.this.f4199c == null || SwitchOnAnimSmallView.this.f4197a == null) {
                return;
            }
            SwitchOnAnimSmallView.this.f4199c.setBackgroundResource(R.mipmap.finger_click);
            SwitchOnAnimSmallView.this.f4197a.postDelayed(new RunnableC0064a(), 200L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends a0 {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimSmallView.this.f4202f) {
                    return;
                }
                SwitchOnAnimSmallView.this.b();
            }
        }

        public b() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(i iVar) {
            SwitchOnAnimSmallView.this.f4197a.postDelayed(new a(), 1000L);
        }
    }

    public SwitchOnAnimSmallView(Context context) {
        this(context, null);
    }

    public SwitchOnAnimSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4197a = new Handler();
        this.f4202f = false;
        LayoutInflater.from(context).inflate(R.layout.finger_switch_on_guide_small_layout, (ViewGroup) this, true);
        a();
    }

    public final void a() {
        this.f4198b = (ImageView) findViewById(R.id.switch_anim_circle_point);
        this.f4199c = (ImageView) findViewById(R.id.finger_switch);
        this.f4200d = u4.a(getContext(), 8.0f);
        this.f4201e = u4.a(getContext(), 5.0f);
    }

    public void b() {
        this.f4202f = false;
        p4.i(this.f4198b, 0.0f);
        this.f4198b.setBackgroundResource(R.mipmap.switch_off_circle_point);
        this.f4199c.setBackgroundResource(R.mipmap.finger_normal);
        e();
    }

    public final void c() {
        ImageView imageView = this.f4198b;
        if (imageView == null) {
            return;
        }
        v2 a6 = v2.a(imageView, "translationX", 0.0f, this.f4201e);
        a6.a(500L);
        a6.k();
    }

    public final void d() {
        ImageView imageView = this.f4199c;
        if (imageView == null) {
            return;
        }
        v2 a6 = v2.a(imageView, "translationY", -this.f4200d, 0.0f);
        a6.a(300L);
        a6.a((i.a) new b());
        a6.k();
    }

    public final void e() {
        v2 a6 = v2.a(this.f4199c, "translationY", 0.0f, -this.f4200d);
        a6.a(300L);
        a6.a((i.a) new a());
        a6.k();
    }

    public void f() {
        this.f4202f = true;
    }

    public void setFingerVisible(boolean z5) {
        if (z5) {
            this.f4199c.setVisibility(0);
        } else {
            this.f4199c.setVisibility(8);
        }
    }
}

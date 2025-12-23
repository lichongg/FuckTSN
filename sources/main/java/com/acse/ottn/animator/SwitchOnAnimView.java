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
public class SwitchOnAnimView extends FrameLayout {

    /* renamed from: g, reason: collision with root package name */
    public static final int f4208g = 300;

    /* renamed from: h, reason: collision with root package name */
    public static final int f4209h = 500;

    /* renamed from: a, reason: collision with root package name */
    public Handler f4210a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f4211b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f4212c;

    /* renamed from: d, reason: collision with root package name */
    public float f4213d;

    /* renamed from: e, reason: collision with root package name */
    public float f4214e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4215f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends a0 {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.animator.SwitchOnAnimView$a$a, reason: collision with other inner class name */
        public class RunnableC0066a implements Runnable {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.animator.SwitchOnAnimView$a$a$a, reason: collision with other inner class name */
            public class RunnableC0067a implements Runnable {
                public RunnableC0067a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (SwitchOnAnimView.this.f4212c != null) {
                        SwitchOnAnimView.this.f4212c.setBackgroundResource(R.mipmap.finger_normal);
                    }
                    SwitchOnAnimView.this.d();
                }
            }

            public RunnableC0066a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimView.this.f4211b == null || SwitchOnAnimView.this.f4210a == null) {
                    return;
                }
                SwitchOnAnimView.this.f4211b.setBackgroundResource(R.mipmap.switch_on_circle_point);
                SwitchOnAnimView.this.c();
                SwitchOnAnimView.this.f4210a.postDelayed(new RunnableC0067a(), 100L);
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(i iVar) {
            if (SwitchOnAnimView.this.f4212c == null || SwitchOnAnimView.this.f4210a == null) {
                return;
            }
            SwitchOnAnimView.this.f4212c.setBackgroundResource(R.mipmap.finger_click);
            SwitchOnAnimView.this.f4210a.postDelayed(new RunnableC0066a(), 200L);
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
                if (SwitchOnAnimView.this.f4215f) {
                    return;
                }
                SwitchOnAnimView.this.b();
            }
        }

        public b() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(i iVar) {
            SwitchOnAnimView.this.f4210a.postDelayed(new a(), 1000L);
        }
    }

    public SwitchOnAnimView(Context context) {
        this(context, null);
    }

    public SwitchOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4210a = new Handler();
        this.f4215f = false;
        LayoutInflater.from(context).inflate(R.layout.finger_switch_on_guide_layout, (ViewGroup) this, true);
        a();
    }

    public final void a() {
        this.f4211b = (ImageView) findViewById(R.id.switch_anim_circle_point);
        this.f4212c = (ImageView) findViewById(R.id.finger_switch);
        this.f4213d = u4.a(getContext(), 20.0f);
        this.f4214e = u4.a(getContext(), 17.5f);
    }

    public void b() {
        this.f4215f = false;
        p4.i(this.f4211b, 0.0f);
        this.f4211b.setBackgroundResource(R.mipmap.switch_off_circle_point);
        this.f4212c.setBackgroundResource(R.mipmap.finger_normal);
        e();
    }

    public final void c() {
        ImageView imageView = this.f4211b;
        if (imageView == null) {
            return;
        }
        v2 a6 = v2.a(imageView, "translationX", 0.0f, this.f4214e);
        a6.a(500L);
        a6.k();
    }

    public final void d() {
        ImageView imageView = this.f4212c;
        if (imageView == null) {
            return;
        }
        v2 a6 = v2.a(imageView, "translationY", -this.f4213d, 0.0f);
        a6.a(300L);
        a6.a((i.a) new b());
        a6.k();
    }

    public final void e() {
        v2 a6 = v2.a(this.f4212c, "translationY", 0.0f, -this.f4213d);
        a6.a(300L);
        a6.a((i.a) new a());
        a6.k();
    }

    public void f() {
        this.f4215f = true;
    }

    public void setFingerVisible(boolean z5) {
        if (z5) {
            this.f4212c.setVisibility(0);
        } else {
            this.f4212c.setVisibility(8);
        }
    }
}

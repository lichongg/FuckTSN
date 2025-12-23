package com.acse.ottn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ContinueSlideScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5462a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5463b;

    /* renamed from: c, reason: collision with root package name */
    public Context f5464c;

    /* renamed from: d, reason: collision with root package name */
    public a f5465d;

    /* renamed from: e, reason: collision with root package name */
    public float f5466e;

    /* renamed from: f, reason: collision with root package name */
    public float f5467f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5468g;

    /* renamed from: h, reason: collision with root package name */
    public int f5469h;

    /* renamed from: i, reason: collision with root package name */
    public b f5470i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();

        void b();
    }

    public ContinueSlideScrollView(Context context) {
        super(context);
        this.f5462a = true;
        this.f5463b = false;
        this.f5468g = false;
        this.f5469h = 160;
        this.f5464c = context;
    }

    public boolean a() {
        return this.f5463b;
    }

    public static int a(Context context, int i6) {
        return (int) ((i6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public boolean b() {
        return this.f5462a;
    }

    public final void c() {
        a aVar;
        if (this.f5462a) {
            a aVar2 = this.f5465d;
            if (aVar2 != null) {
                aVar2.b();
                return;
            }
            return;
        }
        if (!this.f5463b || (aVar = this.f5465d) == null) {
            return;
        }
        aVar.a();
    }

    public void setScanScrollChangedListener(a aVar) {
        this.f5465d = aVar;
    }

    public void setonContinueSlideListener(b bVar) {
        this.f5470i = bVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i6, int i7, boolean z5, boolean z6) {
        super.onOverScrolled(i6, i7, z5, z6);
        if (i7 == 0) {
            this.f5462a = z6;
            this.f5463b = false;
        } else {
            this.f5462a = false;
            this.f5463b = z6;
        }
        c();
    }

    @Override // android.view.View
    public void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f5467f = motionEvent.getY();
                    if (this.f5468g && b() && this.f5467f - this.f5466e > a(this.f5464c, this.f5469h)) {
                        this.f5468g = false;
                        b bVar = this.f5470i;
                        if (bVar != null) {
                            bVar.a();
                        }
                    }
                    if (this.f5468g && a() && this.f5467f - this.f5466e < (-a(this.f5464c, this.f5469h))) {
                        this.f5468g = false;
                        b bVar2 = this.f5470i;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }
            } else {
                this.f5468g = true;
                this.f5467f = 0.0f;
                this.f5466e = 0.0f;
            }
        } else {
            this.f5466e = motionEvent.getY();
            this.f5468g = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5462a = true;
        this.f5463b = false;
        this.f5468g = false;
        this.f5469h = 160;
        this.f5464c = context;
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5462a = true;
        this.f5463b = false;
        this.f5468g = false;
        this.f5469h = 160;
        this.f5464c = context;
    }
}

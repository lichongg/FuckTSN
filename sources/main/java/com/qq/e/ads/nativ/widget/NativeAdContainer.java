package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ViewStatusListener f36681a;

    /* renamed from: b, reason: collision with root package name */
    private ViewStatus f36682b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f36682b = ViewStatus.INIT;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36683a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f36683a = iArr;
            try {
                iArr[ViewStatus.ATTACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36683a[ViewStatus.DETACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36682b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f36681a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f36681a = viewStatusListener;
        if (viewStatusListener != null) {
            int i6 = AnonymousClass1.f36683a[this.f36682b.ordinal()];
            if (i6 == 1) {
                this.f36681a.onAttachToWindow();
            } else {
                if (i6 != 2) {
                    return;
                }
                this.f36681a.onDetachFromWindow();
            }
        }
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f36682b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f36682b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f36681a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f36682b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f36681a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        ViewStatusListener viewStatusListener = this.f36681a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z5);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        ViewStatusListener viewStatusListener = this.f36681a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i6);
        }
    }
}

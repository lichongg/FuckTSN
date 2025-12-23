package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class cs extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10963a = "ContainerView";

    /* renamed from: b, reason: collision with root package name */
    private a f10964b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void dispatchTouchEvent(MotionEvent motionEvent);

        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i6, KeyEvent keyEvent);

        void onLayoutComplete(int i6, int i7);

        void onWindowFocusChanged(boolean z5);

        void onWindowVisibilityChanged(int i6);
    }

    public void a(a aVar) {
        this.f10964b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f10964b;
        if (aVar != null) {
            aVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        a aVar = this.f10964b;
        if (aVar != null) {
            return aVar.onKeyDown(i6, keyEvent);
        }
        super.onKeyDown(i6, keyEvent);
        return false;
    }

    public cs(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f10964b;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f10964b;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        a aVar;
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5 && (aVar = this.f10964b) != null) {
            aVar.onLayoutComplete(getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        a aVar = this.f10964b;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z5);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        a aVar = this.f10964b;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i6);
        }
    }
}

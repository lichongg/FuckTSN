package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector Lq;
    private d ij;
    private View mView;
    private MotionEvent pJ;

    public h(Context context, @NonNull View view, d dVar) {
        this.mView = view;
        view.setOnTouchListener(this);
        this.Lq = new GestureDetector(context, this);
        this.ij = dVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        d dVar = this.ij;
        if (dVar == null) {
            return false;
        }
        dVar.a(this.mView);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.pJ != null && motionEvent.getAction() == 1 && b(this.pJ, motionEvent)) {
            return a(view, motionEvent);
        }
        boolean onTouchEvent = this.Lq.onTouchEvent(motionEvent);
        motionEvent.getAction();
        if (onTouchEvent) {
            return true;
        }
        return a(view, motionEvent);
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z5 = false;
        if (action == 0) {
            this.pJ = MotionEvent.obtain(motionEvent);
            return false;
        }
        if (action == 1) {
            MotionEvent motionEvent2 = this.pJ;
            if (motionEvent2 != null && b(motionEvent2, motionEvent)) {
                d dVar = this.ij;
                if (dVar != null) {
                    dVar.b(view);
                }
                z5 = true;
            }
            this.pJ = null;
        }
        return z5;
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        boolean z5;
        boolean z6;
        if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (!z5 && !z6) {
            return false;
        }
        return true;
    }

    public h(View view, d dVar) {
        if (view == null) {
            return;
        }
        this.mView = view;
        view.setOnTouchListener(this);
        this.Lq = new GestureDetector(view.getContext(), this);
        this.ij = dVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }
}

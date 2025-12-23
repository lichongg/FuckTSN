package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends TouchDelegate {
    private Rect cw;

    /* renamed from: j, reason: collision with root package name */
    private View f26852j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26853r;
    private int up;
    private Rect xt;

    public ae(Rect rect, View view) {
        super(rect, view);
        this.xt = rect;
        this.up = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.cw = rect2;
        int i6 = this.up;
        rect2.inset(-i6, -i6);
        this.f26852j = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        int x5 = (int) motionEvent.getX();
        int y5 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z6 = true;
        if (action != 0) {
            if (action != 1 && action != 2) {
                if (action == 3) {
                    boolean z7 = this.f26853r;
                    this.f26853r = false;
                    z6 = z7;
                }
                z5 = true;
                z6 = false;
            } else {
                boolean z8 = this.f26853r;
                if (z8) {
                    z5 = this.cw.contains(x5, y5);
                    z6 = z8;
                } else {
                    z6 = z8;
                }
            }
            z5 = true;
        } else if (this.xt.contains(x5, y5)) {
            this.f26853r = true;
            z5 = true;
        } else {
            this.f26853r = false;
            z5 = true;
            z6 = false;
        }
        if (z6) {
            View view = this.f26852j;
            if (z5) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                float f6 = -(this.up * 2);
                motionEvent.setLocation(f6, f6);
            }
            if (view.getVisibility() == 0) {
                return view.dispatchTouchEvent(motionEvent);
            }
        }
        return false;
    }
}

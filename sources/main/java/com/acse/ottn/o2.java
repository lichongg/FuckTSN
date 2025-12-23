package com.acse.ottn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o2 extends RecyclerView {

    /* renamed from: a, reason: collision with root package name */
    public int f4970a;

    /* renamed from: b, reason: collision with root package name */
    public float f4971b;

    /* renamed from: c, reason: collision with root package name */
    public float f4972c;

    /* renamed from: d, reason: collision with root package name */
    public n2 f4973d;

    /* renamed from: e, reason: collision with root package name */
    public WindowManager f4974e;

    public o2(@NonNull Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        this.f4970a = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public o2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(n2 n2Var, WindowManager windowManager) {
        this.f4973d = n2Var;
        this.f4974e = windowManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4973d == null || this.f4974e == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4973d.a((int) motionEvent.getRawX());
            this.f4973d.b((int) motionEvent.getRawY());
        } else if (action == 1) {
            performClick();
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int b6 = rawX - this.f4973d.b();
            int c6 = rawY - this.f4973d.c();
            this.f4973d.a(rawX);
            this.f4973d.b(rawY);
            this.f4973d.a().x += b6;
            this.f4973d.a().y += c6;
            this.f4974e.updateViewLayout(this, this.f4973d.a());
        }
        return super.onTouchEvent(motionEvent);
    }

    public o2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4970a = 0;
        a(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action != 2) {
                return false;
            }
            float x5 = motionEvent.getX() - this.f4971b;
            float y5 = motionEvent.getY() - this.f4972c;
            if (Math.abs(x5) <= this.f4970a && Math.abs(y5) <= this.f4970a) {
                return false;
            }
            return true;
        }
        this.f4971b = motionEvent.getX();
        this.f4972c = motionEvent.getY();
        this.f4973d.a((int) motionEvent.getRawX());
        this.f4973d.b((int) motionEvent.getRawY());
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }
}

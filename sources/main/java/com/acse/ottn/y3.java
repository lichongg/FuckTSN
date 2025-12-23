package com.acse.ottn;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class y3 extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public int f5526a;

    /* renamed from: b, reason: collision with root package name */
    public int f5527b;

    /* renamed from: c, reason: collision with root package name */
    public int f5528c;

    /* renamed from: d, reason: collision with root package name */
    public a f5529d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5530e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(int i6);
    }

    public y3(Context context) {
        this(context, null);
    }

    public y3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnScrollListener(a aVar) {
        this.f5529d = aVar;
    }

    public y3(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5530e = false;
        this.f5528c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (getScrollY() > 300) {
            this.f5530e = true;
        } else {
            this.f5530e = false;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                if (Math.abs(((int) motionEvent.getRawY()) - this.f5527b) >= 10) {
                    return false;
                }
                return true;
            }
        } else {
            this.f5526a = (int) motionEvent.getRawX();
            this.f5527b = (int) motionEvent.getRawY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @TargetApi(21)
    public y3(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f5530e = false;
        this.f5528c = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}

package com.bxkj.student.run.app.lockscreen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SwipeBackLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ViewDragHelper f19882a;

    /* renamed from: b, reason: collision with root package name */
    private View f19883b;

    /* renamed from: c, reason: collision with root package name */
    private c f19884c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return SwipeBackLayout.this.f19883b.equals(child) ? Math.min(Math.max(left, 0), SwipeBackLayout.this.getWidth()) : super.clampViewPositionHorizontal(child, left, dx);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int left, int top2, int dx, int dy) {
            if (SwipeBackLayout.this.f19883b.equals(changedView)) {
                if (SwipeBackLayout.this.f19883b.getLeft() == SwipeBackLayout.this.getWidth() && SwipeBackLayout.this.f19884c != null) {
                    SwipeBackLayout.this.f19884c.onFinish();
                }
                SwipeBackLayout.this.setBackgroundColor(Color.argb((int) (((r1.getWidth() - left) / SwipeBackLayout.this.getWidth()) * 160.0f), 0, 0, 0));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (SwipeBackLayout.this.f19883b.equals(releasedChild)) {
                if (SwipeBackLayout.this.f19883b.getLeft() >= SwipeBackLayout.this.getWidth() / 3) {
                    SwipeBackLayout.this.f19882a.settleCapturedViewAt(SwipeBackLayout.this.getWidth(), SwipeBackLayout.this.getTop());
                } else {
                    SwipeBackLayout.this.f19882a.settleCapturedViewAt(0, SwipeBackLayout.this.getTop());
                }
                SwipeBackLayout.this.invalidate();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int pointerId) {
            return SwipeBackLayout.this.f19883b.equals(child);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private Activity f19886a;

        @Override // com.bxkj.student.run.app.lockscreen.SwipeBackLayout.c
        public void onFinish() {
            this.f19886a.finish();
            this.f19886a.overridePendingTransition(0, 0);
        }

        public b(@NonNull Activity activity) {
            this.f19886a = activity;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void onFinish();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        d();
    }

    private void d() {
        this.f19882a = ViewDragHelper.create(this, 1.0f, new a());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.f19882a.shouldInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent ev) {
        try {
            this.f19882a.processTouchEvent(ev);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return true;
        }
    }

    public void setSwipeBackListener(c listener) {
        this.f19884c = listener;
    }

    public SwipeBackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        d();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f19882a.continueSettling(true)) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            this.f19883b = childAt;
            if (childAt.getBackground() == null) {
                this.f19883b.setBackgroundColor(-1118482);
                return;
            }
            return;
        }
        throw new IllegalStateException("SwipeBackLayout must have only one child.");
    }

    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        d();
    }

    @TargetApi(21)
    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        d();
    }
}

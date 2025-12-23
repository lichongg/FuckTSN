package com.bxkj.student.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TBLayout extends LinearLayout {
    public static final int SCREEN_FOOTER = 12;
    public static final int SCREEN_HEADER = 11;
    private OnPageChangedListener ctListener;
    private View mFooter;
    private View mHeader;
    private int mHeaderHeight;
    private int mLastInterceptY;
    private int mLastY;
    private int mTouchSlop;
    private OnPullListener pullListener;
    private int screen;
    private Scroller scroller;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnPageChangedListener {
        void onPageChanged(int stub);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnPullListener {
        boolean footerHeadReached(MotionEvent event);

        boolean headerFootReached(MotionEvent event);
    }

    @SuppressLint({"NewApi"})
    public TBLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mTouchSlop = 0;
        this.screen = 11;
        init();
    }

    private void init() {
        this.scroller = new Scroller(getContext());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            postInvalidate();
        }
    }

    public void setOnContentChangeListener(OnPageChangedListener ler) {
        this.ctListener = ler;
    }

    public void setOnPullListener(OnPullListener listener) {
        this.pullListener = listener;
    }

    private void initData() {
        this.mHeader = findViewById(R.id.mHeader);
        View findViewById = findViewById(R.id.mFooter);
        this.mFooter = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int measuredHeight = this.mHeader.getMeasuredHeight();
        this.mHeaderHeight = measuredHeight;
        layoutParams.height = measuredHeight;
        this.mFooter.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        OnPullListener onPullListener;
        int y5 = (int) ev.getY();
        int action = ev.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i6 = y5 - this.mLastInterceptY;
                    int i7 = this.mTouchSlop;
                    if (i6 > i7 && this.screen == 12) {
                        OnPullListener onPullListener2 = this.pullListener;
                        if (onPullListener2 == null || !onPullListener2.footerHeadReached(ev)) {
                            return false;
                        }
                        return true;
                    }
                    if (i6 < (-i7) && this.screen == 11 && (onPullListener = this.pullListener) != null && onPullListener.headerFootReached(ev)) {
                        return true;
                    }
                }
                return false;
            }
            this.mLastInterceptY = 0;
            return false;
        }
        this.mLastY = y5;
        this.mLastInterceptY = y5;
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i6;
        int y5 = (int) event.getY();
        int action = event.getAction();
        if (action != 1) {
            if (action == 2) {
                int i7 = y5 - this.mLastY;
                int i8 = this.screen;
                if (i8 != 11) {
                    if (i8 == 12 && i7 > 0) {
                        scrollTo(0, this.mHeaderHeight - i7);
                    }
                } else {
                    int i9 = -i7;
                    if (i9 < 0) {
                        i9 = 0;
                    } else if (i9 > getHeight()) {
                        i9 = getHeight();
                    }
                    scrollTo(0, i9);
                }
            }
        } else {
            int i10 = this.screen;
            if (i10 != 11) {
                if (i10 != 12) {
                    i6 = 0;
                } else {
                    i6 = (this.mHeaderHeight * 3) / 4;
                }
            } else {
                i6 = this.mHeaderHeight / 4;
            }
            int scrollY = getScrollY();
            if (scrollY > i6) {
                this.scroller.startScroll(0, scrollY, 0, this.mHeaderHeight - scrollY, 150);
                this.screen = 12;
                OnPageChangedListener onPageChangedListener = this.ctListener;
                if (onPageChangedListener != null) {
                    onPageChangedListener.onPageChanged(12);
                }
                postInvalidate();
            } else {
                this.scroller.startScroll(0, scrollY, 0, -scrollY, 150);
                this.screen = 11;
                OnPageChangedListener onPageChangedListener2 = this.ctListener;
                if (onPageChangedListener2 != null) {
                    onPageChangedListener2.onPageChanged(11);
                }
                postInvalidate();
            }
            this.mLastY = 0;
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && this.mHeader == null && this.mFooter == null) {
            initData();
        }
    }

    public TBLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTouchSlop = 0;
        this.screen = 11;
        init();
    }

    public TBLayout(Context context) {
        super(context);
        this.mTouchSlop = 0;
        this.screen = 11;
        init();
    }
}

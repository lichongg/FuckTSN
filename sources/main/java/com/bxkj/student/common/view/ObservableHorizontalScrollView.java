package com.bxkj.student.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ObservableHorizontalScrollView extends HorizontalScrollView {
    private ScrollViewListener scrollViewListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ScrollViewListener {
        void onScrollChanged(ObservableHorizontalScrollView scrollView, int x5, int y5, int oldx, int oldy);
    }

    public ObservableHorizontalScrollView(Context context) {
        super(context);
        this.scrollViewListener = null;
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.scrollViewListener = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int x5, int y5, int oldx, int oldy) {
        super.onScrollChanged(x5, y5, oldx, oldy);
        ScrollViewListener scrollViewListener = this.scrollViewListener;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x5, y5, oldx, oldy);
        }
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.scrollViewListener = null;
    }
}

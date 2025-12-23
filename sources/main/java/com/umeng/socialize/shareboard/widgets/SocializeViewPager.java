package com.umeng.socialize.shareboard.widgets;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.umeng.socialize.shareboard.widgets.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocializeViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DEFAULT_WIDTH_FACTOR = 1;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private int mActivePointerId;
    private SocializePagerAdapter mAdapter;
    private boolean mCalledSuper;
    private int mCloseEnough;
    private int mCurPosition;
    private int mDefaultGutterSize;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private List<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private int mScrollState;
    private Scroller mScroller;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.2
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.3
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    };
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i6);

        void onPageScrolled(int i6, float f6, int i7);

        void onPageSelected(int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            SocializeViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            SocializeViewPager.this.dataSetChanged();
        }
    }

    public SocializeViewPager(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void init() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f6 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f6);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mCloseEnough = (int) (2.0f * f6);
        this.mFlingDistance = (int) (25.0f * f6);
        this.mDefaultGutterSize = (int) (f6 * 16.0f);
        ViewCompat.setOnApplyWindowInsetsListener(this, new ViewCompat.OnApplyWindowInsetsListener() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.4
            @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (!onApplyWindowInsets.isConsumed()) {
                    Rect rect = SocializeViewPager.this.mTempRect;
                    rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
                    rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
                    rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
                    rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
                    int childCount = SocializeViewPager.this.getChildCount();
                    for (int i6 = 0; i6 < childCount; i6++) {
                        WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(SocializeViewPager.this.getChildAt(i6), onApplyWindowInsets);
                        rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                        rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                        rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                        rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
                    }
                    return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
                }
                return onApplyWindowInsets;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void populate() {
        populate(this.mCurPosition);
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurPosition) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    ItemInfo infoForChild(View view) {
        for (int i6 = 0; i6 < this.mItems.size(); i6++) {
            ItemInfo itemInfo = this.mItems.get(i6);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i6) {
        for (int i7 = 0; i7 < this.mItems.size(); i7++) {
            ItemInfo itemInfo = this.mItems.get(i7);
            if (itemInfo.position == i6) {
                return itemInfo;
            }
        }
        return null;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        LayoutParams layoutParams;
        setMeasuredDimension(View.getDefaultSize(0, i6), View.getDefaultSize(0, i7));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), makeMeasureSpec);
            }
        }
    }

    public void setCurrentItem(int i6) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i6, !this.mFirstLayout, false);
    }

    void setCurrentItemInternal(int i6, boolean z5, boolean z6) {
        setCurrentItemInternal(i6, z5, z6, 0);
    }

    void smoothScrollTo(int i6, int i7) {
        smoothScrollTo(i6, i7, 0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;

        ItemInfo() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.widthFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SocializeViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i6, ItemInfo itemInfo2) {
        int i7;
        int i8;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        if (itemInfo2 != null) {
            int i9 = itemInfo2.position;
            int i10 = itemInfo.position;
            if (i9 < i10) {
                float f6 = itemInfo2.offset + 1.0f + 0.0f;
                int i11 = i9 + 1;
                int i12 = 0;
                while (i11 <= itemInfo.position && i12 < this.mItems.size()) {
                    ItemInfo itemInfo5 = this.mItems.get(i12);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i11 <= itemInfo4.position || i12 >= this.mItems.size() - 1) {
                            break;
                        }
                        i12++;
                        itemInfo5 = this.mItems.get(i12);
                    }
                    while (i11 < itemInfo4.position) {
                        f6 += this.mAdapter.getPageWidth(i11) + 0.0f;
                        i11++;
                    }
                    itemInfo4.offset = f6;
                    f6 += 1.0f;
                    i11++;
                }
            } else if (i9 > i10) {
                int size = this.mItems.size() - 1;
                float f7 = itemInfo2.offset;
                while (true) {
                    i9--;
                    if (i9 < itemInfo.position || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i9 >= itemInfo3.position || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.mItems.get(size);
                    }
                    while (i9 > itemInfo3.position) {
                        f7 -= this.mAdapter.getPageWidth(i9) + 0.0f;
                        i9--;
                    }
                    f7 -= 1.0f;
                    itemInfo3.offset = f7;
                }
            }
        }
        int size2 = this.mItems.size();
        float f8 = itemInfo.offset;
        int i13 = itemInfo.position;
        int i14 = i13 - 1;
        this.mFirstOffset = i13 == 0 ? f8 : -3.4028235E38f;
        int i15 = count - 1;
        this.mLastOffset = i13 == i15 ? (f8 + 1.0f) - 1.0f : Float.MAX_VALUE;
        int i16 = i6 - 1;
        while (i16 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(i16);
            while (true) {
                i8 = itemInfo7.position;
                if (i14 <= i8) {
                    break;
                }
                f8 -= this.mAdapter.getPageWidth(i14) + 0.0f;
                i14--;
            }
            f8 -= 1.0f;
            itemInfo7.offset = f8;
            if (i8 == 0) {
                this.mFirstOffset = f8;
            }
            i16--;
            i14--;
        }
        float f9 = itemInfo.offset + 1.0f + 0.0f;
        int i17 = itemInfo.position + 1;
        int i18 = i6 + 1;
        while (i18 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(i18);
            while (true) {
                i7 = itemInfo8.position;
                if (i17 >= i7) {
                    break;
                }
                f9 += this.mAdapter.getPageWidth(i17) + 0.0f;
                i17++;
            }
            if (i7 == i15) {
                this.mLastOffset = (f9 + 1.0f) - 1.0f;
            }
            itemInfo8.offset = f9;
            f9 += 1.0f;
            i18++;
            i17++;
        }
    }

    private void completeScroll(boolean z5) {
        boolean z6 = this.mScrollState == 2;
        if (z6 && !this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    pageScrolled(currX);
                }
            }
        }
        this.mPopulatePending = false;
        for (int i6 = 0; i6 < this.mItems.size(); i6++) {
            ItemInfo itemInfo = this.mItems.get(i6);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z6 = true;
            }
        }
        if (z6) {
            if (z5) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private void dispatchOnPageScrolled(int i6, float f6, int i7) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i8);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i6, f6, i7);
                }
            }
        }
    }

    private void dispatchOnPageSelected(int i6) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i7);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i6);
                }
            }
        }
    }

    private void dispatchOnScrollStateChanged(int i6) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i7);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i6);
                }
            }
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private boolean isGutterDrag(float f6, float f7) {
        if (f6 >= this.mGutterSize || f7 <= 0.0f) {
            return f6 > ((float) (getWidth() - this.mGutterSize)) && f7 < 0.0f;
        }
        return true;
    }

    private boolean pageScrolled(int i6) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i7 = infoForCurrentScrollPosition.position;
        float f6 = clientWidth;
        float f7 = ((i6 / f6) - infoForCurrentScrollPosition.offset) / 1.0f;
        this.mCalledSuper = false;
        onPageScrolled(i7, f7, (int) (f6 * f7));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f6) {
        boolean z5;
        float f7 = this.mLastMotionX - f6;
        this.mLastMotionX = f6;
        float scrollX = getScrollX() + f7;
        float clientWidth = getClientWidth();
        float f8 = this.mFirstOffset * clientWidth;
        float f9 = this.mLastOffset * clientWidth;
        boolean z6 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        List<ItemInfo> list = this.mItems;
        boolean z7 = true;
        ItemInfo itemInfo2 = list.get(list.size() - 1);
        if (itemInfo.position != 0) {
            f8 = itemInfo.offset * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f9 = itemInfo2.offset * clientWidth;
            z7 = false;
        }
        if (scrollX < f8) {
            scrollX = f8;
            z6 = z5;
        } else if (scrollX > f9) {
            scrollX = f9;
            z6 = z7;
        }
        int i6 = (int) scrollX;
        this.mLastMotionX += scrollX - i6;
        scrollTo(i6, getScrollY());
        pageScrolled(i6);
        return z6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        if (r9 == r10) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void populate(int r19) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.shareboard.widgets.SocializeViewPager.populate(int):void");
    }

    private void recomputeScrollPosition(int i6, int i7, int i8, int i9) {
        if (i7 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i7 - getPaddingLeft()) - getPaddingRight()) + i9)) * (((i6 - getPaddingLeft()) - getPaddingRight()) + i8)), getScrollY());
                return;
            }
        }
        ItemInfo infoForPosition = infoForPosition(this.mCurPosition);
        int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((i6 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            completeScroll(false);
            scrollTo(min, getScrollY());
        }
    }

    ItemInfo addNewItem(int i6, int i7) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i6;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i6);
        if (i7 < 0 || i7 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
            return itemInfo;
        }
        this.mItems.add(i7, itemInfo);
        return itemInfo;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    protected boolean canScroll(View view, boolean z5, int i6, int i7, int i8) {
        int i9;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i10 = i7 + scrollX;
                if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && (i9 = i8 + scrollY) >= childAt.getTop() && i9 < childAt.getBottom() && canScroll(childAt, true, i6, i10 - childAt.getLeft(), i9 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z5 && ViewCompat.canScrollHorizontally(view, -i6);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z5 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i6 = this.mCurPosition;
        int i7 = 0;
        boolean z6 = false;
        while (i7 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i7);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i7);
                    i7--;
                    if (!z6) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z6 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i8 = this.mCurPosition;
                    if (i8 == itemInfo.position) {
                        i6 = Math.max(0, Math.min(i8, count - 1));
                    }
                } else {
                    int i9 = itemInfo.position;
                    if (i9 != itemPosition) {
                        if (i9 == this.mCurPosition) {
                            i6 = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z5 = true;
            }
            i7++;
        }
        if (z6) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z5) {
            setCurrentItemInternal(i6, false, true);
            requestLayout();
        }
    }

    float distanceInfluenceForSnapDuration(float f6) {
        return (float) Math.sin((float) ((f6 - 0.5f) * 0.4712389167638204d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public int getCurrentItem() {
        return this.mCurPosition;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    boolean pageLeft() {
        int i6 = this.mCurPosition;
        if (i6 <= 0) {
            return false;
        }
        setCurrentItem(i6 - 1, true);
        return true;
    }

    boolean pageRight() {
        SocializePagerAdapter socializePagerAdapter = this.mAdapter;
        if (socializePagerAdapter == null || this.mCurPosition >= socializePagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurPosition + 1, true);
        return true;
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(SocializePagerAdapter socializePagerAdapter) {
        SocializePagerAdapter socializePagerAdapter2 = this.mAdapter;
        if (socializePagerAdapter2 != null) {
            socializePagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i6 = 0; i6 < this.mItems.size(); i6++) {
                ItemInfo itemInfo = this.mItems.get(i6);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeAllViews();
            this.mCurPosition = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = socializePagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (socializePagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z5 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem < 0) {
                if (z5) {
                    requestLayout();
                    return;
                } else {
                    populate();
                    return;
                }
            }
            this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
            setCurrentItemInternal(this.mRestoredCurItem, false, true);
            this.mRestoredCurItem = -1;
            this.mRestoredAdapterState = null;
            this.mRestoredClassLoader = null;
        }
    }

    void setCurrentItemInternal(int i6, boolean z5, boolean z6, int i7) {
        SocializePagerAdapter socializePagerAdapter = this.mAdapter;
        if (socializePagerAdapter == null || socializePagerAdapter.getCount() <= 0) {
            return;
        }
        if (z6 || this.mCurPosition != i6 || this.mItems.size() == 0) {
            if (i6 < 0) {
                i6 = 0;
            } else if (i6 >= this.mAdapter.getCount()) {
                i6 = this.mAdapter.getCount() - 1;
            }
            int i8 = this.mOffscreenPageLimit;
            int i9 = this.mCurPosition;
            if (i6 > i9 + i8 || i6 < i9 - i8) {
                for (int i10 = 0; i10 < this.mItems.size(); i10++) {
                    this.mItems.get(i10).scrolling = true;
                }
            }
            boolean z7 = this.mCurPosition != i6;
            if (!this.mFirstLayout) {
                populate(i6);
                scrollToItem(i6, z5, i7, z7);
            } else {
                this.mCurPosition = i6;
                if (z7) {
                    dispatchOnPageSelected(i6);
                }
                requestLayout();
            }
        }
    }

    void setScrollState(int i6) {
        if (this.mScrollState == i6) {
            return;
        }
        this.mScrollState = i6;
        dispatchOnScrollStateChanged(i6);
    }

    void smoothScrollTo(int i6, int i7, int i8) {
        int scrollX;
        if (getChildCount() == 0) {
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
        }
        int i9 = scrollX;
        int scrollY = getScrollY();
        int i10 = i6 - i9;
        int i11 = i7 - scrollY;
        if (i10 == 0 && i11 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i12 = clientWidth / 2;
        float f6 = clientWidth;
        float f7 = i12;
        float distanceInfluenceForSnapDuration = f7 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i10) * 1.0f) / f6)) * f7);
        int abs = Math.abs(i8);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(distanceInfluenceForSnapDuration / abs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / (f6 * this.mAdapter.getPageWidth(this.mCurPosition))) + 1.0f) * 100.0f), 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i9, scrollY, i10, i11, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private int determineTargetPage(int i6, float f6, int i7, int i8) {
        float f7;
        if (Math.abs(i8) > this.mFlingDistance && Math.abs(i7) > this.mMinimumVelocity) {
            if (i7 <= 0) {
                i6++;
            }
        } else {
            if (i6 >= this.mCurPosition) {
                f7 = 0.4f;
            } else {
                f7 = 0.6f;
            }
            i6 += (int) (f6 + f7);
        }
        if (this.mItems.size() > 0) {
            return Math.max(this.mItems.get(0).position, Math.min(i6, this.mItems.get(r4.size() - 1).position));
        }
        return i6;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        float f6;
        int i6;
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f6 = getScrollX() / clientWidth;
        } else {
            f6 = 0.0f;
        }
        int i7 = -1;
        ItemInfo itemInfo = null;
        int i8 = 0;
        boolean z5 = true;
        float f7 = 0.0f;
        while (i8 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i8);
            if (!z5 && itemInfo2.position != (i6 = i7 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f7 + 0.0f + 0.0f;
                itemInfo2.position = i6;
                i8--;
            }
            f7 = itemInfo2.offset;
            float f8 = 1.0f + f7 + 0.0f;
            if (!z5 && f6 < f7) {
                break;
            }
            if (f6 >= f8 && i8 != this.mItems.size() - 1) {
                i7 = itemInfo2.position;
                i8++;
                itemInfo = itemInfo2;
                z5 = false;
            } else {
                return itemInfo2;
            }
        }
        return itemInfo;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i6;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.mLastMotionX = motionEvent.getX(i6);
            this.mActivePointerId = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z5) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z5);
        }
    }

    private void scrollToItem(int i6, boolean z5, int i7, boolean z6) {
        int i8;
        ItemInfo infoForPosition = infoForPosition(i6);
        if (infoForPosition != null) {
            i8 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)));
        } else {
            i8 = 0;
        }
        if (z5) {
            smoothScrollTo(i8, 0, i7);
            if (z6) {
                dispatchOnPageSelected(i6);
                return;
            }
            return;
        }
        if (z6) {
            dispatchOnPageSelected(i6);
        }
        completeScroll(false);
        scrollTo(i8, 0);
        pageScrolled(i8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i6, int i7) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurPosition) {
                    childAt.addFocusables(arrayList, i6, i7);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i7 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z5 = layoutParams2.isDecor;
        layoutParams2.isDecor = z5;
        if (this.mInLayout) {
            if (!z5) {
                layoutParams2.needsMeasure = true;
                addViewInLayout(view, i6, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i6, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean arrowScroll(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L48
        L9:
            if (r0 == 0) goto L48
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L48
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L7
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto L98
            if (r1 == r0) goto L98
            if (r5 != r3) goto L78
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.getChildRectInPagerCoordinates(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.getChildRectInPagerCoordinates(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L73
            if (r2 < r3) goto L73
            boolean r0 = r4.pageLeft()
            goto Laf
        L73:
            boolean r0 = r1.requestFocus()
            goto Laf
        L78:
            if (r5 != r2) goto La4
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.getChildRectInPagerCoordinates(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.getChildRectInPagerCoordinates(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L93
            if (r2 > r3) goto L93
            boolean r0 = r4.pageRight()
            goto Laf
        L93:
            boolean r0 = r1.requestFocus()
            goto Laf
        L98:
            if (r5 == r3) goto Lab
            r0 = 1
            if (r5 != r0) goto L9e
            goto Lab
        L9e:
            if (r5 == r2) goto La6
            r0 = 2
            if (r5 != r0) goto La4
            goto La6
        La4:
            r0 = 0
            goto Laf
        La6:
            boolean r0 = r4.pageRight()
            goto Laf
        Lab:
            boolean r0 = r4.pageLeft()
        Laf:
            if (r0 == 0) goto Lb8
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.shareboard.widgets.SocializeViewPager.arrowScroll(int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurPosition && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                            return arrowScroll(2);
                        }
                        if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                            return arrowScroll(1);
                        }
                        return false;
                    }
                    return false;
                }
                return arrowScroll(66);
            }
            return arrowScroll(17);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return infoForChild(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f6;
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.mIsBeingDragged) {
                    return true;
                }
                if (this.mIsUnableToDrag) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                } else {
                    int i6 = this.mActivePointerId;
                    if (i6 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i6);
                        float x5 = motionEvent.getX(findPointerIndex);
                        float f7 = x5 - this.mLastMotionX;
                        float abs = Math.abs(f7);
                        float y5 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y5 - this.mInitialMotionY);
                        if (f7 != 0.0f && !isGutterDrag(this.mLastMotionX, f7) && canScroll(this, false, (int) f7, (int) x5, (int) y5)) {
                            this.mLastMotionX = x5;
                            this.mLastMotionY = y5;
                            this.mIsUnableToDrag = true;
                            return false;
                        }
                        int i7 = this.mTouchSlop;
                        if (abs > i7 && abs * 0.5f > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            setScrollState(1);
                            float f8 = this.mInitialMotionX;
                            float f9 = this.mTouchSlop;
                            if (f7 > 0.0f) {
                                f6 = f8 + f9;
                            } else {
                                f6 = f8 - f9;
                            }
                            this.mLastMotionX = f6;
                            this.mLastMotionY = y5;
                        } else if (abs2 > i7) {
                            this.mIsUnableToDrag = true;
                        }
                        if (this.mIsBeingDragged && performDrag(x5)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    }
                }
            } else {
                float x6 = motionEvent.getX();
                this.mInitialMotionX = x6;
                this.mLastMotionX = x6;
                float y6 = motionEvent.getY();
                this.mInitialMotionY = y6;
                this.mLastMotionY = y6;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                } else {
                    completeScroll(false);
                    this.mIsBeingDragged = false;
                }
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return this.mIsBeingDragged;
        }
        resetTouch();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        ItemInfo infoForChild;
        int childCount = getChildCount();
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i12 = (i10 - paddingLeft) - paddingRight;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!layoutParams.isDecor && (infoForChild = infoForChild(childAt)) != null) {
                    float f6 = i12;
                    int i14 = ((int) (infoForChild.offset * f6)) + paddingLeft;
                    if (layoutParams.needsMeasure) {
                        layoutParams.needsMeasure = false;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (f6 * layoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, childAt.getMeasuredHeight() + paddingTop);
                }
            }
        }
        if (this.mFirstLayout) {
            scrollToItem(this.mCurPosition, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    protected void onPageScrolled(int i6, float f6, int i7) {
        dispatchOnPageScrolled(i6, f6, i7);
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int i7;
        int i8;
        int i9;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        if ((i6 & 2) != 0) {
            i8 = childCount;
            i7 = 0;
            i9 = 1;
        } else {
            i7 = childCount - 1;
            i8 = -1;
            i9 = -1;
        }
        while (i7 != i8) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurPosition && childAt.requestFocus(i6, rect)) {
                return true;
            }
            i7 += i9;
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 != i8) {
            recomputeScrollPosition(i6, i8, 0, 0);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SocializePagerAdapter socializePagerAdapter;
        float f6;
        boolean z5 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (socializePagerAdapter = this.mAdapter) == null || socializePagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                onSecondaryPointerUp(motionEvent);
                                this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            this.mLastMotionX = motionEvent.getX(actionIndex);
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (this.mIsBeingDragged) {
                        scrollToItem(this.mCurPosition, true, 0, false);
                        z5 = resetTouch();
                    }
                } else {
                    if (!this.mIsBeingDragged) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex == -1) {
                            z5 = resetTouch();
                        } else {
                            float x5 = motionEvent.getX(findPointerIndex);
                            float abs = Math.abs(x5 - this.mLastMotionX);
                            float y5 = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y5 - this.mLastMotionY);
                            if (abs > this.mTouchSlop && abs > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                float f7 = this.mInitialMotionX;
                                if (x5 - f7 > 0.0f) {
                                    f6 = f7 + this.mTouchSlop;
                                } else {
                                    f6 = f7 - this.mTouchSlop;
                                }
                                this.mLastMotionX = f6;
                                this.mLastMotionY = y5;
                                setScrollState(1);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z5 = performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                    }
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / clientWidth) - infoForCurrentScrollPosition.offset) / 1.0f, xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                z5 = resetTouch();
            }
        } else {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x6 = motionEvent.getX();
            this.mInitialMotionX = x6;
            this.mLastMotionX = x6;
            float y6 = motionEvent.getY();
            this.mInitialMotionY = y6;
            this.mLastMotionY = y6;
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        if (z5) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public void setCurrentItem(int i6, boolean z5) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i6, z5, false);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SocializeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }

    public SocializeViewPager(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }

    @TargetApi(21)
    public SocializeViewPager(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }
}

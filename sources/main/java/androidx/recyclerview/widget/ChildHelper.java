package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int i6) {
            if (i6 < 64) {
                this.mData &= ~(1 << i6);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i6 - 64);
            }
        }

        int countOnesBefore(int i6) {
            Bucket bucket = this.mNext;
            return bucket == null ? i6 >= 64 ? Long.bitCount(this.mData) : Long.bitCount(this.mData & ((1 << i6) - 1)) : i6 < 64 ? Long.bitCount(this.mData & ((1 << i6) - 1)) : bucket.countOnesBefore(i6 - 64) + Long.bitCount(this.mData);
        }

        boolean get(int i6) {
            if (i6 < 64) {
                return (this.mData & (1 << i6)) != 0;
            }
            ensureNext();
            return this.mNext.get(i6 - 64);
        }

        void insert(int i6, boolean z5) {
            if (i6 >= 64) {
                ensureNext();
                this.mNext.insert(i6 - 64, z5);
                return;
            }
            long j6 = this.mData;
            boolean z6 = (Long.MIN_VALUE & j6) != 0;
            long j7 = (1 << i6) - 1;
            this.mData = ((j6 & (~j7)) << 1) | (j6 & j7);
            if (z5) {
                set(i6);
            } else {
                clear(i6);
            }
            if (z6 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z6);
            }
        }

        boolean remove(int i6) {
            if (i6 >= 64) {
                ensureNext();
                return this.mNext.remove(i6 - 64);
            }
            long j6 = 1 << i6;
            long j7 = this.mData;
            boolean z5 = (j7 & j6) != 0;
            long j8 = j7 & (~j6);
            this.mData = j8;
            long j9 = j6 - 1;
            this.mData = (j8 & j9) | Long.rotateRight((~j9) & j8, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z5;
        }

        void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        void set(int i6) {
            if (i6 < 64) {
                this.mData |= 1 << i6;
            } else {
                ensureNext();
                this.mNext.set(i6 - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }

        Bucket() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Callback {
        void addView(View view, int i6);

        void attachViewToParent(View view, int i6, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i6);

        View getChildAt(int i6);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i6);
    }

    private int getOffset(int i6) {
        if (i6 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i7 = i6;
        while (i7 < childCount) {
            int countOnesBefore = i6 - (i7 - this.mBucket.countOnesBefore(i7));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i7)) {
                    i7++;
                }
                return i7;
            }
            i7 += countOnesBefore;
        }
        return -1;
    }

    void addView(View view, boolean z5) {
        addView(view, -1, z5);
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    void addView(View view, int i6, boolean z5) {
        int childCount = i6 < 0 ? this.mCallback.getChildCount() : getOffset(i6);
        this.mBucket.insert(childCount, z5);
        if (z5) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }

    void attachViewToParent(View view, int i6, ViewGroup.LayoutParams layoutParams, boolean z5) {
        int childCount = i6 < 0 ? this.mCallback.getChildCount() : getOffset(i6);
        this.mBucket.insert(childCount, z5);
        if (z5) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    View findHiddenNonRemovedView(int i6) {
        int size = this.mHiddenViews.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.mHiddenViews.get(i7);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i6 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    View getUnfilteredChildAt(int i6) {
        return this.mCallback.getChildAt(i6);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    void removeView(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    boolean removeViewIfHidden(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (!this.mBucket.get(indexOfChild)) {
            return false;
        }
        this.mBucket.remove(indexOfChild);
        unhideViewInternal(view);
        this.mCallback.removeViewAt(indexOfChild);
        return true;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.mBucket.get(indexOfChild)) {
            this.mBucket.clear(indexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    void detachViewFromParent(int i6) {
        int offset = getOffset(i6);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    View getChildAt(int i6) {
        return this.mCallback.getChildAt(getOffset(i6));
    }

    void removeViewAt(int i6) {
        int offset = getOffset(i6);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }
}

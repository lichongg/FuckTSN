package androidx.recyclerview.widget;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final ViewCallback mViewCallback;
    final int[] mTmpRange = new int[2];
    final int[] mPrevRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    private int mScrollHint = 0;
    int mItemCount = 0;
    int mDisplayedGeneration = 0;
    int mRequestedGeneration = 0;
    final SparseIntArray mMissingPositions = new SparseIntArray();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i6, int i7);

        @WorkerThread
        public abstract int refreshData();

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i6) {
            int i7 = iArr[1];
            int i8 = iArr[0];
            int i9 = (i7 - i8) + 1;
            int i10 = i9 / 2;
            iArr2[0] = i8 - (i6 == 1 ? i9 : i10);
            if (i6 != 2) {
                i9 = i10;
            }
            iArr2[1] = i7 + i9;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i6);
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    @Nullable
    public T getItem(int i6) {
        if (i6 < 0 || i6 >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i6 + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i6);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i6, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i6 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i6;
        backgroundCallback.refresh(i6);
    }

    void updateRange() {
        int i6;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (i7 > i8 || i7 < 0 || i8 >= this.mItemCount) {
            return;
        }
        if (this.mAllowScrollHints) {
            int[] iArr2 = this.mPrevRange;
            if (i7 > iArr2[1] || (i6 = iArr2[0]) > i8) {
                this.mScrollHint = 0;
            } else if (i7 < i6) {
                this.mScrollHint = 1;
            } else if (i7 > i6) {
                this.mScrollHint = 2;
            }
        } else {
            this.mScrollHint = 0;
        }
        int[] iArr3 = this.mPrevRange;
        iArr3[0] = i7;
        iArr3[1] = i8;
        this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
        int[] iArr4 = this.mTmpRangeExtended;
        iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.mTmpRangeExtended;
        iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int[] iArr6 = this.mTmpRange;
        int i9 = iArr6[0];
        int i10 = iArr6[1];
        int[] iArr7 = this.mTmpRangeExtended;
        backgroundCallback.updateRange(i9, i10, iArr7[0], iArr7[1], this.mScrollHint);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i6, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        ThreadUtil.MainThreadCallback<T> mainThreadCallback = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
            private void recycleAllTiles() {
                for (int i7 = 0; i7 < AsyncListUtil.this.mTileList.size(); i7++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i7));
                }
                AsyncListUtil.this.mTileList.clear();
            }

            private boolean isRequestedGeneration(int i7) {
                return i7 == AsyncListUtil.this.mRequestedGeneration;
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void addTile(int i7, TileList.Tile<T> tile) {
                if (!isRequestedGeneration(i7)) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (addOrReplace != null) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
                }
                int i8 = tile.mStartPosition + tile.mItemCount;
                int i9 = 0;
                while (i9 < AsyncListUtil.this.mMissingPositions.size()) {
                    int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i9);
                    if (tile.mStartPosition <= keyAt && keyAt < i8) {
                        AsyncListUtil.this.mMissingPositions.removeAt(i9);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                    } else {
                        i9++;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void removeTile(int i7, int i8) {
                TileList.Tile<T> removeAtPos;
                if (!isRequestedGeneration(i7) || (removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i8)) == null) {
                    return;
                }
                AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void updateItemCount(int i7, int i8) {
                if (!isRequestedGeneration(i7)) {
                    return;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mItemCount = i8;
                asyncListUtil.mViewCallback.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                recycleAllTiles();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.mAllowScrollHints = false;
                asyncListUtil3.updateRange();
            }
        };
        this.mMainThreadCallback = mainThreadCallback;
        ThreadUtil.BackgroundCallback<T> backgroundCallback = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;

            private void requestTiles(int i7, int i8, int i9, boolean z5) {
                int i10 = i7;
                while (i10 <= i8) {
                    AsyncListUtil.this.mBackgroundProxy.loadTile(z5 ? (i8 + i7) - i10 : i10, i9);
                    i10 += AsyncListUtil.this.mTileSize;
                }
            }

            private TileList.Tile<T> acquireTile() {
                TileList.Tile<T> tile = this.mRecycledRoot;
                if (tile != null) {
                    this.mRecycledRoot = tile.mNext;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int i7) {
                int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= maxCachedTiles) {
                    int keyAt = this.mLoadedTiles.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i8 = this.mFirstRequiredTileStart - keyAt;
                    int i9 = keyAt2 - this.mLastRequiredTileStart;
                    if (i8 > 0 && (i8 >= i9 || i7 == 2)) {
                        removeTile(keyAt);
                    } else {
                        if (i9 <= 0) {
                            return;
                        }
                        if (i8 >= i9 && i7 != 1) {
                            return;
                        } else {
                            removeTile(keyAt2);
                        }
                    }
                }
            }

            private int getTileStart(int i7) {
                return i7 - (i7 % AsyncListUtil.this.mTileSize);
            }

            private boolean isTileLoaded(int i7) {
                return this.mLoadedTiles.get(i7);
            }

            private void removeTile(int i7) {
                this.mLoadedTiles.delete(i7);
                AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i7);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void refresh(int i7) {
                this.mGeneration = i7;
                this.mLoadedTiles.clear();
                int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
                this.mItemCount = refreshData;
                AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void updateRange(int i7, int i8, int i9, int i10, int i11) {
                if (i7 > i8) {
                    return;
                }
                int tileStart = getTileStart(i7);
                int tileStart2 = getTileStart(i8);
                this.mFirstRequiredTileStart = getTileStart(i9);
                int tileStart3 = getTileStart(i10);
                this.mLastRequiredTileStart = tileStart3;
                if (i11 == 1) {
                    requestTiles(this.mFirstRequiredTileStart, tileStart2, i11, true);
                    requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i11, false);
                } else {
                    requestTiles(tileStart, tileStart3, i11, false);
                    requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i11, true);
                }
            }

            private void log(String str, Object... objArr) {
                String.format(str, objArr);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void loadTile(int i7, int i8) {
                if (isTileLoaded(i7)) {
                    return;
                }
                TileList.Tile<T> acquireTile = acquireTile();
                acquireTile.mStartPosition = i7;
                int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i7);
                acquireTile.mItemCount = min;
                AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
                flushTileCache(i8);
                addTile(acquireTile);
            }
        };
        this.mBackgroundCallback = backgroundCallback;
        this.mTClass = cls;
        this.mTileSize = i6;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i6);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(mainThreadCallback);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(backgroundCallback);
        refresh();
    }

    void log(String str, Object... objArr) {
        String.format(str, objArr);
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }
}

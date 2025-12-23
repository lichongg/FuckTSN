package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        boolean containsPosition(int i6) {
            int i7 = this.mStartPosition;
            return i7 <= i6 && i6 < i7 + this.mItemCount;
        }

        T getByPosition(int i6) {
            return this.mItems[i6 - this.mStartPosition];
        }

        Tile(@NonNull Class<T> cls, int i6) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i6));
        }
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.mLastAccessedTile == valueAt) {
            this.mLastAccessedTile = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i6) {
        if (i6 < 0 || i6 >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i6);
    }

    public T getItemAt(int i6) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i6)) {
            int indexOfKey = this.mTiles.indexOfKey(i6 - (i6 % this.mTileSize));
            if (indexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i6);
    }

    public Tile<T> removeAtPos(int i6) {
        Tile<T> tile = this.mTiles.get(i6);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i6);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }

    public TileList(int i6) {
        this.mTileSize = i6;
    }
}

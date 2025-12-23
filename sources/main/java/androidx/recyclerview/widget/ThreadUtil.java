package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.TileList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
interface ThreadUtil<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface BackgroundCallback<T> {
        void loadTile(int i6, int i7);

        @SuppressLint({"UnknownNullness"})
        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i6);

        void updateRange(int i6, int i7, int i8, int i9, int i10);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void addTile(int i6, TileList.Tile<T> tile);

        void removeTile(int i6, int i7);

        void updateItemCount(int i6, int i7);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}

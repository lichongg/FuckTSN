package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class TransitionValuesMaps {
    final ArrayMap<View, TransitionValues> mViewValues = new ArrayMap<>();
    final SparseArray<View> mIdValues = new SparseArray<>();
    final LongSparseArray<View> mItemIdValues = new LongSparseArray<>();
    final ArrayMap<String, View> mNameValues = new ArrayMap<>();

    TransitionValuesMaps() {
    }
}

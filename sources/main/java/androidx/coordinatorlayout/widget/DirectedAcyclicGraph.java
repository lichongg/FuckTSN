package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    public void addEdge(@NonNull T t5, @NonNull T t6) {
        if (!this.mGraph.containsKey(t5) || !this.mGraph.containsKey(t6)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.mGraph.get(t5);
        if (arrayList == null) {
            arrayList = getEmptyList();
            this.mGraph.put(t5, arrayList);
        }
        arrayList.add(t6);
    }

    public void addNode(@NonNull T t5) {
        if (this.mGraph.containsKey(t5)) {
            return;
        }
        this.mGraph.put(t5, null);
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i6 = 0; i6 < size; i6++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i6);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t5) {
        return this.mGraph.containsKey(t5);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t5) {
        return this.mGraph.get(t5);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t5) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i6);
            if (valueAt != null && valueAt.contains(t5)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i6));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i6 = 0; i6 < size; i6++) {
            dfs(this.mGraph.keyAt(i6), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t5) {
        int size = this.mGraph.size();
        for (int i6 = 0; i6 < size; i6++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i6);
            if (valueAt != null && valueAt.contains(t5)) {
                return true;
            }
        }
        return false;
    }

    int size() {
        return this.mGraph.size();
    }

    private void dfs(T t5, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t5)) {
            return;
        }
        if (!hashSet.contains(t5)) {
            hashSet.add(t5);
            ArrayList<T> arrayList2 = this.mGraph.get(t5);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i6 = 0; i6 < size; i6++) {
                    dfs(arrayList2.get(i6), arrayList, hashSet);
                }
            }
            hashSet.remove(t5);
            arrayList.add(t5);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }
}

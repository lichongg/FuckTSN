package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.ObservableMap;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {
    private transient MapChangeRegistry mListeners;

    private void notifyChange(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, obj);
        }
    }

    @Override // androidx.databinding.ObservableMap
    public void addOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new MapChangeRegistry();
        }
        this.mListeners.add(onMapChangedCallback);
    }

    @Override // androidx.databinding.ObservableMap
    public void removeOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(onMapChangedCallback);
        }
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        if (!isEmpty()) {
            super.clear();
            notifyChange(null);
        }
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k6, V v5) {
        super.put(k6, v5);
        notifyChange(k6);
        return v5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.ArrayMap
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            int indexOfKey = indexOfKey(it.next());
            if (indexOfKey >= 0) {
                removeAt(indexOfKey);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i6) {
        K keyAt = keyAt(i6);
        V v5 = (V) super.removeAt(i6);
        if (v5 != null) {
            notifyChange(keyAt);
        }
        return v5;
    }

    @Override // androidx.collection.ArrayMap
    public boolean retainAll(Collection<?> collection) {
        boolean z5 = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(keyAt(size))) {
                removeAt(size);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i6, V v5) {
        K keyAt = keyAt(i6);
        V v6 = (V) super.setValueAt(i6, v5);
        notifyChange(keyAt);
        return v6;
    }
}

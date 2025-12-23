package androidx.databinding;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface ObservableMap<K, V> extends Map<K, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class OnMapChangedCallback<T extends ObservableMap<K, V>, K, V> {
        public abstract void onMapChanged(T sender, K key);
    }

    void addOnMapChangedCallback(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> callback);

    void removeOnMapChangedCallback(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> callback);
}

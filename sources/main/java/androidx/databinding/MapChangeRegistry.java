package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class MapChangeRegistry extends CallbackRegistry<ObservableMap.OnMapChangedCallback, ObservableMap, Object> {
    private static CallbackRegistry.NotifierCallback<ObservableMap.OnMapChangedCallback, ObservableMap, Object> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback<ObservableMap.OnMapChangedCallback, ObservableMap, Object>() { // from class: androidx.databinding.MapChangeRegistry.1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(ObservableMap.OnMapChangedCallback onMapChangedCallback, ObservableMap observableMap, int i6, Object obj) {
            onMapChangedCallback.onMapChanged(observableMap, obj);
        }
    };

    public void notifyChange(@NonNull ObservableMap observableMap, @Nullable Object obj) {
        notifyCallbacks(observableMap, 0, obj);
    }

    public MapChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }
}

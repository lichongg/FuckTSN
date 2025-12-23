package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class PropertyChangeRegistry extends CallbackRegistry<Observable.OnPropertyChangedCallback, Observable, Void> {
    private static final CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void>() { // from class: androidx.databinding.PropertyChangeRegistry.1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback, Observable observable, int i6, Void r42) {
            onPropertyChangedCallback.onPropertyChanged(observable, i6);
        }
    };

    public void notifyChange(@NonNull Observable observable, int i6) {
        notifyCallbacks(observable, i6, null);
    }

    public PropertyChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }
}

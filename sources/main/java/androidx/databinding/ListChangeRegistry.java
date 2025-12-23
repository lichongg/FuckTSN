package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ListChangeRegistry extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, ListChanges> {
    private static final int ALL = 0;
    private static final int CHANGED = 1;
    private static final int INSERTED = 2;
    private static final int MOVED = 3;
    private static final int REMOVED = 4;
    private static final Pools.SynchronizedPool<ListChanges> sListChanges = new Pools.SynchronizedPool<>(10);
    private static final CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges>() { // from class: androidx.databinding.ListChangeRegistry.1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(ObservableList.OnListChangedCallback onListChangedCallback, ObservableList observableList, int i6, ListChanges listChanges) {
            if (i6 == 1) {
                onListChangedCallback.onItemRangeChanged(observableList, listChanges.start, listChanges.count);
                return;
            }
            if (i6 == 2) {
                onListChangedCallback.onItemRangeInserted(observableList, listChanges.start, listChanges.count);
                return;
            }
            if (i6 == 3) {
                onListChangedCallback.onItemRangeMoved(observableList, listChanges.start, listChanges.to, listChanges.count);
            } else if (i6 != 4) {
                onListChangedCallback.onChanged(observableList);
            } else {
                onListChangedCallback.onItemRangeRemoved(observableList, listChanges.start, listChanges.count);
            }
        }
    };

    public void notifyChanged(@NonNull ObservableList observableList) {
        notifyCallbacks(observableList, 0, (ListChanges) null);
    }

    public void notifyInserted(@NonNull ObservableList observableList, int i6, int i7) {
        notifyCallbacks(observableList, 2, acquire(i6, 0, i7));
    }

    public void notifyRemoved(@NonNull ObservableList observableList, int i6, int i7) {
        notifyCallbacks(observableList, 4, acquire(i6, 0, i7));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ListChanges {
        public int count;
        public int start;
        public int to;

        ListChanges() {
        }
    }

    public ListChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    private static ListChanges acquire(int i6, int i7, int i8) {
        ListChanges acquire = sListChanges.acquire();
        if (acquire == null) {
            acquire = new ListChanges();
        }
        acquire.start = i6;
        acquire.to = i7;
        acquire.count = i8;
        return acquire;
    }

    @Override // androidx.databinding.CallbackRegistry
    public synchronized void notifyCallbacks(@NonNull ObservableList observableList, int i6, ListChanges listChanges) {
        super.notifyCallbacks((ListChangeRegistry) observableList, i6, (int) listChanges);
        if (listChanges != null) {
            sListChanges.release(listChanges);
        }
    }

    public void notifyChanged(@NonNull ObservableList observableList, int i6, int i7) {
        notifyCallbacks(observableList, 1, acquire(i6, 0, i7));
    }

    public void notifyMoved(@NonNull ObservableList observableList, int i6, int i7, int i8) {
        notifyCallbacks(observableList, 3, acquire(i6, i7, i8));
    }
}

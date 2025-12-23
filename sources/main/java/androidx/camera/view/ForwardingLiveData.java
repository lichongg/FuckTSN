package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class ForwardingLiveData<T> extends MediatorLiveData<T> {
    private LiveData<T> mLiveDataSource;

    @Override // androidx.lifecycle.LiveData
    public T getValue() {
        LiveData<T> liveData = this.mLiveDataSource;
        if (liveData == null) {
            return null;
        }
        return liveData.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void setSource(@NonNull LiveData<T> liveData) {
        LiveData<T> liveData2 = this.mLiveDataSource;
        if (liveData2 != null) {
            super.removeSource(liveData2);
        }
        this.mLiveDataSource = liveData;
        super.addSource(liveData, new Observer() { // from class: androidx.camera.view.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ForwardingLiveData.this.setValue(obj);
            }
        });
    }

    ForwardingLiveData() {
    }
}

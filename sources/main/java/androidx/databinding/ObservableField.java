package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ObservableField<T> extends BaseObservableField implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t5) {
        this.mValue = t5;
    }

    @Nullable
    public T get() {
        return this.mValue;
    }

    public void set(T t5) {
        if (t5 != this.mValue) {
            this.mValue = t5;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(Observable... observableArr) {
        super(observableArr);
    }
}

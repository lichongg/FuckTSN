package androidx.databinding;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface Observable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable sender, int propertyId);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback callback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback);
}

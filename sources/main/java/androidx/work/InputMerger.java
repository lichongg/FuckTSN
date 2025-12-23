package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class InputMerger {
    private static final String TAG = Logger.tagWithPrefix("InputMerger");

    @NonNull
    public abstract Data merge(@NonNull List<Data> inputs);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(String className) {
        try {
            return (InputMerger) Class.forName(className).newInstance();
        } catch (Exception e6) {
            Logger.get().error(TAG, "Trouble instantiating + " + className, e6);
            return null;
        }
    }
}

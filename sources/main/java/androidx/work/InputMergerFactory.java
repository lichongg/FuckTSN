package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class InputMergerFactory {
    @Nullable
    public abstract InputMerger createInputMerger(@NonNull String className);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new InputMergerFactory() { // from class: androidx.work.InputMergerFactory.1
            @Override // androidx.work.InputMergerFactory
            @Nullable
            public InputMerger createInputMerger(@NonNull String className) {
                return null;
            }
        };
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(@NonNull String className) {
        InputMerger createInputMerger = createInputMerger(className);
        if (createInputMerger == null) {
            return InputMerger.fromClassName(className);
        }
        return createInputMerger;
    }
}

package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SavedStateHandlesVM extends ViewModel {

    @NotNull
    private final Map<String, SavedStateHandle> handles = new LinkedHashMap();

    @NotNull
    public final Map<String, SavedStateHandle> getHandles() {
        return this.handles;
    }
}

package androidx.core.content.pm;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ShortcutInfoChangeListener {
    @AnyThread
    public void onAllShortcutsRemoved() {
    }

    @AnyThread
    public void onShortcutAdded(@NonNull List<ShortcutInfoCompat> list) {
    }

    @AnyThread
    public void onShortcutRemoved(@NonNull List<String> list) {
    }

    @AnyThread
    public void onShortcutUpdated(@NonNull List<ShortcutInfoCompat> list) {
    }

    @AnyThread
    public void onShortcutUsageReported(@NonNull List<String> list) {
    }
}

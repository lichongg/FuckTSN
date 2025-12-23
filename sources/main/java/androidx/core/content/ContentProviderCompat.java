package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    @NonNull
    public static Context requireContext(@NonNull ContentProvider contentProvider) {
        Context context = contentProvider.getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}

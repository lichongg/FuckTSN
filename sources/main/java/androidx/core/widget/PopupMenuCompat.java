package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PopupMenuCompat {
    @Nullable
    public static View.OnTouchListener getDragToOpenListener(@NonNull Object obj) {
        return ((PopupMenu) obj).getDragToOpenListener();
    }

    private PopupMenuCompat() {
    }
}

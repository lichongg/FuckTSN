package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private final Context mContext;

    @NonNull
    public Display[] getDisplays() {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    @NonNull
    public static DisplayManagerCompat getInstance(@NonNull Context context) {
        return new DisplayManagerCompat(context);
    }

    @Nullable
    public Display getDisplay(int i6) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(i6);
    }

    @NonNull
    public Display[] getDisplays(@Nullable String str) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }
}

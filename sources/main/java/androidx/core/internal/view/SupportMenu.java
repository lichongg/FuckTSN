package androidx.core.internal.view;

import android.view.Menu;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public interface SupportMenu extends Menu {
    public static final int CATEGORY_MASK = -65536;
    public static final int CATEGORY_SHIFT = 16;
    public static final int FLAG_KEEP_OPEN_ON_SUBMENU_OPENED = 4;
    public static final int SUPPORTED_MODIFIERS_MASK = 69647;
    public static final int USER_MASK = 65535;
    public static final int USER_SHIFT = 0;

    @Override // android.view.Menu
    void setGroupDividerEnabled(boolean z5);
}

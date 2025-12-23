package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(22)
/* loaded from: D:\Downloads\app\classes.dex */
final class PersistableBundleApi22ImplKt {

    @NotNull
    public static final PersistableBundleApi22ImplKt INSTANCE = new PersistableBundleApi22ImplKt();

    private PersistableBundleApi22ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final void putBoolean(@NotNull PersistableBundle persistableBundle, @Nullable String str, boolean z5) {
        persistableBundle.putBoolean(str, z5);
    }

    @JvmStatic
    @DoNotInline
    public static final void putBooleanArray(@NotNull PersistableBundle persistableBundle, @Nullable String str, @NotNull boolean[] zArr) {
        persistableBundle.putBooleanArray(str, zArr);
    }
}

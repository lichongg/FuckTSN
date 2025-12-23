package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPersistableBundle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,155:1\n13579#2,2:156\n*S KotlinDebug\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n*L\n35#1:156,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle persistableBundleOf(@NotNull Pair<String, ? extends Object>... pairArr) {
        PersistableBundle createPersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            PersistableBundleApi21ImplKt.putValue(createPersistableBundle, pair.component1(), pair.component2());
        }
        return createPersistableBundle;
    }

    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle toPersistableBundle(@NotNull Map<String, ? extends Object> map) {
        PersistableBundle createPersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(createPersistableBundle, entry.getKey(), entry.getValue());
        }
        return createPersistableBundle;
    }

    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }
}

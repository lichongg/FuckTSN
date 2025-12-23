package okhttp3.internal.publicsuffix;

import kotlin.jvm.internal.g0;
import okhttp3.internal.publicsuffix.PublicSuffixList;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class PublicSuffixList_androidKt {
    @NotNull
    public static final PublicSuffixList getDefault(@NotNull PublicSuffixList.Companion companion) {
        g0.p(companion, "<this>");
        return new AssetPublicSuffixList(null, 1, null);
    }
}

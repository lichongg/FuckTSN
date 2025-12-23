package kotlin.text;

import java.util.Set;
import kotlin.internal.InlineOnly;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class b0 extends a0 {
    @InlineOnly
    private static final Regex A(String str, Set<? extends RegexOption> options) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        return new Regex(str, options);
    }

    @InlineOnly
    private static final Regex B(String str, RegexOption option) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(option, "option");
        return new Regex(str, option);
    }

    @InlineOnly
    private static final Regex z(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return new Regex(str);
    }
}

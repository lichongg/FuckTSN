package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.text.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHexFormat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexFormat.kt\nkotlin/text/HexFormatKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,845:1\n1088#2,2:846\n*S KotlinDebug\n*F\n+ 1 HexFormat.kt\nkotlin/text/HexFormatKt\n*L\n843#1:846,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (kotlin.jvm.internal.g0.t(charAt, 128) >= 0 || Character.isLetter(charAt)) {
                return true;
            }
        }
        return false;
    }

    @SinceKotlin(version = "2.2")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final j a(Function1<? super j.a, n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        j.a aVar = new j.a();
        builderAction.invoke(aVar);
        return aVar.a();
    }
}

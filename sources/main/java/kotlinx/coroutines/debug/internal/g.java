package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '\b') {
                sb.append("\\b");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\t') {
                sb.append("\\t");
            } else {
                sb.append(charAt);
            }
        }
        sb.append('\"');
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}

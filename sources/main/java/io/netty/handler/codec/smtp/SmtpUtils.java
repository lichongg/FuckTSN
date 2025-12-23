package io.netty.handler.codec.smtp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SmtpUtils {
    static List<CharSequence> toUnmodifiableList(CharSequence... charSequenceArr) {
        return (charSequenceArr == null || charSequenceArr.length == 0) ? Collections.EMPTY_LIST : Collections.unmodifiableList(Arrays.asList(charSequenceArr));
    }

    private SmtpUtils() {
    }
}

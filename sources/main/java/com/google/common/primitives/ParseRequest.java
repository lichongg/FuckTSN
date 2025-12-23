package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class ParseRequest {
    final int radix;
    final String rawValue;

    private ParseRequest(String str, int i6) {
        this.rawValue = str;
        this.radix = i6;
    }

    static ParseRequest fromString(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i6 = 16;
            if (!str.startsWith("0x") && !str.startsWith("0X")) {
                if (charAt == '#') {
                    str = str.substring(1);
                } else if (charAt == '0' && str.length() > 1) {
                    str = str.substring(1);
                    i6 = 8;
                } else {
                    i6 = 10;
                }
            } else {
                str = str.substring(2);
            }
            return new ParseRequest(str, i6);
        }
        throw new NumberFormatException("empty string");
    }
}

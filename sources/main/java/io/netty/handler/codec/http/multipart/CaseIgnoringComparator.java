package io.netty.handler.codec.http.multipart;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class CaseIgnoringComparator implements Comparator<CharSequence>, Serializable {
    static final CaseIgnoringComparator INSTANCE = new CaseIgnoringComparator();
    private static final long serialVersionUID = 4582133183775373862L;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(CharSequence charSequence, CharSequence charSequence2) {
        char upperCase;
        char upperCase2;
        char lowerCase;
        char lowerCase2;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        for (int i6 = 0; i6 < min; i6++) {
            char charAt = charSequence.charAt(i6);
            char charAt2 = charSequence2.charAt(i6);
            if (charAt != charAt2 && (upperCase = Character.toUpperCase(charAt)) != (upperCase2 = Character.toUpperCase(charAt2)) && (lowerCase = Character.toLowerCase(upperCase)) != (lowerCase2 = Character.toLowerCase(upperCase2))) {
                return lowerCase - lowerCase2;
            }
        }
        return length - length2;
    }

    private CaseIgnoringComparator() {
    }
}

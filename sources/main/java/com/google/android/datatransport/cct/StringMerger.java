package com.google.android.datatransport.cct;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class StringMerger {
    static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length());
            for (int i6 = 0; i6 < str.length(); i6++) {
                sb.append(str.charAt(i6));
                if (str2.length() > i6) {
                    sb.append(str2.charAt(i6));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }
}

package cn.bluemobi.dylan.http;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EncodeUtils {
    public static String ascii2native(String str) {
        String[] split = str.split("\\\\u");
        String str2 = split[0];
        for (int i6 = 1; i6 < split.length; i6++) {
            try {
                String str3 = split[i6];
                String str4 = str2 + ((char) Integer.parseInt(str3.substring(0, 4), 16));
                str2 = str3.length() > 4 ? str4 + str3.substring(4, str3.length()) : str4;
            } catch (NumberFormatException unused) {
                return str;
            }
        }
        return str2;
    }

    public static String convertUnicode(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt == '\\') {
                i6 += 2;
                char charAt2 = str.charAt(i7);
                if (charAt2 == 'u') {
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < 4) {
                        int i10 = i6 + 1;
                        char charAt3 = str.charAt(i6);
                        switch (charAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i9 = ((i9 << 4) + charAt3) - 48;
                                break;
                            default:
                                switch (charAt3) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i9 = (((i9 << 4) + 10) + charAt3) - 65;
                                        break;
                                    default:
                                        switch (charAt3) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i9 = (((i9 << 4) + 10) + charAt3) - 97;
                                                break;
                                        }
                                }
                        }
                        i8++;
                        i6 = i10;
                    }
                    stringBuffer.append((char) i9);
                } else {
                    if (charAt2 == 't') {
                        charAt2 = '\t';
                    } else if (charAt2 == 'r') {
                        charAt2 = StringUtil.CARRIAGE_RETURN;
                    } else if (charAt2 == 'n') {
                        charAt2 = '\n';
                    } else if (charAt2 == 'f') {
                        charAt2 = '\f';
                    }
                    stringBuffer.append(charAt2);
                }
            } else {
                stringBuffer.append(charAt);
                i6 = i7;
            }
        }
        return stringBuffer.toString();
    }
}

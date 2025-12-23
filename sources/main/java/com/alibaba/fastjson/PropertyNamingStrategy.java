package com.alibaba.fastjson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String translate(String str) {
        int i6 = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
        int i7 = 0;
        if (i6 == 1) {
            StringBuilder sb = new StringBuilder();
            while (i7 < str.length()) {
                char charAt = str.charAt(i7);
                if (charAt < 'A' || charAt > 'Z') {
                    sb.append(charAt);
                } else {
                    char c6 = (char) (charAt + ' ');
                    if (i7 > 0) {
                        sb.append('_');
                    }
                    sb.append(c6);
                }
                i7++;
            }
            return sb.toString();
        }
        if (i6 == 2) {
            StringBuilder sb2 = new StringBuilder();
            while (i7 < str.length()) {
                char charAt2 = str.charAt(i7);
                if (charAt2 < 'A' || charAt2 > 'Z') {
                    sb2.append(charAt2);
                } else {
                    char c7 = (char) (charAt2 + ' ');
                    if (i7 > 0) {
                        sb2.append('-');
                    }
                    sb2.append(c7);
                }
                i7++;
            }
            return sb2.toString();
        }
        if (i6 == 3) {
            char charAt3 = str.charAt(0);
            if (charAt3 < 'a' || charAt3 > 'z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            return new String(charArray);
        }
        if (i6 != 4) {
            return str;
        }
        char charAt4 = str.charAt(0);
        if (charAt4 < 'A' || charAt4 > 'Z') {
            return str;
        }
        char[] charArray2 = str.toCharArray();
        charArray2[0] = (char) (charArray2[0] + ' ');
        return new String(charArray2);
    }
}

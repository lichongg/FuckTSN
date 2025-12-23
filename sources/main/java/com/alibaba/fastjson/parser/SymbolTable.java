package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SymbolTable {
    private final int indexMask;
    private final String[] symbols;

    public static int hash(char[] cArr, int i6, int i7) {
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            i9 = (i9 * 31) + cArr[i6];
            i8++;
            i6++;
        }
        return i9;
    }

    public String addSymbol(char[] cArr, int i6, int i7) {
        return addSymbol(cArr, i6, i7, hash(cArr, i6, i7));
    }

    private static String subString(String str, int i6, int i7) {
        char[] cArr = new char[i7];
        str.getChars(i6, i7 + i6, cArr, 0);
        return new String(cArr);
    }

    public SymbolTable(int i6) {
        this.indexMask = i6 - 1;
        this.symbols = new String[i6];
        addSymbol("$ref", 0, 4, 1185263);
        String str = JSON.DEFAULT_TYPE_KEY;
        addSymbol(str, 0, str.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public String addSymbol(char[] cArr, int i6, int i7, int i8) {
        int i9 = this.indexMask & i8;
        String str = this.symbols[i9];
        if (str != null) {
            if (i8 == str.hashCode() && i7 == str.length()) {
                for (int i10 = 0; i10 < i7; i10++) {
                    if (cArr[i6 + i10] == str.charAt(i10)) {
                    }
                }
                return str;
            }
            return new String(cArr, i6, i7);
        }
        String intern = new String(cArr, i6, i7).intern();
        this.symbols[i9] = intern;
        return intern;
    }

    public String addSymbol(String str, int i6, int i7, int i8) {
        int i9 = this.indexMask & i8;
        String str2 = this.symbols[i9];
        if (str2 != null) {
            return (i8 == str2.hashCode() && i7 == str2.length() && str.startsWith(str2, i6)) ? str2 : subString(str, i6, i7);
        }
        if (i7 != str.length()) {
            str = subString(str, i6, i7);
        }
        String intern = str.intern();
        this.symbols[i9] = intern;
        return intern;
    }
}

package com.sun.mail.imap.protocol;

import io.netty.util.internal.StringUtil;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import kotlin.text.v0;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f39389a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', StringUtil.COMMA};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f39390b = new byte[256];

    protected static int a(char[] cArr, int i6, CharacterIterator characterIterator) {
        byte b6;
        boolean z5 = true;
        loop0: while (true) {
            int i7 = -1;
            while (true) {
                byte next = (byte) characterIterator.next();
                if (next == -1) {
                    break loop0;
                }
                if (next != 45) {
                    byte next2 = (byte) characterIterator.next();
                    if (next2 == -1 || next2 == 45) {
                        break loop0;
                    }
                    byte[] bArr = f39390b;
                    byte b7 = bArr[next & 255];
                    byte b8 = bArr[next2 & 255];
                    byte b9 = (byte) (((b7 << 2) & 252) | ((b8 >>> 4) & 3));
                    if (i7 != -1) {
                        cArr[i6] = (char) ((i7 << 8) | (b9 & 255));
                        i6++;
                        i7 = -1;
                    } else {
                        i7 = b9 & 255;
                    }
                    byte next3 = (byte) characterIterator.next();
                    if (next3 != 61) {
                        if (next3 == -1 || next3 == 45) {
                            break loop0;
                        }
                        byte b10 = bArr[next3 & 255];
                        byte b11 = (byte) (((b8 << 4) & 240) | ((b10 >>> 2) & 15));
                        if (i7 != -1) {
                            cArr[i6] = (char) ((b11 & 255) | (i7 << 8));
                            i6++;
                            i7 = -1;
                        } else {
                            i7 = b11 & 255;
                        }
                        byte next4 = (byte) characterIterator.next();
                        if (next4 == 61) {
                            continue;
                        } else {
                            if (next4 == -1 || next4 == 45) {
                                break loop0;
                            }
                            b6 = (byte) ((bArr[next4 & 255] & Utf8.REPLACEMENT_BYTE) | ((b10 << 6) & 192));
                            if (i7 != -1) {
                                break;
                            }
                            i7 = b6 & 255;
                        }
                    }
                    z5 = false;
                } else if (z5) {
                    int i8 = i6 + 1;
                    cArr[i6] = v0.f47960d;
                    return i8;
                }
            }
            cArr[i6] = (char) ((b6 & 255) | (i7 << 8));
            i6++;
            z5 = false;
        }
        return i6;
    }

    static {
        int i6 = 0;
        for (int i7 = 0; i7 < 255; i7++) {
            f39390b[i7] = -1;
        }
        while (true) {
            char[] cArr = f39389a;
            if (i6 >= cArr.length) {
                return;
            }
            f39390b[cArr[i6]] = (byte) i6;
            i6++;
        }
    }

    public static String b(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cArr = new char[str.length()];
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z5 = false;
        int i6 = 0;
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '&') {
                z5 = true;
                i6 = a(cArr, i6, stringCharacterIterator);
            } else {
                cArr[i6] = first;
                i6++;
            }
        }
        return z5 ? new String(cArr, 0, i6) : str;
    }
}

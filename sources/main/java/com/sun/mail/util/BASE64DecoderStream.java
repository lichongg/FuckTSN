package com.sun.mail.util;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BASE64DecoderStream extends FilterInputStream {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] pem_convert_array = new byte[256];
    private byte[] buffer;
    private int bufsize;
    private boolean ignoreErrors;
    private int index;
    private byte[] input_buffer;
    private int input_len;
    private int input_pos;

    public BASE64DecoderStream(InputStream inputStream) {
        super(inputStream);
        this.buffer = new byte[3];
        boolean z5 = false;
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        try {
            String property = System.getProperty("mail.mime.base64.ignoreerrors");
            if (property != null && !property.equalsIgnoreCase("false")) {
                z5 = true;
            }
            this.ignoreErrors = z5;
        } catch (SecurityException unused) {
        }
    }

    private int decode(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = i6;
        while (i7 >= 3) {
            boolean z5 = false;
            int i9 = 0;
            int i10 = 0;
            while (i9 < 4) {
                int i11 = getByte();
                if (i11 == -1 || i11 == -2) {
                    if (i11 == -1) {
                        if (i9 == 0) {
                            return i8 - i6;
                        }
                        if (!this.ignoreErrors) {
                            throw new IOException("Error in encoded stream: needed 4 valid base64 characters but only got " + i9 + " before EOF" + recentChars());
                        }
                        z5 = true;
                    } else {
                        if (i9 < 2 && !this.ignoreErrors) {
                            throw new IOException("Error in encoded stream: needed at least 2 valid base64 characters, but only got " + i9 + " before padding character (=)" + recentChars());
                        }
                        if (i9 == 0) {
                            return i8 - i6;
                        }
                    }
                    int i12 = i9 - 1;
                    if (i12 == 0) {
                        i12 = 1;
                    }
                    int i13 = i10 << 6;
                    for (int i14 = i9 + 1; i14 < 4; i14++) {
                        if (!z5) {
                            int i15 = getByte();
                            if (i15 == -1) {
                                if (!this.ignoreErrors) {
                                    throw new IOException("Error in encoded stream: hit EOF while looking for padding characters (=)" + recentChars());
                                }
                            } else if (i15 != -2 && !this.ignoreErrors) {
                                throw new IOException("Error in encoded stream: found valid base64 character after a padding character (=)" + recentChars());
                            }
                        }
                        i13 <<= 6;
                    }
                    int i16 = i13 >> 8;
                    if (i12 == 2) {
                        bArr[i8 + 1] = (byte) (i16 & 255);
                    }
                    bArr[i8] = (byte) ((i13 >> 16) & 255);
                    return (i8 + i12) - i6;
                }
                i9++;
                i10 = (i10 << 6) | i11;
            }
            bArr[i8 + 2] = (byte) (i10 & 255);
            bArr[i8 + 1] = (byte) ((i10 >> 8) & 255);
            bArr[i8] = (byte) ((i10 >> 16) & 255);
            i7 -= 3;
            i8 += 3;
        }
        return i8 - i6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            byte[] bArr = this.buffer;
            int decode = decode(bArr, 0, bArr.length);
            this.bufsize = decode;
            if (decode <= 0) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr2 = this.buffer;
        int i6 = this.index;
        this.index = i6 + 1;
        return bArr2[i6] & 255;
    }

    static {
        int i6 = 0;
        for (int i7 = 0; i7 < 255; i7++) {
            pem_convert_array[i7] = -1;
        }
        while (true) {
            char[] cArr = pem_array;
            if (i6 >= cArr.length) {
                return;
            }
            pem_convert_array[cArr[i6]] = (byte) i6;
            i6++;
        }
    }

    private int getByte() throws IOException {
        byte b6;
        do {
            if (this.input_pos >= this.input_len) {
                try {
                    int read = ((FilterInputStream) this).in.read(this.input_buffer);
                    this.input_len = read;
                    if (read <= 0) {
                        return -1;
                    }
                    this.input_pos = 0;
                } catch (EOFException unused) {
                    return -1;
                }
            }
            byte[] bArr = this.input_buffer;
            int i6 = this.input_pos;
            this.input_pos = i6 + 1;
            int i7 = bArr[i6] & 255;
            if (i7 == 61) {
                return -2;
            }
            b6 = pem_convert_array[i7];
        } while (b6 == -1);
        return b6;
    }

    private String recentChars() {
        String str;
        int i6 = this.input_pos;
        if (i6 > 10) {
            i6 = 10;
        }
        if (i6 <= 0) {
            return "";
        }
        String str2 = ", the " + i6 + " most recent characters were: \"";
        for (int i7 = this.input_pos - i6; i7 < this.input_pos; i7++) {
            char c6 = (char) (this.input_buffer[i7] & 255);
            if (c6 == '\t') {
                str = String.valueOf(str2) + "\\t";
            } else if (c6 == '\n') {
                str = String.valueOf(str2) + "\\n";
            } else if (c6 == '\r') {
                str = String.valueOf(str2) + "\\r";
            } else if (c6 < ' ' || c6 >= 127) {
                str = String.valueOf(str2) + "\\" + ((int) c6);
            } else {
                str = String.valueOf(str2) + c6;
            }
            str2 = str;
        }
        return String.valueOf(str2) + "\"";
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((((FilterInputStream) this).in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int i8;
        int i9;
        int i10 = i6;
        while (true) {
            i8 = this.index;
            i9 = this.bufsize;
            if (i8 >= i9 || i7 <= 0) {
                break;
            }
            byte[] bArr2 = this.buffer;
            this.index = i8 + 1;
            bArr[i10] = bArr2[i8];
            i7--;
            i10++;
        }
        if (i8 >= i9) {
            this.index = 0;
            this.bufsize = 0;
        }
        int i11 = (i7 / 3) * 3;
        if (i11 > 0) {
            int decode = decode(bArr, i10, i11);
            i10 += decode;
            i7 -= decode;
            if (decode != i11) {
                if (i10 == i6) {
                    return -1;
                }
                return i10 - i6;
            }
        }
        while (i7 > 0) {
            int read = read();
            if (read == -1) {
                break;
            }
            bArr[i10] = (byte) read;
            i7--;
            i10++;
        }
        if (i10 == i6) {
            return -1;
        }
        return i10 - i6;
    }

    public BASE64DecoderStream(InputStream inputStream, boolean z5) {
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = z5;
    }

    public static byte[] decode(byte[] bArr) {
        int i6;
        int length = (bArr.length / 4) * 3;
        if (length == 0) {
            return bArr;
        }
        if (bArr[bArr.length - 1] == 61) {
            length = bArr[bArr.length - 2] == 61 ? length - 2 : length - 1;
        }
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (length2 > 0) {
            byte[] bArr3 = pem_convert_array;
            int i9 = i7 + 2;
            int i10 = (bArr3[bArr[i7 + 1] & 255] | (bArr3[bArr[i7] & 255] << 6)) << 6;
            byte b6 = bArr[i9];
            if (b6 != 61) {
                i9 = i7 + 3;
                i10 |= bArr3[b6 & 255];
                i6 = 3;
            } else {
                i6 = 2;
            }
            int i11 = i10 << 6;
            byte b7 = bArr[i9];
            if (b7 != 61) {
                i9++;
                i11 |= bArr3[b7 & 255];
            } else {
                i6--;
            }
            if (i6 > 2) {
                bArr2[i8 + 2] = (byte) (i11 & 255);
            }
            int i12 = i11 >> 8;
            if (i6 > 1) {
                bArr2[i8 + 1] = (byte) (i12 & 255);
            }
            bArr2[i8] = (byte) ((i11 >> 16) & 255);
            i8 += i6;
            length2 -= 4;
            i7 = i9;
        }
        return bArr2;
    }
}

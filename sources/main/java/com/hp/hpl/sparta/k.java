package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class k implements o {

    /* renamed from: c, reason: collision with root package name */
    private l f32829c;

    private static boolean a(byte[] bArr, int i6) {
        return bArr[0] == ((byte) (i6 >>> 24)) && bArr[1] == ((byte) ((i6 >>> 16) & 255)) && bArr[2] == ((byte) ((i6 >>> 8) & 255)) && bArr[3] == ((byte) (i6 & 255));
    }

    private static boolean c(byte[] bArr, short s5) {
        return bArr[0] == ((byte) (s5 >>> 8)) && bArr[1] == ((byte) (s5 & 255));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r5, byte[] r6, int r7, com.hp.hpl.sparta.n r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.k.e(java.lang.String, byte[], int, com.hp.hpl.sparta.n):java.lang.String");
    }

    public k(String str, InputStream inputStream, n nVar, String str2, m mVar) throws ParseException, IOException {
        String str3;
        m mVar2;
        String str4;
        EncodingMismatchException encodingMismatchException;
        String declaredEncoding;
        m mVar3;
        m mVar4;
        n nVar2 = nVar == null ? o.f32854a : nVar;
        if (!inputStream.markSupported()) {
            throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
        }
        inputStream.mark(o.f32855b);
        byte[] bArr = new byte[4];
        String e6 = str2 == null ? e(str, bArr, inputStream.read(bArr), nVar2) : str2;
        try {
            inputStream.reset();
            try {
                str3 = str;
                mVar3 = mVar;
            } catch (EncodingMismatchException e7) {
                e = e7;
                str3 = str;
                mVar3 = mVar;
            } catch (IOException unused) {
                str3 = str;
                str4 = e6;
                mVar2 = mVar;
            }
            try {
                str4 = e6;
                try {
                    this.f32829c = new l(str3, new InputStreamReader(inputStream, d(e6)), nVar2, e6, mVar3);
                } catch (EncodingMismatchException e8) {
                    e = e8;
                    encodingMismatchException = e;
                    mVar2 = mVar3;
                    declaredEncoding = encodingMismatchException.getDeclaredEncoding();
                    nVar2.a("Encoding declaration of " + declaredEncoding + " is different that assumed " + str4 + " so restarting the parsing with the new encoding", str3, 1);
                    inputStream.reset();
                    try {
                        this.f32829c = new l(str3, new InputStreamReader(inputStream, d(declaredEncoding)), nVar2, (String) null, mVar2);
                    } catch (UnsupportedEncodingException unused2) {
                        throw new ParseException(nVar2, str3, 1, 0, declaredEncoding, "\"" + declaredEncoding + "\" is not a supported encoding");
                    }
                } catch (IOException unused3) {
                    mVar2 = mVar3;
                    try {
                        nVar2.a("Problem reading with assumed encoding of " + str4 + " so restarting with euc-jp", str3, 1);
                        inputStream.reset();
                        try {
                            mVar4 = mVar2;
                        } catch (UnsupportedEncodingException unused4) {
                            String str5 = str3;
                            try {
                                throw new ParseException(nVar2, str5, 1, 0, "euc-jp", "\"euc-jp\" is not a supported encoding");
                            } catch (EncodingMismatchException e9) {
                                e = e9;
                                nVar2 = nVar2;
                                str3 = str5;
                                encodingMismatchException = e;
                                declaredEncoding = encodingMismatchException.getDeclaredEncoding();
                                nVar2.a("Encoding declaration of " + declaredEncoding + " is different that assumed " + str4 + " so restarting the parsing with the new encoding", str3, 1);
                                inputStream.reset();
                                this.f32829c = new l(str3, new InputStreamReader(inputStream, d(declaredEncoding)), nVar2, (String) null, mVar2);
                            }
                        }
                    } catch (EncodingMismatchException e10) {
                        e = e10;
                    }
                    try {
                        this.f32829c = new l(str3, new InputStreamReader(inputStream, d("euc-jp")), nVar2, (String) null, mVar4);
                    } catch (EncodingMismatchException e11) {
                        e = e11;
                        mVar2 = mVar4;
                        encodingMismatchException = e;
                        declaredEncoding = encodingMismatchException.getDeclaredEncoding();
                        nVar2.a("Encoding declaration of " + declaredEncoding + " is different that assumed " + str4 + " so restarting the parsing with the new encoding", str3, 1);
                        inputStream.reset();
                        this.f32829c = new l(str3, new InputStreamReader(inputStream, d(declaredEncoding)), nVar2, (String) null, mVar2);
                    }
                }
            } catch (EncodingMismatchException e12) {
                e = e12;
                str4 = e6;
                encodingMismatchException = e;
                mVar2 = mVar3;
                declaredEncoding = encodingMismatchException.getDeclaredEncoding();
                nVar2.a("Encoding declaration of " + declaredEncoding + " is different that assumed " + str4 + " so restarting the parsing with the new encoding", str3, 1);
                inputStream.reset();
                this.f32829c = new l(str3, new InputStreamReader(inputStream, d(declaredEncoding)), nVar2, (String) null, mVar2);
            } catch (IOException unused5) {
                str4 = e6;
            }
        } catch (EncodingMismatchException e13) {
            e = e13;
            str3 = str;
            mVar2 = mVar;
            str4 = e6;
        }
    }

    @Override // com.hp.hpl.sparta.o
    public int getLineNumber() {
        return this.f32829c.getLineNumber();
    }

    @Override // com.hp.hpl.sparta.o
    public String getSystemId() {
        return this.f32829c.getSystemId();
    }

    @Override // com.hp.hpl.sparta.o
    public String toString() {
        return this.f32829c.toString();
    }

    private static String d(String str) {
        if (str.toLowerCase().equals("utf8")) {
            return "UTF-8";
        }
        return str;
    }

    private static String f(byte b6) {
        String hexString = Integer.toHexString(b6);
        int length = hexString.length();
        if (length != 1) {
            if (length != 2) {
                return hexString.substring(hexString.length() - 2);
            }
            return hexString;
        }
        return "0" + hexString;
    }
}

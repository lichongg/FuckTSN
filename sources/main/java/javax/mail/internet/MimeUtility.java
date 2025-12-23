package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.BEncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.QDecoderStream;
import com.sun.mail.util.QEncoderStream;
import com.sun.mail.util.QPDecoderStream;
import com.sun.mail.util.QPEncoderStream;
import com.sun.mail.util.UUDecoderStream;
import com.sun.mail.util.UUEncoderStream;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import org.apache.commons.net.ftp.b;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MimeUtility {
    public static final int ALL = -1;
    static final int ALL_ASCII = 1;
    static final int MOSTLY_ASCII = 2;
    static final int MOSTLY_NONASCII = 3;
    private static boolean decodeStrict = true;
    private static String defaultJavaCharset = null;
    private static String defaultMIMECharset = null;
    private static boolean encodeEolStrict = false;
    private static boolean foldEncodedWords = false;
    private static boolean foldText = true;
    private static Hashtable java2mime;
    private static Hashtable mime2java;

    static int checkAscii(String str) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (nonascii(str.charAt(i8))) {
                i6++;
            } else {
                i7++;
            }
        }
        if (i6 == 0) {
            return 1;
        }
        return i7 > i6 ? 2 : 3;
    }

    public static OutputStream encode(OutputStream outputStream, String str) throws MessagingException {
        if (str != null) {
            if (str.equalsIgnoreCase(HttpHeaders.Values.BASE64)) {
                return new BASE64EncoderStream(outputStream);
            }
            if (str.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE)) {
                return new QPEncoderStream(outputStream);
            }
            if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
                return new UUEncoderStream(outputStream);
            }
            if (!str.equalsIgnoreCase(HttpHeaders.Values.BINARY) && !str.equalsIgnoreCase("7bit") && !str.equalsIgnoreCase("8bit")) {
                throw new MessagingException("Unknown encoding: " + str);
            }
        }
        return outputStream;
    }

    public static String encodeText(String str) throws UnsupportedEncodingException {
        return encodeText(str, null, null);
    }

    public static String encodeWord(String str) throws UnsupportedEncodingException {
        return encodeWord(str, null, null);
    }

    public static String getEncoding(DataSource dataSource) {
        String str = HttpHeaders.Values.BASE64;
        try {
            ContentType contentType = new ContentType(dataSource.getContentType());
            InputStream inputStream = dataSource.getInputStream();
            int checkAscii = checkAscii(inputStream, -1, !contentType.match("text/*"));
            if (checkAscii == 1) {
                str = "7bit";
            } else if (checkAscii == 2) {
                str = HttpHeaders.Values.QUOTED_PRINTABLE;
            }
            inputStream.close();
        } catch (IOException | Exception unused) {
        }
        return str;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.sun.mail.util.LineInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    static {
        ?? r12;
        Throwable th;
        try {
            String property = System.getProperty("mail.mime.decodetext.strict");
            boolean z5 = true;
            decodeStrict = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.encodeeol.strict");
            encodeEolStrict = property2 != null && property2.equalsIgnoreCase("true");
            String property3 = System.getProperty("mail.mime.foldencodedwords");
            foldEncodedWords = property3 != null && property3.equalsIgnoreCase("true");
            String property4 = System.getProperty("mail.mime.foldtext");
            if (property4 != null && property4.equalsIgnoreCase("false")) {
                z5 = false;
            }
            foldText = z5;
        } catch (SecurityException unused) {
        }
        java2mime = new Hashtable(40);
        mime2java = new Hashtable(10);
        try {
            InputStream resourceAsStream = MimeUtility.class.getResourceAsStream("/META-INF/javamail.charset.map");
            if (resourceAsStream != null) {
                try {
                    r12 = new LineInputStream(resourceAsStream);
                } catch (Throwable th2) {
                    r12 = resourceAsStream;
                    th = th2;
                }
                try {
                    loadMappings(r12, java2mime);
                    loadMappings(r12, mime2java);
                    r12.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        r12.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused3) {
        }
        if (java2mime.isEmpty()) {
            java2mime.put("8859_1", b.T);
            java2mime.put("iso8859_1", b.T);
            java2mime.put("iso8859-1", b.T);
            java2mime.put("8859_2", "ISO-8859-2");
            java2mime.put("iso8859_2", "ISO-8859-2");
            java2mime.put("iso8859-2", "ISO-8859-2");
            java2mime.put("8859_3", "ISO-8859-3");
            java2mime.put("iso8859_3", "ISO-8859-3");
            java2mime.put("iso8859-3", "ISO-8859-3");
            java2mime.put("8859_4", "ISO-8859-4");
            java2mime.put("iso8859_4", "ISO-8859-4");
            java2mime.put("iso8859-4", "ISO-8859-4");
            java2mime.put("8859_5", "ISO-8859-5");
            java2mime.put("iso8859_5", "ISO-8859-5");
            java2mime.put("iso8859-5", "ISO-8859-5");
            java2mime.put("8859_6", "ISO-8859-6");
            java2mime.put("iso8859_6", "ISO-8859-6");
            java2mime.put("iso8859-6", "ISO-8859-6");
            java2mime.put("8859_7", "ISO-8859-7");
            java2mime.put("iso8859_7", "ISO-8859-7");
            java2mime.put("iso8859-7", "ISO-8859-7");
            java2mime.put("8859_8", "ISO-8859-8");
            java2mime.put("iso8859_8", "ISO-8859-8");
            java2mime.put("iso8859-8", "ISO-8859-8");
            java2mime.put("8859_9", "ISO-8859-9");
            java2mime.put("iso8859_9", "ISO-8859-9");
            java2mime.put("iso8859-9", "ISO-8859-9");
            java2mime.put("sjis", "Shift_JIS");
            java2mime.put("jis", "ISO-2022-JP");
            java2mime.put("iso2022jp", "ISO-2022-JP");
            java2mime.put("euc_jp", "euc-jp");
            java2mime.put("koi8_r", "koi8-r");
            java2mime.put("euc_cn", "euc-cn");
            java2mime.put("euc_tw", "euc-tw");
            java2mime.put("euc_kr", "euc-kr");
        }
        if (mime2java.isEmpty()) {
            mime2java.put("iso-2022-cn", "ISO2022CN");
            mime2java.put("iso-2022-kr", "ISO2022KR");
            mime2java.put("utf-8", "UTF8");
            mime2java.put("utf8", "UTF8");
            mime2java.put("ja_jp.iso2022-7", "ISO2022JP");
            mime2java.put("ja_jp.eucjp", "EUCJIS");
            mime2java.put("euc-kr", "KSC5601");
            mime2java.put("euckr", "KSC5601");
            mime2java.put("us-ascii", b.T);
            mime2java.put("x-us-ascii", b.T);
        }
    }

    public static InputStream decode(InputStream inputStream, String str) throws MessagingException {
        if (str.equalsIgnoreCase(HttpHeaders.Values.BASE64)) {
            return new BASE64DecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE)) {
            return new QPDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase(HttpHeaders.Values.BINARY) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return inputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String decodeInnerWords(java.lang.String r5) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
        L6:
            java.lang.String r2 = "=?"
            int r2 = r5.indexOf(r2, r1)
            if (r2 >= 0) goto Lf
            goto L34
        Lf:
            java.lang.String r3 = r5.substring(r1, r2)
            r0.append(r3)
            int r3 = r2 + 2
            r4 = 63
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L21
            goto L34
        L21:
            int r3 = r3 + 1
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L2a
            goto L34
        L2a:
            java.lang.String r4 = "?="
            int r3 = r3 + 1
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L49
        L34:
            if (r1 != 0) goto L37
            return r5
        L37:
            int r2 = r5.length()
            if (r1 >= r2) goto L44
            java.lang.String r5 = r5.substring(r1)
            r0.append(r5)
        L44:
            java.lang.String r5 = r0.toString()
            return r5
        L49:
            int r1 = r3 + 2
            java.lang.String r2 = r5.substring(r2, r1)
            java.lang.String r2 = decodeWord(r2)     // Catch: javax.mail.internet.ParseException -> L53
        L53:
            r0.append(r2)
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.decodeInnerWords(java.lang.String):java.lang.String");
    }

    public static String decodeText(String str) throws UnsupportedEncodingException {
        if (str.indexOf("=?") == -1) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\n\r", true);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        boolean z5 = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            char charAt = nextToken.charAt(0);
            if (charAt == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n') {
                stringBuffer2.append(charAt);
            } else {
                try {
                    String decodeWord = decodeWord(nextToken);
                    if (!z5 && stringBuffer2.length() > 0) {
                        stringBuffer.append(stringBuffer2);
                    }
                    nextToken = decodeWord;
                    z5 = true;
                } catch (ParseException unused) {
                    if (!decodeStrict) {
                        String decodeInnerWords = decodeInnerWords(nextToken);
                        if (decodeInnerWords != nextToken) {
                            if ((!z5 || !nextToken.startsWith("=?")) && stringBuffer2.length() > 0) {
                                stringBuffer.append(stringBuffer2);
                            }
                            z5 = nextToken.endsWith("?=");
                            nextToken = decodeInnerWords;
                        } else if (stringBuffer2.length() > 0) {
                            stringBuffer.append(stringBuffer2);
                        }
                    } else if (stringBuffer2.length() > 0) {
                        stringBuffer.append(stringBuffer2);
                    }
                    z5 = false;
                }
                stringBuffer.append(nextToken);
                stringBuffer2.setLength(0);
            }
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    public static String decodeWord(String str) throws ParseException, UnsupportedEncodingException {
        InputStream qDecoderStream;
        if (!str.startsWith("=?")) {
            throw new ParseException("encoded word does not start with \"=?\": " + str);
        }
        int indexOf = str.indexOf(63, 2);
        if (indexOf == -1) {
            throw new ParseException("encoded word does not include charset: " + str);
        }
        String javaCharset = javaCharset(str.substring(2, indexOf));
        int i6 = indexOf + 1;
        int indexOf2 = str.indexOf(63, i6);
        if (indexOf2 == -1) {
            throw new ParseException("encoded word does not include encoding: " + str);
        }
        String substring = str.substring(i6, indexOf2);
        int i7 = indexOf2 + 1;
        int indexOf3 = str.indexOf("?=", i7);
        if (indexOf3 == -1) {
            throw new ParseException("encoded word does not end with \"?=\": " + str);
        }
        String substring2 = str.substring(i7, indexOf3);
        try {
            String str2 = "";
            if (substring2.length() > 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ASCIIUtility.getBytes(substring2));
                if (substring.equalsIgnoreCase("B")) {
                    qDecoderStream = new BASE64DecoderStream(byteArrayInputStream);
                } else {
                    if (!substring.equalsIgnoreCase("Q")) {
                        throw new UnsupportedEncodingException("unknown encoding: " + substring);
                    }
                    qDecoderStream = new QDecoderStream(byteArrayInputStream);
                }
                int available = byteArrayInputStream.available();
                byte[] bArr = new byte[available];
                int read = qDecoderStream.read(bArr, 0, available);
                if (read > 0) {
                    str2 = new String(bArr, 0, read, javaCharset);
                }
            }
            int i8 = indexOf3 + 2;
            if (i8 >= str.length()) {
                return str2;
            }
            String substring3 = str.substring(i8);
            if (!decodeStrict) {
                substring3 = decodeInnerWords(substring3);
            }
            return str2 + substring3;
        } catch (UnsupportedEncodingException e6) {
            throw e6;
        } catch (IOException e7) {
            throw new ParseException(e7.toString());
        } catch (IllegalArgumentException unused) {
            throw new UnsupportedEncodingException(javaCharset);
        }
    }

    private static void doEncode(String str, boolean z5, String str2, int i6, String str3, boolean z6, boolean z7, StringBuffer stringBuffer) throws UnsupportedEncodingException {
        int length;
        byte[] bytes = str.getBytes(str2);
        if ((z5 ? BEncoderStream.encodedLength(bytes) : QEncoderStream.encodedLength(bytes, z7)) > i6 && (length = str.length()) > 1) {
            int i7 = length / 2;
            doEncode(str.substring(0, i7), z5, str2, i6, str3, z6, z7, stringBuffer);
            doEncode(str.substring(i7, length), z5, str2, i6, str3, false, z7, stringBuffer);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream bEncoderStream = z5 ? new BEncoderStream(byteArrayOutputStream) : new QEncoderStream(byteArrayOutputStream, z7);
        try {
            bEncoderStream.write(bytes);
            bEncoderStream.close();
        } catch (IOException unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!z6) {
            if (foldEncodedWords) {
                stringBuffer.append("\r\n ");
            } else {
                stringBuffer.append(" ");
            }
        }
        stringBuffer.append(str3);
        for (byte b6 : byteArray) {
            stringBuffer.append((char) b6);
        }
        stringBuffer.append("?=");
    }

    public static String encodeText(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, false);
    }

    public static String encodeWord(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, true);
    }

    public static String fold(int i6, String str) {
        char charAt;
        if (!foldText) {
            return str;
        }
        int length = str.length() - 1;
        while (length >= 0 && ((charAt = str.charAt(length)) == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n')) {
            length--;
        }
        if (length != str.length() - 1) {
            str = str.substring(0, length + 1);
        }
        if (str.length() + i6 <= 76) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 4);
        int i7 = i6;
        String str2 = str;
        char c6 = 0;
        while (true) {
            if (str2.length() + i7 <= 76) {
                break;
            }
            int i8 = 0;
            int i9 = -1;
            while (i8 < str2.length() && (i9 == -1 || i7 + i8 <= 76)) {
                char charAt2 = str2.charAt(i8);
                if ((charAt2 == ' ' || charAt2 == '\t') && c6 != ' ' && c6 != '\t') {
                    i9 = i8;
                }
                i8++;
                c6 = charAt2;
            }
            if (i9 == -1) {
                stringBuffer.append(str2);
                str2 = "";
                break;
            }
            stringBuffer.append(str2.substring(0, i9));
            stringBuffer.append(g.f50795q);
            c6 = str2.charAt(i9);
            stringBuffer.append(c6);
            str2 = str2.substring(i9 + 1);
            i7 = 1;
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static String getDefaultJavaCharset() {
        String str;
        if (defaultJavaCharset == null) {
            try {
                str = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
                str = null;
            }
            if (str != null && str.length() > 0) {
                String javaCharset = javaCharset(str);
                defaultJavaCharset = javaCharset;
                return javaCharset;
            }
            try {
                defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
            } catch (SecurityException unused2) {
                String encoding = new InputStreamReader(new InputStream() { // from class: javax.mail.internet.MimeUtility.1NullInputStream
                    @Override // java.io.InputStream
                    public int read() {
                        return 0;
                    }
                }).getEncoding();
                defaultJavaCharset = encoding;
                if (encoding == null) {
                    defaultJavaCharset = "8859_1";
                }
            }
        }
        return defaultJavaCharset;
    }

    static String getDefaultMIMECharset() {
        if (defaultMIMECharset == null) {
            try {
                defaultMIMECharset = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
        }
        if (defaultMIMECharset == null) {
            defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
        }
        return defaultMIMECharset;
    }

    private static int indexOfAny(String str, String str2, int i6) {
        try {
            int length = str.length();
            while (i6 < length) {
                if (str2.indexOf(str.charAt(i6)) >= 0) {
                    return i6;
                }
                i6++;
            }
            return -1;
        } catch (StringIndexOutOfBoundsException unused) {
            return -1;
        }
    }

    public static String javaCharset(String str) {
        Hashtable hashtable = mime2java;
        if (hashtable == null || str == null) {
            return str;
        }
        String str2 = (String) hashtable.get(str.toLowerCase(Locale.ENGLISH));
        return str2 == null ? str : str2;
    }

    public static String mimeCharset(String str) {
        Hashtable hashtable = java2mime;
        if (hashtable == null || str == null) {
            return str;
        }
        String str2 = (String) hashtable.get(str.toLowerCase(Locale.ENGLISH));
        return str2 == null ? str : str2;
    }

    static final boolean nonascii(int i6) {
        if (i6 < 127) {
            return (i6 >= 32 || i6 == 13 || i6 == 10 || i6 == 9) ? false : true;
        }
        return true;
    }

    public static String unfold(String str) {
        char charAt;
        char charAt2;
        if (!foldText) {
            return str;
        }
        StringBuffer stringBuffer = null;
        while (true) {
            int indexOfAny = indexOfAny(str, g.f50795q);
            if (indexOfAny < 0) {
                break;
            }
            int length = str.length();
            int i6 = indexOfAny + 1;
            if (i6 < length && str.charAt(indexOfAny) == '\r' && str.charAt(i6) == '\n') {
                i6 = indexOfAny + 2;
            }
            if (indexOfAny != 0) {
                int i7 = indexOfAny - 1;
                if (str.charAt(i7) == '\\') {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer(str.length());
                    }
                    stringBuffer.append(str.substring(0, i7));
                    stringBuffer.append(str.substring(indexOfAny, i6));
                    str = str.substring(i6);
                }
            }
            if (i6 >= length || !((charAt = str.charAt(i6)) == ' ' || charAt == '\t')) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length());
                }
                stringBuffer.append(str.substring(0, i6));
                str = str.substring(i6);
            } else {
                while (true) {
                    i6++;
                    if (i6 >= length || ((charAt2 = str.charAt(i6)) != ' ' && charAt2 != '\t')) {
                        break;
                    }
                }
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length());
                }
                if (indexOfAny != 0) {
                    stringBuffer.append(str.substring(0, indexOfAny));
                    stringBuffer.append(' ');
                }
                str = str.substring(i6);
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private MimeUtility() {
    }

    static int checkAscii(byte[] bArr) {
        int i6 = 0;
        int i7 = 0;
        for (byte b6 : bArr) {
            if (nonascii(b6 & 255)) {
                i6++;
            } else {
                i7++;
            }
        }
        if (i6 == 0) {
            return 1;
        }
        return i7 > i6 ? 2 : 3;
    }

    private static String encodeWord(String str, String str2, String str3, boolean z5) throws UnsupportedEncodingException {
        String javaCharset;
        boolean z6;
        int checkAscii = checkAscii(str);
        if (checkAscii == 1) {
            return str;
        }
        if (str2 == null) {
            javaCharset = getDefaultJavaCharset();
            str2 = getDefaultMIMECharset();
        } else {
            javaCharset = javaCharset(str2);
        }
        if (str3 == null) {
            str3 = checkAscii != 3 ? "Q" : "B";
        }
        if (str3.equalsIgnoreCase("B")) {
            z6 = true;
        } else {
            if (!str3.equalsIgnoreCase("Q")) {
                throw new UnsupportedEncodingException("Unknown transfer encoding: " + str3);
            }
            z6 = false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        doEncode(str, z6, javaCharset, 68 - str2.length(), "=?" + str2 + "?" + str3 + "?", true, z5, stringBuffer);
        return stringBuffer.toString();
    }

    private static void loadMappings(LineInputStream lineInputStream, Hashtable hashtable) {
        while (true) {
            try {
                String readLine = lineInputStream.readLine();
                if (readLine != null) {
                    if (!readLine.startsWith("--") || !readLine.endsWith("--")) {
                        if (readLine.trim().length() != 0 && !readLine.startsWith("#")) {
                            StringTokenizer stringTokenizer = new StringTokenizer(readLine, " \t");
                            try {
                                String nextToken = stringTokenizer.nextToken();
                                hashtable.put(nextToken.toLowerCase(Locale.ENGLISH), stringTokenizer.nextToken());
                            } catch (NoSuchElementException unused) {
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (IOException unused2) {
                return;
            }
        }
    }

    public static String quote(String str, String str2) {
        int length = str.length();
        char c6 = 0;
        int i6 = 0;
        boolean z5 = false;
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt != '\"' && charAt != '\\' && charAt != '\r' && charAt != '\n') {
                if (charAt < ' ' || charAt >= 127 || str2.indexOf(charAt) >= 0) {
                    z5 = true;
                }
                i6++;
            } else {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                stringBuffer.append(str.substring(0, i6));
                while (i6 < length) {
                    char charAt2 = str.charAt(i6);
                    if ((charAt2 == '\"' || charAt2 == '\\' || charAt2 == '\r' || charAt2 == '\n') && (charAt2 != '\n' || c6 != '\r')) {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt2);
                    i6++;
                    c6 = charAt2;
                }
                stringBuffer.append('\"');
                return stringBuffer.toString();
            }
        }
        if (z5) {
            StringBuffer stringBuffer2 = new StringBuffer(length + 2);
            stringBuffer2.append('\"');
            stringBuffer2.append(str);
            stringBuffer2.append('\"');
            return stringBuffer2.toString();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int checkAscii(java.io.InputStream r17, int r18, boolean r19) {
        /*
            r0 = r18
            boolean r1 = javax.mail.internet.MimeUtility.encodeEolStrict
            r3 = 0
            if (r1 == 0) goto Lb
            if (r19 == 0) goto Lb
            r1 = 1
            goto Lc
        Lb:
            r1 = 0
        Lc:
            r4 = -1
            r5 = 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L20
            if (r0 != r4) goto L14
            goto L18
        L14:
            int r5 = java.lang.Math.min(r0, r5)
        L18:
            byte[] r6 = new byte[r5]
        L1a:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            goto L22
        L20:
            r6 = 0
            goto L1a
        L22:
            if (r0 != 0) goto L25
            goto L2d
        L25:
            r13 = r17
            int r14 = r13.read(r6, r3, r5)     // Catch: java.io.IOException -> L78
            if (r14 != r4) goto L32
        L2d:
            r18 = 3
            r16 = 1
            goto L7d
        L32:
            r2 = 0
            r15 = 0
            r16 = 1
        L36:
            if (r15 < r14) goto L3c
            if (r0 == r4) goto L22
            int r0 = r0 - r14
            goto L22
        L3c:
            r3 = r6[r15]     // Catch: java.io.IOException -> L75
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 10
            r18 = 3
            r12 = 13
            if (r1 == 0) goto L51
            if (r2 != r12) goto L4c
            if (r3 != r4) goto L50
        L4c:
            if (r2 == r12) goto L51
            if (r3 != r4) goto L51
        L50:
            r9 = 1
        L51:
            if (r3 == r12) goto L5e
            if (r3 != r4) goto L56
            goto L5e
        L56:
            int r11 = r11 + 1
            r2 = 998(0x3e6, float:1.398E-42)
            if (r11 <= r2) goto L5f
            r10 = 1
            goto L5f
        L5e:
            r11 = 0
        L5f:
            boolean r2 = nonascii(r3)     // Catch: java.io.IOException -> L73
            if (r2 == 0) goto L6b
            if (r19 == 0) goto L68
            return r18
        L68:
            int r8 = r8 + 1
            goto L6d
        L6b:
            int r7 = r7 + 1
        L6d:
            int r15 = r15 + 1
            r2 = r3
            r3 = 0
            r4 = -1
            goto L36
        L73:
            goto L7d
        L75:
            r18 = 3
            goto L73
        L78:
            r18 = 3
            r16 = 1
            goto L73
        L7d:
            if (r0 != 0) goto L82
            if (r19 == 0) goto L82
            return r18
        L82:
            r0 = 2
            if (r8 != 0) goto L8c
            if (r9 == 0) goto L88
            return r18
        L88:
            if (r10 == 0) goto L8b
            return r0
        L8b:
            return r16
        L8c:
            if (r7 <= r8) goto L8f
            return r0
        L8f:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.checkAscii(java.io.InputStream, int, boolean):int");
    }

    public static String getEncoding(DataHandler dataHandler) {
        if (dataHandler.getName() != null) {
            return getEncoding(dataHandler.getDataSource());
        }
        try {
            if (new ContentType(dataHandler.getContentType()).match("text/*")) {
                AsciiOutputStream asciiOutputStream = new AsciiOutputStream(false, false);
                try {
                    dataHandler.writeTo(asciiOutputStream);
                } catch (IOException unused) {
                }
                int ascii = asciiOutputStream.getAscii();
                if (ascii != 1) {
                    if (ascii != 2) {
                        return HttpHeaders.Values.BASE64;
                    }
                    return HttpHeaders.Values.QUOTED_PRINTABLE;
                }
            } else {
                AsciiOutputStream asciiOutputStream2 = new AsciiOutputStream(true, encodeEolStrict);
                try {
                    dataHandler.writeTo(asciiOutputStream2);
                } catch (IOException unused2) {
                }
                if (asciiOutputStream2.getAscii() != 1) {
                    return HttpHeaders.Values.BASE64;
                }
            }
            return "7bit";
        } catch (Exception unused3) {
            return HttpHeaders.Values.BASE64;
        }
    }

    public static OutputStream encode(OutputStream outputStream, String str, String str2) throws MessagingException {
        if (str != null) {
            if (str.equalsIgnoreCase(HttpHeaders.Values.BASE64)) {
                return new BASE64EncoderStream(outputStream);
            }
            if (str.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE)) {
                return new QPEncoderStream(outputStream);
            }
            if (!str.equalsIgnoreCase("uuencode") && !str.equalsIgnoreCase("x-uuencode") && !str.equalsIgnoreCase("x-uue")) {
                if (!str.equalsIgnoreCase(HttpHeaders.Values.BINARY) && !str.equalsIgnoreCase("7bit") && !str.equalsIgnoreCase("8bit")) {
                    throw new MessagingException("Unknown encoding: " + str);
                }
            } else {
                return new UUEncoderStream(outputStream, str2);
            }
        }
        return outputStream;
    }
}

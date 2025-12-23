package javax.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.BitSet;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class URLName {
    static final int caseDiff = 32;
    private static boolean doEncode = true;
    static BitSet dontNeedEncoding;
    private String file;
    protected String fullURL;
    private int hashCode;
    private String host;
    private InetAddress hostAddress;
    private boolean hostAddressKnown;
    private String password;
    private int port;
    private String protocol;
    private String ref;
    private String username;

    public URLName(String str, String str2, int i6, String str3, String str4, String str5) {
        int indexOf;
        this.hostAddressKnown = false;
        this.hashCode = 0;
        this.protocol = str;
        this.host = str2;
        this.port = i6;
        if (str3 == null || (indexOf = str3.indexOf(35)) == -1) {
            this.file = str3;
            this.ref = null;
        } else {
            this.file = str3.substring(0, indexOf);
            this.ref = str3.substring(indexOf + 1);
        }
        this.username = doEncode ? encode(str4) : str4;
        this.password = doEncode ? encode(str5) : str5;
    }

    private synchronized InetAddress getHostAddress() {
        if (this.hostAddressKnown) {
            return this.hostAddress;
        }
        String str = this.host;
        if (str == null) {
            return null;
        }
        try {
            this.hostAddress = InetAddress.getByName(str);
        } catch (UnknownHostException unused) {
            this.hostAddress = null;
        }
        this.hostAddressKnown = true;
        return this.hostAddress;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    protected void parseString(String str) {
        int indexOf;
        String substring;
        this.password = null;
        this.username = null;
        this.host = null;
        this.ref = null;
        this.file = null;
        this.protocol = null;
        this.port = -1;
        int length = str.length();
        int indexOf2 = str.indexOf(58);
        if (indexOf2 != -1) {
            this.protocol = str.substring(0, indexOf2);
        }
        int i6 = indexOf2 + 1;
        if (str.regionMatches(i6, "//", 0, 2)) {
            int i7 = indexOf2 + 3;
            int indexOf3 = str.indexOf(47, i7);
            if (indexOf3 != -1) {
                substring = str.substring(i7, indexOf3);
                int i8 = indexOf3 + 1;
                if (i8 < length) {
                    this.file = str.substring(i8);
                } else {
                    this.file = "";
                }
            } else {
                substring = str.substring(i7);
            }
            int indexOf4 = substring.indexOf(64);
            if (indexOf4 != -1) {
                String substring2 = substring.substring(0, indexOf4);
                substring = substring.substring(indexOf4 + 1);
                int indexOf5 = substring2.indexOf(58);
                if (indexOf5 != -1) {
                    this.username = substring2.substring(0, indexOf5);
                    this.password = substring2.substring(indexOf5 + 1);
                } else {
                    this.username = substring2;
                }
            }
            int indexOf6 = (substring.length() <= 0 || substring.charAt(0) != '[') ? substring.indexOf(58) : substring.indexOf(58, substring.indexOf(93));
            if (indexOf6 != -1) {
                String substring3 = substring.substring(indexOf6 + 1);
                if (substring3.length() > 0) {
                    try {
                        this.port = Integer.parseInt(substring3);
                    } catch (NumberFormatException unused) {
                        this.port = -1;
                    }
                }
                this.host = substring.substring(0, indexOf6);
            } else {
                this.host = substring;
            }
        } else if (i6 < length) {
            this.file = str.substring(i6);
        }
        String str2 = this.file;
        if (str2 == null || (indexOf = str2.indexOf(35)) == -1) {
            return;
        }
        this.ref = this.file.substring(indexOf + 1);
        this.file = this.file.substring(0, indexOf);
    }

    static {
        try {
            doEncode = !Boolean.getBoolean("mail.URLName.dontencode");
        } catch (Exception unused) {
        }
        dontNeedEncoding = new BitSet(256);
        for (int i6 = 97; i6 <= 122; i6++) {
            dontNeedEncoding.set(i6);
        }
        for (int i7 = 65; i7 <= 90; i7++) {
            dontNeedEncoding.set(i7);
        }
        for (int i8 = 48; i8 <= 57; i8++) {
            dontNeedEncoding.set(i8);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
    }

    private static String _encode(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (dontNeedEncoding.get(charAt)) {
                if (charAt == ' ') {
                    charAt = '+';
                }
                stringBuffer.append(charAt);
            } else {
                try {
                    outputStreamWriter.write(charAt);
                    outputStreamWriter.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    for (int i7 = 0; i7 < byteArray.length; i7++) {
                        stringBuffer.append('%');
                        char forDigit = Character.forDigit((byteArray[i7] >> 4) & 15, 16);
                        if (Character.isLetter(forDigit)) {
                            forDigit = (char) (forDigit - ' ');
                        }
                        stringBuffer.append(forDigit);
                        char forDigit2 = Character.forDigit(byteArray[i7] & 15, 16);
                        if (Character.isLetter(forDigit2)) {
                            forDigit2 = (char) (forDigit2 - ' ');
                        }
                        stringBuffer.append(forDigit2);
                    }
                    byteArrayOutputStream.reset();
                } catch (IOException unused) {
                    byteArrayOutputStream.reset();
                }
            }
        }
        return stringBuffer.toString();
    }

    static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (indexOfAny(str, "+%") == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i6 = 0;
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt == '%') {
                try {
                    stringBuffer.append((char) Integer.parseInt(str.substring(i6 + 1, i6 + 3), 16));
                    i6 += 2;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException();
                }
            } else if (charAt != '+') {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append(' ');
            }
            i6++;
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            return new String(stringBuffer2.getBytes("8859_1"));
        } catch (UnsupportedEncodingException unused2) {
            return stringBuffer2;
        }
    }

    static String encode(String str) {
        if (str == null) {
            return null;
        }
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt == ' ' || !dontNeedEncoding.get(charAt)) {
                return _encode(str);
            }
        }
        return str;
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

    public boolean equals(Object obj) {
        URLName uRLName;
        String str;
        String str2;
        if (!(obj instanceof URLName) || (str = (uRLName = (URLName) obj).protocol) == null || !str.equals(this.protocol)) {
            return false;
        }
        InetAddress hostAddress = getHostAddress();
        InetAddress hostAddress2 = uRLName.getHostAddress();
        if (hostAddress == null || hostAddress2 == null) {
            String str3 = this.host;
            if (str3 == null || (str2 = uRLName.host) == null) {
                if (str3 != uRLName.host) {
                    return false;
                }
            } else if (!str3.equalsIgnoreCase(str2)) {
                return false;
            }
        } else if (!hostAddress.equals(hostAddress2)) {
            return false;
        }
        String str4 = this.username;
        String str5 = uRLName.username;
        if (str4 != str5 && (str4 == null || !str4.equals(str5))) {
            return false;
        }
        String str6 = this.file;
        if (str6 == null) {
            str6 = "";
        }
        String str7 = uRLName.file;
        return str6.equals(str7 != null ? str7 : "") && this.port == uRLName.port;
    }

    public String getFile() {
        return this.file;
    }

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return doEncode ? decode(this.password) : this.password;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRef() {
        return this.ref;
    }

    public URL getURL() throws MalformedURLException {
        return new URL(getProtocol(), getHost(), getPort(), getFile());
    }

    public String getUsername() {
        return doEncode ? decode(this.username) : this.username;
    }

    public int hashCode() {
        int i6 = this.hashCode;
        if (i6 != 0) {
            return i6;
        }
        String str = this.protocol;
        if (str != null) {
            this.hashCode = i6 + str.hashCode();
        }
        InetAddress hostAddress = getHostAddress();
        if (hostAddress != null) {
            this.hashCode += hostAddress.hashCode();
        } else {
            String str2 = this.host;
            if (str2 != null) {
                this.hashCode += str2.toLowerCase(Locale.ENGLISH).hashCode();
            }
        }
        String str3 = this.username;
        if (str3 != null) {
            this.hashCode += str3.hashCode();
        }
        String str4 = this.file;
        if (str4 != null) {
            this.hashCode += str4.hashCode();
        }
        int i7 = this.hashCode + this.port;
        this.hashCode = i7;
        return i7;
    }

    public String toString() {
        if (this.fullURL == null) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = this.protocol;
            if (str != null) {
                stringBuffer.append(str);
                stringBuffer.append(":");
            }
            if (this.username != null || this.host != null) {
                stringBuffer.append("//");
                String str2 = this.username;
                if (str2 != null) {
                    stringBuffer.append(str2);
                    if (this.password != null) {
                        stringBuffer.append(":");
                        stringBuffer.append(this.password);
                    }
                    stringBuffer.append("@");
                }
                String str3 = this.host;
                if (str3 != null) {
                    stringBuffer.append(str3);
                }
                if (this.port != -1) {
                    stringBuffer.append(":");
                    stringBuffer.append(Integer.toString(this.port));
                }
                if (this.file != null) {
                    stringBuffer.append("/");
                }
            }
            String str4 = this.file;
            if (str4 != null) {
                stringBuffer.append(str4);
            }
            if (this.ref != null) {
                stringBuffer.append("#");
                stringBuffer.append(this.ref);
            }
            this.fullURL = stringBuffer.toString();
        }
        return this.fullURL;
    }

    public URLName(URL url) {
        this(url.toString());
    }

    public URLName(String str) {
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        parseString(str);
    }
}

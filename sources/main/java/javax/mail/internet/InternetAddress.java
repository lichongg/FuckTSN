package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.mail.Address;
import javax.mail.Session;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class InternetAddress extends Address implements Cloneable {
    private static final String rfc822phrase = HeaderTokenizer.RFC822.replace(' ', (char) 0).replace('\t', (char) 0);
    private static final long serialVersionUID = -7507595530758302903L;
    private static final String specialsNoDot = "()<>,;:\\\"[]@";
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    protected String address;
    protected String encodedPersonal;
    protected String personal;

    public InternetAddress() {
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    public static InternetAddress[] parse(String str) throws AddressException {
        return parse(str, true);
    }

    public static InternetAddress[] parseHeader(String str, boolean z5) throws AddressException {
        return parse(str, z5, true);
    }

    public void setPersonal(String str, String str2) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str, str2, null);
        } else {
            this.encodedPersonal = null;
        }
    }

    @Override // javax.mail.Address
    public String toString() {
        String str;
        if (this.encodedPersonal == null && (str = this.personal) != null) {
            try {
                this.encodedPersonal = MimeUtility.encodeWord(str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        String str2 = this.encodedPersonal;
        if (str2 != null) {
            return String.valueOf(quotePhrase(str2)) + " <" + this.address + ">";
        }
        if (isGroup() || isSimple()) {
            return this.address;
        }
        return "<" + this.address + ">";
    }

    public InternetAddress(String str) throws AddressException {
        InternetAddress[] parse = parse(str, true);
        if (parse.length != 1) {
            throw new AddressException("Illegal address", str);
        }
        InternetAddress internetAddress = parse[0];
        this.address = internetAddress.address;
        this.personal = internetAddress.personal;
        this.encodedPersonal = internetAddress.encodedPersonal;
    }

    private static void checkAddress(String str, boolean z5, boolean z6) throws AddressException {
        String str2;
        String str3;
        if (str.indexOf(34) >= 0) {
            return;
        }
        int i6 = 0;
        if (z5) {
            while (true) {
                int indexOfAny = indexOfAny(str, ",:", i6);
                if (indexOfAny < 0) {
                    break;
                }
                if (str.charAt(i6) != '@') {
                    throw new AddressException("Illegal route-addr", str);
                }
                if (str.charAt(indexOfAny) == ':') {
                    i6 = indexOfAny + 1;
                    break;
                }
                i6 = indexOfAny + 1;
            }
        }
        int indexOf = str.indexOf(64, i6);
        if (indexOf >= 0) {
            if (indexOf == i6) {
                throw new AddressException("Missing local name", str);
            }
            if (indexOf == str.length() - 1) {
                throw new AddressException("Missing domain", str);
            }
            str3 = str.substring(i6, indexOf);
            str2 = str.substring(indexOf + 1);
        } else {
            if (z6) {
                throw new AddressException("Missing final '@domain'", str);
            }
            str2 = null;
            str3 = str;
        }
        if (indexOfAny(str, " \t\n\r") >= 0) {
            throw new AddressException("Illegal whitespace in address", str);
        }
        if (indexOfAny(str3, specialsNoDot) >= 0) {
            throw new AddressException("Illegal character in local name", str);
        }
        if (str2 != null && str2.indexOf(91) < 0 && indexOfAny(str2, specialsNoDot) >= 0) {
            throw new AddressException("Illegal character in domain", str);
        }
    }

    public static InternetAddress getLocalAddress(Session session) {
        String property;
        String str;
        String str2;
        String property2;
        String property3;
        InetAddress localHost;
        try {
            if (session == null) {
                str = System.getProperty("user.name");
                str2 = InetAddress.getLocalHost().getHostName();
                property = null;
            } else {
                property = session.getProperty("mail.from");
                if (property == null) {
                    String property4 = session.getProperty("mail.user");
                    if (property4 == null || property4.length() == 0) {
                        property4 = session.getProperty("user.name");
                    }
                    if (property4 != null && property4.length() != 0) {
                        property2 = property4;
                        property3 = session.getProperty("mail.host");
                        if ((property3 != null || property3.length() == 0) && (localHost = InetAddress.getLocalHost()) != null) {
                            property3 = localHost.getHostName();
                        }
                        String str3 = property2;
                        str2 = property3;
                        str = str3;
                    }
                    property2 = System.getProperty("user.name");
                    property3 = session.getProperty("mail.host");
                    if (property3 != null) {
                    }
                    property3 = localHost.getHostName();
                    String str32 = property2;
                    str2 = property3;
                    str = str32;
                } else {
                    str = null;
                    str2 = null;
                }
            }
            if (property == null && str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                property = str + "@" + str2;
            }
            if (property != null) {
                return new InternetAddress(property);
            }
        } catch (SecurityException | UnknownHostException | AddressException unused) {
        }
        return null;
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

    private boolean isSimple() {
        String str = this.address;
        return str == null || indexOfAny(str, specialsNoDotNoAt) < 0;
    }

    private static int lengthOfFirstSegment(String str) {
        int indexOf = str.indexOf(g.f50795q);
        return indexOf != -1 ? indexOf : str.length();
    }

    private static int lengthOfLastSegment(String str, int i6) {
        return str.lastIndexOf(g.f50795q) != -1 ? (str.length() - r0) - 2 : str.length() + i6;
    }

    public static InternetAddress[] parse(String str, boolean z5) throws AddressException {
        return parse(str, z5, false);
    }

    private static String unquote(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            if (str.indexOf(92) >= 0) {
                StringBuffer stringBuffer = new StringBuffer(str.length());
                int i6 = 0;
                while (i6 < str.length()) {
                    char charAt = str.charAt(i6);
                    if (charAt == '\\' && i6 < str.length() - 1) {
                        i6++;
                        charAt = str.charAt(i6);
                    }
                    stringBuffer.append(charAt);
                    i6++;
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    @Override // javax.mail.Address
    public boolean equals(Object obj) {
        if (!(obj instanceof InternetAddress)) {
            return false;
        }
        String address = ((InternetAddress) obj).getAddress();
        String str = this.address;
        if (address == str) {
            return true;
        }
        return str != null && str.equalsIgnoreCase(address);
    }

    public String getAddress() {
        return this.address;
    }

    public String getPersonal() {
        String str = this.personal;
        if (str != null) {
            return str;
        }
        String str2 = this.encodedPersonal;
        if (str2 == null) {
            return null;
        }
        try {
            String decodeText = MimeUtility.decodeText(str2);
            this.personal = decodeText;
            return decodeText;
        } catch (Exception unused) {
            return this.encodedPersonal;
        }
    }

    @Override // javax.mail.Address
    public String getType() {
        return "rfc822";
    }

    public int hashCode() {
        String str = this.address;
        if (str == null) {
            return 0;
        }
        return str.toLowerCase(Locale.ENGLISH).hashCode();
    }

    public boolean isGroup() {
        String str = this.address;
        return str != null && str.endsWith(";") && this.address.indexOf(58) > 0;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x018e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static javax.mail.internet.InternetAddress[] parse(java.lang.String r17, boolean r18, boolean r19) throws javax.mail.internet.AddressException {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.InternetAddress.parse(java.lang.String, boolean, boolean):javax.mail.internet.InternetAddress[]");
    }

    private static String quotePhrase(String str) {
        int length = str.length();
        boolean z5 = false;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt != '\"' && charAt != '\\') {
                if ((charAt < ' ' && charAt != '\r' && charAt != '\n' && charAt != '\t') || charAt >= 127 || rfc822phrase.indexOf(charAt) >= 0) {
                    z5 = true;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                for (int i7 = 0; i7 < length; i7++) {
                    char charAt2 = str.charAt(i7);
                    if (charAt2 == '\"' || charAt2 == '\\') {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt2);
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

    public Object clone() {
        try {
            return (InternetAddress) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public InternetAddress[] getGroup(boolean z5) throws AddressException {
        int indexOf;
        String address = getAddress();
        if (!address.endsWith(";") || (indexOf = address.indexOf(58)) < 0) {
            return null;
        }
        return parseHeader(address.substring(indexOf + 1, address.length() - 1), z5);
    }

    public String toUnicodeString() {
        String personal = getPersonal();
        if (personal != null) {
            return String.valueOf(quotePhrase(personal)) + " <" + this.address + ">";
        }
        if (!isGroup() && !isSimple()) {
            return "<" + this.address + ">";
        }
        return this.address;
    }

    public void validate() throws AddressException {
        checkAddress(getAddress(), true, true);
    }

    public void setPersonal(String str) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str);
        } else {
            this.encodedPersonal = null;
        }
    }

    public static String toString(Address[] addressArr) {
        return toString(addressArr, 0);
    }

    public InternetAddress(String str, boolean z5) throws AddressException {
        this(str);
        if (z5) {
            checkAddress(this.address, true, true);
        }
    }

    public static String toString(Address[] addressArr, int i6) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i7 = 0; i7 < addressArr.length; i7++) {
            if (i7 != 0) {
                stringBuffer.append(", ");
                i6 += 2;
            }
            String address = addressArr[i7].toString();
            if (lengthOfFirstSegment(address) + i6 > 76) {
                stringBuffer.append("\r\n\t");
                i6 = 8;
            }
            stringBuffer.append(address);
            i6 = lengthOfLastSegment(address, i6);
        }
        return stringBuffer.toString();
    }

    public InternetAddress(String str, String str2) throws UnsupportedEncodingException {
        this(str, str2, null);
    }

    public InternetAddress(String str, String str2, String str3) throws UnsupportedEncodingException {
        this.address = str;
        setPersonal(str2, str3);
    }
}

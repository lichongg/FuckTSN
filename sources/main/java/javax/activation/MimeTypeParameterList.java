package javax.activation;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MimeTypeParameterList {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private Hashtable parameters = new Hashtable();

    public MimeTypeParameterList() {
    }

    private static boolean isTokenChar(char c6) {
        return c6 > ' ' && c6 < 127 && TSPECIALS.indexOf(c6) < 0;
    }

    public String get(String str) {
        return (String) this.parameters.get(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public Enumeration getNames() {
        return this.parameters.keys();
    }

    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    protected void parse(String str) throws MimeTypeParseException {
        int length;
        int i6;
        String substring;
        if (str != null && (length = str.length()) > 0) {
            int skipWhiteSpace = skipWhiteSpace(str, 0);
            while (skipWhiteSpace < length && str.charAt(skipWhiteSpace) == ';') {
                int skipWhiteSpace2 = skipWhiteSpace(str, skipWhiteSpace + 1);
                if (skipWhiteSpace2 >= length) {
                    return;
                }
                int i7 = skipWhiteSpace2;
                while (i7 < length && isTokenChar(str.charAt(i7))) {
                    i7++;
                }
                String lowerCase = str.substring(skipWhiteSpace2, i7).toLowerCase(Locale.ENGLISH);
                int skipWhiteSpace3 = skipWhiteSpace(str, i7);
                if (skipWhiteSpace3 >= length || str.charAt(skipWhiteSpace3) != '=') {
                    throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
                }
                int skipWhiteSpace4 = skipWhiteSpace(str, skipWhiteSpace3 + 1);
                if (skipWhiteSpace4 >= length) {
                    throw new MimeTypeParseException("Couldn't find a value for parameter named " + lowerCase);
                }
                char charAt = str.charAt(skipWhiteSpace4);
                if (charAt == '\"') {
                    int i8 = skipWhiteSpace4 + 1;
                    if (i8 >= length) {
                        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                    }
                    int i9 = i8;
                    while (i9 < length) {
                        charAt = str.charAt(i9);
                        if (charAt == '\"') {
                            break;
                        }
                        if (charAt == '\\') {
                            i9++;
                        }
                        i9++;
                    }
                    if (charAt != '\"') {
                        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                    }
                    substring = unquote(str.substring(i8, i9));
                    i6 = i9 + 1;
                } else {
                    if (!isTokenChar(charAt)) {
                        throw new MimeTypeParseException("Unexpected character encountered at index " + skipWhiteSpace4);
                    }
                    i6 = skipWhiteSpace4;
                    while (i6 < length && isTokenChar(str.charAt(i6))) {
                        i6++;
                    }
                    substring = str.substring(skipWhiteSpace4, i6);
                }
                this.parameters.put(lowerCase, substring);
                skipWhiteSpace = skipWhiteSpace(str, i6);
            }
            if (skipWhiteSpace < length) {
                throw new MimeTypeParseException("More characters encountered in input than expected.");
            }
        }
    }

    public void remove(String str) {
        this.parameters.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        this.parameters.put(str.trim().toLowerCase(Locale.ENGLISH), str2);
    }

    public int size() {
        return this.parameters.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(this.parameters.size() * 16);
        Enumeration keys = this.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            stringBuffer.append("; ");
            stringBuffer.append(str);
            stringBuffer.append('=');
            stringBuffer.append(quote((String) this.parameters.get(str)));
        }
        return stringBuffer.toString();
    }

    public MimeTypeParameterList(String str) throws MimeTypeParseException {
        parse(str);
    }

    private static String quote(String str) {
        int length = str.length();
        boolean z5 = false;
        for (int i6 = 0; i6 < length && !z5; i6++) {
            z5 = !isTokenChar(str.charAt(i6));
        }
        if (z5) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.ensureCapacity((int) (length * 1.5d));
            stringBuffer.append('\"');
            for (int i7 = 0; i7 < length; i7++) {
                char charAt = str.charAt(i7);
                if (charAt == '\\' || charAt == '\"') {
                    stringBuffer.append('\\');
                }
                stringBuffer.append(charAt);
            }
            stringBuffer.append('\"');
            return stringBuffer.toString();
        }
        return str;
    }

    private static int skipWhiteSpace(String str, int i6) {
        int length = str.length();
        while (i6 < length && Character.isWhitespace(str.charAt(i6))) {
            i6++;
        }
        return i6;
    }

    private static String unquote(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        boolean z5 = false;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (!z5 && charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (z5) {
                stringBuffer.append(charAt);
                z5 = false;
            } else {
                z5 = true;
            }
        }
        return stringBuffer.toString();
    }
}

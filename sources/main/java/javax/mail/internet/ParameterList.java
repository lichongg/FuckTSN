package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class ParameterList {
    private static boolean applehack;
    private static boolean decodeParameters;
    private static boolean decodeParametersStrict;
    private static boolean encodeParameters;
    private static final char[] hex;
    private String lastName;
    private Map list;
    private Set multisegmentNames;
    private Map slist;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MultiValue extends ArrayList {
        String value;

        private MultiValue() {
        }

        /* synthetic */ MultiValue(MultiValue multiValue) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ParamEnum implements Enumeration {
        private Iterator it;

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.it.hasNext();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.it.next();
        }

        ParamEnum(Iterator it) {
            this.it = it;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ToStringBuffer {
        private StringBuffer sb = new StringBuffer();
        private int used;

        public String toString() {
            return this.sb.toString();
        }

        public ToStringBuffer(int i6) {
            this.used = i6;
        }

        public void addNV(String str, String str2) {
            String quote = ParameterList.quote(str2);
            this.sb.append("; ");
            this.used += 2;
            if (this.used + str.length() + quote.length() + 1 > 76) {
                this.sb.append("\r\n\t");
                this.used = 8;
            }
            StringBuffer stringBuffer = this.sb;
            stringBuffer.append(str);
            stringBuffer.append('=');
            int length = this.used + str.length() + 1;
            this.used = length;
            if (length + quote.length() > 76) {
                String fold = MimeUtility.fold(this.used, quote);
                this.sb.append(fold);
                if (fold.lastIndexOf(10) >= 0) {
                    this.used += (fold.length() - r5) - 1;
                    return;
                } else {
                    this.used += fold.length();
                    return;
                }
            }
            this.sb.append(quote);
            this.used += quote.length();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Value {
        String charset;
        String encodedValue;
        String value;

        private Value() {
        }

        /* synthetic */ Value(Value value) {
            this();
        }
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    public void set(String str, String str2) {
        if (str == null && str2 != null && str2.equals("DONE")) {
            if (!decodeParameters || this.multisegmentNames.size() <= 0) {
                return;
            }
            try {
                combineMultisegmentNames(true);
                return;
            } catch (ParseException unused) {
                return;
            }
        }
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        if (!decodeParameters) {
            this.list.put(lowerCase, str2);
            return;
        }
        try {
            putEncodedName(lowerCase, str2);
        } catch (ParseException unused2) {
            this.list.put(lowerCase, str2);
        }
    }

    public String toString() {
        return toString(0);
    }

    static {
        try {
            String property = System.getProperty("mail.mime.encodeparameters");
            boolean z5 = false;
            encodeParameters = property != null && property.equalsIgnoreCase("true");
            String property2 = System.getProperty("mail.mime.decodeparameters");
            decodeParameters = property2 != null && property2.equalsIgnoreCase("true");
            String property3 = System.getProperty("mail.mime.decodeparameters.strict");
            decodeParametersStrict = property3 != null && property3.equalsIgnoreCase("true");
            String property4 = System.getProperty("mail.mime.applefilenames");
            if (property4 != null && property4.equalsIgnoreCase("true")) {
                z5 = true;
            }
            applehack = z5;
        } catch (SecurityException unused) {
        }
        hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void combineMultisegmentNames(boolean r13) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.combineMultisegmentNames(boolean):void");
    }

    private static Value decodeValue(String str) throws ParseException {
        Value value = new Value(null);
        value.encodedValue = str;
        value.value = str;
        try {
            int indexOf = str.indexOf(39);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i6 = indexOf + 1;
                int indexOf2 = str.indexOf(39, i6);
                if (indexOf2 >= 0) {
                    str.substring(i6, indexOf2);
                    String substring2 = str.substring(indexOf2 + 1);
                    value.charset = substring;
                    value.value = decodeBytes(substring2, substring);
                    return value;
                }
                if (decodeParametersStrict) {
                    throw new ParseException("Missing language in encoded value: " + str);
                }
            } else if (decodeParametersStrict) {
                throw new ParseException("Missing charset in encoded value: " + str);
            }
        } catch (UnsupportedEncodingException e6) {
            if (decodeParametersStrict) {
                throw new ParseException(e6.toString());
            }
        } catch (NumberFormatException e7) {
            if (decodeParametersStrict) {
                throw new ParseException(e7.toString());
            }
        } catch (StringIndexOutOfBoundsException e8) {
            if (decodeParametersStrict) {
                throw new ParseException(e8.toString());
            }
        }
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void putEncodedName(String str, String str2) throws ParseException {
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            this.list.put(str, str2);
            return;
        }
        if (indexOf == str.length() - 1) {
            this.list.put(str.substring(0, indexOf), decodeValue(str2));
            return;
        }
        String substring = str.substring(0, indexOf);
        this.multisegmentNames.add(substring);
        this.list.put(substring, "");
        if (str.endsWith("*")) {
            Value value = new Value(null);
            value.encodedValue = str2;
            value.value = str2;
            str = str.substring(0, str.length() - 1);
            str2 = value;
        }
        this.slist.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String quote(String str) {
        return MimeUtility.quote(str, HeaderTokenizer.MIME);
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        return obj instanceof MultiValue ? ((MultiValue) obj).value : obj instanceof Value ? ((Value) obj).value : (String) obj;
    }

    public Enumeration getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public int size() {
        return this.list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString(int i6) {
        ToStringBuffer toStringBuffer = new ToStringBuffer(i6);
        for (String str : this.list.keySet()) {
            Object obj = this.list.get(str);
            if (obj instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) obj;
                String str2 = String.valueOf(str) + "*";
                for (int i7 = 0; i7 < multiValue.size(); i7++) {
                    E e6 = multiValue.get(i7);
                    if (e6 instanceof Value) {
                        toStringBuffer.addNV(String.valueOf(str2) + i7 + "*", ((Value) e6).encodedValue);
                    } else {
                        toStringBuffer.addNV(String.valueOf(str2) + i7, (String) e6);
                    }
                }
            } else if (obj instanceof Value) {
                toStringBuffer.addNV(String.valueOf(str) + "*", ((Value) obj).encodedValue);
            } else {
                toStringBuffer.addNV(str, (String) obj);
            }
        }
        return toStringBuffer.toString();
    }

    private static String decodeBytes(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        int i6 = 0;
        int i7 = 0;
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt == '%') {
                charAt = (char) Integer.parseInt(str.substring(i6 + 1, i6 + 3), 16);
                i6 += 2;
            }
            bArr[i7] = (byte) charAt;
            i6++;
            i7++;
        }
        return new String(bArr, 0, i7, MimeUtility.javaCharset(str2));
    }

    private static Value encodeValue(String str, String str2) {
        Value value = null;
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer(bytes.length + str2.length() + 2);
            stringBuffer.append(str2);
            stringBuffer.append("''");
            for (byte b6 : bytes) {
                char c6 = (char) (b6 & 255);
                if (c6 > ' ' && c6 < 127 && c6 != '*' && c6 != '\'' && c6 != '%' && HeaderTokenizer.MIME.indexOf(c6) < 0) {
                    stringBuffer.append(c6);
                } else {
                    stringBuffer.append('%');
                    char[] cArr = hex;
                    stringBuffer.append(cArr[c6 >> 4]);
                    stringBuffer.append(cArr[c6 & 15]);
                }
            }
            Value value2 = new Value(value);
            value2.charset = str2;
            value2.value = str;
            value2.encodedValue = stringBuffer.toString();
            return value2;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0124, code lost:
    
        throw new javax.mail.internet.ParseException("Expected ';', got \"" + r8.getValue() + "\"");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002a, code lost:
    
        if (javax.mail.internet.ParameterList.decodeParameters == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002c, code lost:
    
        combineMultisegmentNames(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0030, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ParameterList(java.lang.String r8) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<init>(java.lang.String):void");
    }

    public void set(String str, String str2, String str3) {
        if (encodeParameters) {
            Value encodeValue = encodeValue(str2, str3);
            if (encodeValue != null) {
                this.list.put(str.trim().toLowerCase(Locale.ENGLISH), encodeValue);
                return;
            } else {
                set(str, str2);
                return;
            }
        }
        set(str, str2);
    }
}

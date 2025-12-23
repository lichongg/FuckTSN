package myjava.awt.datatransfer;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class MimeTypeProcessor {
    private static MimeTypeProcessor instance;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MimeType implements Cloneable, Serializable {
        private static final long serialVersionUID = -6693571907475992044L;
        private Hashtable<String, String> parameters;
        private String primaryType;
        private String subType;
        private Hashtable<String, Object> systemParameters;

        MimeType() {
            this.primaryType = null;
            this.subType = null;
            this.parameters = null;
            this.systemParameters = null;
        }

        void addParameter(String str, String str2) {
            if (str2 == null) {
                return;
            }
            if (str2.charAt(0) == '\"' && str2.charAt(str2.length() - 1) == '\"') {
                str2 = str2.substring(1, str2.length() - 2);
            }
            if (str2.length() == 0) {
                return;
            }
            this.parameters.put(str, str2);
        }

        void addSystemParameter(String str, Object obj) {
            this.systemParameters.put(str, obj);
        }

        public Object clone() {
            MimeType mimeType = new MimeType(this.primaryType, this.subType);
            mimeType.parameters = (Hashtable) this.parameters.clone();
            mimeType.systemParameters = (Hashtable) this.systemParameters.clone();
            return mimeType;
        }

        boolean equals(MimeType mimeType) {
            if (mimeType == null) {
                return false;
            }
            return getFullType().equals(mimeType.getFullType());
        }

        String getFullType() {
            return String.valueOf(this.primaryType) + "/" + this.subType;
        }

        String getParameter(String str) {
            return this.parameters.get(str);
        }

        String getPrimaryType() {
            return this.primaryType;
        }

        String getSubType() {
            return this.subType;
        }

        Object getSystemParameter(String str) {
            return this.systemParameters.get(str);
        }

        void removeParameter(String str) {
            this.parameters.remove(str);
        }

        MimeType(String str, String str2) {
            this.primaryType = str;
            this.subType = str2;
            this.parameters = new Hashtable<>();
            this.systemParameters = new Hashtable<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class StringPosition {

        /* renamed from: i, reason: collision with root package name */
        int f50396i;

        private StringPosition() {
            this.f50396i = 0;
        }

        /* synthetic */ StringPosition(StringPosition stringPosition) {
            this();
        }
    }

    static String assemble(MimeType mimeType) {
        StringBuilder sb = new StringBuilder();
        sb.append(mimeType.getFullType());
        Enumeration keys = mimeType.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            String str2 = (String) mimeType.parameters.get(str);
            sb.append("; ");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append('\"');
        }
        return sb.toString();
    }

    private static boolean isMeaningfulChar(char c6) {
        return c6 >= '!' && c6 <= '~';
    }

    private static boolean isTSpecialChar(char c6) {
        return c6 == '(' || c6 == ')' || c6 == '[' || c6 == ']' || c6 == '<' || c6 == '>' || c6 == '@' || c6 == ',' || c6 == ';' || c6 == ':' || c6 == '\\' || c6 == '\"' || c6 == '/' || c6 == '?' || c6 == '=';
    }

    static MimeType parse(String str) {
        if (instance == null) {
            instance = new MimeTypeProcessor();
        }
        MimeType mimeType = new MimeType();
        if (str != null) {
            StringPosition stringPosition = new StringPosition(null);
            retrieveType(str, mimeType, stringPosition);
            retrieveParams(str, mimeType, stringPosition);
        }
        return mimeType;
    }

    private static void retrieveParams(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.parameters = new Hashtable();
        mimeType.systemParameters = new Hashtable();
        while (true) {
            int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f50396i);
            stringPosition.f50396i = nextMeaningfulIndex;
            if (nextMeaningfulIndex >= str.length()) {
                return;
            }
            if (str.charAt(stringPosition.f50396i) != ';') {
                throw new IllegalArgumentException();
            }
            stringPosition.f50396i++;
            retrieveParam(str, mimeType, stringPosition);
        }
    }

    private static String retrieveQuoted(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        stringPosition.f50396i++;
        boolean z5 = true;
        do {
            if (str.charAt(stringPosition.f50396i) == '\"' && z5) {
                stringPosition.f50396i++;
                return sb.toString();
            }
            int i6 = stringPosition.f50396i;
            stringPosition.f50396i = i6 + 1;
            char charAt = str.charAt(i6);
            if (!z5) {
                z5 = true;
            } else if (charAt == '\\') {
                z5 = false;
            }
            if (z5) {
                sb.append(charAt);
            }
        } while (stringPosition.f50396i != str.length());
        throw new IllegalArgumentException();
    }

    private static String retrieveToken(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f50396i);
        stringPosition.f50396i = nextMeaningfulIndex;
        if (nextMeaningfulIndex >= str.length() || isTSpecialChar(str.charAt(stringPosition.f50396i))) {
            throw new IllegalArgumentException();
        }
        do {
            int i6 = stringPosition.f50396i;
            stringPosition.f50396i = i6 + 1;
            sb.append(str.charAt(i6));
            if (stringPosition.f50396i >= str.length() || !isMeaningfulChar(str.charAt(stringPosition.f50396i))) {
                break;
            }
        } while (!isTSpecialChar(str.charAt(stringPosition.f50396i)));
        return sb.toString();
    }

    private MimeTypeProcessor() {
    }

    private static int getNextMeaningfulIndex(String str, int i6) {
        while (i6 < str.length() && !isMeaningfulChar(str.charAt(i6))) {
            i6++;
        }
        return i6;
    }

    private static void retrieveParam(String str, MimeType mimeType, StringPosition stringPosition) {
        String retrieveToken;
        String lowerCase = retrieveToken(str, stringPosition).toLowerCase();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f50396i);
        stringPosition.f50396i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && str.charAt(stringPosition.f50396i) == '=') {
            int i6 = stringPosition.f50396i + 1;
            stringPosition.f50396i = i6;
            int nextMeaningfulIndex2 = getNextMeaningfulIndex(str, i6);
            stringPosition.f50396i = nextMeaningfulIndex2;
            if (nextMeaningfulIndex2 < str.length()) {
                if (str.charAt(stringPosition.f50396i) == '\"') {
                    retrieveToken = retrieveQuoted(str, stringPosition);
                } else {
                    retrieveToken = retrieveToken(str, stringPosition);
                }
                mimeType.parameters.put(lowerCase, retrieveToken);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static void retrieveType(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.primaryType = retrieveToken(str, stringPosition).toLowerCase();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f50396i);
        stringPosition.f50396i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && str.charAt(stringPosition.f50396i) == '/') {
            stringPosition.f50396i++;
            mimeType.subType = retrieveToken(str, stringPosition).toLowerCase();
            return;
        }
        throw new IllegalArgumentException();
    }
}

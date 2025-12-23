package javax.mail.internet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class HeaderTokenizer {
    private static final Token EOFToken = new Token(-4, null);
    public static final String MIME = "()<>@,;:\\\"\t []/?=";
    public static final String RFC822 = "()<>@,;:\\\"\t .[]";
    private int currentPos;
    private String delimiters;
    private int maxPos;
    private int nextPos;
    private int peekPos;
    private boolean skipComments;
    private String string;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Token {
        public static final int ATOM = -1;
        public static final int COMMENT = -3;
        public static final int EOF = -4;
        public static final int QUOTEDSTRING = -2;
        private int type;
        private String value;

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        public Token(int i6, String str) {
            this.type = i6;
            this.value = str;
        }
    }

    public HeaderTokenizer(String str, String str2, boolean z5) {
        str = str == null ? "" : str;
        this.string = str;
        this.skipComments = z5;
        this.delimiters = str2;
        this.peekPos = 0;
        this.nextPos = 0;
        this.currentPos = 0;
        this.maxPos = str.length();
    }

    private static String filterToken(String str, int i6, int i7) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z5 = false;
        boolean z6 = false;
        while (i6 < i7) {
            char charAt = str.charAt(i6);
            if (charAt != '\n' || !z5) {
                if (z6) {
                    stringBuffer.append(charAt);
                    z5 = false;
                    z6 = false;
                } else if (charAt == '\\') {
                    z5 = false;
                    z6 = true;
                } else if (charAt == '\r') {
                    z5 = true;
                } else {
                    stringBuffer.append(charAt);
                }
                i6++;
            }
            z5 = false;
            i6++;
        }
        return stringBuffer.toString();
    }

    private Token getNext() throws ParseException {
        char charAt;
        if (this.currentPos >= this.maxPos) {
            return EOFToken;
        }
        if (skipWhiteSpace() == -4) {
            return EOFToken;
        }
        char charAt2 = this.string.charAt(this.currentPos);
        boolean z5 = false;
        while (charAt2 == '(') {
            int i6 = this.currentPos + 1;
            this.currentPos = i6;
            int i7 = 1;
            while (i7 > 0) {
                int i8 = this.currentPos;
                if (i8 >= this.maxPos) {
                    break;
                }
                char charAt3 = this.string.charAt(i8);
                if (charAt3 == '\\') {
                    this.currentPos++;
                } else if (charAt3 != '\r') {
                    if (charAt3 == '(') {
                        i7++;
                    } else if (charAt3 == ')') {
                        i7--;
                    }
                    this.currentPos++;
                }
                z5 = true;
                this.currentPos++;
            }
            if (i7 != 0) {
                throw new ParseException("Unbalanced comments");
            }
            if (!this.skipComments) {
                return new Token(-3, z5 ? filterToken(this.string, i6, this.currentPos - 1) : this.string.substring(i6, this.currentPos - 1));
            }
            if (skipWhiteSpace() == -4) {
                return EOFToken;
            }
            charAt2 = this.string.charAt(this.currentPos);
        }
        if (charAt2 != '\"') {
            if (charAt2 < ' ' || charAt2 >= 127 || this.delimiters.indexOf(charAt2) >= 0) {
                this.currentPos++;
                return new Token(charAt2, new String(new char[]{charAt2}));
            }
            int i9 = this.currentPos;
            while (true) {
                int i10 = this.currentPos;
                if (i10 < this.maxPos && (charAt = this.string.charAt(i10)) >= ' ' && charAt < 127 && charAt != '(' && charAt != ' ' && charAt != '\"' && this.delimiters.indexOf(charAt) < 0) {
                    this.currentPos++;
                }
            }
            return new Token(-1, this.string.substring(i9, this.currentPos));
        }
        int i11 = this.currentPos + 1;
        this.currentPos = i11;
        while (true) {
            int i12 = this.currentPos;
            if (i12 >= this.maxPos) {
                throw new ParseException("Unbalanced quoted string");
            }
            char charAt4 = this.string.charAt(i12);
            if (charAt4 == '\\') {
                this.currentPos++;
            } else if (charAt4 != '\r') {
                if (charAt4 == '\"') {
                    int i13 = this.currentPos;
                    this.currentPos = i13 + 1;
                    return new Token(-2, z5 ? filterToken(this.string, i11, i13) : this.string.substring(i11, i13));
                }
                this.currentPos++;
            }
            z5 = true;
            this.currentPos++;
        }
    }

    private int skipWhiteSpace() {
        while (true) {
            int i6 = this.currentPos;
            if (i6 >= this.maxPos) {
                return -4;
            }
            char charAt = this.string.charAt(i6);
            if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                return this.currentPos;
            }
            this.currentPos++;
        }
    }

    public String getRemainder() {
        return this.string.substring(this.nextPos);
    }

    public Token next() throws ParseException {
        this.currentPos = this.nextPos;
        Token next = getNext();
        int i6 = this.currentPos;
        this.peekPos = i6;
        this.nextPos = i6;
        return next;
    }

    public Token peek() throws ParseException {
        this.currentPos = this.peekPos;
        Token next = getNext();
        this.peekPos = this.currentPos;
        return next;
    }

    public HeaderTokenizer(String str, String str2) {
        this(str, str2, true);
    }

    public HeaderTokenizer(String str) {
        this(str, RFC822);
    }
}

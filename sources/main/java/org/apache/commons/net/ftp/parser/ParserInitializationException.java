package org.apache.commons.net.ftp.parser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ParserInitializationException extends RuntimeException {
    private static final long serialVersionUID = 5563335279583210658L;

    public ParserInitializationException(String str) {
        super(str);
    }

    public ParserInitializationException(String str, Throwable th) {
        super(str, th);
    }

    @Deprecated
    public Throwable getRootCause() {
        return super.getCause();
    }
}

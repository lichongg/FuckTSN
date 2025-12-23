package org.apache.commons.net.imap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum IMAPCommand {
    CAPABILITY(0),
    NOOP(0),
    LOGOUT(0),
    STARTTLS(0),
    AUTHENTICATE(1),
    LOGIN(2),
    XOAUTH(1),
    SELECT(1),
    EXAMINE(1),
    CREATE(1),
    DELETE(1),
    RENAME(2),
    SUBSCRIBE(1),
    UNSUBSCRIBE(1),
    LIST(2),
    LSUB(2),
    STATUS(2),
    APPEND(2, 4),
    CHECK(0),
    CLOSE(0),
    EXPUNGE(0),
    SEARCH(1, Integer.MAX_VALUE),
    FETCH(2),
    STORE(3),
    COPY(2),
    UID(2, Integer.MAX_VALUE);

    private final String imapCommand;
    private final int maxParamCount;
    private final int minParamCount;

    IMAPCommand() {
        this((String) null);
    }

    IMAPCommand(String str) {
        this(str, 0);
    }

    public String getIMAPCommand() {
        String str = this.imapCommand;
        return str != null ? str : name();
    }

    IMAPCommand(int i6) {
        this(null, i6, i6);
    }

    public static final String getCommand(IMAPCommand iMAPCommand) {
        return iMAPCommand.getIMAPCommand();
    }

    IMAPCommand(int i6, int i7) {
        this(null, i6, i7);
    }

    IMAPCommand(String str, int i6) {
        this(str, i6, i6);
    }

    IMAPCommand(String str, int i6, int i7) {
        this.imapCommand = str;
        this.minParamCount = i6;
        this.maxParamCount = i7;
    }
}

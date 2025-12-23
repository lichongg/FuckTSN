package org.apache.commons.net.imap;

import java.io.IOException;
import org.apache.commons.net.imap.IMAP;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IMAPClient extends IMAP {
    private static final char E = '\"';
    private static final String F = "\"";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum FETCH_ITEM_NAMES {
        ALL,
        FAST,
        FULL,
        BODY,
        BODYSTRUCTURE,
        ENVELOPE,
        FLAGS,
        INTERNALDATE,
        RFC822,
        UID
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SEARCH_CRITERIA {
        ALL,
        ANSWERED,
        BCC,
        BEFORE,
        BODY,
        CC,
        DELETED,
        DRAFT,
        FLAGGED,
        FROM,
        HEADER,
        KEYWORD,
        LARGER,
        NEW,
        NOT,
        OLD,
        ON,
        OR,
        RECENT,
        SEEN,
        SENTBEFORE,
        SENTON,
        SENTSINCE,
        SINCE,
        SMALLER,
        SUBJECT,
        TEXT,
        TO,
        UID,
        UNANSWERED,
        UNDELETED,
        UNDRAFT,
        UNFLAGGED,
        UNKEYWORD,
        UNSEEN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum STATUS_DATA_ITEMS {
        MESSAGES,
        RECENT,
        UIDNEXT,
        UIDVALIDITY,
        UNSEEN
    }

    public boolean G0(String str) throws IOException {
        return H0(null, str);
    }

    @Deprecated
    public boolean p0(String str) throws IOException {
        return q0(str, null, null);
    }

    public boolean A0(String str, String str2) throws IOException {
        return c0(IMAPCommand.LIST, str + " " + str2);
    }

    public boolean C0() throws IOException {
        return b0(IMAPCommand.LOGOUT);
    }

    public boolean D0(String str, String str2) throws IOException {
        return c0(IMAPCommand.LSUB, str + " " + str2);
    }

    public boolean E0() throws IOException {
        return b0(IMAPCommand.NOOP);
    }

    public boolean F0(String str, String str2) throws IOException {
        return c0(IMAPCommand.RENAME, str + " " + str2);
    }

    public boolean H0(String str, String str2) throws IOException {
        String str3 = "";
        if (str != null) {
            str3 = "CHARSET " + str;
        }
        return c0(IMAPCommand.SEARCH, str3 + str2);
    }

    public boolean I0(String str) throws IOException {
        return c0(IMAPCommand.SELECT, str);
    }

    public boolean J0(String str, String[] strArr) throws IOException {
        if (strArr == null || strArr.length < 1) {
            throw new IllegalArgumentException("STATUS command requires at least one data item name");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (i6 > 0) {
                sb.append(" ");
            }
            sb.append(strArr[i6]);
        }
        sb.append(")");
        return c0(IMAPCommand.STATUS, sb.toString());
    }

    public boolean K0(String str, String str2, String str3) throws IOException {
        return c0(IMAPCommand.STORE, str + " " + str2 + " " + str3);
    }

    public boolean L0(String str) throws IOException {
        return c0(IMAPCommand.SUBSCRIBE, str);
    }

    public boolean M0(String str, String str2) throws IOException {
        return c0(IMAPCommand.UID, str + " " + str2);
    }

    public boolean N0(String str) throws IOException {
        return c0(IMAPCommand.UNSUBSCRIBE, str);
    }

    public boolean delete(String str) throws IOException {
        return c0(IMAPCommand.DELETE, str);
    }

    @Deprecated
    public boolean q0(String str, String str2, String str3) throws IOException {
        if (str2 != null) {
            str = str + " " + str2;
        }
        if (str3 != null) {
            if (str3.charAt(0) == '{') {
                str = str + " " + str3;
            } else {
                str = str + " {" + str3 + "}";
            }
        }
        return c0(IMAPCommand.APPEND, str);
    }

    public boolean r0(String str, String str2, String str3, String str4) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            sb.append(" ");
            sb.append(str2);
        }
        if (str3 != null) {
            sb.append(" ");
            if (str3.charAt(0) == '\"') {
                sb.append(str3);
            } else {
                sb.append('\"');
                sb.append(str3);
                sb.append('\"');
            }
        }
        sb.append(" ");
        if (str4.startsWith(F) && str4.endsWith(F)) {
            sb.append(str4);
            return c0(IMAPCommand.APPEND, sb.toString());
        }
        sb.append('{');
        sb.append(str4.length());
        sb.append('}');
        return a.d(k0(IMAPCommand.APPEND, sb.toString())) && a.f(m0(str4));
    }

    public boolean s0() throws IOException {
        return b0(IMAPCommand.CAPABILITY);
    }

    public boolean t0() throws IOException {
        return b0(IMAPCommand.CHECK);
    }

    public boolean u0() throws IOException {
        return b0(IMAPCommand.CLOSE);
    }

    public boolean v0(String str, String str2) throws IOException {
        return c0(IMAPCommand.COPY, str + " " + str2);
    }

    public boolean w0(String str) throws IOException {
        return c0(IMAPCommand.CREATE, str);
    }

    public boolean x0(String str) throws IOException {
        return c0(IMAPCommand.EXAMINE, str);
    }

    public boolean y0() throws IOException {
        return b0(IMAPCommand.EXPUNGE);
    }

    public boolean z0(String str, String str2) throws IOException {
        return c0(IMAPCommand.FETCH, str + " " + str2);
    }

    public boolean B0(String str, String str2) throws IOException {
        if (g0() != IMAP.IMAPState.NOT_AUTH_STATE) {
            return false;
        }
        if (!c0(IMAPCommand.LOGIN, str + " " + str2)) {
            return false;
        }
        o0(IMAP.IMAPState.AUTH_STATE);
        return true;
    }
}

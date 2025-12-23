package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import javax.mail.Flags;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FLAGS extends Flags implements l {
    static final char[] name = {'F', 'L', 'A', 'G', 'S'};
    private static final long serialVersionUID = 439049847053756670L;
    public int msgno;

    public FLAGS(i iVar) throws ParsingException {
        this.msgno = iVar.E();
        iVar.B();
        String[] H = iVar.H();
        if (H != null) {
            for (String str : H) {
                if (str.length() >= 2 && str.charAt(0) == '\\') {
                    char upperCase = Character.toUpperCase(str.charAt(1));
                    if (upperCase != '*') {
                        if (upperCase != 'A') {
                            if (upperCase != 'D') {
                                if (upperCase != 'F') {
                                    if (upperCase != 'R') {
                                        if (upperCase != 'S') {
                                            add(str);
                                        } else {
                                            add(Flags.Flag.SEEN);
                                        }
                                    } else {
                                        add(Flags.Flag.RECENT);
                                    }
                                } else {
                                    add(Flags.Flag.FLAGGED);
                                }
                            } else if (str.length() >= 3) {
                                char charAt = str.charAt(2);
                                if (charAt != 'e' && charAt != 'E') {
                                    if (charAt == 'r' || charAt == 'R') {
                                        add(Flags.Flag.DRAFT);
                                    }
                                } else {
                                    add(Flags.Flag.DELETED);
                                }
                            } else {
                                add(str);
                            }
                        } else {
                            add(Flags.Flag.ANSWERED);
                        }
                    } else {
                        add(Flags.Flag.USER);
                    }
                } else {
                    add(str);
                }
            }
        }
    }
}

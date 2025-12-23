package javax.mail.search;

import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MessageIDTerm extends StringTerm {
    private static final long serialVersionUID = -2121096296454691963L;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            String[] header = message.getHeader("Message-ID");
            if (header == null) {
                return false;
            }
            for (String str : header) {
                if (super.match(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof MessageIDTerm) {
            return super.equals(obj);
        }
        return false;
    }

    public MessageIDTerm(String str) {
        super(str);
    }
}

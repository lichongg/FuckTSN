package javax.mail.search;

import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SubjectTerm extends StringTerm {
    private static final long serialVersionUID = 7481568618055573432L;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            String subject = message.getSubject();
            if (subject == null) {
                return false;
            }
            return super.match(subject);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof SubjectTerm) {
            return super.equals(obj);
        }
        return false;
    }

    public SubjectTerm(String str) {
        super(str);
    }
}

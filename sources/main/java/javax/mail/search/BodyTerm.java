package javax.mail.search;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BodyTerm extends StringTerm {
    private static final long serialVersionUID = -4888862527916911385L;

    private boolean matchPart(Part part) {
        if (part.isMimeType("text/*")) {
            String str = (String) part.getContent();
            if (str == null) {
                return false;
            }
            return super.match(str);
        }
        if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int count = multipart.getCount();
            for (int i6 = 0; i6 < count; i6++) {
                if (matchPart(multipart.getBodyPart(i6))) {
                    return true;
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            return matchPart((Part) part.getContent());
        }
        return false;
    }

    @Override // javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof BodyTerm) {
            return super.equals(obj);
        }
        return false;
    }

    public BodyTerm(String str) {
        super(str);
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        return matchPart(message);
    }
}

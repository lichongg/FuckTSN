package javax.mail.search;

import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MessageNumberTerm extends IntegerComparisonTerm {
    private static final long serialVersionUID = -5379625829658623812L;

    public MessageNumberTerm(int i6) {
        super(3, i6);
    }

    @Override // javax.mail.search.IntegerComparisonTerm, javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        if (obj instanceof MessageNumberTerm) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            return super.match(message.getMessageNumber());
        } catch (Exception unused) {
            return false;
        }
    }
}

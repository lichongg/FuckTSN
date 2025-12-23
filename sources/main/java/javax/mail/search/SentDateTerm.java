package javax.mail.search;

import java.util.Date;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SentDateTerm extends DateTerm {
    private static final long serialVersionUID = 5647755030530907263L;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Date sentDate = message.getSentDate();
            if (sentDate == null) {
                return false;
            }
            return super.match(sentDate);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.DateTerm, javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        if (obj instanceof SentDateTerm) {
            return super.equals(obj);
        }
        return false;
    }

    public SentDateTerm(int i6, Date date) {
        super(i6, date);
    }
}

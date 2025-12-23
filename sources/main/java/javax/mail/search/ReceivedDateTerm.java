package javax.mail.search;

import java.util.Date;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ReceivedDateTerm extends DateTerm {
    private static final long serialVersionUID = -2756695246195503170L;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Date receivedDate = message.getReceivedDate();
            if (receivedDate == null) {
                return false;
            }
            return super.match(receivedDate);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.DateTerm, javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        if (obj instanceof ReceivedDateTerm) {
            return super.equals(obj);
        }
        return false;
    }

    public ReceivedDateTerm(int i6, Date date) {
        super(i6, date);
    }
}

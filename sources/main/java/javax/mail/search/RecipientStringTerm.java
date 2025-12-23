package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RecipientStringTerm extends AddressStringTerm {
    private static final long serialVersionUID = -8293562089611618849L;
    private Message.RecipientType type;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Address[] recipients = message.getRecipients(this.type);
            if (recipients == null) {
                return false;
            }
            for (Address address : recipients) {
                if (super.match(address)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.AddressStringTerm, javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        return (obj instanceof RecipientStringTerm) && ((RecipientStringTerm) obj).type.equals(this.type) && super.equals(obj);
    }

    public Message.RecipientType getRecipientType() {
        return this.type;
    }

    @Override // javax.mail.search.StringTerm
    public int hashCode() {
        return this.type.hashCode() + super.hashCode();
    }

    public RecipientStringTerm(Message.RecipientType recipientType, String str) {
        super(str);
        this.type = recipientType;
    }
}

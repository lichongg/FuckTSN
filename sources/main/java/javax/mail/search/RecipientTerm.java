package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RecipientTerm extends AddressTerm {
    private static final long serialVersionUID = 6548700653122680468L;
    protected Message.RecipientType type;

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

    @Override // javax.mail.search.AddressTerm
    public boolean equals(Object obj) {
        return (obj instanceof RecipientTerm) && ((RecipientTerm) obj).type.equals(this.type) && super.equals(obj);
    }

    public Message.RecipientType getRecipientType() {
        return this.type;
    }

    @Override // javax.mail.search.AddressTerm
    public int hashCode() {
        return this.type.hashCode() + super.hashCode();
    }

    public RecipientTerm(Message.RecipientType recipientType, Address address) {
        super(address);
        this.type = recipientType;
    }
}

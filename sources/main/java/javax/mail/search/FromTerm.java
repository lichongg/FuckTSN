package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FromTerm extends AddressTerm {
    private static final long serialVersionUID = 5214730291502658665L;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Address[] from = message.getFrom();
            if (from == null) {
                return false;
            }
            for (Address address : from) {
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
        if (obj instanceof FromTerm) {
            return super.equals(obj);
        }
        return false;
    }

    public FromTerm(Address address) {
        super(address);
    }
}

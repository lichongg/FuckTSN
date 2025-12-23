package javax.mail.search;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class AddressStringTerm extends StringTerm {
    private static final long serialVersionUID = 3086821234204980368L;

    protected AddressStringTerm(String str) {
        super(str, true);
    }

    @Override // javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof AddressStringTerm) {
            return super.equals(obj);
        }
        return false;
    }

    protected boolean match(Address address) {
        return address instanceof InternetAddress ? super.match(((InternetAddress) address).toUnicodeString()) : super.match(address.toString());
    }
}

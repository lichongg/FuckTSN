package javax.mail.search;

import javax.mail.Address;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class AddressTerm extends SearchTerm {
    private static final long serialVersionUID = 2005405551929769980L;
    protected Address address;

    public boolean equals(Object obj) {
        if (obj instanceof AddressTerm) {
            return ((AddressTerm) obj).address.equals(this.address);
        }
        return false;
    }

    public Address getAddress() {
        return this.address;
    }

    public int hashCode() {
        return this.address.hashCode();
    }

    protected boolean match(Address address) {
        return address.equals(this.address);
    }

    protected AddressTerm(Address address) {
        this.address = address;
    }
}

package javax.mail.search;

import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class NotTerm extends SearchTerm {
    private static final long serialVersionUID = 7152293214217310216L;
    protected SearchTerm term;

    public boolean equals(Object obj) {
        if (obj instanceof NotTerm) {
            return ((NotTerm) obj).term.equals(this.term);
        }
        return false;
    }

    public SearchTerm getTerm() {
        return this.term;
    }

    public int hashCode() {
        return this.term.hashCode() << 1;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        return !this.term.match(message);
    }

    public NotTerm(SearchTerm searchTerm) {
        this.term = searchTerm;
    }
}

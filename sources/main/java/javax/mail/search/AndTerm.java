package javax.mail.search;

import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AndTerm extends SearchTerm {
    private static final long serialVersionUID = -3583274505380989582L;
    protected SearchTerm[] terms;

    public AndTerm(SearchTerm searchTerm, SearchTerm searchTerm2) {
        this.terms = new SearchTerm[]{searchTerm, searchTerm2};
    }

    public int hashCode() {
        int i6 = 0;
        int i7 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i6 >= searchTermArr.length) {
                return i7;
            }
            i7 += searchTermArr[i6].hashCode();
            i6++;
        }
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        int i6 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i6 >= searchTermArr.length) {
                return true;
            }
            if (!searchTermArr[i6].match(message)) {
                return false;
            }
            i6++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AndTerm)) {
            return false;
        }
        AndTerm andTerm = (AndTerm) obj;
        if (andTerm.terms.length != this.terms.length) {
            return false;
        }
        int i6 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i6 >= searchTermArr.length) {
                return true;
            }
            if (!searchTermArr[i6].equals(andTerm.terms[i6])) {
                return false;
            }
            i6++;
        }
    }

    public SearchTerm[] getTerms() {
        return (SearchTerm[]) this.terms.clone();
    }

    public AndTerm(SearchTerm[] searchTermArr) {
        this.terms = new SearchTerm[searchTermArr.length];
        for (int i6 = 0; i6 < searchTermArr.length; i6++) {
            this.terms[i6] = searchTermArr[i6];
        }
    }
}

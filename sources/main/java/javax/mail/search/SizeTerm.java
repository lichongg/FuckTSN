package javax.mail.search;

import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SizeTerm extends IntegerComparisonTerm {
    private static final long serialVersionUID = -2556219451005103709L;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            int size = message.getSize();
            if (size == -1) {
                return false;
            }
            return super.match(size);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // javax.mail.search.IntegerComparisonTerm, javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        if (obj instanceof SizeTerm) {
            return super.equals(obj);
        }
        return false;
    }

    public SizeTerm(int i6, int i7) {
        super(i6, i7);
    }
}

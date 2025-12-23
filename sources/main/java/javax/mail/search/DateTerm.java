package javax.mail.search;

import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class DateTerm extends ComparisonTerm {
    private static final long serialVersionUID = 4818873430063720043L;
    protected Date date;

    @Override // javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        return (obj instanceof DateTerm) && ((DateTerm) obj).date.equals(this.date) && super.equals(obj);
    }

    public int getComparison() {
        return this.comparison;
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    @Override // javax.mail.search.ComparisonTerm
    public int hashCode() {
        return this.date.hashCode() + super.hashCode();
    }

    protected boolean match(Date date) {
        switch (this.comparison) {
            case 1:
                if (date.before(this.date) || date.equals(this.date)) {
                }
                break;
            case 6:
                if (date.after(this.date) || date.equals(this.date)) {
                }
                break;
        }
        return false;
    }

    protected DateTerm(int i6, Date date) {
        this.comparison = i6;
        this.date = date;
    }
}

package javax.mail.search;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class IntegerComparisonTerm extends ComparisonTerm {
    private static final long serialVersionUID = -6963571240154302484L;
    protected int number;

    @Override // javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        return (obj instanceof IntegerComparisonTerm) && ((IntegerComparisonTerm) obj).number == this.number && super.equals(obj);
    }

    public int getComparison() {
        return this.comparison;
    }

    public int getNumber() {
        return this.number;
    }

    @Override // javax.mail.search.ComparisonTerm
    public int hashCode() {
        return this.number + super.hashCode();
    }

    protected boolean match(int i6) {
        switch (this.comparison) {
            case 1:
                return i6 <= this.number;
            case 2:
                return i6 < this.number;
            case 3:
                return i6 == this.number;
            case 4:
                return i6 != this.number;
            case 5:
                return i6 > this.number;
            case 6:
                return i6 >= this.number;
            default:
                return false;
        }
    }

    protected IntegerComparisonTerm(int i6, int i7) {
        this.comparison = i6;
        this.number = i7;
    }
}

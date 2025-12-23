package javax.mail.search;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class StringTerm extends SearchTerm {
    private static final long serialVersionUID = 1274042129007696269L;
    protected boolean ignoreCase;
    protected String pattern;

    protected StringTerm(String str) {
        this.pattern = str;
        this.ignoreCase = true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StringTerm)) {
            return false;
        }
        StringTerm stringTerm = (StringTerm) obj;
        return this.ignoreCase ? stringTerm.pattern.equalsIgnoreCase(this.pattern) && stringTerm.ignoreCase == this.ignoreCase : stringTerm.pattern.equals(this.pattern) && stringTerm.ignoreCase == this.ignoreCase;
    }

    public boolean getIgnoreCase() {
        return this.ignoreCase;
    }

    public String getPattern() {
        return this.pattern;
    }

    public int hashCode() {
        return this.ignoreCase ? this.pattern.hashCode() : ~this.pattern.hashCode();
    }

    protected boolean match(String str) {
        int length = str.length() - this.pattern.length();
        int i6 = 0;
        while (i6 <= length) {
            boolean z5 = this.ignoreCase;
            String str2 = this.pattern;
            String str3 = str;
            if (str3.regionMatches(z5, i6, str2, 0, str2.length())) {
                return true;
            }
            i6++;
            str = str3;
        }
        return false;
    }

    protected StringTerm(String str, boolean z5) {
        this.pattern = str;
        this.ignoreCase = z5;
    }
}

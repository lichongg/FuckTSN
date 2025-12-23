package javax.mail.search;

import javax.mail.Flags;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlagTerm extends SearchTerm {
    private static final long serialVersionUID = -142991500302030647L;
    protected Flags flags;
    protected boolean set;

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Flags flags = message.getFlags();
            if (this.set) {
                return flags.contains(this.flags);
            }
            for (Flags.Flag flag : this.flags.getSystemFlags()) {
                if (flags.contains(flag)) {
                    return false;
                }
            }
            for (String str : this.flags.getUserFlags()) {
                if (flags.contains(str)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FlagTerm)) {
            return false;
        }
        FlagTerm flagTerm = (FlagTerm) obj;
        return flagTerm.set == this.set && flagTerm.flags.equals(this.flags);
    }

    public Flags getFlags() {
        return (Flags) this.flags.clone();
    }

    public boolean getTestSet() {
        return this.set;
    }

    public int hashCode() {
        return this.set ? this.flags.hashCode() : ~this.flags.hashCode();
    }

    public FlagTerm(Flags flags, boolean z5) {
        this.flags = flags;
        this.set = z5;
    }
}

package org.junit.experimental.theories;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class PotentialAssignment {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CouldNotGenerateValueException extends Exception {
        private static final long serialVersionUID = 1;

        public CouldNotGenerateValueException() {
        }

        public CouldNotGenerateValueException(Throwable th) {
            super(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends PotentialAssignment {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f51356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f51357b;

        a(Object obj, String str) {
            this.f51356a = obj;
            this.f51357b = str;
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public String b() {
            String format;
            Object obj = this.f51356a;
            if (obj == null) {
                format = "null";
            } else {
                try {
                    format = String.format("\"%s\"", obj);
                } catch (Throwable th) {
                    format = String.format("[toString() threw %s: %s]", th.getClass().getSimpleName(), th.getMessage());
                }
            }
            return String.format("%s <from %s>", format, this.f51357b);
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public Object c() {
            return this.f51356a;
        }

        public String toString() {
            return String.format("[%s]", this.f51356a);
        }
    }

    public abstract String b() throws CouldNotGenerateValueException;

    public abstract Object c() throws CouldNotGenerateValueException;

    public static PotentialAssignment a(String str, Object obj) {
        return new a(obj, str);
    }
}

package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class Provider {
    private String className;
    private String protocol;
    private Type type;
    private String vendor;
    private String version;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Type {
        public static final Type STORE = new Type("STORE");
        public static final Type TRANSPORT = new Type("TRANSPORT");
        private String type;

        public String toString() {
            return this.type;
        }

        private Type(String str) {
            this.type = str;
        }
    }

    public String getClassName() {
        return this.className;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Type getType() {
        return this.type;
    }

    public String getVendor() {
        return this.vendor;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        String str = "javax.mail.Provider[" + this.type + "," + this.protocol + "," + this.className;
        if (this.vendor != null) {
            str = String.valueOf(str) + "," + this.vendor;
        }
        if (this.version != null) {
            str = String.valueOf(str) + "," + this.version;
        }
        return String.valueOf(str) + "]";
    }

    public Provider(Type type, String str, String str2, String str3, String str4) {
        this.type = type;
        this.protocol = str;
        this.className = str2;
        this.vendor = str3;
        this.version = str4;
    }
}

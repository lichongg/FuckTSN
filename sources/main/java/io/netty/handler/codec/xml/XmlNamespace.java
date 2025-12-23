package io.netty.handler.codec.xml;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class XmlNamespace {
    private final String prefix;
    private final String uri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlNamespace xmlNamespace = (XmlNamespace) obj;
        String str = this.prefix;
        if (str == null ? xmlNamespace.prefix != null : !str.equals(xmlNamespace.prefix)) {
            return false;
        }
        String str2 = this.uri;
        String str3 = xmlNamespace.uri;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.prefix;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uri;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String prefix() {
        return this.prefix;
    }

    public String toString() {
        return "XmlNamespace{prefix='" + this.prefix + "', uri='" + this.uri + "'}";
    }

    public String uri() {
        return this.uri;
    }

    public XmlNamespace(String str, String str2) {
        this.prefix = str;
        this.uri = str2;
    }
}

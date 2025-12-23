package io.netty.handler.codec.xml;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class XmlEntityReference {
    private final String name;
    private final String text;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlEntityReference xmlEntityReference = (XmlEntityReference) obj;
        String str = this.name;
        if (str == null ? xmlEntityReference.name != null : !str.equals(xmlEntityReference.name)) {
            return false;
        }
        String str2 = this.text;
        String str3 = xmlEntityReference.text;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String name() {
        return this.name;
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        return "XmlEntityReference{name='" + this.name + "', text='" + this.text + "'}";
    }

    public XmlEntityReference(String str, String str2) {
        this.name = str;
        this.text = str2;
    }
}

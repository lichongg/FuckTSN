package io.netty.handler.codec.xml;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class XmlDTD {
    private final String text;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.text;
        String str2 = ((XmlDTD) obj).text;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        return "XmlDTD{text='" + this.text + "'}";
    }

    public XmlDTD(String str) {
        this.text = str;
    }
}

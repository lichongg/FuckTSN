package io.netty.handler.codec.xml;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class XmlContent {
    private final String data;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.data;
        String str2 = ((XmlContent) obj).data;
        return str == null ? str2 == null : str.equals(str2);
    }

    public String data() {
        return this.data;
    }

    public int hashCode() {
        String str = this.data;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "XmlContent{data='" + this.data + "'}";
    }

    protected XmlContent(String str) {
        this.data = str;
    }
}

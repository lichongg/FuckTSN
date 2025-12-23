package io.netty.handler.codec.xml;

import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class XmlElementStart extends XmlElement {
    private final List<XmlAttribute> attributes;

    @Override // io.netty.handler.codec.xml.XmlElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        List<XmlAttribute> list = this.attributes;
        List<XmlAttribute> list2 = ((XmlElementStart) obj).attributes;
        return list == null ? list2 == null : list.equals(list2);
    }

    public List<XmlAttribute> attributes() {
        return this.attributes;
    }

    @Override // io.netty.handler.codec.xml.XmlElement
    public String toString() {
        return "XmlElementStart{attributes=" + this.attributes + super.toString() + "} ";
    }

    public XmlElementStart(String str, String str2, String str3) {
        super(str, str2, str3);
        this.attributes = new LinkedList();
    }

    @Override // io.netty.handler.codec.xml.XmlElement
    public int hashCode() {
        int i6;
        int hashCode = super.hashCode() * 31;
        List<XmlAttribute> list = this.attributes;
        if (list != null) {
            i6 = list.hashCode();
        } else {
            i6 = 0;
        }
        return hashCode + i6;
    }
}

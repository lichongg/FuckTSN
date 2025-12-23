package g2;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {
    public static XmlPullParserFactory a() throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes", false);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#validation", false);
        return newInstance;
    }
}

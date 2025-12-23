package g2;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    public static SAXParserFactory a() throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException, NullPointerException {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setFeature("http://xml.org/sax/features/namespaces", true);
        newInstance.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
        newInstance.setFeature("http://xml.org/sax/features/validation", false);
        newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
        newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        newInstance.setFeature("http://xml.org/sax/features/string-interning", true);
        return newInstance;
    }
}

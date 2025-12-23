package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class Header {
    protected String name;
    protected String value;

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public Header(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}

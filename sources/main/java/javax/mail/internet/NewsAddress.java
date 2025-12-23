package javax.mail.internet;

import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class NewsAddress extends Address {
    private static final long serialVersionUID = -4203797299824684143L;
    protected String host;
    protected String newsgroup;

    public NewsAddress() {
    }

    @Override // javax.mail.Address
    public String toString() {
        return this.newsgroup;
    }

    public NewsAddress(String str) {
        this(str, null);
    }

    public static NewsAddress[] parse(String str) throws AddressException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Vector vector = new Vector();
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(new NewsAddress(stringTokenizer.nextToken()));
        }
        int size = vector.size();
        NewsAddress[] newsAddressArr = new NewsAddress[size];
        if (size > 0) {
            vector.copyInto(newsAddressArr);
        }
        return newsAddressArr;
    }

    public static String toString(Address[] addressArr) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(((NewsAddress) addressArr[0]).toString());
        for (int i6 = 1; i6 < addressArr.length; i6++) {
            stringBuffer.append(",");
            stringBuffer.append(((NewsAddress) addressArr[i6]).toString());
        }
        return stringBuffer.toString();
    }

    @Override // javax.mail.Address
    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof NewsAddress)) {
            return false;
        }
        NewsAddress newsAddress = (NewsAddress) obj;
        if (this.newsgroup.equals(newsAddress.newsgroup)) {
            String str2 = this.host;
            if (str2 == null && newsAddress.host == null) {
                return true;
            }
            if (str2 != null && (str = newsAddress.host) != null && str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public String getNewsgroup() {
        return this.newsgroup;
    }

    @Override // javax.mail.Address
    public String getType() {
        return "news";
    }

    public int hashCode() {
        String str = this.newsgroup;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.host;
        return str2 != null ? hashCode + str2.toLowerCase(Locale.ENGLISH).hashCode() : hashCode;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setNewsgroup(String str) {
        this.newsgroup = str;
    }

    public NewsAddress(String str, String str2) {
        this.newsgroup = str;
        this.host = str2;
    }
}

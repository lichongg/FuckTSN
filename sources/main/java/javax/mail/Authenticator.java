package javax.mail;

import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Authenticator {
    private int requestingPort;
    private String requestingPrompt;
    private String requestingProtocol;
    private InetAddress requestingSite;
    private String requestingUserName;

    private void reset() {
        this.requestingSite = null;
        this.requestingPort = -1;
        this.requestingProtocol = null;
        this.requestingPrompt = null;
        this.requestingUserName = null;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return null;
    }

    protected final String getDefaultUserName() {
        return this.requestingUserName;
    }

    protected final int getRequestingPort() {
        return this.requestingPort;
    }

    protected final String getRequestingPrompt() {
        return this.requestingPrompt;
    }

    protected final String getRequestingProtocol() {
        return this.requestingProtocol;
    }

    protected final InetAddress getRequestingSite() {
        return this.requestingSite;
    }

    final PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i6, String str, String str2, String str3) {
        reset();
        this.requestingSite = inetAddress;
        this.requestingPort = i6;
        this.requestingProtocol = str;
        this.requestingPrompt = str2;
        this.requestingUserName = str3;
        return getPasswordAuthentication();
    }
}

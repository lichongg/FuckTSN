package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class PasswordAuthentication {
    private String password;
    private String userName;

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }

    public PasswordAuthentication(String str, String str2) {
        this.userName = str;
        this.password = str2;
    }
}

package javax.activation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MimeType implements Externalizable {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private MimeTypeParameterList parameters;
    private String primaryType;
    private String subType;

    public MimeType() {
        this.primaryType = "application";
        this.subType = "*";
        this.parameters = new MimeTypeParameterList();
    }

    public boolean match(MimeType mimeType) {
        if (this.primaryType.equals(mimeType.getPrimaryType())) {
            return this.subType.equals("*") || mimeType.getSubType().equals("*") || this.subType.equals(mimeType.getSubType());
        }
        return false;
    }

    private static boolean isTokenChar(char c6) {
        return c6 > ' ' && c6 < 127 && TSPECIALS.indexOf(c6) < 0;
    }

    private void parse(String str) throws MimeTypeParseException {
        int indexOf = str.indexOf(47);
        int indexOf2 = str.indexOf(59);
        if (indexOf < 0 && indexOf2 < 0) {
            throw new MimeTypeParseException("Unable to find a sub type.");
        }
        if (indexOf < 0 && indexOf2 >= 0) {
            throw new MimeTypeParseException("Unable to find a sub type.");
        }
        if (indexOf >= 0 && indexOf2 < 0) {
            String trim = str.substring(0, indexOf).trim();
            Locale locale = Locale.ENGLISH;
            this.primaryType = trim.toLowerCase(locale);
            this.subType = str.substring(indexOf + 1).trim().toLowerCase(locale);
            this.parameters = new MimeTypeParameterList();
        } else {
            if (indexOf >= indexOf2) {
                throw new MimeTypeParseException("Unable to find a sub type.");
            }
            String trim2 = str.substring(0, indexOf).trim();
            Locale locale2 = Locale.ENGLISH;
            this.primaryType = trim2.toLowerCase(locale2);
            this.subType = str.substring(indexOf + 1, indexOf2).trim().toLowerCase(locale2);
            this.parameters = new MimeTypeParameterList(str.substring(indexOf2));
        }
        if (!isValidToken(this.primaryType)) {
            throw new MimeTypeParseException("Primary type is invalid.");
        }
        if (!isValidToken(this.subType)) {
            throw new MimeTypeParseException("Sub type is invalid.");
        }
    }

    public String getBaseType() {
        return String.valueOf(this.primaryType) + "/" + this.subType;
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }

    public MimeTypeParameterList getParameters() {
        return this.parameters;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public void removeParameter(String str) {
        this.parameters.remove(str);
    }

    public void setParameter(String str, String str2) {
        this.parameters.set(str, str2);
    }

    public void setPrimaryType(String str) throws MimeTypeParseException {
        if (!isValidToken(this.primaryType)) {
            throw new MimeTypeParseException("Primary type is invalid.");
        }
        this.primaryType = str.toLowerCase(Locale.ENGLISH);
    }

    public void setSubType(String str) throws MimeTypeParseException {
        if (!isValidToken(this.subType)) {
            throw new MimeTypeParseException("Sub type is invalid.");
        }
        this.subType = str.toLowerCase(Locale.ENGLISH);
    }

    public String toString() {
        return String.valueOf(getBaseType()) + this.parameters.toString();
    }

    private boolean isValidToken(String str) {
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            if (!isTokenChar(str.charAt(i6))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        try {
            parse(objectInput.readUTF());
        } catch (MimeTypeParseException e6) {
            throw new IOException(e6.toString());
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(toString());
        objectOutput.flush();
    }

    public MimeType(String str) throws MimeTypeParseException {
        parse(str);
    }

    public boolean match(String str) throws MimeTypeParseException {
        return match(new MimeType(str));
    }

    public MimeType(String str, String str2) throws MimeTypeParseException {
        if (isValidToken(str)) {
            Locale locale = Locale.ENGLISH;
            this.primaryType = str.toLowerCase(locale);
            if (isValidToken(str2)) {
                this.subType = str2.toLowerCase(locale);
                this.parameters = new MimeTypeParameterList();
                return;
            }
            throw new MimeTypeParseException("Sub type is invalid.");
        }
        throw new MimeTypeParseException("Primary type is invalid.");
    }
}

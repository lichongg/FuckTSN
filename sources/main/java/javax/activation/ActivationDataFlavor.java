package javax.activation;

import myjava.awt.datatransfer.DataFlavor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class ActivationDataFlavor extends DataFlavor {
    private String humanPresentableName;
    private MimeType mimeObject;
    private String mimeType;
    private Class representationClass;

    public ActivationDataFlavor(Class cls, String str, String str2) {
        super(str, str2);
        this.mimeObject = null;
        this.mimeType = str;
        this.humanPresentableName = str2;
        this.representationClass = cls;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public String getHumanPresentableName() {
        return this.humanPresentableName;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public Class getRepresentationClass() {
        return this.representationClass;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public boolean isMimeTypeEqual(String str) {
        try {
            if (this.mimeObject == null) {
                this.mimeObject = new MimeType(this.mimeType);
            }
            return this.mimeObject.match(new MimeType(str));
        } catch (MimeTypeParseException unused) {
            return this.mimeType.equalsIgnoreCase(str);
        }
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public void setHumanPresentableName(String str) {
        this.humanPresentableName = str;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public boolean equals(DataFlavor dataFlavor) {
        if (isMimeTypeEqual(dataFlavor) && dataFlavor.getRepresentationClass() == this.representationClass) {
            return true;
        }
        return false;
    }

    public ActivationDataFlavor(Class cls, String str) {
        super((Class<?>) cls, str);
        this.mimeType = null;
        this.mimeObject = null;
        this.humanPresentableName = null;
        this.representationClass = null;
        this.mimeType = super.getMimeType();
        this.representationClass = cls;
        this.humanPresentableName = str;
    }

    public ActivationDataFlavor(String str, String str2) {
        super(str, str2);
        this.mimeObject = null;
        this.humanPresentableName = null;
        this.representationClass = null;
        this.mimeType = str;
        try {
            this.representationClass = Class.forName("java.io.InputStream");
        } catch (ClassNotFoundException unused) {
        }
        this.humanPresentableName = str2;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    protected String normalizeMimeType(String str) {
        return str;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    protected String normalizeMimeTypeParameter(String str, String str2) {
        return str2;
    }
}

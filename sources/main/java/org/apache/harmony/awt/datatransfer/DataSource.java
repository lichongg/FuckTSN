package org.apache.harmony.awt.datatransfer;

import androidx.core.view.MotionEventCompat;
import com.baidu.mobads.sdk.internal.a;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DataSource implements DataProvider {
    protected final Transferable contents;
    private DataFlavor[] flavors;
    private List<String> nativeFormats;

    private String getText(boolean z5) {
        for (DataFlavor dataFlavor : this.contents.getTransferDataFlavors()) {
            if (dataFlavor.isFlavorTextType() && (!z5 || isHtmlFlavor(dataFlavor))) {
                try {
                    return String.class.isAssignableFrom(dataFlavor.getRepresentationClass()) ? (String) this.contents.getTransferData(dataFlavor) : getTextFromReader(dataFlavor.getReaderForText(this.contents));
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getHTML() {
        return getText(true);
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public byte[] getSerializedObject(Class<?> cls) {
        try {
            Serializable serializable = (Serializable) this.contents.getTransferData(new DataFlavor(cls, (String) null));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable unused) {
            return null;
        }
    }

    private RawBitmap getImageBitmap(Image image) {
        if (image instanceof BufferedImage) {
            BufferedImage bufferedImage = (BufferedImage) image;
            if (bufferedImage.getType() == 1) {
                return getImageBitmap32(bufferedImage);
            }
        }
        int width = image.getWidth((ImageObserver) null);
        int height = image.getHeight((ImageObserver) null);
        if (width <= 0 || height <= 0) {
            return null;
        }
        BufferedImage bufferedImage2 = new BufferedImage(width, height, 1);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(image, 0, 0, (ImageObserver) null);
        graphics.dispose();
        return getImageBitmap32(bufferedImage2);
    }

    private static List<String> getNativesForFlavors(DataFlavor[] dataFlavorArr) {
        ArrayList arrayList = new ArrayList();
        SystemFlavorMap defaultFlavorMap = SystemFlavorMap.getDefaultFlavorMap();
        for (DataFlavor dataFlavor : dataFlavorArr) {
            for (String str : defaultFlavorMap.getNativesForFlavor(dataFlavor)) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private String getTextFromReader(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        while (true) {
            int read = reader.read(cArr);
            if (read <= 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private boolean isHtmlFlavor(DataFlavor dataFlavor) {
        return a.f10505f.equalsIgnoreCase(dataFlavor.getSubType());
    }

    protected DataFlavor[] getDataFlavors() {
        if (this.flavors == null) {
            this.flavors = this.contents.getTransferDataFlavors();
        }
        return this.flavors;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String[] getFileList() {
        try {
            List list = (List) this.contents.getTransferData(DataFlavor.javaFileListFlavor);
            return (String[]) list.toArray(new String[list.size()]);
        } catch (Exception unused) {
            return null;
        }
    }

    public List<String> getNativeFormatsList() {
        if (this.nativeFormats == null) {
            this.nativeFormats = getNativesForFlavors(getDataFlavors());
        }
        return this.nativeFormats;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public RawBitmap getRawBitmap() {
        DataFlavor[] transferDataFlavors = this.contents.getTransferDataFlavors();
        for (DataFlavor dataFlavor : transferDataFlavors) {
            Class representationClass = dataFlavor.getRepresentationClass();
            if (representationClass != null && Image.class.isAssignableFrom(representationClass) && (dataFlavor.isMimeTypeEqual(DataFlavor.imageFlavor) || dataFlavor.isFlavorSerializedObjectType())) {
                try {
                    return getImageBitmap((Image) this.contents.getTransferData(dataFlavor));
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        return null;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getURL() {
        try {
            try {
                try {
                    return ((URL) this.contents.getTransferData(DataProvider.urlFlavor)).toString();
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception unused2) {
                return new URL(getText()).toString();
            }
        } catch (Exception unused3) {
            return ((URL) this.contents.getTransferData(DataProvider.uriFlavor)).toString();
        }
    }

    public DataSource(Transferable transferable) {
        this.contents = transferable;
    }

    private RawBitmap getImageBitmap32(BufferedImage bufferedImage) {
        int[] iArr = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
        DataBufferInt dataBuffer = bufferedImage.getRaster().getDataBuffer();
        int numBanks = dataBuffer.getNumBanks();
        int[] offsets = dataBuffer.getOffsets();
        int i6 = 0;
        for (int i7 = 0; i7 < numBanks; i7++) {
            int[] data = dataBuffer.getData(i7);
            int i8 = offsets[i7];
            System.arraycopy(data, i8, iArr, i6, data.length - i8);
            i6 += data.length - offsets[i7];
        }
        return new RawBitmap(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getWidth(), 32, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, iArr);
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String[] getNativeFormats() {
        return (String[]) getNativeFormatsList().toArray(new String[0]);
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public boolean isNativeFormatAvailable(String str) {
        return getNativeFormatsList().contains(str);
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getText() {
        return getText(false);
    }
}

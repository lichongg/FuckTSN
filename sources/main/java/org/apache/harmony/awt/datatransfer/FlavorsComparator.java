package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FlavorsComparator implements Comparator<DataFlavor> {
    @Override // java.util.Comparator
    public int compare(DataFlavor dataFlavor, DataFlavor dataFlavor2) {
        if (!dataFlavor.isFlavorTextType() && !dataFlavor2.isFlavorTextType()) {
            return 0;
        }
        if (dataFlavor.isFlavorTextType() || !dataFlavor2.isFlavorTextType()) {
            return ((!dataFlavor.isFlavorTextType() || dataFlavor2.isFlavorTextType()) && DataFlavor.selectBestTextFlavor(new DataFlavor[]{dataFlavor, dataFlavor2}) == dataFlavor) ? -1 : 1;
        }
        return -1;
    }
}

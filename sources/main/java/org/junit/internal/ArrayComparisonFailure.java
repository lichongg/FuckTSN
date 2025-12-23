package org.junit.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ArrayComparisonFailure extends AssertionError {
    private static final long serialVersionUID = 1;
    private final List<Integer> fIndices = new ArrayList();
    private final String fMessage;

    public void addDimension(int i6) {
        this.fIndices.add(0, Integer.valueOf(i6));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        String str = this.fMessage;
        if (str != null) {
            sb.append(str);
        }
        sb.append("arrays first differed at element ");
        Iterator<Integer> it = this.fIndices.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            sb.append("[");
            sb.append(intValue);
            sb.append("]");
        }
        sb.append("; ");
        sb.append(getCause().getMessage());
        return sb.toString();
    }

    public ArrayComparisonFailure(String str, AssertionError assertionError, int i6) {
        this.fMessage = str;
        initCause(assertionError);
        addDimension(i6);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }
}

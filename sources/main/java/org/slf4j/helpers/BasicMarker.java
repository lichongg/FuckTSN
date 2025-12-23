package org.slf4j.helpers;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BasicMarker implements Marker {
    private static String CLOSE = " ]";
    private static String OPEN = "[ ";
    private static String SEP = ", ";
    private static final long serialVersionUID = 1803952589649545191L;
    private final String name;
    private List<Marker> referenceList;

    @Override // org.slf4j.Marker
    public synchronized void add(Marker marker) {
        try {
            if (marker == null) {
                throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
            }
            if (contains(marker)) {
                return;
            }
            if (marker.contains(this)) {
                return;
            }
            if (this.referenceList == null) {
                this.referenceList = new Vector();
            }
            this.referenceList.add(marker);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.slf4j.Marker
    public boolean contains(Marker marker) {
        if (marker == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (equals(marker)) {
            return true;
        }
        if (!hasReferences()) {
            return false;
        }
        Iterator<Marker> it = this.referenceList.iterator();
        while (it.hasNext()) {
            if (it.next().contains(marker)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public synchronized boolean hasReferences() {
        boolean z5;
        List<Marker> list = this.referenceList;
        if (list != null) {
            z5 = list.size() > 0;
        }
        return z5;
    }

    @Override // org.slf4j.Marker
    public synchronized Iterator<Marker> iterator() {
        List<Marker> list = this.referenceList;
        if (list != null) {
            return list.iterator();
        }
        return Collections.EMPTY_LIST.iterator();
    }

    @Override // org.slf4j.Marker
    public synchronized boolean remove(Marker marker) {
        List<Marker> list = this.referenceList;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (marker.equals(this.referenceList.get(i6))) {
                this.referenceList.remove(i6);
                return true;
            }
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Marker)) {
            return this.name.equals(((Marker) obj).getName());
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.Marker
    public int hashCode() {
        return this.name.hashCode();
    }

    BasicMarker(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("A marker name cannot be null");
    }

    @Override // org.slf4j.Marker
    public boolean hasChildren() {
        return hasReferences();
    }

    public String toString() {
        if (!hasReferences()) {
            return getName();
        }
        Iterator<Marker> it = iterator();
        StringBuilder sb = new StringBuilder(getName());
        sb.append(' ');
        sb.append(OPEN);
        while (it.hasNext()) {
            sb.append(it.next().getName());
            if (it.hasNext()) {
                sb.append(SEP);
            }
        }
        sb.append(CLOSE);
        return sb.toString();
    }

    @Override // org.slf4j.Marker
    public boolean contains(String str) {
        if (str != null) {
            if (this.name.equals(str)) {
                return true;
            }
            if (!hasReferences()) {
                return false;
            }
            Iterator<Marker> it = this.referenceList.iterator();
            while (it.hasNext()) {
                if (it.next().contains(str)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Other cannot be null");
    }
}

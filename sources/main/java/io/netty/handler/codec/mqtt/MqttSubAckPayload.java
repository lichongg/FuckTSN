package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MqttSubAckPayload {
    private final List<Integer> grantedQoSLevels;

    public MqttSubAckPayload(int... iArr) {
        if (iArr == null) {
            throw new NullPointerException("grantedQoSLevels");
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i6 : iArr) {
            arrayList.add(Integer.valueOf(i6));
        }
        this.grantedQoSLevels = Collections.unmodifiableList(arrayList);
    }

    public List<Integer> grantedQoSLevels() {
        return this.grantedQoSLevels;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[grantedQoSLevels=" + this.grantedQoSLevels + ']';
    }

    public MqttSubAckPayload(Iterable<Integer> iterable) {
        Integer next;
        if (iterable != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                arrayList.add(next);
            }
            this.grantedQoSLevels = Collections.unmodifiableList(arrayList);
            return;
        }
        throw new NullPointerException("grantedQoSLevels");
    }
}

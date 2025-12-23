package com.umeng.analytics.pro;

import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.by;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface br<T extends br<?, ?>, F extends by> extends Serializable {
    void clear();

    br<T, F> deepCopy();

    F fieldForId(int i6);

    void read(cq cqVar) throws bx;

    void write(cq cqVar) throws bx;
}

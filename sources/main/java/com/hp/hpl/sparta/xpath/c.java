package com.hp.hpl.sparta.xpath;

import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c extends b {
    @Override // com.hp.hpl.sparta.xpath.e
    public String toString() {
        return d(ContainerUtils.KEY_VALUE_DELIMITER);
    }

    c(String str, String str2) {
        super(str, str2);
    }

    @Override // com.hp.hpl.sparta.xpath.k
    public void a(l lVar) throws XPathException {
        lVar.n(this);
    }
}

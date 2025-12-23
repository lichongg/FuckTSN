package com.amap.api.col.p0003l;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p7 extends q7 {
    public p7() {
    }

    public p7(q7 q7Var) {
        super(q7Var);
    }

    @Override // com.amap.api.col.p0003l.q7
    protected final byte[] b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] o5 = q4.o(stringBuffer.toString());
        byte[] bArr2 = new byte[o5.length + bArr.length];
        System.arraycopy(o5, 0, bArr2, 0, o5.length);
        System.arraycopy(bArr, 0, bArr2, o5.length, bArr.length);
        return bArr2;
    }
}

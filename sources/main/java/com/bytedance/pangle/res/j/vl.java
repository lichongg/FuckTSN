package com.bytedance.pangle.res.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl {
    public static void j(ae aeVar) throws IOException {
        int i6;
        aeVar.xt(1835009, 0);
        int readInt = aeVar.readInt();
        int readInt2 = aeVar.readInt();
        int readInt3 = aeVar.readInt();
        aeVar.j();
        int readInt4 = aeVar.readInt();
        int readInt5 = aeVar.readInt();
        aeVar.skipBytes(readInt2 * 4);
        if (readInt3 != 0) {
            aeVar.skipBytes(readInt3 * 4);
        }
        if (readInt5 == 0) {
            i6 = readInt;
        } else {
            i6 = readInt5;
        }
        aeVar.skipBytes(i6 - readInt4);
        if (readInt5 != 0) {
            int i7 = readInt - readInt5;
            aeVar.skipBytes(i7);
            int i8 = i7 % 4;
            if (i8 <= 0) {
                return;
            }
            while (true) {
                int i9 = i8 - 1;
                if (i8 > 0) {
                    aeVar.readByte();
                    i8 = i9;
                } else {
                    return;
                }
            }
        }
    }
}

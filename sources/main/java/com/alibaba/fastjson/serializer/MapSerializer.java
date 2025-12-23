package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        write(jSONSerializer, obj, obj2, type, i6, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0215 A[Catch: all -> 0x0049, TryCatch #2 {all -> 0x0049, blocks: (B:19:0x0045, B:24:0x004c, B:26:0x0058, B:32:0x0073, B:33:0x0084, B:34:0x008f, B:36:0x0095, B:38:0x00a7, B:41:0x00af, B:44:0x00b4, B:46:0x00be, B:48:0x00c2, B:53:0x00ce, B:57:0x00d9, B:59:0x00dd, B:62:0x00e5, B:65:0x00ea, B:67:0x00f4, B:69:0x00f8, B:73:0x0104, B:77:0x010f, B:79:0x0113, B:82:0x011b, B:85:0x0120, B:87:0x012a, B:89:0x012e, B:93:0x013a, B:97:0x0145, B:99:0x0149, B:102:0x0151, B:105:0x0156, B:107:0x0160, B:109:0x0164, B:113:0x0170, B:117:0x017b, B:119:0x017f, B:122:0x0187, B:125:0x018c, B:127:0x0196, B:129:0x019a, B:130:0x01a3, B:131:0x01a9, B:133:0x01ad, B:136:0x01b5, B:139:0x01ba, B:141:0x01c4, B:143:0x01c8, B:144:0x01d2, B:151:0x0201, B:154:0x020f, B:156:0x0215, B:158:0x021a, B:159:0x021d, B:161:0x0225, B:162:0x0228, B:164:0x025c, B:167:0x0261, B:178:0x0278, B:183:0x022e, B:184:0x0231, B:186:0x0239, B:188:0x0241, B:191:0x024a, B:192:0x0255, B:193:0x024e, B:149:0x01fb, B:213:0x006c), top: B:18:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x025c A[Catch: all -> 0x0049, TryCatch #2 {all -> 0x0049, blocks: (B:19:0x0045, B:24:0x004c, B:26:0x0058, B:32:0x0073, B:33:0x0084, B:34:0x008f, B:36:0x0095, B:38:0x00a7, B:41:0x00af, B:44:0x00b4, B:46:0x00be, B:48:0x00c2, B:53:0x00ce, B:57:0x00d9, B:59:0x00dd, B:62:0x00e5, B:65:0x00ea, B:67:0x00f4, B:69:0x00f8, B:73:0x0104, B:77:0x010f, B:79:0x0113, B:82:0x011b, B:85:0x0120, B:87:0x012a, B:89:0x012e, B:93:0x013a, B:97:0x0145, B:99:0x0149, B:102:0x0151, B:105:0x0156, B:107:0x0160, B:109:0x0164, B:113:0x0170, B:117:0x017b, B:119:0x017f, B:122:0x0187, B:125:0x018c, B:127:0x0196, B:129:0x019a, B:130:0x01a3, B:131:0x01a9, B:133:0x01ad, B:136:0x01b5, B:139:0x01ba, B:141:0x01c4, B:143:0x01c8, B:144:0x01d2, B:151:0x0201, B:154:0x020f, B:156:0x0215, B:158:0x021a, B:159:0x021d, B:161:0x0225, B:162:0x0228, B:164:0x025c, B:167:0x0261, B:178:0x0278, B:183:0x022e, B:184:0x0231, B:186:0x0239, B:188:0x0241, B:191:0x024a, B:192:0x0255, B:193:0x024e, B:149:0x01fb, B:213:0x006c), top: B:18:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0261 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #2 {all -> 0x0049, blocks: (B:19:0x0045, B:24:0x004c, B:26:0x0058, B:32:0x0073, B:33:0x0084, B:34:0x008f, B:36:0x0095, B:38:0x00a7, B:41:0x00af, B:44:0x00b4, B:46:0x00be, B:48:0x00c2, B:53:0x00ce, B:57:0x00d9, B:59:0x00dd, B:62:0x00e5, B:65:0x00ea, B:67:0x00f4, B:69:0x00f8, B:73:0x0104, B:77:0x010f, B:79:0x0113, B:82:0x011b, B:85:0x0120, B:87:0x012a, B:89:0x012e, B:93:0x013a, B:97:0x0145, B:99:0x0149, B:102:0x0151, B:105:0x0156, B:107:0x0160, B:109:0x0164, B:113:0x0170, B:117:0x017b, B:119:0x017f, B:122:0x0187, B:125:0x018c, B:127:0x0196, B:129:0x019a, B:130:0x01a3, B:131:0x01a9, B:133:0x01ad, B:136:0x01b5, B:139:0x01ba, B:141:0x01c4, B:143:0x01c8, B:144:0x01d2, B:151:0x0201, B:154:0x020f, B:156:0x0215, B:158:0x021a, B:159:0x021d, B:161:0x0225, B:162:0x0228, B:164:0x025c, B:167:0x0261, B:178:0x0278, B:183:0x022e, B:184:0x0231, B:186:0x0239, B:188:0x0241, B:191:0x024a, B:192:0x0255, B:193:0x024e, B:149:0x01fb, B:213:0x006c), top: B:18:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095 A[Catch: all -> 0x0049, TryCatch #2 {all -> 0x0049, blocks: (B:19:0x0045, B:24:0x004c, B:26:0x0058, B:32:0x0073, B:33:0x0084, B:34:0x008f, B:36:0x0095, B:38:0x00a7, B:41:0x00af, B:44:0x00b4, B:46:0x00be, B:48:0x00c2, B:53:0x00ce, B:57:0x00d9, B:59:0x00dd, B:62:0x00e5, B:65:0x00ea, B:67:0x00f4, B:69:0x00f8, B:73:0x0104, B:77:0x010f, B:79:0x0113, B:82:0x011b, B:85:0x0120, B:87:0x012a, B:89:0x012e, B:93:0x013a, B:97:0x0145, B:99:0x0149, B:102:0x0151, B:105:0x0156, B:107:0x0160, B:109:0x0164, B:113:0x0170, B:117:0x017b, B:119:0x017f, B:122:0x0187, B:125:0x018c, B:127:0x0196, B:129:0x019a, B:130:0x01a3, B:131:0x01a9, B:133:0x01ad, B:136:0x01b5, B:139:0x01ba, B:141:0x01c4, B:143:0x01c8, B:144:0x01d2, B:151:0x0201, B:154:0x020f, B:156:0x0215, B:158:0x021a, B:159:0x021d, B:161:0x0225, B:162:0x0228, B:164:0x025c, B:167:0x0261, B:178:0x0278, B:183:0x022e, B:184:0x0231, B:186:0x0239, B:188:0x0241, B:191:0x024a, B:192:0x0255, B:193:0x024e, B:149:0x01fb, B:213:0x006c), top: B:18:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r18, java.lang.Object r19, java.lang.Object r20, java.lang.reflect.Type r21, int r22, boolean r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}

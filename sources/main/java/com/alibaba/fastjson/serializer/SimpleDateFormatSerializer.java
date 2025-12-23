package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SimpleDateFormatSerializer implements ObjectSerializer {
    private final String pattern;

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        if (obj == null) {
            jSONSerializer.out.writeNull();
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern, jSONSerializer.locale);
        simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
        jSONSerializer.write(simpleDateFormat.format((Date) obj));
    }

    public SimpleDateFormatSerializer(String str) {
        this.pattern = str;
    }
}

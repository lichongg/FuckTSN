package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.material.timepicker.TimeModel;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DateCodec extends AbstractDateDeserializer implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    protected <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        JSONScanner jSONScanner = new JSONScanner(str);
        try {
            if (jSONScanner.scanISO8601DateIfMatch(false)) {
                ?? r32 = (T) jSONScanner.getCalendar();
                return type == Calendar.class ? r32 : (T) r32.getTime();
            }
            jSONScanner.close();
            if (str.length() == defaultJSONParser.getDateFomartPattern().length()) {
                try {
                    return (T) defaultJSONParser.getDateFormat().parse(str);
                } catch (ParseException unused) {
                }
            }
            if (str.startsWith("/Date(") && str.endsWith(")/")) {
                str = str.substring(6, str.length() - 2);
            }
            if ("0000-00-00".equals(str) || "0000-00-00T00:00:00".equalsIgnoreCase(str) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str)) {
                return null;
            }
            return (T) new Date(Long.parseLong(str));
        } finally {
            jSONScanner.close();
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Date castToDate = obj instanceof Date ? (Date) obj : TypeUtils.castToDate(obj);
        if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer.locale);
                dateFormat.setTimeZone(jSONSerializer.timeZone);
            }
            serializeWriter.writeString(dateFormat.format(castToDate));
            return;
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((Date) obj).getTime());
                serializeWriter.write(41);
                return;
            } else {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.writeFieldValue(StringUtil.COMMA, "val", ((Date) obj).getTime());
                serializeWriter.write(125);
                return;
            }
        }
        long time = castToDate.getTime();
        if (!serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            serializeWriter.writeLong(time);
            return;
        }
        int i7 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        serializeWriter.write(i7);
        Calendar calendar = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
        calendar.setTimeInMillis(time);
        int i8 = calendar.get(1);
        int i9 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        int i11 = calendar.get(11);
        int i12 = calendar.get(12);
        int i13 = calendar.get(13);
        int i14 = calendar.get(14);
        if (i14 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            IOUtils.getChars(i14, 23, charArray);
            IOUtils.getChars(i13, 19, charArray);
            IOUtils.getChars(i12, 16, charArray);
            IOUtils.getChars(i11, 13, charArray);
            IOUtils.getChars(i10, 10, charArray);
            IOUtils.getChars(i9, 7, charArray);
            IOUtils.getChars(i8, 4, charArray);
        } else if (i13 == 0 && i12 == 0 && i11 == 0) {
            charArray = "0000-00-00".toCharArray();
            IOUtils.getChars(i10, 10, charArray);
            IOUtils.getChars(i9, 7, charArray);
            IOUtils.getChars(i8, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            IOUtils.getChars(i13, 19, charArray);
            IOUtils.getChars(i12, 16, charArray);
            IOUtils.getChars(i11, 13, charArray);
            IOUtils.getChars(i10, 10, charArray);
            IOUtils.getChars(i9, 7, charArray);
            IOUtils.getChars(i8, 4, charArray);
        }
        serializeWriter.write(charArray);
        int rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
        if (rawOffset == 0) {
            serializeWriter.write(90);
        } else {
            if (rawOffset > 0) {
                serializeWriter.append('+').append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(rawOffset)));
            } else {
                serializeWriter.append('-').append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(-rawOffset)));
            }
            serializeWriter.append((CharSequence) ":00");
        }
        serializeWriter.write(i7);
    }
}

package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final DateTimeFormatter ISO_FIXED_FORMAT;
    private static final DateTimeFormatter defaultFormatter;
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter_d10_cn;
    private static final DateTimeFormatter formatter_d10_de;
    private static final DateTimeFormatter formatter_d10_eur;
    private static final DateTimeFormatter formatter_d10_in;
    private static final DateTimeFormatter formatter_d10_kr;
    private static final DateTimeFormatter formatter_d10_tw;
    private static final DateTimeFormatter formatter_d10_us;
    private static final DateTimeFormatter formatter_d8;
    private static final DateTimeFormatter formatter_dt19_cn;
    private static final DateTimeFormatter formatter_dt19_cn_1;
    private static final DateTimeFormatter formatter_dt19_de;
    private static final DateTimeFormatter formatter_dt19_eur;
    private static final DateTimeFormatter formatter_dt19_in;
    private static final DateTimeFormatter formatter_dt19_kr;
    private static final DateTimeFormatter formatter_dt19_tw;
    private static final DateTimeFormatter formatter_dt19_us;
    private static final DateTimeFormatter formatter_iso8601;
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    public static final Jdk8DateCodec instance = new Jdk8DateCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        int nano;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != n0.a()) {
            serializeWriter.writeString(obj.toString());
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
        int mask = serializerFeature.getMask();
        LocalDateTime a6 = o0.a(obj);
        String dateFormatPattern = jSONSerializer.getDateFormatPattern();
        if ((dateFormatPattern == null && (i6 & mask) != 0) || jSONSerializer.isEnabled(serializerFeature)) {
            dateFormatPattern = formatter_iso8601_pattern;
        }
        nano = a6.getNano();
        if (nano != 0 && dateFormatPattern == null) {
            serializeWriter.writeString(obj.toString());
            return;
        }
        if (dateFormatPattern == null) {
            dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        }
        write(serializeWriter, a6, dateFormatPattern);
    }

    static {
        DateTimeFormatter ofPattern;
        DateTimeFormatter ofPattern2;
        DateTimeFormatter ofPattern3;
        DateTimeFormatter ofPattern4;
        DateTimeFormatter ofPattern5;
        DateTimeFormatter ofPattern6;
        DateTimeFormatter ofPattern7;
        DateTimeFormatter ofPattern8;
        DateTimeFormatter ofPattern9;
        DateTimeFormatter ofPattern10;
        DateTimeFormatter ofPattern11;
        DateTimeFormatter ofPattern12;
        DateTimeFormatter ofPattern13;
        DateTimeFormatter ofPattern14;
        DateTimeFormatter ofPattern15;
        DateTimeFormatter ofPattern16;
        DateTimeFormatter ofPattern17;
        DateTimeFormatter ofPattern18;
        ZoneId systemDefault;
        DateTimeFormatter withZone;
        DateTimeFormatter ofPattern19;
        ofPattern = DateTimeFormatter.ofPattern(defaultPatttern);
        defaultFormatter = ofPattern;
        ofPattern2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        formatter_dt19_tw = ofPattern2;
        ofPattern3 = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
        formatter_dt19_cn = ofPattern3;
        ofPattern4 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
        formatter_dt19_cn_1 = ofPattern4;
        ofPattern5 = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
        formatter_dt19_kr = ofPattern5;
        ofPattern6 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        formatter_dt19_us = ofPattern6;
        ofPattern7 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        formatter_dt19_eur = ofPattern7;
        ofPattern8 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        formatter_dt19_de = ofPattern8;
        ofPattern9 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formatter_dt19_in = ofPattern9;
        ofPattern10 = DateTimeFormatter.ofPattern("yyyyMMdd");
        formatter_d8 = ofPattern10;
        ofPattern11 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        formatter_d10_tw = ofPattern11;
        ofPattern12 = DateTimeFormatter.ofPattern("yyyy年M月d日");
        formatter_d10_cn = ofPattern12;
        ofPattern13 = DateTimeFormatter.ofPattern("yyyy년M월d일");
        formatter_d10_kr = ofPattern13;
        ofPattern14 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        formatter_d10_us = ofPattern14;
        ofPattern15 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter_d10_eur = ofPattern15;
        ofPattern16 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formatter_d10_de = ofPattern16;
        ofPattern17 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter_d10_in = ofPattern17;
        ofPattern18 = DateTimeFormatter.ofPattern(defaultPatttern);
        systemDefault = ZoneId.systemDefault();
        withZone = ofPattern18.withZone(systemDefault);
        ISO_FIXED_FORMAT = withZone;
        ofPattern19 = DateTimeFormatter.ofPattern(formatter_iso8601_pattern);
        formatter_iso8601 = ofPattern19;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i6) {
        LocalDateTime parse;
        int hour;
        int minute;
        int second;
        int nano;
        LocalDateTime parse2;
        int year;
        int monthValue;
        int dayOfMonth;
        LocalTime localTime;
        Object parse3;
        TemporalAmount parse4;
        TemporalAmount parse5;
        Object of;
        Object parse6;
        Object parse7;
        Object parse8;
        Object of2;
        ChronoLocalDate of3;
        ChronoLocalDateTime of4;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() != 4) {
            throw new UnsupportedOperationException();
        }
        String stringVal = jSONLexer.stringVal();
        jSONLexer.nextToken();
        DateTimeFormatter ofPattern = str != null ? defaultPatttern.equals(str) ? defaultFormatter : DateTimeFormatter.ofPattern(str) : null;
        if ("".equals(stringVal)) {
            return null;
        }
        if (type == n0.a()) {
            if (stringVal.length() != 10 && stringVal.length() != 8) {
                return (T) parseDateTime(stringVal, ofPattern);
            }
            LocalDate parseLocalDate = parseLocalDate(stringVal, str, ofPattern);
            localTime = LocalTime.MIN;
            of4 = LocalDateTime.of(parseLocalDate, localTime);
            return (T) of4;
        }
        if (type == d0.a()) {
            if (stringVal.length() != 23) {
                return (T) parseLocalDate(stringVal, str, ofPattern);
            }
            parse2 = LocalDateTime.parse(stringVal);
            year = parse2.getYear();
            monthValue = parse2.getMonthValue();
            dayOfMonth = parse2.getDayOfMonth();
            of3 = LocalDate.of(year, monthValue, dayOfMonth);
            return (T) of3;
        }
        if (type == g.a()) {
            if (stringVal.length() != 23) {
                parse8 = LocalTime.parse(stringVal);
                return (T) parse8;
            }
            parse = LocalDateTime.parse(stringVal);
            hour = parse.getHour();
            minute = parse.getMinute();
            second = parse.getSecond();
            nano = parse.getNano();
            of2 = LocalTime.of(hour, minute, second, nano);
            return (T) of2;
        }
        if (type == n.a()) {
            if (ofPattern == defaultFormatter) {
                ofPattern = ISO_FIXED_FORMAT;
            }
            return (T) parseZonedDateTime(stringVal, ofPattern);
        }
        if (type == o.a()) {
            parse7 = OffsetDateTime.parse(stringVal);
            return (T) parse7;
        }
        if (type == q.a()) {
            parse6 = OffsetTime.parse(stringVal);
            return (T) parse6;
        }
        if (type == s.a()) {
            of = ZoneId.of(stringVal);
            return (T) of;
        }
        if (type == u.a()) {
            parse5 = Period.parse(stringVal);
            return (T) parse5;
        }
        if (type == x.a()) {
            parse4 = Duration.parse(stringVal);
            return (T) parse4;
        }
        if (type != z.a()) {
            return null;
        }
        parse3 = Instant.parse(stringVal);
        return (T) parse3;
    }

    protected LocalDateTime parseDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        LocalDateTime parse;
        LocalDateTime parse2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = defaultFormatter;
                        }
                    } else if (charAt == '-' && charAt2 == '-') {
                        dateTimeFormatter = defaultFormatter;
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = formatter_dt19_tw;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i6 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = formatter_dt19_eur;
                            } else if (i6 > 12) {
                                dateTimeFormatter = formatter_dt19_us;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = formatter_dt19_us;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = formatter_dt19_eur;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = formatter_dt19_de;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = formatter_dt19_in;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? formatter_dt19_cn_1 : formatter_dt19_cn;
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = formatter_dt19_kr;
                }
            }
        }
        if (dateTimeFormatter == null) {
            parse2 = LocalDateTime.parse(str);
            return parse2;
        }
        parse = LocalDateTime.parse(str, dateTimeFormatter);
        return parse;
    }

    protected LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        LocalDate parse;
        LocalDate parse2;
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = formatter_d8;
            }
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = formatter_d10_tw;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i6 = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter = formatter_d10_eur;
                    } else if (i6 > 12) {
                        dateTimeFormatter = formatter_d10_us;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter = formatter_d10_eur;
                        }
                    }
                } else {
                    if (charAt5 == '.' && charAt7 == '.') {
                        dateTimeFormatter2 = formatter_d10_de;
                    } else if (charAt5 == '-' && charAt7 == '-') {
                        dateTimeFormatter2 = formatter_d10_in;
                    }
                    dateTimeFormatter = dateTimeFormatter2;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter = formatter_d10_cn;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter = formatter_d10_kr;
                }
            }
        }
        if (dateTimeFormatter == null) {
            parse2 = LocalDate.parse(str);
            return parse2;
        }
        parse = LocalDate.parse(str, dateTimeFormatter);
        return parse;
    }

    protected ZonedDateTime parseZonedDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        ZonedDateTime parse;
        ZonedDateTime parse2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = defaultFormatter;
                        }
                    } else if (charAt == '-' && charAt2 == '-') {
                        dateTimeFormatter = defaultFormatter;
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = formatter_dt19_tw;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i6 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = formatter_dt19_eur;
                            } else if (i6 > 12) {
                                dateTimeFormatter = formatter_dt19_us;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = formatter_dt19_us;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = formatter_dt19_eur;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = formatter_dt19_de;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = formatter_dt19_in;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? formatter_dt19_cn_1 : formatter_dt19_cn;
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = formatter_dt19_kr;
                }
            }
        }
        if (dateTimeFormatter == null) {
            parse2 = ZonedDateTime.parse(str);
            return parse2;
        }
        parse = ZonedDateTime.parse(str, dateTimeFormatter);
        return parse;
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, c.a(obj), beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter ofPattern;
        String format;
        if (str != formatter_iso8601_pattern) {
            ofPattern = DateTimeFormatter.ofPattern(str);
        } else {
            ofPattern = formatter_iso8601;
        }
        format = ofPattern.format(temporalAccessor);
        serializeWriter.writeString(format);
    }
}

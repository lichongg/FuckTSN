package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface JSONLexer {
    public static final int ARRAY = 2;
    public static final int END = 4;
    public static final char EOI = 26;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int OBJECT = 1;
    public static final int UNKNOWN = 0;
    public static final int VALUE = 3;
    public static final int VALUE_NULL = 5;

    byte[] bytesValue();

    void close();

    void config(Feature feature, boolean z5);

    Number decimalValue(boolean z5);

    BigDecimal decimalValue();

    float floatValue();

    char getCurrent();

    Locale getLocale();

    TimeZone getTimeZone();

    String info();

    int intValue();

    Number integerValue();

    boolean isBlankInput();

    boolean isEnabled(int i6);

    boolean isEnabled(Feature feature);

    boolean isRef();

    long longValue();

    char next();

    void nextToken();

    void nextToken(int i6);

    void nextTokenWithColon();

    void nextTokenWithColon(int i6);

    String numberString();

    int pos();

    void resetStringPosition();

    boolean scanBoolean(char c6);

    double scanDouble(char c6);

    Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c6);

    float scanFloat(char c6);

    int scanInt(char c6);

    long scanLong(char c6);

    void scanNumber();

    String scanString(char c6);

    void scanString();

    void scanStringArray(Collection<String> collection, char c6);

    String scanSymbol(SymbolTable symbolTable);

    String scanSymbol(SymbolTable symbolTable, char c6);

    String scanSymbolUnQuoted(SymbolTable symbolTable);

    String scanSymbolWithSeperator(SymbolTable symbolTable, char c6);

    void setLocale(Locale locale);

    void setTimeZone(TimeZone timeZone);

    void skipWhitespace();

    String stringVal();

    int token();

    String tokenName();
}

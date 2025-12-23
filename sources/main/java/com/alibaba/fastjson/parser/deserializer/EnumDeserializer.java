package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i6 = jSONLexer.token();
            if (i6 == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0) {
                    Object[] objArr = this.ordinalEnums;
                    if (intValue <= objArr.length) {
                        return (T) objArr[intValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            }
            if (i6 == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(this.enumClass, stringVal);
            }
            if (i6 == 8) {
                jSONLexer.nextToken(16);
                return null;
            }
            throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
        } catch (JSONException e6) {
            throw e6;
        } catch (Exception e7) {
            throw new JSONException(e7.getMessage(), e7);
        }
    }

    public Enum getEnumByHashCode(long j6) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j6)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    public Enum<?> valueOf(int i6) {
        return this.ordinalEnums[i6];
    }

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.ordinalEnums = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.enumNameHashCodes = new long[enumArr.length];
        int i6 = 0;
        while (true) {
            Enum[] enumArr2 = this.ordinalEnums;
            if (i6 >= enumArr2.length) {
                break;
            }
            long j6 = -2128831035;
            for (int i7 = 0; i7 < enumArr2[i6].name().length(); i7++) {
                j6 = (j6 ^ r3.charAt(i7)) * 16777619;
            }
            jArr[i6] = j6;
            this.enumNameHashCodes[i6] = j6;
            i6++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.ordinalEnums.length];
        for (int i8 = 0; i8 < this.enumNameHashCodes.length; i8++) {
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                }
                if (this.enumNameHashCodes[i8] == jArr[i9]) {
                    this.enums[i8] = this.ordinalEnums[i9];
                    break;
                }
                i9++;
            }
        }
    }
}

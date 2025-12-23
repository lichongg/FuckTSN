package com.alibaba.fastjson;

import androidx.activity.k;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class JSONPath implements JSONAware {
    private static int CACHE_SIZE = 1024;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private ParserConfig parserConfig;
    private final String path;
    private Segement[] segments;
    private SerializeConfig serializeConfig;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ArrayAccessSegement implements Segement {
        private final int index;

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }

        public ArrayAccessSegement(int i6) {
            this.index = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class DoubleOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final double value;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) propertyValue).doubleValue();
            Operator operator = this.op;
            return operator == Operator.EQ ? doubleValue == this.value : operator == Operator.NE ? doubleValue != this.value : operator == Operator.GE ? doubleValue >= this.value : operator == Operator.GT ? doubleValue > this.value : operator == Operator.LE ? doubleValue <= this.value : operator == Operator.LT && doubleValue < this.value;
        }

        public DoubleOpSegement(String str, double d6, Operator operator) {
            this.propertyName = str;
            this.value = d6;
            this.op = operator;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long startValue;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                if (longValue >= this.startValue && longValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }

        public IntBetweenSegement(String str, long j6, long j7, boolean z5) {
            this.propertyName = str;
            this.startValue = j6;
            this.endValue = j7;
            this.not = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long[] values;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                for (long j6 : this.values) {
                    if (j6 == longValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }

        public IntInSegement(String str, long[] jArr, boolean z5) {
            this.propertyName = str;
            this.values = jArr;
            this.not = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final Long[] values;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean z5;
            int i6 = 0;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i6 < length) {
                    if (lArr[i6] == null) {
                        z5 = this.not;
                    } else {
                        i6++;
                    }
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i6 < length2) {
                    Long l6 = lArr2[i6];
                    if (l6 != null && l6.longValue() == longValue) {
                        z5 = this.not;
                    } else {
                        i6++;
                    }
                }
            }
            return this.not;
            return !z5;
        }

        public IntObjInSegement(String str, Long[] lArr, boolean z5) {
            this.propertyName = str;
            this.values = lArr;
            this.not = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long value;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            long longValue = ((Number) propertyValue).longValue();
            Operator operator = this.op;
            return operator == Operator.EQ ? longValue == this.value : operator == Operator.NE ? longValue != this.value : operator == Operator.GE ? longValue >= this.value : operator == Operator.GT ? longValue > this.value : operator == Operator.LE ? longValue <= this.value : operator == Operator.LT && longValue < this.value;
        }

        public IntOpSegement(String str, long j6, Operator operator) {
            this.propertyName = str;
            this.value = j6;
            this.op = operator;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class JSONPathParser {
        private char ch;
        private int level;
        private final String path;
        private int pos;

        static boolean isDigitFirst(char c6) {
            if (c6 == '-' || c6 == '+') {
                return true;
            }
            return c6 >= '0' && c6 <= '9';
        }

        void accept(char c6) {
            if (this.ch == c6) {
                if (isEOF()) {
                    return;
                }
                next();
            } else {
                throw new JSONPathException("expect '" + c6 + ", but '" + this.ch + "'");
            }
        }

        public Segement[] explain() {
            String str = this.path;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            Segement[] segementArr = new Segement[8];
            while (true) {
                Segement readSegement = readSegement();
                if (readSegement == null) {
                    break;
                }
                int i6 = this.level;
                if (i6 == segementArr.length) {
                    Segement[] segementArr2 = new Segement[(i6 * 3) / 2];
                    System.arraycopy(segementArr, 0, segementArr2, 0, i6);
                    segementArr = segementArr2;
                }
                int i7 = this.level;
                this.level = i7 + 1;
                segementArr[i7] = readSegement;
            }
            int i8 = this.level;
            if (i8 == segementArr.length) {
                return segementArr;
            }
            Segement[] segementArr3 = new Segement[i8];
            System.arraycopy(segementArr, 0, segementArr3, 0, i8);
            return segementArr3;
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        void next() {
            String str = this.path;
            int i6 = this.pos;
            this.pos = i6 + 1;
            this.ch = str.charAt(i6);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        
            r0 = r14.pos;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        com.alibaba.fastjson.JSONPath.Segement parseArrayAccess(boolean r15) {
            /*
                Method dump skipped, instructions count: 1126
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.JSONPathParser.parseArrayAccess(boolean):com.alibaba.fastjson.JSONPath$Segement");
        }

        protected double readDoubleValue(long j6) {
            int i6 = this.pos - 1;
            next();
            while (true) {
                char c6 = this.ch;
                if (c6 < '0' || c6 > '9') {
                    break;
                }
                next();
            }
            return Double.parseDouble(this.path.substring(i6, this.pos - 1)) + j6;
        }

        protected long readLongValue() {
            int i6 = this.pos - 1;
            char c6 = this.ch;
            if (c6 == '+' || c6 == '-') {
                next();
            }
            while (true) {
                char c7 = this.ch;
                if (c7 < '0' || c7 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i6, this.pos - 1));
        }

        protected Operator readOp() {
            Operator operator;
            char c6 = this.ch;
            if (c6 == '=') {
                next();
                operator = Operator.EQ;
            } else if (c6 == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c6 == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c6 == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String readName = readName();
            if (!"not".equalsIgnoreCase(readName)) {
                if ("like".equalsIgnoreCase(readName)) {
                    return Operator.LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName)) {
                    return Operator.RLIKE;
                }
                if ("in".equalsIgnoreCase(readName)) {
                    return Operator.IN;
                }
                if ("between".equalsIgnoreCase(readName)) {
                    return Operator.BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            skipWhitespace();
            String readName2 = readName();
            if ("like".equalsIgnoreCase(readName2)) {
                return Operator.NOT_LIKE;
            }
            if ("rlike".equalsIgnoreCase(readName2)) {
                return Operator.NOT_RLIKE;
            }
            if ("in".equalsIgnoreCase(readName2)) {
                return Operator.NOT_IN;
            }
            if ("between".equalsIgnoreCase(readName2)) {
                return Operator.NOT_BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        Segement readSegement() {
            boolean z5 = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegement(this.ch - '0');
                }
                char c6 = this.ch;
                if ((c6 >= 'a' && c6 <= 'z') || (c6 >= 'A' && c6 <= 'Z')) {
                    return new PropertySegement(Character.toString(c6), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c7 = this.ch;
                if (c7 != '$') {
                    if (c7 != '.' && c7 != '/') {
                        if (c7 == '[') {
                            return parseArrayAccess(true);
                        }
                        if (this.level == 0) {
                            return new PropertySegement(readName(), false);
                        }
                        throw new UnsupportedOperationException();
                    }
                    next();
                    if (c7 == '.' && this.ch == '.') {
                        next();
                    } else {
                        z5 = false;
                    }
                    char c8 = this.ch;
                    if (c8 == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return WildCardSegement.instance;
                    }
                    if (isDigitFirst(c8)) {
                        return parseArrayAccess(false);
                    }
                    String readName = readName();
                    if (this.ch != '(') {
                        return new PropertySegement(readName, z5);
                    }
                    next();
                    if (this.ch != ')') {
                        throw new UnsupportedOperationException();
                    }
                    if (!isEOF()) {
                        next();
                    }
                    if ("size".equals(readName)) {
                        return SizeSegement.instance;
                    }
                    throw new UnsupportedOperationException();
                }
                next();
            }
            return null;
        }

        String readString() {
            char c6 = this.ch;
            next();
            int i6 = this.pos - 1;
            while (this.ch != c6 && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i6, isEOF() ? this.pos : this.pos - 1);
            accept(c6);
            return substring;
        }

        public final void skipWhitespace() {
            while (true) {
                char c6 = this.ch;
                if (c6 > ' ') {
                    return;
                }
                if (c6 != ' ' && c6 != '\r' && c6 != '\n' && c6 != '\t' && c6 != '\f' && c6 != '\b') {
                    return;
                } else {
                    next();
                }
            }
        }

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        Segement buildArraySegement(String str) {
            int length = str.length();
            int i6 = 0;
            char charAt = str.charAt(0);
            int i7 = 1;
            int i8 = length - 1;
            char charAt2 = str.charAt(i8);
            int indexOf = str.indexOf(44);
            int i9 = -1;
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                if (indexOf == -1) {
                    return new PropertySegement(str.substring(1, i8), false);
                }
                String[] split = str.split(",");
                String[] strArr = new String[split.length];
                while (i6 < split.length) {
                    String str2 = split[i6];
                    strArr[i6] = str2.substring(1, str2.length() - 1);
                    i6++;
                }
                return new MultiPropertySegement(strArr);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegement(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new PropertySegement(str, false);
                    }
                }
                return new PropertySegement(str, false);
            }
            if (indexOf != -1) {
                String[] split2 = str.split(",");
                int[] iArr = new int[split2.length];
                while (i6 < split2.length) {
                    iArr[i6] = Integer.parseInt(split2[i6]);
                    i6++;
                }
                return new MultiIndexSegement(iArr);
            }
            if (indexOf2 != -1) {
                String[] split3 = str.split(":");
                int length2 = split3.length;
                int[] iArr2 = new int[length2];
                for (int i10 = 0; i10 < split3.length; i10++) {
                    String str3 = split3[i10];
                    if (str3.length() == 0) {
                        if (i10 == 0) {
                            iArr2[i10] = 0;
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        iArr2[i10] = Integer.parseInt(str3);
                    }
                }
                int i11 = iArr2[0];
                if (length2 > 1) {
                    i9 = iArr2[1];
                }
                if (length2 == 3) {
                    i7 = iArr2[2];
                }
                if (i9 >= 0 && i9 < i11) {
                    throw new UnsupportedOperationException("end must greater than or equals start. start " + i11 + ",  end " + i9);
                }
                if (i7 > 0) {
                    return new RangeSegement(i11, i9, i7);
                }
                throw new UnsupportedOperationException("step must greater than zero : " + i7);
            }
            throw new UnsupportedOperationException();
        }

        String readName() {
            skipWhitespace();
            char c6 = this.ch;
            if (c6 != '\\' && !IOUtils.firstIdentifier(c6)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuilder sb = new StringBuilder();
            while (!isEOF()) {
                char c7 = this.ch;
                if (c7 == '\\') {
                    next();
                    sb.append(this.ch);
                    if (isEOF()) {
                        break;
                    }
                    next();
                } else {
                    if (!IOUtils.isIdent(c7)) {
                        break;
                    }
                    sb.append(this.ch);
                    next();
                }
            }
            if (isEOF() && IOUtils.isIdent(this.ch)) {
                sb.append(this.ch);
            }
            return sb.toString();
        }

        protected Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c6 = this.ch;
            if (c6 != '\"' && c6 != '\'') {
                if (c6 == 'n') {
                    if ("null".equals(readName())) {
                        return null;
                    }
                    throw new JSONPathException(this.path);
                }
                throw new UnsupportedOperationException();
            }
            return readString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final String startsWithValue;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i6;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i6 = 0;
            } else {
                if (!obj4.startsWith(str)) {
                    return this.not;
                }
                i6 = this.startsWithValue.length();
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i6);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i6 = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            return (str3 == null || obj4.endsWith(str3)) ? !this.not : this.not;
        }

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z5) {
            int i6;
            this.propertyName = str;
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z5;
            if (str2 != null) {
                i6 = str2.length();
            } else {
                i6 = 0;
            }
            i6 = str3 != null ? i6 + str3.length() : i6;
            if (strArr != null) {
                for (String str4 : strArr) {
                    i6 += str4.length();
                }
            }
            this.minLength = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class MultiIndexSegement implements Segement {
        private final int[] indexes;

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.indexes.length);
            int i6 = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i6 >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getArrayItem(obj2, iArr[i6]));
                i6++;
            }
        }

        public MultiIndexSegement(int[] iArr) {
            this.indexes = iArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class MultiPropertySegement implements Segement {
        private final String[] propertyNames;

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            for (String str : this.propertyNames) {
                arrayList.add(jSONPath.getPropertyValue(obj2, str, true));
            }
            return arrayList;
        }

        public MultiPropertySegement(String[] strArr) {
            this.propertyNames = strArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class NotNullSegement implements Filter {
        private final String propertyName;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, false) != null;
        }

        public NotNullSegement(String str) {
            this.propertyName = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class NullSegement implements Filter {
        private final String propertyName;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, false) == null;
        }

        public NullSegement(String str) {
            this.propertyName = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PropertySegement implements Segement {
        private final boolean deep;
        private final String propertyName;

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValue(obj2, this.propertyName, true);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepScan(obj2, this.propertyName, arrayList);
            return arrayList;
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, obj2);
            }
        }

        public PropertySegement(String str, boolean z5) {
            this.propertyName = str;
            this.deep = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RangeSegement implements Segement {
        private final int end;
        private final int start;
        private final int step;

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegement.instance.eval(jSONPath, obj, obj2).intValue();
            int i6 = this.start;
            if (i6 < 0) {
                i6 += intValue;
            }
            int i7 = this.end;
            if (i7 < 0) {
                i7 += intValue;
            }
            int i8 = ((i7 - i6) / this.step) + 1;
            if (i8 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i8);
            while (i6 <= i7 && i6 < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i6));
                i6 += this.step;
            }
            return arrayList;
        }

        public RangeSegement(int i6, int i7, int i8) {
            this.start = i6;
            this.end = i7;
            this.step = i8;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(propertyValue.toString()).matches();
            return this.not ? !matches : matches;
        }

        public RlikeSegement(String str, String str2, boolean z5) {
            this.propertyName = str;
            this.pattern = Pattern.compile(str2);
            this.not = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Segement {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SizeSegement implements Segement {
        public static final SizeSegement instance = new SizeSegement();

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }

        SizeSegement() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final String[] values;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean z5;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            for (String str : this.values) {
                if (str == propertyValue) {
                    z5 = this.not;
                } else if (str != null && str.equals(propertyValue)) {
                    z5 = this.not;
                }
                return !z5;
            }
            return this.not;
        }

        public StringInSegement(String str, String[] strArr, boolean z5) {
            this.propertyName = str;
            this.values = strArr;
            this.not = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final String value;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            Operator operator = this.op;
            if (operator == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (operator == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareTo = this.value.compareTo(propertyValue.toString());
            Operator operator2 = this.op;
            return operator2 == Operator.GE ? compareTo <= 0 : operator2 == Operator.GT ? compareTo < 0 : operator2 == Operator.LE ? compareTo >= 0 : operator2 == Operator.LT && compareTo > 0;
        }

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.value = str2;
            this.op = operator;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ValueSegment implements Filter {
        private boolean eq;
        private final String propertyName;
        private final Object value;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(jSONPath.getPropertyValue(obj3, this.propertyName, false));
            return !this.eq ? !equals : equals;
        }

        public ValueSegment(String str, Object obj, boolean z5) {
            this.eq = true;
            if (obj != null) {
                this.propertyName = str;
                this.value = obj;
                this.eq = z5;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        int i6 = 0;
        Object obj2 = null;
        Object obj3 = obj;
        int i7 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i7 >= segementArr.length) {
                break;
            }
            if (i7 == segementArr.length - 1) {
                obj2 = obj3;
            }
            obj3 = segementArr[i7].eval(this, obj, obj3);
            i7++;
        }
        if (obj3 == null) {
            throw new JSONPathException("value not found in path " + this.path);
        }
        if (obj3 instanceof Collection) {
            Collection collection = (Collection) obj3;
            int length = objArr.length;
            while (i6 < length) {
                collection.add(objArr[i6]);
                i6++;
            }
            return;
        }
        Class<?> cls = obj3.getClass();
        if (!cls.isArray()) {
            throw new JSONException("unsupported array put operation. " + cls);
        }
        int length2 = Array.getLength(obj3);
        Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
        System.arraycopy(obj3, 0, newInstance, 0, length2);
        while (i6 < objArr.length) {
            Array.set(newInstance, length2 + i6, objArr[i6]);
            i6++;
        }
        Segement segement = this.segments[r8.length - 1];
        if (segement instanceof PropertySegement) {
            ((PropertySegement) segement).setValue(this, obj2, newInstance);
        } else {
            if (!(segement instanceof ArrayAccessSegement)) {
                throw new UnsupportedOperationException();
            }
            ((ArrayAccessSegement) segement).setValue(this, obj2, newInstance);
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i6 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i6 >= segementArr.length) {
                return true;
            }
            obj2 = segementArr[i6].eval(this, obj, obj2);
            if (obj2 == null) {
                return false;
            }
            i6++;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (!(eval instanceof Iterable)) {
            return eq(eval, obj2);
        }
        Iterator it = ((Iterable) eval).iterator();
        while (it.hasNext()) {
            if (eq(it.next(), obj2)) {
                return true;
            }
        }
        return false;
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i6 = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i6 >= segementArr.length) {
                return obj2;
            }
            obj2 = segementArr[i6].eval(this, obj, obj2);
            i6++;
        }
    }

    int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i6++;
                }
            }
            return i6;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e6) {
            throw new JSONPathException("evalSize error : " + this.path, e6);
        }
    }

    protected Object getArrayItem(Object obj, int i6) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i6 >= 0) {
                if (i6 < list.size()) {
                    return list.get(i6);
                }
                return null;
            }
            if (Math.abs(i6) <= list.size()) {
                return list.get(list.size() + i6);
            }
            return null;
        }
        if (!obj.getClass().isArray()) {
            if (!(obj instanceof Map)) {
                throw new UnsupportedOperationException();
            }
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i6));
            return obj2 == null ? map.get(Integer.toString(i6)) : obj2;
        }
        int length = Array.getLength(obj);
        if (i6 >= 0) {
            if (i6 < length) {
                return Array.get(obj, i6);
            }
            return null;
        }
        if (Math.abs(i6) <= length) {
            return Array.get(obj, length + i6);
        }
        return null;
    }

    public boolean remove(Object obj) {
        boolean z5 = false;
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i6 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i6 < segementArr.length) {
                if (i6 == segementArr.length - 1) {
                    break;
                }
                obj2 = segementArr[i6].eval(this, obj, obj2);
                if (obj2 == null) {
                    break;
                }
                i6++;
            } else {
                break;
            }
        }
        obj2 = null;
        if (obj2 == null) {
            return false;
        }
        Segement[] segementArr2 = this.segments;
        Segement segement = segementArr2[segementArr2.length - 1];
        if (!(segement instanceof PropertySegement)) {
            if (segement instanceof ArrayAccessSegement) {
                return ((ArrayAccessSegement) segement).remove(this, obj2);
            }
            throw new UnsupportedOperationException();
        }
        PropertySegement propertySegement = (PropertySegement) segement;
        if ((obj2 instanceof Collection) && segementArr2.length > 1) {
            Segement segement2 = segementArr2[segementArr2.length - 2];
            if ((segement2 instanceof RangeSegement) || (segement2 instanceof MultiIndexSegement)) {
                Iterator it = ((Collection) obj2).iterator();
                while (it.hasNext()) {
                    if (propertySegement.remove(this, it.next())) {
                        z5 = true;
                    }
                }
                return z5;
            }
        }
        return propertySegement.remove(this, obj2);
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i6 = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i6 >= segementArr.length) {
                return evalSize(obj2);
            }
            obj2 = segementArr[i6].eval(this, obj, obj2);
            i6++;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class FilterSegement implements Segement {
        private final Filter filter;

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(obj2 instanceof Iterable)) {
                if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                    jSONArray.add(obj3);
                }
            }
            return jSONArray;
        }

        public FilterSegement(Filter filter) {
            this.filter = filter;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class WildCardSegement implements Segement {
        public static WildCardSegement instance = new WildCardSegement();

        WildCardSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValues(obj2);
        }
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.path = str;
        this.serializeConfig = serializeConfig;
        this.parserConfig = parserConfig;
    }

    public static JSONPath compile(String str) {
        if (str == null) {
            throw new JSONPathException("jsonpath can not be null");
        }
        JSONPath jSONPath = pathCache.get(str);
        if (jSONPath == null) {
            jSONPath = new JSONPath(str);
            if (pathCache.size() < CACHE_SIZE) {
                pathCache.putIfAbsent(str, jSONPath);
                return pathCache.get(str);
            }
        }
        return jSONPath;
    }

    static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (!(obj instanceof Number)) {
            return obj.equals(obj2);
        }
        if (obj2 instanceof Number) {
            return eqNotNull((Number) obj, (Number) obj2);
        }
        return false;
    }

    protected static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        paths(identityHashMap, "/", obj, serializeConfig);
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : identityHashMap.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
        return hashMap;
    }

    protected void deepScan(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                list.add(map.get(str));
                return;
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                deepScan(it.next(), str, list);
            }
            return;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i6 = 0; i6 < list2.size(); i6++) {
                    deepScan(list2.get(i6), str, list);
                }
                return;
            }
            return;
        }
        try {
            FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
            if (fieldSerializer == null) {
                Iterator<Object> it2 = javaBeanSerializer.getFieldValues(obj).iterator();
                while (it2.hasNext()) {
                    deepScan(it2.next(), str, list);
                }
                return;
            }
            try {
                try {
                    list.add(fieldSerializer.getPropertyValueDirect(obj));
                } catch (IllegalAccessException e6) {
                    throw new JSONException("getFieldValue error." + str, e6);
                }
            } catch (InvocationTargetException e7) {
                throw new JSONException("getFieldValue error." + str, e7);
            }
        } catch (Exception e8) {
            throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e8);
        }
    }

    protected void deepSet(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            } else {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    deepSet(it.next(), str, obj2);
                }
                return;
            }
        }
        Class<?> cls = obj.getClass();
        JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
        if (javaBeanDeserializer == null) {
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    deepSet(list.get(i6), str, obj2);
                }
                return;
            }
            return;
        }
        try {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer != null) {
                fieldDeserializer.setValue(obj, obj2);
                return;
            }
            Iterator<Object> it2 = getJavaBeanSerializer(cls).getObjectFieldValues(obj).iterator();
            while (it2.hasNext()) {
                deepSet(it2.next(), str, obj2);
            }
        } catch (Exception e6) {
            throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e6);
        }
    }

    protected JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    protected JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    public String getPath() {
        return this.path;
    }

    protected Object getPropertyValue(Object obj, String str, boolean z5) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            return (obj2 == null && "size".equals(str)) ? Integer.valueOf(map.size()) : obj2;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj, str);
            } catch (Exception e6) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e6);
            }
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if ("size".equals(str)) {
                return Integer.valueOf(list.size());
            }
            JSONArray jSONArray = new JSONArray(list.size());
            for (int i6 = 0; i6 < list.size(); i6++) {
                Object propertyValue = getPropertyValue(list.get(i6), str, z5);
                if (propertyValue instanceof Collection) {
                    jSONArray.addAll((Collection) propertyValue);
                } else {
                    jSONArray.add(propertyValue);
                }
            }
            return jSONArray;
        }
        if (obj instanceof Enum) {
            Enum r7 = (Enum) obj;
            if (CommonNetImpl.NAME.equals(str)) {
                return r7.name();
            }
            if ("ordinal".equals(str)) {
                return Integer.valueOf(r7.ordinal());
            }
        }
        if (obj instanceof Calendar) {
            Calendar calendar = (Calendar) obj;
            if ("year".equals(str)) {
                return Integer.valueOf(calendar.get(1));
            }
            if ("month".equals(str)) {
                return Integer.valueOf(calendar.get(2));
            }
            if ("day".equals(str)) {
                return Integer.valueOf(calendar.get(5));
            }
            if ("hour".equals(str)) {
                return Integer.valueOf(calendar.get(11));
            }
            if ("minute".equals(str)) {
                return Integer.valueOf(calendar.get(12));
            }
            if ("second".equals(str)) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str);
    }

    protected void init() {
        if (this.segments != null) {
            return;
        }
        if ("*".equals(this.path)) {
            this.segments = new Segement[]{WildCardSegement.instance};
        } else {
            this.segments = new JSONPathParser(this.path).explain();
        }
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i6) {
        if (!(obj instanceof List)) {
            throw new JSONPathException("unsupported set operation." + obj.getClass());
        }
        List list = (List) obj;
        if (i6 >= 0) {
            if (i6 >= list.size()) {
                return false;
            }
            list.remove(i6);
            return true;
        }
        int size = list.size() + i6;
        if (size < 0) {
            return false;
        }
        list.remove(size);
        return true;
    }

    protected boolean removePropertyValue(Object obj, String str) {
        if (obj instanceof Map) {
            return ((Map) obj).remove(str) != null;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer == null) {
            throw new UnsupportedOperationException();
        }
        FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            return false;
        }
        fieldDeserializer.setValue(obj, (String) null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean set(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            r8 = this;
            r11 = 0
            if (r9 != 0) goto L4
            return r11
        L4:
            r8.init()
            r0 = 0
            r2 = r9
            r3 = r0
            r1 = 0
        Lb:
            com.alibaba.fastjson.JSONPath$Segement[] r4 = r8.segments
            int r5 = r4.length
            r6 = 1
            if (r1 >= r5) goto L86
            r3 = r4[r1]
            java.lang.Object r4 = r3.eval(r8, r9, r2)
            if (r4 != 0) goto L81
            com.alibaba.fastjson.JSONPath$Segement[] r4 = r8.segments
            int r5 = r4.length
            int r5 = r5 - r6
            if (r1 >= r5) goto L24
            int r5 = r1 + 1
            r4 = r4[r5]
            goto L25
        L24:
            r4 = r0
        L25:
            boolean r5 = r4 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r5 == 0) goto L61
            boolean r4 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r4 == 0) goto L4b
            r4 = r3
            com.alibaba.fastjson.JSONPath$PropertySegement r4 = (com.alibaba.fastjson.JSONPath.PropertySegement) r4
            java.lang.String r4 = com.alibaba.fastjson.JSONPath.PropertySegement.access$000(r4)
            java.lang.Class r5 = r2.getClass()
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r5)
            if (r5 == 0) goto L4b
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r5.getFieldDeserializer(r4)
            com.alibaba.fastjson.util.FieldInfo r4 = r4.fieldInfo
            java.lang.Class<?> r4 = r4.fieldClass
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r4)
            goto L4d
        L4b:
            r4 = r0
            r5 = r4
        L4d:
            if (r5 == 0) goto L5b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r5.beanInfo
            java.lang.reflect.Constructor<?> r7 = r7.defaultConstructor
            if (r7 == 0) goto L5a
            java.lang.Object r4 = r5.createInstance(r0, r4)
            goto L6c
        L5a:
            return r11
        L5b:
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
            r4.<init>()
            goto L6c
        L61:
            boolean r4 = r4 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegement
            if (r4 == 0) goto L6b
            com.alibaba.fastjson.JSONArray r4 = new com.alibaba.fastjson.JSONArray
            r4.<init>()
            goto L6c
        L6b:
            r4 = r0
        L6c:
            if (r4 == 0) goto L87
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r5 == 0) goto L78
            com.alibaba.fastjson.JSONPath$PropertySegement r3 = (com.alibaba.fastjson.JSONPath.PropertySegement) r3
            r3.setValue(r8, r2, r4)
            goto L81
        L78:
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegement
            if (r5 == 0) goto L87
            com.alibaba.fastjson.JSONPath$ArrayAccessSegement r3 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegement) r3
            r3.setValue(r8, r2, r4)
        L81:
            int r1 = r1 + 1
            r3 = r2
            r2 = r4
            goto Lb
        L86:
            r2 = r3
        L87:
            if (r2 != 0) goto L8a
            return r11
        L8a:
            com.alibaba.fastjson.JSONPath$Segement[] r9 = r8.segments
            int r11 = r9.length
            int r11 = r11 - r6
            r9 = r9[r11]
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r11 == 0) goto L9a
            com.alibaba.fastjson.JSONPath$PropertySegement r9 = (com.alibaba.fastjson.JSONPath.PropertySegement) r9
            r9.setValue(r8, r2, r10)
            return r6
        L9a:
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegement
            if (r11 == 0) goto La5
            com.alibaba.fastjson.JSONPath$ArrayAccessSegement r9 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegement) r9
            boolean r9 = r9.setValue(r8, r2, r10)
            return r9
        La5:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.set(java.lang.Object, java.lang.Object, boolean):boolean");
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i6, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i6 >= 0) {
                list.set(i6, obj2);
            } else {
                list.set(list.size() + i6, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            throw new JSONPathException("unsupported set operation." + cls);
        }
        int length = Array.getLength(obj);
        if (i6 >= 0) {
            if (i6 < length) {
                Array.set(obj, i6, obj2);
            }
        } else if (Math.abs(i6) <= length) {
            Array.set(obj, length + i6, obj2);
        }
        return true;
    }

    protected boolean setPropertyValue(Object obj, String str, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        }
        if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, obj2);
                }
            }
            return true;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer == null) {
            throw new UnsupportedOperationException();
        }
        FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            return false;
        }
        fieldDeserializer.setValue(obj, obj2);
        return true;
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean isInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (isInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(number2.longValue()));
            }
        }
        if (isInt) {
            if (isInt2) {
                if (number.longValue() == number2.longValue()) {
                    return true;
                }
                return false;
            }
            if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (isInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(number2.longValue()));
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        if (((isDouble && isDouble2) || ((isDouble && isInt2) || (isDouble2 && isInt))) && number.doubleValue() == number2.doubleValue()) {
            return true;
        }
        return false;
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    protected Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e6) {
                throw new JSONPathException("jsonpath error, path " + this.path, e6);
            }
        }
        if (obj instanceof Map) {
            return ((Map) obj).values();
        }
        throw new UnsupportedOperationException();
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    private static void paths(Map<Object, String> map, String str, Object obj, SerializeConfig serializeConfig) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj == null || map.containsKey(obj)) {
            return;
        }
        map.put(obj, str);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals("/")) {
                        sb4 = new StringBuilder();
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(str);
                    }
                    sb4.append("/");
                    sb4.append(key);
                    paths(map, sb4.toString(), entry.getValue(), serializeConfig);
                }
            }
            return;
        }
        int i6 = 0;
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals("/")) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append("/");
                sb3.append(i6);
                paths(map, sb3.toString(), obj2, serializeConfig);
                i6++;
            }
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            while (i6 < length) {
                Object obj3 = Array.get(obj, i6);
                if (str.equals("/")) {
                    sb2 = new StringBuilder();
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str);
                }
                sb2.append("/");
                sb2.append(i6);
                paths(map, sb2.toString(), obj3, serializeConfig);
                i6++;
            }
            return;
        }
        if (ParserConfig.isPrimitive2(cls) || cls.isEnum()) {
            return;
        }
        ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            try {
                for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                    String key2 = entry2.getKey();
                    if (k.a(key2)) {
                        if (str.equals("/")) {
                            sb = new StringBuilder();
                            sb.append("/");
                        } else {
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("/");
                        }
                        sb.append(key2);
                        paths(map, sb.toString(), entry2.getValue(), serializeConfig);
                    }
                }
            } catch (Exception e6) {
                throw new JSONException("toJSON error", e6);
            }
        }
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }
}

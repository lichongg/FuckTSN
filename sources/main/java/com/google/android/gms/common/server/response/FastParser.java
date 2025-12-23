package com.google.android.gms.common.server.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import okio.internal.Buffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ShowFirstParty
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', '\"'};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaf = {'\n'};
    private static final zai zag = new zaa();
    private static final zai zah = new zab();
    private static final zai zai = new zac();
    private static final zai zaj = new zad();
    private static final zai zak = new zae();
    private static final zai zal = new zaf();
    private static final zai zam = new zag();
    private static final zai zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack zat = new Stack();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(@NonNull Throwable th) {
            super(th);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @Nullable char[] cArr2) throws ParseException, IOException {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z5 = false;
        boolean z6 = false;
        loop0: while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            int i6 = 0;
            while (i6 < read) {
                char c6 = cArr[i6];
                if (!Character.isISOControl(c6) || (cArr2 != null && cArr2[0] == c6)) {
                    int i7 = i6 + 1;
                    if (c6 == '\"') {
                        if (!z5) {
                            sb.append(cArr, 0, i6);
                            bufferedReader.reset();
                            bufferedReader.skip(i7);
                            return z6 ? JsonUtils.unescapeString(sb.toString()) : sb.toString();
                        }
                    } else if (c6 == '\\') {
                        z5 = !z5;
                        z6 = true;
                        i6 = i7;
                    }
                    z5 = false;
                    i6 = i7;
                }
            }
            sb.append(cArr, 0, read);
            bufferedReader.mark(cArr.length);
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i6 = 0;
        while (true) {
            int length = cArr.length;
            if (i6 >= length) {
                return;
            }
            int read = bufferedReader.read(this.zap, 0, length - i6);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i7 = 0; i7 < read; i7++) {
                if (cArr[i7 + i6] != this.zap[i7]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i6 += read;
        }
    }

    private final char zai(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zao) != -1) {
            while (Character.isWhitespace(this.zao[0])) {
                if (bufferedReader.read(this.zao) == -1) {
                }
            }
            return this.zao[0];
        }
        return (char) 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) throws ParseException, IOException {
        int i6;
        int i7;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c6 = cArr[0];
        int i8 = c6 == '-' ? Integer.MIN_VALUE : -2147483647;
        int i9 = c6 == '-' ? 1 : 0;
        if (i9 < zam2) {
            i6 = i9 + 1;
            int digit = Character.digit(cArr[i9], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i7 = -digit;
        } else {
            i6 = i9;
            i7 = 0;
        }
        while (i6 < zam2) {
            int i10 = i6 + 1;
            int digit2 = Character.digit(cArr[i6], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i7 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i11 = i7 * 10;
            if (i11 < i8 + digit2) {
                throw new ParseException("Number too large");
            }
            i7 = i11 - digit2;
            i6 = i10;
        }
        if (i9 == 0) {
            return -i7;
        }
        if (i6 > 1) {
            return i7;
        }
        throw new ParseException("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) throws ParseException, IOException {
        long j6;
        int i6;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0L;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c6 = cArr[0];
        long j7 = c6 == '-' ? Long.MIN_VALUE : -9223372036854775807L;
        int i7 = c6 == '-' ? 1 : 0;
        if (i7 < zam2) {
            i6 = i7 + 1;
            int digit = Character.digit(cArr[i7], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j6 = -digit;
        } else {
            j6 = 0;
            i6 = i7;
        }
        while (i6 < zam2) {
            int i8 = i6 + 1;
            int digit2 = Character.digit(cArr[i6], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j6 < Buffer.OVERFLOW_ZONE) {
                throw new ParseException("Number too large");
            }
            long j8 = j6 * 10;
            long j9 = digit2;
            if (j8 < j7 + j9) {
                throw new ParseException("Number too large");
            }
            j6 = j8 - j9;
            i6 = i8;
        }
        if (i7 == 0) {
            return -j6;
        }
        if (i6 > 1) {
            return j6;
        }
        throw new ParseException("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final String zao(BufferedReader bufferedReader) throws ParseException, IOException {
        return zap(bufferedReader, this.zap, this.zar, null);
    }

    @Nullable
    @ResultIgnorabilityUnspecified
    private final String zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        }
        if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        }
        if (zai2 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token: " + zai2);
    }

    @Nullable
    private final String zar(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char zai2 = zai(bufferedReader);
        int i6 = 1;
        if (zai2 == '\"') {
            if (bufferedReader.read(this.zao) == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            char c6 = this.zao[0];
            boolean z5 = false;
            do {
                if (c6 == '\"') {
                    if (z5) {
                        c6 = '\"';
                        z5 = true;
                    }
                }
                z5 = c6 == '\\' ? !z5 : false;
                if (bufferedReader.read(this.zao) == -1) {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
                c6 = this.zao[0];
            } while (!Character.isISOControl(c6));
            throw new ParseException("Unexpected control character while reading string");
        }
        if (zai2 == ',') {
            throw new ParseException("Missing value");
        }
        if (zai2 == '[') {
            this.zat.push(5);
            bufferedReader.mark(32);
            if (zai(bufferedReader) != ']') {
                bufferedReader.reset();
                boolean z6 = false;
                loop1: while (true) {
                    boolean z7 = false;
                    while (i6 > 0) {
                        char zai3 = zai(bufferedReader);
                        if (zai3 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                        if (Character.isISOControl(zai3)) {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                        if (zai3 == '\"') {
                            if (!z7) {
                                z6 = !z6;
                            }
                            zai3 = '\"';
                        }
                        if (zai3 == '[') {
                            if (!z6) {
                                i6++;
                            }
                            zai3 = '[';
                        }
                        if (zai3 == ']' && !z6) {
                            i6--;
                        }
                        if (zai3 == '\\' && z6) {
                            z7 = !z7;
                        }
                    }
                    zaw(5);
                    break loop1;
                }
            } else {
                zaw(5);
            }
        } else if (zai2 != '{') {
            bufferedReader.reset();
            zam(bufferedReader, this.zaq);
        } else {
            this.zat.push(1);
            bufferedReader.mark(32);
            char zai4 = zai(bufferedReader);
            if (zai4 == '}') {
                zaw(1);
            } else {
                if (zai4 != '\"') {
                    throw new ParseException("Unexpected token " + zai4);
                }
                bufferedReader.reset();
                zaq(bufferedReader);
                while (zar(bufferedReader) != null) {
                }
                zaw(1);
            }
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        }
        if (zai5 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token " + zai5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final BigDecimal zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final BigInteger zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    @Nullable
    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) throws ParseException, IOException {
        ArrayList arrayList = new ArrayList();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        }
        if (zai2 != '{') {
            throw new ParseException("Unexpected token: " + zai2);
        }
        this.zat.push(1);
        while (true) {
            try {
                FastJsonResponse zad2 = field.zad();
                if (!zaz(bufferedReader, zad2)) {
                    return arrayList;
                }
                arrayList.add(zad2);
                char zai3 = zai(bufferedReader);
                if (zai3 != ',') {
                    if (zai3 == ']') {
                        zaw(5);
                        return arrayList;
                    }
                    throw new ParseException("Unexpected token: " + zai3);
                }
                if (zai(bufferedReader) != '{') {
                    throw new ParseException("Expected start of next object in array");
                }
                this.zat.push(1);
            } catch (IllegalAccessException e6) {
                throw new ParseException("Error instantiating inner object", e6);
            } catch (InstantiationException e7) {
                throw new ParseException("Error instantiating inner object", e7);
            }
        }
    }

    private final void zaw(int i6) throws ParseException {
        if (this.zat.isEmpty()) {
            throw new ParseException("Expected state " + i6 + " but had empty stack");
        }
        int intValue = ((Integer) this.zat.pop()).intValue();
        if (intValue == i6) {
            return;
        }
        throw new ParseException("Expected state " + i6 + " but had " + intValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ResultIgnorabilityUnspecified
    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq = zaq(bufferedReader);
        if (zaq == null) {
            zaw(1);
            return false;
        }
        while (zaq != null) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(zaq);
            if (field == null) {
                zaq = zar(bufferedReader);
            } else {
                this.zat.push(4);
                int i6 = field.zaa;
                switch (i6) {
                    case 0:
                        if (!field.zab) {
                            fastJsonResponse.zau(field, zal(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zav(field, zau(bufferedReader, zag));
                            break;
                        }
                    case 1:
                        if (!field.zab) {
                            fastJsonResponse.zae(field, zat(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zag(field, zau(bufferedReader, zam));
                            break;
                        }
                    case 2:
                        if (!field.zab) {
                            fastJsonResponse.zax(field, zan(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zay(field, zau(bufferedReader, zah));
                            break;
                        }
                    case 3:
                        if (!field.zab) {
                            fastJsonResponse.zaq(field, zak(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zas(field, zau(bufferedReader, zai));
                            break;
                        }
                    case 4:
                        if (!field.zab) {
                            fastJsonResponse.zam(field, zaj(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zao(field, zau(bufferedReader, zaj));
                            break;
                        }
                    case 5:
                        if (!field.zab) {
                            fastJsonResponse.zaa(field, zas(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zac(field, zau(bufferedReader, zan));
                            break;
                        }
                    case 6:
                        if (!field.zab) {
                            fastJsonResponse.zai(field, zay(bufferedReader, false));
                            break;
                        } else {
                            fastJsonResponse.zaj(field, zau(bufferedReader, zak));
                            break;
                        }
                    case 7:
                        if (!field.zab) {
                            fastJsonResponse.zaA(field, zao(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zaC(field, zau(bufferedReader, zal));
                            break;
                        }
                    case 8:
                        fastJsonResponse.zal(field, Base64Utils.decode(zap(bufferedReader, this.zaq, this.zas, zaf)));
                        break;
                    case 9:
                        fastJsonResponse.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader, this.zaq, this.zas, zaf)));
                        break;
                    case 10:
                        char zai2 = zai(bufferedReader);
                        if (zai2 == 'n') {
                            zax(bufferedReader, zaa);
                            hashMap = null;
                        } else {
                            if (zai2 != '{') {
                                throw new ParseException("Expected start of a map object");
                            }
                            this.zat.push(1);
                            hashMap = new HashMap();
                            while (true) {
                                char zai3 = zai(bufferedReader);
                                if (zai3 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                }
                                if (zai3 == '\"') {
                                    String zaA = zaA(bufferedReader, this.zap, this.zar, null);
                                    if (zai(bufferedReader) != ':') {
                                        throw new ParseException("No map value found for key ".concat(String.valueOf(zaA)));
                                    }
                                    if (zai(bufferedReader) != '\"') {
                                        throw new ParseException("Expected String value for key ".concat(String.valueOf(zaA)));
                                    }
                                    hashMap.put(zaA, zaA(bufferedReader, this.zap, this.zar, null));
                                    char zai4 = zai(bufferedReader);
                                    if (zai4 != ',') {
                                        if (zai4 != '}') {
                                            throw new ParseException("Unexpected character while parsing string map: " + zai4);
                                        }
                                        zaw(1);
                                    }
                                } else if (zai3 == '}') {
                                    zaw(1);
                                }
                            }
                        }
                        fastJsonResponse.zaB(field, hashMap);
                        break;
                    case 11:
                        if (field.zab) {
                            char zai5 = zai(bufferedReader);
                            if (zai5 == 'n') {
                                zax(bufferedReader, zaa);
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                break;
                            } else {
                                this.zat.push(5);
                                if (zai5 != '[') {
                                    throw new ParseException("Expected array start");
                                }
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                                break;
                            }
                        } else {
                            char zai6 = zai(bufferedReader);
                            if (zai6 == 'n') {
                                zax(bufferedReader, zaa);
                                fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                break;
                            } else {
                                this.zat.push(1);
                                if (zai6 != '{') {
                                    throw new ParseException("Expected start of object");
                                }
                                try {
                                    FastJsonResponse zad2 = field.zad();
                                    zaz(bufferedReader, zad2);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, zad2);
                                    break;
                                } catch (IllegalAccessException e6) {
                                    throw new ParseException("Error instantiating inner object", e6);
                                } catch (InstantiationException e7) {
                                    throw new ParseException("Error instantiating inner object", e7);
                                }
                            }
                        }
                    default:
                        throw new ParseException("Invalid field type " + i6);
                }
                zaw(4);
                zaw(2);
                char zai7 = zai(bufferedReader);
                if (zai7 == ',') {
                    zaq = zaq(bufferedReader);
                } else {
                    if (zai7 != '}') {
                        throw new ParseException("Expected end of object or field separator, but found: " + zai7);
                    }
                    zaq = null;
                }
            }
        }
        zaw(1);
        return true;
    }

    @KeepForSdk
    public void parse(@NonNull InputStream inputStream, @NonNull T t5) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.zat.push(0);
                char zai2 = zai(bufferedReader);
                if (zai2 == 0) {
                    throw new ParseException("No data to parse");
                }
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t5.getFieldMappings();
                    if (fieldMappings.size() != 1) {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                    t5.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                } else {
                    if (zai2 != '{') {
                        throw new ParseException("Unexpected token: " + zai2);
                    }
                    this.zat.push(1);
                    zaz(bufferedReader, t5);
                }
                zaw(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
            } catch (IOException e6) {
                throw new ParseException(e6);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    @ResultIgnorabilityUnspecified
    private final int zam(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i6;
        char zai2 = zai(bufferedReader);
        if (zai2 != 0) {
            if (zai2 != ',') {
                if (zai2 == 'n') {
                    zax(bufferedReader, zaa);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (zai2 == '\"') {
                    i6 = 0;
                    boolean z5 = false;
                    while (i6 < 1024 && bufferedReader.read(cArr, i6, 1) != -1) {
                        char c6 = cArr[i6];
                        if (!Character.isISOControl(c6)) {
                            int i7 = i6 + 1;
                            if (c6 == '\"') {
                                if (!z5) {
                                    bufferedReader.reset();
                                    bufferedReader.skip(i7);
                                    return i6;
                                }
                            } else if (c6 == '\\') {
                                z5 = !z5;
                                i6 = i7;
                            }
                            z5 = false;
                            i6 = i7;
                        } else {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                } else {
                    cArr[0] = zai2;
                    i6 = 1;
                    while (i6 < 1024 && bufferedReader.read(cArr, i6, 1) != -1) {
                        char c7 = cArr[i6];
                        if (c7 != '}' && c7 != ',' && !Character.isWhitespace(c7) && cArr[i6] != ']') {
                            i6++;
                        } else {
                            bufferedReader.reset();
                            bufferedReader.skip(i6 - 1);
                            cArr[i6] = 0;
                            return i6;
                        }
                    }
                }
                if (i6 == 1024) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    @Nullable
    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @Nullable char[] cArr2) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 != '\"') {
            if (zai2 == 'n') {
                zax(bufferedReader, zaa);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return zaA(bufferedReader, cArr, sb, cArr2);
    }

    @Nullable
    private final ArrayList zau(BufferedReader bufferedReader, zai zaiVar) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        if (zai2 == '[') {
            this.zat.push(5);
            ArrayList arrayList = new ArrayList();
            while (true) {
                bufferedReader.mark(1024);
                char zai3 = zai(bufferedReader);
                if (zai3 != 0) {
                    if (zai3 != ',') {
                        if (zai3 != ']') {
                            bufferedReader.reset();
                            arrayList.add(zaiVar.zaa(this, bufferedReader));
                        } else {
                            zaw(5);
                            return arrayList;
                        }
                    }
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z5) throws ParseException, IOException {
        char[] cArr;
        char[] cArr2;
        char zai2 = zai(bufferedReader);
        if (zai2 != '\"') {
            if (zai2 != 'f') {
                if (zai2 != 'n') {
                    if (zai2 == 't') {
                        if (z5) {
                            cArr2 = zac;
                        } else {
                            cArr2 = zab;
                        }
                        zax(bufferedReader, cArr2);
                        return true;
                    }
                    throw new ParseException("Unexpected token: " + zai2);
                }
                zax(bufferedReader, zaa);
                return false;
            }
            if (z5) {
                cArr = zae;
            } else {
                cArr = zad;
            }
            zax(bufferedReader, cArr);
            return false;
        }
        if (!z5) {
            return zay(bufferedReader, true);
        }
        throw new ParseException("No boolean value found in string");
    }
}

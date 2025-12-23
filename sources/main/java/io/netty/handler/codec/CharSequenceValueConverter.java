package io.netty.handler.codec;

import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.text.ParseException;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CharSequenceValueConverter implements ValueConverter<CharSequence> {
    public static final CharSequenceValueConverter INSTANCE = new CharSequenceValueConverter();
    private static final AsciiString TRUE_ASCII = new AsciiString("true");

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertBoolean(boolean z5) {
        return String.valueOf(z5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertByte(byte b6) {
        return String.valueOf((int) b6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertChar(char c6) {
        return String.valueOf(c6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertDouble(double d6) {
        return String.valueOf(d6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertFloat(float f6) {
        return String.valueOf(f6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertInt(int i6) {
        return String.valueOf(i6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertLong(long j6) {
        return String.valueOf(j6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertObject(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertShort(short s5) {
        return String.valueOf((int) s5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.ValueConverter
    public CharSequence convertTimeMillis(long j6) {
        return DateFormatter.format(new Date(j6));
    }

    @Override // io.netty.handler.codec.ValueConverter
    public boolean convertToBoolean(CharSequence charSequence) {
        return AsciiString.contentEqualsIgnoreCase(charSequence, TRUE_ASCII);
    }

    @Override // io.netty.handler.codec.ValueConverter
    public byte convertToByte(CharSequence charSequence) {
        return ((charSequence instanceof AsciiString) && charSequence.length() == 1) ? ((AsciiString) charSequence).byteAt(0) : Byte.parseByte(charSequence.toString());
    }

    @Override // io.netty.handler.codec.ValueConverter
    public char convertToChar(CharSequence charSequence) {
        return charSequence.charAt(0);
    }

    @Override // io.netty.handler.codec.ValueConverter
    public double convertToDouble(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? ((AsciiString) charSequence).parseDouble() : Double.parseDouble(charSequence.toString());
    }

    @Override // io.netty.handler.codec.ValueConverter
    public float convertToFloat(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? ((AsciiString) charSequence).parseFloat() : Float.parseFloat(charSequence.toString());
    }

    @Override // io.netty.handler.codec.ValueConverter
    public int convertToInt(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? ((AsciiString) charSequence).parseInt() : Integer.parseInt(charSequence.toString());
    }

    @Override // io.netty.handler.codec.ValueConverter
    public long convertToLong(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? ((AsciiString) charSequence).parseLong() : Long.parseLong(charSequence.toString());
    }

    @Override // io.netty.handler.codec.ValueConverter
    public short convertToShort(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? ((AsciiString) charSequence).parseShort() : Short.parseShort(charSequence.toString());
    }

    @Override // io.netty.handler.codec.ValueConverter
    public long convertToTimeMillis(CharSequence charSequence) {
        Date parseHttpDate = DateFormatter.parseHttpDate(charSequence);
        if (parseHttpDate != null) {
            return parseHttpDate.getTime();
        }
        PlatformDependent.throwException(new ParseException("header can't be parsed into a Date: " + ((Object) charSequence), 0));
        return 0L;
    }
}

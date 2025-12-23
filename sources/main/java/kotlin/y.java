package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class y extends x {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger F(int i6) {
        BigInteger valueOf = BigInteger.valueOf(i6);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger A(BigInteger bigInteger, int i6) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        BigInteger shiftRight = bigInteger.shiftRight(i6);
        kotlin.jvm.internal.g0.o(shiftRight, "shiftRight(...)");
        return shiftRight;
    }

    @InlineOnly
    private static final BigInteger B(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger multiply = bigInteger.multiply(other);
        kotlin.jvm.internal.g0.o(multiply, "multiply(...)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal C(BigInteger bigInteger) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal D(BigInteger bigInteger, int i6, MathContext mathContext) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i6, mathContext);
    }

    static /* synthetic */ BigDecimal E(BigInteger bigInteger, int i6, MathContext mathContext, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        if ((i7 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            kotlin.jvm.internal.g0.o(mathContext, "UNLIMITED");
        }
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i6, mathContext);
    }

    @InlineOnly
    private static final BigInteger H(BigInteger bigInteger) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        BigInteger negate = bigInteger.negate();
        kotlin.jvm.internal.g0.o(negate, "negate(...)");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger I(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger xor = bigInteger.xor(other);
        kotlin.jvm.internal.g0.o(xor, "xor(...)");
        return xor;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger q(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger and = bigInteger.and(other);
        kotlin.jvm.internal.g0.o(and, "and(...)");
        return and;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger r(BigInteger bigInteger) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        kotlin.jvm.internal.g0.o(subtract, "subtract(...)");
        return subtract;
    }

    @InlineOnly
    private static final BigInteger s(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger divide = bigInteger.divide(other);
        kotlin.jvm.internal.g0.o(divide, "divide(...)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger t(BigInteger bigInteger) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        kotlin.jvm.internal.g0.o(add, "add(...)");
        return add;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger u(BigInteger bigInteger) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        BigInteger not = bigInteger.not();
        kotlin.jvm.internal.g0.o(not, "not(...)");
        return not;
    }

    @InlineOnly
    private static final BigInteger v(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger subtract = bigInteger.subtract(other);
        kotlin.jvm.internal.g0.o(subtract, "subtract(...)");
        return subtract;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger w(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger or = bigInteger.or(other);
        kotlin.jvm.internal.g0.o(or, "or(...)");
        return or;
    }

    @InlineOnly
    private static final BigInteger x(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger add = bigInteger.add(other);
        kotlin.jvm.internal.g0.o(add, "add(...)");
        return add;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final BigInteger y(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigInteger remainder = bigInteger.remainder(other);
        kotlin.jvm.internal.g0.o(remainder, "remainder(...)");
        return remainder;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger z(BigInteger bigInteger, int i6) {
        kotlin.jvm.internal.g0.p(bigInteger, "<this>");
        BigInteger shiftLeft = bigInteger.shiftLeft(i6);
        kotlin.jvm.internal.g0.o(shiftLeft, "shiftLeft(...)");
        return shiftLeft;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger G(long j6) {
        BigInteger valueOf = BigInteger.valueOf(j6);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        return valueOf;
    }
}

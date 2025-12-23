package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class x {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal l(int i6) {
        BigDecimal valueOf = BigDecimal.valueOf(i6);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal a(BigDecimal bigDecimal) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        kotlin.jvm.internal.g0.o(subtract, "subtract(...)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal b(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigDecimal divide = bigDecimal.divide(other, RoundingMode.HALF_EVEN);
        kotlin.jvm.internal.g0.o(divide, "divide(...)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal c(BigDecimal bigDecimal) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        kotlin.jvm.internal.g0.o(add, "add(...)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal d(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigDecimal subtract = bigDecimal.subtract(other);
        kotlin.jvm.internal.g0.o(subtract, "subtract(...)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal e(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigDecimal add = bigDecimal.add(other);
        kotlin.jvm.internal.g0.o(add, "add(...)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal f(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigDecimal remainder = bigDecimal.remainder(other);
        kotlin.jvm.internal.g0.o(remainder, "remainder(...)");
        return remainder;
    }

    @InlineOnly
    private static final BigDecimal g(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        BigDecimal multiply = bigDecimal.multiply(other);
        kotlin.jvm.internal.g0.o(multiply, "multiply(...)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal h(double d6) {
        return new BigDecimal(String.valueOf(d6));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal i(double d6, MathContext mathContext) {
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d6), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal j(float f6) {
        return new BigDecimal(String.valueOf(f6));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal k(float f6, MathContext mathContext) {
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f6), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal m(int i6, MathContext mathContext) {
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        return new BigDecimal(i6, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal o(long j6, MathContext mathContext) {
        kotlin.jvm.internal.g0.p(mathContext, "mathContext");
        return new BigDecimal(j6, mathContext);
    }

    @InlineOnly
    private static final BigDecimal p(BigDecimal bigDecimal) {
        kotlin.jvm.internal.g0.p(bigDecimal, "<this>");
        BigDecimal negate = bigDecimal.negate();
        kotlin.jvm.internal.g0.o(negate, "negate(...)");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal n(long j6) {
        BigDecimal valueOf = BigDecimal.valueOf(j6);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        return valueOf;
    }
}

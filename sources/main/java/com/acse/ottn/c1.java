package com.acse.ottn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c1 implements m4<Number> {
    @Override // com.acse.ottn.m4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f6, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f6 * (number2.floatValue() - floatValue)));
    }
}

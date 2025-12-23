package com.github.aachartmodel.aainfographics.aachartcreator;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public enum AAChartAnimationType {
    Linear("Linear"),
    EaseInQuad("easeInQuad"),
    EaseOutQuad("easeOutQuad"),
    EaseInOutQuad("easeInOutQuad"),
    EaseInCubic("easeInCubic"),
    EaseOutCubic("easeOutCubic"),
    EaseInOutCubic("easeInOutCubic"),
    EaseInQuart("easeInQuart"),
    EaseOutQuart("easeOutQuart"),
    EaseInOutQuart("easeInOutQuart"),
    EaseInQuint("easeInQuint"),
    EaseOutQuint("easeOutQuint"),
    EaseInOutQuint("easeInOutQuint"),
    EaseInSine("easeInSine"),
    EaseOutSine("easeOutSine"),
    EaseInOutSine("easeInOutSine"),
    EaseInExpo("easeInExpo"),
    EaseOutExpo("easeOutExpo"),
    EaseInOutExpo("easeInOutExpo"),
    EaseInCirc("easeInCirc"),
    EaseOutCirc("easeOutCirc"),
    EaseInOutCirc("easeInOutCirc"),
    EaseOutBounce("easeOutBounce"),
    EaseInBack("easeInBack"),
    EaseOutBack("easeOutBack"),
    EaseInOutBack("easeInOutBack"),
    Elastic("elastic"),
    SwingFromTo("swingFromTo"),
    SwingFrom("swingFrom"),
    SwingTo("swingTo"),
    Bounce("bounce"),
    BouncePast("bouncePast"),
    EaseFromTo("easeFromTo"),
    EaseFrom("easeFrom"),
    EaseTo("easeTo");


    @NotNull
    private final String value;

    @NotNull
    public final String getValue() {
        return this.value;
    }

    AAChartAnimationType(String str) {
        this.value = str;
    }
}

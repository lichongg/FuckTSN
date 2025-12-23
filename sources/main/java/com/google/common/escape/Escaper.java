package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class Escaper {
    private final Function<String, String> asFunction = new Function<String, String>() { // from class: com.google.common.escape.Escaper.1
        @Override // com.google.common.base.Function
        public String apply(String str) {
            return Escaper.this.escape(str);
        }
    };

    public abstract String escape(String str);

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }

    protected Escaper() {
    }
}

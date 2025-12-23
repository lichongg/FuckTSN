package com.kwad.sdk.components;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ComponentsNotFoundException extends IllegalStateException {
    private static final String MESSAGE = "组件未集成/未加载，如需要该部分的功能，请集成后重试";
    private static final long serialVersionUID = -2648461538415997941L;

    public ComponentsNotFoundException(String str) {
        this(str, null);
    }

    public ComponentsNotFoundException(String str, Throwable th) {
        super(str + MESSAGE, th);
    }
}

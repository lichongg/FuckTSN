package com.kwad.sdk.components;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface DevelopMangerComponents extends b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DevelopValue implements Serializable {
        private static final long serialVersionUID = 2793333073373146040L;
        Serializable mValue;

        public <T> T getValue() {
            T t5 = (T) this.mValue;
            if (t5 != null) {
                return t5;
            }
            return null;
        }

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }
    }

    String Ei();
}

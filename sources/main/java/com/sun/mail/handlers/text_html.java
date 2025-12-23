package com.sun.mail.handlers;

import javax.activation.ActivationDataFlavor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class text_html extends text_plain {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(String.class, "text/html", "HTML String");

    @Override // com.sun.mail.handlers.text_plain
    protected ActivationDataFlavor getDF() {
        return myDF;
    }
}

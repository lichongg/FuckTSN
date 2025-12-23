package com.google.common.xml;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import io.netty.util.internal.StringUtil;
import kotlin.text.v0;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public class XmlEscapers {
    private static final char MAX_ASCII_CONTROL_CHAR = 31;
    private static final char MIN_ASCII_CONTROL_CHAR = 0;
    private static final Escaper XML_ATTRIBUTE_ESCAPER;
    private static final Escaper XML_CONTENT_ESCAPER;
    private static final Escaper XML_ESCAPER;

    public static Escaper xmlAttributeEscaper() {
        return XML_ATTRIBUTE_ESCAPER;
    }

    public static Escaper xmlContentEscaper() {
        return XML_CONTENT_ESCAPER;
    }

    static {
        Escapers.Builder builder = Escapers.builder();
        builder.setSafeRange((char) 0, Utf8.REPLACEMENT_CHARACTER);
        builder.setUnsafeReplacement("�");
        for (char c6 = 0; c6 <= 31; c6 = (char) (c6 + 1)) {
            if (c6 != '\t' && c6 != '\n' && c6 != '\r') {
                builder.addEscape(c6, "�");
            }
        }
        builder.addEscape(v0.f47960d, "&amp;");
        builder.addEscape(v0.f47961e, "&lt;");
        builder.addEscape(v0.f47962f, "&gt;");
        XML_CONTENT_ESCAPER = builder.build();
        builder.addEscape('\'', "&apos;");
        builder.addEscape('\"', "&quot;");
        XML_ESCAPER = builder.build();
        builder.addEscape('\t', "&#x9;");
        builder.addEscape('\n', "&#xA;");
        builder.addEscape(StringUtil.CARRIAGE_RETURN, "&#xD;");
        XML_ATTRIBUTE_ESCAPER = builder.build();
    }

    private XmlEscapers() {
    }
}

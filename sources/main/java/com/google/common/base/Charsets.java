package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;
import org.apache.commons.net.ftp.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Charsets {

    @GwtIncompatible
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset ISO_8859_1 = Charset.forName(b.T);
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    @GwtIncompatible
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");

    @GwtIncompatible
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");

    @GwtIncompatible
    public static final Charset UTF_16 = Charset.forName("UTF-16");

    private Charsets() {
    }
}

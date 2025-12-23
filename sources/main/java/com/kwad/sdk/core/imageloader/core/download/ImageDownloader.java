package com.kwad.sdk.core.imageloader.core.download;

import java.io.InputStream;
import java.util.Locale;
import master.flame.danmaku.danmaku.parser.b;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ImageDownloader {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Scheme {
        HTTP(b.f50154a),
        HTTPS(b.f50155b),
        FILE(b.f50156c),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE(ResIdentify.RES_TYPE_DRAWABLE),
        UNKNOWN("");

        private String scheme;
        private String uriPrefix;

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        public final String wrap(String str) {
            return this.uriPrefix + str;
        }

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        public final String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }
    }

    InputStream getStream(String str, Object obj);
}

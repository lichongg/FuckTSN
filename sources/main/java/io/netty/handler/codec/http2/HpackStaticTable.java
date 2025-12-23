package io.netty.handler.codec.http2;

import com.baidu.mobads.sdk.internal.cl;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.util.AsciiString;
import java.util.Arrays;
import java.util.List;
import master.flame.danmaku.danmaku.parser.b;
import okhttp3.internal.http2.Header;
import xyz.adscope.common.network.Headers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HpackStaticTable {
    private static final CharSequenceMap<Integer> STATIC_INDEX_BY_NAME;
    private static final List<HpackHeaderField> STATIC_TABLE;
    static final int length;

    static int getIndex(CharSequence charSequence) {
        Integer num = STATIC_INDEX_BY_NAME.get(charSequence);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    static {
        List<HpackHeaderField> asList = Arrays.asList(newEmptyHeaderField(Header.TARGET_AUTHORITY_UTF8), newHeaderField(Header.TARGET_METHOD_UTF8, "GET"), newHeaderField(Header.TARGET_METHOD_UTF8, "POST"), newHeaderField(Header.TARGET_PATH_UTF8, "/"), newHeaderField(Header.TARGET_PATH_UTF8, "/index.html"), newHeaderField(Header.TARGET_SCHEME_UTF8, b.f50154a), newHeaderField(Header.TARGET_SCHEME_UTF8, b.f50155b), newHeaderField(Header.RESPONSE_STATUS_UTF8, "200"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "204"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "206"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "304"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "400"), newHeaderField(Header.RESPONSE_STATUS_UTF8, cl.f10887b), newHeaderField(Header.RESPONSE_STATUS_UTF8, "500"), newEmptyHeaderField("accept-charset"), newHeaderField("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), newEmptyHeaderField("accept-language"), newEmptyHeaderField("accept-ranges"), newEmptyHeaderField("accept"), newEmptyHeaderField("access-control-allow-origin"), newEmptyHeaderField("age"), newEmptyHeaderField("allow"), newEmptyHeaderField("authorization"), newEmptyHeaderField("cache-control"), newEmptyHeaderField("content-disposition"), newEmptyHeaderField("content-encoding"), newEmptyHeaderField("content-language"), newEmptyHeaderField("content-length"), newEmptyHeaderField("content-location"), newEmptyHeaderField("content-range"), newEmptyHeaderField("content-type"), newEmptyHeaderField("cookie"), newEmptyHeaderField("date"), newEmptyHeaderField("etag"), newEmptyHeaderField("expect"), newEmptyHeaderField("expires"), newEmptyHeaderField(Constants.FROM), newEmptyHeaderField("host"), newEmptyHeaderField("if-match"), newEmptyHeaderField("if-modified-since"), newEmptyHeaderField("if-none-match"), newEmptyHeaderField("if-range"), newEmptyHeaderField("if-unmodified-since"), newEmptyHeaderField("last-modified"), newEmptyHeaderField("link"), newEmptyHeaderField(SocializeConstants.KEY_LOCATION), newEmptyHeaderField("max-forwards"), newEmptyHeaderField("proxy-authenticate"), newEmptyHeaderField("proxy-authorization"), newEmptyHeaderField("range"), newEmptyHeaderField("referer"), newEmptyHeaderField("refresh"), newEmptyHeaderField("retry-after"), newEmptyHeaderField("server"), newEmptyHeaderField("set-cookie"), newEmptyHeaderField("strict-transport-security"), newEmptyHeaderField("transfer-encoding"), newEmptyHeaderField("user-agent"), newEmptyHeaderField("vary"), newEmptyHeaderField(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA), newEmptyHeaderField("www-authenticate"));
        STATIC_TABLE = asList;
        STATIC_INDEX_BY_NAME = createMap();
        length = asList.size();
    }

    private static CharSequenceMap<Integer> createMap() {
        int size = STATIC_TABLE.size();
        CharSequenceMap<Integer> charSequenceMap = new CharSequenceMap<>(true, UnsupportedValueConverter.instance(), size);
        while (size > 0) {
            charSequenceMap.set((CharSequenceMap<Integer>) getEntry(size).name, (CharSequence) Integer.valueOf(size));
            size--;
        }
        return charSequenceMap;
    }

    static HpackHeaderField getEntry(int i6) {
        return STATIC_TABLE.get(i6 - 1);
    }

    private static HpackHeaderField newEmptyHeaderField(String str) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newHeaderField(String str, String str2) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.cached(str2));
    }

    private HpackStaticTable() {
    }

    static int getIndex(CharSequence charSequence, CharSequence charSequence2) {
        int index = getIndex(charSequence);
        if (index == -1) {
            return -1;
        }
        while (index <= length) {
            HpackHeaderField entry = getEntry(index);
            if (HpackUtil.equalsConstantTime(charSequence, entry.name) == 0) {
                break;
            }
            if (HpackUtil.equalsConstantTime(charSequence2, entry.value) != 0) {
                return index;
            }
            index++;
        }
        return -1;
    }
}

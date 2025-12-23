package com.alibaba.fastjson.parser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes2.dex */
public class DefaultExtJSONParser extends DefaultJSONParser {
    public DefaultExtJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance());
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig) {
        super(str, parserConfig);
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig, int i6) {
        super(str, parserConfig, i6);
    }

    public DefaultExtJSONParser(char[] cArr, int i6, ParserConfig parserConfig, int i7) {
        super(cArr, i6, parserConfig, i7);
    }
}

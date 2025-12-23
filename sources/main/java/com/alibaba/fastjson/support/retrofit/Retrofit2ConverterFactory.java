package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.d0;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Retrofit2ConverterFactory extends g.a {
    private Feature[] features;
    private SerializeConfig serializeConfig;
    private SerializerFeature[] serializerFeatures;
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];
    private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
    private int featureValues = JSON.DEFAULT_PARSER_FEATURE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class RequestBodyConverter<T> implements g<T, RequestBody> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.g
        public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
            return convert2((RequestBodyConverter<T>) obj);
        }

        RequestBodyConverter() {
        }

        @Override // retrofit2.g
        /* renamed from: convert, reason: avoid collision after fix types in other method */
        public RequestBody convert2(T t5) throws IOException {
            return RequestBody.create(Retrofit2ConverterFactory.MEDIA_TYPE, JSON.toJSONBytes(t5, Retrofit2ConverterFactory.this.serializeConfig == null ? SerializeConfig.globalInstance : Retrofit2ConverterFactory.this.serializeConfig, Retrofit2ConverterFactory.this.serializerFeatures == null ? SerializerFeature.EMPTY : Retrofit2ConverterFactory.this.serializerFeatures));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class ResponseBodyConverter<T> implements g<ResponseBody, T> {
        private Type type;

        ResponseBodyConverter(Type type) {
            this.type = type;
        }

        @Override // retrofit2.g
        public T convert(ResponseBody responseBody) throws IOException {
            try {
                T t5 = (T) JSON.parseObject(responseBody.string(), this.type, Retrofit2ConverterFactory.this.parserConfig, Retrofit2ConverterFactory.this.featureValues, Retrofit2ConverterFactory.this.features != null ? Retrofit2ConverterFactory.this.features : Retrofit2ConverterFactory.EMPTY_SERIALIZER_FEATURES);
                responseBody.close();
                return t5;
            } catch (Throwable th) {
                responseBody.close();
                throw th;
            }
        }
    }

    public ParserConfig getParserConfig() {
        return this.parserConfig;
    }

    public int getParserFeatureValues() {
        return this.featureValues;
    }

    public Feature[] getParserFeatures() {
        return this.features;
    }

    public SerializeConfig getSerializeConfig() {
        return this.serializeConfig;
    }

    public SerializerFeature[] getSerializerFeatures() {
        return this.serializerFeatures;
    }

    @Override // retrofit2.g.a
    public g<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, d0 d0Var) {
        return new RequestBodyConverter();
    }

    @Override // retrofit2.g.a
    public g<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, d0 d0Var) {
        return new ResponseBodyConverter(type);
    }

    public Retrofit2ConverterFactory setParserConfig(ParserConfig parserConfig) {
        this.parserConfig = parserConfig;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatureValues(int i6) {
        this.featureValues = i6;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatures(Feature[] featureArr) {
        this.features = featureArr;
        return this;
    }

    public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
        return this;
    }

    public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
        return this;
    }
}

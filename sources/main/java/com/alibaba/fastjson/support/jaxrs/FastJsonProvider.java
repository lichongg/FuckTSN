package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Produces({"*/*"})
@Provider
@Consumes({"*/*"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {

    @Deprecated
    protected Charset charset;
    private Class<?>[] clazzes;

    @Deprecated
    protected String dateFormat;
    private FastJsonConfig fastJsonConfig;

    @Deprecated
    protected SerializerFeature[] features;

    @Deprecated
    protected SerializeFilter[] filters;
    private boolean pretty;

    public FastJsonProvider() {
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
        this.clazzes = null;
    }

    protected boolean hasMatchingMediaType(MediaType mediaType) {
        if (mediaType != null) {
            String subtype = mediaType.getSubtype();
            if (!"json".equalsIgnoreCase(subtype) && !subtype.endsWith("+json") && !"javascript".equals(subtype) && !"x-javascript".equals(subtype) && !"x-json".equals(subtype) && !"x-www-form-urlencoded".equalsIgnoreCase(subtype) && !subtype.endsWith("x-www-form-urlencoded")) {
                return false;
            }
        }
        return true;
    }

    protected boolean isValidType(Class<?> cls, Annotation[] annotationArr) {
        if (cls == null) {
            return false;
        }
        Class<?>[] clsArr = this.clazzes;
        if (clsArr == null) {
            return true;
        }
        for (Class<?> cls2 : clsArr) {
            if (cls2 == cls) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    public long getSize(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        return -1L;
    }

    public Object readFrom(Class<Object> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        return JSON.parseObject(inputStream, this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getFeatures());
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public FastJsonProvider setPretty(boolean z5) {
        this.pretty = z5;
        return this;
    }

    public void writeTo(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        SerializerFeature[] serializerFeatureArr;
        SerializerFeature[] serializerFeatures = this.fastJsonConfig.getSerializerFeatures();
        if (this.pretty) {
            if (serializerFeatures == null) {
                serializerFeatureArr = new SerializerFeature[]{SerializerFeature.PrettyFormat};
            } else {
                ArrayList arrayList = new ArrayList(Arrays.asList(serializerFeatures));
                arrayList.add(SerializerFeature.PrettyFormat);
                serializerFeatureArr = (SerializerFeature[]) arrayList.toArray(serializerFeatures);
            }
            this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
        }
        multivaluedMap.add("Content-Length", String.valueOf(JSON.writeJSONString(outputStream, this.fastJsonConfig.getCharset(), obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures())));
        outputStream.flush();
    }

    public boolean isReadable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (!hasMatchingMediaType(mediaType)) {
            return false;
        }
        return isValidType(cls, annotationArr);
    }

    public boolean isWriteable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (!hasMatchingMediaType(mediaType)) {
            return false;
        }
        return isValidType(cls, annotationArr);
    }

    public FastJsonProvider(Class<?>[] clsArr) {
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
        this.clazzes = clsArr;
    }

    @Deprecated
    public FastJsonProvider(String str) {
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        this.fastJsonConfig = fastJsonConfig;
        this.clazzes = null;
        fastJsonConfig.setCharset(Charset.forName(str));
    }
}

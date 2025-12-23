package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FastJsonpHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {
    private static final byte[] JSONP_FUNCTION_PREFIX_BYTES;
    private static final byte[] JSONP_FUNCTION_SUFFIX_BYTES;
    private FastJsonConfig fastJsonConfig;

    protected boolean supports(Class<?> cls) {
        return true;
    }

    static {
        Charset charset = IOUtils.UTF8;
        JSONP_FUNCTION_PREFIX_BYTES = "/**/".getBytes(charset);
        JSONP_FUNCTION_SUFFIX_BYTES = ");".getBytes(charset);
    }

    public FastJsonpHttpMessageConverter4() {
        super(MediaType.ALL);
        this.fastJsonConfig = new FastJsonConfig();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    protected int writePrefix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        String jsonpFunction = obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null;
        if (jsonpFunction == null) {
            return 0;
        }
        byte[] bArr = JSONP_FUNCTION_PREFIX_BYTES;
        byteArrayOutputStream.write(bArr);
        byte[] bytes = (jsonpFunction + "(").getBytes(IOUtils.UTF8);
        byteArrayOutputStream.write(bytes);
        return bArr.length + bytes.length;
    }

    protected int writeSuffix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        if ((obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null) == null) {
            return 0;
        }
        byte[] bArr = JSONP_FUNCTION_SUFFIX_BYTES;
        byteArrayOutputStream.write(bArr);
        return bArr.length;
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getFeatures());
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), cls, this.fastJsonConfig.getFeatures());
    }

    protected void writeInternal(Object obj, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Object obj2;
        HttpHeaders headers = httpOutputMessage.getHeaders();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int writePrefix = writePrefix(byteArrayOutputStream, obj);
        if (obj instanceof MappingFastJsonValue) {
            obj2 = ((MappingFastJsonValue) obj).getValue();
        } else {
            obj2 = obj;
        }
        int writeJSONString = writePrefix + JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj2, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures()) + writeSuffix(byteArrayOutputStream, obj);
        if (this.fastJsonConfig.isWriteContentLength()) {
            headers.setContentLength(writeJSONString);
        }
        byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
        byteArrayOutputStream.close();
    }
}

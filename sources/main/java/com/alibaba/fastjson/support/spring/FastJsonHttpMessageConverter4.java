package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FastJsonHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {
    private FastJsonConfig fastJsonConfig;

    protected boolean supports(Class<?> cls) {
        return true;
    }

    public FastJsonHttpMessageConverter4() {
        super(MediaType.ALL);
        this.fastJsonConfig = new FastJsonConfig();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getFeatures());
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), cls, this.fastJsonConfig.getFeatures());
    }

    protected void writeInternal(Object obj, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        HttpHeaders headers = httpOutputMessage.getHeaders();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList arrayList = new ArrayList(Arrays.asList(this.fastJsonConfig.getSerializeFilters()));
        if (obj instanceof FastJsonContainer) {
            FastJsonContainer fastJsonContainer = (FastJsonContainer) obj;
            arrayList.addAll(fastJsonContainer.getFilters().getFilters());
            obj = fastJsonContainer.getValue();
        }
        int writeJSONString = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        if (this.fastJsonConfig.isWriteContentLength()) {
            headers.setContentLength(writeJSONString);
        }
        byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
        byteArrayOutputStream.close();
    }
}

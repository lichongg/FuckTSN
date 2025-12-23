package com.bytedance.sdk.component.ae.cw;

import android.util.Xml;
import com.acse.ottn.l3;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bytedance.sdk.component.ae.j, com.bytedance.sdk.component.ae.xt {

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.component.r.j.j f26072j;
    private final boolean xt;

    public m(com.bytedance.sdk.component.r.j.j jVar) {
        this.f26072j = jVar;
        this.xt = false;
    }

    @Override // com.bytedance.sdk.component.ae.j
    public Map<String, Object> j(File file) {
        FileInputStream fileInputStream;
        HashMap hashMap = new HashMap();
        if (!file.exists()) {
            return hashMap;
        }
        if (!file.canRead()) {
            vl.xt("XmlSimpleReader", "can't read file " + file);
            return hashMap;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType == 2) {
                        String name = newPullParser.getName();
                        if (!ResIdentify.RES_TYPE_STRING.equals(name) && !IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equals(name) && !"long".equals(name) && !"float".equals(name) && !"boolean".equals(name) && !l3.f4738h.equals(name)) {
                        }
                        String attributeValue = newPullParser.getAttributeValue(null, CommonNetImpl.NAME);
                        Object j6 = j(newPullParser, name);
                        if (attributeValue != null && j6 != null) {
                            hashMap.put(attributeValue, j6);
                        }
                    }
                }
                fileInputStream.close();
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return new com.bytedance.sdk.component.ae.j.xt().j(hashMap, this.f26072j, this.xt);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return new com.bytedance.sdk.component.ae.j.xt().j(hashMap, this.f26072j, this.xt);
    }

    public m(com.bytedance.sdk.component.r.j.j jVar, boolean z5) {
        this.f26072j = jVar;
        this.xt = z5;
    }

    private Object j(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        str.getClass();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            case "set":
                return j(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, "value")));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "value")));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "value")));
            default:
                return null;
        }
    }

    private Set<String> j(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && l3.f4738h.equals(xmlPullParser.getName())) {
                return hashSet;
            }
            if (eventType == 2 && ResIdentify.RES_TYPE_STRING.equals(xmlPullParser.getName())) {
                hashSet.add(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private void j(String str, Object obj, XmlSerializer xmlSerializer) throws IOException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, ResIdentify.RES_TYPE_STRING);
            xmlSerializer.attribute(null, CommonNetImpl.NAME, str);
            xmlSerializer.text(j((String) obj));
            xmlSerializer.endTag(null, ResIdentify.RES_TYPE_STRING);
            return;
        }
        if (obj instanceof Integer) {
            j(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            j(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            j(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            j(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            j(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            j(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void j(String str, Integer num, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        xmlSerializer.attribute(null, CommonNetImpl.NAME, str);
        xmlSerializer.attribute(null, "value", Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
    }

    private void j(String str, Long l6, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, CommonNetImpl.NAME, str);
        xmlSerializer.attribute(null, "value", Long.toString(l6.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void j(String str, Float f6, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "float");
        xmlSerializer.attribute(null, CommonNetImpl.NAME, str);
        xmlSerializer.attribute(null, "value", Float.toString(f6.floatValue()));
        xmlSerializer.endTag(null, "float");
    }

    private void j(String str, Double d6, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, CommonNetImpl.NAME, str);
        xmlSerializer.attribute(null, "value", Double.toString(d6.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void j(String str, Boolean bool, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "boolean");
        xmlSerializer.attribute(null, CommonNetImpl.NAME, str);
        xmlSerializer.attribute(null, "value", Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, "boolean");
    }

    private void j(String str, Set<String> set, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, l3.f4738h);
        xmlSerializer.attribute(null, CommonNetImpl.NAME, str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, ResIdentify.RES_TYPE_STRING);
            xmlSerializer.text(j(str2));
            xmlSerializer.endTag(null, ResIdentify.RES_TYPE_STRING);
        }
        xmlSerializer.endTag(null, l3.f4738h);
    }

    @Override // com.bytedance.sdk.component.ae.xt
    public void j(Map<String, Object> map, File file) throws IOException {
        FileOutputStream fileOutputStream;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Map<String, Object> xt = new com.bytedance.sdk.component.ae.j.xt().xt(map, this.f26072j, this.xt);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    XmlSerializer newSerializer = Xml.newSerializer();
                    newSerializer.setOutput(fileOutputStream, "utf-8");
                    newSerializer.startDocument(null, Boolean.TRUE);
                    newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    newSerializer.startTag(null, "map");
                    for (String str : xt.keySet()) {
                        if (str != null) {
                            j(str, xt.get(str), newSerializer);
                        }
                    }
                    newSerializer.endTag(null, "map");
                    newSerializer.endDocument();
                } catch (Exception e6) {
                    e = e6;
                    fileOutputStream2 = fileOutputStream;
                    vl.xt("XmlSimpleReader", "write file exception ", e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
            try {
                fileOutputStream.close();
            } catch (Exception unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String j(String str) {
        int i6;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            char charAt = str.charAt(i7);
            if ((charAt < ' ' || charAt > 55295) && !((charAt >= 57344 && charAt <= 65533) || charAt == '\t' || charAt == '\n' || charAt == '\r')) {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i7 > 0) {
                        sb.append(str.substring(0, i7));
                    }
                }
                if (charAt == '\"') {
                    sb.append("&quot;");
                } else if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt != '\'') {
                    if (Character.isHighSurrogate(charAt) && (i6 = i7 + 1) < length) {
                        char charAt2 = str.charAt(i6);
                        if (Character.isLowSurrogate(charAt2)) {
                            sb.append(charAt);
                            sb.append(charAt2);
                            i7 = i6;
                        }
                    } else {
                        sb.append("&#");
                        sb.append((int) charAt);
                        sb.append(";");
                    }
                } else {
                    sb.append("&apos;");
                }
            } else if (sb != null) {
                sb.append(charAt);
            }
            i7++;
        }
        return sb != null ? sb.toString() : str;
    }
}

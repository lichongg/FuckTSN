package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.kuaishou.weapon.p0.t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.StringUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AwtCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AwtCodec instance = new AwtCodec();

    public static boolean support(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t5;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error");
        }
        jSONLexer.nextToken();
        if (type == Point.class) {
            t5 = (T) parsePoint(defaultJSONParser, obj);
        } else if (type == Rectangle.class) {
            t5 = (T) parseRectangle(defaultJSONParser);
        } else if (type == Color.class) {
            t5 = (T) parseColor(defaultJSONParser);
        } else {
            if (type != Font.class) {
                throw new JSONException("not support awt class : " + type);
            }
            t5 = (T) parseFont(defaultJSONParser);
        }
        ParseContext context = defaultJSONParser.getContext();
        defaultJSONParser.setContext(t5, obj);
        defaultJSONParser.setContext(context);
        return t5;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    protected Color parseColor(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextTokenWithColon(2);
            if (jSONLexer.token() != 2) {
                throw new JSONException("syntax error");
            }
            int intValue = jSONLexer.intValue();
            jSONLexer.nextToken();
            if (stringVal.equalsIgnoreCase(t.f36150k)) {
                i6 = intValue;
            } else if (stringVal.equalsIgnoreCase("g")) {
                i7 = intValue;
            } else if (stringVal.equalsIgnoreCase("b")) {
                i8 = intValue;
            } else {
                if (!stringVal.equalsIgnoreCase("alpha")) {
                    throw new JSONException("syntax error, " + stringVal);
                }
                i9 = intValue;
            }
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(4);
            }
        }
        jSONLexer.nextToken();
        return new Color(i6, i7, i8, i9);
    }

    protected Font parseFont(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = 0;
        String str = null;
        int i7 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextTokenWithColon(2);
            if (stringVal.equalsIgnoreCase(CommonNetImpl.NAME)) {
                if (jSONLexer.token() != 4) {
                    throw new JSONException("syntax error");
                }
                str = jSONLexer.stringVal();
                jSONLexer.nextToken();
            } else if (stringVal.equalsIgnoreCase(ResIdentify.RES_TYPE_STYLE)) {
                if (jSONLexer.token() != 2) {
                    throw new JSONException("syntax error");
                }
                i6 = jSONLexer.intValue();
                jSONLexer.nextToken();
            } else {
                if (!stringVal.equalsIgnoreCase("size")) {
                    throw new JSONException("syntax error, " + stringVal);
                }
                if (jSONLexer.token() != 2) {
                    throw new JSONException("syntax error");
                }
                i7 = jSONLexer.intValue();
                jSONLexer.nextToken();
            }
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(4);
            }
        }
        jSONLexer.nextToken();
        return new Font(str, i6, i7);
    }

    protected Point parsePoint(DefaultJSONParser defaultJSONParser, Object obj) {
        int floatValue;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = 0;
        int i7 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            if (JSON.DEFAULT_TYPE_KEY.equals(stringVal)) {
                defaultJSONParser.acceptType("java.awt.Point");
            } else {
                if ("$ref".equals(stringVal)) {
                    return (Point) parseRef(defaultJSONParser, obj);
                }
                jSONLexer.nextTokenWithColon(2);
                int i8 = jSONLexer.token();
                if (i8 == 2) {
                    floatValue = jSONLexer.intValue();
                    jSONLexer.nextToken();
                } else {
                    if (i8 != 3) {
                        throw new JSONException("syntax error : " + jSONLexer.tokenName());
                    }
                    floatValue = (int) jSONLexer.floatValue();
                    jSONLexer.nextToken();
                }
                if (stringVal.equalsIgnoreCase("x")) {
                    i6 = floatValue;
                } else {
                    if (!stringVal.equalsIgnoreCase("y")) {
                        throw new JSONException("syntax error, " + stringVal);
                    }
                    i7 = floatValue;
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
            }
        }
        jSONLexer.nextToken();
        return new Point(i6, i7);
    }

    protected Rectangle parseRectangle(DefaultJSONParser defaultJSONParser) {
        int floatValue;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextTokenWithColon(2);
            int i10 = jSONLexer.token();
            if (i10 == 2) {
                floatValue = jSONLexer.intValue();
                jSONLexer.nextToken();
            } else {
                if (i10 != 3) {
                    throw new JSONException("syntax error");
                }
                floatValue = (int) jSONLexer.floatValue();
                jSONLexer.nextToken();
            }
            if (stringVal.equalsIgnoreCase("x")) {
                i6 = floatValue;
            } else if (stringVal.equalsIgnoreCase("y")) {
                i7 = floatValue;
            } else if (stringVal.equalsIgnoreCase("width")) {
                i8 = floatValue;
            } else {
                if (!stringVal.equalsIgnoreCase("height")) {
                    throw new JSONException("syntax error, " + stringVal);
                }
                i9 = floatValue;
            }
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(4);
            }
        }
        jSONLexer.nextToken();
        return new Rectangle(i6, i7, i8, i9);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Point.class, '{'), "x", point.x);
            serializeWriter.writeFieldValue(StringUtil.COMMA, "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Font.class, '{'), CommonNetImpl.NAME, font.getName());
            serializeWriter.writeFieldValue(StringUtil.COMMA, ResIdentify.RES_TYPE_STYLE, font.getStyle());
            serializeWriter.writeFieldValue(StringUtil.COMMA, "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Rectangle.class, '{'), "x", rectangle.x);
            serializeWriter.writeFieldValue(StringUtil.COMMA, "y", rectangle.y);
            serializeWriter.writeFieldValue(StringUtil.COMMA, "width", rectangle.width);
            serializeWriter.writeFieldValue(StringUtil.COMMA, "height", rectangle.height);
        } else {
            if (!(obj instanceof Color)) {
                throw new JSONException("not support awt class : " + obj.getClass().getName());
            }
            Color color = (Color) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Color.class, '{'), t.f36150k, color.getRed());
            serializeWriter.writeFieldValue(StringUtil.COMMA, "g", color.getGreen());
            serializeWriter.writeFieldValue(StringUtil.COMMA, "b", color.getBlue());
            if (color.getAlpha() > 0) {
                serializeWriter.writeFieldValue(StringUtil.COMMA, "alpha", color.getAlpha());
            }
        }
        serializeWriter.write(125);
    }

    protected char writeClassName(SerializeWriter serializeWriter, Class<?> cls, char c6) {
        if (!serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            return c6;
        }
        serializeWriter.write(123);
        serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
        serializeWriter.writeString(cls.getName());
        return StringUtil.COMMA;
    }

    private Object parseRef(DefaultJSONParser defaultJSONParser, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        lexer.nextTokenWithColon(4);
        String stringVal = lexer.stringVal();
        defaultJSONParser.setContext(defaultJSONParser.getContext(), obj);
        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(defaultJSONParser.getContext(), stringVal));
        defaultJSONParser.popContext();
        defaultJSONParser.setResolveStatus(1);
        lexer.nextToken(13);
        defaultJSONParser.accept(13);
        return null;
    }
}

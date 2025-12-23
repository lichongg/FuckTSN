package com.alibaba.fastjson.serializer;

import com.acse.ottn.l3;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ASMSerializerFactory implements Opcodes {
    static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
    static final String JavaBeanSerializer;
    static final String JavaBeanSerializer_desc;
    static final String ObjectSerializer;
    static final String ObjectSerializer_desc;
    static final String SerialContext_desc;
    static final String SerializeFilterable_desc;
    static final String SerializeWriter;
    static final String SerializeWriter_desc;
    protected final ASMClassLoader classLoader = new ASMClassLoader();
    private final AtomicLong seed = new AtomicLong();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Context {
        static final int features = 5;
        static int fieldName = 6;
        static final int obj = 2;
        static int original = 7;
        static final int paramFieldName = 3;
        static final int paramFieldType = 4;
        static int processValue = 8;
        static final int serializer = 1;
        private final SerializeBeanInfo beanInfo;
        private final String className;
        private final FieldInfo[] getters;
        private boolean nonContext;
        private final boolean writeDirect;
        private Map<String, Integer> variants = new HashMap();
        private int variantIndex = 9;

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i6 = this.variantIndex;
                this.variantIndex = i6 + 1;
                map.put(str, Integer.valueOf(i6));
            }
            return this.variants.get(str).intValue();
        }

        public int getFieldOrinal(String str) {
            int length = this.getters.length;
            for (int i6 = 0; i6 < length; i6++) {
                if (this.getters[i6].name.equals(str)) {
                    return i6;
                }
            }
            return -1;
        }

        public Context(FieldInfo[] fieldInfoArr, SerializeBeanInfo serializeBeanInfo, String str, boolean z5, boolean z6) {
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z5;
            this.nonContext = z6;
        }

        public int var(String str, int i6) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i6;
            }
            return this.variants.get(str).intValue();
        }
    }

    private void _after(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _before(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _labelApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(fieldInfo.label);
        methodVisitor.visitMethodInsn(182, JavaBeanSerializer, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
        methodVisitor.visitJumpInsn(153, label);
    }

    static {
        String type = ASMUtils.type(ObjectSerializer.class);
        ObjectSerializer = type;
        ObjectSerializer_desc = "L" + type + ";";
        String type2 = ASMUtils.type(SerializeWriter.class);
        SerializeWriter = type2;
        SerializeWriter_desc = "L" + type2 + ";";
        JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
        JavaBeanSerializer_desc = "L" + ASMUtils.type(JavaBeanSerializer.class) + ";";
        SerialContext_desc = ASMUtils.desc((Class<?>) SerialContext.class);
        SerializeFilterable_desc = ASMUtils.desc((Class<?>) SerializeFilterable.class);
    }

    private void _apply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
            methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var(ResIdentify.RES_TYPE_STRING));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(182, JavaBeanSerializer, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void _decimal(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("decimal"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitJumpInsn(199, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label);
    }

    private void _double(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(57, context.var("double", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(24, context.var("double", 2));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _enum(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/lang/Enum");
        methodVisitor.visitVarInsn(58, context.var("enum"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("enum"));
        methodVisitor.visitJumpInsn(199, label);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitMethodInsn(182, "java/lang/Enum", CommonNetImpl.NAME, "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(182, str, "write", "(I)V");
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(182, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label3);
    }

    private void _filters(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (fieldInfo.fieldTransient) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(154, label);
        }
        _notWriteDefault(methodVisitor, fieldInfo, context, label);
        if (context.writeDirect) {
            return;
        }
        _apply(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(153, label);
        _processKey(methodVisitor, fieldInfo, context);
        _processValue(methodVisitor, fieldInfo, context, label);
    }

    private void _float(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(56, context.var("float"));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(23, context.var("float"));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _get(MethodVisitor methodVisitor, Context context, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitVarInsn(25, context.var("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            methodVisitor.visitMethodInsn(declaringClass.isInterface() ? 185 : 182, ASMUtils.type(declaringClass), method.getName(), ASMUtils.desc(method));
            if (method.getReturnType().equals(fieldInfo.fieldClass)) {
                return;
            }
            methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("entity"));
        Field field = fieldInfo.field;
        methodVisitor.visitFieldInsn(180, ASMUtils.type(fieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
        if (field.getType().equals(fieldInfo.fieldClass)) {
            return;
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
    }

    private void _getFieldSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        String str2 = fieldInfo.name + "_asm_ser_";
        String str3 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, str, str2, str3);
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(182, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        methodVisitor.visitFieldInsn(181, context.className, fieldInfo.name + "_asm_ser_", str3);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_ser_", str3);
    }

    private void _getListFieldItemSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        String str2 = fieldInfo.name + "_asm_list_item_ser_";
        String str3 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, str, str2, str3);
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(182, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        methodVisitor.visitFieldInsn(181, context.className, fieldInfo.name + "_asm_list_item_ser_", str3);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_ser_", str3);
    }

    private void _if_write_null(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls = fieldInfo.fieldClass;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label);
        JSONField annotation = fieldInfo.getAnnotation();
        int of = annotation != null ? SerializerFeature.of(annotation.serialzeFeatures()) : 0;
        int i6 = SerializerFeature.WRITE_MAP_NULL_FEATURES;
        if ((of & i6) == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(i6));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(153, label2);
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = SerializeWriter;
        methodVisitor.visitMethodInsn(182, str, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn(Integer.valueOf(of));
        if (cls == String.class || cls == Character.class) {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        } else if (Number.class.isAssignableFrom(cls)) {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
        } else if (cls == Boolean.class) {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
        } else if (Collection.class.isAssignableFrom(cls) || cls.isArray()) {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
        } else {
            methodVisitor.visitLdcInsn(0);
        }
        methodVisitor.visitMethodInsn(182, str, "writeNull", "(II)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label4);
    }

    private void _int(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, int i6, char c6) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(54, i6);
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(21, i6);
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;" + c6 + ")V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _list(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label;
        Label label2;
        Label label3;
        Class<?> cls2;
        String str;
        Label label4;
        Label label5;
        FieldInfo fieldInfo2;
        Label label6;
        int i6;
        int i7;
        int i8;
        Label label7;
        Label label8;
        java.lang.reflect.Type collectionItemType = TypeUtils.getCollectionItemType(fieldInfo.fieldType);
        Class<?> cls3 = null;
        Class<?> cls4 = collectionItemType instanceof Class ? (Class) collectionItemType : null;
        if (cls4 != Object.class && cls4 != Serializable.class) {
            cls3 = cls4;
        }
        Label label9 = new Label();
        Label label10 = new Label();
        Label label11 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label9);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/util/List");
        methodVisitor.visitVarInsn(58, context.var("list"));
        _filters(methodVisitor, fieldInfo, context, label9);
        methodVisitor.visitVarInsn(25, context.var("list"));
        methodVisitor.visitJumpInsn(199, label10);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label11);
        methodVisitor.visitLabel(label10);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str2 = SerializeWriter;
        methodVisitor.visitMethodInsn(182, str2, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var("list"));
        methodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
        methodVisitor.visitVarInsn(54, context.var("size"));
        Label label12 = new Label();
        Label label13 = new Label();
        methodVisitor.visitVarInsn(21, context.var("size"));
        methodVisitor.visitInsn(3);
        methodVisitor.visitJumpInsn(160, label12);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn("[]");
        methodVisitor.visitMethodInsn(182, str2, "write", "(Ljava/lang/String;)V");
        methodVisitor.visitJumpInsn(167, label13);
        methodVisitor.visitLabel(label12);
        if (context.nonContext) {
            label = label13;
        } else {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            label = label13;
            methodVisitor.visitMethodInsn(182, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (collectionItemType == String.class && context.writeDirect) {
            i7 = 25;
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, context.var("list"));
            i8 = 182;
            methodVisitor.visitMethodInsn(182, str2, "write", "(Ljava/util/List;)V");
            i6 = 1;
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 91);
            methodVisitor.visitMethodInsn(182, str2, "write", "(I)V");
            Label label14 = new Label();
            Label label15 = new Label();
            Label label16 = new Label();
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, context.var("i"));
            methodVisitor.visitLabel(label14);
            methodVisitor.visitVarInsn(21, context.var("i"));
            methodVisitor.visitVarInsn(21, context.var("size"));
            methodVisitor.visitJumpInsn(162, label16);
            methodVisitor.visitVarInsn(21, context.var("i"));
            methodVisitor.visitJumpInsn(153, label15);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 44);
            methodVisitor.visitMethodInsn(182, str2, "write", "(I)V");
            methodVisitor.visitLabel(label15);
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitVarInsn(21, context.var("i"));
            methodVisitor.visitMethodInsn(185, "java/util/List", l3.f4736f, "(I)Ljava/lang/Object;");
            methodVisitor.visitVarInsn(58, context.var("list_item"));
            Label label17 = new Label();
            Label label18 = new Label();
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            methodVisitor.visitJumpInsn(199, label18);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitMethodInsn(182, str2, "writeNull", "()V");
            methodVisitor.visitJumpInsn(167, label17);
            methodVisitor.visitLabel(label18);
            Label label19 = new Label();
            Label label20 = new Label();
            if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                label2 = label14;
                label3 = label17;
                cls2 = cls3;
                str = "out";
                label4 = label19;
                label5 = label16;
                fieldInfo2 = fieldInfo;
                label6 = label20;
            } else {
                str = "out";
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                label5 = label16;
                label2 = label14;
                methodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                methodVisitor.visitJumpInsn(166, label20);
                fieldInfo2 = fieldInfo;
                _getListFieldItemSer(context, methodVisitor, fieldInfo2, cls3);
                cls2 = cls3;
                methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                Label label21 = new Label();
                Label label22 = new Label();
                if (context.writeDirect) {
                    String str3 = (context.nonContext && context.writeDirect) ? "writeDirectNonContext" : "write";
                    label3 = label17;
                    label8 = label20;
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    String str4 = JavaBeanSerializer;
                    methodVisitor.visitTypeInsn(193, str4);
                    methodVisitor.visitJumpInsn(153, label21);
                    label7 = label19;
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    methodVisitor.visitTypeInsn(192, str4);
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor.visitInsn(1);
                    } else {
                        methodVisitor.visitVarInsn(21, context.var("i"));
                        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                    methodVisitor.visitMethodInsn(182, str4, str3, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor.visitJumpInsn(167, label22);
                    methodVisitor.visitLabel(label21);
                } else {
                    label3 = label17;
                    label7 = label19;
                    label8 = label20;
                }
                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                if (context.nonContext) {
                    methodVisitor.visitInsn(1);
                } else {
                    methodVisitor.visitVarInsn(21, context.var("i"));
                    methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor.visitMethodInsn(185, ObjectSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitLabel(label22);
                label4 = label7;
                methodVisitor.visitJumpInsn(167, label4);
                label6 = label8;
            }
            methodVisitor.visitLabel(label6);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            if (context.nonContext) {
                methodVisitor.visitInsn(1);
            } else {
                methodVisitor.visitVarInsn(21, context.var("i"));
                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) collectionItemType)));
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLabel(label3);
            i6 = 1;
            methodVisitor.visitIincInsn(context.var("i"), 1);
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label5);
            i7 = 25;
            methodVisitor.visitVarInsn(25, context.var(str));
            methodVisitor.visitVarInsn(16, 93);
            i8 = 182;
            methodVisitor.visitMethodInsn(182, str2, "write", "(I)V");
        }
        methodVisitor.visitVarInsn(i7, i6);
        methodVisitor.visitMethodInsn(i8, JSONSerializer, "popContext", "()V");
        methodVisitor.visitLabel(label);
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label11);
        methodVisitor.visitLabel(label9);
    }

    private void _long(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(55, context.var("long", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(22, context.var("long", 2));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _object(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("object"));
        _filters(methodVisitor, fieldInfo, context, label);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitLabel(label);
    }

    private void _processKey(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
        methodVisitor.visitJumpInsn(153, label);
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
            methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var(ResIdentify.RES_TYPE_STRING));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(182, JavaBeanSerializer, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        methodVisitor.visitVarInsn(58, Context.fieldName);
        methodVisitor.visitLabel(label);
    }

    private void _processValue(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Label label2 = new Label();
        Class<?> cls = fieldInfo.fieldClass;
        if (cls.isPrimitive()) {
            Label label3 = new Label();
            methodVisitor.visitVarInsn(21, context.var("checkValue"));
            methodVisitor.visitJumpInsn(154, label3);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(58, Context.processValue);
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label3);
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(Integer.valueOf(context.getFieldOrinal(fieldInfo.name)));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(182, str, "getBeanContext", "(I)" + ASMUtils.desc((Class<?>) BeanContext.class));
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
            methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var(ResIdentify.RES_TYPE_STRING));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        }
        methodVisitor.visitMethodInsn(182, str, "processValue", "(L" + JSONSerializer + ";" + ASMUtils.desc((Class<?>) BeanContext.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, Context.processValue);
        methodVisitor.visitVarInsn(25, Context.original);
        methodVisitor.visitVarInsn(25, Context.processValue);
        methodVisitor.visitJumpInsn(165, label2);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitJumpInsn(167, label);
        methodVisitor.visitLabel(label2);
    }

    private void _seperator(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _string(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(182, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor.visitJumpInsn(154, label);
        }
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var(ResIdentify.RES_TYPE_STRING));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var(ResIdentify.RES_TYPE_STRING));
        methodVisitor.visitJumpInsn(199, label2);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label2);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var(ResIdentify.RES_TYPE_STRING));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var(ResIdentify.RES_TYPE_STRING));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLabel(label);
    }

    private void _writeObject(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        String str;
        Label label2;
        Label label3;
        String format = fieldInfo.getFormat();
        Class<?> cls = fieldInfo.fieldClass;
        Label label4 = new Label();
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, Context.processValue);
        }
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(58, context.var("object"));
        methodVisitor.visitJumpInsn(199, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        Label label5 = new Label();
        Label label6 = new Label();
        if (!Modifier.isPublic(cls.getModifiers()) || ParserConfig.isPrimitive2(cls)) {
            str = format;
            label2 = label5;
            label3 = label6;
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            methodVisitor.visitJumpInsn(166, label6);
            _getFieldSer(context, methodVisitor, fieldInfo);
            methodVisitor.visitVarInsn(58, context.var("fied_ser"));
            Label label7 = new Label();
            Label label8 = new Label();
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            String str2 = JavaBeanSerializer;
            methodVisitor.visitTypeInsn(193, str2);
            methodVisitor.visitJumpInsn(153, label7);
            boolean z5 = (fieldInfo.serialzeFeatures & SerializerFeature.BeanToArray.mask) != 0;
            String str3 = (context.nonContext && context.writeDirect) ? z5 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z5 ? "writeAsArray" : "write";
            str = format;
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitTypeInsn(192, str2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            String str4 = JSONSerializer;
            sb.append(str4);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor.visitMethodInsn(182, str2, str3, sb.toString());
            methodVisitor.visitJumpInsn(167, label8);
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(185, ObjectSerializer, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor.visitLabel(label8);
            label2 = label5;
            methodVisitor.visitJumpInsn(167, label2);
            label3 = label6;
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, 1);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, Context.processValue);
        }
        if (str != null) {
            methodVisitor.visitLdcInsn(str);
            methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, Context.fieldName);
            java.lang.reflect.Type type = fieldInfo.fieldType;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (fieldInfo.fieldClass == String.class) {
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) String.class)));
                } else {
                    methodVisitor.visitVarInsn(25, 0);
                    methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        methodVisitor.visitLabel(label2);
        _seperator(methodVisitor, context);
    }

    private void generateWriteAsArray(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        String str;
        int i6;
        String str2;
        int i7;
        ASMSerializerFactory aSMSerializerFactory;
        Label label;
        String str3;
        Class<?> cls2;
        int i8;
        Label label2;
        Label label3;
        String str4;
        Label label4;
        Class<?> cls3;
        Label label5;
        int i9;
        int i10;
        int i11;
        String str5;
        String str6;
        Label label6;
        ASMSerializerFactory aSMSerializerFactory2 = this;
        FieldInfo[] fieldInfoArr2 = fieldInfoArr;
        String str7 = "out";
        int i12 = 25;
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(16, 91);
        String str8 = SerializeWriter;
        int i13 = 182;
        String str9 = "(I)V";
        methodVisitor.visitMethodInsn(182, str8, "write", "(I)V");
        int length = fieldInfoArr2.length;
        if (length == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 93);
            methodVisitor.visitMethodInsn(182, str8, "write", "(I)V");
            return;
        }
        int i14 = 0;
        while (i14 < length) {
            int i15 = i14 == length + (-1) ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr2[i14];
            Class<?> cls4 = fieldInfo.fieldClass;
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitVarInsn(58, Context.fieldName);
            if (cls4 == Byte.TYPE || cls4 == Short.TYPE || cls4 == Integer.TYPE) {
                str = str7;
                i6 = i14;
                str2 = str9;
                i7 = length;
                methodVisitor.visitVarInsn(25, context.var(str));
                methodVisitor.visitInsn(89);
                aSMSerializerFactory = this;
                aSMSerializerFactory._get(methodVisitor, context, fieldInfo);
                String str10 = SerializeWriter;
                methodVisitor.visitMethodInsn(i13, str10, "writeInt", str2);
                methodVisitor.visitVarInsn(16, i15);
                methodVisitor.visitMethodInsn(i13, str10, "write", str2);
            } else {
                if (cls4 == Long.TYPE) {
                    methodVisitor.visitVarInsn(i12, context.var(str7));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str11 = SerializeWriter;
                    methodVisitor.visitMethodInsn(i13, str11, "writeLong", "(J)V");
                    methodVisitor.visitVarInsn(16, i15);
                    methodVisitor.visitMethodInsn(i13, str11, "write", str9);
                } else if (cls4 == Float.TYPE) {
                    methodVisitor.visitVarInsn(i12, context.var(str7));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    String str12 = SerializeWriter;
                    methodVisitor.visitMethodInsn(i13, str12, "writeFloat", "(FZ)V");
                    methodVisitor.visitVarInsn(16, i15);
                    methodVisitor.visitMethodInsn(i13, str12, "write", str9);
                } else if (cls4 == Double.TYPE) {
                    methodVisitor.visitVarInsn(i12, context.var(str7));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    String str13 = SerializeWriter;
                    methodVisitor.visitMethodInsn(i13, str13, "writeDouble", "(DZ)V");
                    methodVisitor.visitVarInsn(16, i15);
                    methodVisitor.visitMethodInsn(i13, str13, "write", str9);
                } else if (cls4 == Boolean.TYPE) {
                    methodVisitor.visitVarInsn(i12, context.var(str7));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str14 = SerializeWriter;
                    methodVisitor.visitMethodInsn(i13, str14, "write", "(Z)V");
                    methodVisitor.visitVarInsn(16, i15);
                    methodVisitor.visitMethodInsn(i13, str14, "write", str9);
                } else if (cls4 == Character.TYPE) {
                    methodVisitor.visitVarInsn(i12, context.var(str7));
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitMethodInsn(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                    methodVisitor.visitVarInsn(16, i15);
                    methodVisitor.visitMethodInsn(i13, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                } else if (cls4 == String.class) {
                    methodVisitor.visitVarInsn(i12, context.var(str7));
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitVarInsn(16, i15);
                    methodVisitor.visitMethodInsn(i13, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                } else if (cls4.isEnum()) {
                    methodVisitor.visitVarInsn(i12, context.var(str7));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str15 = SerializeWriter;
                    methodVisitor.visitMethodInsn(i13, str15, "writeEnum", "(Ljava/lang/Enum;)V");
                    methodVisitor.visitVarInsn(16, i15);
                    methodVisitor.visitMethodInsn(i13, str15, "write", str9);
                } else if (List.class.isAssignableFrom(cls4)) {
                    java.lang.reflect.Type type = fieldInfo.fieldType;
                    java.lang.reflect.Type type2 = type instanceof Class ? Object.class : ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (!(type2 instanceof Class) || (cls2 = (Class) type2) == Object.class) {
                        cls2 = null;
                    }
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    i6 = i14;
                    methodVisitor.visitTypeInsn(192, "java/util/List");
                    java.lang.reflect.Type type3 = type2;
                    methodVisitor.visitVarInsn(58, context.var("list"));
                    if (cls2 == String.class && context.writeDirect) {
                        methodVisitor.visitVarInsn(25, context.var(str7));
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        i11 = 182;
                        methodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(Ljava/util/List;)V");
                        str = str7;
                        str2 = str9;
                        i7 = length;
                        i8 = i15;
                        i10 = 16;
                        i9 = 25;
                    } else {
                        Label label7 = new Label();
                        Label label8 = new Label();
                        i7 = length;
                        i8 = i15;
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        methodVisitor.visitJumpInsn(199, label8);
                        methodVisitor.visitVarInsn(25, context.var(str7));
                        String str16 = SerializeWriter;
                        methodVisitor.visitMethodInsn(182, str16, "writeNull", "()V");
                        methodVisitor.visitJumpInsn(167, label7);
                        methodVisitor.visitLabel(label8);
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        methodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
                        methodVisitor.visitVarInsn(54, context.var("size"));
                        methodVisitor.visitVarInsn(25, context.var(str7));
                        methodVisitor.visitVarInsn(16, 91);
                        methodVisitor.visitMethodInsn(182, str16, "write", str9);
                        Label label9 = new Label();
                        Label label10 = new Label();
                        Label label11 = new Label();
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitVarInsn(54, context.var("i"));
                        methodVisitor.visitLabel(label9);
                        methodVisitor.visitVarInsn(21, context.var("i"));
                        methodVisitor.visitVarInsn(21, context.var("size"));
                        methodVisitor.visitJumpInsn(162, label11);
                        methodVisitor.visitVarInsn(21, context.var("i"));
                        methodVisitor.visitJumpInsn(153, label10);
                        methodVisitor.visitVarInsn(25, context.var(str7));
                        methodVisitor.visitVarInsn(16, 44);
                        methodVisitor.visitMethodInsn(182, str16, "write", str9);
                        methodVisitor.visitLabel(label10);
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        methodVisitor.visitVarInsn(21, context.var("i"));
                        methodVisitor.visitMethodInsn(185, "java/util/List", l3.f4736f, "(I)Ljava/lang/Object;");
                        methodVisitor.visitVarInsn(58, context.var("list_item"));
                        Label label12 = new Label();
                        Label label13 = new Label();
                        String str17 = str9;
                        methodVisitor.visitVarInsn(25, context.var("list_item"));
                        methodVisitor.visitJumpInsn(199, label13);
                        methodVisitor.visitVarInsn(25, context.var(str7));
                        String str18 = str7;
                        methodVisitor.visitMethodInsn(182, str16, "writeNull", "()V");
                        methodVisitor.visitJumpInsn(167, label12);
                        methodVisitor.visitLabel(label13);
                        Label label14 = new Label();
                        Label label15 = new Label();
                        if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                            label2 = label12;
                            label3 = label9;
                            str4 = str16;
                            label4 = label11;
                            cls3 = cls2;
                            label5 = label15;
                        } else {
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            str4 = str16;
                            label4 = label11;
                            methodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                            methodVisitor.visitJumpInsn(166, label15);
                            aSMSerializerFactory2._getListFieldItemSer(context, methodVisitor, fieldInfo, cls2);
                            methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                            Label label16 = new Label();
                            Label label17 = new Label();
                            if (context.writeDirect) {
                                cls3 = cls2;
                                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                String str19 = JavaBeanSerializer;
                                methodVisitor.visitTypeInsn(193, str19);
                                methodVisitor.visitJumpInsn(153, label16);
                                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                methodVisitor.visitTypeInsn(192, str19);
                                methodVisitor.visitVarInsn(25, 1);
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                if (context.nonContext) {
                                    methodVisitor.visitInsn(1);
                                    label2 = label12;
                                    label3 = label9;
                                } else {
                                    methodVisitor.visitVarInsn(21, context.var("i"));
                                    label3 = label9;
                                    label2 = label12;
                                    methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                StringBuilder sb = new StringBuilder();
                                str6 = "(L";
                                sb.append(str6);
                                sb.append(JSONSerializer);
                                str5 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
                                sb.append(str5);
                                label6 = label15;
                                methodVisitor.visitMethodInsn(182, str19, "writeAsArrayNonContext", sb.toString());
                                methodVisitor.visitJumpInsn(167, label17);
                                methodVisitor.visitLabel(label16);
                            } else {
                                label2 = label12;
                                label3 = label9;
                                cls3 = cls2;
                                str5 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
                                str6 = "(L";
                                label6 = label15;
                            }
                            methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            if (context.nonContext) {
                                methodVisitor.visitInsn(1);
                            } else {
                                methodVisitor.visitVarInsn(21, context.var("i"));
                                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            methodVisitor.visitMethodInsn(185, ObjectSerializer, "write", str6 + JSONSerializer + str5);
                            methodVisitor.visitLabel(label17);
                            methodVisitor.visitJumpInsn(167, label14);
                            label5 = label6;
                        }
                        methodVisitor.visitLabel(label5);
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("list_item"));
                        if (context.nonContext) {
                            methodVisitor.visitInsn(1);
                        } else {
                            methodVisitor.visitVarInsn(21, context.var("i"));
                            methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        }
                        if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                            methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                        } else {
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) type3)));
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        }
                        methodVisitor.visitLabel(label14);
                        methodVisitor.visitLabel(label2);
                        methodVisitor.visitIincInsn(context.var("i"), 1);
                        methodVisitor.visitJumpInsn(167, label3);
                        methodVisitor.visitLabel(label4);
                        str = str18;
                        i9 = 25;
                        methodVisitor.visitVarInsn(25, context.var(str));
                        i10 = 16;
                        methodVisitor.visitVarInsn(16, 93);
                        str2 = str17;
                        i11 = 182;
                        methodVisitor.visitMethodInsn(182, str4, "write", str2);
                        methodVisitor.visitLabel(label7);
                    }
                    methodVisitor.visitVarInsn(i9, context.var(str));
                    methodVisitor.visitVarInsn(i10, i8);
                    methodVisitor.visitMethodInsn(i11, SerializeWriter, "write", str2);
                    aSMSerializerFactory = this;
                    i13 = 182;
                } else {
                    String str20 = str7;
                    i6 = i14;
                    String str21 = str9;
                    i7 = length;
                    Label label18 = new Label();
                    Label label19 = new Label();
                    _get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(89);
                    methodVisitor.visitVarInsn(58, context.var("field_" + fieldInfo.fieldClass.getName()));
                    methodVisitor.visitJumpInsn(199, label19);
                    methodVisitor.visitVarInsn(25, context.var(str20));
                    String str22 = SerializeWriter;
                    int i16 = i15;
                    methodVisitor.visitMethodInsn(182, str22, "writeNull", "()V");
                    methodVisitor.visitJumpInsn(167, label18);
                    methodVisitor.visitLabel(label19);
                    Label label20 = new Label();
                    Label label21 = new Label();
                    methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                    methodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls4)));
                    methodVisitor.visitJumpInsn(166, label21);
                    _getFieldSer(context, methodVisitor, fieldInfo);
                    methodVisitor.visitVarInsn(58, context.var("fied_ser"));
                    Label label22 = new Label();
                    Label label23 = new Label();
                    if (context.writeDirect && Modifier.isPublic(cls4.getModifiers())) {
                        methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                        String str23 = JavaBeanSerializer;
                        methodVisitor.visitTypeInsn(193, str23);
                        methodVisitor.visitJumpInsn(153, label22);
                        label = label18;
                        methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                        methodVisitor.visitTypeInsn(192, str23);
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitVarInsn(25, Context.fieldName);
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls4)));
                        methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                        str3 = "writeWithFieldName";
                        methodVisitor.visitMethodInsn(182, str23, "writeAsArrayNonContext", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        methodVisitor.visitJumpInsn(167, label23);
                        methodVisitor.visitLabel(label22);
                    } else {
                        label = label18;
                        str3 = "writeWithFieldName";
                    }
                    methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                    methodVisitor.visitVarInsn(25, Context.fieldName);
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls4)));
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                    String str24 = ObjectSerializer;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("(L");
                    String str25 = JSONSerializer;
                    sb2.append(str25);
                    sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor.visitMethodInsn(185, str24, "write", sb2.toString());
                    methodVisitor.visitLabel(label23);
                    methodVisitor.visitJumpInsn(167, label20);
                    methodVisitor.visitLabel(label21);
                    String format = fieldInfo.getFormat();
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                    if (format != null) {
                        methodVisitor.visitLdcInsn(format);
                        i13 = 182;
                        methodVisitor.visitMethodInsn(182, str25, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                    } else {
                        i13 = 182;
                        methodVisitor.visitVarInsn(25, Context.fieldName);
                        java.lang.reflect.Type type4 = fieldInfo.fieldType;
                        if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                            methodVisitor.visitMethodInsn(182, str25, str3, "(Ljava/lang/Object;Ljava/lang/Object;)V");
                        } else {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            i13 = 182;
                            methodVisitor.visitMethodInsn(182, str25, str3, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        }
                    }
                    methodVisitor.visitLabel(label20);
                    methodVisitor.visitLabel(label);
                    str = str20;
                    methodVisitor.visitVarInsn(25, context.var(str));
                    methodVisitor.visitVarInsn(16, i16);
                    str2 = str21;
                    methodVisitor.visitMethodInsn(i13, str22, "write", str2);
                    aSMSerializerFactory = this;
                }
                String str26 = str9;
                aSMSerializerFactory = aSMSerializerFactory2;
                str = str7;
                str2 = str26;
                i6 = i14;
                i7 = length;
            }
            i14 = i6 + 1;
            String str27 = str2;
            str7 = str;
            aSMSerializerFactory2 = aSMSerializerFactory;
            str9 = str27;
            fieldInfoArr2 = fieldInfoArr;
            length = i7;
            i12 = 25;
        }
    }

    private void generateWriteMethod(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        Label label;
        String str;
        ASMSerializerFactory aSMSerializerFactory = this;
        MethodVisitor methodVisitor2 = methodVisitor;
        Label label2 = new Label();
        if (context.writeDirect) {
            label = label2;
        } else {
            Label label3 = new Label();
            Label label4 = new Label();
            label = label2;
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            methodVisitor2.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(154, label4);
            boolean z5 = false;
            for (FieldInfo fieldInfo : fieldInfoArr) {
                if (fieldInfo.method != null) {
                    z5 = true;
                }
            }
            if (z5) {
                methodVisitor2.visitVarInsn(25, context.var("out"));
                methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                methodVisitor2.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor2.visitJumpInsn(153, label3);
            } else {
                methodVisitor2.visitJumpInsn(167, label3);
            }
            methodVisitor2.visitLabel(label4);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(183, JavaBeanSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(177);
            methodVisitor2.visitLabel(label3);
        }
        if (!context.nonContext) {
            Label label5 = new Label();
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(182, JavaBeanSerializer, "writeReference", "(L" + JSONSerializer + ";Ljava/lang/Object;I)Z");
            methodVisitor2.visitJumpInsn(153, label5);
            methodVisitor2.visitInsn(177);
            methodVisitor2.visitLabel(label5);
        }
        String str2 = context.writeDirect ? context.nonContext ? "writeAsArrayNonContext" : "writeAsArray" : "writeAsArrayNormal";
        int i6 = context.beanInfo.features;
        SerializerFeature serializerFeature = SerializerFeature.BeanToArray;
        if ((i6 & serializerFeature.mask) == 0) {
            Label label6 = new Label();
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitLdcInsn(Integer.valueOf(serializerFeature.mask));
            methodVisitor2.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(153, label6);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(182, context.className, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(177);
            methodVisitor2.visitLabel(label6);
        } else {
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(182, context.className, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(177);
        }
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            String str3 = JSONSerializer;
            StringBuilder sb = new StringBuilder();
            sb.append("()");
            String str4 = SerialContext_desc;
            sb.append(str4);
            methodVisitor2.visitMethodInsn(182, str3, "getContext", sb.toString());
            methodVisitor2.visitVarInsn(58, context.var("parent"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context.var("parent"));
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitLdcInsn(Integer.valueOf(context.beanInfo.features));
            methodVisitor2.visitMethodInsn(182, str3, "setContext", "(" + str4 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        if (context.writeDirect) {
            str = "parent";
            methodVisitor2.visitVarInsn(16, 123);
        } else {
            Label label7 = new Label();
            Label label8 = new Label();
            Label label9 = new Label();
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(25, 2);
            String str5 = JSONSerializer;
            str = "parent";
            methodVisitor2.visitMethodInsn(182, str5, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor2.visitJumpInsn(153, label8);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor2.visitJumpInsn(165, label8);
            methodVisitor2.visitLabel(label9);
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            if (context.beanInfo.typeKey != null) {
                methodVisitor2.visitLdcInsn(context.beanInfo.typeKey);
            } else {
                methodVisitor2.visitInsn(1);
            }
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitMethodInsn(182, JavaBeanSerializer, "writeClassName", "(L" + str5 + ";Ljava/lang/String;Ljava/lang/Object;)V");
            methodVisitor2.visitVarInsn(16, 44);
            methodVisitor2.visitJumpInsn(167, label7);
            methodVisitor2.visitLabel(label8);
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitLabel(label7);
        }
        methodVisitor2.visitVarInsn(54, context.var("seperator"));
        if (!context.writeDirect) {
            aSMSerializerFactory._before(methodVisitor2, context);
        }
        if (!context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitMethodInsn(182, SerializeWriter, "isNotWriteDefaultValue", "()Z");
            methodVisitor2.visitVarInsn(54, context.var("notWriteDefaultValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            String str6 = JSONSerializer;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(");
            String str7 = SerializeFilterable_desc;
            sb2.append(str7);
            sb2.append(")Z");
            methodVisitor2.visitMethodInsn(182, str6, "checkValue", sb2.toString());
            methodVisitor2.visitVarInsn(54, context.var("checkValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(182, str6, "hasNameFilters", "(" + str7 + ")Z");
            methodVisitor2.visitVarInsn(54, context.var("hasNameFilters"));
        }
        for (FieldInfo fieldInfo2 : fieldInfoArr) {
            Class<?> cls2 = fieldInfo2.fieldClass;
            methodVisitor2.visitLdcInsn(fieldInfo2.name);
            methodVisitor2.visitVarInsn(58, Context.fieldName);
            if (cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE) {
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo2, context, context.var(cls2.getName()), 'I');
            } else if (cls2 == Long.TYPE) {
                aSMSerializerFactory._long(cls, methodVisitor2, fieldInfo2, context);
            } else if (cls2 == Float.TYPE) {
                aSMSerializerFactory._float(cls, methodVisitor2, fieldInfo2, context);
            } else if (cls2 == Double.TYPE) {
                aSMSerializerFactory._double(cls, methodVisitor2, fieldInfo2, context);
            } else if (cls2 == Boolean.TYPE) {
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo2, context, context.var("boolean"), 'Z');
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
            } else if (cls2 == Character.TYPE) {
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo2, context, context.var("char"), 'C');
            } else {
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
                if (cls2 == String.class) {
                    aSMSerializerFactory._string(cls, methodVisitor2, fieldInfo2, context);
                } else if (cls2 == BigDecimal.class) {
                    aSMSerializerFactory._decimal(cls, methodVisitor2, fieldInfo2, context);
                } else if (List.class.isAssignableFrom(cls2)) {
                    aSMSerializerFactory._list(cls, methodVisitor2, fieldInfo2, context);
                } else if (cls2.isEnum()) {
                    aSMSerializerFactory._enum(cls, methodVisitor2, fieldInfo2, context);
                } else {
                    aSMSerializerFactory._object(cls, methodVisitor2, fieldInfo2, context);
                }
            }
        }
        if (!context.writeDirect) {
            aSMSerializerFactory._after(methodVisitor2, context);
        }
        Label label10 = new Label();
        Label label11 = new Label();
        methodVisitor2.visitVarInsn(21, context.var("seperator"));
        methodVisitor2.visitIntInsn(16, 123);
        methodVisitor2.visitJumpInsn(160, label10);
        methodVisitor2.visitVarInsn(25, context.var("out"));
        methodVisitor2.visitVarInsn(16, 123);
        String str8 = SerializeWriter;
        methodVisitor2.visitMethodInsn(182, str8, "write", "(I)V");
        methodVisitor2.visitLabel(label10);
        methodVisitor2.visitVarInsn(25, context.var("out"));
        methodVisitor2.visitVarInsn(16, 125);
        methodVisitor2.visitMethodInsn(182, str8, "write", "(I)V");
        methodVisitor2.visitLabel(label11);
        methodVisitor2.visitLabel(label);
        if (context.nonContext) {
            return;
        }
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context.var(str));
        methodVisitor2.visitMethodInsn(182, JSONSerializer, "setContext", "(" + SerialContext_desc + ")V");
    }

    public JavaBeanSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        boolean z5;
        Class<SerializeBeanInfo> cls;
        String str;
        boolean z6;
        boolean z7;
        String str2;
        boolean z8;
        boolean z9;
        FieldInfo[] fieldInfoArr;
        Class<?> cls2;
        int i6;
        FieldInfo[] fieldInfoArr2;
        int i7;
        Method method;
        ASMSerializerFactory aSMSerializerFactory = this;
        Class<?> cls3 = serializeBeanInfo.beanType;
        if (cls3.isPrimitive()) {
            throw new JSONException("unsupportd class " + cls3.getName());
        }
        JSONType jSONType = (JSONType) cls3.getAnnotation(JSONType.class);
        FieldInfo[] fieldInfoArr3 = serializeBeanInfo.fields;
        for (FieldInfo fieldInfo : fieldInfoArr3) {
            if (fieldInfo.field == null && (method = fieldInfo.method) != null && method.getDeclaringClass().isInterface()) {
                return new JavaBeanSerializer(cls3);
            }
        }
        FieldInfo[] fieldInfoArr4 = serializeBeanInfo.sortedFields;
        boolean z10 = fieldInfoArr4 == serializeBeanInfo.fields;
        if (fieldInfoArr4.length > 256) {
            return new JavaBeanSerializer(cls3);
        }
        for (FieldInfo fieldInfo2 : fieldInfoArr4) {
            if (!ASMUtils.checkName(fieldInfo2.getMember().getName())) {
                return new JavaBeanSerializer(cls3);
            }
        }
        String str3 = "ASMSerializer_" + aSMSerializerFactory.seed.incrementAndGet() + "_" + cls3.getSimpleName();
        String name = ASMSerializerFactory.class.getPackage().getName();
        String str4 = name.replace('.', '/') + "/" + str3;
        String str5 = name + "." + str3;
        ClassWriter classWriter = new ClassWriter();
        classWriter.visit(49, 33, str4, JavaBeanSerializer, new String[]{ObjectSerializer});
        int length = fieldInfoArr4.length;
        int i8 = 0;
        while (i8 < length) {
            FieldInfo fieldInfo3 = fieldInfoArr4[i8];
            String str6 = str5;
            if (!fieldInfo3.fieldClass.isPrimitive() && fieldInfo3.fieldClass != String.class) {
                new FieldWriter(classWriter, 1, fieldInfo3.name + "_asm_fieldType", "Ljava/lang/reflect/Type;").visitEnd();
                if (List.class.isAssignableFrom(fieldInfo3.fieldClass)) {
                    new FieldWriter(classWriter, 1, fieldInfo3.name + "_asm_list_item_ser_", ObjectSerializer_desc).visitEnd();
                }
                new FieldWriter(classWriter, 1, fieldInfo3.name + "_asm_ser_", ObjectSerializer_desc).visitEnd();
            }
            i8++;
            str5 = str6;
        }
        String str7 = str5;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<SerializeBeanInfo> cls4 = SerializeBeanInfo.class;
        sb.append(ASMUtils.desc(cls4));
        sb.append(")V");
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", sb.toString(), null, null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(183, JavaBeanSerializer, "<init>", "(" + ASMUtils.desc(cls4) + ")V");
        int i9 = 0;
        while (i9 < fieldInfoArr4.length) {
            FieldInfo fieldInfo4 = fieldInfoArr4[i9];
            if (fieldInfo4.fieldClass.isPrimitive() || fieldInfo4.fieldClass == String.class) {
                fieldInfoArr2 = fieldInfoArr4;
                i7 = i9;
            } else {
                methodWriter.visitVarInsn(25, 0);
                if (fieldInfo4.method != null) {
                    methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo4.declaringClass)));
                    methodWriter.visitLdcInsn(fieldInfo4.method.getName());
                    fieldInfoArr2 = fieldInfoArr4;
                    i7 = i9;
                    methodWriter.visitMethodInsn(184, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    fieldInfoArr2 = fieldInfoArr4;
                    i7 = i9;
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitLdcInsn(Integer.valueOf(i7));
                    methodWriter.visitMethodInsn(183, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                methodWriter.visitFieldInsn(181, str4, fieldInfo4.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i9 = i7 + 1;
            fieldInfoArr4 = fieldInfoArr2;
        }
        FieldInfo[] fieldInfoArr5 = fieldInfoArr4;
        methodWriter.visitInsn(177);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
        if (jSONType != null) {
            for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        int i10 = 0;
        while (true) {
            JSONType jSONType2 = jSONType;
            cls = cls4;
            if (i10 >= 3) {
                break;
            }
            boolean z11 = z10;
            if (i10 == 0) {
                str2 = "write";
                z9 = z5;
                z8 = true;
            } else if (i10 == 1) {
                str2 = "writeNormal";
                z9 = z5;
                z8 = false;
            } else {
                str2 = "writeDirectNonContext";
                z8 = true;
                z9 = true;
            }
            boolean z12 = z5;
            String str8 = str7;
            int i11 = i10;
            FieldInfo[] fieldInfoArr6 = fieldInfoArr5;
            Context context = new Context(fieldInfoArr6, serializeBeanInfo, str4, z8, z9);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(L");
            String str9 = JSONSerializer;
            sb2.append(str9);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            MethodWriter methodWriter2 = new MethodWriter(classWriter, 1, str2, sb2.toString(), null, new String[]{"java/io/IOException"});
            Label label = new Label();
            boolean z13 = z9;
            FieldInfo[] fieldInfoArr7 = fieldInfoArr3;
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitJumpInsn(199, label);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitMethodInsn(182, str9, "writeNull", "()V");
            methodWriter2.visitInsn(177);
            methodWriter2.visitLabel(label);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitFieldInsn(180, str9, "out", SerializeWriter_desc);
            methodWriter2.visitVarInsn(58, context.var("out"));
            if (z11 || context.writeDirect || !(jSONType2 == null || jSONType2.alphabetic())) {
                fieldInfoArr = fieldInfoArr6;
            } else {
                Label label2 = new Label();
                methodWriter2.visitVarInsn(25, context.var("out"));
                fieldInfoArr = fieldInfoArr6;
                methodWriter2.visitMethodInsn(182, SerializeWriter, "isSortField", "()Z");
                methodWriter2.visitJumpInsn(154, label2);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(182, str4, "writeUnsorted", "(L" + str9 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodWriter2.visitInsn(177);
                methodWriter2.visitLabel(label2);
            }
            if (!context.writeDirect || z13) {
                cls2 = cls3;
                i6 = 177;
            } else {
                Label label3 = new Label();
                Label label4 = new Label();
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                cls2 = cls3;
                methodWriter2.visitMethodInsn(182, JavaBeanSerializer, "writeDirect", "(L" + str9 + ";)Z");
                methodWriter2.visitJumpInsn(154, label4);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(182, str4, "writeNormal", "(L" + str9 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodWriter2.visitInsn(177);
                methodWriter2.visitLabel(label4);
                methodWriter2.visitVarInsn(25, context.var("out"));
                methodWriter2.visitLdcInsn(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                methodWriter2.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
                methodWriter2.visitJumpInsn(153, label3);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(182, str4, "writeDirectNonContext", "(L" + str9 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i6 = 177;
                methodWriter2.visitInsn(177);
                methodWriter2.visitLabel(label3);
            }
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitTypeInsn(192, ASMUtils.type(cls2));
            methodWriter2.visitVarInsn(58, context.var("entity"));
            FieldInfo[] fieldInfoArr8 = fieldInfoArr;
            Class<?> cls5 = cls2;
            generateWriteMethod(cls5, methodWriter2, fieldInfoArr8, context);
            methodWriter2.visitInsn(i6);
            methodWriter2.visitMaxs(7, context.variantIndex + 2);
            methodWriter2.visitEnd();
            i10 = i11 + 1;
            fieldInfoArr5 = fieldInfoArr8;
            aSMSerializerFactory = this;
            cls3 = cls5;
            jSONType = jSONType2;
            cls4 = cls;
            z10 = z11;
            z5 = z12;
            str7 = str8;
            fieldInfoArr3 = fieldInfoArr7;
        }
        FieldInfo[] fieldInfoArr9 = fieldInfoArr3;
        boolean z14 = z5;
        FieldInfo[] fieldInfoArr10 = fieldInfoArr5;
        String str10 = str7;
        Class<?> cls6 = cls3;
        ASMSerializerFactory aSMSerializerFactory2 = aSMSerializerFactory;
        if (!z10) {
            Context context2 = new Context(fieldInfoArr10, serializeBeanInfo, str4, false, z14);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(L");
            String str11 = JSONSerializer;
            sb3.append(str11);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            MethodWriter methodWriter3 = new MethodWriter(classWriter, 1, "writeUnsorted", sb3.toString(), null, new String[]{"java/io/IOException"});
            methodWriter3.visitVarInsn(25, 1);
            methodWriter3.visitFieldInsn(180, str11, "out", SerializeWriter_desc);
            methodWriter3.visitVarInsn(58, context2.var("out"));
            methodWriter3.visitVarInsn(25, 2);
            methodWriter3.visitTypeInsn(192, ASMUtils.type(cls6));
            methodWriter3.visitVarInsn(58, context2.var("entity"));
            aSMSerializerFactory2.generateWriteMethod(cls6, methodWriter3, fieldInfoArr9, context2);
            methodWriter3.visitInsn(177);
            methodWriter3.visitMaxs(7, context2.variantIndex + 2);
            methodWriter3.visitEnd();
        }
        for (int i12 = 0; i12 < 3; i12++) {
            if (i12 == 0) {
                str = "writeAsArray";
                z7 = z14;
                z6 = true;
            } else if (i12 == 1) {
                str = "writeAsArrayNormal";
                z7 = z14;
                z6 = false;
            } else {
                str = "writeAsArrayNonContext";
                z6 = true;
                z7 = true;
            }
            Context context3 = new Context(fieldInfoArr10, serializeBeanInfo, str4, z6, z7);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("(L");
            String str12 = JSONSerializer;
            sb4.append(str12);
            sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            MethodWriter methodWriter4 = new MethodWriter(classWriter, 1, str, sb4.toString(), null, new String[]{"java/io/IOException"});
            methodWriter4.visitVarInsn(25, 1);
            methodWriter4.visitFieldInsn(180, str12, "out", SerializeWriter_desc);
            methodWriter4.visitVarInsn(58, context3.var("out"));
            methodWriter4.visitVarInsn(25, 2);
            methodWriter4.visitTypeInsn(192, ASMUtils.type(cls6));
            methodWriter4.visitVarInsn(58, context3.var("entity"));
            aSMSerializerFactory2.generateWriteAsArray(cls6, methodWriter4, fieldInfoArr10, context3);
            methodWriter4.visitInsn(177);
            methodWriter4.visitMaxs(7, context3.variantIndex + 2);
            methodWriter4.visitEnd();
        }
        byte[] byteArray = classWriter.toByteArray();
        return (JavaBeanSerializer) aSMSerializerFactory2.classLoader.defineClassPublic(str10, byteArray, 0, byteArray.length).getConstructor(cls).newInstance(serializeBeanInfo);
    }

    private void _nameApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(182, JavaBeanSerializer, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            methodVisitor.visitJumpInsn(153, label);
            _labelApply(methodVisitor, fieldInfo, context, label);
        }
        if (fieldInfo.field == null) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(154, label);
        }
    }

    private void _notWriteDefault(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (context.writeDirect) {
            return;
        }
        Label label2 = new Label();
        methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
        methodVisitor.visitJumpInsn(153, label2);
        Class<?> cls = fieldInfo.fieldClass;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long"));
            methodVisitor.visitInsn(9);
            methodVisitor.visitInsn(148);
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitInsn(11);
            methodVisitor.visitInsn(Opcodes.FCMPL);
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double"));
            methodVisitor.visitInsn(14);
            methodVisitor.visitInsn(151);
            methodVisitor.visitJumpInsn(153, label);
        }
        methodVisitor.visitLabel(label2);
    }

    private void _writeFieldName(MethodVisitor methodVisitor, Context context) {
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }
}

package astava.java;

import java.util.List;
import java.util.stream.Collectors;

public class Descriptor {
    public static final String BOOLEAN = "Z";
    public static final String BYTE = "B";
    public static final String SHORT = "S";
    public static final String INT = "I";
    public static final String LONG = "J";
    public static final String FLOAT = "F";
    public static final String DOUBLE = "D";
    public static final String CHAR = "C";
    public static final String VOID = "V";
    public static final String STRING = get(String.class);

    public static String get(Class<?> numberClass) {
        switch(numberClass.getTypeName()) {
            case "boolean": return Descriptor.BOOLEAN;
            case "byte": return Descriptor.BYTE;
            case "short": return Descriptor.SHORT;
            case "int": return Descriptor.INT;
            case "long": return Descriptor.LONG;
            case "float": return Descriptor.FLOAT;
            case "double": return Descriptor.DOUBLE;
            case "char": return Descriptor.CHAR;
            case "void": return Descriptor.VOID;
        }

        return numberClass.getName().replace(".", "/");
    }

    public static String getMethodDescriptor(List<Class<?>> parameterTypes, Class<?> returnTypes) {
        return getMethodDescriptor(parameterTypes.stream().map(c -> get(c)).collect(Collectors.toList()), get(returnTypes));
    }

    public static String getMethodDescriptor(List<String> parameterTypeNames, String returnTypeName) {
        StringBuilder mdBuilder = new StringBuilder();

        mdBuilder.append("(");
        for(int i = 0; i < parameterTypeNames.size(); i++) {
            String ptn = parameterTypeNames.get(i);
            mdBuilder.append(getMethodDescriptorPart(ptn));
        }
        mdBuilder.append(")");
        mdBuilder.append(getMethodDescriptorPart(returnTypeName));

        return mdBuilder.toString();
    }

    private static String getMethodDescriptorPart(String typeName) {
        switch(typeName) {
            case "V":
            case "Z":
            case "C":
            case "B":
            case "S":
            case "I":
            case "F":
            case "J":
            case "D":
                return typeName;
        }

        return "L" + typeName + ";";
    }
}

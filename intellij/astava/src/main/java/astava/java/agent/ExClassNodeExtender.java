package astava.java.agent;

import astava.java.parser.ClassInspector;
import astava.java.parser.ClassResolver;
import org.objectweb.asm.tree.ClassNode;

public interface ExClassNodeExtender {
    void transform(ClassNode classNode, ClassResolver classResolver, ClassInspector classInspector);
}

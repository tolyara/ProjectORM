package annotations;

import java.lang.annotation.*;

/**
 * Annotation for DB entities
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Model {
	
	String tableName();
	String primaryKey();
	
}

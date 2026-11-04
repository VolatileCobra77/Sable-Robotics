package ca.volatilecobra77.sable_robotics.Graph;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RobotNode {
    String id();
    String name();
    String category() default "General";
    String description() default "";

}

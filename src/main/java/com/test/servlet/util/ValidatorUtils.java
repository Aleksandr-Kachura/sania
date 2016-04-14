package com.test.servlet.util;


import com.test.servlet.exception.ValidationException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.integration.spring.BeanInjectingCheckInitializationListener;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatorUtils {

    //private Validator validator = new Validator();

    public void validate(Object o) throws ValidationException {
        AnnotationsConfigurer myConfigurer = new AnnotationsConfigurer();
        myConfigurer.addCheckInitializationListener(BeanInjectingCheckInitializationListener.INSTANCE);
        Validator validator = new Validator(myConfigurer);
        List<ConstraintViolation> violations = validator.validate(o);
        Map<String, String> map = new HashMap<String, String>();
        if (violations.size() > 0) {
            for (ConstraintViolation cs : violations) {
                OValContext c = cs.getContext();
                if (c instanceof FieldContext) {
                    Field field = ((FieldContext) c).getField();
                    map.put(field.getName(), cs.getMessage());
                }
            }
            throw new ValidationException(map);
        }
    }
}

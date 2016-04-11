package com.test.servlet.util;


import com.test.servlet.exception.ValidationException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatorUtils {

    private Validator validator = new Validator();

    public void validate(Object o) throws ValidationException {
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

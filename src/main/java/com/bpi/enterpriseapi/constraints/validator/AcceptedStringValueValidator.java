package com.bpi.enterpriseapi.constraints.validator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import com.bpi.enterpriseapi.constraints.AcceptedStringValue;
public class AcceptedStringValueValidator implements ConstraintValidator<AcceptedStringValue, String>{

	private Set<String> values;
	
    @Override
    public void initialize(AcceptedStringValue acceptedValues) {
        values = Arrays.stream(acceptedValues.value()).collect(Collectors.toSet());
    }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

        if (StringUtils.isBlank(value)) {
            return true;
        }
        return values.contains(value);
	}

}

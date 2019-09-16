package com.bpi.enterpriseapi.constraints.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bpi.enterpriseapi.constraints.AcceptedLength;

public class AcceptedLengthValidator implements ConstraintValidator<AcceptedLength, String>{
	
	private List<Integer> lengths;

    @Override
    public void initialize(AcceptedLength acceptedLength) {
        lengths = Arrays.stream(acceptedLength.value()).boxed().collect(Collectors.toList());
    }
	@Override
	public boolean isValid(String accountNumber, ConstraintValidatorContext constraintValidatorContext) {
		if (accountNumber == null) {
            return true;
        }
        return lengths.contains(accountNumber.length());
	}

}

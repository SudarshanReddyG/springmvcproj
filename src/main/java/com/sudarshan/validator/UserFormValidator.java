package com.sudarshan.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sudarshan.model.AppUser;

@Component
public class UserFormValidator implements Validator {
	
	@Autowired
	EmailValidator emailValidator;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AppUser.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		AppUser userObj = (AppUser) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.userForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");
		
		if(!emailValidator.valid(userObj.getEmail())) {
			errors.rejectValue("email", "Pattern.userForm.email");
		}
		
		if(userObj.getNumber()==null || userObj.getNumber()<=0){
			errors.rejectValue("number", "NotEmpty.userForm.number");
		}
		
		if(userObj.getCountry().equalsIgnoreCase("none")){
			errors.rejectValue("country", "NotEmpty.userForm.country");
		}
		
		if (!userObj.getPassword().equals(userObj.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
		}
		
		if (userObj.getFramework() == null || userObj.getFramework().size() < 2) {
			errors.rejectValue("framework", "Valid.userForm.framework");
		}

		if (userObj.getSkill() == null || userObj.getSkill().size() < 3) {
			errors.rejectValue("skill", "Valid.userForm.skill");
		}
	}

}

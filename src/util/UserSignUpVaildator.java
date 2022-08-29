package util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user.service.IdCheckService;

public class UserSignUpVaildator {
	
	
	private void idCheck(Map<String, Boolean> errors, String id) {
		Pattern pattern = Pattern.compile("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$");
		Matcher matcher = pattern.matcher(id);
		IdCheckService idc = new IdCheckService();
		
		if ( id.length() > 50) {
			errors.put("id: 길이 에러-아이디는 50자 이내로 작성해주세요.", true);
		}
		if (! matcher.matches()) {
			errors.put("id: 지정되지 않은 문자 혹은 형식. 올바른 이메일주소를 입력해주세요.", true);
		}
		if (idc.idCheck(id)) {
			errors.put("id: 이 아이디는 이미 다른 사용자가 이용하고 있는 아이디입니다.", true);
		}
	}
	
	private void pwCheck(Map<String, Boolean> errors, String pw) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9~!@#$%^&*()]{4,20}");
		Matcher matcher = pattern.matcher(pw);
		
		if (pw.length() > 20 || pw.length() < 4) {
			errors.put("pw: 길이 에러. 4자 이상 20자 이하로 입력하세요.", true);
		}
		if (!matcher.matches()) {
			errors.put("pw: 지정되지 않은 문자 사용. 입력조건을 다시 확인해 주세요.", true);
		}
	}
	
	private void nameCheck(Map<String, Boolean> errors, String name) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9가-힣]{2,12}");
		Matcher matcher = pattern.matcher(name);
		if (name.length() > 12 || name.length() < 2) {
			errors.put("name: 길이 에러. 2자 이상 12자 이하로 입력하세요.", true);
		}
		if (!matcher.matches()) {
			errors.put("name: 지정되지 않은 문자 사용. 입력조건을 다시 확인해 주세요.", true);
		}
	}
	
	public void vaildate(Map<String, Boolean> errors, String id, String pw, String name, String confirmPw) {
		idCheck(errors, id);
		pwCheck(errors, pw);
		nameCheck(errors, name);
		if (! (pw.equals(confirmPw))) {
			errors.put("pw: 패스워드와 패스워드확인 값이 불일치합니다.", true);
		}
	}
}

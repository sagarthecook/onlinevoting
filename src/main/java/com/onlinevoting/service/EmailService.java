
package com.onlinevoting.service;

import com.onlinevoting.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class EmailService {

	@Autowired
	private EmailUtil emailUtil;

	public void sendTemplatedEmail(String to, String subject, String template,
	 Map<String, Object> variables) throws Exception{
		emailUtil.sendEmailWithTemplate(to, subject, template, variables);
	}
}



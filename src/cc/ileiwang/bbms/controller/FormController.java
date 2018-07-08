package cc.ileiwang.bbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.ileiwang.bbms.service.BBMSService;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018年5月11日 下午1:56:16
 */
@Controller
public class FormController {

	@Autowired
	@Qualifier("Service")
	private BBMSService Service;

	@RequestMapping(value = "/{formName}")
	public String formName(@PathVariable String formName) {
		return formName;
	}
}

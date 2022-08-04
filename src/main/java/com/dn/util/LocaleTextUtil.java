package com.dn.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * i18n 国际化 工具类
 */
@Component
public class LocaleTextUtil {

	private static MessageSource messageSource;

	public LocaleTextUtil(MessageSource messageSource) {
		LocaleTextUtil.messageSource = messageSource;
	}

	/**
	 * 获取单个国际化翻译值
	 */
	public static String get(String msgKey) {
		try {
			return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
		} catch (Exception e) {
			return msgKey;
		}
	}

	/**
	 * 获取单个国际化翻译值 支持占位符替换
	 */
	public static String get(String msgKey, Object[] params) {
		try {
			return messageSource.getMessage(msgKey, params, LocaleContextHolder.getLocale());
		} catch (Exception e) {
			return msgKey;
		}
	}

	/**
	 * 获取单个国际化翻译值 指定语种
	 */
	public static String get(String msgKey, Locale locale) {
		try {
			return messageSource.getMessage(msgKey, null, locale);
		} catch (Exception e) {
			return msgKey;
		}
	}

	/**
	 * 获取单个国际化翻译值 指定语种 并支持占位符替换
	 * @param msgKey
	 * @param params
	 * @param locale
	 * @return
	 */
	public static String get(String msgKey, Object[] params, Locale locale) {
		try {
			return messageSource.getMessage(msgKey, params, locale);
		} catch (Exception e) {
			return msgKey;
		}
	}
}

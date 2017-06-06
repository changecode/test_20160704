package com.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * 三级审核
 * 
 * @author Tim
 *
 */
public class CountryListener implements SmartApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (((AuditEvent) event).getStatus()) {
			System.out.println(
					"获取当前的申报状态为：" + ((AuditEvent) event).getStatus() + "——" + ((AuditEvent) event).getAdvice());
			((AuditEvent) event).setStatus(true);
			((AuditEvent) event).setAdvice("国家审核意见：一般般，勉强通过吧！");
		}
	}

	@Override
	public int getOrder() {
		return 3;
	}

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == AuditEvent.class;
	}

	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == Publisher.class;
	}

}

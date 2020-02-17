package ePuntual.builder;

import ePuntual.presentacion.OrderManager;

public class BuilderFactory {
	
	public UIBuilder getUIBuilder(String str) {
		UIBuilder builder = null;
		if (str.equals(OrderManager.CA_ORDER)) {
			builder = new CaliforniaOrderBuilder();
		} else if (str.equals(OrderManager.NON_CA_ORDER)) {
			builder = new NonCaliforniaOrderBuilder();
		}else if (str.equals(OrderManager.OVERSEAS_ORDER)) {
			builder = new OverseasOrderBuilder();
		}
		return builder;
	}
}
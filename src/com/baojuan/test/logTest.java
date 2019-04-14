package com.baojuan.test;

import org.apache.log4j.Logger;

public class logTest {
	public static void main(String[] args) {
		Logger  logger=Logger.getLogger("flower.class");
		logger.info("普通信息");
	}
}

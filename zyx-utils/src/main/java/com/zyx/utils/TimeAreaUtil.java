package com.zyx.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeAreaUtil {
	public static String TIME_AREA_START = "start";
	public static String TIME_AREA_END = "end";
	private static Long LONG_DAY = 24*60*60*1000L;
	/**
	 * 获取天时间范围
	 * @param dayOffset 当前天0开始 前后以天为单位 位移量
	 * @return
     */
	public static Map<String,Long> getDayTimeArea(Integer dayOffset){

		Date date = new Date(System.currentTimeMillis()+LONG_DAY*dayOffset);
		Calendar calendar = Calendar.getInstance();
		Map<String,Long> timeArea = new HashMap<String,Long>();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		timeArea.put(TIME_AREA_START,calendar.getTimeInMillis());
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND,999);
		timeArea.put(TIME_AREA_END,calendar.getTimeInMillis());
		return timeArea;
	}

	public static void main(String[] args) {
		System.out.println(getDayTimeArea(-1));
		Map<String, Long> map = getDayTimeArea(-1);
		SimpleDateFormat fomate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fomate.format(new Date(map.get(TIME_AREA_START))));
		System.out.println(fomate.format(new Date(map.get(TIME_AREA_END))));
	}
}

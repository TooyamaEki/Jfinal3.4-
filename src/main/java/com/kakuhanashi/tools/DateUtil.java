package com.kakuhanashi.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取当前时间到某一天的倒计时秒数 Frank - 2017-5-18 11:10:46
	 * 
	 * @param date日期
	 * @return,只返回正数
	 */
	public static long getCountDown(String date) {
		long l = System.currentTimeMillis();
		long end = getDateMillis(date);
		if (end - l <= 1000) {
			return 0;
		}
		return (end - l) / 1000;
	}

	public static String getNowTime() {
		// 得到long类型当前时间
		long l = System.currentTimeMillis();
		// new日期对象
		Date date = new Date(l);
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * 获取当前月份 Frank - 2016-09-21 17:58:36
	 * 
	 * @return 月份
	 */
	public static String getNowMonth() {
		// 得到long类型当前时间
		long l = System.currentTimeMillis();
		// new日期对象
		Date date = new Date(l);
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		return dateFormat.format(date);
	}

	public static String getNowMonthFirstDay() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	public static String addMonth(String monthDate, int amount) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date date;
		try {
			date = dateFormat.parse(monthDate);
			date = addMonths(date, amount);
			return dateFormat.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getNowMonth();
		/*
		 * String s = monthDate.replaceAll("-", ""); String s1 =
		 * (Integer.valueOf(s) + amount) +""; return s1.substring(0, 4) + "-" +
		 * s1.substring(3);
		 */
	}

	/**
	 * 
	 * @return
	 */
	public static String getNextMonthFirstDay() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	public static String getNowDay() {
		// 得到long类型当前时间
		long l = System.currentTimeMillis();
		// new日期对象
		Date date = new Date(l);
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	// 格式 02-04 17:39:41
	public static String getShotTime(Timestamp time) {
		return time.toString().substring(5, 16);
	}

	public static String getTime(long currentTimeMillis) {
		Date date = new Date(currentTimeMillis);
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String getDay() {
		Date date = new Date(System.currentTimeMillis());
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}

	/**
	 * 获取日期 Frank - 2016-11-15 15:29:03
	 * 
	 * @param date
	 *            字符串日期
	 * @return date
	 */
	public static Date getDay(String date) {
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取日期到月份 Frank - 2016-11-15 15:29:03
	 * 
	 * @param date
	 *            字符串日期
	 * @return date
	 */
	public static Date getMonth(String date) {
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getDateTime(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String getBirthday(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	public static Date addYears(Date date, int amount) {
		return add(date, 1, amount);
	}

	public static Date addMonths(Date date, int amount) {
		return add(date, 2, amount);
	}

	public static Date addWeeks(Date date, int amount) {
		return add(date, 3, amount);
	}

	public static Date addDays(Date date, int amount) {
		return add(date, 5, amount);
	}

	public static String addDays(int amount) {
		return getBirthday(add(new Date(System.currentTimeMillis()), 5, amount));
	}

	public static String addHours(Date date, int amount) {
		return getDateTime(add(date, 11, amount));
	}

	public static String addMinutes(Date date, int amount) {
		return getDateTime(add(date, 12, amount));
	}

	public static String addMinutes(int amount) {
		return getBirthday(add(new Date(System.currentTimeMillis()), 12, amount));
	}

	public static Date addSeconds(Date date, int amount) {
		return add(date, 13, amount);
	}

	public static Date addMilliseconds(Date date, int amount) {
		return add(date, 14, amount);
	}

	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("date must not be null!");
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(calendarField, amount);
			return c.getTime();
		}
	}

	/**
	 * 获取时间戳与当前时间相减后天数
	 * 
	 * @param timestamp
	 *            时间戳
	 * @return String
	 */
	public static String getRestTime(String timestamp) {
		int days = 0;
		long expire = new Long(timestamp);
		long today = System.currentTimeMillis();
		if (expire - today <= 0) {
			return "已到期";
		} else {
			days += (int) ((expire - today) / (1000 * 3600 * 24));
			double rest = (((double) expire - (double) today) / (1000 * 3600 * 24)) % days;
			if (rest > 0) {
				days += 1;
			}
			return days + "天";
		}
	}

	/**
	 * 根据时间返回时间戳 Frank - 2016-10-05 15:16:55
	 * 
	 * @param time
	 *            时间
	 * @return long
	 */
	public static Long getTimeMillis(String time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			d = dateFormat.parse(time);
			return d.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0L;
	}

	public static Long getDateMillis(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = dateFormat.parse(date);
			return d.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0L;
	}

	/**
	 * 返回某一天到现在的毫秒数,负数为已过期的
	 * 
	 * @param day
	 * @return
	 */
	public static int getSeconds(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = dateFormat.parse(date);
			return (int) (d.getTime() - System.currentTimeMillis());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取距离某一日期某个天数的日期
	 * 
	 * @author pomi
	 * @create_time 2016年11月7日 下午3:12:11
	 * @param date
	 * @param day
	 * @return
	 */
	public static String accessOtherDate(String date, int day) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(format.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.add(Calendar.DATE, day);
		return format.format(calendar.getTime());
	}

	/**
	 * 字符串转日期yyyy-MM-dd
	 * 
	 * @author pomi
	 * @create_time 2016年11月8日 下午2:40:15
	 * @param time
	 * @return
	 */
	public static String getDateTime(String time) {
		String date = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = format.parse(time).toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取两个日期相差的天数
	 * 
	 * @author pomi
	 * @create_time 2016年11月8日 下午2:46:12
	 * @param dayMin
	 *            被减日期
	 * @param dayMax
	 * @return
	 */
	public static long getSubdays(String dayMin, String dayMax) {
		Date beginDate = null;
		Date endDate = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			beginDate = format.parse(dayMin);
			endDate = format.parse(dayMax);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long days = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		return days;
	}

	/**
	 * 获取对应天数几天后0点的时间戳
	 * 
	 * @author pomi
	 * @create_time 2017年5月24日 下午12:22:02
	 * @param day
	 *            天数
	 * @return
	 */
	public static long getAddDaysMills(int day) {
		if (day < 0) {
			return 0L;
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis();
	}

}

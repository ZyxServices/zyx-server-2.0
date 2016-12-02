import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.zyx.entity.venue.Venue;
import com.zyx.param.record.RankParam;
import com.zyx.param.record.SportRecordParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.rpc.record.SportRecordFacade;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class Test extends TestCase {
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public Test(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static TestSuite suite() {
		return new TestSuite(Test.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
		try {
			System.out.println("-------------------------");
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:spring/spring-context.xml");

			SportRecordFacade test = (SportRecordFacade) context.getBean("sportRecordFacade");
//			VenueParam param =  new VenueParam();
//			param.setLatitude(100.000000);
//			param.setLongitude(-100.000000);
//			param.setRadius(10.000000);
//			List<Venue> list = test.getVenues(param);
//			System.out.println(JSON.toJSONString(list));

//			获取用户足迹
//			System.out.println(JSON.toJSONString(test.getFootprints(1,null)));

			//获取各人运动概况
//			System.out.println(JSON.toJSONString(test.getSelfRecordOverview(1)));

			//获取场馆列表
//			VenueParam param =  new VenueParam();
//			param.setLatitude(120.000000);
//			param.setLongitude(100.000000);
//			param.setRadius(10.000000);
//			List<Venue> list = test.getVenues(param);
//			System.out.println(JSON.toJSONString(list));

			//保存运动记录
//			test.uploadSportRecord(1,2,2,500L);

//			SportRecordParam param =new SportRecordParam();
//			param.setUserId(1);
//			System.out.println(JSON.toJSONString(test.getHistoryRecords(param)));

//			RankParam param = new RankParam();
//			System.out.println(JSON.toJSONString(test.getRanks(param)));
//			param.setUserId(169);
//			System.out.println(JSON.toJSONString(test.getSelfRank(param)));
//			test.getFootprints(1,null);

//			System.out.println(JSON.toJSONString(test.getVenueFootprints(1,"北京")));

			System.out.println(JSON.toJSONString(test.getCityFootprints(168)));
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("== DubboProvider context start error:",e);
		}

		synchronized (Test.class) {
			while (true) {
				try {
					Test.class.wait();
				} catch (InterruptedException e) {
					// log.error("== synchronized error:",e);
				}
			}
		}
		//
	}
}

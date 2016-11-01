
import com.alibaba.fastjson.JSON;
import com.zyx.constants.coin.CoinConstants;
import com.zyx.rpc.coin.SportCoinFacade;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Test extends TestCase {

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

			SportCoinFacade test = (SportCoinFacade) context.getBean("sportCoinFacade");
			test.modify(2, CoinConstants.OperType.PUBLISH_ACTIVITY.getOperType());
			System.out.println(JSON.toJSONString(test.search(1)));
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


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zyx.rpc.test.TestFracade;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import junit.framework.TestCase;
import junit.framework.TestSuite;

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

			TestFracade test = (TestFracade) context.getBean("testFracade");
			long start = System.currentTimeMillis();
			for(int i=0;i<100;i++){
				long t1 = System.currentTimeMillis();
				test.modify(i+1,(i)%8+1,2L);
				long t2 = System.currentTimeMillis();
				System.out.println("本次用时："+(t2-t1));
			}
			long end = System.currentTimeMillis();
			System.out.println("100 times RPC spend time :"+(end-start));
//			System.out.println();
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

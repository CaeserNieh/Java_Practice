
 

import org.junit.Assert;
import org.junit.Test;
 

public class unittest {
	@Test
	public static void test1(){
		testcase ts = new testcase();
		Assert.assertEquals("9:23 AM",ts.addminute("9:13 AM",10) );
	}
}

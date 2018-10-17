import java.util.Random;

public class Utils {

	public static int randomInt (int max) {
		Random r = new Random();
		int val = r.nextInt();
		val = Math.abs(val);
		val = val % max;
		val += 1;
		return val;
	}
}
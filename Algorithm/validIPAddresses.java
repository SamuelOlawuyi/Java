//QUESTION
/*
You're given a string of length 12 or smaller, containing only digits. Write a function that returns all the possible IP addresses that can be created by inserting three .s in the string.

An IP address is a sequence of four positive integers that are separated by .s, where each individual integer is within the range 0 - 255, inclusive.

An IP address isn't valid if any of the individual integers contains leading 0s. For example, "192.168.0.1" is a valid IP address, but "192.168.00.1" and "192.168.0.01" aren't, because they contain "00" and 01, respectively. Another example of a valid IP address is "99.1.1.10"; conversely, "991.1.1.0" isn't valid, because "991" is greater than 255.

Your function should return the IP addresses in string format and in no particular order. If no valid IP addresses can be created from the string, your function should return an empty list.

Sample Input
string = "1921680"
Sample Output
[
  "1.9.216.80",
  "1.92.16.80",
  "1.92.168.0",
  "19.2.16.80",
  "19.2.168.0",
  "19.21.6.80",
  "19.21.68.0",
  "19.216.8.0",
  "192.1.6.80",
  "192.1.68.0",
  "192.16.8.0"
]
 The IP addresses could be ordered differently.
*/

//Solutions
import java.util.*;

class Challenge {

  public ArrayList<String> validIPAddresses(String string) {
    ArrayList<String> validIPs = new ArrayList<>();
    generateIPAddresses(string, 0, new ArrayList<>(), validIPs);
    return validIPs;
  }

  private void generateIPAddresses(String remaining, int segments, ArrayList<String> currentIP, ArrayList<String> validIPs) {
    if (segments == 4) {
      if (remaining.isEmpty()) {
        validIPs.add(String.join(".", currentIP));
      }
      return;
    }

    for (int i = 1; i <= Math.min(3, remaining.length()); i++) {
      String segment = remaining.substring(0, i);
      if (isValidSegment(segment)) {
        currentIP.add(segment);
        generateIPAddresses(remaining.substring(i), segments + 1, currentIP, validIPs);
        currentIP.remove(currentIP.size() - 1);
      }
    }
  }

  private boolean isValidSegment(String segment) {
    if (segment.length() > 1 && segment.charAt(0) == '0') {
      return false; // Leading zeros are not allowed
    }
    int value = Integer.parseInt(segment);
    return value >= 0 && value <= 255;
  }

  public static void main(String[] args) {
    Challenge challenge = new Challenge();
    String input = "1921680";
    ArrayList<String> result = challenge.validIPAddresses(input);
    for (String ip : result) {
      System.out.println(ip);
    }
  }
}

//TEST

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChallengeTest {
	@Test
	public void TestCase1() {
      String input = "1921680";

      ArrayList<String> expected = new ArrayList<String>() {{
		add("1.9.216.80");
		add("1.92.16.80");
		add("1.92.168.0");
		add("19.2.16.80");
		add("19.2.168.0");
		add("19.21.6.80");
		add("19.21.68.0");
		add("19.216.8.0");
		add("192.1.6.80");
		add("192.1.68.0");
		add("192.16.8.0");
      }};
      
      var actual = new Challenge().validIPAddresses(input);
      assertTrue(expected.equals(actual));
	}
	@Test
	public void TestCase2() {
		String input = "3700100";
		ArrayList<String> expected = new ArrayList<String>(
			Arrays.asList(
				"3.70.0.100",
				"37.0.0.100"
		));

		var actual = new Challenge().validIPAddresses(input);
		assertTrue(expected.equals(actual));
	}
	@Test
	public void TestCase3() {
		String input = "9743";
		ArrayList<String> expected = new ArrayList<String>(
			Arrays.asList(
				"9.7.4.3"
		));

		var actual = new Challenge().validIPAddresses(input);
		assertTrue(expected.equals(actual));
	}
	@Test
	public void TestCase4() {
		String input = "97430";
		ArrayList<String> expected = new ArrayList<String>(
			Arrays.asList(
				"9.7.4.30",
				"9.7.43.0",
				"9.74.3.0",
				"97.4.3.0"
		));

		var actual = new Challenge().validIPAddresses(input);
		assertTrue(expected.equals(actual));
	}
	@Test
	public void TestCase5() {
		String input = "997430";
		ArrayList<String> expected = new ArrayList<String>(
			Arrays.asList(
				"9.9.74.30",
				"9.97.4.30",
				"9.97.43.0",
				"99.7.4.30",
				"99.7.43.0",
				"99.74.3.0"
		));

		var actual = new Challenge().validIPAddresses(input);
		assertTrue(expected.equals(actual));
	}
}

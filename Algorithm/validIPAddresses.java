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

package starter.volume;

import java.io.*;
import java.util.*;

public class Volume {

  public static String volumePath;
  public final String NT_SETUP_PATH = "./neoTextilSetup-8.6.1-b.1.dmg";

  public static List<String> runCommandForOutput(List<String> params) {
    ProcessBuilder pb = new ProcessBuilder(params);
    Process p;
    List<String> sj = new ArrayList<String>();
    try {
      p = pb.start();
      final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

      reader.lines().forEach(x -> sj.add(x));
      reader.lines().forEach(x -> System.out.println(x));

      System.out.println("errCode = " + p.waitFor());
      p.destroy();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sj;
  }

  public void mount(String dmg) {
    System.out.println("[DEBUG] Mounting...");
    List<String> mounting =
        runCommandForOutput(Arrays.asList("hdiutil", "attach", dmg, "-verbose"));
    mounting.forEach(x -> System.out.println(x));
    volumePath = mounting.get(mounting.size() - 1).split("\\s+")[0];
  }

  public void unmount(String volume) {
    System.out.println("[DEBUG] Unmounting...");
    List<String> unmounting =
        runCommandForOutput(Arrays.asList("hdiutil", "detach", volume, "-verbose"));
    unmounting.forEach(x -> System.out.println(x));
  }
}

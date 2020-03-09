package starter.files;
import java.nio.*;
import java.io.*;
import java.util.*;

public class Plugins {
  final String  PHOTOSHOP_PATH = "/Applications/Adobe Photoshop";
  // final String  PHOTOSHOP_TWENTY_PATH = PHOTOSHOP_PATH + " 2020/;
  final String  NT_PLUGINS_PATH = "/Plug-ins/nT8";
  final String  NT_PLUGINS_BACKUP = "/Plug-ins/com.inedit.neotextil.plugins.zip";
  final String  PANELS_PATH = "/Library/Application Support/Adobe/CEP/extensions";
  final String  NT_DATA = "/Documents/neoTextil";

  // what happens the first time you test it?...
  public boolean previousVersionIsBackedUp(String ver) {
    String backupPath = PHOTOSHOP_PATH + " " + ver + NT_PLUGINS_BACKUP;
    File backup = new File(backupPath);
    return backup.exists();
  }

  public boolean currentVersionIsInstalled(String ver) {
    String nTPath = PHOTOSHOP_PATH + " " + ver + NT_PLUGINS_PATH;
    File nTFolder = new File(nTPath);
    List<File> files = Arrays.asList(nTFolder.listFiles());
    files.forEach(x -> System.out.println(x.getName()));
    return nTFolder.exists()
      && files.stream().anyMatch(x -> x.getName().contains("nT_Halftone_Channels.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Repeat_View.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Indexed2Multichannel.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Stork_GRT.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Masquerade.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Stork_PUB.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Multicomia.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Stork_SEP.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_PEC.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Trapping.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Activation_Manager.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Rapport.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Virtual_Vision.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Colorations.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Rapport_Monitor.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("neoRipEngine"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Coverage.plugin"))
      && files.stream().anyMatch(x -> x.getName().contains("nT_Repeat.plugin"));
  }

  public boolean panelIsBackedUpAndInstalled() {
    File panelFolder = new File(PANELS_PATH);
    List<File> files = Arrays.asList(panelFolder.listFiles());
    files.forEach(x -> System.out.println(x.getName()));
    return panelFolder.exists()
      && files.stream().anyMatch(x -> x.getName().contains("neoTextilPanel"))
      && files.stream().anyMatch(x -> x.getName().contains("neoCatalogPanel"))
      && files.stream().anyMatch(x -> x.getName().contains("QuickPrintPanel"))
      && files.stream().anyMatch(x -> x.getName().contains("StepAndRepeat"))
      && files.stream().anyMatch(x -> x.getName().contains("com.inedit.neotextil.panels.zip"));
  }
  // ^ These could or should be abstracted...
  // As above, so below. v
  // There is one advantage to doing it like this though.
  public boolean userDataIsInstalled() {
    String dataFolderPath = System.getProperty("user.home") + NT_DATA;
    File dataFolder = new File(dataFolderPath);
    List<File> files = Arrays.asList(dataFolder.listFiles());
    files.forEach(x -> System.out.println(x.getName()));
    return dataFolder.exists()
      && files.stream().anyMatch(x -> x.getName().contains("ColorLibraries"))
      && files.stream().anyMatch(x -> x.getName().contains("ImageData"))
      && files.stream().anyMatch(x -> x.getName().contains("Layouts"))
      && files.stream().anyMatch(x -> x.getName().contains("Licenses"))
      && files.stream().anyMatch(x -> x.getName().contains("Templates"));
  }
}

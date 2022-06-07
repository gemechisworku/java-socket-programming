import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DeviceInfo {
    static Disk c = findDiskSpace("C:");
    static Disk d = findDiskSpace("D:");
    public static void main(String[] args) {
        findTotalUsage();
    }

    public static Disk findDiskSpace(String diskName){
//        System.out.println("Disk usage info of Disk-" + diskName);
        File disk = new File(diskName);

        Double totalSpace = (double)disk.getTotalSpace() /1073741824;
        Double freeSpace = (double)disk.getFreeSpace() /1073741824;
        Double usedSpace = totalSpace - freeSpace;

//        System.out.println(String.format("\t\tTotal space of disk %s %.2f GB", diskName, totalSpace));
//        System.out.println(String.format("\t\tUsed space of disk  %s %.2f GB", diskName, usedSpace));
//        System.out.println(String.format("\t\tFree space of disk  %s %.2f GB", diskName,freeSpace));
//        System.out.println("");

        return (new Disk(totalSpace, usedSpace, freeSpace));
    }

    public static List<Double> findTotalUsage(){
        Double totalSpace = c.totalSpace + d.totalSpace;
        Double usedSpace = c.usedSpace + d.usedSpace;
        Double freeSpace = c.freeSpace + d.freeSpace;

//        System.out.println("Total Disk Usage Info:");
//        System.out.println(String.format("\t\tTotal space: %.2f GB", totalSpace));
//        System.out.println(String.format("\t\tUsed space:  %.2f GB", usedSpace));
//        System.out.println(String.format("\t\tFree space:  %.2f GB", freeSpace));

        return (new ArrayList<Double>() {{
            add(totalSpace);
            add(usedSpace);
            add(freeSpace);
        }
        });
    }
    static class Disk{
        Double freeSpace, usedSpace, totalSpace;
        public Disk(Double totalSpace, Double usedSpace, Double freeSpace) {
            this.freeSpace = freeSpace;
            this.usedSpace = usedSpace;
            this.totalSpace = totalSpace;
        }
    }
}

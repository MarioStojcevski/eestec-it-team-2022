import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class F1Test {

    public static void main(String[] args) {
        F1Race f1Race = new F1Race();
        f1Race.readResults(System.in);
        f1Race.printSorted(System.out);
    }

}

class Driver implements Comparable<Driver>{
    String name;
    String []laps;

    public Driver(String name, String lap1, String lap2, String lap3) {
        this.name = name;
        laps = new String[3];
        laps[0] = lap1;
        laps[1] = lap2;
        laps[2] = lap3;
    }

    private String bestLap() {
        return Arrays.stream(laps)
                .min(String::compareTo)
                .orElse(null);
    }

    @Override
    public int compareTo(Driver driver) {
        return bestLap().compareTo(driver.bestLap());
    }

    @Override
    public String toString() {
        return String.format("%-10s%10s", name, bestLap());
    }


}
class F1Race {
    // vashiot kod ovde
    List<Driver> drivers;

    public F1Race() {
        drivers = new ArrayList<Driver>();
    }


    public void readResults(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        drivers = br.lines()
                .map(line ->{
                    String dataParts[] = line.split(" ");
                    return new Driver(dataParts[0], dataParts[1], dataParts[2], dataParts[3]);
                })
                .collect(Collectors.toList());
    }


    public void printSorted(PrintStream out) {
        PrintWriter pw = new PrintWriter(out);

        drivers.sort(null);

        for (int i = 1; i <= drivers.size(); i++) {
            pw.printf("%d. %s\n", i, drivers.get(i-1).toString());
        }

        pw.flush();
    }
}
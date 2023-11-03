import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Average each row of ten test scores
 */
public class ScannerReadCSVFile
{
    public void run() throws FileNotFoundException {
        //Initial title
        System.out.println("Class: Avg score");
        
        // Mr. Jaffe's code to read data from a file
        // Instantiate a File object
        File dataFile = new File("TestScoresByClass.csv");

        // Instantiate a Scanner object that uses the file
        Scanner scanner = new Scanner(dataFile);

        // Set the delimiter as a new-line character so we can read the
        // data one line at a time
        scanner.useDelimiter("\n");

        // Continue while there's still data in the file to be read
        while (scanner.hasNext()) {
            // Read the next line of the file
            String line = scanner.nextLine() + ",";
            Scanner scan = new Scanner(line);
            scan.useDelimiter(",");
            // line now contains a line of comma-separated numbers
            // representing 10 test scores for each class.
            //
            // Your job is to parse the numbers into individual test scores using
            // another Scanner variable using a comma as the delimiter.  
            // 
            // Read the ten test scores and average them together.  The first
            // number is the class number and the next 10 numbers are the 
            // test scores.  
            //
            // You need to compute the average and print for each class the class
            // number, then the average score.  The first few lines should look
            // like this:
            //
            // Class: Avg score
            // 2125:  55
            // 1628:  47
            //
            // Pay attention to the spacing on your output
            //
            // Write your code in the space below!
            
            //prepering veriables for average calculations
            
            int values = 0;
            int sum = 0;
            int avg = 0;
            if(scan.hasNextInt()){
                while(scan.hasNextInt()){
                    int num = scan.nextInt();
                    if(num > 101){
                        System.out.print(num + ": ");
                    }
                    else{
                        sum += num;
                        values++;
                    }
                }
                avg = sum / values;
                System.out.println(avg);
                scanner.useDelimiter("\n");
            }
        }
    }

    public static void main (String[] args) {
        try {
            ScannerReadCSVFile srCsv = new ScannerReadCSVFile();
            srCsv.run();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("There's an error someplace. Try using the debugger to find it!");

        }
    }
}

class HarmonicSeries {
 

    // this is a main function

    public static void main(String args[])

    {
 

        // num is the number of values we want in a series

        int num = 5;

        double result = 0.0;
 

        System.out.println("The harmonic series is: ");
 

        // printing the harmonic series till num value

        // using while loop

        while (num > 0) {
 

            // calculating harmonic values

            result = result + (double)1 / num;
 

            // after calculating harmonic value

            // decrementing num by 1 which means the common

            // difference is 1

            num--;

            System.out.print(result + ", ");

        }

    }
}

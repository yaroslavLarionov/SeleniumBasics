package SeleniumUseCases;

public class MavenCommands {
    public static void main(String[] args) {

        /**
         * Run all the test classes:
         *     mvn test
         *
         * Run a single test class
         *    mvn -Dtest=NameOfTheClass test
         *
         * Run multiple test classes
         *   mvn -Dtest=NameOfTheClass, NameOfTheClass2 test
         *
         * Run a single test method from a test class
         *   mvn -Dtest=MyClassName#methodname test
         *
         * Run all test methods that match pattern 'methodNamePattern*' from MyClassName
         *   mvn test -Dtest=MyClassName#methodname* test
         */



    }
}

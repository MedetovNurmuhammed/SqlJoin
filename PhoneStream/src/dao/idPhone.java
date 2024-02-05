package dao;

public class idPhone {

        private static int counter = 0;
        public static int geneteId(){

            return ++counter;
        }


}

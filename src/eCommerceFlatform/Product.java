//package eCommerceFlatform;
//import java.util.*;
//
//public class Product {
//    public Product() {}
//    //상품의 종류에는 옷, 전자기기, 책이 있고
//    //이 들은 상품과 밀접한 관계이므로 중첩클래스로 표현함
//    public static class clothes {
//        private static String clothesName;
//        private static int clothesPrice;
//        private static String clothesIntroduction;
//
//        clothes(String clothesName, int clothesPrice, String clothesIntroduction) {
//            Product.clothes.clothesName = clothesName;
//            Product.clothes.clothesPrice = clothesPrice;
//            Product.clothes.clothesIntroduction = clothesIntroduction;
//        }
//        public static void setClothesName(String clothesName) {
//            Product.clothes.clothesName = clothesName;
//        }
//
//        public static void setClothesPrice(int clothesPrice) {
//            Product.clothes.clothesPrice = clothesPrice;
//        }
//
//        public static void setClothesIntroduction(String clothesIntroduction) {
//            Product.clothes.clothesIntroduction = clothesIntroduction;
//        }
//
//        public static String getClothesName() {
//            return clothesName;
//        }
//
//        public static int getClothesPrice() {
//            return clothesPrice;
//        }
//
//        public static String getClothesIntroduction() {
//            return clothesIntroduction;
//        }
//    }
//
//    public static class devices {
//        private static String devicesName;
//        private static int devicesPrice;
//        private static String devicesIntroduction;
//
//        devices(String devicesName, int devicesPrice, String devicesIntroduction) {
//            Product.devices.devicesName = devicesName;
//            Product.devices.devicesPrice = devicesPrice;
//            Product.devices.devicesIntroduction = devicesIntroduction;
//        }
//
//        public static void setDevicesName(String devicesName) {
//            Product.devices.devicesName = devicesName;
//        }
//
//        public static void setDevicesPrice(int devicesPrice) {
//            Product.devices.devicesPrice = devicesPrice;
//        }
//
//        public static void setDevicesIntroduction(String devicesIntroduction) {
//            Product.devices.devicesIntroduction = devicesIntroduction;
//        }
//
//        public static String getDevicesName() {
//            return devicesName;
//        }
//
//        public static int getDevicesPrice() {
//            return devicesPrice;
//        }
//
//        public static String getDevicesIntroduction() {
//            return devicesIntroduction;
//        }
//    }
//
//    public static class books {
//        private static String booksName;
//        private static int booksPrice;
//        private static String booksIntroduction;
//
//        books(String booksName, int booksPrice, String booksIntroduction) {
//            Product.books.booksName = booksName;
//            Product.books.booksPrice = booksPrice;
//            Product.books.booksIntroduction = booksIntroduction;
//        }
//
//        public static void setBooksName(String booksName) {
//            Product.books.booksName = booksName;
//        }
//
//        public static void setBooksPrice(int booksPrice) {
//            Product.books.booksPrice = booksPrice;
//        }
//
//        public static void setBooksIntroduction(String booksIntroduction) {
//            Product.books.booksIntroduction = booksIntroduction;
//        }
//
//        public static int getBooksPrice() {
//            return booksPrice;
//        }
//
//        public static String getBooksName() {
//            return booksName;
//        }
//
//        public static String getBooksIntroduction() {
//            return booksIntroduction;
//        }
//    }
//}
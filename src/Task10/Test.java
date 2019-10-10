//Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы,  set- и get- методы
//и метод  toString(). Создать второй класс, агрегирующий массив типа  Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

package Task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Test {
        public static void main(String[] args) {
            Shop airTicket = new Shop("Белавия");
            airTicket.addAirplaneList(new Airplane("Брест",288,"Boeing 737-800",22.02,"Суббота"));
            airTicket.addAirplaneList(new Airplane("Москва",1023,"Boeing 737-500",19.35,"Понедельник"));
            airTicket.addAirplaneList(new Airplane("Амстердам",2099,"Boeing 737-300",21.15,"Среда"));
            airTicket.addAirplaneList(new Airplane("Берлин",108,"CRJ-200 LR",20.45,"Пятница"));
            airTicket.addAirplaneList(new Airplane("Вильнюс",20112,"Embraer 195",11.25,"Воскресение"));
            airTicket.addAirplaneList(new Airplane("Варшава",1122,"Embraer 175",13.03,"Понедельник"));
            airTicket.addAirplaneList(new Airplane("Москва",2357,"Boeing 737-300",20.38,"Среда"));
            airTicket.addAirplaneList(new Airplane("Берлин",4324,"Embraer 195",18.12,"Четверг"));
            airTicket.addAirplaneList(new Airplane("Румыния",121,"CRJ-200 LR",22.22,"Понедельник"));
            airTicket.addAirplaneList(new Airplane("Брест",3221,"Embraer 175", 10.55, "Среда"));

            System.out.print("Enter the name of destination(введите пункт прибытия с большой буквы на русском языке): ");                                                                                    //отсортируем по фамилиям
            List<Airplane> listFindAirplane = airTicket.getDestination();


            System.out.print("\nEnter the day of the week(введите день недели с большой буквы на русском языке): ");                                                                                  ////отсортируем по именам
            List<Airplane> listFindDayOfTheWeek = airTicket.getDayOfTheWeek();

            System.out.print("\nEnter the day of the week(введите день недели с большой буквы на русском языке): ");
            List<Airplane> listFindDayOfTheWeek2 = airTicket.getDayOfTheWeek2();
        }
    }


    class Shop {
        private String AirplaneName;
        private ArrayList<Airplane> airplaneList = new ArrayList<>();

        Shop(String AirplaneName) {
            this.AirplaneName = AirplaneName;
        }

        void addAirplaneList(Airplane airplane) {

            airplaneList.add(airplane);
        }


        List<Airplane> getDestination() {   //список рейсов для заданного пункта назначения
            Scanner scanner = new Scanner(System.in);
            String finder = scanner.next();
            List<Airplane> list = new ArrayList<>(airplaneList);
            for (Airplane c : airplaneList) {
                if (c.getDestination().equals(finder)) {
                    list.add(c);
                    System.out.println("Flight №"+ c.getFlightNumber() + ", time: " + c.getDepartureTime());
                }
            }
            return list;
        }

        List<Airplane> getDayOfTheWeek() { //список рейсов для заданного дня недели
            Scanner scanner = new Scanner(System.in);
            String finder2 = scanner.next();
            List<Airplane> list = new ArrayList<>(airplaneList);
            for (Airplane c : airplaneList) {
                if (c.getDayOfTheWeek().equals(finder2)) {
                    list.add(c);
                    System.out.println("Flight №"+ c.getFlightNumber());
                }
            }
            return list;
        }
          List<Airplane> getDayOfTheWeek2() { //список рейсов для заданного дня недели, время вылета для которых больше заданного
            Scanner scanner = new Scanner(System.in);
            String finder3 = scanner.next();
            System.out.print("Enter the time from which we will search(Введите время(в виде hh,mm) от которого будем искать): "); //вводить через запятую!!!
            double finderInt = scanner.nextDouble();
            List<Airplane> list = new ArrayList<>(airplaneList);
            for (Airplane c : airplaneList) {
                if ((c.getDayOfTheWeek().equals(finder3))&&(c.getDepartureTime()>finderInt)) {
                    list.add(c);
                    System.out.println("Flight №"+ c.getFlightNumber()+" - "+ c.getTypeOfAircraft()+" - "+c.getDestination());

                }
            }
            return list;
        }
    }

    class Airplane {

        private String destination;
        private String dayOfTheWeek;
        private int flightNumber;
        private double departureTime;
        private String typeOfAircraft;

        Airplane(String destination, int flightNumber, String typeOfAircraft, double departureTime, String dayOfTheWeek) {
            this.destination = destination;
            this.flightNumber = flightNumber;
            this.typeOfAircraft = typeOfAircraft;
            this.departureTime = departureTime;
            this.dayOfTheWeek = dayOfTheWeek;
        }

        public String getDestination() {
            return destination;
        }

        public String getTypeOfAircraft() {
            return typeOfAircraft;
        }

        public String getDayOfTheWeek() {
            return dayOfTheWeek;
        }

        public int getFlightNumber() {

            return flightNumber;
        }

        public double getDepartureTime() {
            return departureTime;
        }

        public String toString() {
            return String.format("%d\t destination: %s\t flightNumber: %s\t typeOfAircraft: %s \t departureTime: %s\t dayOfTheWeek: %d\t  n: ",
                    destination, flightNumber, typeOfAircraft, departureTime, dayOfTheWeek);
        }
    }


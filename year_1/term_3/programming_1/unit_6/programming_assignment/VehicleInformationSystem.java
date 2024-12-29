/**
 * Vehicle Information System
 *
 * Instructions to run program:
 * 1. Ensure Java is installed on your system.
 * 2. Save the file as `VehicleInformationSystem.java` and compile it with:
 *    javac VehicleInformationSystem.java
 * 3. Run the program using:
 *    java VehicleInformationSystem
 *
 * Usage:
 * - The main menu will allow users to choose between entering and viewing vehicle information.
 * - Users can input details for three types of vehicles: cars, motorcycles, and trucks.
 * - For each vehicle type, the system prompts for specific attributes.
 * - After entering vehicle information, users can view a list of all previously created vehicles by type.
 * - Ensure that input formats are correct.
 * - The system saves vehicle details and provides feedback when the information is saved successfully.
 *
 **/

import java.util.*;

/**
 * Vehicle Information System allows the user to input and view information 
 * about different types of vehicles: cars, motorcycles, and trucks.
 * The system allows adding vehicle details, storing them, and retrieving previously entered vehicle data.
 */
public class VehicleInformationSystem {
    // main class for running the vehicle information system

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();
        List<Motorcycle> motorcycleList = new ArrayList<>();
        List<Truck> truckList = new ArrayList<>();

        while (true) {
            System.out.println("\n-----------------------------------------\n");
            System.out.println("Welcome to the Vehicle Information System\n");
            System.out.println("1. Provide vehicle information");
            System.out.println("2. View previously created vehicles");
            System.out.println("3. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    // provide vehicle information
                    System.out.println("\nSelect vehicle type:\n");
                    System.out.println("1. Car");
                    System.out.println("2. Motorcycle");
                    System.out.println("3. Truck");
                    System.out.print("\nEnter your choice:");
                    int vehicleType = scanner.nextInt();
                    scanner.nextLine();

                    switch (vehicleType) {
                        case 1 -> {
                            // car
                            Car car = new Car();
                            System.out.print("\nEnter car make: ");
                            car.vehicleMake(scanner.nextLine());
                            System.out.print("Enter car model: ");
                            car.vehicleModel(scanner.nextLine());
                            System.out.print("Enter car year: ");
                            while (true) {
                                try {
                                    car.vehicleYear(scanner.nextInt());
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid year.");
                                    System.out.print("Enter car year: ");
                                    scanner.nextLine();
                                }
                            }
                            System.out.print("Enter number of doors: ");
                            while (true) {
                                try {
                                    car.doorNumber(scanner.nextInt());
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid number of doors.");
                                    System.out.print("Enter number of doors: ");
                                    scanner.nextLine();
                                }
                            }
                            System.out.print("Enter fuel type (petrol, diesel, or electric): ");
                            while (true) {
                                String fuelType = scanner.nextLine().toLowerCase();
                                if (fuelType.equals("petrol") || fuelType.equals("diesel")
                                || fuelType.equals("electric")) {
                                    car.fuelType(fuelType);
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter one of the following: petrol, diesel, or electric.");
                                    System.out.print("Enter fuel type (petrol, diesel, or electric): ");
                                }
                            }
                            System.out.println("\nYour car information is as follows:");
                            System.out.println("Make: " + car.carMake);
                            System.out.println("Model: " + car.carModel);
                            System.out.println("Year: " + car.carYear);
                            System.out.println("Number of doors: " + car.carDoorNumber);
                            System.out.println("Fuel type: " + car.carFuelType);
                            carList.add(car);
                            System.out.println("\nCar information saved successfully!");
                        }
                        case 2 -> {
                            // motorcycle
                            Motorcycle motorcycle = new Motorcycle();
                            System.out.print("\nEnter motorcycle make: ");
                            motorcycle.vehicleMake(scanner.nextLine());
                            System.out.print("Enter motorcycle model: ");
                            motorcycle.vehicleModel(scanner.nextLine());
                            System.out.print("Enter motorcycle year: ");
                            while (true) {
                                try {
                                    motorcycle.vehicleYear(scanner.nextInt());
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid year.");
                                    System.out.print("Enter motorcycle year: ");
                                    scanner.nextLine();
                                }
                            }
                            System.out.print("Enter number of wheels: ");
                            while (true) {
                                try {
                                    motorcycle.numberOfWheels(scanner.nextInt());
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid number of wheels.");
                                    System.out.print("Enter number of wheels: ");
                                    scanner.nextLine();
                                }
                            }
                            System.out.print("Enter motorcycle type (cruiser, sport, or off-road): ");
                            while (true) {
                                String motorcycleType = scanner.nextLine().toLowerCase();
                                if (motorcycleType.equals("cruiser") || motorcycleType.equals("sport")
                                || motorcycleType.equals("off-road")) {
                                    motorcycle.motorcycleType(motorcycleType);
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter one of the following: cruiser, sport, or off-road.");
                                    System.out.print("Enter motorcycle type (cruiser, sport, or off-road): ");
                                }
                            }
                            System.out.println("\nYour motorcycle information is as follows:");
                            System.out.println("Make: " + motorcycle.motorcycleMake);
                            System.out.println("Model: " + motorcycle.motorcycleModel);
                            System.out.println("Year: " + motorcycle.motorcycleYear);
                            System.out.println("Number of wheels: " + motorcycle.motorcycleWheelNumber);
                            System.out.println("Motorcycle type: " + motorcycle.motorcycleType);
                            motorcycleList.add(motorcycle);
                            System.out.println("\nMotorcycle information saved successfully!");
                        }
                        case 3 -> {
                            // truck
                            Truck truck = new Truck();
                            System.out.print("\nEnter truck make: ");
                            truck.vehicleMake(scanner.nextLine());
                            System.out.print("Enter truck model: ");
                            truck.vehicleModel(scanner.nextLine());
                            System.out.print("Enter truck year: ");
                            while (true) {
                                try {
                                    truck.vehicleYear(scanner.nextInt());
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid year.");
                                    System.out.print("Enter truck year: ");
                                    scanner.nextLine();
                                }
                            }
                            System.out.print("Enter cargo capacity (in tons): ");
                            while (true) {
                                try {
                                    truck.cargoCapacity(scanner.nextDouble());
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid cargo capacity in tons.");
                                    System.out.print("Enter cargo capacity (in tons): ");
                                    scanner.nextLine();
                                }
                            }
                            System.out.print("Enter transmission type (manual or automatic): ");
                            while (true) {
                                String transmissionType = scanner.nextLine().toLowerCase();
                                if (transmissionType.equals("manual") || transmissionType.equals("automatic")) {
                                    truck.transmissionType(transmissionType);
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter one of the following: manual, automatic.");
                                    System.out.print("Enter transmission type (manual or automatic): ");
                                }
                            }
                            System.out.println("\nYour truck information is as follows:");
                            System.out.println("Make: " + truck.truckMake);
                            System.out.println("Model: " + truck.truckModel);
                            System.out.println("Year: " + truck.truckYear);
                            System.out.println("Cargo capacity: " + truck.truckCargoSize + " kg");
                            System.out.println("Transmission type: " + truck.truckTransType);
                            truckList.add(truck);
                            System.out.println("\nTruck information saved successfully!");
                        }
                        default -> System.out.println("Invalid vehicle type.\n");
                    }
                }
                case 2 -> {
                    // view previously created vehicles
                    System.out.println("\nSelect vehicle type to view:\n");
                    System.out.println("1. Cars");
                    System.out.println("2. Motorcycles");
                    System.out.println("3. Trucks");
                    System.out.print("\nEnter your choice: ");
                    int viewType = scanner.nextInt();
                    scanner.nextLine();

                    switch (viewType) {
                        case 1 -> {
                            // cars
                            if (carList.isEmpty()) {
                                System.out.println("\nNo cars have been created yet.\n");
                            } else {
                                System.out.println("\nPreviously created cars:\n");
                                for (Car car : carList) {
                                    System.out.println("Make: " + car.carMake);
                                    System.out.println("Model: " + car.carModel);
                                    System.out.println("Year: " + car.carYear);
                                    System.out.println("Number of doors: " + car.carDoorNumber);
                                    System.out.println("Fuel type: " + car.carFuelType);
                                    System.out.println();
                                }
                            }
                        }
                        case 2 -> {
                            // motorcycles
                            if (motorcycleList.isEmpty()) {
                                System.out.println("\nNo motorcycles have been created yet.\n");
                            } else {
                                System.out.println("\nPreviously created motorcycles:\n");
                                for (Motorcycle motorcycle : motorcycleList) {
                                    System.out.println("Make: " + motorcycle.motorcycleMake);
                                    System.out.println("Model: " + motorcycle.motorcycleModel);
                                    System.out.println("Year: " + motorcycle.motorcycleYear);
                                    System.out.println("Number of wheels: " + motorcycle.motorcycleWheelNumber);
                                    System.out.println("Motorcycle type: " + motorcycle.motorcycleType);
                                    System.out.println();
                                }
                            }
                        }
                        case 3 -> {
                            // trucks
                            if (truckList.isEmpty()) {
                                System.out.println("\nNo trucks have been created yet.\n");
                            } else {
                                System.out.println("\nPreviously created trucks:\n");
                                for (Truck truck : truckList) {
                                    System.out.println("Make: " + truck.truckMake);
                                    System.out.println("Model: " + truck.truckModel);
                                    System.out.println("Year: " + truck.truckYear);
                                    System.out.println("Cargo capacity: " + truck.truckCargoSize + " kg");
                                    System.out.println("Transmission type: " + truck.truckTransType);
                                    System.out.println();
                                }
                            }
                        }
                        default -> System.out.println("Invalid vehicle type.\n");
                    }
                }
                case 3 -> {
                    // exit
                    System.out.println("Exiting the Vehicle Information System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}

/**
 * Interface representing a generic vehicle with methods for setting the make, model, and year
 */
interface Vehicle {
    void vehicleMake(String make); // set the vehicle make
    void vehicleModel(String model); // set the vehicle model
    void vehicleYear(int year); // set the vehicle year
}

/**
 * Interface for car-specific details, including number of doors and fuel type
 */
interface CarVehicle {
    void doorNumber(int doorNumber); // set the number of doors
    void fuelType(String fuelType); // set the fuel type
}

/**
 * Class representing a car, implements Vehicle and CarVehicle interfaces
 * Contains attributes related to car details such as make, model, year, doors, and fuel type
 */
class Car implements Vehicle, CarVehicle {
    String carMake; // car make
    String carModel; // car model
    int carYear; // car year
    int carDoorNumber; // number of doors
    String carFuelType; // fuel type

    @Override
    public void vehicleMake(String make) {
        carMake = make; // set car make
    }

    @Override
    public void vehicleModel(String model) {
        carModel = model; // set car model
    }

    @Override
    public void vehicleYear(int year) {
        carYear = year; // set car year
    }

    @Override
    public void doorNumber(int doorNumber) {
        carDoorNumber = doorNumber; // set number of doors
    }

    @Override
    public void fuelType(String fuelType) {
        carFuelType = fuelType; // set fuel type
    }
}

/**
 * Interface for motorcycle-specific details, including number of wheels and type
 */
interface MotorVehicle {
    void numberOfWheels(int wheelNumber); // set the number of wheels
    void motorcycleType(String type); // set the motorcycle type
}

/**
 * Class representing a motorcycle, implements Vehicle and MotorVehicle interfaces
 * Contains attributes related to motorcycle details such as make, model, year, wheels, and type
 */
class Motorcycle implements Vehicle, MotorVehicle {
    String motorcycleMake; // motorcycle make
    String motorcycleModel; // motorcycle model
    int motorcycleYear; // motorcycle year
    int motorcycleWheelNumber; // number of wheels
    String motorcycleType; // motorcycle type

    @Override
    public void vehicleMake(String make) {
        motorcycleMake = make; // set motorcycle make
    }

    @Override
    public void vehicleModel(String model) {
        motorcycleModel = model; // set motorcycle model
    }

    @Override
    public void vehicleYear(int year) {
        motorcycleYear = year; // set motorcycle year
    }

    @Override
    public void numberOfWheels(int wheelNumber) {
        motorcycleWheelNumber = wheelNumber; // set number of wheels
    }

    @Override
    public void motorcycleType(String type) {
        motorcycleType = type; // set motorcycle type
    }
}

/**
 * Interface for truck-specific details, including cargo capacity and transmission type
 */
interface TruckVehicle {
    void cargoCapacity(double cargoSize); // set the cargo capacity
    void transmissionType(String transType); // set the transmission type
}

/**
 * Class representing a truck, implements Vehicle and TruckVehicle interfaces.
 * Contains attributes related to truck details such as make, model, year, cargo capacity, and transmission type.
 */
class Truck implements Vehicle, TruckVehicle {
    String truckMake; // truck make
    String truckModel; // truck model
    int truckYear; // truck year
    double truckCargoSize; // cargo capacity
    String truckTransType; // transmission type

    @Override
    public void vehicleMake(String make) {
        truckMake = make; // set truck make
    }

    @Override
    public void vehicleModel(String model) {
        truckModel = model; // set truck model
    }

    @Override
    public void vehicleYear(int year) {
        truckYear = year; // set truck year
    }

    @Override
    public void cargoCapacity(double cargoSize) {
        truckCargoSize = cargoSize; // set cargo capacity
    }

    @Override
    public void transmissionType(String transType) {
        truckTransType = transType; // set transmission type
    }
}